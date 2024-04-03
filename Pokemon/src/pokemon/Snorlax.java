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
    
    /**
    * Disminuye en 1 unidad la amistad del pikachu.
    * Es creado para la funcionalidad de que se pierde 1 de amistad por cada 
    * segundo que pase.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    */
    public void restaram(){
        this.amistad-=1;
    }

    @Override
    int jugar(int saldo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void verAmistad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void darAmistad(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
}
