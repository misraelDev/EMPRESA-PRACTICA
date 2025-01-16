# Práctica de Java con Spring y Thymeleaf

Este proyecto es una práctica de desarrollo de una aplicación web utilizando Java, el framework Spring y Thymeleaf como motor de plantillas. La aplicación permite gestionar departamentos y empleados.

## Características

- **Inicio**: Página principal con una vista general.
- **Agregar departamento**: Interfaz para añadir un nuevo departamento.
- **Agregar empleado**: Interfaz para añadir un nuevo empleado.

## Capturas de pantalla

### Página de inicio
![Página de Inicio](https://github.com/user-attachments/assets/06e0a9e2-9dc1-4f70-934d-261298378a8e)

### Agregar departamento
![Agregar Departamento](https://github.com/user-attachments/assets/195cc71c-704f-4610-9c8e-5fc7315272ce)

### Agregar empleado
![Agregar Empleado](https://github.com/user-attachments/assets/f3028411-fbf3-4dea-b48b-01741310ff3a)

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Framework**: Para la creación del backend.
- **Thymeleaf**: Motor de plantillas para renderizar vistas HTML.
- **PostgreSQL**: Base de datos para el almacenamiento persistente de datos.

## Configuración de la Base de Datos

1. Asegúrate de tener PostgreSQL instalado en tu sistema.
2. Crea una base de datos llamada `EMPRESA` (puedes personalizar el nombre).
3. Configura las credenciales de acceso en el archivo `application.properties` o `application.yml`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/EMPRESA
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
