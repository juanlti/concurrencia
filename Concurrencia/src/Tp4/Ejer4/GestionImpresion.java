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
    private boolean[] ImpresoraEstaImprimiendo;
    private Semaphore impresoras;
    private int cantImpresorasDisponibles;
    private Semaphore mutex1, mutex2;
    private int CantCliente;

    public GestionImpresion(Impresora[] unaImpresa, int cantClientes) {
        this.cantImpresorasDisponibles = unaImpresa.length;

        impresoras = new Semaphore(this.cantImpresorasDisponibles);

        todasLasImPresoras = new Impresora[this.cantImpresorasDisponibles];
        ImpresoraEstaImprimiendo = new boolean[this.cantImpresorasDisponibles];

        this.CantCliente = cantClientes;
        for (int i = 0; i < cantImpresorasDisponibles; i++) {

            //Inicializo el arreglo con las impresoras
            unaImpresa[i].setId(i);
            unaImpresa[i].mostrar();
            todasLasImPresoras[i] = unaImpresa[i];
            // Inicializo en true (disponible) a todas las impresoras
            ImpresoraEstaImprimiendo[i] = true;

        }

        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(1);

    }

    public void gestion(Thread unCliente, int unTiempo) {

        try {
            System.out.println("id " + unCliente.getId());
            //Adquiero la solicitud (un documento),
            // si hay una impresora, imprimi documento
            // no hay disponibilidad, no imprimi documento y sale
            //  impresoras.acquire(this.cantImpresorasDisponibles);
            mutex1.acquire(); //MUTEX P 0

            //al menos una impresora esta disponible
            int idImpresoraSelecionada = -1;
            int i;
            i = 0;
            boolean puedeImprimir = true;
            
        

                //  mutex1.acquire(0);  //MUTEX P 1
                while (puedeImprimir) {
                  
                    if (ImpresoraEstaImprimiendo[i]) {
                        //impresora disponible encontrada
                        idImpresoraSelecionada = i;
                        ImpresoraEstaImprimiendo[i] = false;

                        mutex1.release(); //MUTEX P 1

                    } else {
                        if (i + 1 >= cantImpresorasDisponibles) {
                            i = 0;
                        } else {
                            i = i + 1;
                        }
                    }

                    if (idImpresoraSelecionada != -1) {

                        // realiza impresion
                        imprimiendo(idImpresoraSelecionada, unCliente, unTiempo);
                        //libero impresora
                        mutex2.acquire(); //MUTEX2 P 0
                        ImpresoraEstaImprimiendo[idImpresoraSelecionada] = true;

                        //mutex.release()
                        puedeImprimir = false;
                      
                        System.out.println("Libero impresora " + idImpresoraSelecionada);
                        this.CantCliente = this.CantCliente - 1;
                        mutex2.release(); //MUTEX2 P 1

                    }

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
