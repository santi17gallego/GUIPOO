/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

/**
 *
 * @author santi
 */
public class Pruebas {
    public static void main (String[] args){
        String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        System.out.println(Arrays.toString(fontNames));
    }
}
