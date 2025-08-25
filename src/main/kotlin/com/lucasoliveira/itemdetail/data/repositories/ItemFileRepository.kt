package com.lucasoliveira.itemdetail.data.repositories

import com.lucasoliveira.itemdetail.domain.model.Item
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Repository

@Repository
class ItemFileRepository {
    private fun getItems(): List<Item> {
        val inputStream = javaClass.classLoader.getResourceAsStream("data/items.json")
            ?: throw IllegalStateException("Arquivo data/items.json não encontrado")
        return jacksonObjectMapper().readValue(inputStream)
    }

    fun findById(id: String): Item? = getItems().find { it.id == id }
}