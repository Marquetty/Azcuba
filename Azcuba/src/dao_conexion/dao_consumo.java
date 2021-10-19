/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conexion;

import auth.Auth;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.consumo;
import models.personal;

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
            String query = "INSERT INTO consumo (consumo_lodo,consumo_petroleo,consumo_biomasa,consumo_marabu"
                    + ",recobrado,indice_dia,indice_petroleo,consumo_fecha)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, c.getConsumo_lodo());
            ps.setInt(2, c.getConsumo_petroleo());
            ps.setInt(3, c.getBiomasa());
            ps.setInt(4, c.getMarabu());
            ps.setInt(5, c.getRecobrado());
            ps.setInt(6, c.getIndice_dia());
            ps.setInt(7, c.getIndice_pretroleo());
            ps.setDate(8, c.getConsumo_fecha());
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
            String query = "UPDATE  consumo  set consumo_lodo=?,consumo_petroleo=?,consumo_biomasa=?,consumo_marabu=?"
                    + ",recobrado=?,indice_dia=?,indice_petroleo=?,consumo_fecha=? where id_consumo=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, c.getConsumo_lodo());
            ps.setInt(2, c.getConsumo_petroleo());
            ps.setInt(3, c.getBiomasa());
            ps.setInt(4, c.getMarabu());
            ps.setInt(5, c.getRecobrado());
            ps.setInt(6, c.getIndice_dia());
            ps.setInt(7, c.getIndice_pretroleo());
            ps.setDate(8, c.getConsumo_fecha());
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
            String query = "DELETE from  consumo  where id=?";
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

    public void llenarTabla(JTable table) {
        Statement stmt = null;
        ResultSet rs = null;
        String[] columna = {"No", "nombre", "Comite Primario"};
        

        try {
            int contM = 1;
            Object[] row = new Object[6];
            modeloTabla = new DefaultTableModel(null, columna) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT\n"
                    + "comite_base.cb_id,\n"
                    + "comite_base.cb_nombre,\n"
                    + "comite_base.cb_cp_id,\n"
                    + "comite_primario.cp_id,\n"
                    + "comite_primario.cp_nombre\n"
                    + "FROM\n"
                    + "comite_base\n"
                    + "INNER JOIN comite_primario ON comite_base.cb_cp_id = comite_primario.cp_id"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("cb_nombre");
                row[2] = rs.getString("comite_primario.cp_nombre");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
