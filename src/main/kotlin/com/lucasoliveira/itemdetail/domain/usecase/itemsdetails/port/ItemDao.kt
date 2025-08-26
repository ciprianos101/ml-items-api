package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port

import com.lucasoliveira.itemdetail.domain.model.Item
import java.util.UUID

interface ItemDao {
    fun byId(id: UUID): Item?
}