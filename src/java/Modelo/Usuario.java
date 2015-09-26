package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String Mail;
    private String pass;
    private String nombre;
    private List<Error> errores;
    
    public Usuario(String Mail, String pass) { //MÉTODO PARA EL VALIDAR USUARIO AL LOGIN
        this.Mail = Mail;
        this.pass = pass;
        errores = new ArrayList<>();
    }

    public Usuario(String Mail, String pass, String nombre) {
        this.Mail = Mail;
        this.pass = pass;
        this.nombre = nombre;
        errores = new ArrayList<>();
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarError (Error err){
        errores.add(err);
    }
    
    public boolean existeError (){
        return !errores.isEmpty();
    }

    public List<Error> getErrores() {
        return errores;
    }
    
}
