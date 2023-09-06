/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1;

/**
 *
 * @author juanc
 */
public class Ejercicio_5 {

    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Observacion: EL constructor de clase Thread, no utiliza paramatros, por esa razon,
        // se define un constructor con parametros en la instancia Runnable, que  ese objeto reemplazara
        //al constructor de Thread.

//Primero, construye un objeto unHilo.
        unHilo mh = new unHilo("#1");

//Luego, construye un hilo de ese objeto.
        Thread nuevoHilo = new Thread(mh);
//Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            System.out.println("Hilo principal antes de dormir. "+ Thread.currentThread().getName().toString());
              
            Thread.sleep(100);
            System.out.println("Hilo principal despues de dormir."+Thread.currentThread().getName().toString());
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
};

class unHilo implements Runnable {

    String nombreHilo;

//Punto de entrada del hilo
//Los hilos comienzan a ejecutarse aquí
    unHilo(String nombre) {
        nombreHilo = nombre;
    }

    public void run() {
        System.out.println("Comenzando " + nombreHilo);
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + nombreHilo + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando " + nombreHilo);
    }
}
