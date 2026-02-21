# SistemaAuditoria-java-spring

🛡️  Sistema de Auditoria e Versionamento de Dados

Este projeto é uma API REST desenvolvida em Java com Spring Boot, focada em auditoria, rastreabilidade e versionamento de dados, registrando todas as ações realizadas pelos usuários no sistema, como criação, alteração e exclusão lógica de entidades.

O objetivo é garantir transparência, segurança e histórico completo das operações, seguindo boas práticas utilizadas em sistemas corporativos e financeiros.

🎯 ## Objetivos do Projeto

Registrar todas as ações realizadas pelos usuários

Garantir imutabilidade dos logs de auditoria

Manter histórico de versões de dados (versionamento)

Permitir rastreabilidade: quem fez, o quê, quando e em qual entidade

Gerar alertas automáticos para ações suspeitas

Separar responsabilidades usando camadas bem definidas

🗃️ Modelo de Dados (Entidades Principais)

User -> executa as ações

Transaction -> ação do negócio

AuditLog -> registro imutável 

VersionedEntity -> estado da entidade auditada

Alert -> consequência de um log suspeito

🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

controller  →  service  →  repository  →  database
                ↓
            audit / alert


📦  Principais Camadas

Controller: expõe endpoints REST

Service: contém a lógica de negócio

Repository: acesso a dados via Spring Data JPA

DTOs: comunicação entre API e cliente

Mapper: conversão entre entidades e DTOs

Security: configuração de segurança (Spring Security)

Migration: versionamento do banco com Flyway


🛠️  Tecnologias Utilizadas

Java 21

Spring Boot

Spring Data JPA

Spring Security

PostgreSQL

Flyway (Database Migration)

Maven

Postman (testes de API)
