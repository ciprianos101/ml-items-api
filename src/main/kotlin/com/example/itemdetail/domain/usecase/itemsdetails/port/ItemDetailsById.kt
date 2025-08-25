package com.example.itemdetail.domain.usecase.itemsdetails.port

import com.example.itemdetail.domain.model.Item

interface ItemDetailsById {
    fun run(id: String): Item
}