<p align="center">
  <img src="docker_logo.png" alt="web home" width="300"/>
</p>

# MBC Laboratory Week 1 by Veiron Vaya Yarief 

# Table of Contents
- [MBC Laboratory Week 1 by Veiron Vaya Yarief](#mbc-laboratory-week-1-by-veiron-vaya-yarief)
- [Table of Contents](#table-of-contents)
  - [1. Docker Facts](#1-docker-facts)
    - [1. Difference between running on Compose and Stack](#1-difference-between-running-on-compose-and-stack)
      - [1.1. Communication](#11-communication)
      - [1.2. Features](#12-features)
    - [2. Redis cache on Compose and Stack](#2-redis-cache-on-compose-and-stack)
    - [3. What happend to cache data if Redis container deleted?](#3-what-happend-to-cache-data-if-redis-container-deleted)
    - [4. Docker Compose on Docker Swarm](#4-docker-compose-on-docker-swarm)
  - [2. Project Structure](#2-project-structure)
  - [3. Architecture \& System-Flow](#3-architecture--system-flow)
    - [3.1. Architecture](#31-architecture)
      - [3.1.1 Backend](#311-backend)
      - [3.1.2. Frontend](#312-frontend)
      - [3.1.3. Docker](#313-docker)
    - [3.2. System-FLow](#32-system-flow)
  - [3. Development Process](#3-development-process)

## 1. Docker Facts

### 1. Difference between running on Compose and Stack

There is some important aspect to look through this topic

#### 1.1. Communication

  - Compose is a simple multi-container orchestration where the containers communicate with eachother by exposing their port in the same network using **bridge** type network. 
  - While Stack is a complex multi-container orchestration where containers communicate with eachother using **overlay** network, this enable multiple node and their own purpose on the schema.

#### 1.2. Features 

  - Swarm give better orchestration on another level, like making replicas and how large system communicate through **overlay** netwrok.
  - Docker secrets can only be utilize in swarm mode, because it stored the password encrypted in one file under /run/secrets. 


### 2. Redis cache on Compose and Stack

  Redis as a storage and in this application we can simplify it as caching, where it store data in RAM, theres nothing difference between the functionality but in swarm redis can work accross multiple node and the redis password can be stored in docker secrets.

### 3. What happend to cache data if Redis container deleted?

  When we use Redis it will store data in RAM, when we delete the container the memory is released and cache data gone also when we shutdown the computer because its volatile or in this application when we hit `POST API` because it will do `CacheEvict` where it will delete invalid cache.

### 4. Docker Compose on Docker Swarm

  Docker swarm deploy is using `compile.yaml` file and docker auto read these files so, Docer Compose is Utilized in Swarm mode.

## 2. Project Structure

```
MBC_WEEK1/
├── backend/                          # Spring Boot Backend
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/.../
│   │       │   ├── controller/       # Controllers (handle HTTP requests)
│   │       │   ├── dto/              # Data Transfer Objects
│   │       │   ├── entity/           # JPA Entities (models)
│   │       │   ├── mapper/           # Mappers for DTO <-> Entity
│   │       │   ├── repository/       # Spring Data JPA Repositories
│   │       │   ├── security/         # Security configuration (JWT, etc.)
│   │       │   ├── service/          # Business logic
│   │       │   └── BackendApplication.java # Main Spring Boot app
│   │       └── resources/
│   │           ├── database/
│   │           │   ├── dummy.sql     # Sample SQL data
│   │           │   └── schema.sql    # Schema definition
│   │           └── application.yaml  # Spring Boot config
│   ├── target/                       # Build output directory
│   ├── pom.xml                       # Maven build file
│   └── Dockerfile                    # Dockerfile for backend
│
├── docker/                           # Docker and Redis config
│   ├── redis/
│   │   ├── redis.conf                # Redis configuration
│   │   └── secrets/                  # Sensitive data for docker secrets
│   └── docker-compose.yml            # Compose file for services
│
├── frontend/                         # React-based frontend
│   ├── src/
│   │   ├── components/               # UI components
│   │   ├── layouts/                  # Layout components (navbar, footer)
│   │   ├── pages/                    # Page views
│   │   ├── App.jsx                   # Main App component
│   │   ├── index.js                  # Entry point
│   ├── Dockerfile                    # Dockerfile for frontend
│   ├── tailwind.config.js           # Tailwind configuration
│   └── package.json                 # NPM dependencies
|
└── README.md                        # Project overview

```

## 3. Architecture & System-Flow

### 3.1. Architecture

![alt text](mbc_week1-architecture.drawio.png)

#### 3.1.1 Backend 

- Springboot: Clean and clear backend code with tools that help backend development, and support contenarization so does docker secrets using: `spring.config.import:optional:configtree:/run/secrets/`. and utilize greate cache manager combine with Redis.

- MySQL: Basic RDMS to handle data process and storage.
- Redis: Caching storage.

#### 3.1.2. Frontend

- React Js: Familiarization javascript interface.

#### 3.1.3. Docker

- Containerization: Wrap an application into a container.
- Compose: Run multiple container.
- Swarm/Stack: Orchestrate multiple container and nodes.
- Secrets: Help securing data with keep the credential hidden.

### 3.2. System-FLow 

![alt text](architecture.png)


## 3. Development Process

![alt text](mbc_week1-development_process.drawio.png)

- Start with architecteru design that thinks about many aspect and create architecture design and the system flow
- Develop backend with clean code and security consideration using REST API, configuration with redis and mysql for data storage.
- Develop frontend for ui and human interaction.
- Contenarization backend springboot and react frontend using dockerfile.
- Make `compose.yaml` on root directory to run multiple container (backend,mysql,redis).
- Activate SWARM mode to manage multiple node and service.
- Implement docker secrets. 








