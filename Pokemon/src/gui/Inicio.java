/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import files.functions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static main.main.username;

/**
 *
 * @author nelsoncarrillo
 */
public class Inicio extends javax.swing.JFrame {
    
    private Escoger escoger;
    private Principal principal;

    /**
     * Creates new form Inicio
     */
    public Inicio() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.reproducirAudio("test//center.wav");
        cj.setOpaque(false);
cj.setContentAreaFilled(false);
cj.setBorderPainted(false);
cj2.setOpaque(false);
cj2.setContentAreaFilled(false);
cj2.setBorderPainted(false);
c.setOpaque(false);
c.setContentAreaFilled(false);
c.setBorderPainted(false);
jn.setOpaque(false);
jn.setContentAreaFilled(false);
jn.setBorderPainted(false);
    }

    functions nuevo = new functions();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jn = new javax.swing.JButton();
        cj = new javax.swing.JButton();
        cj2 = new javax.swing.JButton();
        c = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jn.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jn.setForeground(new java.awt.Color(51, 0, 102));
        jn.setText("Juego Nuevo");
        jn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnActionPerformed(evt);
            }
        });
        jPanel1.add(jn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        cj.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        cj.setForeground(new java.awt.Color(51, 0, 102));
        cj.setText("Cargar Juego");
        cj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cjActionPerformed(evt);
            }
        });
        jPanel1.add(cj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, -1));

        cj2.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        cj2.setForeground(new java.awt.Color(51, 0, 102));
        cj2.setText("Cómo Jugar");
        cj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cj2ActionPerformed(evt);
            }
        });
        jPanel1.add(cj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, -1));

        c.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        c.setForeground(new java.awt.Color(51, 0, 102));
        c.setText("Créditos");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cute-yellow-mouse-playing-with-butterfly-background-free-vector.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnActionPerformed
        // TODO add your handling code here:
String name = JOptionPane.showInputDialog("Ingrese username:");
        
        if (name.matches(".*[,].*")) {
            JOptionPane.showMessageDialog(null, "El username no debe contener comas.");
        } else{
        if(nuevo.validarUsuario(name)){
            username=name;
            this.escoger = new Escoger();
            escoger.setVisible(true);
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe Cargar su Anterior juego o cree un nuevo usuario.");
        }}
    }//GEN-LAST:event_jnActionPerformed

    private void cjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cjActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog("Ingrese username:");
        if(nuevo.validarUsuario(name)){
            JOptionPane.showMessageDialog(null, "No tiene juegos guardados.\nCree uno nuevo.");
        }else{
            String lineaEncontrada="";
            try (BufferedReader br = new BufferedReader(new FileReader("test//data.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(","+name+",")) {
                    lineaEncontrada = linea;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] base = lineaEncontrada.split(",");
        String[] elementosAdicionales = new String[0];
        if (base.length > 6) {
            elementosAdicionales = new String[base.length - 6];
            for (int i = 6; i < base.length; i++) {
                elementosAdicionales[i - 6] = base[i];
            }
        }
        if(base[2].contains("Pikachu")){
            try {
                Principal menu = new Principal(base[1],Integer.parseInt(base[3]),Integer.parseInt(base[4]),Integer.parseInt(base[5]),elementosAdicionales);
                menu.setVisible(true);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }else if(base[2].contains("Snorlax")){
            try {
                Principal1 menu = new Principal1(base[1],Integer.parseInt(base[3]),Integer.parseInt(base[4]),Integer.parseInt(base[5]),elementosAdicionales);
                menu.setVisible(true);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //String user,int saldou,int time,int amiPika,int amiSno,String[] regalosPika,String[] regalosSno
            try {
                String[] regalos = base[6].split(";");
                String[] regalospika = regalos[0].split("u");
                String[] regalossno = regalos[1].split("u");
                Principal2 menu = new Principal2(base[1],Integer.parseInt(base[3]),Integer.parseInt(base[4]), Integer.parseInt(base[5].split(";")[0]),Integer.parseInt(base[5].split(";")[1]),regalospika,regalossno);
                menu.setVisible(true);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_cjActionPerformed

    private void cj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cj2ActionPerformed
        // TODO add your handling code here:
        String mensaje = "Bienvenido!\n\n";
        mensaje += "Instrucciones del juego (tras presionar botón juego nuevo):\n";
        mensaje += "- Primero, elige una modalidad de juego:\n";
        mensaje += "  - Jugar solo con Pikachu\n";
        mensaje += "  - Jugar solo con Snorlax\n";
        mensaje += "  - Jugar con ambos\n";
        mensaje += "- Una vez elegida la modalidad, el juego comenzará.\n";
        mensaje += "- Podrás ver el estado de tu Pokémon y jugar con él.\n";
        mensaje += "- También podrás ir a la tienda y comprarle regalos.\n";
        mensaje += "- En la sección 'Pokémon', podrás ver su relación numéricamente y la lista de los regalos.\n";
        mensaje += "- Después de cerrar y volver a abrir el programa, podrás ingresar tu mismo username y \nreanudar el progreso que tenías antes, intacto. \nNi la amistad, ni los regalos se pierden como en la vida debería ser.  :)\n";
        JOptionPane.showMessageDialog(null, mensaje, "Cómo jugar", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_cj2ActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Agregar los créditos
        panel.add(new JLabel("Créditos:"));
        panel.add(new JLabel("- Iconos: https://sprites.pmdcollab.org"));
        panel.add(new JLabel("- Sonidos: https://downloads.khinsider.com/game-soundtracks/album/pokemon-ruby-sapphire-music-super-complete"));
        panel.add(new JLabel("- Imagen de fondo: https://www.freepik.es/vectores/fondos-animado/6"));
        panel.add(new JLabel("- Fondo de Pikachu: https://www.vecteezy.com/vector-art/24851353-cute-yellow-mouse-playing-with-butterfly-background"));

        // Mostrar el JOptionPane personalizado
        JOptionPane.showMessageDialog(null, panel, "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton c;
    private javax.swing.JButton cj;
    private javax.swing.JButton cj2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jn;
    // End of variables declaration//GEN-END:variables
}
