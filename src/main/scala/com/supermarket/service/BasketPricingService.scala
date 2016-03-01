package com.supermarket.service

import com.supermarket.model._

class BasketPricingService {
  def calculateTotalPrice(pricingRules: PricingRules, basket: Basket): Price = {
    val pricesPerSku = for {
      (sku, quantity) <- basket.items
      // TODO: throw exception on found val
      itemPrice = pricingRules.productPricingRule(sku)
    } yield {
      itemPrice.totalPrice(quantity)
    }
    pricesPerSku.sum
  }
}
