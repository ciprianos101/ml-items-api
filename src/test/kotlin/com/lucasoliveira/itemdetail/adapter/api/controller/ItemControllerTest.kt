import com.lucasoliveira.itemdetail.ItemMockFactory
import com.lucasoliveira.itemdetail.adapter.api.controller.ItemController
import com.lucasoliveira.itemdetail.adapter.api.dto.toResponseDTO
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus

class ItemControllerTest {

    private val itemDetailsById = mock(ItemDetailsById::class.java)
    private val controller = ItemController(itemDetailsById)

    @Test
    fun `should return item when found`() = runBlocking {
        val item = ItemMockFactory.create()
        `when`(itemDetailsById.run("3fe94906-02d3-4d16-8083-6da13889110d")).thenReturn(item)

        val response = controller.getItem("3fe94906-02d3-4d16-8083-6da13889110d")

        assertEquals(HttpStatus.OK, response?.statusCode)
        assertEquals(item.toResponseDTO(), response?.body)
    }

    @Test
    fun `should return 404 when item not found`() = runBlocking {
        `when`(itemDetailsById.run("2")).thenThrow(NoSuchElementException())

        val response = controller.getItem("2")

        assertEquals(HttpStatus.NOT_FOUND, response?.statusCode)
        assertNull(response?.body)
    }
}