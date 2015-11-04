/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author joaco
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTOEvaluacion {
    
    private String comentario;
    private float puntaje;
    private String fecha;
    private String nickname;
    
    public DTOEvaluacion(){}
    
    public DTOEvaluacion(String comentario, float puntaje){
        this.comentario = comentario;
        this.puntaje = puntaje;
    }
    
    public DTOEvaluacion(String comentario, float puntaje, String fecha){
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return this.nickname;
    }
}
