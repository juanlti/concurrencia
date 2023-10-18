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
public class Main {

    public static void main(String[] args) {

        //recurso compartido
        RecursoCompartido rc = new RecursoCompartido();
        ClaseProceso1 cp1 = new ClaseProceso1(rc);
        ClaseProceso2 cp2 = new ClaseProceso2(rc);
        ClaseProceso3 cp3 = new ClaseProceso3(rc);

        cp1.start();
        cp2.start();
        cp3.start();

    }

}
