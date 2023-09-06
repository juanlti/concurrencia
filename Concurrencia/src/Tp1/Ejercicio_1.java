package Tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanc
 */
public class Ejercicio_1 {

    public static void main(String[] args){
        // TODO code application logic here

  
        Cliente juan = new Cliente();
        juan.setName("h1");
        Cliente ines = new Cliente();
        ines.setName("h2");
        juan.start();
       ines.start();
       

       
       Recurso.uso();

    }

    public static class Recurso {

        public static void uso() {
            Thread t = Thread.currentThread();
            System.out.println("en Recurso: Soy " + t.getName());
        }

    }

    public static class Cliente extends Thread {

        @Override
        public void run() {
            System.out.println("soy " + Thread.currentThread().getName());
            //todo metodo debe ser instanciado ?
            Recurso.uso();
         
           try {
               Thread.sleep(2000);
            } catch (InterruptedException e) {
            };
                      
                    
        }
              

    }
}
