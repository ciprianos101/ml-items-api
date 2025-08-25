# Item Detail API

API Backend que fornece detalhes sobre produtos, inspirado no Mercado Livre.


## Narrativa de Negócio

Esta API foi desenvolvida para fornecer todos os detalhes relevantes de um item/produto, permitindo que o frontend exiba ao cliente todas as informações necessárias para a tomada de decisão de compra.

Durante o processo de refinamento, analisamos produtos no site do Mercado Livre 
e simulamos o cadastro de novos itens para identificar os campos essenciais. 
O objetivo foi mapear todos os atributos que realmente importam para a experiência do usuário final.

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

## Narrativa técnica

## Escolha das Tecnologias

O projeto foi desenvolvido utilizando Kotlin, Gradle e Spring Boot. A escolha dessas tecnologias foi motivada não apenas pelo meu conhecimento prévio, mas também por 
suas características técnicas e benefícios para o desenvolvimento de APIs modernas:

- **Kotlin**: Linguagem concisa, segura e interoperável com Java, proporcionando maior produtividade e menos propensão a erros. Sua sintaxe moderna facilita a manutenção e evolução do código.
- **Spring Boot**: Framework robusto e amplamente adotado para construção de APIs REST, oferecendo rápida configuração, grande ecossistema de bibliotecas e suporte nativo a práticas como injeção de dependências, segurança e testes.
- **Gradle**: Ferramenta de build flexível e eficiente, que simplifica o gerenciamento de dependências e automação de tarefas, acelerando o ciclo de desenvolvimento.

Além da familiaridade, essas tecnologias foram escolhidas por sua maturidade, comunidade ativa, 
documentação abrangente e facilidade de integração com ferramentas modernas de observabilidade, de IA generativa 
e deploy, garantindo escalabilidade, correção de erros e qualidade ao projeto.



> Esta estrutura garante que todas as informações essenciais estejam disponíveis para o frontend, proporcionando uma experiência completa e transparente ao cliente.
## Endpoints

- `GET /items/{id}`: Get detalhes do item por id.

## Arquitetura

## Estrutura de Pastas

```
├── src/
    │   ├── main/
    │   │   ├── kotlin/
    │   │   │   ├── com.lucasoliveira.itemdetail/
    │   │   │   │   ├── adapter.api.controller/ # Controllers (camada de entrada da API)
    │   │   │   │   │   └── ItemController.kt # Controller principal dos endpoints de item
    │   │   │   │   ├── data/ # Camada de acesso a dados
    │   │   │   │   │   ├── daos/
    │   │   │   │   │   │   └── ItemDaoImpl.kt # Implementação do DAO de itens
    │   │   │   │   │   ├── repositories/
    │   │   │   │   │   │   └── ItemFileRepository.kt # Repositório que lê/escreve itens do arquivo JSON
    │   │   │   │   ├── domain/ # Entidades e regras de negócio
    │   │   │   │   │   ├── model/
    │   │   │   │   │   │   ├── enums/ # Enumerações de domínio (condição, tipo, etc)
    │   │   │   │   │   │   │   └── Condition.kt
    │   │   │   │   │   │   │   └── DeliveryMethod.kt
    │   │   │   │   │   │   │   └── ListingType
    │   │   │   │   │   │   │   └── Warramty
    │   │   │   │   │   │   └── Item.kt # Entidade principal de Item
    │   │   │   │   │   │   └── Price.kt # Classe de valor para preço
    │   │   │   │   │   ├── usecase.itemsdetails/
    │   │   │   │   │   │   ├── port/
    │   │   │   │   │   │   │   └── ItemDao.kt # Interface do DAO de itens
    │   │   │   │   │   │   │   └── ItemDetailsById.kt # Caso de uso para buscar detalhes por ID
    │   │   │   │   │   │   └── ItemDetailsByIdImpl.kt# Implementação do caso de uso
    │   │   │   └── ItemDetailApiApplication.kt # Classe principal (entrypoint Spring Boot)
    │   │   └── resources/
    │   │   │   ├── data/
    │   │   │   │   └── items.json # Base de dados dos itens (JSON)
    │   │   │   └── application.yml # Configurações do Spring Boot
    │   ├── test/
    │   │   ├── kotlin/
    │   │   │   ├── com.lucasoliveira.itemdetail/
    │   │   │   │   ├── adapter.api.controller/
    │   │   │   │   │   └── ItemControllerTest.kt # Testes do controller
    │   │   │   │   ├── data.repositories/
    │   │   │   │   │   └── ItemFileRepositoryTest.kt # Testes do repositório de arquivos
    │   │   │   │   ├── domain.usecase.itemsdetails/
    │   │   │   │   │   └── ItemDetailsByIdImplTest.kt # Testes do caso de uso
    │   │ └── ItemMockFactory.kt # Fábrica de mocks para testes
    │   └── resources/ # Recursos para testes
```

- Clean Architecture 

Para facilitar futuras manutenções e garantir uma organização robusta, a aplicação foi estruturada seguindo 
os princípios do Clean Architecture, separando as responsabilidades em diferentes camadas.

No código, isso se reflete na existência de portas (ports) e interfaces, como a interface `ItemDao` (port) 
utilizada pelo caso de uso `ItemDetailsByIdImpl`. Essa interface define um contrato para acesso aos dados, 
sendo implementada na camada de infraestrutura (data) pela classe `ItemDaoImpl`. 
Dessa forma, caso seja necessário alterar a fonte de dados no futuro 
(por exemplo, migrar de um arquivo JSON para um banco de dados), basta criar uma nova implementação da interface, 
sem impactar as regras de negócio.

A separação de camadas também é evidenciada pelo uso da interface `ItemDetailsById` (port) no controller. 
O controller depende apenas dessa interface, permitindo que a lógica de negócio seja modificada ou substituída 
sem a necessidade de alterar a camada de apresentação (API). Isso promove baixo acoplamento e alta coesão, facilitando 
a evolução e manutenção do sistema.

Essa abordagem garante que as regras de negócio permaneçam isoladas de detalhes de infraestrutura e frameworks, 
tornando a aplicação mais flexível, testável e preparada para mudanças.

- Persistence via local JSON file
- Async endpoints (Kotlin coroutines)
- Error handling with clear messages

## Sample Data

See `src/main/resources/data/items.json`

## Tecnologias utilizadas
IntelliJ IDEA 2025.1.4.1 (Community Edition) e StackSpot