/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static main.main.nuevo;
import static main.main.username;
import pokemon.Pikachu;

/**
 *
 * @author nelsoncarrillo
 */
public final class Principal extends javax.swing.JFrame {
    
    private int saldo;
    private int segundos =0;
    /**
     *
     */
    public void mostrarTiempoTranscurrido() {
        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                label.setText("Tiempo Transcurrido: "+String.valueOf(segundos)+" s");
                if(mascota.getAmistad()>0)
                    mascota.restaram();
                saldo++;
                label2.setText("Watts: "+String.valueOf(saldo));
            }
        });

        timer.start();
    }
    
    Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while (true) {
            if (mascota.getAmistad() >= 0 && mascota.getAmistad() < 2000) {
                String rutaIcono = "/images/sighp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Sigh");
                // Ejecutar evento para el rango de 0 a 2000
                // ...
            } else if (mascota.getAmistad() >= 2000 && mascota.getAmistad() < 4000) {
                // Ejecutar evento para el rango de 2000 a 4000
                // ...
                String rutaIcono = "/images/angryp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Angry");
            } else if (mascota.getAmistad() >= 4000 && mascota.getAmistad() < 6000) {
                // Ejecutar evento para el rango de 4000 a 6000
                // ...
                String rutaIcono = "/images/normalp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Normal");
            } else if (mascota.getAmistad() >= 6000 && mascota.getAmistad() < 8000) {
                // Ejecutar evento para el rango de 6000 a 8000
                // ...
                String rutaIcono = "/images/happyp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Happy");
            } else if (mascota.getAmistad() >= 8000 && mascota.getAmistad() <= 10000) {
                // Ejecutar evento para el rango de 8000 a 10000
                // ...
                String rutaIcono = "/images/inspiredp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Inspired");
            }

            try {
                Thread.sleep(1000); // Pausar durante 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    });
    
    
    
    public void mainFrame() {
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // Escribir en un archivo de texto
            try {
                FileWriter writer = new FileWriter("test//data.txt", true); // Abre el archivo en modo de apendizaje
                writer.write(","+username + "," + mascota.toString() + "," + saldo + "," + segundos +","+mascota.getAmistad()+ "\n"); // Agrega un salto de línea al final de cada registro
                writer.close();
                thread.interrupt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
}

    private Inicio inicio;
    private Escoger escoger;
    private Pikachu mascota;
    
    
    
    /**
     * Creates new form Principal
     * @throws java.io.IOException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public Principal() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota = new Pikachu();
        this.saldo=0;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        thread.start();
        
    }
    
    public Principal(int sald,int time, int ami) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota = new Pikachu(ami);
        this.saldo=sald;
        segundos = time;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        thread.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pikachu2 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Pokemon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pikachu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/normalp.png"))); // NOI18N
        jPanel1.add(pikachu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, 100));

        estado.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        estado.setText("Sigh");
        jPanel1.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        label.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label.setText("Tiempo Transcurrido:");
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label2.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label2.setText("Watts:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jButton1.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jButton1.setText("Ir a Tienda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, -1));

        Pokemon.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        Pokemon.setText("Pokemon");
        Pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PokemonActionPerformed(evt);
            }
        });
        jPanel1.add(Pokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, -1));

        jButton3.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jButton3.setText("Jugar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, -1));

        jLabel2.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jLabel2.setText("Estado Pikachu:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PokemonActionPerformed
        // TODO add your handling code here:
        mascota.showPokemon(estado.getText());
        
    }//GEN-LAST:event_PokemonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int aux = saldo;
        int finale = mascota.jugar(saldo);
        saldo=(saldo-aux)+finale;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int aux = saldo;
        int finale = nuevo.tienda(saldo,mascota);
        saldo=(saldo-aux)+finale;    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pokemon;
    private javax.swing.JLabel estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel pikachu2;
    // End of variables declaration//GEN-END:variables
}
