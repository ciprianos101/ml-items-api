package com.example.itemdetail.domain.model

import com.example.itemdetail.domain.model.enums.Condition
import com.example.itemdetail.domain.model.enums.DeliveryMethod
import com.example.itemdetail.domain.model.enums.ListingType
import com.example.itemdetail.domain.model.enums.Warranty

data class Item(
        val id: String,
        val title: String,
        val condition: Condition,
        val universalCode: String,
        val pictures: List<String> = emptyList(),
        val stock: Int,
        val sku: String? = null,
        val description: String? = null,
        val price: Price,
        val listingType: ListingType,
        val deliveryMethod: DeliveryMethod,
        val pickupAvailable: Boolean = false,
        val warranty: Warranty
)

