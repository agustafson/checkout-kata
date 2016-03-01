Domain
======
* `Sku` is a product SKU, wrapping an uppercase alpha char
* `Basket` represents the total count of each product SKU in the basket
* `PricingRule` represents a pricing rule and includes a regular and optional special price, with the ability to
 calculate total price for a given quantity
* `PricingRules` represents a pricing rule per product SKU

Service
=======
`BasketPricingService` calculates the total price for a basket given a set of pricing rules

Assumptions made
================
Libraries for handling error cases such as cats or scalaz have not been included. Therefore: 
* Unparseable SKUs will throw a `InvalidSkuException`
* The first unknown SKU in a basket will result in an `UnknownProductException` being thrown
