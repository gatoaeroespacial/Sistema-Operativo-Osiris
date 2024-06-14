/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author juanm
 */
public class Caminante implements Runnable{
    PanelSnake panel;
    boolean estado=true;
        int time =250;

    public Caminante(PanelSnake panel){
    this.panel =panel;
    
}
    @Override
    public void run() {
        
        while(estado){

        panel.repaint();
        panel.avanzar();
                
             
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        }
    }
    public void Parar(){
    this.estado = false;
    }
    
    public void Continuar(){
      
        panel.revalidate();
        panel.repaint();
                
    this.estado = true;
      
    }
}
