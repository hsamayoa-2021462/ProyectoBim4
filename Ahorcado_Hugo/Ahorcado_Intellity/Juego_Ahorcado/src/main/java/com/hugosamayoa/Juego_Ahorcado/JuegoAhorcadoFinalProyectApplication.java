package com.hugosamayoa.Juego_Ahorcado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuegoAhorcadoFinalProyectApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(JuegoAhorcadoFinalProyectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Api Juego_Ahorcado ejecutando correctamente ");

    }
}
