
# 📦 Sistema de Logística – API de Entregas e Frotas

Projeto acadêmico em grupo para gerenciamento de entregas com controle de disponibilidade de veículos e motoristas.

Desenvolvido com **Java 17** e **Quarkus**, o sistema é dividido em duas APIs independentes que se comunicam via REST.

---

## 🔗 Repositório

👉 [https://github.com/MapaInterativohub/Servidor_quakus](https://github.com/MapaInterativohub/Servidor_quakus)

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Quarkus 3.22
- RESTEasy Reactive
- Hibernate ORM Panache
- MicroProfile REST Client
- Banco de dados H2
- Swagger/OpenAPI
- Maven

---

## 🛠️ Como executar o projeto localmente

### Pré-requisitos

- Java 17 instalado
- Maven instalado (ou use o `mvnw`)
- IDE como VS Code ou IntelliJ

### Clonar o repositório

```bash
git clone https://github.com/MapaInterativohub/Servidor_quakus.git
cd Servidor_quakus
```

### Estrutura

```text
Servidor_quakus/
├── api_entregas/   → API de Entregas (porta 8080)
└── api_frota/      → API de Frotas   (porta 8081)
```

---

### ▶️ Executar a API de Frotas

```bash
cd api_frota
mvn clean quarkus:dev
```

> Acesse em: [http://localhost:8081/q/swagger-ui](http://localhost:8081/q/swagger-ui)

---

### ▶️ Executar a API de Entregas

```bash
cd ../api_entregas
mvn clean quarkus:dev
```

> Acesse em: [http://localhost:8080/q/swagger-ui](http://localhost:8080/q/swagger-ui)

### ▶️ Executar o arquivo start-servidores
 
 > start-servidores.bat inicia ambas 
---

## 📬 Endpoints principais

### 🔹 FROTAS

| Método | Rota                         | Descrição                                     |
|--------|------------------------------|-----------------------------------------------|
| GET    | /api/frotas                  | Lista todas as frotas                         |
| POST   | /api/frotas                  | Cadastra uma nova frota                       |
| GET    | /api/frotas/disponiveis      | Lista frotas disponíveis                      |
| GET    | /api/frotas/disponibilidade  | Retorna se há frota e motorista disponíveis   |

### 🔹 ENTREGAS

| Método | Rota              | Descrição                                              |
|--------|-------------------|----------------------------------------------------------|
| GET    | /api/entregas     | Lista todas as entregas cadastradas                     |
| POST   | /api/entregas     | Agenda nova entrega (verifica se há frota disponível)   |

---

## 📄 Exemplos de JSON

### Criar uma frota

```json
{
  "modeloCaminhao": "Mercedes Axor",
  "placa": "ABC1D23",
  "capacidadeDeCarga": 10000,
  "disponivel": true,
  "veiculoDisponivel": true,
  "motoristaDisponivel": true
}
```

### Criar uma entrega

```json
{
  "categoria": "Alimentos",
  "dataDeSaidaDeEntrega": "2025-06-15",
  "volume": 30
}
```

> ⚠️ A entrega só é agendada se houver frota disponível **não ocupada na mesma data**.

---

## 🧪 Testes via Swagger

- [API de Entregas - Swagger UI](http://localhost:8080/q/swagger-ui)
- [API de Frotas - Swagger UI](http://localhost:8081/q/swagger-ui)

---

## 👨‍💻 Projeto desenvolvido por

**Equipe do projeto Mapa Interativo**  
Repositório mantido por: [MapaInterativohub](https://github.com/MapaInterativohub)
