package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port

import com.lucasoliveira.itemdetail.domain.model.Item

interface ItemDetailsById {
    fun run(id: String): Item
}