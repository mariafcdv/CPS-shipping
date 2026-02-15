# CPS Shipping – Cotizador de Envíos

Prueba técnica: **Cotizador de envíos CPS** con **Frontend Angular**, **Backend Spring Boot (REST API)** y **SQL Server**.

El sistema permite cotizar un envío con base en el país/región de destino y el tipo de cliente (visitante / premium / super premium), aplicando una fórmula para determinar el total de envío.

---

## Fórmula de cotización

(peso * tarifa) + 1.66 * alto * largo * ancho – descuento_cliente * 0.5 * peso

> Donde "descuento_cliente" corresponde al porcentaje de descuento del cliente: sin descuento (0%), premium (5%), super premium (10%).

---

## Arquitectura del proyecto

CPS_shipping/
├─ Backend/                                          # Spring Boot REST API
├─ DB/                                               # Script SQL Server
└─ Frontend/cps-shipping-frontend                    # Angular (UI)

---

## Requisitos

### Base de datos

- Docker Desktop
- SQL Server en contenedor (Docker)
- Azure Data Studio (opcional, para administración)

### Backend
- Java 17 (recomendado)
- Maven Wrapper (incluido en el proyecto)

### Frontend
- Node.js (LTS recomendado)
- npm

---

## Base de datos (SQL Server)

Script de creación:
- DB/CPS_shipping.sql

### Configuración de Base de Datos

Ya que la base de datos está corriendo en un contenedor de Docker, se utiliza como “localhost”.  
Asegúrate de que el contenedor esté encendido y que Azure Data Studio esté conectado antes de levantar el backend.


**Levantar el contenedor:**

docker-compose up -d

**Crear estructura y datos:**
Una vez que el contenedor esté corriendo, utiliza tu gestor de base de datos para conectarte a localhost,1433 con el usuario sa y ejecutar el script ubicado en:
./DB/CPS_Shipping.sql

Ejecuta el script `DB/CPS_shipping.sql` para crear la base de datos.
---

## Ejecución del proyecto

### 1) Levantar base de datos
1. Inicia el contenedor de SQL Server en Docker.
2. Verifica conexión en Azure Data Studio.
3. Ejecuta `DB/CPS_shipping.sql`.

### 2) Levantar Backend (Spring Boot)
Desde la carpeta del backend:

cd Backend
./mvnw clean spring-boot:run -Dspring-boot.run.profiles=local

### 3) Levantar Frontend (Angular)
Desde el frontend:

cd frontend/cps-shipping-frontend
npm install
npm start

Luego abre la URL que te muestra la consola (comúnmente http://localhost:4200).

---

## Verificación rápida

1. Abre el frontend.
2. Selecciona:
   - Región / País destino (define la tarifa)
   - Tipo de cliente (aplica descuento si corresponde)
3. Ingresa:
   - Peso, alto, largo, ancho
4. Presiona **Cotizar**.
5. Valida que el resultado coincida con la fórmula.

---

## Consideraciones

- La tarifa se determina por el **país destino** (asociado a una región).
- El tipo de cliente controla el **porcentaje de descuento**.
---

## Autor
Mariafernanda Castro Del Vecchio