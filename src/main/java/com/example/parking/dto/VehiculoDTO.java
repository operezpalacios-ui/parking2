package com.example.parking.dto;

public class VehiculoDTO {
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

    public VehiculoDTO() {}//constructor vACIO

    public VehiculoDTO(String matricula, String modelo, long horaEntrada, String marca, int numeroPuertas, String color, boolean estado, String tipoVehiculo, double tarifa, long horaSalida) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.horaEntrada = horaEntrada;
        this.marca = marca;
        this.numeroPuertas = numeroPuertas;
        this.color = color;
        this.estado = estado;
        this.tipoVehiculo = tipoVehiculo;
        this.tarifa = tarifa;
        this.horaSalida = horaSalida;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(long horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public long getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(long horaSalida) {
        this.horaSalida = horaSalida;
    }


    }

