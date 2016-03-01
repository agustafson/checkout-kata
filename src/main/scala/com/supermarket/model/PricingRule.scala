package com.supermarket.model

case class PricingRule(normalPrice: Price, specialPriceMaybe: Option[SpecialPrice]) {
  def totalPrice(quantity: Quantity): Price = {
    specialPriceMaybe.map {
      case (specialQuantity, specialPrice) =>
        quantity / specialQuantity * specialPrice +
          quantity % specialQuantity * normalPrice
    }.getOrElse {
      quantity * normalPrice
    }
  }
}
