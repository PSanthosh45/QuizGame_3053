
package quizgame_3035;

import java.awt.*;
import javax.swing.*;


public class Assets {
    
    String path = "C:\\Users\\parus\\Documents\\NetBeansProjects\\QuizGame_3035\\src\\quizgame_3035\\Assets\\";
    
    public ImageIcon ImposterIcon(){
        //get image
        String imposter = (path + "imposter.png");
        ImageIcon icon = new ImageIcon(imposter);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(60,50,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon StatsIcon(){
        //get image
        String stats = (path + "analytics.png");
        ImageIcon icon = new ImageIcon(stats);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(60,50,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon AIcon(){
        //get image
        String lettera = (path + "letter-a.png");
        ImageIcon icon = new ImageIcon(lettera);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon BIcon(){
        //get image
        String letterb = (path + "letter-b.png");
        ImageIcon icon = new ImageIcon(letterb);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon CIcon(){
        //get image
        String letterc = (path + "letter-c.png");
        ImageIcon icon = new ImageIcon(letterc);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon DIcon(){
        //get image
        String letterd = (path + "letter-d.png");
        ImageIcon icon = new ImageIcon(letterd);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
    
    public ImageIcon FIcon(){
        //get image
        String letterf = (path + "letter-f.png");
        ImageIcon icon = new ImageIcon(letterf);
        //resize it
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        return icon;
    }
}
