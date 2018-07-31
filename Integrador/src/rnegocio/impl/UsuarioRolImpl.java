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
public class UsuarioRolImpl implements Serializable{
    public static ArrayList<Usuario_rol> llenarUsuarioRol(ConjuntoResultado rs) throws Exception {
        ArrayList<Usuario_rol> lst = new ArrayList<Usuario_rol>();
        Usuario_rol log = null;
        try {
            while (rs.next()) {
                log = new Usuario_rol(rs.getInt("pcodigo"), rs.getInt("pcodigo_rol"), rs.getInt("pcodigo_usuario"), rs.getInt("pestado"));
                lst.add(log);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    public static ArrayList<Usuario_rol> obtenerLogin(Usuario_rol log) throws Exception {
        ArrayList<Usuario_rol> lst = new ArrayList<Usuario_rol>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, log.getCodigo_usuario()));
            String sql = "select * from actividades.fc_obtener_usuarioRol(?)";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            lst = llenarUsuarioRol(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
