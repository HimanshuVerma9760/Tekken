package com.gamingUsers.Gaming.canvas;

import javax.swing.*;

public class GameFrame extends JFrame implements GameVar{
    public GameFrame(){
        try {
            setResizable(false);
            setTitle("Game Frame");
            setSize(bWidth, bHeight);
            setLocationRelativeTo(null);
            GameBoard board=new GameBoard();
            add(board);
            setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        GameFrame gameFrame=new GameFrame();
    }
}
