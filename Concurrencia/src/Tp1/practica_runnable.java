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
public class practica_runnable {
    
    
    public static class Persona {
    private String nombre;
    private int edad;

    public  Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    // Getters y setters (omitiendo para simplificar el ejemplo)
}

public static class TareaPersona implements Runnable {
    private Persona persona;

    public TareaPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void run() {
        // Realizamos alguna operación relacionada con la persona
        persona.saludar();
    }
}


    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);
        TareaPersona tarea = new TareaPersona(persona);

        Thread hilo = new Thread(tarea);
        hilo.start();
        
        // Realizar otras operaciones en el hilo principal
    }


    
}
