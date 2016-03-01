package com.supermarket.model

case class PricingRules(val pricesPerProduct: Map[SKU, ItemPrice]) {
  def this(itemPrices: (SKU, ItemPrice)*) = this(itemPrices.toMap)
}
