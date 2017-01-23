/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiOperations;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Maciek P
 */
public class ImageOperations {
    
      public BufferedImage insertPicture(String file, JPanel picturePanel) {
        picturePanel.removeAll();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file));
        }
        catch (IOException e) {
        }
        
        Image dimg = img.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.add(imageLabel);
        //pack();
        return img;
    }

    public void savePicture(String path, BufferedImage image) throws IOException {
        String extensionValidator;
        if (path.length() > 3) 
            extensionValidator = path.substring(path.length() - 4, path.length());
        else 
            extensionValidator = null;
       
        if (!extensionValidator.equals(".jpg") && !extensionValidator.equals(".png")) {
            path = path + ".jpg";
        }
        File outputfile = new File(path);
        ImageIO.write((RenderedImage)image, "jpg", outputfile);
    }
}
