/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.applet.*;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Sashank
 */
public class Game extends Frame implements ActionListener
{
     BufferedImage img;

    WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
           dispose();
        }
    };
TextField tf = new TextField(50);
Button s = new Button("submit");
Button r = new Button("replay sound");
 Panel p = new Panel();
String [] e = {"cat","eclipse","king","late","weight"};
  int randomNum;    
    public Game() {
        
   
    
    
p.add(tf);
p.add(s);
p.add(r);
add("North", p);
s.addActionListener(this);
r.addActionListener(this);      
   
                AudioStream au = null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\in.au");
            au = new AudioStream(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
            AudioPlayer.player.start(au);
         try {
             sleep(3000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
                randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                try {
            InputStream in = new FileInputStream("C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\game\\"+e[randomNum]+".au");
            au = new AudioStream(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioPlayer.player.start(au);
    
      setSize(450,450);
        
        addWindowListener(wl);
        setVisible(true);   

        
        
    }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getActionCommand()=="submit")
       {
           String s = tf.getText();
           
          
           if(s.matches(e[randomNum]))
           {
               tf.setText("correct");
                try {
            img = ImageIO.read(new File("C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\game\\"+e[randomNum]+".jpg"));
         } catch (IOException ex) {
           Logger.getLogger(Easy.class.getName()).log(Level.SEVERE, null, ex);
         }
           repaint();
           }
           else
           {
              tf.setText("incorrect"); 
              
          }
       }
       if(ae.getActionCommand()=="replay sound")
       {
           AudioStream au = null;
           try {
            InputStream in = new FileInputStream("C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\game\\"+e[randomNum]+".au");
            au = new AudioStream(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioPlayer.player.start(au);
       }
   }
    public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(img, 50, 50,1000,500, null);
    }
}
