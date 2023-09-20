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
public class Ejercicio_3 {

    public static void main(String[] args) throws InterruptedException {
        Tienda unaTienda = new Tienda();
        //1 hilo por 1 hamster , total 3 hilos
        Hamsters h1 = new Hamsters("1", unaTienda);
        Hamsters h2 = new Hamsters("2", unaTienda);
        Hamsters h3 = new Hamsters("3", unaTienda);

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

    }

    static class Tienda {

        private boolean hamacaDisponible = true;
        private boolean ruedaDisponible = true;
        private boolean comidaDisponible = true;

        /*
         public synchronized String ObtenerActividadDisponible() {
         
         System.out.println("valor de comer " + this.comidaDisponible);
         System.out.println("valor de ruedaDisponible " + this.ruedaDisponible);
         System.out.println("valor de hamacaDisponible " + this.hamacaDisponible);

         if (this.comidaDisponible) {

         return disponible = "comer";

         } else {
         if (this.ruedaDisponible) {
         return disponible = "ejercicio";

         } else {
         if (this.hamacaDisponible) {
         return disponible = "dormir";

         }

         }

         }

         return "No hay disponibilidad";

         }
         */
        public void realizarActividad(Thread hamster, String nombre) {
            // System.out.println("ESTADO DEL HILO " + hamster.getState() + " nombre del hilo  " + hamster.getName() + " nombre del hamster " + nombre);

            if (comidaDisponible) {
                synchronized (hamster) {

                    comidaDisponible = false;

                    try {
                        System.out.println("El hamster " + hamster.getName() + " está comiendo, disponibilidad para otros" + this.comidaDisponible);

                        hamster.sleep(1000);
                        comidaDisponible = true;
                        // hamster.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("Hilo muerto");
                        Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("El hamster " + hamster.getName() + " termino  de comer , disponibilidad para otros" + this.comidaDisponible);

                }
            } else if (ruedaDisponible) {
                synchronized (hamster) {
                    ruedaDisponible = false;

                    try {
                        System.out.println("El hamster " + hamster.getName() + " está ejercitando, disponibilidad para otros " + this.ruedaDisponible);

                        hamster.sleep(1000);
                        //System.out.println("El hamster " + hamster.getName() + " está en la rueda.");
                        ruedaDisponible = true;
                        //hamster.sleep(1000);
                        System.out.println("El hamster " + hamster.getName() + " termino de ejercitarse, disponibilidad para otros" + this.ruedaDisponible);

                    } catch (InterruptedException ex) {
                        System.out.println("Hilo muerto");

                        Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else if (hamacaDisponible) {

                synchronized (hamster) {
                    hamacaDisponible = false;
                    try {
                        System.out.println("El hamster " + hamster.getName() + " está durmiendo,  disponibilidad para otros " + this.hamacaDisponible);

                        hamster.sleep(1000);

                        //System.out.println("El hamster " + hamster.getName() + " está en la hamaca.");
                        hamacaDisponible = true;
                        System.out.println("El hamster" + hamster.getName() + " se desperto (termino de dorminar) , disponibilidad para otros" + this.hamacaDisponible);

                        //hamster.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else {
                System.out.println("No hay actividades disponibles para el hamster " + hamster.getName());
            }

        }

    }
    

    static class Hamsters extends Thread {

        private String nombre;
        private Tienda unaTienda;
        private String nombreActividad;

        //constructor con nombre
        public Hamsters(String nombre, Tienda unaTienda) {
            this.nombre = nombre;
            this.unaTienda = unaTienda;
            this.nombreActividad = " ";

        }

//PREGUNTA POR RESPONSANBILIDAD DE CONTROL DE LOS HILOS
        // EJEMPLO, RECURSO COMPARTIDO TIENE UNA FUNCION QUE RECIBA UN HILO, Y DETERMINE QUE FUNCION UTILIZAR O EL HILO DECIDA LA FUNCION DEL RECURSO ?
        //run
        public void run() {
            //hilo actual
            int i = 0;
            while (i < 2) {

                    //String estado = this.unaTienda.getEstado();
                // comer  ejercicio   dormir
                    /*
                  
                    
                 */
                //this.sleep(300);
                //unaTienda.realizarActividad(this);
                try {
                    while(true){
                        
                        
                        
                        
               

                        // unaTienda.ObtenerActividadDisponible();
                        Thread hilo = Thread.currentThread();
                        hilo.sleep(200);
                        //System.out.println("ESTADO DEL HILO "+hilo.getState() + " nombre del hilo  "+hilo.getName() +" nombre del hamster "+ this.nombre);
                        unaTienda.realizarActividad(hilo, this.nombre);
                        hilo.sleep(500);

                         }
                    /*
       
                    
                     if ("Comida".equals(this.unaTienda.getEstado())) {
                     this.unaTienda.estaComiendo(hilo);
                     //hilo.sleep(100);
                     }
                     if ("Rueda".equals(this.unaTienda.getEstado())) {
                     this.unaTienda.estaEjercitando(hilo);
                     //hilo.sleep(100);
                     }
                     if ("Hamaca".equals(this.unaTienda.getEstado())) {
                     this.unaTienda.estaDurmiendo(hilo);
                     //hilo.sleep(100);
                    
                     }
                     */

                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                }

                //hilo.sleep(100);
                i++;

            }
        }

    }

}
