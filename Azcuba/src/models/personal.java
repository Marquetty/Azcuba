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
public class personal {

    private int id;
    private String ci;
    private String nombre;
    private String apellidos;
    private String ocupacion;
    private String contrata;
    private int salario;
    private int salario_contrata;
    private int tiempo_contrata;

    public personal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getContrata() {
        return contrata;
    }

    public void setContrata(String contrata) {
        this.contrata = contrata;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario_contrata() {
        return salario_contrata;
    }

    public void setSalario_contrata(int salario_contrata) {
        this.salario_contrata = salario_contrata;
    }

    public int getTiempo_contrata() {
        return tiempo_contrata;
    }

    public void setTiempo_contrata(int tiempo_contrata) {
        this.tiempo_contrata = tiempo_contrata;
    }

    public personal(int id, String ci, String nombre, String apellidos, String ocupacion, String contrata, int salario, int salario_contrata, int tiempo_contrata) {
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ocupacion = ocupacion;
        this.contrata = contrata;
        this.salario = salario;
        this.salario_contrata = salario_contrata;
        this.tiempo_contrata = tiempo_contrata;
    }

}
