# 🌟 My Professional Portfolio

<p align="center">
  <img src="src/main/resources/static/images/banner_codigo.jpg" alt="Banner" width="100%" style="border-radius: 10px;">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" alt="Thymeleaf">
  <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white" alt="Bootstrap">
</p>

---

## 👤 Sobre el Proyecto
Este es un sistema de gestión de perfil profesional desarrollado como una aplicación web completa. Utiliza una arquitectura **MVC (Modelo-Vista-Controlador)** para ofrecer una experiencia dinámica donde el usuario puede administrar su marca personal.



### ✨ Características Principales
* **Diseño LinkedIn Premium:** Estética moderna con banner neón y foto de perfil integrada.
* **Gestión de Datos:** CRUD completo para Experiencias, Estudios y Proyectos.
* **Relación Muchos-a-Muchos:** Los proyectos están vinculados dinámicamente con lenguajes de programación.
* **Animaciones Avanzadas:** Efectos de hover y transiciones suaves en toda la interfaz.

---

## 🛠️ Stack Tecnológico

| Área | Tecnología |
| :--- | :--- |
| **Lenguaje** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **Base de Datos** | MySQL |
| **Motor de Vistas** | Thymeleaf |
| **Frontend** | Bootstrap 5 & CSS3 |
| **Iconos** | FontAwesome 6 |

---

## ⚙️ Configuración Rápida

### 1. Preparar la Base de Datos
Crea el esquema en tu servidor MySQL (XAMPP o Workbench):
```sql
-- 1. Crear la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS portfolio;
USE portfolio;

-- 2. Tabla de Información Personal
CREATE TABLE info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    email VARCHAR(100),
    telefono VARCHAR(20),
    linkedin VARCHAR(255),
    github VARCHAR(255),
    foto_url VARCHAR(255)
);

-- 3. Tabla de Lenguajes de Programación
CREATE TABLE lenguaje (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
);

-- 4. Tabla de Experiencia Laboral
CREATE TABLE experiencia (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    puesto VARCHAR(100) NOT NULL,
    empresa VARCHAR(100),
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE -- Puede ser NULL si es el trabajo actual
);

-- 5. Tabla de Formación Académica
CREATE TABLE estudios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    institucion VARCHAR(100),
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE
);

-- 6. Tabla de Proyectos
CREATE TABLE proyecto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    github_url VARCHAR(255),
    imagen_url VARCHAR(255)
);

-- 7. Tabla Intermedia (Relación Muchos a Muchos entre Proyecto y Lenguaje)
-- Esta tabla une qué lenguajes se usaron en cada proyecto
CREATE TABLE proyecto_lenguajes (
    proyecto_id BIGINT NOT NULL,
    lenguajes_id BIGINT NOT NULL,
    PRIMARY KEY (proyecto_id, lenguajes_id),
    CONSTRAINT fk_proyecto FOREIGN KEY (proyecto_id) REFERENCES proyecto(id) ON DELETE CASCADE,
    CONSTRAINT fk_lenguaje FOREIGN KEY (lenguajes_id) REFERENCES lenguaje(id) ON DELETE CASCADE
);
```

### 2. Datos de prueba en data.sql
