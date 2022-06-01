package Speak;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MyMusicPlayer {
    private String fileName;
    private Player player;

    public MyMusicPlayer(String filename){
        this.fileName = filename;
    }
    public void close(){
        if(player!=null)
            player.close();
    }
    public void play(){
        try{
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        new Thread(){
            public void run() {
                try {
                    player.play();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}