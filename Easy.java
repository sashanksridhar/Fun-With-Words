/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;
import java.awt.Button;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Easy extends Frame 
{
     BufferedImage img;

    WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
           dispose();
        }
    };
int randomNum;
String [] e = new String[100];
    public Easy() {
         
   
    for(int i=1;i<=5;i++)
    e[i]= "C:\\Users\\Sashank\\Documents\\NetBeansProjects\\image\\build\\easy\\"+Integer.toString(i)+".jpg";
   
         randomNum = ThreadLocalRandom.current().nextInt(1, 6);
         try {
             img = ImageIO.read(new File(e[randomNum]));
         } catch (IOException ex) {
             Logger.getLogger(Easy.class.getName()).log(Level.SEVERE, null, ex);
         }
        setSize(450,450);
        
        addWindowListener(wl);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 50, 50,1000,500, null);
    }
}

