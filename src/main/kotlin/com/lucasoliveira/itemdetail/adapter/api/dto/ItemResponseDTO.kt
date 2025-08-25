package com.lucasoliveira.itemdetail.adapter.api.dto

import com.lucasoliveira.itemdetail.domain.model.Price
import com.lucasoliveira.itemdetail.domain.model.enums.Condition
import com.lucasoliveira.itemdetail.domain.model.enums.DeliveryMethod
import com.lucasoliveira.itemdetail.domain.model.enums.ListingType
import com.lucasoliveira.itemdetail.domain.model.enums.Warranty
import java.math.BigDecimal
import java.util.UUID

data class ItemResponseDTO(
    val id: UUID,
    val title: String,
    val condition: Condition,
    val universalCode: String,
    val photos: List<String>?,
    val stock: Int,
    val sku: String?,
    val description: String?,
    val price: Price,
    val listingType: ListingType,
    val deliveryType: DeliveryMethod,
    val pickupAvailable: Boolean?,
    val warranty: Warranty
)
