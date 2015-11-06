/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author joaco
 */
public class Evaluacion {
    
    private String comentario;
    private float puntaje;
    private String fecha;

    public Evaluacion(){}
    
    public Evaluacion(String comentario, float puntaje){
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public DtoEvaluacion getDTOEvaluacion(){
        return new DtoEvaluacion(getComentario(), getPuntaje(), getFecha());
    }
}
