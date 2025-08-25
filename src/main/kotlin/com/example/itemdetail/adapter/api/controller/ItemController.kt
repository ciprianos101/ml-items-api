package com.example.itemdetail.adapter.api.controller
import com.example.itemdetail.domain.model.Item
import com.example.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
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
    fun getItem(@PathVariable id: String): ResponseEntity<Item> =
        try {
            ResponseEntity.ok(itemDetailsById.run(id))
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
}