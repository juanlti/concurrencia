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
public class Ejercicio_1_modificado {

    public static void main(String[] args) throws InterruptedException {

        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Manuel.start();
        Luis.start();

        Luis.join();
        Manuel.join();
        System.out.println("balance " + vc.cb.balance);

    }

    static class CuentaBanco {

        private int balance = 50;

        public CuentaBanco() {
        }

        public int getBalance() {
            return balance;

        }

        public void retiroBancario(int retiro) {
            balance = balance - retiro;
        }
    }

    static class VerificarCuenta implements Runnable {

        //esta Ok, 
        private CuentaBanco cb = new CuentaBanco();

        // Consultar, cuando creamos los hilos de Manuel y Luis, ambos reciben por parametro una solo objeto de tipo VerificarCuenta
        // pero, cada hilo tiene una instancia diferente de VerificarCuenta ??
        private void HacerRetiro(int cantidad) throws InterruptedException {

            if (cb.getBalance() >= cantidad) {
                //System.out.println(Thread.currentThread().getName() + " está realizando un retiro de " + cantidad);
                Thread.sleep(1000);
                cb.retiroBancario(cantidad);
                //System.out.println(Thread.currentThread().getName() + " :Retiro realizado.");
                //  System.out.println(Thread.currentThread().getName() + " :Los fondos son de: \"" + cb.getBalance());
            } else {
                //System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr " + Thread.currentThread().getName());
                // System.out.println("Su saldo actual es de " + cb.getBalance());
                Thread.sleep(1000);

            }

        }

        public void run() {
            for (int i = 0; i <= 3; i++) {
                try {
                    if (Thread.currentThread().getName() == "Luis") {
                        Thread.sleep(1000);

                    } else {
                        this.HacerRetiro(10);

                        if (cb.balance < 0) {
                            System.out.println("La cuenta está sobregirada.");
                        }

                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(VerificarCuenta.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

                if (i == 3 && Thread.currentThread().getName() == "Luis") {
                    System.out.println("Ultimos datos de Luis == " + Thread.currentThread().getName() + ", debe ser igual a 50 " + this.cb.balance);

                }
                if (i == 3 && Thread.currentThread().getName() == "Manuel") {
                    System.out.println("Ultimos datos de Manuel == " + Thread.currentThread().getName() + ", debe ser igual a 10 " + Thread.currentThread().getName() + ", debe ser igual a 50 " + this.cb.balance);
                }
            }
        }

    }

}
