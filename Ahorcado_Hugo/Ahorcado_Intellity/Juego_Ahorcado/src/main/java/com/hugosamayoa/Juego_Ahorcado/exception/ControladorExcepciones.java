package com.hugosamayoa.Juego_Ahorcado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;


// Validacion cuando la ruta de la API es incorrecta.
@ControllerAdvice
public class ControladorExcepciones {
    // El manejo de este error nos ayuda cuando cambiamos la ruta en postman para mandar a llamar muestre el mensaje de abajo
    //ue la ruta no existe
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> ApiIncorrecta(NoHandlerFoundException badApi) {
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.NOT_FOUND.value());
        mensaje.put("error", "Not Found");
        mensaje.put("message", "La ruta API que has solicitado no existe.Verifica la URL.");

        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
    }
}