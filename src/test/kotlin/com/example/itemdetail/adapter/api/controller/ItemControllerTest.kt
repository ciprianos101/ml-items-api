package com.example.itemdetail.adapter.api.controller

import com.example.itemdetail.ItemMockFactory
import com.example.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus

class ItemControllerTest {

    private val itemDetailsById = mock(ItemDetailsById::class.java)
    private val controller = ItemController(itemDetailsById)

    @Test
    fun `should return item when found`() {
        val item = ItemMockFactory.create()
        `when`(itemDetailsById.run("1")).thenReturn(item)

        val response = controller.getItem("1")

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(item, response.body)
    }

    @Test
    fun `should return 404 when item not found`() {
        `when`(itemDetailsById.run("2")).thenThrow(NoSuchElementException())

        val response = controller.getItem("2")

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }
}