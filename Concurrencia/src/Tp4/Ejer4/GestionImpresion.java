/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.ejer4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class GestionImpresion {

    private Impresora[] todasLasImPresoras;
    private boolean[] impresorasDisponibles;
    private Semaphore impresoras;
    private int cantImpresorasDisponibles;
    private Semaphore mutex1, mutex2;

    public GestionImpresion(Impresora[] unaImpresa) {
        this.cantImpresorasDisponibles = unaImpresa.length;

        impresoras = new Semaphore(this.cantImpresorasDisponibles);

        todasLasImPresoras = new Impresora[this.cantImpresorasDisponibles];
        impresorasDisponibles = new boolean[this.cantImpresorasDisponibles];
        for (int i = 0; i < cantImpresorasDisponibles; i++) {

            //Inicializo el arreglo con las impresoras
            unaImpresa[i].setId(i);
            unaImpresa[i].mostrar();
            todasLasImPresoras[i] = unaImpresa[i];
            // Inicializo en true (disponible) a todas las impresoras
            impresorasDisponibles[i] = true;

        }

        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(1);

    }

    public void gestion(Thread unCliente, int unTiempo) {

        try {
            
            //Adquiero la solicitud (un documento),
            // si hay una impresora, imprimi documento
            // no hay disponibilidad, no imprimi documento y sale
            //  impresoras.acquire(this.cantImpresorasDisponibles);
            mutex1.acquire(); //MUTEX P 0
            
            
            
            //al menos una impresora esta disponible
            int idImpresoraSelecionada = -1;

            for (int i = 0; i < todasLasImPresoras.length; i++) {
                           //  mutex1.acquire(0);  //MUTEX P 1

                if (impresorasDisponibles[i]) {
                    //impresora disponible encontrada
                    idImpresoraSelecionada = i;
                    impresorasDisponibles[i] = false;
                    mutex1.release(); //MUTEX P 1
                    break; // salgo del bucle
                } 
                    
                

            }

            if (idImpresoraSelecionada != -1) {
              
                // realiza impresion
                imprimiendo(idImpresoraSelecionada, unCliente, unTiempo);
                //libero impresora
                //mutex.aq()
                mutex2.acquire(); //MUTEX2 P 0
                impresorasDisponibles[idImpresoraSelecionada] = true;
                //mutex.release()
                System.out.println("Libero impresora " + idImpresoraSelecionada);
                mutex2.release(); //MUTEX2 P 1
            }

        } catch (InterruptedException ex) {
            System.out.println("Cliente interrumpido " + ex);
        }

    }

    public void imprimiendo(int idImpresora, Thread unCliente, int unTiempo) {

        System.out.println("Cliente " + unCliente.getName() + " esta utilizando la impresora " + idImpresora + " tiempo calculado " + unTiempo);
        try {
            Thread.sleep(unTiempo); // Simulación de impresión
        } catch (InterruptedException ex) {
            Logger.getLogger(GestionImpresion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrar() {
        System.out.println("Impresoras administradas por Gestion");
        for (int i = 0; i < todasLasImPresoras.length; i++) {
            System.out.println("impresora id: " + todasLasImPresoras[i] + " tipo " + todasLasImPresoras[i]);
        }
    }

}
