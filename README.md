# Projeto Inicial - Arquitetura Hexagonal (Ports & Adapters)

Este é um projeto base desenvolvido em **Java 21** e **Spring Boot 3**, estruturado seguindo os princípios rigorosos da **Arquitetura Hexagonal** (também conhecida como Ports and Adapters). O objetivo desta estrutura é manter as regras de negócio centrais (Domínio) isoladas de tecnologias externas (bancos de dados, web frameworks, filas, etc).

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.2+** (Usado apenas na camada de infraestrutura)
- **Maven**
- **SpringDoc OpenAPI (Swagger)** para documentação de APIs

## 📂 Estrutura de Diretórios
O código fonte principal está em `src/main/java/com/exemplo/projeto` e é dividido nas seguintes camadas principais:

```
com.exemplo.projeto
├── domain/             # (O CORE) Regras de Negócio e Entidades
│   └── model/          # User (Não possui NENHUMA anotação de framework)
│
├── application/        # Casos de uso e Portas
│   ├── ports/
│   │   ├── in/         # Portas de Entrada (Interfaces dos Use Cases - ex: CreateUserUseCase)
│   │   └── out/        # Portas de Saída (Interfaces para acesso externo - ex: UserRepositoryPort)
│   └── services/       # Implementação dos Casos de Uso (ex: UserService)
│
└── infrastructure/     # Adaptadores Técnicos e Configuração (Onde o Spring vive)
    ├── adapters/
    │   ├── in/web/          # Adaptadores de Entrada (ex: Controllers REST)
    │   └── out/persistence/ # Adaptadores de Saída (ex: Implementação de repositórios)
    └── config/         # Configurações do framework (Injeção de dependências dos beans do domínio)
```

## ⚙️ Como Executar

Para executar o projeto localmente, abra o terminal na raiz do projeto e utilize o wrapper do Maven:

```bash
# Para compilar o projeto e baixar as dependências
./mvnw clean install

# Para rodar a aplicação
./mvnw spring-boot:run
```
> O servidor será iniciado na porta `8080`.

## 📚 Documentação da API (Swagger)

A aplicação já vem com o Swagger configurado nativamente. Após rodar a aplicação, acesse o link abaixo no seu navegador:

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Lá você encontrará a interface gráfica documentando nossos endpoints e poderá realizar chamadas de teste.

## 🧪 Como Testar a API via Terminal

Você pode realizar um cadastro de usuário via `cURL` ou `PowerShell` testando a camada Web:

```bash
curl -X POST http://localhost:8080/api/users \
     -H "Content-Type: application/json" \
     -d '{"name": "João", "email": "joao@exemplo.com"}'
```
