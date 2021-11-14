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
import models.personal;
import models.producion;

/**
 *
 * @author Lenovo
 */
public class dao_producion {

    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();
    DefaultTableModel modeloTabla = null;

    public void insertar(producion p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "INSERT INTO producion (sacos,azucarPizarra,norma_producion,tm_refino,total_azucar,miel,"
                    + "insumo_ajeno,refino_a_procesar,produccion_fecha)VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, p.getSacos());
            ps.setInt(2, p.getAzucar_pizarra());
            ps.setInt(3, p.getNorma_producion());
            ps.setInt(4, p.getTm_refino());
            ps.setInt(5, p.getTotal_azucar());
            ps.setInt(6, p.getMiel());
            ps.setInt(7, p.getInsumo_ajeno());
            ps.setInt(8, p.getRefino_a_procesar());
            ps.setDate(9, p.getProducion_fecha());
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

    public void actualizar(producion p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "UPDATE  producion  set sacos=?,azucarPizarra=?,norma_producion=?,tm_refino=?,total_azucar=?,miel=?,"
                    + "insumo_ajeno=?,refino_a_procesar=? where id_producion=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, p.getSacos());
            ps.setInt(2, p.getAzucar_pizarra());
            ps.setInt(3, p.getNorma_producion());
            ps.setInt(4, p.getTm_refino());
            ps.setInt(5, p.getTotal_azucar());
            ps.setInt(6, p.getMiel());
            ps.setInt(7, p.getInsumo_ajeno());
            ps.setInt(8, p.getRefino_a_procesar());

            ps.setInt(9, p.getId_producion());
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

    public void eliminar(producion p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "DELETE from  producion  where id_producion=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, p.getId_producion());
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
            PreparedStatement ps = conn.prepareStatement("select count(produccion_fecha) from producion where produccion_fecha=?");
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
                    + "producion.Sacos,\n"
                    + "producion.azucarPizarra,\n"
                    + "producion.norma_producion,\n"
                    + "producion.tm_refino,\n"
                    + "producion.total_azucar,\n"
                    + "producion.miel,\n"
                    + "producion.insumo_ajeno,\n"
                    + "producion.refino_a_procesar,\n"
                    + "producion.produccion_fecha\n"
                    + "FROM\n"
                    + "producion"
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

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
