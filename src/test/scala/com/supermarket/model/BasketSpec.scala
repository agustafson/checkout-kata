package com.supermarket.model

import org.specs2.mutable.Specification

class BasketSpec extends Specification {

  "Basket" should {
    "add a single item" in {
      Basket().addItem('A').items ==== Map('A' -> 1)
    }
    "add a single item for each SKU" in {
      Basket().addItem('A').addItem('B').items ==== Map('A' -> 1, 'B' -> 1)
    }
    "add multiple items" in {
      val basket = Basket().addItem('A').addItem('B').addItem('A').addItem('A').addItem('C').addItem('B')
      basket.items ==== Map('A' -> 3, 'B' -> 2, 'C' -> 1)
    }
  }
}
