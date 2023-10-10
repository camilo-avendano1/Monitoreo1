# Monitoreo1
Repositorio backend del moduo de monitoreo1 de FE 2023-2 de la Universidad de Antioquia


Este proyecto representa un backend construido en Java 11 y Spring Boot 3.0 que se encarga del monitoreo en tiempo real de rutas, autos y clientes en una aplicación para fabrica Escuela en la Universidad de Antioquia. Utiliza tecnologías como WebSockets, Kafka y Spark para proporcionar un sistema eficiente y escalable.

## Características principales

- **WebSockets**: Utilizamos WebSockets para habilitar la comunicación en tiempo real entre el servidor y los clientes, lo que permite el seguimiento en tiempo real de la ubicación de los autos y clientes.

- **Kafka**: Utilizamos Apache Kafka para la transmisión de datos en tiempo real. Los productores Kafka reciben información de los conductores y los clientes, mientras que los consumidores procesan y transmiten los datos a los clientes conectados a través de WebSockets.

- **Spring Boot 3.0**: Utilizamos Spring Boot 3.0 para la creación de la aplicación, lo que facilita la configuración y el desarrollo de aplicaciones Java de manera eficiente.

## Requisitos

- Java 11.
- Apache Kafka instalado y configurado.
- Un servidor de Spark configurado.
- Dependencias adicionales se encuentran en el archivo `pom.xml`.

## Configuración

1. Clone este repositorio:

   ```bash
   git clone https://github.com/camilo-avendano1/Monitoreo1.git
   cd backend-uber-monitoreo
