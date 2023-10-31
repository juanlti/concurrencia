/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer8;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Electrico extends Thread {


    private int tiempo;
    private Fabrica unaFabrica;

    public Electrico(Fabrica unaFabrica) {
        
 

        this.unaFabrica = unaFabrica;

    }

    public void run() {
        try {
            Random random = new Random();
            this.tiempo = random.nextInt(15) + 25;

            //System.out.println(this.getName() + " su tiempo " + this.tiempo);
            unaFabrica.llegaElectrico(this.tiempo,this);
            sleep(this.tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Electrico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
