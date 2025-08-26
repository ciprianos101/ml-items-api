# Como Executar o Projeto

Este documento explica como rodar e testar a aplicação localmente, utilizando tanto o Gradle quanto o Docker.

---

## Executando com Gradle

Certifique-se de ter o Java 17+ instalado.

Para iniciar a aplicação localmente, execute o comando abaixo no terminal, na raiz do projeto:

```bash
./gradlew bootRun
```

A aplicação será iniciada em modo de desenvolvimento, normalmente acessível em [http://localhost:8080](http://localhost:8080).

### Rodando os Testes

Para executar todos os testes automatizados do projeto, utilize:

```bash
./gradlew test
```

---

## Executando com Docker

Se preferir rodar a aplicação em um container Docker, siga os passos abaixo:

. **Build da imagem Docker:**

   ```bash
   docker build -t item-detail-api .
   ```

. **Executando o container:**

   ```bash
   docker run -p 8080:8080 item-detail-api
   ```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

---

## Observações

- Certifique-se de que a porta 8080 esteja livre em sua máquina.
- O arquivo de configuração e os dados dos itens estão incluídos na imagem Docker.
- Para customizações, edite os arquivos em `src/main/resources` antes de gerar a imagem.

---

Pronto! Agora você pode rodar e testar a aplicação facilmente em qualquer ambiente.