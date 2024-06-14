
package Formularios;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagePlayer extends JDialog {

    private JLabel imageLabel;

    public ImagePlayer(Frame parent, boolean modal, String imagePath) {
        super(parent, modal);
        initComponents(imagePath);
    }

    private void initComponents(String imagePath) {
        setTitle("Visor de Imágenes: " + imagePath);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(img);
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImagePlayer player = new ImagePlayer(null, true, "C:\\Users\\juanm\\OneDrive\\Documentos\\NetBeansProjects\\SOsiris\\src\\Images\\snake.jpg");
            player.setVisible(true);
        });
    }

    
    
    //generat
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
