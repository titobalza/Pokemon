package pokemon;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Subclase de pokemon.
 * Pues pachirisu es un tipo de pokemon, y al modificar la opci&oacuten de 
 * elegir si usar a pachirisu o pikachu se cre&oacute esta herencia.
 * 
 * @author nelsoncarrillo
 * @version 1.0 17 enero 2024
 */
public class Snorlax extends Pokemon{
    
    int bayas=0; //este agrega atributo de bayas, no usa amistad
    Scanner myObje = new Scanner(System.in);//para los inputs por consola.
    
    
    /**
    * Imprime por pantalla el ascii art del pachirisu acorde a sus bayas.
    * Tipo de polimorfismo para el m&eacutetodo de la superclase pokemon, este
    * depende pues del nivel de bayas mientras que el de piakchu de la amistad.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    */
    public void verAmistad(){
        System.out.println("");
        System.out.println("BAYAS RECOLECTADAS:    "+this.bayas);
        if(10>= this.bayas & this.bayas >=7){
            System.out.println("");
            System.out.println(" ________");
            System.out.println(" | ^_^ |");
            System.out.println("  \\_^_/");
        } else if(7> this.bayas & this.bayas >=5){
                        System.out.println("");
            System.out.println(" ________");
            System.out.println(" | O_O |");
            System.out.println("  \\_^_/");
        }else if(5> this.bayas & this.bayas >=2){
                        System.out.println("");

            System.out.println(" ________");
            System.out.println(" | >_< |");
            System.out.println("  \\_^_/");
        }else if(2> this.bayas & this.bayas >=0){
                        System.out.println("");
            System.out.println(" ________");
            System.out.println(" | T_T |");
            System.out.println("  \\_^_/");
        }
        System.out.println("");
    }
    
    /**
    * Permite abrir el juego de las apuestas.
    * M&eacutetodo propuesto a polimorfismo tanto para pikachu como 
    * pachirisu, aunque para esta version ambos tienen lo mismo.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024
    * @param user instancia del usuario que apostar&aacute y gana o pierde watts.
    */
    @Override
    public void jugar(Usuario user){
        
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
    
        
    }
    
    /**
    * Se le da la amistad proveniente de un regalo.
    * La unica manera de obtener amistad es mediante un regalo, pero al ser pachirisu
    * solo acepta bayas y en vez de tratarse de amistad es en bayas. Pues 
    * surge el polimorfismo con respecto a la otra subclase de pokemon, el pikachu.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024.
    * @param n integer de la cantidad de bayas.
    */
    void darAmistad(int baya){
        this.bayas+=baya;
    }
}
