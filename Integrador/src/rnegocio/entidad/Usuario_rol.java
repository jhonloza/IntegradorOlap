/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnegocio.entidad;

/**
 *
 * @author andresorozco
 */
public class Usuario_rol {
    
    private int codigo;
    private int codigo_rol;
    private int codigo_usuario;
    private int estado;

    public Usuario_rol(int codigo, int codigo_rol, int codigo_usuario, int estado) {
        this.codigo = codigo;
        this.codigo_rol = codigo_rol;
        this.codigo_usuario = codigo_usuario;
        this.estado = estado;
    }

    public Usuario_rol() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_rol() {
        return codigo_rol;
    }

    public void setCodigo_rol(int codigo_rol) {
        this.codigo_rol = codigo_rol;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
