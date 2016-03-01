package com.supermarket.service

import com.supermarket.model._

class BasketPricingService {
  def calculateTotalPrice(pricingRules: PricingRules, basket: Basket): Price = {
    val pricesPerSku = basket.items.map {
      case (sku, quantity) =>
        pricingRules.productPricingRule(sku)
          .map(_.totalPrice(quantity))
          .getOrElse(throw new UnknownProductException(sku))
    }
    pricesPerSku.sum
  }
}
