package com.supermarket.model

case class PricingRule(price: Price, specialPriceMaybe: Option[SpecialPrice])
