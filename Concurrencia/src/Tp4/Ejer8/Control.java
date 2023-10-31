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
public class Control extends Thread {

    private Fabrica unaFabrica;
    private int cantElectricos, cantMecanicos;

    public Control(Fabrica unaFabrica, int cantElectricos, int cantMecanicos) {
        this.cantElectricos = cantElectricos;
        this.cantMecanicos = cantMecanicos;
        this.unaFabrica = unaFabrica;

    }

    public void run() {

        boolean seguir = true;
        while (seguir) {

            seguir = cambiaLineas(cantElectricos, cantMecanicos);

        }

    }

}
