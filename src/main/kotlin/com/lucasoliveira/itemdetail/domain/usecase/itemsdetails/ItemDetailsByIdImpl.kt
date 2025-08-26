package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails

import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemRepository
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ItemDetailsByIdImpl(
    private val itemRepository : ItemRepository
) : ItemDetailsById{
        override suspend fun run(id: UUID): Item =
            itemRepository.findById(id) ?: throw NoSuchElementException("Item not found")
}