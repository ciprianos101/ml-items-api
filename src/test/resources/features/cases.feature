Feature: Consulta de detalhes de item

  Background:
    Given que a API está em execução

  Scenario: Consulta de item com sucesso
    When faço uma requisição GET para "/items/3fe94906-02d3-4d16-8083-6da13889110d"
    Then a resposta deve ter status 200
    And o corpo da resposta deve conter o campo "id" com valor "3fe94906-02d3-4d16-8083-6da13889110d"
    And o corpo da resposta deve conter o campo "title"

  Scenario: Produto não encontrado
    When faço uma requisição GET para "/items/00000000-0000-0000-0000-000000000000"
    Then a resposta deve ter status 404
    And o corpo da resposta deve conter o campo "message" com valor "Item não encontrado"

  Scenario: UUID inválido
    When faço uma requisição GET para "/items/uuid-invalido"
    Then a resposta deve ter status 400
    And o corpo da resposta deve conter o campo "message" com valor "O parâmetro 'id' deve ser um UUID válido"

  Scenario: Requisição inválida (endpoint inexistente)
    When faço uma requisição GET para "/item/3fe94906-02d3-4d16-8083-6da13889110d"
    Then a resposta deve ter status 404
    And o corpo da resposta deve conter o campo "Endpoint não encontrado"