/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Cliente extends Thread {
    
    GestionImpresion unaGestion;
    int unTiempo;
    public  Cliente(GestionImpresion unaGestion, int unTiempo){
        this.unaGestion=unaGestion;
        this.unTiempo=unTiempo;
    }
    
    
    public void run(){
    
        try {
            //tiempo de cliente para realizar la impresion
            System.out.println("Tiempo de cliente");
            Thread.sleep(unTiempo*1,3);
            this.unaGestion.gestion(this, unTiempo);

        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
