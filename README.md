# 🧾 API Backend - Customer Management

Ce backend est une application **Spring Boot** RESTful permettant de gérer des clients, leurs adresses associées, ainsi que leurs factures.

---

## 🔧 Technologies utilisées

| Technologie       | Description                     |
|------------------|---------------------------------|
| Java 21          | Langage principal               |
| Spring Boot 3+   | Framework principal             |
| Spring Web       | Création d'API REST             |
| Spring Data JPA  | Accès à la base de données      |
| Hibernate        | ORM pour les entités            |
| PostgreSQL / MySQL | Base de données relationnelle |
| Jakarta Validation | Validation des champs          |
| Lombok           | Réduction du code boilerplate   |
| Maven            | Gestion de projet et dépendances |
| CORS             | Support CORS pour le frontend React |

---

## 📁 Structure du projet

src.main.java.com.testapi.demoapi/
├── customer/ # Entité, repository, controller, service client
├── address/ # Gestion des adresses
├── invoice/ # Gestion des factures
├── invoiceItems/ #  elemtns des factures
├── exceptions/ # Gestion des erreurs personnalisées
└── DemoApiApplication.java

## 🔌 Connexion Base de Données

spring.application.name=demoapi

spring.datasource.url=jdbc:postgresql://db:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


## ▶️ Lancer l'application

# Compile le projet
mvn clean install

# Lancer le serveur localement
mvn spring-boot:run
configurer aves posgreSQL

# Optionnel : lancer avec docker
avoir docker installé

docker commpose up --build -d





