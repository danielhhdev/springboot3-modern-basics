package com.dhh.springboot3ModernBasics.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {


    public String sayHello(String name) {
        return "Hola, " + name + "! (desde el Service)";
    }

    public String doHeavyWork(long millis) {
        try {
            Thread.sleep(millis); // Simula carga de trabajo bloqueante
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Thread interrumpido: " + Thread.currentThread();
        }
        return "Trabajo terminado en: " + Thread.currentThread();
    }
}