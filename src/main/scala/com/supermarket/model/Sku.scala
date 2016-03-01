package com.supermarket.model

case class Sku(val underlying: Char) {
  if (!(underlying.isLetter && underlying.isUpper)) {
    throw new InvalidSkuException(underlying)
  }
}
