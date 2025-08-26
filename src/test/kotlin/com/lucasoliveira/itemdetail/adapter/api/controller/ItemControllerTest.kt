import com.lucasoliveira.itemdetail.ItemMockFactory
import com.lucasoliveira.itemdetail.adapter.api.controller.ItemController
import com.lucasoliveira.itemdetail.adapter.api.dto.toResponseDTO
import com.lucasoliveira.itemdetail.domain.usecase.itemsdetails.port.ItemDetailsById
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus
import java.util.UUID

class ItemControllerTest {

    private val itemDetailsById = mock(ItemDetailsById::class.java)
    private val controller = ItemController(itemDetailsById)

    @Test
    fun `should return item when found`() {
        runBlocking {
            val item = ItemMockFactory.create()
            `when`(itemDetailsById.run(UUID.fromString("3fe94906-02d3-4d16-8083-6da13889110d"))).thenReturn(item)

            val response = controller.getItem(UUID.fromString("3fe94906-02d3-4d16-8083-6da13889110d"))

            assertEquals(HttpStatus.OK, response?.statusCode)
            assertEquals(item.toResponseDTO(), response?.body)
            verify(itemDetailsById).run(UUID.fromString("3fe94906-02d3-4d16-8083-6da13889110d"))
        }
    }
}