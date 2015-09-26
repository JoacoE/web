/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

/**
 *
 * @author joaco
 */
public class DTOActualizarPromocional {
    private DataPromocional dp;
    private String nombre;
    private String nickRest;
    
    public DTOActualizarPromocional(){
    }
    
    public DTOActualizarPromocional(DataPromocional dp, String nombre, String nickRest){
        this.dp = dp;
        this.nombre = nombre;
        this.nickRest = nickRest;
    }

    public DataPromocional getDp() {
        return dp;
    }

    public void setDp(DataPromocional dp) {
        this.dp = dp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickRest() {
        return nickRest;
    }

    public void setNickRest(String nickRest) {
        this.nickRest = nickRest;
    }
}
