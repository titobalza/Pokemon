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
 * Pues pikachu es un tipo de pokemon, y al modificar la opci&oacuten de 
 * elegir si usar a pachirisu o pikachu se cre&oacute esta herencia.
 * 
 * @author nelsoncarrillo
 * @version 1.0 17 enero 2024
 */
public class Pikachu extends Pokemon{
    
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
    
    public Pikachu(){
        
    }
    
    public Pikachu(int a){
        this.amistad=a;
    }
    
    public int getAmistad(){
        return this.amistad;
    }
    
    public void addGift(Regalo gift){
        this.regalos.insertar(gift);
        this.regalos2.insertFinal(gift);
        this.amistad+=gift.getAmistad();
    }
    public void addGiftHistory(Regalo gift){
        this.regalos.insertar(gift);
        this.regalos2.insertFinal(gift);
    }

    @Override
    public int jugar(int saldo) {
            Random random = new Random();

            // Generar el número aleatorio de la carta escogida por el Pokémon
            int cartaPokemon = random.nextInt(13) + 1;
            String cartaPokemonTexto = obtenerTextoCarta(cartaPokemon);

            // Mostrar la carta escogida por el Pokémon al usuario
            JOptionPane.showMessageDialog(null, "El Pokémon ha escogido inicialmente la carta: " + cartaPokemonTexto);

            // Solicitar al usuario que elija si la siguiente carta será más alta o más baja
            int opcion = JOptionPane.showOptionDialog(null, "¿La siguiente carta será más alta o más baja?", "Juego de la carta más alta", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Más alta", "Más baja"}, null);
            
            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
        
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
            
            // Generar el número aleatorio de la siguiente carta
            int siguienteCarta = random.nextInt(13) + 1;
            String siguienteCartaTexto = obtenerTextoCarta(siguienteCarta);

            // Mostrar la siguiente carta al jugador
            JOptionPane.showMessageDialog(null, "La siguiente carta es: " + siguienteCartaTexto);

            // Comparar la carta del Pokémon con la siguiente carta y determinar el resultado
            String resultado = "";
            if ((opcion == 0 && siguienteCarta > cartaPokemon) || (opcion == 1 && siguienteCarta < cartaPokemon)) {
                resultado = "¡Has ganado!";
                // Mostrar el resultado al jugador
            JOptionPane.showMessageDialog(null, resultado);
                return saldo+apuesta;
            } else {
                resultado = "Lo siento, has perdido.";
                // Mostrar el resultado al jugador
            JOptionPane.showMessageDialog(null, resultado);
                return saldo-apuesta;
            }

            
        }

        private static String obtenerTextoCarta(int numeroCarta) {
            switch (numeroCarta) {
                case 1:
                    return "A";
                case 11:
                    return "J";
                case 12:
                    return "Q";
                case 13:
                    return "K";
                default:
                    return String.valueOf(numeroCarta);
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

    @Override
    void verAmistad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void darAmistad(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    }



    
    
    
    
    
    
    

    




