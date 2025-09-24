package com.hugosamayoa.Juego_Ahorcado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ControladorExcepciones {

    // Validación cuando la ruta de la API es incorrecta
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> ApiIncorrecta(NoHandlerFoundException badApi) {
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.NOT_FOUND.value());
        mensaje.put("error", "Not Found");
        mensaje.put("message", "La ruta API que estas solicitando no existe. Verifica la URL.");

        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
    }

    // Validación para que al momento de ingresar otro tipo de caracter que no sea un ID muestre un mensaje
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> IdInvalido(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.BAD_REQUEST.value());
        mensaje.put("error", "Bad Request");
        mensaje.put("message", "El parámetro 'ID' es obligatorio, no se permiten otro tipo de caracteres");

        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
    }
}
