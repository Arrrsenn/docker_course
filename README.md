# User Management API

- [English](#-english)
- [Русский](#-русский)

---

<a name="english"></a>
## 🇬🇧 English

### 📝 Description

A REST API service for user management built with **Spring Boot** and deployed on **Kubernetes**. This is an educational project demonstrating modern microservices architecture, containerization, and orchestration practices.

**Tech Stack:**
- **Backend:** Java 17, Spring Boot 3.4.1, Spring Data JPA
- **Database:** PostgreSQL 18
- **Database Migrations:** Liquibase
- **Containerization:** Docker (multi-stage builds)
- **Orchestration:** Kubernetes (minikube)
- **Infrastructure:** StatefulSets, Services (ClusterIP, NodePort, Headless), Ingress, PersistentVolumes

**Features:**
- RESTful API for user CRUD operations
- Database persistence with PostgreSQL
- Automated schema migrations with Liquibase
- Health check endpoint
- Kubernetes deployment with probes (startup, readiness, liveness)
- Ingress configuration for domain-based routing

---

### 🛠 Prerequisites

Ensure you have the following tools installed:

- **Docker** (v20.10+)
- **Kubernetes CLI (kubectl)** (v1.27+)
- **Minikube** (v1.30+)
- **Java** 17+ (for local development)
- **Maven** 3.9+ (for local development)

---

### 🚀 Quick Start

#### 1. Build Docker Image

```bash
# Navigate to project root
cd /path/to/project

# Build Docker image
docker build -t my-app:1.0.0 .

# Load image into minikube
minikube image load my-app:1.0.0
```

#### 2. Deploy to Kubernetes

```bash
# Start minikube cluster
minikube start

# Enable Ingress addon
minikube addons enable ingress

# Apply Kubernetes manifests
kubectl apply -f k8s/

# Check deployment status
kubectl get pods
kubectl get services
kubectl get ingress
```

#### 3. Configure Local Access

Add the following entry to `/etc/hosts` (Linux/Mac) or `C:\Windows\System32\drivers\etc\hosts` (Windows):

```
<minikube-ip>  my-app.local
```

Get minikube IP:
```bash
minikube ip
```

---

### 📡 API Examples

**Base URL:** `http://my-app.local`

#### Create User
```bash
curl -X POST "http://my-app.local/users?name=Ivan"
```

#### Get User by ID
```bash
curl -X GET "http://my-app.local/users/info?id=3a7822ce-d466-44a4-8c97-453b9448a1b7"
```

#### Get All Users
```bash
curl -X GET "http://my-app.local/users" | jq
```

#### Health Check
```bash
curl -X GET "http://my-app.local/healthcheck"
```

**Expected Response:**
```json
{
  "success": true
}
```

---

### 🗄️ Database Access

Connect to PostgreSQL from your local machine:

```bash
# Get minikube IP
MINIKUBE_IP=$(minikube ip)

# Connect via psql
psql -h $MINIKUBE_IP -p 30001 -U postgres -d postgres
```

**Credentials:**
- Username: `postgres`
- Password: `postgres123`
- Database: `postgres`

---

### 🧹 Cleanup

```bash
# Delete all Kubernetes resources
kubectl delete -f k8s/

# Stop minikube
minikube stop

# Delete minikube cluster (optional)
minikube delete
```

---

### 📚 Project Structure

```
.
├── app-api/          # REST Controllers
├── app-main/         # Application entry point
├── app-repository/   # Data access layer, Liquibase migrations
├── app-service/      # Business logic layer
├── k8s/              # Kubernetes manifests
├── Dockerfile        # Multi-stage Docker build
└── pom.xml           # Maven parent POM
```

---

### 🎯 Learning Objectives

This project demonstrates:
- Multi-module Maven project structure
- Docker multi-stage builds for optimization
- Kubernetes StatefulSet for stateful applications (PostgreSQL)
- Persistent storage with PersistentVolumeClaims
- Service types: ClusterIP, NodePort, Headless
- Ingress for HTTP routing
- Startup, Readiness, and Liveness Probes
- Database schema versioning with Liquibase

---

<a name="russian"></a>
## 🇷🇺 Русский

### 📝 Описание

REST API сервис для управления пользователями, построенный на **Spring Boot** и развернутый в **Kubernetes**. Это учебный проект, демонстрирующий современные практики микросервисной архитектуры, контейнеризации и оркестрации.

**Технологический стек:**
- **Backend:** Java 17, Spring Boot 3.4.1, Spring Data JPA
- **База данных:** PostgreSQL 18
- **Миграции БД:** Liquibase
- **Контейнеризация:** Docker (многоступенчатая сборка)
- **Оркестрация:** Kubernetes (minikube)
- **Инфраструктура:** StatefulSets, Services (ClusterIP, NodePort, Headless), Ingress, PersistentVolumes

**Функциональность:**
- RESTful API для CRUD операций с пользователями
- Персистентное хранение данных в PostgreSQL
- Автоматические миграции схемы БД через Liquibase
- Endpoint для проверки здоровья приложения
- Развертывание в Kubernetes с пробами (startup, readiness, liveness)
- Настройка Ingress для маршрутизации по доменному имени

---

### 🛠 Требования

Убедитесь, что установлены следующие инструменты:

- **Docker** (v20.10+)
- **Kubernetes CLI (kubectl)** (v1.27+)
- **Minikube** (v1.30+)
- **Java** 17+ (для локальной разработки)
- **Maven** 3.9+ (для локальной разработки)

---

### 🚀 Быстрый старт

#### 1. Сборка Docker образа

```bash
# Перейдите в корень проекта
cd /путь/к/проекту

# Соберите Docker образ
docker build -t my-app:1.0.0 .

# Загрузите образ в minikube
minikube image load my-app:1.0.0
```

#### 2. Развертывание в Kubernetes

```bash
# Запустите minikube кластер
minikube start

# Включите Ingress addon
minikube addons enable ingress

# Примените Kubernetes манифесты
kubectl apply -f k8s/

# Проверьте статус развертывания
kubectl get pods
kubectl get services
kubectl get ingress
```

#### 3. Настройка локального доступа

Добавьте следующую запись в `/etc/hosts` (Linux/Mac) или `C:\Windows\System32\drivers\etc\hosts` (Windows):

```
<minikube-ip>  my-app.local
```

Получите IP minikube:
```bash
minikube ip
```

---

### 📡 Примеры API запросов

**Базовый URL:** `http://my-app.local`

#### Создание пользователя
```bash
curl -X POST "http://my-app.local/users?name=Ivan"
```

#### Получение пользователя по ID
```bash
curl -X GET "http://my-app.local/users/info?id=3a7822ce-d466-44a4-8c97-453b9448a1b7"
```

#### Получение всех пользователей
```bash
curl -X GET "http://my-app.local/users" | jq
```

#### Проверка здоровья
```bash
curl -X GET "http://my-app.local/healthcheck"
```

**Ожидаемый ответ:**
```json
{
  "success": true
}
```

---

### 🗄️ Доступ к базе данных

Подключение к PostgreSQL с локальной машины:

```bash
# Получите IP minikube
MINIKUBE_IP=$(minikube ip)

# Подключитесь через psql
psql -h $MINIKUBE_IP -p 30001 -U postgres -d postgres
```

**Учетные данные:**
- Имя пользователя: `postgres`
- Пароль: `postgres123`
- База данных: `postgres`

---

### 🧹 Очистка

```bash
# Удалите все Kubernetes ресурсы
kubectl delete -f k8s/

# Остановите minikube
minikube stop

# Удалите minikube кластер (опционально)
minikube delete
```

---

### 📚 Структура проекта

```
.
├── app-api/          # REST контроллеры
├── app-main/         # Точка входа приложения
├── app-repository/   # Слой доступа к данным, Liquibase миграции
├── app-service/      # Слой бизнес-логики
├── k8s/              # Kubernetes манифесты
├── Dockerfile        # Многоступенчатая сборка Docker
└── pom.xml           # Родительский Maven POM
```

---

### 🎯 Цели обучения

Этот проект демонстрирует:
- Структуру многомодульного Maven проекта
- Многоступенчатую сборку Docker для оптимизации
- Kubernetes StatefulSet для stateful приложений (PostgreSQL)
- Персистентное хранилище с PersistentVolumeClaims
- Типы сервисов: ClusterIP, NodePort, Headless
- Ingress для HTTP маршрутизации
- Startup, Readiness и Liveness Probes
- Версионирование схемы БД с Liquibase

---

### 📄 License

This project is for educational purposes.

### 👤 Author

Arsen Alevorian

- GitHub: https://github.com/Arrrsenn
- Linkedin: https://www.linkedin.com/in/arsen-alevorian-0485b1255


---

**Note:** This is a learning project demonstrating Kubernetes and containerization skills. Not intended for production use.