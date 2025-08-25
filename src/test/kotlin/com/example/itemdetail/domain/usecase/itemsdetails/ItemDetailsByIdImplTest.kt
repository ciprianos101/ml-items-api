package com.example.itemdetail.domain.usecase.itemsdetails

import com.example.itemdetail.ItemMockFactory
import com.example.itemdetail.domain.usecase.itemsdetails.port.ItemDao
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*

class ItemDetailsByIdImplTest {

    private val itemDao: ItemDao = mock(ItemDao::class.java)
    private val itemDetailsById = ItemDetailsByIdImpl(itemDao)

    @Test
    fun `should return item when found`() {
        val itemId = "123"
        val item = ItemMockFactory.create()
        `when`(itemDao.byId(itemId)).thenReturn(item)

        val result = itemDetailsById.run(itemId)

        assertEquals(item, result)
        verify(itemDao).byId(itemId)
    }

    @Test
    fun `should throw NoSuchElementException when item not found`() {
        val itemId = "not_found"
        `when`(itemDao.byId(itemId)).thenReturn(null)

        val exception = assertThrows<NoSuchElementException> {
            itemDetailsById.run(itemId)
        }

        assertEquals("Item not found", exception.message)
        verify(itemDao).byId(itemId)
    }
}