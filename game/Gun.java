/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.game;

import java.awt.Point;

/**
 *
 * @author Khaled
 */
public class Gun {
    public Point pos=new Point();          //make an instance of ready made class 'point' to get or set Y or X axis.
    public Bullet Rocket=new Bullet();
    public int speed;
    public Gun (int width)
    {
        speed=10;
        pos.x=width+300;
        pos.y=width+400;
    }

    void mover() {                     //move tank to the right by incrementig X axis.
        if(this.pos.x<1250)
        this.pos.x+=speed;
    }
      void movel() {              //move tank to the right by incrementig Y axis.
          if(this.pos.x+100>=0)
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+25; //set the X axis of the rocket to the same axis of the tank +60 pixels to set it on top of the gun
        Rocket.pos.y=this.pos.y;
        Thread shoot=new Thread (Rocket);
        shoot.start(); 
    }
}
