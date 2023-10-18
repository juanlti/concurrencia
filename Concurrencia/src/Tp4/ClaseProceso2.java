/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4;

/**
 *
 * @author juan.barrera
 */
public class ClaseProceso2 extends Thread {

    RecursoCompartido unR;

    public  ClaseProceso2(RecursoCompartido unR) {
        this.unR = unR;
    }

    public void run() {

        while (true) {
            this.unR.Proceso2(); // ejecuto sem1

        }

    }
}
