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
import models.personal;
import models.transportacion;

/**
 *
 * @author Lenovo
 */
public class dao_personal {

    DefaultTableModel modeloTabla = null;

    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();

    public void insertar(personal p) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "INSERT INTO personal (ci,nombre,apellidos,ocupacion,contrata,salario,tiempo_contrata,salario_contrata)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getCi());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellidos());
            ps.setString(4, p.getOcupacion());
            ps.setString(5, p.getContrata());
            ps.setInt(6, p.getSalario());
            ps.setInt(7, p.getSalario_contrata());
            ps.setInt(8, p.getTiempo_contrata());
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
            String query = "UPDATE  personal  set ci=?,nombre=?,apellidos=?,ocupacion=?,contrata=?,salario=?"
                    + ",tiempo_contrata=?,salario_contrata=? where id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, p.getCi());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getOcupacion());
            ps.setString(4, p.getContrata());
            ps.setInt(5, p.getSalario());
            ps.setInt(6, p.getSalario_contrata());
            ps.setInt(7, p.getTiempo_contrata());
            ps.setInt(8, p.getId());
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

    public int Existe(String ci) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select count(ci) from personal where ci=?");
            ps.setString(1, ci);
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
        String[] columna = {"No", "CI", "Nombre", "Apellidos", "Ocupacion", "Contrata",
            "Salario", "Salario de contrata", "Tiempo de Contrata"};

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
                    + "personal.id,\n"
                    + "personal.ci,\n"
                    + "personal.ocupacion,\n"
                    + "personal.contrata,\n"
                    + "personal.salario,\n"
                    + "personal.tiempo_contrata,\n"
                    + "personal.salario_contrata,\n"
                    + "personal.nombre,\n"
                    + "personal.apellidos\n"
                    + "FROM\n"
                    + "personal"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("personal.ci");
                row[2] = rs.getString("personal.nombre");
                row[3] = rs.getString("personal.apellidos");
                row[4] = rs.getString("personal.ocupacion");
                row[5] = rs.getString("personal.contrata");
                row[6] = rs.getString("personal.salario");
                row[7] = rs.getString("personal.tiempo_contrata");
                row[8] = rs.getString("personal.salario_contrata");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Buscar(JTable table, String buscar) {
        Statement stmt = null;
        ResultSet rs = null;
        String[] columna = {"No", "CI", "Nombre", "Apellidos", "Ocupacion", "Contrata",
            "Salario", "Salario de contrata", "Tiempo de Contrata"};

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
                    + "personal.id,\n"
                    + "personal.ci,\n"
                    + "personal.ocupacion,\n"
                    + "personal.contrata,\n"
                    + "personal.salario,\n"
                    + "personal.tiempo_contrata,\n"
                    + "personal.salario_contrata,\n"
                    + "personal.nombre,\n"
                    + "personal.apellidos\n"
                    + "FROM\n"
                    + "personal where nombre like '%" + buscar + "%' or ci like '%" + buscar + "%'"
            );
            while (rs.next()) {
                row[0] = contM++;
                row[1] = rs.getString("personal.ci");
                row[2] = rs.getString("personal.nombre");
                row[3] = rs.getString("personal.apellidos");
                row[4] = rs.getString("personal.ocupacion");
                row[5] = rs.getString("personal.contrata");
                row[6] = rs.getString("personal.salario");
                row[7] = rs.getString("personal.tiempo_contrata");
                row[8] = rs.getString("personal.salario_contrata");

                modeloTabla.addRow(row);

            }
            table.setModel(modeloTabla);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
