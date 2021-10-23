/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class producion {

    private int id_producion;
    private int sacos;
    private int miel;
    private int azucar_pizarra;
    private int norma_producion;
    private int tm_refino;
    private int total_azucar;
    private int insumo_ajeno;
    private int refino_a_procesar;
    private Date producion_fecha;

    public producion(int id_producion) {
        this.id_producion = id_producion;
    }

    public producion(int id_producion, int miel, int sacos, int azucar_pizarra, int norma_producion, int tm_refino, int total_azucar, int insumo_ajeno, int refino_a_procesar) {
        this.id_producion = id_producion;
        this.miel = miel;
        this.sacos = sacos;
        this.azucar_pizarra = azucar_pizarra;
        this.norma_producion = norma_producion;
        this.tm_refino = tm_refino;
        this.total_azucar = total_azucar;
        this.insumo_ajeno = insumo_ajeno;
        this.refino_a_procesar = refino_a_procesar;

    }

    public producion(int id_producion, int miel, int sacos, int azucar_pizarra, int norma_producion, int tm_refino, int total_azucar, int insumo_ajeno, int refino_a_procesar, Date producion_fecha) {
        this.id_producion = id_producion;
        this.miel = miel;
        this.sacos = sacos;
        this.azucar_pizarra = azucar_pizarra;
        this.norma_producion = norma_producion;
        this.tm_refino = tm_refino;
        this.total_azucar = total_azucar;
        this.insumo_ajeno = insumo_ajeno;
        this.refino_a_procesar = refino_a_procesar;
        this.producion_fecha = producion_fecha;
    }

    public int getMiel() {
        return miel;
    }

    public void setMiel(int miel) {
        this.miel = miel;
    }

    public int getId_producion() {
        return id_producion;
    }

    public void setId_producion(int id_producion) {
        this.id_producion = id_producion;
    }

    public int getSacos() {
        return sacos;
    }

    public void setSacos(int sacos) {
        this.sacos = sacos;
    }

    public int getAzucar_pizarra() {
        return azucar_pizarra;
    }

    public void setAzucar_pizarra(int azucar_pizarra) {
        this.azucar_pizarra = azucar_pizarra;
    }

    public int getNorma_producion() {
        return norma_producion;
    }

    public void setNorma_producion(int norma_producion) {
        this.norma_producion = norma_producion;
    }

    public int getTm_refino() {
        return tm_refino;
    }

    public void setTm_refino(int tm_refino) {
        this.tm_refino = tm_refino;
    }

    public int getTotal_azucar() {
        return total_azucar;
    }

    public void setTotal_azucar(int total_azucar) {
        this.total_azucar = total_azucar;
    }

    public int getInsumo_ajeno() {
        return insumo_ajeno;
    }

    public void setInsumo_ajeno(int insumo_ajeno) {
        this.insumo_ajeno = insumo_ajeno;
    }

    public int getRefino_a_procesar() {
        return refino_a_procesar;
    }

    public void setRefino_a_procesar(int refino_a_procesar) {
        this.refino_a_procesar = refino_a_procesar;
    }

    public Date getProducion_fecha() {
        return producion_fecha;
    }

    public void setProducion_fecha(Date producion_fecha) {
        this.producion_fecha = producion_fecha;
    }

}
