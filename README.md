API médica desarrollada con Spring Boot 3 que gestiona médicos y pacientes, implementando mejores prácticas de desarrollo.

🌟 Características Principales Arquitectura RESTful con endpoints documentados CRUD completo para médicos y pacientes Validaciones robustas con Bean Validation Paginación de resultados con Spring Data JPA Migrations automatizadas con Flyway 🛠️ Tecnologías Utilizadas Tecnología Uso Spring Boot 3 Framework principal MySQL Base de datos relacional Flyway Control de migraciones Lombok Reducción de boilerplate Bean Validation Validación de datos JPA/Hibernate ORM y gestión de entidades 🚀 Cómo Ejecutar Clona el repositorio:

bash git clone https://github.com/eleuteriovargas/Spring-Boot-3.git Configura la base de datos en:

properties

application.properties spring.datasource.url=jdbc:mysql://localhost:3306/vollmed
spring.datasource.username=tu_usuario 
spring.datasource.password=tu_contraseña Ejecuta la aplicación:

📌 Endpoints Principales
Método Endpoint Descripción 
POST /medicos Registrar nuevo médico
GET /medicos Listar médicos paginados(paginacion)
PUT /medicos/{id} Actualizar datos médico
DELETE /medicos/id Pone inactivo un medico sin eliminar de la base de datos
POST /pacientes Registrar nuevo paciente
GET /pacientes Listar pacientes paginados(paginacion)
PUT /pacientes/{id} Actualizar datos pacientes
DELETE /pacientes/id Pone inactivo un pacientes sin eliminar de la base de datos
