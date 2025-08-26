package com.lucasoliveira.itemdetail.data.daos

import com.lucasoliveira.itemdetail.data.repositories.ItemFileRepository
import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class ItemDaoImpl(
    private val itemFileRepository: ItemFileRepository
) : ItemDao {
    override fun byId(id: UUID): Item? {
        return itemFileRepository.findById(id)
    }
}