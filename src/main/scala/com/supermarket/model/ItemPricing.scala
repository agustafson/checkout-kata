package com.supermarket.model

case class ItemPricing(val pricesPerProduct: Map[SKU, ItemPrice]) {
  def this(itemPrices: (SKU, ItemPrice)*) = this(itemPrices.toMap)
}
