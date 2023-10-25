/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer6;

/**
 *
 * @author juanc
 */
public class Pasajero extends Thread {
    Taxi unTaxi;
    private int distancia;
    public Pasajero(Taxi unTaxi, int distancia) {
        this.unTaxi=unTaxi;
        this.distancia=distancia;
        
    }
    
    public void run(){
    
    
    this.unTaxi.solicitarUnTaxi(distancia);
    }

}
