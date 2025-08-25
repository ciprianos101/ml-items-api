package com.lucasoliveira.itemdetail

import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.model.Price
import com.lucasoliveira.itemdetail.domain.model.enums.Condition
import com.lucasoliveira.itemdetail.domain.model.enums.DeliveryMethod
import com.lucasoliveira.itemdetail.domain.model.enums.ListingType
import com.lucasoliveira.itemdetail.domain.model.enums.Warranty
import java.util.UUID

object ItemMockFactory {
    private var newId = UUID.randomUUID()

    fun create(
        id: UUID = UUID.fromString("3fe94906-02d3-4d16-8083-6da13889110d"),
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
        newId = UUID.randomUUID()
        return item
    }
}