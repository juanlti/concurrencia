/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juanc
 */
public class Impresora {

    private int id;
    private char unTipo;

    public Impresora(char unT) {

        this.unTipo = unT;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void mostrar() {
        System.out.println("datos " + this.id + " tipo " + this.unTipo);
    }

}
