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
 * @author Jhon
 */
public class PeriodoImpl implements Serializable {
    
    public static boolean Insertar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_periodos(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodo.getNombre()));
            lstP.add(new Parametro(2, periodo.getFecha_inicio()));
            lstP.add(new Parametro(3, periodo.getFecha_fin()));
            lstP.add(new Parametro(4, periodo.getTipo()));
            lstP.add(new Parametro(5, periodo.getObservaciones()));
            lstP.add(new Parametro(6, periodo.getCodigo_sicoa()));
            lstP.add(new Parametro(7, periodo.getEstado()));
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

    public static ArrayList<Periodo> llenarPeriodos(ConjuntoResultado rs) throws Exception {
        ArrayList<Periodo> lst = new ArrayList<Periodo>();
        Periodo periodo = null;
        Facultad facultad=null;
        try {
            while (rs.next()) {
                facultad=new Facultad();
                periodo = new Periodo(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getDate("pfecha_inicio"), rs.getDate("pfecha_fin"), rs.getInt("ptipo"), rs.getString("pobservaciones"), rs.getInt("pcodigo_sicoa"), rs.getInt("pestado"));
                lst.add(periodo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Periodo> ObtenerPeriodos() throws Exception {
        ArrayList<Periodo> lst = new ArrayList<Periodo>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_periodos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPeriodos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Periodo ObtenerPeriodoDadoCodigo(int codigo) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodos_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_periodos(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodo.getNombre()));
            lstP.add(new Parametro(2, periodo.getFecha_inicio()));
            lstP.add(new Parametro(3, periodo.getFecha_fin()));
            lstP.add(new Parametro(4, periodo.getTipo()));
            lstP.add(new Parametro(5, periodo.getObservaciones()));
            lstP.add(new Parametro(6, periodo.getCodigo_sicoa()));
            lstP.add(new Parametro(7, periodo.getEstado()));
            lstP.add(new Parametro(8, periodo.getCodigo()));
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

    public static boolean eliminar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_periodos(?)";
            lstP.add(new Parametro(1, periodo.getCodigo()));
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