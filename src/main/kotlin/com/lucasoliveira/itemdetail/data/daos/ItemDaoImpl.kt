package com.lucasoliveira.itemdetail.data.daos

import com.lucasoliveira.itemdetail.data.repositories.ItemFileRepository
import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import org.springframework.stereotype.Service


@Service
class ItemDaoImpl(
    private val itemFileRepository: ItemFileRepository
) : ItemDao {
    override fun byId(id: String): Item? {
        return itemFileRepository.findById(id)
    }
}