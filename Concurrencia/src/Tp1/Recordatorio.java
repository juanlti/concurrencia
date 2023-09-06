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
public class Recordatorio {
    

    // Variable estática
    public static int contador = 0;

    // Método estático
    public static void aumentarContador() {
        contador++;
    }

    // Método no estático
    public void imprimirContador() {
        System.out.println("Contador: " + contador);
    }

    public static void main(String[] args) {
        // Puedes acceder a la variable y al método estático sin crear una instancia de la clase
        Recordatorio.aumentarContador();
        System.out.println("Valor del contador: " + Recordatorio.contador);

        // Si intentas acceder al método no estático, necesitas crear una instancia de la clase
        Recordatorio instancia = new Recordatorio();
        instancia.imprimirContador();
    }


    
}
