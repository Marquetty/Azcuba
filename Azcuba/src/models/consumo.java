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
public class consumo {

    private int id;
    private int consumo_aceite;
    private int consumo_lodo;
    private int consumo_petroleo;
    private int biomasa;
    private int marabu;
    private int recobrado;
    private int indice_dia;
    private int indice_pretroleo;
    private Date consumo_fecha;

    public consumo(int id) {
        this.id = id;
    }

    public consumo(int id, int consumo_aceite, int consumo_lodo, int consumo_petroleo, int biomasa, int marabu, int recobrado, int indice_dia, int indice_pretroleo) {

    }

    public consumo(int id, int consumo_aceite, int consumo_lodo, int consumo_petroleo, int biomasa, int marabu, int recobrado, int indice_dia, int indice_pretroleo, Date consumo_fecha) {
        this.id = id;
        this.consumo_aceite = consumo_aceite;
        this.consumo_lodo = consumo_lodo;
        this.consumo_petroleo = consumo_petroleo;
        this.biomasa = biomasa;
        this.marabu = marabu;
        this.recobrado = recobrado;
        this.indice_dia = indice_dia;
        this.indice_pretroleo = indice_pretroleo;
        this.consumo_fecha = consumo_fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsumo_aceite() {
        return consumo_aceite;
    }

    public void setConsumo_aceite(int consumo_aceite) {
        this.consumo_aceite = consumo_aceite;
    }

    public int getConsumo_lodo() {
        return consumo_lodo;
    }

    public void setConsumo_lodo(int consumo_lodo) {
        this.consumo_lodo = consumo_lodo;
    }

    public int getConsumo_petroleo() {
        return consumo_petroleo;
    }

    public void setConsumo_petroleo(int consumo_petroleo) {
        this.consumo_petroleo = consumo_petroleo;
    }

    public int getBiomasa() {
        return biomasa;
    }

    public void setBiomasa(int biomasa) {
        this.biomasa = biomasa;
    }

    public int getMarabu() {
        return marabu;
    }

    public void setMarabu(int marabu) {
        this.marabu = marabu;
    }

    public int getRecobrado() {
        return recobrado;
    }

    public void setRecobrado(int recobrado) {
        this.recobrado = recobrado;
    }

    public int getIndice_dia() {
        return indice_dia;
    }

    public void setIndice_dia(int indice_dia) {
        this.indice_dia = indice_dia;
    }

    public int getIndice_pretroleo() {
        return indice_pretroleo;
    }

    public void setIndice_pretroleo(int indice_pretroleo) {
        this.indice_pretroleo = indice_pretroleo;
    }

    public Date getConsumo_fecha() {
        return consumo_fecha;
    }

    public void setConsumo_fecha(Date consumo_fecha) {
        this.consumo_fecha = consumo_fecha;
    }

}
