package com.lucasoliveira.itemdetail.data.repositories

import com.lucasoliveira.itemdetail.domain.model.Item
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ItemFileRepository : ItemRepository{
    private fun getItems(): List<Item> {
        val inputStream = javaClass.classLoader.getResourceAsStream("data/items.json")
            ?: throw IllegalStateException("Arquivo data/items.json não encontrado")
        return jacksonObjectMapper().readValue(inputStream)
    }
    override suspend fun findById(id: UUID): Item? = getItems().find { it.id == id }
}