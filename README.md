# JPA Application

Este proyecto es una aplicación Java utilizando Spring Boot y JPA (Java Persistence API). Se centra en la gestión de entidades como clientes, domicilios, facturas, artículos y categorías, utilizando relaciones bidireccionales entre las entidades.

## Requisitos previos

- **Java 17**: Este proyecto está diseñado para ejecutarse con Java 17.
- **Maven o Gradle**: Puedes usar cualquiera de estos administradores de dependencias. Este proyecto usa Gradle.
- **Base de datos H2**: La aplicación está configurada para usar una base de datos en memoria H2 para el almacenamiento temporal de datos.
- **Spring Boot 3.3.3**: El proyecto utiliza Spring Boot para la configuración y ejecución de la aplicación.

## Configuración del proyecto

### Estructura del proyecto

El proyecto sigue una estructura de paquetes estándar:

- **entidades**: Aquí se encuentran las clases que representan las entidades JPA, como `Cliente`, `Domicilio`, `Factura`, `Articulo`, `Categoria`, y `DFactura`.
- **AplicationApplication**: Clase principal que inicia la aplicación Spring Boot.

### Dependencias

Asegúrate de que tu archivo `build.gradle` o `pom.xml` incluye las siguientes dependencias:


### Ejemplo de Persistencia

Domicilio domicilio1 = new Domicilio("San Martin", 1222);
Cliente cliente1 = new Cliente ("Pablo", "Muñoz", 15245778);
cliente1.setDomicilio(domicilio1);
domicilio1.setCliente(cliente1);

Factura factura1 = new Factura();
factura1.setCliente(cliente1);

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'com.h2database:h2'
    implementation 'jakarta.persistence:jakarta.persistence-api:3.0.0'
}
./gradlew bootRun

