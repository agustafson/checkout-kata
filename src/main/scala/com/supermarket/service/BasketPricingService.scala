package com.supermarket.service

import com.supermarket.model.{ItemPricing, Price, Basket}

class BasketPricingService {
  def calculateTotalPrice(itemPricing: ItemPricing, basket: Basket): Price = {
    val pricesPerSku = for {
      (sku, quantity) <- basket.items
      // TODO: throw exception on found val
      itemPrice = itemPricing.pricesPerProduct(sku)
    } yield {
      quantity * itemPrice.price
    }
    pricesPerSku.sum
  }
}
