package com.example.parking.dto;

public class FacturaDTO {

    private String matricula;
    private double tarifa;
    private long horaEntrada;
    private long horaSalida;
    private double costeTotal;

    // Constructor vacío
    public FacturaDTO() {
    }

    // Constructor completo opcional
    public FacturaDTO(String matricula, double tarifa, long horaEntrada, long horaSalida, double costeTotal) {
        this.matricula = matricula;
        this.tarifa = tarifa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.costeTotal = costeTotal;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(long horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public long getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(long horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    @Override
    public String toString() {
        return "FacturaDTO{" +
                "matricula='" + matricula + '\'' +
                ", tarifa=" + tarifa +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", costeTotal=" + costeTotal +
                '}';
    }
}
