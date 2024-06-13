/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSnake extends JPanel {

    Color colorSk = Color.green;
    Color colorcomida = Color.red;

    int tammax, tam, can, res;
    List<int[]> snake = new ArrayList<>();
    int[] comida = new int[2];

    String direccion = "de";
    String direccionProxima = "de";
    int puntos = 0;
    Thread hilo;
    public Caminante camino;

    public PanelSnake(int tammax, int can) {

        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        int[] a = {can / 2 - 1, can / 2 - 1};
        int[] b = {can / 2, can / 2 - 1};

        snake.add(a);
        snake.add(b);
        generarComida();
        comida[0] = 19;
        comida[1] = 14;

        camino = new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();

    }

    public void paint(Graphics pintor) {

        super.paint(pintor);
        pintor.setColor(colorSk);

        for (int[] par : snake) {
            pintor.fillRect(res / 2 + par[0] * tam, res / 2 + par[1] * tam, tam - 1, tam - 1);

        }
        pintor.setColor(colorcomida);

        pintor.fillRect(res / 2 + comida[0] * tam, res / 2 + comida[1] * tam, tam - 1, tam - 1);

    }

    public void avanzar() {
        igualardir();
        int[] ultimo = snake.get(snake.size() - 1);
        int agx = 0;
        int agy = 0;
        switch (direccion) {
            case "de":
                agx = 1;
                break;
            case "iz":
                agx = -1;
                break;
            case "ar":
                agy = -1;
                break;
            case "ab":
                agy = 1;
                break;
        }

        int[] nuevo = {Math.floorMod(ultimo[0] + agx, can),
            Math.floorMod(ultimo[1] + agy, can)};

        boolean existe = false;

        for (int i = 0; i < snake.size(); i++) {

            if (nuevo[0] == snake.get(i)[0] && snake.get(i)[1] == nuevo[1]) {

                existe = true;

                break;
            }
        }
        if (existe) {
            System.out.println("perdio");
            camino.Parar();
            JOptionPane.showMessageDialog(this, "has perdido tu puntuacion fue de: " + puntos);

            //camino.Continuar();
            direccion = "de";
            reiniciar();

        } else {

            if (nuevo[0] == comida[0] && nuevo[1] == comida[1]) {
                // System.out.println("comio");
                snake.add(nuevo);
                if (camino.time > 150) {
                    camino.time = camino.time - 10;
                    puntos += 10;

                } else if (camino.time > 100) {
                    camino.time = camino.time - 5;
                    puntos += 20;

                } else if (camino.time > 80) {
                    camino.time = camino.time - 2;
                    puntos += 30;
                } else if (camino.time > 60) {//a lo mejor sobre y dejarlo hasta 80
                    camino.time = camino.time - 1;
                    puntos += 40;

                } else {
                    puntos += 50;
                }

                generarComida();

            } else {

                snake.add(nuevo);
                snake.remove(0);

            }

        }

    }

    public void generarComida() {

        boolean existe = false;
        int a = (int) (Math.random() * can);
        int b = (int) (Math.random() * can);

        for (int[] par : snake) {

            if (par[0] == a && par[1] == b) {
                existe = true;
                generarComida();
                break;
            }
            if (!existe) {
                this.comida[0] = a;
                this.comida[1] = b;

            }
        }

    }

    public void cambiardireccion(String dir) {
        if ((this.direccion.equals("de") || this.direccion.equals("iz")) && (dir.equals("ar") || dir.equals("ab"))) {

            this.direccionProxima = dir;

        }
        if ((this.direccion.equals("ar") || this.direccion.equals("ab")) && (dir.equals("iz") || dir.equals("de"))) {
            this.direccionProxima = dir;
        }
    }

    public void igualardir() {
        this.direccion = this.direccionProxima;
    }

    public void Continuar() {
        if (!camino.estado) {
            reiniciar();
        }

    }

    public void reiniciar() {
        snake.removeAll(snake);

        int[] a = {can / 2 - 1, can / 2 - 1};
        int[] b = {can / 2, can / 2 - 1};

        direccionProxima = "de";
        snake.add(a);
        snake.add(b);
        generarComida();
        comida[0] = 19;
        comida[1] = 14;

        camino.time = 250;
        camino.Continuar();
        puntos = 0;

    }
}
