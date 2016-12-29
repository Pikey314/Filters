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
        
        
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
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
                } else if ("blue".equals(color))
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() - value;
                    green = colorOfPixel.getGreen()-value;
                    blue = colorOfPixel.getBlue();
                    if (red < 0) red = 0;
                    if (green < 0) green = 0;    
                } else if ("yellow".equals(color))
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue() - value;
                    if (blue < 0) blue = 0;
                } else if ("purple".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen() - value;
                    blue = colorOfPixel.getBlue();
                    if (green < 0) green = 0;
                } else if ("cyan".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() - value;
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue();
                    if (red < 0) red = 0;
                } else if ("white".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() + value;
                    green = colorOfPixel.getGreen() + value;
                    blue = colorOfPixel.getBlue() + value;
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                } 
                else if ("black".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed() - value;
                    green = colorOfPixel.getGreen() - value;
                    blue = colorOfPixel.getBlue() - value;
                    if (red < 0) red = 0;
                    if (green < 0) green = 0;
                    if (blue < 0) blue = 0;
                }else if ("negative".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = 255 - colorOfPixel.getRed();
                    green = 255 - colorOfPixel.getGreen();
                    blue = 255 - colorOfPixel.getBlue();
                   // if (red < 0) red = 0;
                   // if (green < 0) green = 0;
                   // if (blue < 0) blue = 0;
                } else if ("greyScale".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                    green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                    blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                   // if (red < 0) red = 0;
                   // if (green < 0) green = 0;
                   // if (blue < 0) blue = 0;
                } else if ("sepia".equals(color)) 
                {
                    alpha = colorOfPixel.getAlpha();
                    red = ((colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3) + 2*(20+(value*20/255));
                    green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3 + (20+(value*20/255));
                    blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                } else {
                    red = -1;
                    green = -1;
                    blue = -1;
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

