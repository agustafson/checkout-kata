package com.supermarket.model

import scala.collection.immutable.HashMap

case class Basket(val items: Map[SKU, Quantity] = new HashMap[SKU, Quantity]) {
  // TODO: validate SKU as Alpha Char
  def addItem(sku: SKU): Basket = {
    new Basket(items.updated(sku, items.getOrElse(sku, 0) + 1))
  }
}
