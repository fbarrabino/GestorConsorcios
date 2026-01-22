#  Sistema de Gestión de Consorcios

Aplicación web Full Stack diseñada para administrar gastos y expensas de consorcios de propietarios.

##  Tecnologías

Este proyecto está construido con un stack moderno y robusto:

* **Backend:** Java con Spring Boot 3.
* **Base de Datos:** SQL Server.
* **Frontend:** HTML5, CSS3 y JavaScript (Vanilla).
* **Persistencia:** Hibernate / JPA.

##  Funcionalidades Clave

*  **Gestión de Gastos:** Carga, edición y eliminación (individual y masiva) de gastos.
*  **Auditoría:** Registro automático de fechas de modificación.
*  **Interfaz Moderna:** Diseño reactivo con soporte para Modo Oscuro y Claro.
*  **API REST:** Comunicación eficiente entre cliente y servidor.

##  Ejecución Local

Para correr este proyecto en tu máquina:

1.  Clonar el repositorio.
2.  Tener una instancia de SQL Server corriendo.
3.  Configurar las credenciales en `src/main/resources/application.properties`.
4.  Ejecutar el proyecto con Maven o desde tu IDE.
5.  Acceder vía navegador a `http://localhost:8080`.