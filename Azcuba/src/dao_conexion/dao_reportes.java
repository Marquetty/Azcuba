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
}
