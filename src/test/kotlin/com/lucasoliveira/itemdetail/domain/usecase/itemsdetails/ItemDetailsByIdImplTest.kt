package com.lucasoliveira.itemdetail.domain.usecase.itemsdetails

import com.lucasoliveira.itemdetail.ItemMockFactory
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import java.util.UUID

class ItemDetailsByIdImplTest {

    private val itemRepository: ItemRepository = mock(ItemRepository::class.java)
    private val itemDetailsById = ItemDetailsByIdImpl(itemRepository)

    @Test
    fun `should return item when found`() {
        runBlocking {

            val item = ItemMockFactory.create()
            val itemId = item.id
            `when`(itemRepository.findById(itemId)).thenReturn(item)

            val result = itemDetailsById.run(itemId)

            assertEquals(item, result)
            verify(itemRepository).findById(itemId)
        }
    }

    @Test
    fun `should throw NoSuchElementException when item not found`() {
        runBlocking {
            val itemId = UUID.randomUUID()
            `when`(itemRepository.findById(itemId)).thenReturn(null)

            val exception = assertThrows<NoSuchElementException> {
                itemDetailsById.run(itemId)
            }

            assertEquals("Item not found", exception.message)
            verify(itemRepository).findById(itemId)
        }
    }
}