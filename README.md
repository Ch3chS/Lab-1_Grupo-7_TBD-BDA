# Lab-1_Grupo-7_TBD-BDA
Este repositorio contiene todos los archivos relacionados con el laboratorio 1 del ramo de Taller de base de datos o base de datos avanzada.

* **IMPORTANTE: Para poder conectarse correctamente a la Base de Datos, se debe utilizar el usuario "postgres" y la contraseña "postgres"**

## Acerca del proyecto

### Colaboradores
* [Sergio Espinoza](https://github.com/Ch3chS)
* [Gonzalo Ibáñez](https://github.com/Gr3yW0lfChie)
* [Cristóbal Olivares](https://github.com/ToTozudo)

### Descripción
El proyecto consiste en desarrollar un sistema para la gestión del voluntariado espontáneo con Api Restful cuya interfaz sea realizada en Vue.js y Backend en Spring Boot<br>

### Tareas a realizar
- [x] Entender el problema
- [x] Investigar tecnologías a usar
- [x] Dividir el trabajo
- [x] Realizar el diseño 
  - [x] Diseñar base de datos
  - [x] Diseñar Back-end
  - [x] Diseñar Front-End
- [x] Realizar construcción de base de datos, Back-End y Front-end en paralelo
- [x] Unir Back-end y Front-end
- [x] Realizar ppt para la presentación
- [x] Preparar entrega
- [x] Pulir README.md
- [ ] Entregar y presentar

### Organización carpetas

- [Backend](./Backend/): Donde se almacenan todos los directorios y archivos relacionados al mismo.
  - [Directorio de trabajo](./Backend/src/main/java/com/example/demo/):
    - [Modelos](./Backend/src/main/java/com/example/demo/models/)
    - [Repositorios](./Backend/src/main/java/com/example/demo/repositories/)
    - [Servicios](./Backend/src/main/java/com/example/demo/services/)
    - [Controladores](./Backend/src/main/java/com/example/demo/controllers/)
- [Frontend](./Frontend/): Donde se almacenan todos los directorios y archivos relacionados al mismo.
- [Database](./Database/): Donde se encuentran los archivos relacionados a la base de datos en sí.
  - [dbCreate](./Database/dbCreate.sql): Archivo de creación de tablas
  - [loadData](./Database/loadData.sql): Archivo de llenado de tablas

## Instalación

### Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [Postgres SQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior. 
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [IntelliJ IDEA Ultimate](https://code.visualstudio.com/download) deberia funcionar con cualquier versión, con la extensión de Spring Boot Tools.
* [Nuxt + VUE](https://nuxtjs.org) versión 2.

### Instrucciones de ejecución
- Crear base de datos con el nombre de "demo" en pgAdmin4
- Abrir la Query Tool en la base de datos recien creada (demo)
- En la Query Tool, abrir y ejecutar el archivo dbCreate de la carpeta Database (Esto creara las tablas)
- Inicializar aplicación:
Dirigirse a directorio de aplicación back-end desde terminal
$ cd ./Lab-1_Grupo-7_TBD-BDA/Backend

Ejecutar el proyecto, cuyo acceso será: http://localhost:3000
$ ./gradlew bootRun


- Inicializar pagina de acceso:
 Dirigirse a directorio de aplicación front-end desde terminal
$ cd ./Lab-1_Grupo-7_TBD-BDA/Frontend

# Instalar dependencias necesarias para la ejecución
$ yarn install

Ejecutar el proyecto, cuyo acceso será: http://localhost:3000
$ yarn dev
$ yarn build

- Ingresar a <a href="http://localhost:3000/">http://localhost:3000/</a>

## Links de interes
- <a href="https://lucid.app/lucidchart/87e467c7-6553-432e-9ec1-d4299718d13b/edit?viewport_loc=-530%2C83%2C2742%2C1358%2C0_0&invitationId=inv_78eae510-25d6-4c34-bb0d-1edb538e05ad" target="_blank">Modelo relacional (MR)</a>
