/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer8;

/**
 *
 * @author juanc
 */
public class Mecanico extends Thread {

    private int capacidad;
    private int tiempo;
    private Fabrica unaFabrica;

    public Mecanico(int unaCapacidad, int unTiempo, Fabrica unaFabrica) {
        this.capacidad = unaCapacidad;
        this.tiempo = unTiempo;
        this.unaFabrica = unaFabrica;

    }

    public void run() {
        
        

    }

}
