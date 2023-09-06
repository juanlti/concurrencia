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
public class sincronizacion_con_runnable {

    public static void main(String[] args) throws InterruptedException {

        final Dato1 unContador = new Dato1();

        RunnableCdor unRunCdor = new RunnableCdor(unContador);

        Thread h1 = new Thread(unRunCdor);
        Thread h2 = new Thread(unRunCdor);

        h1.start();
        h2.start();
        h1.join();
        h2.join();
        System.out.println("en main-" + unContador.obtenerValor());

    }

}

class Dato1 {

    private int valor;

    void contar() {
        valor = ++valor;
    }

    int obtenerValor() {
        return valor;
    }

}

class RunnableCdor implements Runnable {

    private Dato1 unContador;

    public RunnableCdor(Dato1 elCdor) {

        unContador = elCdor;

    }

    public void run() {

        unContador.obtenerValor();

        for (int x = 0; x < 10000; ++x) {
            unContador.contar();

        }

    }

}
