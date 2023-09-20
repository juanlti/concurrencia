/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Ejercicio_2 {

    public static void main(String[] args) throws InterruptedException {

        Energia unaEnergia = new Energia(10);
        PoderesMagicos h1 = new PoderesMagicos("Criatura", unaEnergia);// Thread = 0

        PoderesMagicos h2 = new PoderesMagicos("Sanador", unaEnergia); //  Thread = 1
        h1.start();
        h2.start();

        h1.join();
        h2.join();
        System.out.println("VALORES DE ENERGIA " + unaEnergia.getUnidades());

    }

    static class Energia {

        private int unidades;

        public Energia(int unidades) {
            this.unidades = unidades;

        }

        public synchronized int getUnidades() {
            return this.unidades;
        }

        public synchronized void operacion(String unHilo) {

            if ("Sanador".equals(unHilo)) {

                //this.revitaliza();
                this.unidades = this.unidades + 3;
                System.out.println("soy el sanador  ?  " + unHilo + " con nuevo valor " + getUnidades());
                //Thread.sleep(500);

            } else {
                this.unidades = this.unidades - 3;
                System.out.println("soy la criatura   ?  " + unHilo + " con nuevo valor " + getUnidades());
                    // Thread.sleep(500);

                // this.drena();
            }

        }

    }

    static class PoderesMagicos extends Thread {

        private String name;
        private Energia unaEnergia;

        //constructor
        PoderesMagicos(String unNombre, Energia unaEnergia) {
            this.unaEnergia = unaEnergia;
            this.name = unNombre;
        }

        //run
        public void run() {
            int i = 0;
            while (i < 3) {
                Thread hilo = Thread.currentThread();

                //obtengo lo ultimo (sin interrupciones), pq esta synchronized
                System.out.println("Tu nivel de vida es " + this.unaEnergia.getUnidades());
                try {

                    if (this.name == "Sanador") {
                        unaEnergia.operacion("Sanador");
                       // System.out.println("Sanador, curado  +3 " + this.unaEnergia.getUnidades());
                    } else {
                        unaEnergia.operacion("Criatura");
                       // System.out.println("Criatura, lastimado -3  " + this.unaEnergia.getUnidades());

                    }

                    // System.out.println("Mago " + this.name + " == " + hilo.getName() + "  => " + unaEnergia.unidades);
                    Thread.sleep(500);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio_2.class.getName()).log(Level.SEVERE, null, ex);
                }

                i = i + 1;
            }

        }

    }

}
