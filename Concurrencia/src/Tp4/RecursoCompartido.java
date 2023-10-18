/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan.barrera
 */
class RecursoCompartido {

    private Semaphore pc1;
    private Semaphore pc2;
    private Semaphore pc3;

    public RecursoCompartido() {
        this.pc1 = new Semaphore(1); // TP=1
        this.pc2 = new Semaphore(0);
        this.pc3 = new Semaphore(0);

    }

    public void Proceso1() {
        try {
            this.pc1.acquire(1);// TP=0
            Thread.sleep(500);
            System.out.println("Se desperto, pc1 le otorga permiso a pc3 ");
            this.pc3.release(1);//  PC3 TOTAL DE PERMISOS= 1

        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Proceso2() {
        try {
            this.pc2.acquire(1); // PC2 TOTAL DE PERMISOS= 0
            Thread.sleep(500);
            System.out.println("Se desperto, pc2 le otorga permiso a pc1 ");
            this.pc1.release(1);//  PC1 TOTAL DE PERMISOS= 1

        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void Proceso3() {
        for (int i = 0; i < 10; i++) {
            System.out.println("234234");
        }
        try {
            this.pc3.acquire(1); // PC3 TOTAL DE PERMISOS= 0
            Thread.sleep(500);
            System.out.println("Se desperto, pc3 le otorga permiso a pc2 ");
            this.pc2.release(1);//  PC2 TOTAL DE PERMISOS= 1
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
