/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import files.Regalo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import static main.main.nuevo;
import static main.main.username;
import pokemon.Pikachu;
import pokemon.Snorlax;

/**
 *
 * @author nelsoncarrillo
 */
public final class Principal1 extends javax.swing.JFrame {
    
    private int saldo;
    private int segundos;
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
                String rutaIcono = "/images/sighs.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Sigh");
                // Ejecutar evento para el rango de 0 a 2000
                // ...
            } else if (mascota.getAmistad() >= 2000 && mascota.getAmistad() < 4000) {
                // Ejecutar evento para el rango de 2000 a 4000
                // ...
                String rutaIcono = "/images/angrys.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Angry");
            } else if (mascota.getAmistad() >= 4000 && mascota.getAmistad() < 6000) {
                // Ejecutar evento para el rango de 4000 a 6000
                // ...
                String rutaIcono = "/images/snorlax.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Normal");
            } else if (mascota.getAmistad() >= 6000 && mascota.getAmistad() < 8000) {
                // Ejecutar evento para el rango de 6000 a 8000
                // ...
                String rutaIcono = "/images/happys.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Happy");
            } else if (mascota.getAmistad() >= 8000 && mascota.getAmistad() <= 10000) {
                // Ejecutar evento para el rango de 8000 a 10000
                // ...
                String rutaIcono = "/images/inspireds.png";
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
            String filePath = "test//data.txt";            
            // Validar si el nombre de usuario ya existe en el archivo de texto
            boolean usuarioExistente = false;
            List<String> lines = new ArrayList<>();
            try {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] datos = line.split(",");
                    String usernameExistente = datos[1].trim(); // Suponiendo que el nombre de usuario está en la segunda posición
                    if (usernameExistente.equals(username)) {
                        usuarioExistente = true;
                    } else {
                        lines.add(line);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            
            // Escribir en el archivo de texto
            try {
                FileWriter writer = new FileWriter(filePath);
                for (String line : lines) {
                    writer.write(line + "\n");
                }
                if (usuarioExistente) {
                    writer.write("," + username + "," +mascota.toString()+ "," + saldo + "," + segundos + "," + mascota.getAmistad() +mascota.listaToString()+ "\n");
                }else{
                    writer.write("," + username + "," +mascota.toString()+ "," + saldo + "," + segundos + "," + mascota.getAmistad() +mascota.listaToString()+ "\n");
                }
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
    private Snorlax mascota;
    
    
    
    /**
     * Creates new form Principal
     * @throws java.io.IOException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public Principal1() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota = new Snorlax();
        this.saldo=0;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        segundos=0;
        thread.start();
        
    }
    
    
    public Principal1(String user,int saldou,int time,int ami,String[] regalos) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota = new Snorlax(ami);
        this.saldo=saldou;
        segundos = time;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        segundos = time;
        username=user;
        thread.start();
        try{
            for(int i=0;i<regalos.length;i++){
                Regalo gift = new Regalo(Integer.parseInt(regalos[i]));
                mascota.addGiftHistory(gift);
            }
        }catch(Exception e){
            
        }
        
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
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        P = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pikachu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/snorlax.png"))); // NOI18N
        jPanel1.add(pikachu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, 100));

        jLabel1.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jLabel1.setText("Estado Snorlax:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        label.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label.setText("Tiempo Transcurrido:");
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label2.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label2.setText("Watts:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        estado.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        estado.setText("Normal");
        jPanel1.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jButton1.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jButton1.setText("Ir a Tienda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, -1));

        P.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        P.setText("Pokemon");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        jPanel1.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 130, -1));

        jButton3.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jButton3.setText("Jugar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, -1));

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

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        // TODO add your handling code here:
        saldo+=10;
        mascota.showPokemon(estado.getText());

    }//GEN-LAST:event_PActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saldo+=10;
        int aux = saldo;
        int finale = nuevo.tiendaSno(saldo,mascota);
        saldo=(saldo-aux)+finale; 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int aux = saldo;
        int finale = mascota.jugar(saldo);
        saldo=(saldo-aux)+finale;
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton P;
    private javax.swing.JLabel estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel pikachu2;
    // End of variables declaration//GEN-END:variables
}
