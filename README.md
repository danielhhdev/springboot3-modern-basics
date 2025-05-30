# Spring Boot 3.x + GraalVM Native Image + Virtual Threads (Java 21)

## Descripción

Proyecto base de microservicio moderno usando **Spring Boot 3.x** con dos tecnologías clave:

- **GraalVM Native Image:** Compilación a ejecutable nativo para tiempos de arranque ultra rápidos y menor consumo de recursos.
- **Virtual Threads (Project Loom):** Concurrencia eficiente en Java 21; cada petición HTTP se atiende en su propio virtual thread.

---

## Características

- Endpoint `/api/hello/virtual-demo` que simula carga bloqueante y muestra el hilo y duración.
- Código separado en Controller y Service, con logs de inicio, fin y duración del proceso.
- Arranque instantáneo usando el `.exe` nativo generado por GraalVM.

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
  Hilos ligeros introducidos en Java 21 que permiten gestionar miles de tareas concurrentes de forma eficiente.
- **Uso en este proyecto:**  
  Simplemente activa en `application.properties`:
  ```properties
  spring.threads.virtual.enabled=true
  ```
  Ahora, **cada petición HTTP se maneja en su propio virtual thread**.
- **Prueba el endpoint:**
  - Llama a `/api/hello/virtual-demo?millis=1000`
  - La respuesta y los logs indicarán el hilo y el tiempo de proceso.
  - Ejemplo de log:
    ```
    INFO  ... Inicio del proceso en hilo: VirtualThread[#17,...]
    INFO  ... Fin del proceso en hilo: VirtualThread[#17,...]. Duración: 1005 ms
    ```

---

## Cómo probar el endpoint

- Levanta la app (jar o exe).
- Haz una llamada:
  ```bash
  curl "http://localhost:8080/api/hello/virtual-demo?millis=1000"
  ```
- Revisa la respuesta y los logs en consola.

---

## Próximas secciones

- Observabilidad avanzada (Micrometer, OpenTelemetry)
- Testing robusto (Testcontainers)
- Integración de IA (Spring AI, Vector DB, etc.)

---

> Autor: Daniel Hernández  
> Roadmap: Spring Boot Moderno & IA
