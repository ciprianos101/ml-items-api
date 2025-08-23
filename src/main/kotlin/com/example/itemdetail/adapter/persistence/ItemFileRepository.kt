package com.example.itemdetail.adapter.persistence

import com.example.itemdetail.domain.model.Item
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class ItemFileRepository {
    fun getItems(): List<Item> {
        val file = File(javaClass.classLoader.getResource("data/items.json")!!.file)
        return jacksonObjectMapper().readValue(file)
    }

    fun findById(id: String): Item? = getItems().find { it.id == id }
}