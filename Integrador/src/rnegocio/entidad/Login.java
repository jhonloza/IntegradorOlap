/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.entidad;

/**
 *
 * @author jloza
 */
public class Login {
    private int codigo;
    private String identificacion;
    private String clave;

    public Login() {
    }

    public Login(int codigo, String identificacion, String clave) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.clave = clave;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
