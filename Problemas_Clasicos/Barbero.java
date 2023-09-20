/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problemas_Clasicos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Barbero {

    public static void main(String[] args) {

        //objeto compartido
        Barberia unaB = new Barberia();

        //1 barbaro
        Barbaaro unBarbero = new Barbaaro(unaB);

        //varios clients
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(unaB);

        }

        //creo los hilos
        Thread HB = new Thread(unBarbero);
        HB.start();

        // creo los hilos de Cliente
        Thread[] HC = new Thread[5];
        for (int i = 0; i < HC.length; i++) {
            HC[i] = new Thread(clientes[i]);
            HC[i].start();

        }

    }

}

class Barberia {

    private Semaphore sillon;
    private Semaphore cliente;
    private Semaphore barbero;

    public Barberia() {
        this.sillon = new Semaphore(1);
        this.cliente = new Semaphore(0);
        this.barbero = new Semaphore(0);

    }

    public void nuevoCliente() {
        try {
            this.sillon.acquire(); //un Cliente, solicita el permiso del semaforo del sillon

            this.barbero.release();// Solicita al barbaro que active su recurso

            this.cliente.acquire(); // Espera que el barbero termine el corte, para liberar al cliente
            System.out.println("Me estoy cortando el pelo " + Thread.currentThread().getName());
            this.sillon.release(); //Cliente libera sillon

        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void realizarCorte() {

        try {
            this.barbero.acquire();
            //corta el pelo

            System.out.println("Barbero ocupado, cortando el pelo ");
            Thread.sleep(1000);
            this.cliente.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class Barbaaro implements Runnable {

    private Barberia unaBarberia;

    public Barbaaro(Barberia unaBarberia) {
        this.unaBarberia = unaBarberia;
    }

    @Override
    public void run() {

        while (true) {

            this.unaBarberia.realizarCorte();

        }

    }

}

class Cliente implements Runnable {

    private Barberia unaBarberia;

    public Cliente(Barberia unaBarberia) {
        this.unaBarberia = unaBarberia;
    }

    @Override
    public void run() {
        Random random = new Random();
        int randomNumber = random.nextInt((2000 - 500) + 1) + 500;
        while(true){
        try {
            Thread.sleep(randomNumber);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.unaBarberia.nuevoCliente();
        System.out.println(" saliendo: " + Thread.currentThread().getName());
        }
    }

}
