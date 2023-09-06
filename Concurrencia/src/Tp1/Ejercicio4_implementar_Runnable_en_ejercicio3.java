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
public class Ejercicio4_implementar_Runnable_en_ejercicio3 {

    public static void main(String[] args) {

    // 2 metodos para crear hilos con interfaz
        // metodo n1:
        //creo una instancia de Runnable y luego creo un hilo con dicho objeto.
        //por lo tanto, mi hilo, es una instancia de la interfaz runnable
    /*
         new Thread(new RunnableEjemplo("Maria Jose")).start();
         new Thread(new RunnableEjemplo(" Jose Maria")).start();
         */
        // metodo n2:
        // creo la instancia de runnable por separado
        RunnableEjemplo recursoComportadido = new RunnableEjemplo();
        Thread HMJ = new Thread(recursoComportadido);
        Thread HJM = new Thread(recursoComportadido);
        HMJ.setName("Maria Jose");
        HJM.setName("Jose Maria");

        HMJ.start();
        HJM.start();
        System.out.println("Fin");
        //¿Qué sucede? => El comportamiento  de los hilos es el mismo.
        //¿Es necesario el constructor? =>No, porque el objeto Runnable, va a utilizar el constructor de la clase Thread, 
        //cuando se cree  un objeto de hilo Thread, solo se reemplaza el run, y nada mas.

    }

}

class RunnableEjemplo implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            String nombreDelHiloActual = Thread.currentThread().getName();

            System.out.println("Termina thread " + nombreDelHiloActual);
        }
    }
};
