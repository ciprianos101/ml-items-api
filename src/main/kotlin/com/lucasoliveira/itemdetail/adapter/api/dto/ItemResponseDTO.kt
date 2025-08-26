package com.lucasoliveira.itemdetail.adapter.api.dto

import com.lucasoliveira.itemdetail.domain.model.Price
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.util.UUID

data class ItemResponseDTO(
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    @field:Size(max = 120)
    val title: String,

    @field:NotBlank
    val condition: String,

    @field:NotBlank
    val universalCode: String,

    val photos: List<String>?,

    val stock: Int,

    val sku: String?,

    val description: String?,

    val price: Price,

    val listingType: String,

    val deliveryType: String,

    val pickupAvailable: Boolean?,

    val warranty: String
)
