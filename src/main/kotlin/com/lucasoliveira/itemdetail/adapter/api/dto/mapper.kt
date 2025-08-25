package com.lucasoliveira.itemdetail.adapter.api.dto

import com.lucasoliveira.itemdetail.domain.model.Item

fun Item.toResponseDTO() = ItemResponseDTO(
    id = this.id,
    title = this.title,
    condition = this.condition,
    universalCode = this.universalCode,
    photos = this.pictures,
    stock = this.stock,
    sku = this.sku,
    description = this.description,
    price = this.price,
    listingType = this.listingType,
    deliveryType = this.deliveryMethod,
    pickupAvailable = this.pickupAvailable,
    warranty = this.warranty
)