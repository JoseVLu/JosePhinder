# 📌 Sistema Spring Boot - Gestión de Usuarios

Sistema desarrollado con **Spring Boot** para la gestión de usuarios, direcciones y hobbies, utilizando **Oracle Database** como motor de base de datos.

---

## 🚀 Tecnologías Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Oracle Database
* Maven
* Swagger (OpenAPI)

---

# ⚙️ Configuración del Proyecto

## 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio
```

---

## 2️⃣ Configurar la Base de Datos

Este proyecto utiliza **Oracle Database**.

### 🔹 Crear la base de datos

Ejecutar el script SQL incluido en el proyecto que contiene:

* Creación de tablas
* Llaves primarias
* Llaves foráneas
* Inserciones de catálogos

⚠️ **Para la base de datos ejecutar el Script del siguiente archivo**

JosePhinderPrueba.sql (adjunto dentro del respositorio)

Ejecutarlo desde:

* SQL Developer
---

## 3️⃣ Configurar `Conexion a la base de datos`

Actualizar las credenciales en:

```
DataSourceConfig.java
```

Ejemplo:

```DataSourceConfig.java
@Bean
    public DataSource DataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("[usuario]");
        dataSource.setPassword("[password]");
        
        return dataSource;
    }
```

---


# 📚 Documentación Swagger

Una vez levantado el proyecto, la documentación estará disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

```

Desde ahí podrás:

* Ver todos los endpoints disponibles
* Probar peticiones directamente
* Revisar modelos y respuestas

---

# 🗄️ Estructura de Base de Datos

El sistema maneja las siguientes entidades principales:

* PAIS
* ESTADO
* MUNICIPIO
* COLONIA
* DIRECCION
* USUARIO
* HOBBIE
* HOBBIEUSUARIO

Incluye relaciones:

* País → Estado
* Estado → Municipio
* Municipio → Colonia
* Usuario → Dirección
* Usuario → Hobbies

---
# 👨‍💻 Autor: Jose Vera Luna

Desarrollado como prueba tecnica
