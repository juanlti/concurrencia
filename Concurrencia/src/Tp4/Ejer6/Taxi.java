package Tp4.ejer6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juan.barrera
 */
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
    private int distanciaDePasajero = -1;

    public Taxi(int tarifaDeConductor) {
        bajarTaxi = new Semaphore(0);

        mutexPasajero = new Semaphore(1);
        mutextConductor = new Semaphore(0);
        this.tarifaDeConductor = tarifaDeConductor * (int) 1.3;

    }

    public void solicitarUnTaxi(Thread unPasajero, int distancia) {
        try {
           
            //adquiero un pasajero
            mutexPasajero.acquire();
             System.out.println("solicitarUnTaxi " + unPasajero.getName());
            // objeto un pasajero y ejecuta las siguientes sentencias
            //  System.out.println("pasajero " + unPasajero.getId());
            this.distanciaDePasajero = distancia;
            //verifico disponibilidad
            mutextConductor.release();

            //aviso al conductor. tp=1
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bajarseTaxi(Thread unPasajero) throws InterruptedException {
        System.out.println("bajarseTaxi  " + unPasajero.getName());
        bajarTaxi.acquire();
        //mutextConductor.release();
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
    public void distino(int tarifa) throws InterruptedException {
        System.out.println("conductor se duerme " + tarifa);
        mutextConductor.acquire();
        int costo = 0;
        //calculo costo viaje
        costo = tarifa * this.distanciaDePasajero;

        System.out.println("Destino, costo: " + costo);
        //despierto pasajero

        this.bajarTaxi.release();

    }

}