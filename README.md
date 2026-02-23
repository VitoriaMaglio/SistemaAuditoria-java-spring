# Sistema de Auditoria e Versionamento de Dados

API REST desenvolvida em Java com Spring Boot, focada em auditoria, rastreabilidade e versionamento de dados, registrando todas as ações realizadas pelos usuários no sistema — como criação, alteração e exclusão lógica de entidades.

O projeto tem como objetivo garantir transparência, segurança e histórico completo das operações, seguindo boas práticas adotadas em sistemas corporativos e financeiros.
---
🎯 **Problema Resolvido**

Em sistemas corporativos, é comum a necessidade de:

- Rastrear alterações em dados sensíveis

- Investigar falhas, erros ou comportamentos indevidos

- Atender requisitos de compliance e governança

- Manter um histórico confiável de versões dos dados

Este projeto resolve esses problemas oferecendo:

✅ Versionamento de entidades

✅ Auditoria automatizada

✅ Arquitetura extensível e desacoplada
---

🗃️ **Modelo de Dados**
| Entidade            | Responsabilidade                |
| ------------------- | ------------------------------- |
| **User**            | Executa as ações no sistema     |
| **Transaction**     | Representa a ação de negócio    |
| **AuditLog**        | Registro imutável dos eventos   |
| **VersionedEntity** | Estado da entidade auditada     |
| **Alert**           | Consequência de um log suspeito |

🧱 **Arquitetura**

O projeto segue uma arquitetura em camadas, garantindo organização, manutenibilidade e escalabilidade:

Controller → Exposição dos endpoints REST

Service → Lógica de negócio

Repository → Acesso a dados com Spring Data JPA

DTOs → Comunicação entre API e cliente

Mapper → Conversão entre entidades e DTOs

Exception → Tratamento global de erros

Migration → Versionamento do banco de dados com Flyway

---
🔍 **Funcionamento da Auditoria**

O sistema de auditoria é baseado em registro de eventos e versionamento do estado dos dados, separando claramente:

👤 Quem realizou a ação

⚙️ Qual ação ocorreu

🗂️ Como os dados estavam naquele momento

📌 **Fluxo de Funcionamento**
-> Cadastro ou alteração de um usuário

A ação gera um registro na tabela AuditLog

O evento é registrado com informações da operação (ex: criação, atualização)

-> Cadastro ou alteração de uma transação

Um novo registro é criado em AuditLog

Cada evento é tratado de forma independente e rastreável

-> Versionamento do estado dos dados

O estado da entidade no momento da ação é persistido em VersionedEntity

Cada registro representa um snapshot do dado, permitindo manter o histórico completo das alterações

📂 **Responsabilidades das Estruturas**

🧾 AuditLog

Responsável por registrar o evento ocorrido no sistema.

Armazena:

Tipo de ação (CREATE, UPDATE, DELETE)

Entidade afetada

Identificador da entidade

Data e hora do evento

🗂️ VersionedEntity

Responsável por armazenar os estados versionados dos dados.

Permite:

Reconstrução do histórico da entidade

Análise da evolução dos dados ao longo do tempo

Auditorias detalhadas e rastreáveis

---
🧠 **Benefícios da Abordagem**

Separação clara entre evento de auditoria e estado do dado

Maior flexibilidade para evolução do sistema

Compatibilidade com cenários corporativos e requisitos de compliance

Histórico confiável, organizado e imutável

🛠️ **Tecnologias Utilizadas**

☕ Java 21

🌱 Spring Boot

🗄️ Spring Data JPA

🐘 PostgreSQL

🔄 Flyway (Database Migration)

🧪 JUnit

🧪 Mockito

📦 Maven

🔎 Postman (testes de API)

👩‍💻 **Autora**

Vitória
Estudante de Análise e Desenvolvimento de Sistemas
Foco em desenvolvimento Back-end com Java e Spring
