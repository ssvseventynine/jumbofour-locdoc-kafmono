## 📸 Application Preview
![Dashboard Preview](resources/Jumbo_4.jpg)

## Enterprise System Dashboard

> An asynchronous enterprise streaming dashboard engineered to ingest client message payloads, dispatch event streams through an Apache Kafka cluster, and persist real-time message streams into MySQL for dynamic consumer UI rendering.

[![AWS AWS-Cloud](https://img.shields.io/badge/Infrastructure-AWS-232F3E?logo=amazon-aws&logoColor=white)](#)
[![Kubernetes Kubernetes](https://img.shields.io/badge/Orchestration-Kubernetes-326CE5?logo=kubernetes&logoColor=white)](#)
[![Apache Kafka](https://img.shields.io/badge/Event%20Streaming-Apache%20Kafka-231F20?logo=apachekafka&logoColor=white)](#)
[![Backend Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot-6DB33F?logo=springboot&logoColor=white)](#)
[![Frontend VueJS](https://img.shields.io/badge/Frontend-Vue.js-4FC08D?logo=vuedotjs&logoColor=white)](#)

---

## 🌐 Live Application

* **Deployment Status:** Configured for cloud orchestration on AWS Kubernetes Cluster (Local/Staging environment verified via Docker Containerization).

---

## 📐 System Architecture & Workflow

The architecture utilizes a monolithic Spring Boot backend serving as both the producer and consumer interface for an **Apache Kafka** event stream cluster. The VueJS front-end submits event messages via HTTP network requests to the Spring Boot producer endpoint. Incoming messages are pushed to the Kafka Broker topic on port `9092`. A dedicated Kafka consumer component listens to the topic, processes incoming payloads, and triggers database persistence via Hibernate ORM to MySQL before broadcasting real-time state back to the storage dashboard.

```
+-------------------+      HTTP Request      +---------------------------------+
|                   | ---------------------> |  Spring Boot Backend            |
|   VueJS Client    |                        |  (Producer / Consumer Tier)     |
|   (Dashboard)     | <--------------------- |  (Port 8080)                    |
+-------------------+    Real-Time Updates   +----------------+----------------+
     (Port 5173)                                              |
                                                              | Publish / Subscribe
                                                              v
                                                     +-----------------+
                                                     |  Apache Kafka   |
                                                     |  Broker Topic   |
                                                     |  (Port 9092)    |
                                                     +--------+--------+
                                                              |
                                                              | Hibernate ORM
                                                              v
                                                     +-----------------+
                                                     | MySQL Database  |
                                                     | (Port 3306)     |
                                                     +-----------------+
```

---

## ✨ Key Features & Capabilities

* **Interactive Event Message Submission:** Interactive VueJS UI component enabling users to input custom message payloads and dispatch them directly to the event producer stream.
* **Asynchronous Kafka Event Streaming:** High-throughput message ingestion and topic partitioning managed by an Apache Kafka cluster on port `9092`.
* **Real-Time Consumer & Storage View:** Real-time event consumption pipeline that reads streaming data and publishes dynamic live updates to the consumer view.
* **Hibernate Data Persistence:** Automatic persistence layer storing all ingested stream logs and transaction records into MySQL database tables.
* **Containerized AWS/Kubernetes Deployment:** Complete container orchestration packaged via Docker Desktop and configured for AWS Kubernetes nodes.

---

## 🛠️ Tech Stack & Dependencies

* **Back-End:** Java JRE, Spring Boot, Spring Kafka, Hibernate ORM
* **Front-End:** Vue.js, JavaScript (ES6+), HTML5/CSS3
* **Streaming & Database:** Apache Kafka, MySQL
* **Cloud & DevOps:** Docker Desktop, Amazon Web Services (AWS), Kubernetes (k8s)

---

## 🔌 Port Configuration & Environment Setup

| Component / Service | Default Port | Protocol / Description |
| :--- | :--- | :--- |
| **Front-End Portal** | `5173` | Vue.js Development Server (Vite) |
| **Back-End Service** | `8080` | Spring Boot Application Server |
| **Kafka Broker** | `9092` | Apache Kafka Messaging Service |
| **MySQL Database** | `3306` | Persistent Relational Store |

---

## 💻 Local Getting Started

### Prerequisites
* Java Development Kit (JDK 11+)
* Node.js (v16+) & npm
* Apache Kafka Server & Zookeeper / KRaft
* MySQL Server 8.0+
* Docker Desktop

---

### 1. Database & Kafka Setup

Create the target database in MySQL:

```sql
CREATE DATABASE enterprise_system_db;
```

Configure backend parameters in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/enterprise_system_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=enterprise-dashboard-group
```

---

### 2. Start Kafka Cluster (Local / Docker)

Using Docker Compose or standalone binaries, start the Kafka broker on port `9092`:

```bash
# Start Zookeeper and Kafka Broker via Docker Desktop
docker run -d --name zookeeper -p 2181:2181 zookeeper
docker run -d --name kafka -p 9092:9092 --link zookeeper:zookeeper -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka
```

---

### 3. Build and Run Backend

Start the Spring Boot backend server:

```bash
# Clone the repository
git clone https://github.com/your-username/enterprise-system-dashboard.git
cd enterprise-system-dashboard

# Build and execute Spring Boot service
./mvnw clean spring-boot:run
```

Backend API will start on `http://localhost:8080`.

---

### 4. Build and Run Frontend

Launch the VueJS frontend application:

```bash
cd frontend

# Install node dependencies
npm install

# Start development server
npm run dev
```

VueJS web dashboard will be available at `http://localhost:5173`.

---

## 🚀 Cloud & Container Deployment

1. **Docker Containerization:** Dockerfile configs generate isolated container images for VueJS client, Spring Boot backend, and Kafka infrastructure.
2. **Kubernetes Deployment:** StatefulSet and Deployment manifests orchestrate Kafka nodes, application pods, and persistent volume claims on AWS Kubernetes clusters.