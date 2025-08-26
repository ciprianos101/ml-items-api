package com.lucasoliveira.itemdetail.cucumber

import io.cucumber.java.pt.*
import io.cucumber.spring.CucumberContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity
import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.context.SpringBootTest

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CucumberSpringConfiguration

class ItemSteps {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    lateinit var response: ResponseEntity<String>
    lateinit var itemId: String

    @Dado("que a API está em execução")
    fun api_esta_em_execucao() {
        // Pode ser vazio, pois o contexto do Spring Boot já sobe a API
    }

    @Quando("faço uma requisição GET para {string}")
    fun faco_uma_requisicao_get_para(endpoint: String) {
        response = restTemplate.getForEntity(endpoint, String::class.java)
    }

    @Entao("a resposta deve ter status {int}")
    fun resposta_deve_ter_status(status: Int) {
        assertThat(response.statusCode.value()).isEqualTo(status)
    }

    @E("o corpo da resposta deve conter o campo {string} com valor {string}")
    fun corpo_deve_conter_campo_com_valor(campo: String, valor: String) {
        assertThat(response.body).contains("\"$campo\":\"$valor\"")
    }

    @E("o corpo da resposta deve conter o campo {string}")
    fun corpo_deve_conter_campo(campo: String) {
        assertThat(response.body).contains("\"$campo\"")
    }
}