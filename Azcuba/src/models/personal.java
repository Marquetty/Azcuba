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
    private String ocupacion;
    private String cotrata; 
    private int salario;
    private String tipo_contrata;
    private int salario_total;

    public personal(int id,String ci, String ocupacion, String cotrata, int salario, String tipo_contrata, int salario_total) {
        this.id=id;
        this.ci = ci;
        this.ocupacion = ocupacion;
        this.cotrata = cotrata;
        this.salario = salario;
        this.tipo_contrata = tipo_contrata;
        this.salario_total = salario_total;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCotrata() {
        return cotrata;
    }

    public void setCotrata(String cotrata) {
        this.cotrata = cotrata;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getTipo_contrata() {
        return tipo_contrata;
    }

    public void setTipo_contrata(String tipo_contrata) {
        this.tipo_contrata = tipo_contrata;
    }

    public int getSalario_total() {
        return salario_total;
    }

    public void setSalario_total(int salario_total) {
        this.salario_total = salario_total;
    }
    
    
}
