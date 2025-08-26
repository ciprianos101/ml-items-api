import com.lucasoliveira.itemdetail.adapter.api.exception.ExceptionHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class ExceptionHandlerTest {

    private val exceptionHandler = ExceptionHandler()

    @Test
    fun `handleNotFound should return NOT_FOUND and correct message`() {
        val ex = NoSuchElementException("not found")
        val response = exceptionHandler.handleNotFound(ex)

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertEquals("Item não encontrado", response.body?.message)
    }

    @Test
    fun `handleBadRequest should return BAD_REQUEST and exception message`() {
        val ex = IllegalArgumentException("bad request")
        val response = exceptionHandler.handleBadRequest(ex)

        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals("bad request", response.body?.message)
    }


    @Test
    fun `handleGeneric should return INTERNAL_SERVER_ERROR and correct message`() {
        val ex = Exception("something went wrong")
        val response = exceptionHandler.handleGeneric(ex)

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
        assertEquals("Erro interno inesperado", response.body?.message)
    }
}