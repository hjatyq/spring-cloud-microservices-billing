# 🧩 Spring Cloud Microservices Application

## 📌 Description du projet

Ce projet est une **application basée sur une architecture microservices** développée avec **Spring Boot** et **Spring Cloud**.  
Il a pour objectif de démontrer les concepts fondamentaux des microservices, notamment :

- Configuration centralisée avec **Spring Cloud Config**
- Découverte de services avec **Eureka Discovery Server**
- API Gateway pour un point d’entrée unique
- Communication inter-services avec **Spring Cloud OpenFeign**
- Indépendance et scalabilité des services

Le projet est conçu dans un **cadre pédagogique (TP Spring Cloud)**.

---

## 🏗️ Architecture globale

L’architecture repose sur les composants suivants :

                 ┌──────────────┐
                 │  Config Repo │
                 └──────┬───────┘
                        │
                ┌───────▼────────┐
                │ Config Service │
                └───────┬────────┘
                        │
                ┌───────▼────────┐
                │ Discovery      │
                │ (Eureka)       │
                └───────┬────────┘
                        │
                ┌───────▼────────┐
Client ───────▶ │ Gateway        │
└───────┬────────┘
┌───────────────┼────────────────┐
▼               ▼                ▼
Customer Service   Inventory Service   Billing Service



Les services sont enregistrés dynamiquement dans **Eureka Discovery Server** et leur configuration est centralisée via **Spring Cloud Config Server**.

---

## 🧩 Microservices et rôles

| Service | Description |
|------|------------|
| **config-service** | Fournit la configuration centralisée à tous les microservices |
| **config-repo** | Contient les fichiers de configuration externalisés |
| **discovery-service** | Service de découverte basé sur Netflix Eureka |
| **gateway-service** | Point d’entrée unique (API Gateway) |
| **customer-service** | Gestion des clients |
| **inventory-service** | Gestion des produits |
| **billing-service** | Gestion des factures et communication inter-services via Feign |

---

## ⚙️ Technologies utilisées

- Java 17
- Spring Boot
- Spring Cloud
    - Config Server
    - Eureka Discovery
    - Spring Cloud Gateway
    - OpenFeign
- Spring Data JPA
- H2 Database
- Maven
- Lombok

---

## 🔁 Ordre de démarrage des services

⚠️ L’ordre de démarrage est très important :

1. `config-service`
2. `discovery-service`
3. `gateway-service`
4. `customer-service`
5. `inventory-service`
6. `billing-service`

---

## 🌐 Accès aux services

| Service | URL |
|------|----|
| Eureka Dashboard | http://localhost:8761 |
| Gateway | http://localhost:8888 |
| Customers API | http://localhost:8888/customers |
| Products API | http://localhost:8888/products |
| Billing API | http://localhost:8888/bills |

---

## 🔄 Communication inter-services

La communication entre microservices est réalisée grâce à **Spring Cloud OpenFeign** :

- Pas d’URL codée en dur
- Résolution dynamique via Eureka
- Appels REST déclaratifs

Exemple :
```java
@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
