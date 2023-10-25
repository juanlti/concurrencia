/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.ejer6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan.barrera
 */
public class Pasajero extends Thread {
    Taxi unTaxi;
    private int distancia;
    public Pasajero(Taxi unTaxi, int distancia) {
        this.unTaxi=unTaxi;
        this.distancia=distancia;
        
    }
    
    public void run(){
    
    
    this.unTaxi.solicitarUnTaxi(this,distancia);
    
        try {
            this.unTaxi.bajarseTaxi(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}