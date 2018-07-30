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

public class ModalidadTutoriaImpl implements Serializable {

    public static boolean Insertar(Modalidad modalidad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_modalidad_tutoria(?,?,?)";
            lstP.add(new Parametro(1, modalidad.getNombre()));
            lstP.add(new Parametro(2, modalidad.getDescripcion()));
            lstP.add(new Parametro(3, modalidad.getEstado()));
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

    public static ArrayList<Modalidad> llenarModalidad(ConjuntoResultado rs) throws Exception {
        ArrayList<Modalidad> lst = new ArrayList<Modalidad>();
        Modalidad modalidad = null;
        try {
            while (rs.next()) {
                modalidad = new Modalidad(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pestado"));
                lst.add(modalidad);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Modalidad> ObtenerModalidad() throws Exception {
        ArrayList<Modalidad> lst = new ArrayList<Modalidad>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_modalidad_tutoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarModalidad(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Modalidad ObtenerModalidadDadoCodigo(int codigo) throws Exception {
        Modalidad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_modalidad_tutoria_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Modalidad();
            lst = llenarModalidad(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Modalidad modalidad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_modalidad_tutoria(?,?,?,?)";
            lstP.add(new Parametro(1, modalidad.getNombre()));
            lstP.add(new Parametro(2, modalidad.getDescripcion()));
            lstP.add(new Parametro(3, modalidad.getEstado()));
            lstP.add(new Parametro(4, modalidad.getCodigo()));
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

    public static boolean eliminar(Modalidad modalidad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_modalidad_tutoria(?)";
            lstP.add(new Parametro(1, modalidad.getCodigo()));
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