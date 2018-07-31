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

/**
 *
 * @author jloza
 */
public class loginImpl implements Serializable{
    public static ArrayList<Login> llenarlogin(ConjuntoResultado rs) throws Exception {
        ArrayList<Login> lst = new ArrayList<Login>();
        Login log = null;
        try {
            while (rs.next()) {
                log = new Login(rs.getInt("pcodigo"), rs.getString("pidentificacion"), rs.getString("pclave"));
                lst.add(log);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    public static ArrayList<Login> obtenerLogin(Login log) throws Exception {
        ArrayList<Login> lst = new ArrayList<Login>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, log.getIdentificacion()));
            lstP.add(new Parametro(2, log.getClave()));
            String sql = "select * from actividades.fc_obtener_login(?,?)";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            lst = llenarlogin(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
