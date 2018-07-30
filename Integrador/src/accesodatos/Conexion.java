/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author dpalacios
 */
public class Conexion implements Serializable {

    private String driver;
    private String url;
    public String user;
    private String pass;
    private Connection con;
    private PreparedStatement prStm;
    private ResultSet rs;

    public String getDriver() {
        return this.driver;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String pass) {
        this.setPass(pass);
    }

    public Conexion() throws Exception {
        Global global = new Global();
        this.driver = global.getDRIVER();
        this.url = global.getURL();
        this.user = global.getUSER();
        this.pass = global.getPASS();
        try {
            // Context c = new InitialContext();
            // DataSource ds = (DataSource) c.lookup("jdbc/tutoriasJDBC");
            // this.con = ds.getConnection();
            Class.forName(this.driver);
            con = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (Exception e) {
            throw e;
        }
    }

    public void desconectar() throws Exception {
        try {
            getCon().close();
            setCon(null);
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the prStm
     */
    public PreparedStatement getPrStm() {
        return prStm;
    }

    /**
     * @param prStm the prStm to set
     */
    public void setPrStm(PreparedStatement prStm) {
        this.prStm = prStm;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
