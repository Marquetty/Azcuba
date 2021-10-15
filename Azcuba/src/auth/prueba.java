/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import dao_conexion.dao_consumo;
import dao_conexion.dao_personal;
import dao_conexion.dao_transportacion;
import java.sql.Date;
import models.personal;
import models.transportacion;

/**
 *
 * @author Lenovo
 */
public class prueba {

    public static void main(String[] args) {
        dao_conexion.dao_transportacion st = new dao_transportacion();
        dao_personal dp = new dao_personal();
        dao_consumo dc= new dao_consumo();
        models.transportacion t = new transportacion(1, "saddddd", "lollllll", "llllqwe");
        models.personal p = new personal(1, "asd", "sadas", "asdas", 12, "asdasddd", 54);
        models.consumo c = new models.consumo(2, 0, 0, 6, 5, 3, 3, 0, new Date(2021,9,23));
        //st.insertar(t);
        // st.actualizar(t);
        //  st.eliminar(t);
        dp.eliminar(p);
        
        dc.insertar(c);
        dc.actualizar(c);
    }
}
