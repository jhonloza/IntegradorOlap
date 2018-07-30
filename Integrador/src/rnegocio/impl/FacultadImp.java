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
 * @author Jhon
 */
public class FacultadImp implements Serializable {

    public static boolean Insertar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_facultad(?,?,?,?)";
            lstP.add(new Parametro(1, facultad.getCodigo()));
            lstP.add(new Parametro(2, facultad.getNombre()));
            lstP.add(new Parametro(3, facultad.getDescripcion()));
            lstP.add(new Parametro(4, facultad.getCodigo_sicoa()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<Facultad> llenarFacultades(ConjuntoResultado rs) throws Exception {
        ArrayList<Facultad> lst = new ArrayList<Facultad>();
        Facultad facultad = null;
        try {
            while (rs.next()) {
                facultad = new Facultad(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pcodigo_sicoa"));
                lst.add(facultad);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Facultad> ObtenerFacultades() throws Exception {
        ArrayList<Facultad> lst = new ArrayList<Facultad>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_facultad()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFacultades(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Facultad ObtenerFacultadDadoCodigo(int codigo) throws Exception {
        Facultad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_facultad_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Facultad();
            lst = llenarFacultades(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Facultad ObtenerFacultadDadoCodigoSicoa(int codigo) throws Exception {
        Facultad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_facultad_codigo_sicoa(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Facultad();
            lst = llenarFacultades(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Facultad ObtenerFacultadDadoDescripcion(String descripcion) throws Exception {
        Facultad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_facultad_descripcion(?)";
            lstP.add(new Parametro(1, descripcion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Facultad();
            lst = llenarFacultades(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Facultad ObtenerFacultadDadoNombre(String nombre) throws Exception {
        Facultad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_facultad_nombre(?)";
            lstP.add(new Parametro(1, nombre));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Facultad();
            lst = llenarFacultades(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static boolean actualizar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_facultad(?,?,?,?)";
            lstP.add(new Parametro(1, facultad.getNombre()));
            lstP.add(new Parametro(2, facultad.getDescripcion()));
            lstP.add(new Parametro(3, facultad.getCodigo_sicoa()));
            lstP.add(new Parametro(4, facultad.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean eliminar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_facultad(?)";
            lstP.add(new Parametro(1, facultad.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}