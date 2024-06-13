/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelFondoC extends JPanel{

    
    Color colrfondo= Color.gray;
    int tammax, tam, can, res;
    
    
    public PanelFondoC (int tammax, int can){
    
        this.tammax=tammax;
        this.can= can;
        this.tam= tammax/can;
        this.res = tammax%can;
    }

    public void paint(Graphics pintor){
        
    super.paint(pintor);
    pintor.setColor(colrfondo);
    for(int i =0;i < can; i++){
        
    for(int j =0;j < can; j++){
    
        
        pintor.fillRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
        
    }
    }
    
        
    }           
}
