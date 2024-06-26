/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Clases.PanelFondoC;
import Clases.PanelSnake;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author juanm
 */
public class Culebrita extends javax.swing.JFrame {

    /**
     * Creates new form Culebrita
     */
    PanelSnake snake;

    public Culebrita() {
        // En la clase Frame1
        // En la clase Frame2
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        this.snake = new PanelSnake(600, 30);
        this.add(snake);
        snake.setBounds(10, 10, 600, 600);
        snake.setOpaque(false);

        PanelFondoC fondo = new PanelFondoC(600, 30);
        this.add(fondo);
        fondo.setBounds(10, 10, 600, 600);

        this.setBounds(0, 0, 640, 660);
        this.setLocationRelativeTo(null);
        this.requestFocus(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                snake.cambiardireccion("iz");
                break;
            case KeyEvent.VK_RIGHT:
                snake.cambiardireccion("de");
                break;
            case KeyEvent.VK_DOWN:
                snake.cambiardireccion("ab");
                break;
            case KeyEvent.VK_UP:
                snake.cambiardireccion("ar");
                break;

            case KeyEvent.VK_A:
                snake.cambiardireccion("iz");
                break;
            case KeyEvent.VK_D:
                snake.cambiardireccion("de");
                break;
            case KeyEvent.VK_S:
                snake.cambiardireccion("ab");
                break;
            case KeyEvent.VK_W:
                snake.cambiardireccion("ar");
                break;
            case KeyEvent.VK_SPACE:
                snake.Continuar();
                break;

            case KeyEvent.VK_P:
                //snake.Pausa();
                break;

            default:
                break;

        }


    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Culebrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Culebrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Culebrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Culebrita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Culebrita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
