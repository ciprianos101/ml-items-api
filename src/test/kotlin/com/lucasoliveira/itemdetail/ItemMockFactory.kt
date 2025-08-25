package com.lucasoliveira.itemdetail

import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.model.Price
import com.lucasoliveira.itemdetail.domain.model.enums.Condition
import com.lucasoliveira.itemdetail.domain.model.enums.DeliveryMethod
import com.lucasoliveira.itemdetail.domain.model.enums.ListingType
import com.lucasoliveira.itemdetail.domain.model.enums.Warranty

object ItemMockFactory {
    private var idCounter = 1

    fun create(
        id: String = idCounter.toString(),
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
    ): Item {
        val item = Item(
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
        idCounter++
        return item
    }
}