/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Lenovo
 */
public class transportacion {

    private int id_vehiculo;
    private String tipo_vehiculo;
    private String modelo;
    private String marca;

    public transportacion(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public transportacion(int id_vehiculo, String tipo_vehiculo, String modelo, String marca) {
        this.id_vehiculo = id_vehiculo;
        this.tipo_vehiculo = tipo_vehiculo;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
