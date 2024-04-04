package pokemon;

import edd.Nodo;
import files.Regalo;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
    
    public Snorlax(){
    }
    
    public Snorlax( int am){
        this.amistad=am;
    }
    
    public void addGiftHistory(Regalo gift){
        this.regalos.insertar(gift);
        this.regalos2.insertFinal(gift);
    }
    
    public String listaToString(){
        Nodo aux = this.regalos2.getHead();
        String respuesta =",";
        while(aux!=null){
            Regalo gift = (Regalo)aux.getElement();
            respuesta += Integer.toString(gift.getCosto());
            respuesta+=",";
            aux=aux.getNext();
        }
        return respuesta;
    }
    
    public String listaToStringB(){
        Nodo aux = this.regalos2.getHead();
        String respuesta ="u";
        while(aux!=null){
            Regalo gift = (Regalo)aux.getElement();
            respuesta += Integer.toString(gift.getCosto());
            respuesta+="u";
            aux=aux.getNext();
        }
        return respuesta;
    }
    
    @Override
    public int jugar(int saldo) {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
String[] regalos = {"Baya Aranja", "Baya Caquic", "Poke ball", "Baya Zreza", "Baya Zanama", "Baya Ziuela", "Baya Zidra", "Baya Enigma", "Caramelo raro"};
        // Mostrar lista de regalos al usuario
        String regaloElegido = (String) JOptionPane.showInputDialog(null, 
                "Adivina el regalo en el que pienso:", "Regalos Disponibles",
                JOptionPane.QUESTION_MESSAGE, null, regalos, regalos[0]);

        // Generar un número aleatorio entre 0 y la cantidad de regalos totales
        Random random = new Random();
        int numeroAdivinar = random.nextInt(regalos.length);

        // Mostrar un cuadro de diálogo para que el usuario ingrese su apuesta
            JOptionPane.showMessageDialog(null, spinner, "Ajuste su apuesta", JOptionPane.PLAIN_MESSAGE);

            // Obtener el valor seleccionado por el usuario
            int apuesta = (int) spinner.getValue();
            while(apuesta>saldo){
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente.");
                 spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
             spinner = new JSpinner(spinnerModel);
        
            // Mostrar un cuadro de diálogo para que el usuario ingrese su apuesta
            JOptionPane.showMessageDialog(null, spinner, "Ajuste su apuesta", JOptionPane.PLAIN_MESSAGE);

            // Obtener el valor seleccionado por el usuario
             apuesta = (int) spinner.getValue();
            }

        // Verificar si la apuesta es correcta
        if (numeroAdivinar == regalos.length) {
                        JOptionPane.showMessageDialog(null, "¡Adivinaste! Ganaste " + apuesta + ". Nuevo saldo: " + saldo);

            return saldo += apuesta;
        } else {
                        JOptionPane.showMessageDialog(null, "Lo siento, el regalo era: " + regalos[numeroAdivinar] + ". Perdiste " + apuesta + ". Nuevo saldo: " + saldo);

            return saldo -= apuesta;
        }
    }
    
    
    public void showPokemon(String estado){
        String finali = "";
        finali = this.regalos.recorridoInorden();
        if (!finali.equals("")){
            JOptionPane.showMessageDialog(null, "Amistad: "+this.amistad+"\n"+"Estado Emocional: "+estado+"\n"+"Ha recibido: "+"\n"+finali);
        }else{
            JOptionPane.showMessageDialog(null, "Amistad: "+this.amistad+"\n"+"Estado Emocional: "+estado+"\n"+"No ha recibido regalos.");
        }
    }
    
    public int getAmistad(){
        return this.amistad;
    }
    
    public void addGift(Regalo gift){
        this.regalos.insertar(gift);
        this.regalos2.insertFinal(gift);
        this.amistad+=gift.getAmistad();
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
