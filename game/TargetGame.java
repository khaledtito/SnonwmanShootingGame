/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.game;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Khaled
 */
public class TargetGame
{

    public static void main(String[] args)
    {
        MovingObjects play=new MovingObjects();
        play.setTitle("PerfectShot V1.0");
        play.setDefaultCloseOperation(MovingObjects.EXIT_ON_CLOSE);
        
        Thread t1=new Thread(play);
        t1.start();
    }
    
}
