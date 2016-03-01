package com.supermarket.service

import com.supermarket
import com.supermarket.model._
import org.specs2.matcher.MatchResult
import org.specs2.mutable.Specification

class BasketPricingServiceSpec extends Specification {
  val pricingRules = new PricingRules(
    Sku('A') -> PricingRule(50, Some(3, 130)),
    Sku('B') -> PricingRule(30, Some(2, 45)),
    Sku('C') -> PricingRule(20, None),
    Sku('D') -> PricingRule(15, None)
  )
  val basketPricingService = new BasketPricingService

  def checkPrice(basket: Basket, expectedPrice: Quantity): MatchResult[supermarket.model.Price] = {
    basketPricingService.calculateTotalPrice(pricingRules, basket) ==== expectedPrice
  }

  "BasketPricingService" should {
    "calculateTotalPrice" >> {
      "for single items" in {
        checkPrice(Basket().addItem(Sku('A')), 50)
        checkPrice(Basket().addItem(Sku('B')), 30)
        checkPrice(Basket().addItem(Sku('C')), 20)
        checkPrice(Basket().addItem(Sku('D')), 15)
      }

      "for a single type of item with a multiple price discount" in {
        checkPrice(Basket().addItem(Sku('B')).addItem(Sku('B')), 45)
        checkPrice(Basket().addItem(Sku('A')).addItem(Sku('A')).addItem(Sku('A')).addItem(Sku('A')).addItem(Sku('A')), 230)
      }

      "for multiple items in a basket with some discounts" in {
        checkPrice(Basket().addItem(Sku('B')).addItem(Sku('A')).addItem(Sku('B')), 95)
      }

      "ensure unknown SKUs are invalid" in {
        val unknownSku = Sku('Z')
        basketPricingService.calculateTotalPrice(pricingRules, Basket().addItem(unknownSku)) must throwA(new UnknownProductException(unknownSku))
      }
    }
  }
}
