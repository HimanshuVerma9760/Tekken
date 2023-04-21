package com.gamingUsers.Gaming.Sprites;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Jin extends JPanel {
    private static int imageIndex=1;
    private static char key;
    private final BufferedImage[] JINpunches=new BufferedImage[6];
    private final BufferedImage[] JINkicks=new BufferedImage[3];

    String myPlayer="jinAttack.png";
    private static int x=55;
    private static final int h=320;
    private static final int y=310;
    private static final int w=320;
    private BufferedImage playerImg;
    public Jin(){
        try{
            playerImg= ImageIO.read(Objects.requireNonNull(Jin.class.getResource(myPlayer)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void moveJIN(int speed, char k){
        key=k;
        if (k=='d'){
            x=x+speed;
        }
        if (k=='a'){
            x=x-speed;
        }
    }
    public void attackJIN(char k){
       key=k;
    }
    public void drawPlayer(Graphics pen){
        pen.drawImage(idle(key), x, y, w, h, null);
    }
    private void loadJinPunches(){
        //X = 311 Y = 608
        //Width = 218 Height = 222
        JINpunches[0]=playerImg.getSubimage(306, 1754, 222, 203);
        JINpunches[1]=playerImg.getSubimage(315, 44, 213, 200);
        JINpunches[2]=playerImg.getSubimage(573, 608, 237, 227);
        JINpunches[3]=playerImg.getSubimage(54, 583, 158, 262);
        JINpunches[4]=playerImg.getSubimage(311, 608, 218, 222);
        JINpunches[5]=playerImg.getSubimage(1169, 27, 182, 255);
    }
    private void loadJinKicks(){
        //X = 335 Y = 1437
        //Width = 183 Height = 259
        JINkicks[0]=playerImg.getSubimage(606, 341, 209, 198);
        JINkicks[1]=playerImg.getSubimage(1187, 315, 158, 251);
        JINkicks[2]=playerImg.getSubimage(335, 1437, 183, 259);
    }
   public BufferedImage idle(char keyCode) {
       BufferedImage img;
       loadJinKicks();
       loadJinPunches();
        if (keyCode=='z'){
            if (imageIndex>=6){
                imageIndex=0;
            }
            img=JINpunches[imageIndex];
            imageIndex++;
            return img;
        }
       else if (keyCode=='x'){
           if (imageIndex>=3){
               imageIndex=0;
           }
           img=JINkicks[imageIndex];
           imageIndex++;
           return img;
       }else {
           return JINpunches[0];
       }
    }
}
