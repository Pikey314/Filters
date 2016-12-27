/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorFilters;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Maciek P
 */
public class RGBFilters {
    
      
    public void rgbFilter(BufferedImage image, JPanel picturePanel, String color, int value) {
       
        Color colorOfPixel;
        
            int alpha; 
            int red;
            int green;
            int blue;
            int argb;
        
        
        for (int i = 0; i < image.getHeight()-1; i++) {
            for (int j = 0; j < image.getWidth()-1; j++) {
                colorOfPixel = new Color(image.getRGB(j,i));
                
                if ("red".equals(color))
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen()-value;
                    blue = colorOfPixel.getBlue()-value;
                    if (blue < 0) blue = 0;
                    if (green < 0) green = 0;
                } else if ("green".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() - value;
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue()-value;
                    if (blue < 0) blue = 0;
                    if (red < 0) red = 0;    
                } else
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() - value;
                    green = colorOfPixel.getGreen()-value;
                    blue = colorOfPixel.getBlue();
                    if (red < 0) red = 0;
                    if (green < 0) green = 0;    
                }
                image.setRGB(j, i, new Color(red, green, blue).getRGB());
            }
        }
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
        
    }
}

