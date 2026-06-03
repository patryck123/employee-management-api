# 👔 Employee Management API

Sistema de gestão de funcionários e departamentos de RH.

## 📋 Sobre o Projeto

API para o setor de Recursos Humanos gerenciar colaboradores da empresa. Organiza funcionários por departamentos, controla status de vínculo empregatício e armazena dados profissionais completos.

## ✨ Funcionalidades

- ✅ Cadastrar funcionários com dados completos (nome, CPF, cargo, salário)
- ✅ Criar e gerenciar departamentos
- ✅ Vincular funcionário a um departamento
- ✅ Listar funcionários por departamento
- ✅ Atualizar cargo e salário
- ✅ Status do funcionário: ACTIVE, ON_LEAVE, TERMINATED
- ✅ Buscar funcionário por CPF

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/employees` | Listar / Cadastrar funcionários |
| GET/PUT/DELETE | `/api/employees/{id}` | Gerenciar funcionário |
| GET | `/api/employees/department/{id}` | Funcionários por depto |
| GET/POST | `/api/departments` | Listar / Criar departamentos |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · MySQL · Maven · Lombok
