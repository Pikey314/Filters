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
import java.awt.image.IndexColorModel;

/**
 *
 * @author Maciek P
 */
public class HSVFilters {
    HSVconverter converter = new HSVconverter();
    
    public void hsvFilter(BufferedImage image, JPanel picturePanel, String operation, int value, int range){
        
        Color colorOfPixel;
            
            int alpha; 
            int red;
            int green;
            int blue;
            int argb;
            double hsvModel[];
            double rgbModel[];
            double h;
            double s;
            double v;
            double hUp = (value + (range/2) + 360)%360;
            double hDown = (value - (range/2) + 360)%360;
        
            System.out.println(hUp + " " + hDown);
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                colorOfPixel = new Color(image.getRGB(j,i));
                
                    alpha = colorOfPixel.getAlpha();
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue();
                    
                    hsvModel = this.converter.rgb2hsv((double) red, (double) green, (double) blue);
                    h = hsvModel[0];
                    s = hsvModel[1];
                    v = hsvModel[2];
                    
                    if (hDown <= hUp)
                    {
                        if (h < hDown || h > hUp){
                            //rgbModel = this.converter.hsv2rgb(h, s, v);
                            red = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            image.setRGB(j, i, new Color(red, green, blue).getRGB());
                        }                         
                    } else 
                    {
                        if (h > hDown || h < hUp){
                            //rgbModel = this.converter.hsv2rgb(h, s, v);
                            red = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            image.setRGB(j, i, new Color(red, green, blue).getRGB());
                        }                         
                    }
            }        
         }
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
    }
    
}
