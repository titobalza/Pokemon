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
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static main.main.nuevo;
import static main.main.username;
import pokemon.Pikachu;
import pokemon.Snorlax;

/**
 *
 * @author nelsoncarrillo
 */
public class Principal2 extends javax.swing.JFrame {
    
    private int saldo;
    private int segundos;
    private Pikachu mascota;
    private Snorlax mascota1;
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
                if(mascota1.getAmistad()>0)
                    mascota1.restaram();
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
                pikachu3.setIcon(imagen);
                estado3.setText("Sigh");
                // Ejecutar evento para el rango de 0 a 2000
                // ...
            } else if (mascota.getAmistad() >= 2000 && mascota.getAmistad() < 4000) {
                // Ejecutar evento para el rango de 2000 a 4000
                // ...
                String rutaIcono = "/images/angryp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu3.setIcon(imagen);
                estado3.setText("Angry");
            } else if (mascota.getAmistad() >= 4000 && mascota.getAmistad() < 6000) {
                // Ejecutar evento para el rango de 4000 a 6000
                // ...
                String rutaIcono = "/images/normalp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu3.setIcon(imagen);
                estado3.setText("Normal");
            } else if (mascota.getAmistad() >= 6000 && mascota.getAmistad() < 8000) {
                // Ejecutar evento para el rango de 6000 a 8000
                // ...
                String rutaIcono = "/images/happyp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu3.setIcon(imagen);
                estado3.setText("Happy");
            } else if (mascota.getAmistad() >= 8000 && mascota.getAmistad() <= 10000) {
                // Ejecutar evento para el rango de 8000 a 10000
                // ...
                String rutaIcono = "/images/inspiredp.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu3.setIcon(imagen);
                estado3.setText("Inspired");
            }
            
            if (mascota1.getAmistad() >= 0 && mascota1.getAmistad() < 2000) {
                String rutaIcono = "/images/sighs.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Sigh");
                // Ejecutar evento para el rango de 0 a 2000
                // ...
            } else if (mascota1.getAmistad() >= 2000 && mascota1.getAmistad() < 4000) {
                // Ejecutar evento para el rango de 2000 a 4000
                // ...
                String rutaIcono = "/images/angrys.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Angry");
            } else if (mascota1.getAmistad() >= 4000 && mascota1.getAmistad() < 6000) {
                // Ejecutar evento para el rango de 4000 a 6000
                // ...
                String rutaIcono = "/images/snorlax.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Normal");
            } else if (mascota1.getAmistad() >= 6000 && mascota1.getAmistad() < 8000) {
                // Ejecutar evento para el rango de 6000 a 8000
                // ...
                String rutaIcono = "/images/happys.png";
                Icon imagen = new ImageIcon(getClass().getResource(rutaIcono));
                pikachu2.setIcon(imagen);
                estado.setText("Happy");
            } else if (mascota1.getAmistad() >= 8000 && mascota1.getAmistad() <= 10000) {
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
                    writer.write("," + username + ",Both," + saldo + "," + segundos + "," + mascota.getAmistad()+";"+mascota1.getAmistad() +","+mascota.listaToStringB()+ ";"+mascota1.listaToStringB()+"\n");
                }else{
                    writer.write("," + username + ",Both," + saldo + "," + segundos + "," + mascota.getAmistad()+";"+mascota1.getAmistad()+"," +mascota.listaToStringB()+";"+mascota1.listaToStringB()+ "\n");
                }
                writer.close();
                thread.interrupt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
}
    
    /**
     * Creates new form Principal
     * @throws java.io.IOException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public Principal2() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota1 = new Snorlax();
        this.mascota= new Pikachu();
        this.saldo=0;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        segundos=0;
        thread.start();
        
    }
    
    public Principal2(String user,int saldou,int time,int amiPika,int amiSno,String[] regalosPika,String[] regalosSno) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        nuevo.detenerReproduccion();
        nuevo.reproducirAudio("test//center3.wav");
        this.mascota1 = new Snorlax(amiSno);
        this.mascota = new Pikachu(amiPika);
        this.saldo=saldou;
        segundos = time;
        this.mostrarTiempoTranscurrido();
        this.mainFrame();
        segundos = time;
        username=user;
        thread.start();
        try{
            for(int i=1;i<regalosPika.length;i++){
                Regalo gift = new Regalo(Integer.parseInt(regalosPika[i]));
                mascota.addGiftHistory(gift);
            }
            for(int j=1;j<regalosSno.length;j++){
                Regalo gift = new Regalo(Integer.parseInt(regalosSno[j]));
                mascota1.addGiftHistory(gift);
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
        estado3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Pokemon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pikachu3 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pikachu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/snorlax.png"))); // NOI18N
        jPanel1.add(pikachu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, 100));

        jLabel1.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jLabel1.setText("Estado Snorlax:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        label.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label.setText("Tiempo Transcurrido:");
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label2.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        label2.setText("Watts:");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        estado3.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        estado3.setText("Normal");
        jPanel1.add(estado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        jButton1.setText("Ir a Tienda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, -1));

        Pokemon.setText("Pokemon");
        Pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PokemonActionPerformed(evt);
            }
        });
        jPanel1.add(Pokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, -1));

        jButton3.setText("Jugar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        jLabel5.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        jLabel5.setText("Estado Pikachu:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        pikachu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/normalp.png"))); // NOI18N
        jPanel1.add(pikachu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 100, 100));

        estado.setFont(new java.awt.Font("Silom", 1, 14)); // NOI18N
        estado.setText("Normal");
        jPanel1.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

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
        String[] options = {"Snorlax", "Pikachu"};
        int choice = JOptionPane.showOptionDialog(null, "¿Cuál Pokemon deseas consultar?", "Selección de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        // Verificar la selección del usuario
        if (choice == 0) {
            // El usuario eligió Snorlax
        saldo+=10;
        mascota1.showPokemon(estado.getText());
        } else if (choice == 1) {
            // El usuario eligió Pikachu
            saldo+=10;
            mascota.showPokemon(estado3.getText());
        } else {
            // El usuario cerró el cuadro de diálogo sin hacer ninguna selección
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún Pokémon. ¡Hasta luego!");
            // Aquí puedes agregar el código para manejar esta situación
        }
    }//GEN-LAST:event_PokemonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String[] options = {"Snorlax", "Pikachu"};
        int choice = JOptionPane.showOptionDialog(null, "¿Con qué Pokémon quieres jugar?", "Selección de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        // Verificar la selección del usuario
        switch (choice) {
            case 0:
                {
                    // El usuario eligió Snorlax
                    int aux = saldo;
                    int finale = mascota1.jugar(saldo);
                    saldo=(saldo-aux)+finale;
                    break;
                }
            case 1:
                {
                    // El usuario eligió Pikachu
                    int aux = saldo;
                    int finale = mascota.jugar(saldo);
                    saldo=(saldo-aux)+finale;
                    break;
                }
            default:
                // El usuario cerró el cuadro de diálogo sin hacer ninguna selección
                JOptionPane.showMessageDialog(null, "No has seleccionado ningún Pokémon. ¡Hasta luego!");
                // Aquí puedes agregar el código para manejar esta situación
                break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saldo+=10;
        int aux = saldo;
        int finale = 0;
        String[] options = {"Snorlax", "Pikachu"};
        int choice = JOptionPane.showOptionDialog(null, "¿A qué pokemon le comprarás?", "Selección de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        // Verificar la selección del usuario
        if (choice == 0) {
            // El usuario eligió Snorlax
        finale = nuevo.tiendaSno(saldo,mascota1);
        } else if (choice == 1) {
            // El usuario eligió Pikachu
            finale =nuevo.tiendaPika(saldo,mascota);
        } else {
            // El usuario cerró el cuadro de diálogo sin hacer ninguna selección
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún Pokémon. ¡Hasta luego!");
            // Aquí puedes agregar el código para manejar esta situación
        }      
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
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pokemon;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel estado3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel pikachu2;
    private javax.swing.JLabel pikachu3;
    // End of variables declaration//GEN-END:variables
}
