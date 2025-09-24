package com.hugosamayoa.Juego_Ahorcado;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sun.net.httpserver.HttpServer;
import java.net.*;

@SpringBootApplication
public class JuegoAhorcadoFinalProyectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        try {
            SpringApplication.run(JuegoAhorcadoFinalProyectApplication.class, args);
        } catch (Exception e) {
            manejarError(e);
        }
    }

    private static void manejarError(Exception e) {
        if (!tieneErrorPuerto(e)) return;

        int puertoReserva = 8081;
        String mensaje = "Servicio temporalmente no disponible - El Puerto principal esta ocupado";

        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(puertoReserva), 0);

            servidor.createContext("/", exchange -> {
                String respuesta = "{\"estado\":\"error\",\"mensaje\":\"" + mensaje + "\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(503, respuesta.length());
                exchange.getResponseBody().write(respuesta.getBytes());
                exchange.getResponseBody().close();
            });

            servidor.start();
            System.out.println("Servidor de aviso en puerto: " + puertoReserva);

        } catch (Exception ex) {
            System.out.println("No se pudo iniciar servidor alterno");
        }
    }

    private static boolean tieneErrorPuerto(Exception e) {
        Throwable causa = e;
        while (causa != null) {
            if (causa instanceof BindException) return true;
            causa = causa.getCause();
        }
        return false;
    }

    @Override
    public void run(String... args) {
        System.out.println("API funcionando correctamente");
    }
}
