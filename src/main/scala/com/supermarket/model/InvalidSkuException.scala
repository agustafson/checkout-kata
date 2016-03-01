package com.supermarket.model

case class InvalidSkuException(ch: Char) extends Exception(s"Invalid character '$ch' used to create SKU")
