package files;
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

/**
 *
 * @author nelsoncarrillo
 */
public class functions {
    
    public static Clip clip;
    
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
    
}
