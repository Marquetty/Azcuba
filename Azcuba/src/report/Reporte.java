/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import auth.Auth;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lenovo
 */
public class Reporte {
    
    private final Auth SQL = new Auth();
    private final Connection conn = SQL.conectarMySQL();
    
    public void reporte() {
        
        Workbook book;
        book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Persona");
        try {
            InputStream is = new FileInputStream("src\\Image\\images.jpg");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();
            
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            ClientAnchor achor = help.createClientAnchor();
            achor.setCol1(0);
            achor.setRow1(1);
            Picture pict = draw.createPicture(achor, imgIndex);
            pict.resize(1, 3);
            
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);
            
            Row filaTitulo = sheet.createRow(1);
            Cell celdatitulo = filaTitulo.createCell(1);
            celdatitulo.setCellStyle(tituloEstilo);
            celdatitulo.setCellValue("Reporte de Personal");
            
            sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));
            
            String[] Cabecera = new String[]{"CI", "Nombre", "Apellidos", "sexo", "edad", "Ocupacion", "Contrata",
                "Salario", "Salario de contrata", "Tiempo de Contrata"};
            
            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);
            Row FilaEncabezados = sheet.createRow(9);
            for (int i = 0; i < Cabecera.length; i++) {
                Cell celdaEncabezados = FilaEncabezados.createCell(i);
                celdaEncabezados.setCellStyle(headerStyle);
                celdaEncabezados.setCellValue(Cabecera[i]);
            }
            
            Statement stmt = null;
            ResultSet rs = null;
            int numFiladatos = 10;
            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            
            stmt = conn.createStatement();
            // Query que usarás para hacer lo que necesites
            String query = "SELECT\n"
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
                    + "personal";
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            int numcol = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFiladatos);
                for (int i = 0; i < numcol; i++) {
                    Cell CeldaDatos = filaDatos.createCell(i);
                    CeldaDatos.setCellStyle(datosEstilo);
                    if (i == 2 || i == 3) {
                        CeldaDatos.setCellValue(rs.getString(i + 1));
                    } else {
                        CeldaDatos.setCellValue(rs.getString(i + 1));
                    }
                }
                numFiladatos++;
            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.setZoom(150);
            
            FileOutputStream fileout = null;
            fileout = new FileOutputStream("ReportePersona.xlsx");
            
            book.write(fileout);
            
            fileout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reporte.class
                    .getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(Reporte.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
