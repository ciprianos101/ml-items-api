package com.example.itemdetail.application.service

import com.example.itemdetail.domain.model.Item
import com.example.itemdetail.adapter.persistence.ItemFileRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val productRepository: ItemFileRepository
) {
    @Cacheable("jsonFileCache")
    fun getProductById(id: String): Item =
        productRepository.findById(id) ?: throw NoSuchElementException("Item not found")
}