package com.example.itemdetail.adapter.api.controller

import com.example.itemdetail.application.service.ItemService
import com.example.itemdetail.domain.model.Item
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/items")
class ItemController(
    private val itemService: ItemService
) {
    @GetMapping("/{id}")
    fun getItem(@PathVariable id: String): ResponseEntity<Item> =
        try {
            ResponseEntity.ok(itemService.getProductById(id))
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
}