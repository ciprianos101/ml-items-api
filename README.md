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

## Narrativa técnica

### Escolha das Tecnologias

O projeto foi desenvolvido utilizando Kotlin, Gradle e Spring Boot. A escolha dessas tecnologias foi motivada não apenas pelo meu conhecimento prévio, mas também por 
suas características técnicas e benefícios para o desenvolvimento de APIs modernas:

- **Kotlin**: Linguagem concisa, segura e interoperável com Java, proporcionando maior produtividade e menos propensão a erros. Sua sintaxe moderna facilita a manutenção e evolução do código.
- **Spring Boot**: Framework robusto e amplamente adotado para construção de APIs REST, oferecendo rápida configuração, grande ecossistema de bibliotecas e suporte nativo a práticas como injeção de dependências, segurança e testes.
- **Gradle**: Ferramenta de build flexível e eficiente, que simplifica o gerenciamento de dependências e automação de tarefas, acelerando o ciclo de desenvolvimento.

Além da familiaridade, essas tecnologias foram escolhidas por sua maturidade, comunidade ativa, 
documentação abrangente e facilidade de integração com ferramentas modernas de observabilidade, de IA generativa 
e deploy, garantindo escalabilidade, correção de erros e qualidade ao projeto.


> Esta estrutura garante que todas as informações essenciais estejam disponíveis para o frontend, proporcionando uma experiência completa e transparente ao cliente.
### Endpoints

- `GET /items/{id}`: Get detalhes do item por id.

## Arquitetura

### Estrutura de Pastas

```
├── src/
    │   ├── main/
    │   │   ├── kotlin/
    │   │   │   ├── com.lucasoliveira.itemdetail/
    │   │   │   │   ├── adapter.api
    │   │   │   │   │   ├──controller # Controllers (camada de entrada da API)
    │   │   │   │   │     └── ItemController.kt # Controller principal dos endpoints de item
    │   │   │   │   │   ├──dto/
    │   │   │   │   │     └── ItemResponseDTO.kt 
    │   │   │   │   │     └── mapper.kt 
    │   │   │   │   │   ├──exception
    │   │   │   │   │     └── ExceptionHandler.kt # controle de exceções
    │   │   │   │   ├── data/ # Camada de acesso a dados
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
    │   │   │   │   │   │   │   └── ItemRepository.kt # Interface do Repository de itens
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
    │   │   │   │   ├── adapter.api.exception/    
    │   │   │   │   │   └── ExceptionHandlerTest.kt 
    │   │   │   │   ├── cucumber
    │   │   │   │   │   └── ItemSteps.kt   # implementação testes cucumber
    │   │   │   │   ├── data.repositories/
    │   │   │   │   │   └── ItemFileRepositoryTest.kt # Testes do repositório de arquivos
    │   │   │   │   ├── domain.usecase.itemsdetails/
    │   │   │   │   │   └── ItemDetailsByIdImplTest.kt # Testes do caso de uso
    │   │ └── ItemMockFactory.kt # Fábrica de mocks para testes
    │   └── resources/ # Recursos para testes
```

### Clean Architecture 

Para facilitar futuras manutenções e garantir uma organização robusta, a aplicação foi estruturada seguindo 
os princípios do Clean Architecture, separando as responsabilidades em diferentes camadas.

No código, isso se reflete na existência de portas (ports) e interfaces, como a interface `ItemRepository` (port) 
utilizada pelo caso de uso `ItemDetailsByIdImpl`. Essa interface define um contrato para acesso aos dados, 
sendo implementada na camada de infraestrutura (data) pela classe `ItemFileRepository`. 
Dessa forma, caso seja necessário alterar a fonte de dados no futuro 
(por exemplo, migrar de um arquivo JSON para um banco de dados), basta criar uma nova implementação da interface, 
sem impactar as regras de negócio.

A separação de camadas também é evidenciada pelo uso da interface `ItemDetailsById` (port) no controller. 
O controller depende apenas dessa interface, permitindo que a lógica de negócio seja modificada ou substituída 
sem a necessidade de alterar a camada de apresentação (API). Isso promove baixo acoplamento e alta coesão, facilitando 
a evolução e manutenção do sistema.

Essa abordagem garante que as regras de negócio permaneçam isoladas de detalhes de infraestrutura e frameworks, 
tornando a aplicação mais flexível, testável e preparada para mudanças.

### Persistence via local JSON file  

Como solicitado na descrição do projeto, neste primeiro momento utilizamos um arquivo JSON como base de dados para os itens.  

### Estrutura de Dados e Performance

Para garantir alta performance e atualização automática dos dados ao utilizar um arquivo JSON como "banco de dados", optamos por carregar os itens em memória e indexá-los em um `HashMap` (Kotlin: `Map<UUID, Item>`). Essa decisão foi motivada pelos seguintes fatores:

- **Performance de busca:**  
  Em uma abordagem ingênua, seria necessário ler e desserializar o arquivo JSON a cada requisição, realizando uma busca linear (O(N)) para encontrar o item pelo ID. Isso significa que, quanto maior o número de itens, mais lenta seria a resposta da API.

- **Acesso em tempo constante:**  
  Ao carregar os itens em memória e indexá-los por ID usando um `HashMap`, a busca por um item específico passa a ser feita em tempo constante (O(1)). Ou seja, o tempo de resposta não depende do número de itens cadastrados, garantindo escalabilidade mesmo com grandes volumes de dados.

- **Atualização automática:**  
  O repositório monitora o timestamp de modificação do arquivo. Sempre que o arquivo é alterado, ele é recarregado e o índice em memória é atualizado automaticamente, refletindo as mudanças sem necessidade de reiniciar a aplicação.

#### Resumo das complexidades:
- **Busca linear (O(N))**: ler o arquivo e procurar item por item (ineficiente para grandes arquivos).
- **Busca indexada (O(1))**: acesso direto ao item via `HashMap`, extremamente eficiente.

Essa estratégia proporciona uma API responsiva, eficiente e preparada para crescer conforme a demanda, sem abrir mão da simplicidade de utilizar um arquivo como fonte de dados.

### Async endpoints (Kotlin coroutines)

A API utiliza **endpoints assíncronos** com [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html), uma abordagem moderna para lidar com operações de I/O (como leitura de arquivos, chamadas HTTP, etc) de forma não bloqueante.

### Por que usar endpoints assíncronos?

- **Escalabilidade:**  
  Em APIs tradicionais, cada requisição ocupa uma thread do servidor até que toda a operação termine (incluindo esperas por I/O). Com coroutines, a thread é liberada enquanto aguarda operações externas, permitindo que o servidor atenda muito mais requisições simultâneas com a mesma quantidade de recursos.

- **Desempenho:**  
  O uso de coroutines reduz o overhead de criação e troca de threads, tornando o processamento mais eficiente, especialmente sob alta carga.

- **Simplicidade:**  
  O código assíncrono com coroutines é escrito de forma sequencial, facilitando a leitura, manutenção e testes, sem a complexidade de callbacks ou programação reativa.

### Exemplo prático

No controller, o endpoint é declarado como `suspend`:

```kotlin
@GetMapping("/{id}")
suspend fun getItem(@PathVariable id: UUID): ResponseEntity<ItemResponseDTO?>?  {
  val item = itemDetailsById.run(id)
  return ResponseEntity.ok(item.toResponseDTO())
}
```

Isso permite que toda a cadeia de execução (controller, usecase, DAO) seja não bloqueante, aproveitando ao máximo os recursos do servidor.

### Benefícios em produção

- **Menor consumo de memória e CPU** em cenários de alta concorrência.
- **Respostas mais rápidas** sob carga, pois o servidor não fica preso esperando operações de I/O.
- **Preparação para crescimento**: a aplicação está pronta para escalar horizontalmente e atender picos de acesso sem grandes mudanças na arquitetura.

> Em resumo: endpoints assíncronos com Kotlin Coroutines tornam a API mais eficiente, escalável e fácil de manter.

## Segurança

A segurança é um aspecto fundamental no desenvolvimento de APIs, especialmente quando expostas a aplicações frontend. No projeto, algumas medidas essenciais já foram implementadas, enquanto outras foram postergadas devido ao escopo atual. Abaixo, detalhamos as principais decisões:

- **Validação de entrada**
  - Todos os endpoints que recebem identificadores de itens utilizam o tipo `UUID`. Essa escolha:
    - **Previne enumeração fácil de produtos**, dificultando ataques de enumeração sequencial.
    - **Facilita a integração** com múltiplos sistemas e bancos de dados distribuídos.
    - **Segue boas práticas** de APIs modernas, especialmente públicas, ao evitar exposição de IDs previsíveis.
  - Além disso, são aplicadas validações automáticas nos DTOs de entrada, reduzindo o risco de dados malformados ou maliciosos.

- **Utilização de DTOs para resposta**
  - As respostas da API são encapsuladas em DTOs (Data Transfer Objects), expondo apenas os campos necessários ao consumidor. Isso evita vazamento de informações sensíveis ou detalhes internos da aplicação.

- **Tratamento de erros**
  - A API retorna mensagens de erro claras e status HTTP apropriados para cada situação, evitando exposição de stacktraces ou detalhes internos do sistema.

- **Medidas não implementadas neste momento**
  - **CORS (Cross-Origin Resource Sharing):** Não foi configurado explicitamente, pois a API está restrita a ambientes controlados. Para produção, recomenda-se definir políticas de CORS adequadas para evitar acessos indevidos de domínios não autorizados.
  - **Autenticação e Autorização:** Não foram implementadas, já que o objetivo atual é fornecer dados de catálogo sem restrição. Em ambientes produtivos, é fundamental proteger os endpoints com mecanismos como OAuth2, JWT ou integração com provedores de identidade.
  - **Rate Limiting:** Não foi aplicado, pois a API não está exposta publicamente. Em produção, recomenda-se limitar o número de requisições por IP/usuário para evitar abusos e ataques de negação de serviço (DoS).

> **Resumo:**  
> O projeto já adota práticas de segurança para o contexto atual, priorizando validação de entrada e encapsulamento de dados. Caso a API seja disponibilizada em ambiente produtivo ou exposta publicamente, recomenda-se fortemente a implementação de CORS, autenticação/autorização e rate limiting para garantir a proteção dos dados e dos usuários.

## Testes

A qualidade e a confiabilidade da API são garantidas por uma combinação de testes unitários e testes funcionais automatizados.

- **Testes unitários:** Validam o comportamento isolado de componentes e regras de negócio, garantindo que cada parte do sistema funcione corretamente de forma independente.

- **Testes funcionais com Cucumber:**  
  Utilizamos o [Cucumber](https://cucumber.io/), uma ferramenta de BDD (Behavior-Driven Development), para descrever e automatizar cenários de uso da API em uma linguagem próxima do negócio (Gherkin). Isso facilita a comunicação entre desenvolvedores, QA e stakeholders, além de garantir que a API se comporte conforme o esperado em situações reais de uso.

  Os cenários de teste cobrem casos como:
  - Consulta de item existente
  - Item não encontrado
  - Validação de UUID inválido
  - Requisições para endpoints inexistentes

  Os arquivos `.feature` com os cenários podem ser encontrados em:  
  `src/test/resources/features`

### Como executar os testes

Para rodar todos os testes unitários rode:

```bash
./gradlew test
```

Para rodar todos os testes do cucumber:

```bash
./gradlew cucumber
```


> A adoção do Cucumber permite que a documentação dos requisitos e os testes estejam sempre alinhados, promovendo maior confiança na evolução do sistema.

## Sample Data

Veja a base de dados utilizada em `src/main/resources/data/items.json`

## Tecnologias utilizadas para auxiliar o desenvolvimento
IntelliJ IDEA 2025.1.4.1 (Community Edition) e StackSpot AI