package com.Daniblue02.model;

public class Coche extends Cliente{

    //PK
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    //FK
    private String nif;

    public Coche(){

    }

    public Coche(String placa, String marca, String modelo, String color, double precio, String nif) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.nif = nif;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String getNif() {
        return nif;
    }

    @Override
    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", nif=" + nif +
                '}';
    }
}
