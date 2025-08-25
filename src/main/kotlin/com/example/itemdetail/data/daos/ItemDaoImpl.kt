package com.example.itemdetail.data.daos

import com.example.itemdetail.data.repositories.ItemFileRepository
import com.example.itemdetail.domain.model.Item
import com.example.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import org.springframework.stereotype.Service


@Service
class ItemDaoImpl(
    private val itemFileRepository: ItemFileRepository
) : ItemDao {
    override fun byId(id: String): Item? {
        return itemFileRepository.findById(id)
    }
}