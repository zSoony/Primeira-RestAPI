package com.teste.aula_1.models.error;

public class ObjectError {

    private String titulo;
    private Integer errorcode;
    private String messenger;

    public ObjectError(String titulo, Integer errorcode, String messenger) {
        this.titulo = titulo;
        this.errorcode = errorcode;
        this.messenger = messenger;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

}
