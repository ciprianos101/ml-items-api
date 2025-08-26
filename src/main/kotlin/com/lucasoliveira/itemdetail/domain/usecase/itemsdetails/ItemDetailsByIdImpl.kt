package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails

import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ItemDetailsByIdImpl(
    private val itemDao: ItemDao
) : ItemDetailsById{
        @Cacheable("jsonFileCache")
        override suspend fun run(id: UUID): Item =
            itemDao.byId(id) ?: throw NoSuchElementException("Item not found")
}