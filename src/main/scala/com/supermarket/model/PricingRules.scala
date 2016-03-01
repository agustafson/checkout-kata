package com.supermarket.model

case class PricingRules(private val pricesPerProduct: Map[Sku, PricingRule]) {
  def this(itemPrices: (Sku, PricingRule)*) = this(itemPrices.toMap)

  def productPricingRule(sku: Sku): Option[PricingRule] = {
    pricesPerProduct.get(sku)
  }
}
