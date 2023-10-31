/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer8;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Fabrica {

    Semaphore semE, semM, semC, semR;
    private int cantMecanico;
    private int cantElectrico;
    private int cantControl;
    private int cantReiniciosElec, cantReiniciosMec;

    public Fabrica(int cantElectrico, int cantMecanico, int cantControl) {
        this.cantElectrico = cantElectrico;
        this.cantMecanico = cantMecanico;
        this.cantControl = cantControl;

        this.semC = new Semaphore(-2);
        this.semE = new Semaphore(1);
        this.semM = new Semaphore(1);
        this.semR = new Semaphore(0);
        this.cantReiniciosElec = 0;
        this.cantReiniciosMec = 0;

    }

    public boolean cambiaLineas(int cantElec, int cantMec) {

        boolean seguir = true;
        if(cantElec+1==0){
        
        
        }
        try {

            this.semC.acquire(-2);// -2

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seguir;
    }

    public void llegaElectrico(int unaCantidad, Thread unElec) {
        System.out.println("VALOR DE THREAD " + unElec.getId());
        try {
            this.semE.acquire(); // 0
            
            System.out.println("QUE INGESO " + unElec.getId() + " UNA CANT " + unaCantidad);
            if (cantElectrico < 0) {

                try {
                    System.out.println("QUE INGESO " + unElec.getId() + " UNA CANT " + unaCantidad + " valor " + cantElectrico);

                    //reinicio de ensamblaje
                    System.out.println("Comienzo de reinicio");
                    //valor original
                    this.cantElectrico = 200;
                    sleep(1000);
                    System.out.println("Fin  de reinicio");
                    System.out.println("QUE INGESO " + unElec + " UNA CANT " + unaCantidad + " ACTUALIZADO " + cantElectrico);
                    this.cantReiniciosElec = this.cantReiniciosElec + 1;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.cantElectrico = this.cantElectrico - unaCantidad;
            System.out.println("QUE SALIO " + unElec.getId() + " UNA CANT " + unaCantidad);

            this.semE.release();// +1

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reinicio() {
    }

    public void llegaMecanico() {
    }

    public void sale() {
    }

    public void cambiaLineas() {

    }

}
