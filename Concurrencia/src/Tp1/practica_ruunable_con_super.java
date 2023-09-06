/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1;

/**
 *
 * @author juanc
 */
public class practica_ruunable_con_super {
    
    class MiSuperClase {
    private int numero;

    public MiSuperClase(int numero) {
        this.numero = numero;
    }

    public void metodoSuper() {
        System.out.println("Número en superclase: " + numero);
    }
}

static class  MiClase extends MiSuperClase implements Runnable {
    public MiClase(int numero) {
        super(numero); // Llamada al constructor de la superclase
    }

    @Override
    public void run() {
        metodoSuper(); // Llamada al método de la superclase
        System.out.println("Hilo ejecutando.");
    }
}


    public static void main(String[] args) {
        MiClase miObjeto = new MiClase(42);
        Thread miHilo = new Thread(miObjeto);
        miHilo.start();
    }


}
