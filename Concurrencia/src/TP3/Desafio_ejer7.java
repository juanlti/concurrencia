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
public class Desafio_ejer7 {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    static class Letra implements Runnable {

        private MostrarCadena unaCadena;
        private char unaL;
        private int unaCantidad;
        private boolean datoEntradaVerificado;

        public Letra(char unaC, MostrarCadena unaCadena, int unaCantidad) {
            this.unaL = unaC;
            this.unaCadena = unaCadena;
            this.unaCantidad = unaCantidad;
        }

        @Override
        public void run() {
            int t = 0;
            while (t < 3) {

                Thread h = Thread.currentThread();
                datoEntradaVerificado = unaCadena.verificaEntrada(unaL);

                if (datoEntradaVerificado) {

                    System.out.println("valido: hilo-> " + h.getName() + " su letra " + this.unaL);
                    unaCadena.armarCadena(unaL);
                    System.out.println(unaCadena.toString());

                    try {
                        //metodos que llama  al recurso compartido
                        //verifoco si el orden
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        System.out.println(h.getName() + "Interrumpido.");

                    }
                } else {
                    t = t + 1;

                }

                // System.out.println("hilo actual " + this.unaL + " muestro " + this.unaCadena.toString());
            }
        }

    }

    static class MostrarCadena {

        private char unaLetra;

        private char obtenerLetra() {

            return this.unaLetra;
        }

//recurso compartido
        //ABBCCC
        //""
        char[] letras = {'A', 'B', 'C'};
        String cadena = "";
        int postLetra = 0;
        char ultimaLetraValida = 'A';

        public synchronized boolean verificaEntrada(char unaL) {
            boolean datoCorrecto = false;
            int pos = 0;

            System.out.println("llego el " + unaL);
            if (ultimaLetraValida == unaL) {
                System.out.println("datos ultima letra valida " + ultimaLetraValida + " y debe ser igual " + unaL + "   pos " + postLetra);
                System.out.println("posssss " + pos);
                datoCorrecto = true;
                System.out.println("valor de postLetraa " + postLetra);
                postLetra = postLetra + 1;
                System.out.println("valor de postLetraa actualizado " + postLetra);
                System.out.println("letra actual  " + ultimaLetraValida);
                ultimaLetraValida = letras[postLetra];
                System.out.println("letra siguiente " + ultimaLetraValida);

            } else {
                System.out.println("no coinciden");
                System.out.println("datos No validos ultima letra " + ultimaLetraValida + " y debe ser igual " + unaL + "   pos " + postLetra);

            }

            return datoCorrecto;

        }

        public synchronized void armarCadena(char unaLetraValida) {

            this.cadena = cadena + unaLetraValida;

        }

        public String toString() {

            return this.cadena.toString();
            //return this.cadena;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //1 recurso compartido, mostrar secuencia
        MostrarCadena unaCadena = new MostrarCadena();

        // 3 Objetos de tipo Letra
        Letra Rl1 = new Letra('A', unaCadena, 0);
        Letra Rl2 = new Letra('B', unaCadena, 0);
        Letra Rl3 = new Letra('C', unaCadena, 0);

        // creo 3 hilos con el objeto tipo letra
        Thread hl1 = new Thread(Rl1);
        Thread hl2 = new Thread(Rl2);
        Thread hl3 = new Thread(Rl3);
        
        hl1.start();
        hl2.start();
        hl3.start();
                
        
       

        hl1.join();
        hl2.join();
        hl3.join();

        System.out.println("termino");
        System.out.println(unaCadena.toString());
     
       

    }

}
