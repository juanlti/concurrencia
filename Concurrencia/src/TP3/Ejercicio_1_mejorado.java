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
public class Ejercicio_1_mejorado {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    public static void main(String[] args) throws InterruptedException {

        VerificarCuenta vc = new VerificarCuenta();
        // VC, la interfaz de VerificarCuenta, tiene una unica instancia de CuentaBanco
        // por lo tanto los Hilos que utilicen dicha intefaz, van a compartir la instancia de CuentaBanco  ?? 
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Manuel.start();
        Luis.start();

        Luis.join();
        Manuel.join();
        System.out.println("balance de cuenta compartida " + vc.cb.balance);

    }

    static class CuentaBanco {

        private int balance = 50;

        public CuentaBanco() {
        }

        public int getBalance() {
            return balance;

        }

        public synchronized boolean retiroBancario(int retiro) {
            boolean exitoso = false;

            try {

                Thread.sleep(1000);
                if (this.balance >= retiro) {
                    this.balance = balance - retiro;
                    exitoso = true;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio_1_mejorado.class.getName()).log(Level.SEVERE, null, ex);
            }
            return exitoso;

        }
    }

    static class VerificarCuenta implements Runnable {

        //esta Ok, 
        private CuentaBanco cb = new CuentaBanco();

        // Consultar, cuando creamos los hilos de Manuel y Luis, ambos reciben por parametro una solo objeto de tipo VerificarCuenta
        // pero, cada hilo tiene una instancia diferente de VerificarCuenta ??
        private void HacerRetiro(int cantidad) throws InterruptedException {

            if (cb.getBalance() >= cantidad) {
                System.out.println(Thread.currentThread().getName() + " verifiqua que la cuenta compartida, contiene la cantidad de dinero a retirar :" + cantidad);

                // ACA RETOMA EL H2 ,HASTA QUE SE LIBERE EL RECURSO COMPARTIDO ?
                boolean res = cb.retiroBancario(cantidad);
                if (res) {
                    //System.out.println(Thread.currentThread().getName() + " :Retiro realizado.");
                    System.out.println(Thread.currentThread().getName() + " : OK ");
                    System.out.println(Thread.currentThread().getName() + " :Los fondos son de: \" " + cb.getBalance());
                }

            } else {
                System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr " + Thread.currentThread().getName());
                System.out.println("Su saldo actual es de " + cb.getBalance());

            }

        }

        public void run() {
            for (int i = 0; i <= 3; i++) {
                try {

                    this.HacerRetiro(10);

                    if (cb.balance < 0) {
                        System.out.println("La cuenta está sobregirada.");
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(VerificarCuenta.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
