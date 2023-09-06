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
public class Metodo_comparativo_Thread_Runnable {

    static class Proceso1 extends Thread {

        private int cant = 0;

        @Override

        public void run() {
            for (int i = 0; i <= 10; i++) {

                System.out.println("Proceso 1 " + getName());
            }

        }

    }

    static class Proceso2 implements Runnable {

        public void run() {
            for (int i = 0; i <= 5; i++) {

                System.out.println("Proceso 2");
            }
        }

    }

    public static void main(String[] args) {
        //Creamos todos los objetos a utilizar
        //creo el objecto h1 de tipo Proceso1 y que hereda de la clase Thread.
        Proceso1 h1 = new Proceso1();
        // creo el objecto h2 de tipo Thread  y que implementa la interfaz de la subClase Runnable
        Thread h2 = new Thread(new Proceso2());

        Proceso1 h3 = new Proceso1();

        //
        //inicia proceso1
        h1.start();
        //inicia proceso2
        h2.start();
        h3.start();

    }

}
