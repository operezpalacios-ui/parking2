package com.example.parking.exception;

public class VehiculoNoEncontradoException extends RuntimeException {

    public VehiculoNoEncontradoException() {
        super();
    }

    public VehiculoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
