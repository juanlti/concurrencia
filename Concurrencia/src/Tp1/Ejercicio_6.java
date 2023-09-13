/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Ejercicio_6 {

    public static class ThreadRunner extends Thread {

        private Corredor aRunner;
        private int limite = 100;
        private int cantPasos = 0;
        private int cantDistanciasPorPasos = 0;
        private long tiempoDeInicio;

        public ThreadRunner(Corredor pArunner) {
            this.aRunner = pArunner;

        }

        public void run() {
            tiempoDeInicio = System.currentTimeMillis();
            //operaciones por hilo
            //corredor actual
            Thread c = Thread.currentThread();

            while ((cantPasos < limite)) {
                int distanciaPorCorredor = (int) (Math.random() * 10 + 1);
                cantDistanciasPorPasos = cantDistanciasPorPasos + distanciaPorCorredor;
                cantPasos = cantPasos + 1;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    System.out.println(aRunner.nombre + "Interrumpido.");

                }

            }
            if (this.cantPasos == this.limite) {

                this.aRunner.distanciasRecorridaPorCorredor(cantDistanciasPorPasos, tiempoDeInicio);
                System.out.println("Carrra terminada por: " + this.aRunner.nombre + " cant pasos " + this.cantPasos + " y recorrio ===>" + this.cantDistanciasPorPasos);

            }

        }
    }

    public static class Corredor {

        private String[] nombres = {"Juan", "Fer", "Nico", "Pedro"};
        private int[] distancias = {550, 550, 550, 550};
        private int distancia;
        private int resultado = 0;
        private long tiempo;
        private String nombre;

        public Corredor(int posData) {

            this.distancia = distancias[posData];
            this.nombre = nombres[posData];

        }

        public void distanciasRecorridaPorCorredor(int unaDistancia, long tiempoDeFinalizacion) {
            this.tiempo = tiempoDeFinalizacion;
            this.resultado = unaDistancia;

        }

        public String toString() {
            return "Nombre: " + nombre + " distancia a recorrer: " + distancia;

        }

    }

    public static void main(String[] args) throws InterruptedException {

        //defino los objetos de tipo Corredor
        //total 4.
        //arreglo de corredores
        Corredor listaDeCorredores[] = new Corredor[4];

        Corredor C0 = new Corredor(0);
        Corredor C1 = new Corredor(1);
        Corredor C2 = new Corredor(2);
        Corredor C3 = new Corredor(3);

        listaDeCorredores[0] = C0;
        listaDeCorredores[1] = C1;
        listaDeCorredores[2] = C2;
        listaDeCorredores[3] = C3;
        ThreadRunner listaHilosCorredores[] = new ThreadRunner[4];
        for (int i = 0; i < listaDeCorredores.length; i++) {

            System.out.println("corredor: " + i + " datos: " + listaDeCorredores[i].toString());
            listaHilosCorredores[i] = new ThreadRunner(listaDeCorredores[i]);
        }
        listaHilosCorredores[0].start();
        listaHilosCorredores[1].start();
        listaHilosCorredores[2].start();
        listaHilosCorredores[3].start();

        for (ThreadRunner listaHilosCorredore : listaHilosCorredores) {

            listaHilosCorredore.join();
        }
        for (Corredor listaDeCorredore : listaDeCorredores) {
            System.out.println("Carrera Finalizada por " + listaDeCorredore.nombre + " distancia de " + listaDeCorredore.resultado + " en tiempos de nano time " + listaDeCorredore.tiempo);

        }

    }

}
