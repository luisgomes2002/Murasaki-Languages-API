# Murasaki Languages API Documentation

## 🔧 Tecnologias

- Java 23
- Spring Boot
- Spring Security + OAuth2 Resource Server
- MapStruct
- Testcontainers
- Mongodb
- JUnit 5
- Mockito
- Docker (para ambiente de desenvolvimento/testes)
- AI 

## Autenticação
Todas as rotas (exceto login e criação de usuário) requerem um token JWT no header:

### 🔒 Configuração de Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis ou adicione environment variables
`SECRET=sua_chave_JWT`


### Para rodar o projeto (Spring Boot)

```
## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 23 ou superior
- Maven 3.8+
- MongoDB
- IDE de sua preferência (IntelliJ, Eclipse, VS Code)

```
### Passo a Passo

**Clone o repositório**

```bash
   git clone https://github.com/seu-usuario/murasaki-api.git
   cd murasaki-api
```

```bash
  mvn clean install
```

```bash
  mvn spring-boot:run
```

## Endpoints da API

## Endpoints da API

| Método | Caminho                                                     | Descrição                             |
|--------|-------------------------------------------------------------|---------------------------------------|
| POST   | `/api/user/login`                                           | Login                                 |
| POST   | `/api/user/create`                                          | Criar Usuário                         |
| GET    | `/api/user/`                                                | Listar Todos Usuários                 |
| GET    | `/api/user/list/{userId}`                                   | Obter Usuário por ID                  |
| PUT    | `/api/user/update/{userId}`                                 | Atualizar Usuário                     |
| PUT    | `/api/user/update-password/{userId}`                        | Atualizar Senha do Usuário            |
| PUT    | `/api/user/update-role/{userId}`                            | Atualizar Role do Usuário             |
| PUT    | `/api/user/update-status/{userId}`                          | Atualizar Status do Usuário           |
| DELETE | `/api/user/delete/{userId}`                                 | Deletar Usuário                       |
| POST   | `/api/lesson/create/{collectionId}`                         | Criar Lição                           |
| POST   | `/api/lesson/publish/{userId}/{lessonId}`                   | Publicar Lição                        |
| GET    | `/api/lesson/`                                              | Listar Todas Lições                   |
| GET    | `/api/lesson/visibility/{visibility}`                       | Obter Lições publicas ou privadas     |
| GET    | `/api/lesson/published/{published}`                         | Obter Lições postadas ou não postadas |
| GET    | `/api/lesson/public`                                        | Obter Lições publicas                 |
| GET    | `/api/lesson/published-true`                                | Obter Lições publicadas               |
| GET    | `/api/lesson/{id}`                                          | Obter Lição por ID                    |
| PUT    | `/api/lesson/update/{userId}/{lessonId}`                    | Atualizar Lição                       |
| DELETE | `/api/lesson/delete/{userId}/{lessonId}`                    | Deletar Lição                         |
| POST   | `/api/plans/create`                                         | Criar Plano                           |
| GET    | `/api/plans/`                                               | Listar Todos Planos                   |
| GET    | `/api/plans/list/{planId}`                                  | Obter Plano por ID                    |
| PUT    | `/api/plans/update/{planId}`                                | Atualizar Plano                       |
| DELETE | `/api/plans/delete/{planId}`                                | Deletar Plano                         |
| POST   | `/api/lesson-collection/create`                             | Criar Coleção de Lições               |
| GET    | `/api/lesson-collection/`                                   | Listar Todas Coleções                 |
| POST   | `/api/report/create`                                        | Criar Reporte                         |
| GET    | `/api/report/`                                              | Listar Todos Reportes                 |
| PUT    | `/api/report/update-status/{reportId}`                      | Atualizar Status do Reporte           |
| GET    | `/api/backlog/`                                             | Listar Backlog                        |
| POST   | `/api/work-sheets/create/{userId}/{lessonId}`               | Criar Worksheet                       |
| GET    | `/api/work-sheets/{worksheetId}`                            | Obter Worksheet por ID                |
| PUT    | `/api/work-sheets/update/{worksheetId}/{userId}`            | Atualizar Worksheet                   |
| DELETE | `/api/work-sheets/delete/{worksheetId}/{userId}/{lessonId}` | Deletar Worksheet                     |
| POST   | `/api/explanation/create/{userId}/{lessonId}`               | Criar Explicação                      |
| GET    | `/api/explanation/{explanationId}`                          | Obter Explicação por ID               |
| PUT    | `/api/explanation/update/{explanationId}/{userId}`          | Atualizar Explicação                  |
| DELETE | `/api/explanation/delete/{userId}/{explanationId}`          | Deletar Explicação                    |


### Login
```
POST /api/user/login
{
  "email": "luis@gmail.com",
  "password": "123123123"
}
```

### Criar Usuário
```
POST /api/user/create
{
  "name": "Luis",
  "username": "Luis",
  "email": "luis@gmail.com",
  "password": "123123123"
}
```

### Atualizar Usuário
```
PUT /api/user/update/{userId}
{
  "name": "Gustavo",
  "username": "Gustavo",
  "email": "gustavo@gmail.com",
  "icon": "",
  "background": "",
  "about": "Ainda não criou uma descrição"
}
```

```
PUT /api/user/update-password/{userId}

Body: "novaSenha"
```

```
PUT /api/user/update-role/{userId}
Body: "ADMIN" ou "USER"
```

```
PUT /api/user/update-status/{userId}
Body: true ou false
```

```
POST /api/lesson/create/{collectionId}
{
  "title": "Título da Lição",
  "text": "Texto completo da lição...",
  "explanations": [],
  "worksheets": [],
  "links": ["https://exemplo.com"],
  "languageType": "JP",
  "japaneseLevels": "N4"
}
```

```
PUT /api/lesson/update/{userId}/{lessonId}
Body: (mesmo formato de criação, com campos atualizados)
```

```
POST /api/plans/create
{
  "title": "Plano Premium",
  "description": "Descrição do plano...",
  "value": 35.00,
  "advantages": ["Vantagem 1", "Vantagem 2"]
}
```


```
PUT /api/plans/update/{planId}
Body: (mesmo formato de criação)
```


```
POST /api/lesson-collection/create
{
  "languageName": "Coreano"
}
```

```
POST /api/report/create
{
  "userId": "idDoUsuario",
  "objectId": "idDoObjetoReportado",
  "reportType": "LESSON",
  "text": "Texto do reporte"
}
```

```
PUT /api/report/update-status/{reportId}
Body: true ou false
```

```
POST /api/work-sheets/create/{userId}/{lessonId}
{
  "question": "Pergunta",
  "options": ["Opção A", "Opção B"],
  "answer": "A",
  "explanation": "Explicação da resposta"
}
```

```
PUT /api/work-sheets/update/{worksheetId}/{userId}
{
  "question": "Pergunta",
  "options": ["Opção A", "Opção B"],
  "answer": "A",
  "explanation": "Explicação da resposta"
}
```

```
POST /api/explanation/create/{userId}/{lessonId}
{
  "phrase": "Frase em japonês",
  "translation": "Tradução",
  "explanation": "Explicação detalhada"
}
```

```
PUT /api/explanation/update/{explanationId}/{userId}
{
  "phrase": "Frase em japonês",
  "translation": "Tradução",
  "explanation": "Explicação detalhada"
}
```

