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
 *
 * @author nelsoncarrillo
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
        
        /**
        String[] palabras = {"pikachu", "charizard", "bulbasaur", "squirtle", "jigglypuff"};
        String palabraSeleccionada = palabras[(int) (Math.random() * palabras.length)];
        
        char[] palabraAdivinada = new char[palabraSeleccionada.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
        
        int intentosRestantes = 6;
        boolean juegoTerminado = false;
        
        JOptionPane.showMessageDialog(null, "¡Bienvenido al juego del ahorcado!");
        
        while (!juegoTerminado) {
            JOptionPane.showMessageDialog(null, "Palabra a adivinar: " + String.valueOf(palabraAdivinada));
            JOptionPane.showMessageDialog(null, "Intentos restantes: " + intentosRestantes);
            String letra = JOptionPane.showInputDialog("Ingresa una letra:");
            
            boolean letraAdivinada = false;
            
            for (int i = 0; i < palabraSeleccionada.length(); i++) {
                if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                    palabraAdivinada[i] = letra.charAt(0);
                    letraAdivinada = true;
                }
            }
            
            if (!letraAdivinada) {
                intentosRestantes--;
                JOptionPane.showMessageDialog(null, "La letra no está en la palabra. ¡Intento fallido!");
                if (intentosRestantes == 0) {
                    juegoTerminado = true;
                    JOptionPane.showMessageDialog(null, "¡Has perdido! La palabra correcta era: " + palabraSeleccionada);
                }
            }
            
            if (String.valueOf(palabraAdivinada).equals(palabraSeleccionada)) {
                juegoTerminado = true;
                JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado la palabra correctamente: " + palabraSeleccionada);
            }
        }
        
        JOptionPane.showMessageDialog(null, "Fin del juego. ¡Gracias por jugar!");
    **/
    } 
    
    
    
}
