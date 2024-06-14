package Clases;

import Formularios.MusicaPlayer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass {
    FileInputStream fis;
    BufferedInputStream bis;
    public Player player;
    public long pauseLocation,songTotal;
    public String song;

    public void Stop(){
        if(player!=null){
            player.close();
            pauseLocation=songTotal=0;
            MusicaPlayer.Display.setText("ANKS wants you to select a song");
        }
    }
   
    public void resetSong() {
    if (song.isEmpty()) {
        // Si no hay ninguna canción seleccionada, simplemente retorna sin hacer nada
        return;
    }
    
    // Si hay una canción seleccionada, cierra el player y reinicia las variables
    if (player != null) {
        player.close();
    }
    pauseLocation = songTotal = 0;
    song = "";
}

    public void Pause(){
        if(player!=null){
            try {
                pauseLocation= fis.available();
                player.close();
                MusicaPlayer.Display.setText("Don't stop the fun!!");
            }
            catch (IOException ex) {
                
            }
            
        }
    }
    
    public void Play(String path) {
        
        try {
            fis= new FileInputStream(path);
            bis= new BufferedInputStream(fis);
            player= new Player(bis);
            try {
                songTotal=fis.available();
                song=path+"";
            }
            catch (IOException ex) {
                
            }
        }
        catch (FileNotFoundException | JavaLayerException ex) {
            
        }
        new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                    if(player.isComplete() && MusicaPlayer.loop){
                        Play(song);
                    }
                    if(player.isComplete()){
                        MusicaPlayer.Display.setText("ANKS wants you to select a song");
                    }
                } 
                catch (JavaLayerException ex) {
                    
                }
            }
        }.start();
    }
    
    public void Resume() {
        try {
            
            fis= new FileInputStream(song);
            bis= new BufferedInputStream(fis);
            player= new Player(bis);
            try {
                fis.skip(songTotal-pauseLocation);
            }
            catch (IOException ex) {
               
            }
        }
        catch (FileNotFoundException | JavaLayerException ex) {
            
        }
        new Thread(){
            @Override
            public void run(){
                try {
                    MusicaPlayer.Display.setText(MusicaPlayer.name);
                    player.play();
                } 
                catch (JavaLayerException ex) {
                    
                }
            }
        }.start();
    }
}
