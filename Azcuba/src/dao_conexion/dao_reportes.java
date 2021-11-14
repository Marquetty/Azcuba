/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conexion;

import auth.Auth;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class dao_reportes {

    DefaultTableModel modeloTabla = null;

    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();

// Buscar por edad 
    public void buscarEdad(JTable table, int edad, String operador) {
        Statement stmt = null;
        ResultSet rs = null;
        String[] columna = {"No", "CI", "Nombre", "Apellidos", "Sexo", "Edad", "Ocupacion", "Contrata",
            "Salario", "Salario de contrata", "Tiempo de Contrata(Mes)"};

        try {
            int contM = 1;
            Object[] row = new Object[11];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "personal.id,\n"
                    + "personal.ci,\n"
                    + "personal.ocupacion,\n"
                    + "personal.contrata,\n"
                    + "personal.salario,\n"
                    + "personal.tiempo_contrata,\n"
                    + "personal.salario_contrata,\n"
                    + "personal.nombre,\n"
                    + "personal.apellidos,\n"
                    + "personal.sexo,\n"
                    + "personal.edad\n"
                    + "FROM\n"
                    + "personal where edad  " + operador + "" + edad + "    "
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("personal.ci");
                row[2] = rs.getString("personal.nombre");
                row[3] = rs.getString("personal.apellidos");

                row[4] = rs.getString("personal.sexo");
                row[5] = rs.getString("personal.edad");

                row[6] = rs.getString("personal.ocupacion");
                row[7] = rs.getString("personal.contrata");
                row[8] = rs.getString("personal.salario");
                row[9] = rs.getString("personal.tiempo_contrata");
                row[10] = rs.getString("personal.salario_contrata");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Reporte de Busqueda de Producciòn
//Buscar produccion por fecha y ganancia en ventas de sacos
    public void BuscarProducionXfecha(JTable table, String buscar) {
        Statement stmt = null;
        ResultSet rs = null;
        String[] columna = {"No", "Sacos", "Azucar en Pizarra", "Normas de Producción", "Refino", "Total de Azucar",
            "Miel", "Insumo Ajeno", "Refino a Procesar"};

        try {
            int contM = 1;
            Object[] row = new Object[10];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "producion.id_producion,\n"
                    + "producion.sacos,\n"
                    + "producion.azucarPizarra,\n"
                    + "producion.norma_producion,\n"
                    + "producion.tm_refino,\n"
                    + "producion.total_azucar,\n"
                    + "producion.miel,\n"
                    + "producion.insumo_ajeno,\n"
                    + "producion.refino_a_procesar,\n"
                    + "producion.produccion_fecha\n"
                    + "FROM\n"
                    + "producion where produccion_fecha like '%" + buscar + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("producion.sacos");
                row[2] = rs.getString("producion.azucarPizarra");
                row[3] = rs.getString("producion.norma_producion");
                row[4] = rs.getString("producion.tm_refino");
                row[5] = rs.getString("producion.total_azucar");
                row[6] = rs.getString("producion.miel");
                row[7] = rs.getString("producion.insumo_ajeno");
                row[8] = rs.getString("producion.refino_a_procesar");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
// Buscar Produccion por mes  

    public void buscarxmes(JTable table, int mes) {
        Statement stmt = null;
        ResultSet rs = null;

        int uno = 0;
        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;
        int siete = 0;
        int ocho = 0;
        int nueve = 0;
        int diez = 0;
        String[] columna = {"No", "Sacos", "Azucar en Pizarra", "Normas de Producción", "Refino", "Total de Azucar",
            "Miel", "Insumo Ajeno", "Refino a Procesar", "Fecha de Producción"};

        try {
            int contM = 1;
            Object[] row = new Object[10];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "producion.id_producion,\n"
                    + "producion.sacos,\n"
                    + "producion.azucarPizarra,\n"
                    + "producion.norma_producion,\n"
                    + "producion.tm_refino,\n"
                    + "producion.total_azucar,\n"
                    + "producion.miel,\n"
                    + "producion.insumo_ajeno,\n"
                    + "producion.refino_a_procesar,\n"
                    + "producion.produccion_fecha\n"
                    + "FROM\n"
                    + "producion where MONTH (produccion_fecha) like '%" + mes + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("producion.sacos");
                row[2] = rs.getString("producion.azucarPizarra");
                row[3] = rs.getString("producion.norma_producion");
                row[4] = rs.getString("producion.tm_refino");
                row[5] = rs.getString("producion.total_azucar");
                row[6] = rs.getString("producion.miel");
                row[7] = rs.getString("producion.insumo_ajeno");
                row[8] = rs.getString("producion.refino_a_procesar");
                row[9] = rs.getString("producion.produccion_fecha");

                dos += Integer.parseInt(rs.getString("producion.sacos"));
                tres += Integer.parseInt(rs.getString("producion.azucarPizarra"));
                cuatro += Integer.parseInt(rs.getString("producion.norma_producion"));
                cinco += Integer.parseInt(rs.getString("producion.tm_refino"));
                seis += Integer.parseInt(rs.getString("producion.total_azucar"));
                siete += Integer.parseInt(rs.getString("producion.miel"));
                ocho += Integer.parseInt(rs.getString("producion.insumo_ajeno"));
                nueve += Integer.parseInt(rs.getString("producion.refino_a_procesar"));
                modeloTabla.addRow(row);

            }
            row[0] = "Total";
            row[1] = dos;
            row[2] = tres;
            row[3] = cuatro;
            row[4] = cinco;
            row[5] = seis;
            row[6] = siete;
            row[7] = ocho;
            row[8] = nueve;
            row[9] = diez;
            modeloTabla.addRow(row);
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Buscar Produccion por año
    public void buscarxanno(JTable table, int anno) {
        Statement stmt = null;
        ResultSet rs = null;

        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;
        int siete = 0;
        int ocho = 0;
        int nueve = 0;
        int diez = 0;

        String[] columna = {"No", "Sacos", "Azucar en Pizarra", "Normas de Producción", "Refino", "Total de Azucar",
            "Miel", "Insumo Ajeno", "Refino a Procesar", "Fecha de Producción"};

        try {
            int contM = 1;
            Object[] row = new Object[10];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "producion.id_producion,\n"
                    + "producion.sacos,\n"
                    + "producion.azucarPizarra,\n"
                    + "producion.norma_producion,\n"
                    + "producion.tm_refino,\n"
                    + "producion.total_azucar,\n"
                    + "producion.miel,\n"
                    + "producion.insumo_ajeno,\n"
                    + "producion.refino_a_procesar,\n"
                    + "producion.produccion_fecha\n"
                    + "FROM\n"
                    + "producion where YEAR (produccion_fecha) like '%" + anno + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("producion.sacos");
                row[2] = rs.getString("producion.azucarPizarra");
                row[3] = rs.getString("producion.norma_producion");
                row[4] = rs.getString("producion.tm_refino");
                row[5] = rs.getString("producion.total_azucar");
                row[6] = rs.getString("producion.miel");
                row[7] = rs.getString("producion.insumo_ajeno");
                row[8] = rs.getString("producion.refino_a_procesar");
                row[9] = rs.getString("producion.produccion_fecha");

                dos += Integer.parseInt(rs.getString("producion.sacos"));
                tres += Integer.parseInt(rs.getString("producion.azucarPizarra"));
                cuatro += Integer.parseInt(rs.getString("producion.norma_producion"));
                cinco += Integer.parseInt(rs.getString("producion.tm_refino"));
                seis += Integer.parseInt(rs.getString("producion.total_azucar"));
                siete += Integer.parseInt(rs.getString("producion.miel"));
                ocho += Integer.parseInt(rs.getString("producion.insumo_ajeno"));
                nueve += Integer.parseInt(rs.getString("producion.refino_a_procesar"));
                modeloTabla.addRow(row);

            }

            row[0] = "Total";
            row[1] = dos;
            row[2] = tres;
            row[3] = cuatro;
            row[4] = cinco;
            row[5] = seis;
            row[6] = siete;
            row[7] = ocho;
            row[8] = nueve;
            row[9] = 0;
            modeloTabla.addRow(row);

            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Reporte de Busqueda por Consumo
    //Busqueda de Consumo por fecha
    //Busqueda de consumo por mes
    public void buscarxmesconsumo(JTable table, int mes) {
        Statement stmt = null;
        ResultSet rs = null;

        int uno = 0;
        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;
        int siete = 0;
        int ocho = 0;
        int nueve = 0;
        int diez = 0;
        String[] columna = {"No", "Consumo de Aceite", "Consumo de Lodo", "Consumo de Petroleo", "Consumo de Biomasa", "Consumo de Marabu", "Recobrado",
            "Indice del Día", "Indice del Petroleo", "Fecha"};

        try {
            int contM = 1;
            Object[] row = new Object[10];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "consumo.consumo_aceite,\n"
                    + "consumo.id_consumo,\n"
                    + "consumo.consumo_lodo,\n"
                    + "consumo.consumo_petroleo,\n"
                    + "consumo.consumo_biomasa,\n"
                    + "consumo.consumo_marabu,\n"
                    + "consumo.recobrado,\n"
                    + "consumo.indice_dia,\n"
                    + "consumo.indice_petroleo,\n"
                    + "consumo.consumo_fecha\n"
                    + "FROM\n"
                    + "consumo where MONTH (consumo_fecha) like '%" + mes + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("consumo.consumo_aceite");
                row[2] = rs.getString("consumo.consumo_lodo");
                row[3] = rs.getString("consumo_petroleo");
                row[4] = rs.getString("consumo.consumo_biomasa");
                row[5] = rs.getString("consumo.consumo_marabu");
                row[6] = rs.getString("consumo.recobrado");
                row[7] = rs.getString("consumo.indice_dia");
                row[8] = rs.getString("consumo.indice_petroleo");
                row[9] = rs.getString("consumo.consumo_fecha");

                dos += Integer.parseInt(rs.getString("consumo.consumo_aceite"));
                tres += Integer.parseInt(rs.getString("consumo.consumo_lodo"));
                cuatro += Integer.parseInt(rs.getString("consumo_petroleo"));
                cinco += Integer.parseInt(rs.getString("consumo.consumo_biomasa"));
                seis += Integer.parseInt(rs.getString("consumo.consumo_marabu"));
                siete += Integer.parseInt(rs.getString("consumo.recobrado"));
                ocho += Integer.parseInt(rs.getString("consumo.indice_dia"));
                nueve += Integer.parseInt(rs.getString("consumo.indice_petroleo"));
                //diez += Integer.parseInt(rs.getString("consumo.consumo_fecha"));
                modeloTabla.addRow(row);

            }
            row[0] = "Total";
            row[1] = dos;
            row[2] = tres;
            row[3] = cuatro;
            row[4] = cinco;
            row[5] = seis;
            row[6] = siete;
            row[7] = ocho;
            row[8] = nueve;
            row[9] = diez;
            modeloTabla.addRow(row);
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buscarxannoconsumo(JTable table, int anno) {
        Statement stmt = null;
        ResultSet rs = null;

        int uno = 0;
        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;
        int siete = 0;
        int ocho = 0;
        int nueve = 0;
        int diez = 0;
        String[] columna = {"No", "Consumo de Aceite", "Consumo de Lodo", "Consumo de Petroleo", "Consumo de Biomasa", "Consumo de Marabu", "Recobrado",
            "Indice del Día", "Indice del Petroleo", "Fecha"};

        try {
            int contM = 1;
            Object[] row = new Object[10];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "consumo.consumo_aceite,\n"
                    + "consumo.id_consumo,\n"
                    + "consumo.consumo_lodo,\n"
                    + "consumo.consumo_petroleo,\n"
                    + "consumo.consumo_biomasa,\n"
                    + "consumo.consumo_marabu,\n"
                    + "consumo.recobrado,\n"
                    + "consumo.indice_dia,\n"
                    + "consumo.indice_petroleo,\n"
                    + "consumo.consumo_fecha\n"
                    + "FROM\n"
                    + "consumo where YEAR (consumo_fecha) like '%" + anno + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("consumo.consumo_aceite");
                row[2] = rs.getString("consumo.consumo_lodo");
                row[3] = rs.getString("consumo_petroleo");
                row[4] = rs.getString("consumo.consumo_biomasa");
                row[5] = rs.getString("consumo.consumo_marabu");
                row[6] = rs.getString("consumo.recobrado");
                row[7] = rs.getString("consumo.indice_dia");
                row[8] = rs.getString("consumo.indice_petroleo");
                row[9] = rs.getString("consumo.consumo_fecha");

                dos += Integer.parseInt(rs.getString("consumo.consumo_aceite"));
                tres += Integer.parseInt(rs.getString("consumo.consumo_lodo"));
                cuatro += Integer.parseInt(rs.getString("consumo_petroleo"));
                cinco += Integer.parseInt(rs.getString("consumo.consumo_biomasa"));
                seis += Integer.parseInt(rs.getString("consumo.consumo_marabu"));
                siete += Integer.parseInt(rs.getString("consumo.recobrado"));
                ocho += Integer.parseInt(rs.getString("consumo.indice_dia"));
                nueve += Integer.parseInt(rs.getString("consumo.indice_petroleo"));
                //diez += Integer.parseInt(rs.getString("consumo.consumo_fecha"));
                modeloTabla.addRow(row);

            }
            row[0] = "Total";
            row[1] = dos;
            row[2] = tres;
            row[3] = cuatro;
            row[4] = cinco;
            row[5] = seis;
            row[6] = siete;
            row[7] = ocho;
            row[8] = nueve;
            row[9] = diez;
            modeloTabla.addRow(row);
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
