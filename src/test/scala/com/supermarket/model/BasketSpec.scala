package com.supermarket.model

import org.specs2.mutable.Specification

class BasketSpec extends Specification {

  "Basket" should {
    "add a single item" in {
      Basket().addItem(Sku('A')).items ==== Map(Sku('A') -> 1)
    }
    "add a single item for each SKU" in {
      Basket().addItem(Sku('A')).addItem(Sku('B')).items ==== Map(Sku('A') -> 1, Sku('B') -> 1)
    }
    "add multiple items" in {
      val basket = Basket().addItem(Sku('A')).addItem(Sku('B')).addItem(Sku('A')).addItem(Sku('A')).addItem(Sku('C')).addItem(Sku('B'))
      basket.items ==== Map(Sku('A') -> 3, Sku('B') -> 2, Sku('C') -> 1)
    }
  }
}
