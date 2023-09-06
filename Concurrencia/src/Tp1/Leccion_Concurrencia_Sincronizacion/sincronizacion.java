/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1.Leccion_Concurrencia_Sincronizacion;

/**
 *
 * @author juanc
 */
public class sincronizacion {

    public static void main(String[] args) throws InterruptedException {

        Dato cuenta = new Dato();
       // PingPong t1 = new PingPong("PING", (int) (Math.random() * 2300), cuenta);
        PingPong t1 = new PingPong("PING", (int)1000000000, cuenta);
        PingPong t2 = new PingPong("PONG", (int) (Math.random() * 2000), cuenta);

        t1.start();
        t2.start();

        Thread.sleep((long) Math.random() * 2000);

        System.out.println(Thread.currentThread() + " chau-chau.adios");
        System.out.println(" dato total de los hilos " + cuenta.obtenerValor());

    }

}

class Dato {

    private int valor;

    void contar() {
        valor = ++valor;
    }

    int obtenerValor() {
        return valor;
    }

}

//... y  el código de la clase PingPong  debe quedar ...  
class PingPong extends Thread {

    private int delay;            //info de las iteraciones
    private Dato miDato;          // para mantener el total
    private int miCta = 0;    // para contar mis iteraciones

// constructor 1, que refina al constructor heredado de Thread
    public PingPong(String cartel, int cantMs) {
        super(cartel);
        this.delay = cantMs;
    }

// constructor 2, que utiliza al constructor 1
    public PingPong(String cartel, int cantMs, Dato ddato) {
        this(cartel, cantMs);
        this.miDato = ddato;
    }

    public void run() {
         System.out.println("Tiempo: "+delay +" del hilo "+ this.getName());
                ///System.out.println("Tiempo: "+delay +" del hilo "+ this.getName());
        for (int i = 1; i < delay * 2; i++) {
              //System.out.println("Tiempo: "+delay +" del hilo "+ this.getName());
// System.out.print(this.getName() + " ");
            miCta++;
            this.miDato.contar();

        } // del for
        System.out.println(miCta + " veces " + this.getName());

    } // del run
}// fin de PingPong

