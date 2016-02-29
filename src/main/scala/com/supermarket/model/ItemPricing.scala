package com.supermarket.model

import scala.collection.immutable.HashMap

case class ItemPricing(val pricesPerProduct: Map[SKU, ItemPrice]) {
  def this(itemPrices: (SKU, ItemPrice)*) = this(itemPrices.toMap)
}
