/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Taxi {

    Conductor unConductor;
    Semaphore mutexPasajero, mutextConductor;
    private int tarifaDeConductor;
    private int distanciaDePasajero=-1;
    public Taxi(int tarifaDeConductor) {
        this.unConductor = unConductor;
        mutexPasajero = new Semaphore(1);
        mutextConductor = new Semaphore(1);
        this.tarifaDeConductor=tarifaDeConductor*(int)1.3;

    }

    public void solicitarUnTaxi(int distancia) {
        try {
            //adquiero un pasajero
            mutexPasajero.acquire();
            
           this.distanciaDePasajero=distancia;
            //verifico disponibilidad
           
            mutextConductor.release();
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void realizarViaje(int tarifa){
        
        try {
            //verifico
            mutextConductor.acquire();
            int costo=0;
            //calculo costo viaje
            costo=tarifa* this.distanciaDePasajero;
            
            //despierta cliente
              mutexPasajero.release();
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
