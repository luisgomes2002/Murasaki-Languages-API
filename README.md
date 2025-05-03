# Murasaki Languages API Documentation

## Autenticação
Todas as rotas (exceto login e criação de usuário) requerem um token JWT no header:

## 🔒 Configuração de Variáveis de Ambiente

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

## Rotas

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

### Listar Todos Usuários
```
GET /api/user/
```

### Obter Usuário por ID
```
GET /api/user/list/{userId}
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
DELETE /api/user/delete/{userId}
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
POST /api/lesson/publish/{userId}/{lessonId}
```

```
GET /api/lesson/
```

```
GET /api/lesson/{lessonId}
```

```
PUT /api/lesson/update/{userId}/{lessonId}
Body: (mesmo formato de criação, com campos atualizados)
```

```
DELETE /api/lesson/delete/{userId}/{lessonId}
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
GET /api/plans/
```

```
GET /api/plans/list/{planId}
```

```
PUT /api/plans/update/{planId}
Body: (mesmo formato de criação)
```

```
DELETE /api/plans/delete/{planId}
```

```
POST /api/lesson-collection/create
{
  "languageName": "Coreano"
}
```

```
GET /api/lesson-collection/
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
GET /api/report/
```

```
PUT /api/report/update-status/{reportId}
Body: true ou false
```

```
GET /api/backlog/
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
GET /api/work-sheets/{worksheetId}
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
DELETE /api/work-sheets/delete/{worksheetId}/{userId}/{lessonId}
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
GET /api/explanation/{explanationId}
```

```
PUT /api/explanation/update/{explanationId}/{userId}
{
  "phrase": "Frase em japonês",
  "translation": "Tradução",
  "explanation": "Explicação detalhada"
}
```

```
DELETE /api/explanation/delete/{userId}/{explanationId}
```
