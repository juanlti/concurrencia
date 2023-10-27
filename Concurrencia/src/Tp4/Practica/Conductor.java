/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Practica;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Conductor extends Thread {

    private boolean disponibilidad;
    private int tarifa;
    Taxi unTaxi;

    public Conductor(Taxi unTaxi) {
        this.disponibilidad = true;

        this.unTaxi = unTaxi;
    }

    public void run() {
        int i = 0;
        
        
        while(true){
            try {
                int res=-14;
                res=this.unTaxi.distino(15);
                System.out.println("nuevo valor -1 o 5 "+res);
            } catch (InterruptedException ex) {
                Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*
        while (true) {

            
            try {
                Random random = new Random();
                int randomNumber = random.nextInt((2000 - 500) + 1) + 500;
                this.unTaxi.distino(randomNumber);
               // this.unTaxi.realizarViaje();

                //sleep(randomNumber);
                //espera un tiempo
                i = i + 1;
            } catch (InterruptedException ex) {
                Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                */

    }
}
