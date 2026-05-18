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
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />

</div>

***

## 📋 Descripción del Proyecto

**Vibes Events** es una aplicación web corporativa desarrollada para **Javi Berenguel**, DJ profesional y empresario especializado en eventos de sonido, iluminación y entretenimiento. La plataforma combina una web de presentación de marca personal con un sistema completo de gestión y reservas de eventos en tiempo real.

### Objetivo de Negocio

1. **Vitrina digital profesional** que comunique la marca personal y el portafolio artístico del DJ.
2. **Sistema de reservas** que automatice la gestión de fechas, servicios adicionales y clientes, eliminando la dependencia de canales informales (WhatsApp, teléfono).
3. **Panel de administración** seguro y funcional desde el que gestionar reservas, fechas bloqueadas y mensajes de contacto.

### Audiencia

- **Clientes:** Personas físicas o empresas que contratan servicios para su evento. No requieren registro explícito; su identidad se crea automáticamente al formalizar una reserva.
- **Administrador:** El DJ o su equipo, con acceso completo al panel de gestión.

***

## 🧱 Stack Tecnológico Detallado

| Frontend | Backend | DevOps |
|---|---|---|
| **Astro 4.x** — Framework principal, generación estática + SSR parcial | **Java 17+** / **Spring Boot 3.x** — API REST | **Docker** + **Docker Compose** — Contenerización completa |
| **Tailwind CSS 3.x** — Utilitarios de estilo | **Spring Security** — Autenticación JWT del panel admin | **Git + GitHub** — Control de versiones |
| **TypeScript 5.x** — Tipado estático | **Spring Data JPA + Hibernate** — Persistencia / ORM | |
| **React 18.x** — Islas interactivas (Calendario, Wizard de Reservas) | **Jakarta Validation** — Validación de DTOs | |
| **Formspree** — Gestión del formulario de contacto | **Maven** — Gestión de dependencias | |

> **Principio de Astro Islands:** React se usa exclusivamente para componentes que requieren estado del cliente en tiempo real: `BookingCalendar` y el flujo `BookingWizard`. El resto de la web son páginas y componentes Astro estáticos.

***

## 🗂️ Arquitectura General

```
vibes-events/
├── docker-compose.yml           ← Orquestación completa (PostgreSQL + Backend + Frontend)
├── AGENTS.md
├── README.md
├── .gitignore
│
├── frontend/                    ← Proyecto Astro
│   ├── Dockerfile               ← Multi-stage: build Astro + Nginx
│   ├── astro.config.mjs
│   ├── tailwind.config.mjs
│   ├── tsconfig.json
│   ├── package.json
│   └── src/
│       ├── components/          ← Componentes Astro reutilizables
│       │   ├── Header.astro
│       │   ├── Footer.astro
│       │   ├── dj/              ← Componentes de la sección DJ
│       │   ├── booking/         ← Islas React: BookingCalendar, ExtrasSelector, BookingForm
│       │   └── admin/           ← Componentes del panel de administración
│       ├── layouts/
│       │   ├── BaseLayout.astro
│       │   └── AdminLayout.astro
│       ├── pages/
│       │   ├── index.astro      ← Hero / Inicio
│       │   ├── dj.astro         ← Sección DJ (informativa)
│       │   ├── reservas.astro   ← Flujo de reservas (contiene isla React)
│       │   ├── contacto.astro   ← Formulario Formspree
│       │   └── admin/
│       │       ├── index.astro  ← Dashboard del administrador
│       │       ├── reservas.astro ← CRUD de reservas
│       │       └── contactos.astro ← CRUD de mensajes de contacto
│       └── styles/
│           └── global.css
│
└── backend/                     ← Proyecto Spring Boot
    ├── Dockerfile               ← Multi-stage: build Maven + JRE slim
    ├── pom.xml
    └── src/main/java/com/vibesevents/
        ├── VibesEventsApplication.java
        ├── config/              ← CORS, Security, beans globales
        ├── controller/          ← @RestController: endpoints REST públicos y admin
        ├── service/             ← Lógica de negocio e interfaces
        │   └── impl/            ← Implementaciones de los servicios
        ├── repository/          ← Interfaces JPA (@Repository)
        ├── entity/              ← Entidades JPA (@Entity)
        ├── dto/                 ← Data Transfer Objects (Request/Response)
        ├── exception/           ← Excepciones personalizadas y @ControllerAdvice
        └── util/                ← Utilidades transversales (mappers, constantes)
```

***

## 💾 Modelo de Base de Datos

### Entidades Principales

| Entidad | Campos clave | Descripción |
|---|---|---|
| **Usuario** | `id (UUID)`, `email`, `nombre`, `telefono`, `createdAt` | Cliente sin registro explícito. Se crea automáticamente al confirmar una reserva. Si el email ya existe, se asocia la reserva al usuario existente. |
| **Reserva** | `id (UUID)`, `usuarioId (FK)`, `fechaEvento`, `lugarEvento`, `horasContratadas`, `estado (ENUM)`, `motivoCancelacion`, `precioTotal`, `notas`, `createdAt`, `updatedAt` | Solicitud de contratación con fecha, servicios y estado (`PENDIENTE`, `CONFIRMADA`, `CANCELADA`). |
| **Extra** | `id`, `reservaId (FK)`, `tipo`, `descripcion`, `precioUnitario`, `cantidad` | Servicio adicional vinculado a una reserva (cachimbas, horas extra, equipo especial, etc.). |
| **MensajeContacto** | `id (UUID)`, `nombre`, `email`, `telefono`, `asunto`, `mensaje`, `leido (boolean)`, `createdAt` | Registro generado al enviar el formulario de contacto. Almacenado en BD para el historial del administrador. |
| **Admin** | `id`, `username`, `passwordHash`, `email`, `rol` | Entidad independiente gestionada por Spring Security. Nunca se expone `passwordHash` en ningún DTO. |

> **Estados de Reserva:** `PENDIENTE` → `CONFIRMADA` → `CANCELADA`

***

## 🌐 API REST

Prefijo base: `/api`

### Reservas (Públicas)

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/reservas/disponibilidad` | Fechas bloqueadas y reservadas del mes indicado (`?mes=YYYY-MM`) |
| `POST` | `/api/reservas` | Crear reserva (valida email, crea usuario si no existe) |
| `GET` | `/api/reservas/{id}` | Consultar estado de reserva (por ID y email, sin autenticación) |

### Reservas (Admin — autenticado)

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/admin/reservas` | Listar reservas (paginadas, filtrables) |
| `GET` | `/api/admin/reservas/{id}` | Detalle completo de una reserva |
| `PATCH` | `/api/admin/reservas/{id}/cancelar` | Cancelar reserva con motivo obligatorio |
| `PUT` | `/api/admin/reservas/{id}` | Actualizar datos de una reserva |
| `DELETE` | `/api/admin/reservas/{id}` | Eliminar reserva (solo en estado `CANCELADA`) |

### Días No Disponibles (Admin)

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/admin/bloques` | Listar días marcados como no disponibles |
| `POST` | `/api/admin/bloques` | Marcar un día como no disponible |
| `DELETE` | `/api/admin/bloques/{fecha}` | Liberar un día bloqueado manualmente |

### Mensajes de Contacto (Admin)

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/admin/contactos` | Listar mensajes (paginados, filtro leído/no leído) |
| `GET` | `/api/admin/contactos/{id}` | Detalle de un mensaje |
| `PATCH` | `/api/admin/contactos/{id}/leer` | Marcar mensaje como leído |
| `DELETE` | `/api/admin/contactos/{id}` | Eliminar mensaje |

### Autenticación (Admin)

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/api/auth/login` | Login del administrador; devuelve JWT |
| `POST` | `/api/auth/logout` | Invalida el token activo |

### Estadísticas (Admin — Dashboard)

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/admin/stats` | KPIs: reservas del mes, ingresos estimados, mensajes no leídos, próximas fechas |

***

## 🔐 Panel de Administración

El panel de administración está accesible bajo `/admin/*`. No hay registro público; las credenciales se gestionan directamente en base de datos.

### Estructura

| Ruta | Descripción |
|---|---|
| `/admin/` | Dashboard con KPIs + Calendario interactivo |
| `/admin/reservas` | CRUD completo de reservas (tabla paginada, filtros, edición en modal) |
| `/admin/contactos` | CRUD de mensajes de contacto con badge de no leídos |

### Activity Bar (Sidebar)

Navegación tipo VS Code / Linear en el lado izquierdo:

- Dashboard, Reservas, Contactos con icono + label
- Badge numérico en "Contactos" si hay mensajes no leídos
- Estado activo con acento dorado
- Colapsable en pantallas medianas/pequeñas

### Dashboard (`/admin/`)

- **KPIs:** Reservas del mes, ingresos estimados, próximo evento, mensajes sin leer
- **Calendario interactivo:** Días marcados como `RESERVADO` (dorado), `BLOQUEADO_ADMIN` (rojo/zinc), `DISPONIBLE` (neutro)
  - Click en día reservado → Modal con info de reserva + opción de cancelar
  - Click en día disponible → Opción de marcar como no disponible
  - Click en día bloqueado → Opción de liberar día
- **Últimas reservas:** Tabla con las 5 reservas más recientes

### Seguridad

- JWT almacenado en `httpOnly cookie` (no en `localStorage`)
- Spring Security protege todos los endpoints `/api/admin/**` con rol `ROLE_ADMIN`
- Las cuentas de administrador se crean directamente en base de datos o mediante script de inicialización

***

## 📅 Flujo de Reserva (Cliente)

El flujo de reserva en `/reservas` es un **wizard de 3 pasos** implementado como isla React:

```
Paso 1: Selección de fecha
  └─ Calendario interactivo conectado a GET /api/reservas/disponibilidad
  └─ Días bloqueados no seleccionables

Paso 2: Configuración del evento
  └─ Selección de extras (cachimbas, horas extra, equipo especial, etc.)
  └─ Descripción del evento, lugar, hora de inicio
  └─ Resumen de precio en tiempo real

Paso 3: Datos del cliente y confirmación
  └─ Nombre, email, teléfono
  └─ Aceptación de términos
  └─ Envío a POST /api/reservas
  └─ Confirmación visual con número de reserva
```

***

## 🌐 Secciones de la Web Pública

| Página | Ruta | Tipo | Descripción |
|---|---|---|---|
| Hero / Inicio | `/` | Estática (Astro) | Presentación con tagline, servicios clave, CTA a Reservas |
| Sección DJ | `/dj` | Estática (Astro) | Biografía, próximos bolos, galería de fotos, vídeos/audios |
| Reservas | `/reservas` | Isla React | Calendario + wizard de reserva conectado al backend |
| Contacto | `/contacto` | Estática (Astro) | Formulario integrado con Formspree |

***

## 🎨 Diseño Visual

| Elemento | Especificación |
|---|---|
| **Estilo general** | Minimalista, inspirado en ecosistema Apple. Limpio, sin ruido visual. |
| **Fondo principal** | `zinc-950` / `#09090b` (negro profundo) |
| **Texto principal** | `zinc-100` |
| **Color acento** | Dorado (`#D4AF37`) — usado en CTAs, bordes destacados, iconos clave. Nunca como fondo dominante. |
| **Glassmorphism** | Tarjetas, modales y navbars con `backdrop-blur`, fondo semitransparente (`bg-white/5` o `bg-zinc-900/60`) y borde sutil (`border border-white/10`) |
| **Radios de borde** | `rounded-2xl` (16px) en tarjetas, `rounded-3xl` (24px) en elementos grandes, `rounded-full` en badges y botones pill |
| **Tipografía headings** | Fuente serif con personalidad (Playfair Display, Cormorant Garamond o similar) |
| **Tipografía cuerpo** | Fuente sans-serif limpia (Inter, Satoshi) |
| **Sombras** | Profundidad sutil, tono cálido/dorado en hover de elementos interactivos primarios |

> **Restricciones:** No usar gradientes de colores vivos en botones. No usar bordes laterales de color sólido en tarjetas. El texto de cuerpos y cards debe estar alineado a la izquierda, nunca centrado.

***

## 🐳 Contenerización Docker

La aplicación se levanta completamente con un único comando:

```bash
docker compose up
```

### Servicios

| Servicio | Imagen | Depende de |
|---|---|---|
| `db` | PostgreSQL | — |
| `backend` | Spring Boot (JRE slim) | `db` |
| `frontend` | Nginx sirviendo Astro estático | `backend` |

Los archivos clave:
- `docker-compose.yml` — Orquesta los tres servicios
- `frontend/Dockerfile` — Multi-stage: build Node.js + Nginx
- `backend/Dockerfile` — Multi-stage: build Maven + JRE slim

> Las variables de entorno sensibles (`DB_PASSWORD`, `JWT_SECRET`) se gestionan mediante `.env` en la raíz, nunca hardcodeadas. Se provee `.env.example` como plantilla. Los contenedores incluyen healthchecks y volumen persistente para PostgreSQL.

### Comandos

```bash
docker compose up          # Iniciar la aplicación
docker compose up -d       # Iniciar en segundo plano
docker compose stop        # Apagar sin destruir datos
docker compose down        # Apagar y limpiar recursos
```

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

### Docker

```bash
docker compose up --build -d
# Frontend: http://localhost:80
# Backend:  http://localhost:8080/api
# Admin:    http://localhost:80/admin
```

> ⚠️ **CORS**: El backend está configurado para aceptar peticiones desde `http://localhost:4321` en desarrollo y desde el servicio `frontend` de Docker en producción.

***

## 🔌 Variables de Entorno

| Variable | Servicio | Descripción |
|---|---|---|
| `DB_HOST` | backend | Host de PostgreSQL |
| `DB_PORT` | backend | Puerto de PostgreSQL |
| `DB_NAME` | backend | Nombre de la base de datos |
| `DB_USERNAME` | backend | Usuario de BD |
| `DB_PASSWORD` | backend | Contraseña de BD |
| `JWT_SECRET` | backend | Clave secreta para firmar tokens JWT (mín. 256 bits) |
| `JWT_EXPIRATION_MS` | backend | Duración del token en milisegundos |
| `PUBLIC_API_URL` | frontend | URL base de la API |
| `PUBLIC_FORMSPREE_ID` | frontend | ID del formulario Formspree |

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

## 🏗️ Buenas Prácticas Arquitectónicas (Backend)

### Capas

```
Controller (@RestController)
    ↓ recibe DTOs de Request, devuelve DTOs de Response
Service (interfaz + implementación)
    ↓ lógica de negocio, transacciones (@Transactional)
Repository (JPA interface)
    ↓ acceso a datos
Entity (@Entity)
```

- Los controllers no acceden al Repository directamente. Siempre pasan por el Service.
- Las entities no se devuelven directamente en respuestas HTTP. Siempre se mapean a DTOs.
- Los DTOs de Request se validan con anotaciones Jakarta Validation (`@NotBlank`, `@Email`, `@Future`, etc.) y `@Valid` en el parámetro del controller.

### Manejo de Errores

- `@ControllerAdvice` global (`GlobalExceptionHandler`) centraliza todas las excepciones.
- Excepciones de dominio personalizadas (`ReservaNotFoundException`, `FechaNoDisponibleException`, etc.).
- Respuestas de error con DTO `ErrorResponse` (timestamp, status, error, message). Nunca se devuelve stack trace al cliente.

### CORS

- Configurado como `@Bean` de `WebMvcConfigurer` en `config/CorsConfig.java`.
- En desarrollo: permite `http://localhost:4321` (Astro dev server).
- En producción (Docker): permite el origen del servicio frontend según URL configurada en `.env`.

***

## 📁 Estructura del Proyecto (Resumen)

```
vibes-events/
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Header.astro
│   │   │   ├── Footer.astro
│   │   │   ├── dj/
│   │   │   ├── booking/     ← Islas React
│   │   │   └── admin/
│   │   ├── layouts/
│   │   ├── pages/
│   │   │   ├── index.astro
│   │   │   ├── dj.astro
│   │   │   ├── reservas.astro
│   │   │   ├── contacto.astro
│   │   │   └── admin/
│   │   └── styles/
│   ├── Dockerfile
│   └── astro.config.mjs
│
├── backend/
│   ├── src/main/java/com/vibesevents/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── service/
│   │   │   └── impl/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── exception/
│   │   └── util/
│   ├── Dockerfile
│   └── pom.xml
│
├── docker-compose.yml
└── README.md
```

***

<div align="center">

<a href="https://github.com/ualpmg943">
  <img src="https://img.shields.io/badge/Pablo%20Martínez%20Gálvez-%40ualpmg943-181717?style=for-the-badge&logo=github&logoColor=white" />
</a>

<sub>🎧 <strong>Vibes Events</strong> &nbsp;·&nbsp; Almería, España &nbsp;·&nbsp; © 2026 · Todos los derechos reservados</sub>

</div>
