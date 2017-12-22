/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Khaled
 */
public class Target
{
    int speed=10;
    public Point pos=new Point();
    public Target() 
    {
        pos.x=0;
        pos.y=5;
    }

    public void move(int width)
    {
        pos.x+=speed;
        if (pos.x+220>width)
        {
            speed=-speed;
        }
        if (pos.x<0)
        {
            speed=-speed;
        }
    }
}
