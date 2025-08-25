package com.lucasoliveira.itemdetail.adapter.api.controller
import com.lucasoliveira.itemdetail.adapter.api.dto.ItemResponseDTO
import com.lucasoliveira.itemdetail.adapter.api.dto.toResponseDTO
import com.lucasoliveira.itemdetail.domain.model.Item
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("items")
class ItemController(
    private val itemDetailsById: ItemDetailsById
) {
    @GetMapping("/{id}")
    suspend fun getItem(@PathVariable id: String): ResponseEntity<ItemResponseDTO?>? =
        try {
            val item = itemDetailsById.run(id)
            ResponseEntity.ok(item.toResponseDTO())
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
}