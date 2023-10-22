/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer4;

import java.util.Random;

/**
 *
 * @author juanc
 */
public class Test {

      public static void main(String[] args) throws InterruptedException {

        //creo 5 impresoras
        Impresora[] imp = new Impresora[10];
        Cliente[] clientes = new Cliente[25];
        for (int i = 0; i < imp.length; i++) {
            imp[i] = new Impresora('G');

        }

        //creo una GestionImpresion
        GestionImpresion unaGestion = new GestionImpresion(imp);

        //creo los clientes, total 7
        for (int i = 0; i < clientes.length; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt((2000 - 500) + 1) + 500;
            clientes[i] = new Cliente(unaGestion, randomNumber);

        }
        for (int i = 0; i <  clientes.length; i++) {
            clientes[i].start();

        }

    }
}
