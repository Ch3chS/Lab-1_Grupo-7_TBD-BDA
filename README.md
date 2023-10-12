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
- [ ] Dividir el trabajo
- [ ] Realizar el diseño 
  - [ ] Diseñar base de datos
  - [ ] Diseñar Back-end
  - [ ] Diseñar Front-End
- [ ] Realizar construcción de base de datos, Back-End y Front-end en paralelo
- [ ] Unir Back-end y Front-end
- [ ] Realizar ppt para la presentación
- [ ] Preparar entrega
- [ ] Pulir README.md
- [ ] Entregar y presentar

### Organización carpetas

- [Backend](./Backend/): Donde se almacenan todos los directorios y archivos relacionados al mismo.
  - [Directorio de trabajo](./Backend/src/main/java/com/example/demo/):
    - [Modelos](./Backend/src/main/java/com/example/demo/models/)
    - [Repositorios](./Backend/src/main/java/com/example/demo/repositories/)
    - [Servicios](./Backend/src/main/java/com/example/demo/services/)
    - [Controladores](./Backend/src/main/java/com/example/demo/controllers/)

- [Frontend](./Frontend/): Donde se almacenan todos los directorios y archivos relacionados al mismo.

## Instalación

### Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [Postgres SQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior. 
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [IntelliJ IDEA Ultimate](https://code.visualstudio.com/download) deberia funcionar con cualquier versión, con la extensión de Spring Boot Tools.
* [Nuxt + VUE](https://nuxtjs.org) versión 2.

### Instrucciones de ejecución
- Crear base de datos con el nombre de "demo" en pgAdmin4
- Fijarse en que el puerto 8080 no se encuentre en uso
  - Si se encuentra en uso ejecutar las siguientes instrucciones:
- Inicializar aplicación
- Ingresar a <a href="http://localhost:8080/">http://localhost:8080/</a>

## Links de interes
- <a href="https://drive.google.com/drive/folders/1aI0BVZKgkPVEpecW9JwqeeAMNqhDOWyL?usp=sharing">Drive del grupo</a>
- <a href="https://lucid.app/lucidchart/87e467c7-6553-432e-9ec1-d4299718d13b/edit?viewport_loc=-530%2C83%2C2742%2C1358%2C0_0&invitationId=inv_78eae510-25d6-4c34-bb0d-1edb538e05ad" target="_blank">Modelo relacional (MR)</a>
