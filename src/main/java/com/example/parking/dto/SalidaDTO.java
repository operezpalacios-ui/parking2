package com.example.parking.dto;

public class SalidaDTO {
    private String mensaje;

    public SalidaDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public SalidaDTO() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
