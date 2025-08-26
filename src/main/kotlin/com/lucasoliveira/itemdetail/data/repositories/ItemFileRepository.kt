package com.lucasoliveira.itemdetail.data.repositories

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemRepository
import org.springframework.stereotype.Repository
import java.io.File
import java.util.UUID

@Repository
class ItemFileRepository : ItemRepository {
    private val filePath = "src/main/resources/data/items.json"
    @Volatile private var lastModified: Long = 0
    @Volatile private var itemsById: Map<UUID, Item> = emptyMap()

    private fun loadItemsIfNeeded() {
        val file = File(filePath)
        val currentModified = file.lastModified()
        if (currentModified != lastModified) {
            val items: List<Item> = jacksonObjectMapper().readValue(file)
            itemsById = items.associateBy { it.id }
            lastModified = currentModified
        }
    }

    override suspend fun findById(id: UUID): Item? {
        loadItemsIfNeeded()
        return itemsById[id]
    }
}