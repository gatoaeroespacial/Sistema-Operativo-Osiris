/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Clases.helper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanm
 */
public class Escritorio extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private JLabel horaLabel;
    private boolean culebrita = false;

    public Escritorio() {
        iniciarReloj();
        initComponents();

        JPanel panel = jPanel1;
        panel.setBackground(new Color(0, 0, 50)); // Azul oscuro (RGB: 0, 0, 50)
        ImageIcon imagen = new ImageIcon("src/images/inicio.jpg");
        Image imagen2 = imagen.getImage();

        panel.imageUpdate(imagen2, 0, 0, 100, 1000, 100);
        //como importar la imagen que esta al mismo nivel que el archivo
        //como saber si la imagen se cargo correctamente
        if (imagen.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Error al cargar la imagen");
        }
        /*
        Icon icon = new ImageIcon(imagen.getImage());
          JLabel imagenLabel= jLabel1;
          imagenLabel.setIcon(imagen);
          helper.setImageLabelSize(jLabel1);

        panel.add(imagenLabel, BorderLayout.NORTH);
                  this.repaint();
         */

        // Crear un JLabel para el texto "OSIRIS"
        JLabel label = new JLabel("OSIRIS");
        label.setFont(new Font("Arial", Font.BOLD, 72));
        label.setForeground(new Color(76, 16, 198)); // Color blanco
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrar horizontalmente

        // Agregar el JLabel al centro del panel
        panel.add(label, BorderLayout.CENTER);

        JPanel footerPanel = jPanel2;
        footerPanel.setBackground(new Color(75, 0, 130)); // Morado oscuro (RGB: 75, 0, 130)
        footerPanel.setPreferredSize(new Dimension(getWidth(), 50)); // Altura de 50 píxeles

        // Crear un layout de FlowLayout para el footer
        // FlowLayout flowLayout = new FlowLayout();
        //flowLayout.setAlignment(FlowLayout.LEFT); // Alinear los componentes a la izquierda
        //footerPanel.setLayout(flowLayout);
        ImageIcon icono = new ImageIcon("C:\\Users\\juanm\\OneDrive\\Documentos\\Sistemas Operativos\\ProyectoOsiris\\src\\images\\inicio.jpg"); // Reemplaza con la ruta de tu icono
        Image image = icono.getImage();
        image = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

        icono = new ImageIcon(image);
        jLabel2.setIcon(icono);

        ImageIcon icono2 = new ImageIcon("C:\\Users\\juanm\\OneDrive\\Documentos\\Sistemas Operativos\\ProyectoOsiris\\src\\images\\begin.jpg"); // Reemplaza con la ruta de tu icono
        Image image2 = icono2.getImage();
        image2 = image2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

        icono2 = new ImageIcon(image2);
        jLabel3.setIcon(icono2);

        ImageIcon icono3 = new ImageIcon("C:\\Users\\juanm\\OneDrive\\Documentos\\Sistemas Operativos\\ProyectoOsiris\\src\\images\\music.jpg"); // Reemplaza con la ruta de tu icono
        Image image3 = icono3.getImage();
        image3 = image3.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

        icono3 = new ImageIcon(image3);

        JLabel iconoLabel3 = new JLabel(icono3);

        ImageIcon icono4 = new ImageIcon("C:\\Users\\juanm\\OneDrive\\Documentos\\Sistemas Operativos\\ProyectoOsiris\\src\\images\\Calculadora.jpg"); // Reemplaza con la ruta de tu icono
        Image image4 = icono4.getImage();
        image4 = image4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

        icono4 = new ImageIcon(image4);

        JLabel iconoLabel4 = new JLabel(icono4);

        ImageIcon icono5 = new ImageIcon("C:\\Users\\juanm\\OneDrive\\Documentos\\Sistemas Operativos\\ProyectoOsiris\\src\\images\\snake.jpg"); // Reemplaza con la ruta de tu icono
        Image image5 = icono5.getImage();
        image5 = image5.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);

        icono5 = new ImageIcon(image5);

        JLabel iconoLabel5 = new JLabel(icono5);

        jLabel4.setIcon(icono3);
        jLabel5.setIcon(icono4);
        jLabel6.setIcon(icono5);

        btnRegistrar.setSize(50, 50);
        horaLabel = jLabel1;

        jLabel2.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel6.setText("");
        
        horaLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        horaLabel.setForeground(Color.WHITE);
        pack();

        // Agregar el footer al panel principal
        panel.add(footerPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        add(panel);

        // Mostrar el frame
        setVisible(true);
        System.out.println("holalalas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 45, 248));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistrar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrarse");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("jLabel4");

        jLabel6.setText("jLabel6");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 770, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(633, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        FormRegistro form = new FormRegistro();
        form.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (!culebrita) {
            Culebrita snake = new Culebrita();
            snake.setVisible(true);
            this.culebrita = true;
            snake.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    culebrita = false;
                }
            });
        }
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escritorio().setVisible(true);
            }
        });
    }

    private void iniciarReloj() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarHora();
            }
        });
        timer.start();
    }

    private void actualizarHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date ahora = new Date();
        horaLabel.setText(sdf.format(ahora));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
