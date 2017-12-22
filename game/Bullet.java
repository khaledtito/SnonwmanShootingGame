/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.game;

import java.awt.Point;

public class Bullet implements Runnable
{
    public Point pos=new Point();
    public int Speed;
    public String imgPath="C:\\Users\\Khaled\\Documents\\NetBeansProjects\\Target Game\\Rocket.png";
    
    public Bullet()
    {
        pos.y=400;
        Speed=5;                    //speed initialized with 1 pixel per movement
    }
    public  void  move()
    {
        pos.y -= Speed;              //move rocket to up by decrementing Y axis by 1 pixel
    }

    @Override
    public void run() //move the rocket 400 times and each time delay the movement by 10ms
    {
        try {
            for (int i=0;i<120;i++)
            {
                move();
                Thread.sleep(10);                            //delay movement each time by 10ms
            }
        }
        catch (InterruptedException ex) {}
    }
}