package com.game.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music  {
    public void music() throws FileNotFoundException,JavaLayerException{
        String str = System.getProperty("user.dir")+"/music/MusicOfGame.mp3";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        System.out.println("check");
        Player player = new Player(bufferedInputStream);
        player.play();
    }
}
