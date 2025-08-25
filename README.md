# Item Detail API

API Backend que fornece detalhes sobre produtos, inspirado no Mercado Livre.


## Narrativa de Negócio

Esta API foi desenvolvida para fornecer todos os detalhes relevantes de um item/produto, permitindo que o frontend exiba ao cliente todas as informações necessárias para a tomada de decisão de compra.

Durante o processo de refinamento, analisamos produtos no site do Mercado Livre e simulamos o cadastro de novos itens para identificar os campos essenciais. O objetivo foi mapear todos os atributos que realmente importam para a experiência do usuário final.

Abaixo, segue uma tabela detalhada com os atributos mapeados, suas descrições e a obrigatoriedade de cada um:

| Nome                | Descrição                                                                                                         | Obrigatório |
|---------------------|-------------------------------------------------------------------------------------------------------------------|:-----------:|
| Título              | Título exibido para o cliente                                                                                     | Sim         |
| Condição do produto | Indica se o produto é novo, usado ou recondicionado                                                               | Sim         |
| Código universal    | Número que identifica o produto em nível global (ex: EAN, UPC)                                                    | Sim         |
| Fotos               | Lista de URLs de imagens do produto                                                                               | Não         |
| Estoque             | Quantidade disponível para venda                                                                                  | Sim         |
| SKU                 | Código interno do vendedor para controle de estoque                                                               | Não         |
| Descrição           | Descrição detalhada do produto                                                                                    | Não         |
| Preço               | Valor de venda do produto                                                                                         | Sim         |
| Tipo de anúncio     | Define o grau de exposição e características do anúncio (Clássico ou Premium)                                     | Sim         |
| Forma de entrega    | Modalidade de entrega: Entrega grátis, por conta do vendedor ou a combinar                                        | Sim         |
| Retirar pessoalmente| Indica se o cliente pode retirar o produto pessoalmente                                                           | Não         |
| Garantia            | Tipo de garantia oferecida: garantia do vendedor, garantia de fábrica ou sem garantia                             | Sim         |

> Esta estrutura garante que todas as informações essenciais estejam disponíveis para o frontend, proporcionando uma experiência completa e transparente ao cliente.
## Endpoints

- `GET /api/items/{id}`: Get detalhes do item por id.

## Observability

- OpenTelemetry configured for traces (Tempo) and logs (Loki).
- Actuator enabled.

## Arquitetura

- Clean Architecture (domain, application, adapter layers)
- Persistence via local JSON file
- Async endpoints (Kotlin coroutines)
- Error handling with clear messages

## Sample Data

See `src/main/resources/data/products.json`

## Tecnologias utilizadas
IntelliJ IDEA 2025.1.4.1 (Community Edition) e StackSpot