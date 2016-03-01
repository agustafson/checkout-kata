package com.supermarket.service

import com.supermarket.model.{PricingRules, Price, Basket}

class BasketPricingService {
  def calculateTotalPrice(pricingRules: PricingRules, basket: Basket): Price = {
    val pricesPerSku = for {
      (sku, quantity) <- basket.items
      // TODO: throw exception on found val
      itemPrice = pricingRules.productPricingRule(sku)
    } yield {
      val regularPrice = itemPrice.price
      itemPrice.specialPriceMaybe.map {
        case (specialQuantity, specialPrice) =>
          quantity / specialQuantity * specialPrice +
            quantity % specialQuantity * regularPrice
      }.getOrElse {
        quantity * regularPrice
      }
    }
    pricesPerSku.sum
  }
}
