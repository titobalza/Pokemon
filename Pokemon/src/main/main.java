/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import files.functions;
import gui.Inicio;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
*                    Extra Credits.
*                  Universidad Metropolitana
*                     Estructura de Datos
*                  Prof. Fernando Torre secc. 3
*                Hecho por: Nelson Carrillo
*                           Tito Balza
* 
* @author nelsoncarrillo & tito_
*/
public class main {
    
    public static functions nuevo;
    public static String username ="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // TODO code application logic here
        
        nuevo = new functions();
        Inicio menu = new Inicio();
        menu.setVisible(true);
        
    } 
    
    
    
}
