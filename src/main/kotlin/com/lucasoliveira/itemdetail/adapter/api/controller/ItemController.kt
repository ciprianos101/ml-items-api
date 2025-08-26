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
import java.util.UUID

@RestController
@RequestMapping("items")
class ItemController(
    private val itemDetailsById: ItemDetailsById
) {
    @GetMapping("/{id}")
    suspend fun getItem(@PathVariable id: UUID): ResponseEntity<ItemResponseDTO?>?  {
        val item = itemDetailsById.run(id)
        return ResponseEntity.ok(item.toResponseDTO())
    }
}