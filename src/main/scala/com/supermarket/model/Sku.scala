package com.supermarket.model

case class Sku(val underlying: Char) {
  if (!(underlying.isLetter && underlying.isUpper)) {
    throw new IllegalArgumentException(s"Cannot parse $underlying as SKU")
  }
}
