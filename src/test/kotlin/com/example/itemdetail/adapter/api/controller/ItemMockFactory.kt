package com.example.itemdetail.adapter.api.controller

import com.example.itemdetail.domain.model.Item
import com.example.itemdetail.domain.model.Price
import com.example.itemdetail.domain.model.enums.*

object ItemMockFactory {
    fun create(
        id: String = "1",
        title: String = "Mocked Item",
        condition: Condition = Condition.NEW,
        universalCode: String = "1234567890123",
        pictures: List<String> = listOf("https://example.com/img1.jpg"),
        stock: Int = 10,
        sku: String? = "SKU-001",
        description: String? = "Mocked item description",
        price: Price = Price(99.99, "BRL"),
        listingType: ListingType = ListingType.CLASSIC,
        deliveryMethod: DeliveryMethod = DeliveryMethod.FREE_SHIPPING,
        pickupAvailable: Boolean = true,
        warranty: Warranty = Warranty.FACTORY
    ): Item = Item(
        id = id,
        title = title,
        condition = condition,
        universalCode = universalCode,
        pictures = pictures,
        stock = stock,
        sku = sku,
        description = description,
        price = price,
        listingType = listingType,
        deliveryMethod = deliveryMethod,
        pickupAvailable = pickupAvailable,
        warranty = warranty
    )
}