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
import static rnegocio.impl.EscuelaImpl.*;

/**
 *
 * @author Jhon
 */
public class NivelImpl implements Serializable {

    public static boolean Insertar(Nivel nivel) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_nivel(?,?,?,?,?)";
            lstP.add(new Parametro(1, nivel.getCodigo_sicoa()));
            lstP.add(new Parametro(2, nivel.getNombre()));
            lstP.add(new Parametro(3, nivel.getParalelo()));
            lstP.add(new Parametro(4, nivel.getModalidad()));
            lstP.add(new Parametro(5, nivel.getCodigo_escuela().getCodigo()));
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

    public static ArrayList<Nivel> llenarNivels(ConjuntoResultado rs) throws Exception {
        ArrayList<Nivel> lst = new ArrayList<Nivel>();
        Nivel nivel = null;
        Facultad facultad=null;
        try {
            while (rs.next()) {
                facultad=new Facultad();
                nivel = new Nivel(rs.getInt("pcodigo"), rs.getInt("pcodigo_sicoa"), rs.getString("pnombre"), rs.getString("pparalelo"), rs.getString("pmodalidad"), ObtenerEscuelaDadoCodigo(rs.getInt("pcodigo_escuela")));
        //(r, rs.getInt("pcodigo_sicoa") , rs.getString("pnombre"), rs.getString("pnombre"), rs.getString("pnombre"), ObtenerFacultadDadoCodigo(rs.getInt("pcodigo_facultad")));
                lst.add(nivel);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Nivel> ObtenerNivels() throws Exception {
        ArrayList<Nivel> lst = new ArrayList<Nivel>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_nivel()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarNivels(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Nivel ObtenerNivelDadoCodigo(int codigo) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Nivel ObtenerNivelDadoCodigoSicoa(int codigo) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_codigosicoa(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Nivel ObtenerNivelDadoNombre(String nombre) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_nombre(?)";
            lstP.add(new Parametro(1, nombre));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Nivel ObtenerNivelDadoModalidad(String modalidad) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_modalidad(?)";
            lstP.add(new Parametro(1, modalidad));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Nivel ObtenerNivelDadoParalelo(String paralelo) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_paralelo(?)";
            lstP.add(new Parametro(1, paralelo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Nivel ObtenerNivelDadoEscuela(Escuela escuela) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_nivel_codigo_escuela(?)";
            lstP.add(new Parametro(1, escuela.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivels(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static boolean actualizar(Nivel nivel) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_nivel(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, nivel.getCodigo_sicoa()));
            lstP.add(new Parametro(2, nivel.getNombre()));
            lstP.add(new Parametro(3, nivel.getParalelo()));
            lstP.add(new Parametro(4, nivel.getModalidad()));
            lstP.add(new Parametro(5, nivel.getCodigo_escuela().getCodigo()));
            lstP.add(new Parametro(6, nivel.getCodigo()));
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

    public static boolean eliminar(Nivel nivel) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_nivel(?)";
            lstP.add(new Parametro(1, nivel.getCodigo()));
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