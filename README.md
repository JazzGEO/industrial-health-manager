# Industrial Health Manager (IHM)

[🇧🇷 Português](#português) | [🇺🇸 English](#english)

---

## Português

### Sobre o Projeto

Sistema de Gêmeo Digital para monitoramento de ativos industriais em tempo real.

### Tecnologias

- Java 17
- Spring Boot 3.2
- PostgreSQL 15
- Docker & Docker Compose
- Maven

### Funcionalidades

- Simulação multithread de sensores (Temperatura e Vibração)
- Processamento de telemetria com regras de negócio
- Persistência de eventos críticos em PostgreSQL
- API REST para consulta de status dos ativos

### Como executar

#### Pré-requisitos
- Docker Desktop instalado e rodando

#### Executar o projeto
```bash
docker-compose up --build
```

#### Acessar a API
```
GET http://localhost:8080/assets/health
```

### Regras de Negócio

- **NORMAL**: Temperatura < 75°C e Vibração < 5mm/s
- **ALERTA**: Temperatura entre 75°C e 85°C
- **CRÍTICO**: Temperatura > 85°C ou Vibração > 10mm/s

Apenas eventos CRÍTICOS são persistidos no banco de dados.

### Arquitetura

- **Model**: Entidades JPA
- **Repository**: Acesso ao banco de dados
- **Service**: Lógica de negócio e simulação
- **Controller**: Endpoints REST

---

## English

### About the Project

Digital Twin system for real-time industrial asset monitoring.

### Technologies

- Java 17
- Spring Boot 3.2
- PostgreSQL 15
- Docker & Docker Compose
- Maven

### Features

- Multithread sensor simulation (Temperature and Vibration)
- Telemetry processing with business rules
- Critical event persistence in PostgreSQL
- REST API for asset status queries

### How to run

#### Prerequisites
- Docker Desktop installed and running

#### Run the project
```bash
docker-compose up --build
```

#### Access the API
```
GET http://localhost:8080/assets/health
```

### Business Rules

- **NORMAL**: Temperature < 75°C and Vibration < 5mm/s
- **WARNING**: Temperature between 75°C and 85°C
- **CRITICAL**: Temperature > 85°C or Vibration > 10mm/s

Only CRITICAL events are persisted in the database.

### Architecture

- **Model**: JPA entities
- **Repository**: Database access layer
- **Service**: Business logic and simulation
- **Controller**: REST endpoints