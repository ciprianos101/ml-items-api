package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port

import com.lucasoliveira.itemdetail.domain.model.Item

interface ItemDao {
    fun byId(id: String): Item?
}