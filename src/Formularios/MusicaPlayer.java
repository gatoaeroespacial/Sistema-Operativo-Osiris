
package Formularios;

//All code is added to create the widget. Follow the "Create a Widget" tutorial if you want to know how I did it.

import Clases.MainClass;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MusicaPlayer extends javax.swing.JDialog 
{
    int xMouse;
    int yMouse;
    MainClass MC=new MainClass();
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 185;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height - 180;
    public static String name;
    public static boolean loop=false;
        public boolean isplay= false;
        public static String pathini ;
    public MusicaPlayer(java.awt.Frame parent, boolean modal, String path )//path 
    {
        super(parent, modal);
        initComponents();
        this.pathini=path;   
        this.setLocation(width, height);
        iniciopt(path);
    }
   private void iniciopt(String path) {                                        
        if(path.equals("")){
            System.out.println("hola");
        }else{
         MC.Play(path);
         isplay= true;
        }
        
    }       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Play = new javax.swing.JLabel();
        SelectFile = new javax.swing.JLabel();
        Pause = new javax.swing.JLabel();
        Stop = new javax.swing.JLabel();
        Loop = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MP3 Player");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 90, 90));

        SelectFile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectFileMouseReleased(evt);
            }
        });
        getContentPane().add(SelectFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 60, 40, 40));

        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseMouseReleased(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 50, 60, 60));

        Stop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StopMouseReleased(evt);
            }
        });
        getContentPane().add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, 60));

        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoopMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, 40));

        Display.setBackground(new java.awt.Color(255, 153, 51));
        Display.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        Display.setText("Hello User!!");
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 340, 20));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background.png"))); // NOI18N
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BackgroundMouseDragged

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

    }//GEN-LAST:event_BackgroundMousePressed

    private void StopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopMouseReleased
        // TODO add your handling code here:
        MC.Stop();
        isplay = false;
    }//GEN-LAST:event_StopMouseReleased

    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseReleased
        // TODO add your handling code here:
        if (!isplay) {
            MC.Resume();
            isplay = true;
        }

    }//GEN-LAST:event_PlayMouseReleased

    private void PauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseMouseReleased
        // TODO add your handling code here:
        MC.Pause();
        isplay = false;
    }//GEN-LAST:event_PauseMouseReleased

    private void SelectFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectFileMouseReleased
        // TODO add your handling code here:
        isplay = false;
        MC.Stop();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");

        JFileChooser chooser = new JFileChooser(new File("C:\\Users\\juanm\\OneDrive\\Documentos\\NetBeansProjects\\SOsiris\\src\\Music")); // Cambia a tu directorio preferido

        chooser.addChoosableFileFilter(filter);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File myFile = chooser.getSelectedFile();
            String song = myFile + "";
            MC.Stop();
            name = chooser.getSelectedFile().getName();
            Display.setText(name);
            MC.Play(song);
        }
    }//GEN-LAST:event_SelectFileMouseReleased

    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseReleased
        // TODO add your handling code here:

        dispose(); // Cierra el diálogo al hacer clic en CloseLabel
        MC.resetSong();
    }//GEN-LAST:event_LoopMouseReleased

    private void LoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoopMouseClicked

    public static void main(String args[]) {
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(MusicaPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(MusicaPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(MusicaPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(MusicaPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            MusicaPlayer dialog = new MusicaPlayer(new javax.swing.JFrame(), true,"");
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel Loop;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel Play;
    private javax.swing.JLabel SelectFile;
    private javax.swing.JLabel Stop;
    // End of variables declaration//GEN-END:variables
}
