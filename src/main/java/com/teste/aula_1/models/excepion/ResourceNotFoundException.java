package com.teste.aula_1.models.excepion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//responseStatus serve pra retornar algo quando condição atingida
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String messenger) {
        super(messenger);

    }

}
