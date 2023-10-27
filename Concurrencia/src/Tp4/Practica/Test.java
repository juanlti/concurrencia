/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Practica;

/**
 *
 * @author juanc
 */
public class Test {
    
    public static void main(String[] args) throws InterruptedException {
          
             
             Taxi unTaxi=new Taxi(250);
             Pasajero[] unPasajero=new Pasajero[10];
             Conductor unConductor=new Conductor(unTaxi);
             
             for (int i = 0; i < unPasajero.length; i++) {
                 unPasajero[i]=new Pasajero(unTaxi,i);
             }
             unConductor.start();
             
             for (int i = 0; i < unPasajero.length; i++) {
                   unPasajero[i].start();
             }
             while(true){
                          System.out.println("distancia en taxi "+unTaxi.distanciaDePasajero);

             }
             
      }
}
