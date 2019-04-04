package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
    // Return the set of customers who ordered the specified product
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.sumBy { it.orders.sumBy { it.products.count { it == product }}}}
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
