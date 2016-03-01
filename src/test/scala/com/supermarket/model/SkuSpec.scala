package com.supermarket.model

import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class SkuSpec extends Specification with ScalaCheck {
  "Sku" should {
    "ensure that sku char is alhpanumeric uppercase" in {
      prop { (ch: Char) =>
        if (ch.isLetter && ch.isUpper)
          Sku(ch).underlying ==== ch
        else
          Sku(ch) must throwA(new IllegalArgumentException(s"Cannot parse $ch as SKU"))
      }
    }
  }
}
