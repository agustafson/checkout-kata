package com.supermarket.service

import com.supermarket.model.{ItemPricing, Price, Basket}

class BasketPricingService {
  def calculateTotalPrice(itemPricing: ItemPricing, basket: Basket): Price = {
    val pricesPerSku = for {
      (sku, quantity) <- basket.items
      // TODO: throw exception on found val
      itemPrice = itemPricing.pricesPerProduct(sku)
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
