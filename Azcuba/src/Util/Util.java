/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Util {
     public static int confirmarInformacion(Component componentePadre, String titulo, String mensajeInformacion) {
        return JOptionPane.showConfirmDialog(componentePadre, mensajeInformacion, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void centrarDialog(JDialog dialog) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
    }

    public static void ocultar(JDialog dialog) {
        dialog.dispose();
    }

    public static void mostrarError(Component componentePadre, String mensajeError) {
        JOptionPane.showMessageDialog(componentePadre, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarInformacion(Component componentePadre, String titulo, String mensajeInformacion) {
        JOptionPane.showMessageDialog(componentePadre, mensajeInformacion, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
