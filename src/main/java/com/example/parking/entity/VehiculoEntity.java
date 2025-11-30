package com.example.parking.entity;
import jakarta.persistence.*;

@Entity
@Table(name="vehiculos")
public class VehiculoEntity {

    @Id
    private String matricula;
    private String modelo;
    private long horaEntrada;
    private String marca;
    private int numeroPuertas;
    private String color;
    private boolean estado;
    private String tipoVehiculo;
    private double tarifa;
    private long horaSalida;

    public VehiculoEntity() {}

    public VehiculoEntity(String matricula, long horaSalida, double tarifa, String tipoVehiculo, boolean estado, String color, int numeroPuertas, String marca, long horaEntrada, String modelo) {
        this.matricula = matricula;
        this.horaSalida = horaSalida;
        this.tarifa = tarifa;
        this.tipoVehiculo = tipoVehiculo;
        this.estado = estado;
        this.color = color;
        this.numeroPuertas = numeroPuertas;
        this.marca = marca;
        this.horaEntrada = horaEntrada;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public long getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(long horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(long horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
