/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.Ejer8;

import java.util.Random;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) {

        //una fabrica
        Fabrica unaFabrica = new Fabrica(200, 250, 350);

        // una electrico
        Electrico[] unElectrico = new Electrico[30];

        for (int i = 0; i < unElectrico.length; i++) {

            unElectrico[i] = new Electrico(unaFabrica);

        }
        for (int i = 0; i < unElectrico.length; i++) {

            unElectrico[i].start();

        }

    }

}
