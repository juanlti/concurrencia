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
public class Ejercicio_3 {

    public static class ThreadEjemplo extends Thread {

        public ThreadEjemplo(String str) throws InterruptedException {
                  
            super(str);
            
                   Thread t = Thread.currentThread();
                   Thread.sleep(5000);
                 System.out.println("cual soy? "+t.getName());
      
        }


      
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + getName());


            }
            System.out.println("Termina thread " + getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadEjemplo("Maria Jose").start();
                Thread t = Thread.currentThread();
                 System.out.println("cual soy? "+t.getName());
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
        System.out.println("Termina thread ma2");
        System.out.println("Termina thread ma3");
                    //Thread t = Thread.currentThread();
        System.out.println("Termina thread ma4");
        System.out.println("Termina thread ma5");

            //System.out.println("cual soy? "+t.getName());
        // Orden de ejecucion
        // h(main), es el primer hilo en ejecutarse y tambien el primero en terminar, porque 
    }

}
