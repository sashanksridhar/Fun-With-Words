/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.lang.*;
import java.util.concurrent.ThreadLocalRandom;
import sun.audio.*;
/*<applet code = "display" height = 2000 width = 2000>
</applet>
*/
/**
 *
 * @author Sashank
 */

public class display extends Applet implements ActionListener
{
    /**
     * @param args the command line arguments
     */
 
    BufferedImage img;
    int randomNum;
     String [] e = new String[100];
   void add()
   {
    for(int i=1;i<=5;i++)
    e[i]= "C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\img\\"+Integer.toString(i)+".jpg";
   }
  
  int thenmin,nowmin;
 

   @Override
   public void init()
	{	
            
           Calendar calendar = Calendar.getInstance();
           thenmin= calendar.get(Calendar.MINUTE);
            Button easy = new Button("Easy");
            Button medium=new Button("Medium");
            Button hard=new Button("Hard");
            Button game = new Button("Game");
            Button sound = new Button("Sound");
            add(easy);
            add(medium);
            add(hard);
            add(game);
            add(sound);
            easy.addActionListener(this);
            medium.addActionListener(this);
            hard.addActionListener(this);
            game.addActionListener(this);
            sound.addActionListener(this);
            add();
         }

   
       public void actionPerformed(ActionEvent ae) 
       {
           if(ae.getActionCommand()=="Easy")
           {
            Easy e = new Easy();
           }
           if(ae.getActionCommand()=="Medium")
           {
            Medium e = new Medium();
           }
           if(ae.getActionCommand()=="Hard")
           {
            Hard e = new Hard();
           }
           if(ae.getActionCommand()=="Game")
           {
               Game e = new Game();
           }
           if(ae.getActionCommand()=="Sound")
           {
                AudioStream au = null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\sound\\"+Integer.toString(randomNum)+".au");
            au = new AudioStream(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
                AudioPlayer.player.start(au);
       }
           }
       
       class Th extends Thread
      {
       public void run()
       {
       int i=1;
           while(i==1)
           {
             Calendar calendar = Calendar.getInstance();
           nowmin= calendar.get(Calendar.MINUTE); 
            if((nowmin-thenmin)==1)
            {
               thenmin = nowmin;
             break;
             
            }
           }
           repaint();
       }  
       
       
      }    
       public void paint(Graphics g) 
       {
          Th t = new Th();
          t.start();
           randomNum = ThreadLocalRandom.current().nextInt(1, 6);
           try {
             img = ImageIO.read(new File(e[randomNum]));
         } catch (IOException ex) {
             Logger.getLogger(Easy.class.getName()).log(Level.SEVERE, null, ex);
         }
           super.paint(g);
        
         g.drawImage(img, 50, 50,1000,500, null);
         
            
      
       }
}


