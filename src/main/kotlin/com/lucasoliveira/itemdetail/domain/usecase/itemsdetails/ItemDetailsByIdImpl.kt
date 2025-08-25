package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails

import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ItemDetailsByIdImpl(
    private val itemDao: ItemDao
) : ItemDetailsById{
        @Cacheable("jsonFileCache")
        override fun run(id: String): Item =
            itemDao.byId(id) ?: throw NoSuchElementException("Item not found")
}