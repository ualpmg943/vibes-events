<div align="center">

# 🎧 Vibes Events

<img src="https://img.shields.io/badge/Status-En%20Desarrollo-gold?style=for-the-badge" />
<img src="https://img.shields.io/badge/Versión-1.0.0-black?style=for-the-badge" />

**Plataforma web corporativa e integral de reservas para eventos de sonido, iluminación y DJ.**

***

### 🧱 Stack Tecnológico

<!-- Frontend -->
<img src="https://img.shields.io/badge/Astro-FF5D01?style=for-the-badge&logo=astro&logoColor=white" />
<img src="https://img.shields.io/badge/TailwindCSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white" />
<img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white" />

<!-- Backend -->
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
<img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" />
<img src="https://img.shields.io/badge/JPA%20%2F%20Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />

<!-- Base de datos -->
<img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />

<!-- Integraciones -->
<img src="https://img.shields.io/badge/Formspree-ED4245?style=for-the-badge&logo=formspree&logoColor=white" />

<!-- DevOps / Herramientas -->
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />

</div>

***

## 📋 Descripción del Proyecto

**Vibes Events** es una aplicación web corporativa desarrollada para **Javi Berenguel**, DJ y empresario especializado en eventos de sonido e iluminación. La plataforma combina una web de presentación de marca personal con un sistema completo de gestión y reservas de eventos.

El sistema permite a los clientes:
- Consultar la disponibilidad del artista mediante un **calendario interactivo** en tiempo real.
- Seleccionar la fecha del evento y configurar **servicios adicionales** (cachimbas, horas extra, equipos especiales, etc.).
- Completar el proceso de reserva mediante un formulario que conecta directamente con el backend.
- Contactar con el equipo a través de un formulario integrado con **Formspree**.

***

## 🗂️ Estructura del Proyecto

```
vibes-events/
├── frontend/               # Proyecto Astro (Web estática + Islas React)
│   ├── src/
│   │   ├── components/     # Componentes Astro y React (Calendario, Extras, etc.)
│   │   ├── layouts/        # Layouts base de la web
│   │   ├── pages/          # Rutas: inicio, DJ, reservas, contacto
│   │   └── styles/         # Configuración global de Tailwind CSS
│   └── astro.config.mjs
│
└── backend/                # Proyecto Spring Boot (API REST)
    └── src/main/java/
        ├── controller/     # Endpoints REST (@RestController)
        ├── service/        # Lógica de negocio
        ├── repository/     # Interfaces JPA
        ├── entity/         # Entidades JPA (Reserva, Extra, etc.)
        └── dto/            # Data Transfer Objects
```

***

## 🌐 Secciones de la Web

| Sección | Descripción |
|---|---|
| 🏠 **Hero / Inicio** | Presentación impactante con identidad visual de la marca |
| 📅 **Reservas** | Calendario interactivo conectado a la API, selección de extras y formulario de reserva |
| 🎧 **DJ** | Biografía, próximos bolos, vídeos y audios de actuaciones |
| ✉️ **Contacto** | Formulario estilizado integrado con Formspree |

***

## ⚙️ Configuración y Arranque

### Requisitos previos
- Node.js >= 18
- Java >= 17
- PostgreSQL activo (o Docker)

### Frontend

```bash
cd frontend
npm install
npm run dev       # http://localhost:4321
```

### Backend

```bash
cd backend
# Configura application.properties con tus credenciales de PostgreSQL
./mvnw spring-boot:run   # http://localhost:8080
```

> ⚠️ **CORS**: El backend está configurado para aceptar peticiones desde `http://localhost:4321` en entorno de desarrollo.

***

## 🔌 Variables de Entorno

### Backend — `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vibes_events
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### Frontend — `.env`

```env
PUBLIC_API_URL=http://localhost:8080/api
PUBLIC_FORMSPREE_ID=TU_ID_FORMSPREE
```

***

<div align="center">

<a href="https://github.com/ualpmg943">
  <img src="https://img.shields.io/badge/Pablo%20Martínez%20Gálvez-%40ualpmg943-181717?style=for-the-badge&logo=github&logoColor=white" />
</a>

<sub>Ingeniería Informática · Universidad de Almería</sub>

<br/>

<sub>🎧 <strong>Vibes Events</strong> &nbsp;·&nbsp; Almería, España &nbsp;·&nbsp; © 2026 · Todos los derechos reservados</sub>

</div>
