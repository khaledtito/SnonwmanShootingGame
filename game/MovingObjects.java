/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package target.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovingObjects extends JFrame implements Runnable{

    Target myTarget=new Target();
    Gun myGun=new Gun(this.getWidth());
    int score;
    JLabel scoreLabel=new JLabel();
    ArrayList<Target> myArray=new ArrayList<>();
    
    public MovingObjects()
    {
        setSize(600,600);
        setVisible(true);
        setBackground(Color.GRAY);
        this.addKeyListener(new actions());
        score=0;
        scoreLabel.setText(String.valueOf(score));
        this.setBackground(Color.BLUE);
    }

    
    @Override
    public void paint(Graphics g)
    {
        g.clearRect(0,0,this.getWidth(),this.getWidth());
         try 
         {
           BufferedImage imgRocket = ImageIO.read(new File("C:\\Users\\Khaled\\Documents\\NetBeansProjects\\Target Game\\snowball.png"));
           BufferedImage imgCannon = ImageIO.read(new File("C:\\Users\\Khaled\\Documents\\NetBeansProjects\\Target Game\\cannon2.png"));
           BufferedImage imgTarget = ImageIO.read(new File("C:\\Users\\Khaled\\Documents\\NetBeansProjects\\Target Game\\snowman.png"));
           g.drawImage(imgCannon,myGun.pos.x,myGun.pos.y,null);
            g.drawImage(imgRocket,myGun.pos.x+45,myGun.Rocket.pos.y,null);
            g.drawImage(imgTarget,myTarget.pos.x,myTarget.pos.y,null);
            if (myGun.Rocket.pos.distance(myTarget.pos.x, myTarget.pos.y)<=50)
            {
                score++;
                System.out.println("Score= "+score);
                scoreLabel.setText("Score: " + score);
                scoreLabel.setBounds(myGun.pos.x-100, myGun.pos.y, 20, 20);
                this.add(scoreLabel);
            }
         }  
         catch (IOException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        }
    
    class actions implements KeyListener
    {
     @Override
    public void keyTyped(KeyEvent ke) {
        try{}
        catch(UnsupportedOperationException e)
        {}
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        try
        {
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
                myGun.mover();
            else if(ke.getKeyCode()==KeyEvent.VK_LEFT)
                myGun.movel();
            else if(ke.getKeyCode()==KeyEvent.VK_SPACE)
            {
                myGun.fireBullet();
            }
        }
        catch(UnsupportedOperationException e)
        {
            System.out.println(e);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        try{}
        catch(UnsupportedOperationException e)
        {}
    }
    
    }
    
    @Override
    public void run() 
    {
        try 
        {
            while(true)
            {
                myTarget.move(this.getWidth());
                repaint();
                Thread.sleep(50);
            }
        }
        catch (InterruptedException ex){}
    }
}
