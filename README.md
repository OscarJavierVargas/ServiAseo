Proyecto de Gestión de Facturación - ServiAseo
Descripción
Este proyecto consiste en una aplicación de gestión de facturación desarrollada con Spring Boot para el backend y Angular para el frontend. 
La base de datos utilizada es MySQL y el proyecto se construye utilizando Maven.

Requisitos
Backend
Java 8
Eclipse IDE
Maven
MySQL Server
Frontend
Node.js (versión 14 o superior)
Angular CLI (versión 15 o superior)
Visual Studio Code
Configuración
Base de Datos
Instalar MySQL:
Asegúrate de tener MySQL instalado y en funcionamiento en tu máquina.

Configurar la base de datos:
Crea una base de datos en MySQL llamada serviaseo_db y ejecuta los scripts SQL proporcionados para crear las tablas necesarias.
y ejecutar los scripts de que contienn los procedimientos y funcion.
Credenciales de la base de datos:
Configura las credenciales de acceso a MySQL en el archivo application.properties de tu proyecto Spring Boot.

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/serviaseo_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
Backend
Clonar el repositorio:
Clona el repositorio en tu máquina local.

bash
Copiar código
git clone https://github.com/tu-usuario/serviaseo.git
Importar el proyecto en Eclipse:

Abre Eclipse IDE.
Selecciona File > Import > Maven > Existing Maven Projects.
Navega a la carpeta donde clonaste el repositorio y selecciona la carpeta raíz del proyecto.
Compilar el proyecto:
Ejecuta el comando Maven para compilar el proyecto.


Ejecutar el proyecto:
Ejecuta la aplicación Spring Boot directamente desde Eclipse.

Haz clic derecho sobre el proyecto en el explorador de Eclipse.
Selecciona Run As > Spring Boot App.
Frontend
Instalar dependencias:
Navega a la carpeta frontend dentro del proyecto clonado y ejecuta el siguiente comando para instalar las dependencias:

Copiar código
npm install
Ejecutar la aplicación Angular:
Ejecuta la aplicación Angular localmente utilizando el siguiente comando:

en la consola de visualstudio code
ng serve
Acceder a la aplicación:
Abre tu navegador y dirígete a http://localhost:4200 para ver la aplicación en funcionamiento.

Uso
Endpoints Principales
Backend:

http://localhost:8585/conusulta/{cedula}: Verificar si un cliente existe.
http://localhost:8585/factura: Crear una nueva factura.
http://localhost:8585/facturas: Listar todas las facturas.
http://localhost:8585/factura/{id_factura}/detalles: Ver detalles de una factura específica.
Frontend:

http://localhost:4200/cliente: Gestión de clientes.
http://localhost:4200/factura/nueva: Crear una nueva factura.
http://localhost:4200/facturas: Listar facturas.
Herramientas de Construcción
Maven: Usado para la gestión de dependencias y compilación del backend.
Angular CLI: Usado para la gestión y compilación del frontend.
Ejecución en Local
Para ejecutar ambos lados de la aplicación localmente, sigue los pasos descritos en las secciones de configuración de backend y frontend. 
Asegúrate de que tanto el servidor MySQL como los servicios de backend y frontend estén en funcionamiento para una experiencia completa.
