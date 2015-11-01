/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.server;

/**
 *
 * @author joaco
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        PublicadorPedido pPed = new PublicadorPedido();
        PublicadorProducto pProd = new PublicadorProducto();
        PublicadorUsuario pUsr = new PublicadorUsuario();
        pPed.publicPed();
        pProd.publicProd();
        pUsr.publicUsr();
    }
}