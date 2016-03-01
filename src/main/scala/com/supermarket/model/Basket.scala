package com.supermarket.model

import scala.collection.immutable.HashMap

case class Basket(val items: Map[Sku, Quantity] = new HashMap[Sku, Quantity]) {
  def addItem(sku: Sku): Basket = {
    new Basket(items.updated(sku, items.getOrElse(sku, 0) + 1))
  }
}
