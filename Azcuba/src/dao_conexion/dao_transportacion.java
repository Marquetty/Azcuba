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
import models.transportacion;

/**
 *
 * @author Lenovo
 */
public class dao_transportacion {

    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();
    DefaultTableModel modeloTabla = null;

    public void insertar(transportacion t) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "INSERT INTO transportacion (tipo_vehiculo,modelo,marca)VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, t.getTipo_vehiculo());
            ps.setString(2, t.getModelo());
            ps.setString(3, t.getMarca());
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

    public void actualizar(transportacion t) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "UPDATE  transportacion set tipo_vehiculo=?,marca=?,modelo=? where id_vehiculo=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, t.getTipo_vehiculo());
            ps.setString(2, t.getMarca());
            ps.setString(3, t.getModelo());
            ps.setInt(4, t.getId_vehiculo());
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

    public void eliminar(transportacion t) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "DELETE from transportacion where id_vehiculo=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, t.getId_vehiculo());
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
        String[] columna = {"No", "Tipo de Vehiculo", "Modelo", "Marca"};

        try {
            int contM = 1;
            Object[] row = new Object[8];
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
                    + "transportacion.id_vehiculo,\n"
                    + "transportacion.tipo_vehiculo,\n"
                    + "transportacion.modelo,\n"
                    + "transportacion.marca\n"
                    + "FROM\n"
                    + "transportacion"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("transportacion.tipo_vehiculo");
                row[2] = rs.getString("transportacion.modelo");
                row[3] = rs.getString("transportacion.marca");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
