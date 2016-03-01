package com.supermarket.service

import com.supermarket
import com.supermarket.model._
import org.specs2.matcher.MatchResult
import org.specs2.mutable.Specification

class BasketPricingServiceSpec extends Specification {
  val pricingRules = new PricingRules(
    'A' -> PricingRule(50, Some(3, 130)),
    'B' -> PricingRule(30, Some(2, 45)),
    'C' -> PricingRule(20, None),
    'D' -> PricingRule(15, None)
  )
  val basketPricingService = new BasketPricingService

  def checkPrice(basket: Basket, expectedPrice: Quantity): MatchResult[supermarket.model.Price] = {
    basketPricingService.calculateTotalPrice(pricingRules, basket) ==== expectedPrice
  }

  "BasketPricingService" should {
    "calculateTotalPrice" >> {
      "for single items" in {
        checkPrice(Basket().addItem('A'), 50)
        checkPrice(Basket().addItem('B'), 30)
        checkPrice(Basket().addItem('C'), 20)
        checkPrice(Basket().addItem('D'), 15)
      }

      "for a single type of item with a multiple price discount" in {
        checkPrice(Basket().addItem('B').addItem('B'), 45)
        checkPrice(Basket().addItem('A').addItem('A').addItem('A').addItem('A').addItem('A'), 230)
      }
    }
  }
}
