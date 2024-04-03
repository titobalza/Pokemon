package files;
import edd.Lista;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import pokemon.*;

/**
 *
 * @author nelsoncarrillo
 */
public class functions {
    
    public static Clip clip;
    public static Lista pokemones = new Lista();
    
    /**
     *
     * @param nombreUsuario
     * @return
     */
    public boolean validarUsuario(String nombreUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader("test/data.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(nombreUsuario)) {
                    return false; // El nombre de usuario ya existe en el archivo
                }
            }
        } catch (IOException e) {
        }
        
        return true; // El nombre de usuario es válido
    }
    
    public void reproducirAudio(String rutaArchivo) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File archivo = new File(rutaArchivo);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    
    public void detenerReproduccion() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    
    public Lista getPokemones(){
        return pokemones;
    }
    
    public void insertarPokemon(Pikachu pok){
        functions.pokemones.insertFinal(pok);
    }
    
    public void insertarPokemon(Snorlax pok){
        functions.pokemones.insertFinal(pok);
    }
    
    public int tienda(int saldo,Pikachu pika){
        String[] opciones = {
            "Baya Aranja 100 Watts +100 Relación",
            "Baya Caquic 200 Watts +250 Relación",
            "Poke ball 300 Watts +400 Relación",
            "Baya Zreza 400 Watts +550 Relación",
            "Baya Zanama 500 Watts +700 Relación",
            "Baya Ziuela 600 Watts +850 Relación",
            "Baya Zidra 700 Watts +1000 Relación",
            "Baya Enigma 800 Watts +1150 Relación",
            "Caramelo raro 900 Watts +1300 Relación"
        };
        int precioSeleccionado=0;
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú de Selección", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        // Realizar acciones basadas en la selección
        if (seleccion != null) {
            switch (seleccion) {
                case "Baya Aranja 100 Watts +100 Relación":
                    precioSeleccionado = 100;
                    break;
                case "Baya Caquic 200 Watts +250 Relación":
                    precioSeleccionado = 200;
                    break;
                case "Poke ball 300 Watts +400 Relación":
                    precioSeleccionado = 300;
                    break;
                case "Baya Zreza 400 Watts +550 Relación":
                    precioSeleccionado = 400;
                    break;
                case "Baya Zanama 500 Watts +700 Relación":
                    precioSeleccionado = 500;
                    break;
                case "Baya Ziuela 600 Watts +850 Relación":
                    precioSeleccionado = 600;
                    break;
                case "Baya Zidra 700 Watts +1000 Relación":
                    precioSeleccionado = 700;
                    break;
                case "Baya Enigma 800 Watts +1150 Relación":
                    precioSeleccionado = 800;
                    break;
                case "Caramelo raro 900 Watts +1300 Relación":
                    precioSeleccionado = 900;
                    break;
            }
            
            // Validar el saldo
            if (saldo >= precioSeleccionado) {
                // Restar el saldo
                saldo -= precioSeleccionado;
                Regalo gift = new Regalo(precioSeleccionado);
                pika.addGift(gift);
                JOptionPane.showMessageDialog(null, "Compra exitosa. Saldo restante: " + saldo + " Watts");
            } else {
                JOptionPane.showMessageDialog(null, "No tienes suficiente saldo para realizar la compra");
            }
        }
    return saldo;
    }
    
    public void adjuntarRegalo(int auxFinale,Pikachu pika){
        if(auxFinale>0){
            
        }
    }
    
}
