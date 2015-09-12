/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lab01.Clases.Categoria;
import lab01.Clases.DataCategoria;
/**
 *
 * @author gera
 */
public class HCategoria {
    private static HCategoria instancia=null;
    private Map ColCategoria;
    
    private HCategoria(){
       ColCategoria =new HashMap();
    }
    
    
    public static HCategoria getinstance(){
        if (instancia==null)
            instancia = new HCategoria();
        return instancia;
    }
    
    public void addCategoria(Categoria c){
        ColCategoria.put(c.getNombre(), c);
    }
    public boolean member(String nombre){
        return ColCategoria.containsKey(nombre);
    }
    public Map obtenerColeccion(){
        Map ret = new HashMap();
        Iterator it = ColCategoria.entrySet().iterator();
        //Iterator itret = ret.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            DataCategoria dc = new DataCategoria(map.getKey().toString());
            ret.put(map.getKey(), dc);        
        }
        return ret;
        
        
        //return col;
    }
}    