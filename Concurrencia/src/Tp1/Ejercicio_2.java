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
public class Ejercicio_2 {

   // a. ¿Cómo es el comportamiento de las diferentes ejecuciones?.
    // El comportamiento es ordenado, H(miHilo),arranca pero perdie la cepu, entonces se muestra 'En el main' H(main),
    //el H(main) perdie la cpu (bloqueado), entonces H(miHilo) vuelve a ejecutar y muestra el resultado y finaliza.
    //Por ultimo H(main) finalizada (sin mostrar nada)
    public static void main(String[] args) throws InterruptedException {
        Thread miHilo = new MiEjecucion();


        miHilo.start();
        //aca continua la ejecucion del Hilo main ?
        
              //Configuracion para cambiar el comportamiento
                  //Thread.sleep(5000);
        
        
        
                 System.out.println("En el main");
          
             
      

    }

    public static class MiEjecucion extends Thread {

        @Override
        public void run() {
            ir();// A

            
            //D
            //Configuracion para cambiar el comportamiento
            /*
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            };
                    */

        }

        public void ir() {
            //B
            hacerMas();
        }

        public void hacerMas() {
            //C
            System.out.println("En la pila");
        }
    }

}
