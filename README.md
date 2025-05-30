# Spring Boot 3.x + GraalVM Native Image + Virtual Threads (Java 21)

## Descripción

Proyecto base de microservicio moderno usando **Spring Boot 3.x** con dos tecnologías clave:

- **GraalVM Native Image:** Compilación a ejecutable nativo para tiempos de arranque ultra rápidos y menor consumo de recursos.
- **Virtual Threads (Project Loom):** Concurrencia eficiente en Java 21; cada petición HTTP se atiende en su propio virtual thread.
- **Observabilidad avanzada:** Métricas y monitorización en tiempo real mediante [Micrometer](https://micrometer.io/) y Spring Boot Actuator, para controlar el estado, el rendimiento y la salud de la aplicación desde el primer momento.

---

## Características

- Endpoint `/api/hello/virtual-demo` que simula carga bloqueante y muestra el hilo y duración.
- Código separado en Controller y Service, con logs de inicio, fin y duración del proceso.
- Arranque instantáneo usando el `.exe` nativo generado por GraalVM.
- Observabilidad avanzada con [Micrometer](https://micrometer.io/) y Spring Boot Actuator.

---

## Native Image con GraalVM

- **¿Qué es?**  
  Permite compilar la app Java a un ejecutable nativo (`.exe` en Windows), sin necesidad de JVM instalada.
- **Ventajas:**
  - Tiempo de arranque < 1s (ideal para microservicios y serverless).
  - Menor uso de memoria.
- **Compilación:**
  ```bash
  mvnw.cmd -Pnative native:compile
  ```
  El ejecutable se genera en la carpeta `target/` y puede ejecutarse directamente:
  ```bash
  target\springboot3-modern-basics.exe
  ```

---

## Virtual Threads (Project Loom)

- **¿Qué son?**  
  Virtual Threads son un avance de Java 21 que permite gestionar la concurrencia de manera mucho más eficiente y escalable. A diferencia de los hilos tradicionales (platform threads), los virtual threads son extremadamente ligeros y consumen muchos menos recursos, lo que posibilita manejar miles de tareas concurrentes en una sola aplicación Java sin penalizar el rendimiento ni la memoria.

- **Ventajas en este proyecto:**  
  El microservicio aprovecha Virtual Threads para que cada petición HTTP sea gestionada de forma independiente, mejorando la escalabilidad y la capacidad de respuesta bajo alta carga. Gracias a Project Loom, se eliminan muchas de las limitaciones tradicionales asociadas al uso intensivo de hilos, facilitando el desarrollo de aplicaciones altamente concurrentes y listas para producción moderna.


## Observabilidad avanzada (Micrometer, OpenTelemetry, Actuator)

El microservicio implementa observabilidad profesional usando **Micrometer** y **Spring Boot Actuator**:

- **Micrometer** es el motor de métricas de Spring Boot. Recoge y expone información detallada sobre la JVM, hilos, memoria, peticiones HTTP y permite crear métricas personalizadas.
- **Actuator** expone endpoints REST para consultar el estado y métricas, como `/actuator/metrics`, `/actuator/health`, etc.


### ¿Cómo acceder a las métricas y salud?
- [http://localhost:8080/actuator/metrics](http://localhost:8080/actuator/metrics)  
  (lista todas las métricas disponibles)
- [http://localhost:8080/actuator/metrics/jvm.threads.live](http://localhost:8080/actuator/metrics/jvm.threads.live)  
  (número de hilos activos)
- [http://localhost:8080/actuator/metrics/http.server.requests](http://localhost:8080/actuator/metrics/http.server.requests)  
  (peticiones HTTP gestionadas)
- [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)  
  (estado general de la aplicación)


## Próximas secciones

- Testing robusto (Testcontainers)
- Integración de IA (Spring AI, Vector DB, etc.)

---

> Autor: Daniel Hernández  
> Roadmap: Spring Boot Moderno & IA
