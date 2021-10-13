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
import models.personal;

/**
 *
 * @author Lenovo
 */
public class dao_producion {
      private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();

    public void insertar(personal p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "INSERT INTO personal (ci,ocupacion,contrata,salario,tiempo_contrata,salario_total)VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getCi());
            ps.setString(2, p.getOcupacion());
            ps.setString(3, p.getCotrata());
            ps.setInt(4, p.getSalario());
            ps.setString(5, p.getCotrata());
            ps.setInt(6, p.getSalario_total());
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

    public void actualizar(personal p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "UPDATE  personal  set ci=?,ocupacion=?,contrata=?,salario=?"
                    + ",tiempo_contrata=?,salario_total=? where id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getCi());
            ps.setString(2, p.getOcupacion());
            ps.setString(3, p.getCotrata());
            ps.setInt(4, p.getSalario());
            ps.setString(5, p.getCotrata());
            ps.setInt(6, p.getSalario_total());
            ps.setInt(7, p.getId());
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

    public void eliminar(personal p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "DELETE from  personal  where id=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, p.getId());
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
    
}
