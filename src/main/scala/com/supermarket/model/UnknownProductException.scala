package com.supermarket.model

case class UnknownProductException(sku: Sku) extends Exception(s"Unknown product $sku")
