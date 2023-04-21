package com.gamingUsers.Gaming.canvas;

import com.gamingUsers.Gaming.Sprites.Jin;
import com.gamingUsers.Gaming.Sprites.Paul;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class GameBoard extends JPanel implements GameVar {
    String arcadeBG="fight_2.jpg";
    Jin jin =new Jin();
    Paul paul=new Paul();
    BufferedImage imageBg;
    public GameBoard() {
        setFocusable(true);
        loadBackground();
        keyBind();
    }
    @Override
    public void paintComponent(Graphics pen) {
        showBackground(pen);
        jin.drawPlayer(pen);
        paul.drawPlayer(pen);
    }
    public void keyBind(){
        KeyListener listener=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key=e.getKeyChar();
                if (key=='d'){
                    jin.moveJIN(5, key);
                    repaint();
                }
                if (key=='h'){
                    paul.movePaul(5, key);
                    repaint();
                }
                if (key=='a'){
                    jin.moveJIN(5, key);
                    repaint();
                }
                if (key=='f'){
                    paul.movePaul(5, key);
                    repaint();
                }
                if (key=='z' || key=='x'){
                    jin.attackJIN(key);
                    repaint();
                }
                if (key=='c' || key=='v'){
                    paul.PaulAttacks(key);
                    repaint();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        this.addKeyListener(listener);
    }
    private void showBackground(Graphics pen) {
        pen.drawImage(imageBg, bX, bY, bWidth, bHeight, null);
    }
    private void loadBackground() {
        try {
            imageBg = ImageIO.read(Objects.requireNonNull(GameBoard.class.getResource(arcadeBG)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
