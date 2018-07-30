/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.impl;
import rnegocio.entidad.*;
import accesodatos.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.Serializable;
import rnegocio.impl.*;
/**
 *
 * @author jloza
 */
public class RolImpl implements Serializable{
    public static ArrayList<Rol> llenarRols(ConjuntoResultado rs) throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        Rol rol = null;
        try {
            while (rs.next()) {
                rol = new Rol(rs.getInt("pcodigo"), rs.getString("pnombre"));
                lst.add(rol);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Rol> ObtenerRols() throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_rol()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRols(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
