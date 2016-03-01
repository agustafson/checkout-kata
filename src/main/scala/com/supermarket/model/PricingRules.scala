package com.supermarket.model

case class PricingRules(private val pricesPerProduct: Map[SKU, PricingRule]) {
  def this(itemPrices: (SKU, PricingRule)*) = this(itemPrices.toMap)

  def productPricingRule(sku: SKU) = {
    pricesPerProduct(sku)
  }
}
