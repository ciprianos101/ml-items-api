package com.example.itemdetail.domain.usecase.itemsdetails.port

import com.example.itemdetail.domain.model.Item

interface ItemDao {
    fun byId(id: String): Item?
}