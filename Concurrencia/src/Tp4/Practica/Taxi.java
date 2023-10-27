/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Practica;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Taxi {

      Semaphore mutexPasajero, mutextConductor, bajarTaxi;
    private int tarifaDeConductor;
    public int distanciaDePasajero = -1;

    public Taxi(int tarifaDeConductor) {
        bajarTaxi = new Semaphore(0);

        mutexPasajero = new Semaphore(1);
        mutextConductor = new Semaphore(-1);
        this.tarifaDeConductor = tarifaDeConductor * (int) 1.3;

    }

    public void solicitarUnTaxi(Thread unPasajero, int distancia) {
        try {
            System.out.println("solicitarUnTaxi " + unPasajero.getName());
            //adquiero un pasajero
            mutexPasajero.acquire();
            // objeto un pasajero y ejecuta las siguientes sentencias
            //  System.out.println("pasajero " + unPasajero.getId());
         
            this.distanciaDePasajero = 5;
            //mutextConductor.release();
              sleep(200);
            
       
            mutexPasajero.release();
            System.out.println("****************Pasajero liberado");

            //aviso al conductor. tp=1
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bajarseTaxi(Thread unPasajero) throws InterruptedException {
        System.out.println("bajarseTaxi  " + unPasajero.getName());
        //unPasajero debe tener un permiso para acceder
        bajarTaxi.acquire();
         //unPasajero perdio el permiso que tenia
     
        mutexPasajero.release();
        System.out.println("Pasajero fuera " + unPasajero.getName());
    }

    /*
    public void realizarViaje() {

        try {

            mutextConductor.acquire();
            //conductor empieza

            //recorrido
            //despierta cliente Tp 1
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
    public int distino(int tarifa) throws InterruptedException {
     
       
        System.out.println("valor de distancia actual -1 ==  "+this.distanciaDePasajero);
       
        //mutextConductor.acquire();
        //System.out.println("valor de distancia actualizado == "+this.distanciaDePasajero);
        //int costo = 0;
        //calculo costo viaje
       // costo = tarifa * this.distanciaDePasajero;

        //System.out.println("Destino, costo: " + costo);
        //despierto pasajero

       // this.bajarTaxi.release();
        return this.distanciaDePasajero;

    }

}
