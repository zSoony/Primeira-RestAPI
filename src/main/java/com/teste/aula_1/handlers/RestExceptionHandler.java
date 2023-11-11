package com.teste.aula_1.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.aula_1.models.error.ObjectError;
import com.teste.aula_1.models.excepion.ResourceNotFoundException;

@ControllerAdvice // esse cara é um controlador de aplicação

// classe para controlar qualquer erro dentro da api direciona todos os erros
// pra ela caso occora um dos erros listado retorna esse metodo
public class RestExceptionHandler {

    // @excepiothandler serve pra chamar o metodo sempre que a exceção entre ()
    // acontecer
    // <?>= qualquer coisa
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {

        ObjectError error404 = new ObjectError("Not Found", 404, ex.getMessage());
        return new ResponseEntity<>(error404, HttpStatus.NOT_FOUND);

    }

}
