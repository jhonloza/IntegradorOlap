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
import rnegocio.impl.EscuelaImpl.*;
import rnegocio.impl.NivelImpl.*;

/**
 *
 * @author Jhon
 */
public class EstudianteImpl implements Serializable {
    
    public static boolean Insertar(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_estudiante(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombre()));
            lstP.add(new Parametro(2, estudiante.getApellido()));
            lstP.add(new Parametro(3, estudiante.getCedula()));
            lstP.add(new Parametro(4, estudiante.getCodigo_sicoa()));
            lstP.add(new Parametro(5, estudiante.getPeriodo().getCodigo()));
            lstP.add(new Parametro(6, estudiante.getNivel().getCodigo()));
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

    public static ArrayList<Estudiante> llenarEstudiantes(ConjuntoResultado rs) throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        Estudiante estudiante = null;
        Facultad facultad=null;
        try {
            while (rs.next()) {
                facultad=new Facultad();
                estudiante = new Estudiante(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("papellido"), rs.getString("pcedula"), rs.getInt("pcodigo_sicoa"), PeriodoImpl.ObtenerPeriodoDadoCodigo(rs.getInt("pcodigo_periodo")), NivelImpl.ObtenerNivelDadoCodigo(rs.getInt("pcodigo_nivel")));
                lst.add(estudiante);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Estudiante> ObtenerEstudiantes() throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_estudiante()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstudiantes(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Estudiante ObtenerEstudianteDadoCodigo(int codigo) throws Exception {
        Estudiante lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_estudiante_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Estudiante();
            lst = llenarEstudiantes(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
           String sql = "select * from actividades.fa_estudiante(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombre()));
            lstP.add(new Parametro(2, estudiante.getApellido()));
            lstP.add(new Parametro(3, estudiante.getCedula()));
            lstP.add(new Parametro(4, estudiante.getCodigo_sicoa()));
            lstP.add(new Parametro(5, estudiante.getPeriodo().getCodigo()));
            lstP.add(new Parametro(6, estudiante.getNivel().getCodigo()));
            lstP.add(new Parametro(8, estudiante.getCodigo()));
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

    public static boolean eliminar(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_estudiante(?)";
            lstP.add(new Parametro(1, estudiante.getCodigo()));
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