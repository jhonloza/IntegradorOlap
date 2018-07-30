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
import static rnegocio.impl.FacultadImp.*;

/**
 *
 * @author Jhon
 */
public class EscuelaImpl implements Serializable {

    public static boolean Insertar(Escuela escuela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_escuela(?,?,?,?,?)";
            lstP.add(new Parametro(1, escuela.getCodigo()));
            lstP.add(new Parametro(2, escuela.getFacultad().getCodigo()));
            lstP.add(new Parametro(3, escuela.getNombre()));
            lstP.add(new Parametro(4, escuela.getDescripcion()));
            lstP.add(new Parametro(5, escuela.getCodigo_sicoa()));
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

    public static ArrayList<Escuela> llenarEscuelas(ConjuntoResultado rs) throws Exception {
        ArrayList<Escuela> lst = new ArrayList<Escuela>();
        Escuela escuela = null;
        Facultad facultad=null;
        try {
            while (rs.next()) {
                facultad=new Facultad();
                escuela = new Escuela(rs.getInt("pcodigo"), ObtenerFacultadDadoCodigo(rs.getInt("pcodigo_facultad")) , rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pcodigo_sicoa"));
                lst.add(escuela);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Escuela> ObtenerEscuelas() throws Exception {
        ArrayList<Escuela> lst = new ArrayList<Escuela>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEscuelas(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Escuela ObtenerEscuelaDadoCodigo(int codigo) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_escuela_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuelas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Escuela ObtenerEscuelaDadoCodigoSicoa(int codigo) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_escuela_codigo_sicoa(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuelas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Escuela ObtenerEscuelaDadoDescripcion(String descripcion) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_escuela_descripcion(?)";
            lstP.add(new Parametro(1, descripcion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuelas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Escuela ObtenerEscuelaDadoNombre(String nombre) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_escuela_nombre(?)";
            lstP.add(new Parametro(1, nombre));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuelas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Escuela ObtenerEscuelaDadoFacultad(int facultad) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_escuela_codigo_facultad(?)";
            lstP.add(new Parametro(1, facultad));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuelas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static boolean actualizar(Escuela escuela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_escuela(?,?,?,?,?)";
            lstP.add(new Parametro(1, escuela.getFacultad().getCodigo()));
            lstP.add(new Parametro(2, escuela.getNombre()));
            lstP.add(new Parametro(3, escuela.getDescripcion()));
            lstP.add(new Parametro(4, escuela.getCodigo_sicoa()));
            lstP.add(new Parametro(5, escuela.getCodigo()));
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

    public static boolean eliminar(Escuela escuela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_escuela(?)";
            lstP.add(new Parametro(1, escuela.getCodigo()));
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