# Item Detail API

API Backend que fornece detalhes sobre produtos, inspirado no Mercado Livre.


## Narrativa de Negocio

Api retorna detalhes relacionados a um item/produto. A api deve retornar todas as informações
que serão usadas pelo frontend para mostrar para o cliente tudo o que ele precisa saber sobre 
aquele produto.

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