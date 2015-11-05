/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author joaquin
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class DataRestaurante {
    private String nickname;
    private String nombre;
    private String email;
    private String direccion;
    private String pwd;
    private float promedio;
    private ArrayList<String> lstImagen;
    private ArrayList<DataCategoria> ColCategoria = new ArrayList<>();
    private ArrayList<DataPromocional> ColPromocionales = new ArrayList<>();
    private ArrayList<DataIndividual> ColIndividuales = new ArrayList<>();

    
    public DataRestaurante(){}
    
    public DataRestaurante(String nickname, String nombre, String mail, String direccion, ArrayList<String>lstImagen, ArrayList<DataPromocional> colPromocionales, ArrayList<DataIndividual> colIndividuales,  ArrayList<DataCategoria> colCategoria, String pwd){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.pwd = pwd;
        if(lstImagen == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>();
            this.lstImagen.addAll(lstImagen);
        }
        if(colPromocionales == null){
            this.ColPromocionales = null;
        }else{
            this.ColPromocionales = new ArrayList<>();
            this.ColPromocionales.addAll(colPromocionales);
        }
        if(colIndividuales == null){
            this.ColIndividuales = null;
        }else{
            this.ColIndividuales = new ArrayList<>();
            this.ColIndividuales.addAll(colIndividuales);
        }
        if(colCategoria == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new ArrayList<>();
            this.ColCategoria.addAll(colCategoria);
        }
    }
    
    public DataRestaurante(String nickname,  String nombre, String mail, String direccion, ArrayList<String>lstImagen, ArrayList<DataPromocional> colPromocionales, ArrayList<DataIndividual> colIndividuales,  ArrayList<DataCategoria> colCategoria, String pwd, float promedio){
        this.nickname=nickname;
        this.nombre=nombre;
        this.email=mail;
        this.direccion=direccion;
        this.pwd = pwd;
        this.promedio = promedio;
        if(lstImagen == null){
            this.lstImagen = null;
        }else{
            this.lstImagen = new ArrayList<>();
            this.lstImagen.addAll(lstImagen);
        }
        if(colPromocionales == null){
            this.ColPromocionales = null;
        }else{
            this.ColPromocionales = new ArrayList<>();
            this.ColPromocionales.addAll(colPromocionales);
        }
        if(colIndividuales == null){
            this.ColIndividuales = null;
        }else{
            this.ColIndividuales = new ArrayList<>();
            this.ColIndividuales.addAll(colIndividuales);
        }
        if(colCategoria == null){
            this.ColCategoria = null;
        }else{
            this.ColCategoria = new ArrayList<>();
            this.ColCategoria.addAll(colCategoria);
        }
    }

    public boolean member(String nombre){
        Iterator dcats = getColCategoria().iterator();
        while(dcats.hasNext()){
            DataCategoria dc = (DataCategoria)dcats.next();
            if(dc.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setEmail(String mail){
        this.email = mail;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public void setLstImagen(ArrayList<String> lstImagen){
        this.lstImagen = lstImagen;
    }
    
    public ArrayList<String> getLstImagen(){
        return this.lstImagen;
    }
    
    public void setColCategoria(ArrayList<DataCategoria> colCategoria){
        this.ColCategoria.addAll(colCategoria);
    }
    
    public ArrayList<DataCategoria> getColCategoria(){
        return this.ColCategoria;
    }
    
    public ArrayList<DataPromocional> getColPromocionales(){
        return this.ColPromocionales;
    }

    public void setColPromocionales(ArrayList<DataPromocional> ColPromocionales) {
        this.ColPromocionales = ColPromocionales;
    }
    
    public void setColProducto(ArrayList<DataPromocional> colPromocionales){
        this.ColPromocionales.addAll(colPromocionales);
    }
    
    public ArrayList<DataIndividual> getColIndividuales(){
        return this.ColIndividuales;
    }
    
    public void setColIndividuales(ArrayList<DataIndividual> colIndividuales){
        this.ColIndividuales.addAll(colIndividuales);
    }
    
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    
    public String getPwd(){
        return this.pwd;
    }
    
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
    
    public float getPromedio(){
        return this.promedio;
    }
    
    public String getLogo(){
     String logo;
        if(this.lstImagen!=null){
            logo = this.lstImagen.get(0);   
        }else{
            logo = "";     
        }
        return logo; 
    }
}
