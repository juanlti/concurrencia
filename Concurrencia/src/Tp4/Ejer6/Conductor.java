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
public class Conductor extends Thread{
    
    private boolean disponibilidad;
    private int tarifa;
    Taxi unTaxi;
    public Conductor(Taxi unTaxi){
    this.disponibilidad=true;
    this.tarifa=tarifa;
    this.unTaxi=unTaxi;
    }
    
    
    
     public void run(){
    
    
           this.unTaxi.realizarViaje(tarifa);
    }
}
