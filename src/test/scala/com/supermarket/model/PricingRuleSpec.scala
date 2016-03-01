package com.supermarket.model

import org.specs2.mutable.Specification
import org.scalacheck._
import org.specs2.ScalaCheck

class PricingRuleSpec extends Specification with ScalaCheck {
  "PricingRule" should {
    "calculate total price for pricing rule without special" in {
      prop { (price: Price, quantity: Quantity) =>
        val pricingRule = PricingRule(price, None)
        pricingRule.totalPrice(quantity) ==== price * quantity
      }.setGens(Gen.posNum[Price], Gen.posNum[Quantity])
    }

    "calculate total price for an item with special pricing" in {
      val pricingRule = PricingRule(50, Some(3, 130))
      pricingRule.totalPrice(1) ==== 50
      pricingRule.totalPrice(2) ==== 100
      pricingRule.totalPrice(3) ==== 130
      pricingRule.totalPrice(4) ==== 180
      pricingRule.totalPrice(5) ==== 230
      pricingRule.totalPrice(6) ==== 260
    }
  }
}
