/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Uknown
 */
public class ControlAcceso {
    private String usuario;
    private String password;

    public ControlAcceso(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public boolean concedeAcceso(){
        return usuario.equals("OMAR")&&password.equals("ACCESAR");
    }
}
