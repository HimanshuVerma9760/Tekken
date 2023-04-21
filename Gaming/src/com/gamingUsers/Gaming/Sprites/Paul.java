package com.gamingUsers.Gaming.Sprites;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Paul {
    public int x=650, h=320, y=310, w=280;
    private static int imageIndex=1;
    private static char key;
    private BufferedImage playerImg;
    private final BufferedImage[] PaulPunches= new BufferedImage[6];
    private final BufferedImage[] PaulKicks= new BufferedImage[4];

    private void loadPaulPunches(){
        PaulPunches[0]= playerImg.getSubimage(1511, 873, 259, 260);
        PaulPunches[1]=playerImg.getSubimage(93, 33, 275, 251);
        PaulPunches[2]=playerImg.getSubimage(91, 323, 243, 234);
        PaulPunches[3]=playerImg.getSubimage(692, 21, 190, 254);
        PaulPunches[4]=playerImg.getSubimage(1522, 591, 209, 256);
        PaulPunches[5]=playerImg.getSubimage(973, 33, 222, 241);

    }
    private void loadPaulKicks(){
        //X = 1773 Y = 883
        //Width = 250 Height = 249
        PaulKicks[0]=playerImg.getSubimage(652, 321, 246, 241);
        PaulKicks[1]=playerImg.getSubimage(1487, 1752, 254, 210);
        PaulKicks[2]=playerImg.getSubimage(1773, 883, 250, 249);

    }
    public Paul(){
        try{
            playerImg= ImageIO.read(Objects.requireNonNull(Paul.class.getResource("Paul.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void movePaul(int speed, char key){
        if (key=='h'){
            x=x+speed;
        }
        if (key=='f'){
            x=x-speed;
        }
    }
    public void PaulAttacks(char k){
            key=k;
    }
    public void drawPlayer(Graphics pen){
        pen.drawImage(idle(key), x, y, w, h, null);
    }

    public BufferedImage idle(char key) {
        loadPaulPunches();
        loadPaulKicks();
        BufferedImage image;
        if (key=='c'){
            if (imageIndex>=6){
                imageIndex=1;
            }
            image=PaulPunches[imageIndex];
            imageIndex++;
            return image;
        }
       else if (key=='v'){
            if (imageIndex>=3){
                imageIndex=1;
            }
            image=PaulKicks[imageIndex];
            imageIndex++;
            return image;
        }else {
            return PaulPunches[0];
        }
    }
}
