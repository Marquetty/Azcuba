/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conexion;

import auth.Auth;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.consumo;

/**
 *
 * @author Lenovo
 */
public class dao_consumo {

    DefaultTableModel modeloTabla = null;
    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();

    public void insertar(consumo c) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "INSERT INTO consumo (consumo_aceite,consumo_lodo,consumo_petroleo,consumo_biomasa,consumo_marabu"
                    + ",recobrado,indice_dia,indice_petroleo,consumo_fecha)VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, c.getConsumo_aceite());
            ps.setInt(2, c.getConsumo_lodo());
            ps.setInt(3, c.getConsumo_petroleo());
            ps.setInt(4, c.getBiomasa());
            ps.setInt(5, c.getMarabu());
            ps.setInt(6, c.getRecobrado());
            ps.setInt(7, c.getIndice_dia());
            ps.setInt(8, c.getIndice_pretroleo());
            ps.setDate(9, c.getConsumo_fecha());
            ps.executeUpdate();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }

            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {

                }

            }
        }

    }

    public void actualizar(consumo c) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "UPDATE  consumo  set consumo_aceite=?,consumo_lodo=?,consumo_petroleo=?,consumo_biomasa=?,consumo_marabu=?"
                    + ",recobrado=?,indice_dia=?,indice_petroleo=? where id_consumo=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, c.getConsumo_aceite());
            ps.setInt(2, c.getConsumo_lodo());
            ps.setInt(3, c.getConsumo_petroleo());
            ps.setInt(4, c.getBiomasa());
            ps.setInt(5, c.getMarabu());
            ps.setInt(6, c.getRecobrado());
            ps.setInt(7, c.getIndice_dia());
            ps.setInt(8, c.getIndice_pretroleo());
            ps.setInt(9, c.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }

            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {

                }

            }
        }

    }

    public void eliminar(consumo c) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "DELETE from  consumo  where id_consumo=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, c.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }

            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {

                }

            }
        }

    }

    public int existe(Date date) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select count(consumo_fecha) from consumo where consumo_fecha=?");
            ps.setDate(1, date);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }

    public void llenarTabla(JTable table) {
        Statement stmt = null;
        ResultSet rs = null;
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
                    + "consumo\n"
                    + "ORDER BY\n"
                    + "consumo.consumo_fecha ASC"
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
            //    row[9] = rs.getString("consumo.consumo_fecha");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
