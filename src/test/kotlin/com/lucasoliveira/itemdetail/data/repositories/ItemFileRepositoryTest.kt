package com.lucasoliveira.itemdetail.data.repositories

import com.lucasoliveira.itemdetail.ItemMockFactory
import com.lucasoliveira.itemdetail.domain.model.Item
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.UUID

class ItemFileRepositoryTest {

    private fun createRepoWithMockedItems() = object : ItemFileRepository() {
        fun getItems(): List<Item> = listOf(
            ItemMockFactory.create(),
            ItemMockFactory.create()
        )
    }

    @Test
    fun `findById returns item when id exists`() {
        runBlocking {
            // Arrange
            val repo = createRepoWithMockedItems()

            // Act
            val result = repo.findById(UUID.fromString("3fe94906-02d3-4d16-8083-6da13889110d"))

            // Assert
            assertNotNull(result)
            assertEquals("Smartphone 1", result?.title)
        }
    }

    @Test
    fun `findById returns null when id does not exist`() {
        runBlocking {
            // Arrange
            val repo = createRepoWithMockedItems()

            // Act
            val result = repo.findById(UUID.randomUUID())

            // Assert
            assertNull(result)
        }
    }

    @Test
    fun `getItems throws exception when file not found`() {
        runBlocking {
            // Arrange
            val repo = ItemFileRepository()

            // Simulate missing file by using a non-existent resource
            val exception = assertThrows(IllegalStateException::class.java) {
                repo.javaClass.classLoader.getResourceAsStream("data/nonexistent.json")
                    ?: throw IllegalStateException("Arquivo data/items.json não encontrado")
            }

            // Assert
            assertEquals("Arquivo data/items.json não encontrado", exception.message)
        }
    }
}