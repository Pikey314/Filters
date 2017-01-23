/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorModelFunctions;

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
public class HSVModelFunctions {
    private final HSVconverter converter = new HSVconverter();
    
    public void hsvFilter(BufferedImage image, JPanel picturePanel, String operation, int value, int range){
        
        Color colorOfPixel;
            
            int red;
            int green;
            int blue;
            double hsvModel[];
            double h;
            double s;
            double v;
            double hUp = (value + (range/2) + 360)%360;
            double hDown = (value - (range/2) + 360)%360;
        
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                colorOfPixel = new Color(image.getRGB(j,i));
                
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue();
                    
                    hsvModel = this.converter.rgb2hsv((double) red, (double) green, (double) blue);
                    h = hsvModel[0];
                    s = hsvModel[1];
                    v = hsvModel[2];
                    
                    if (operation.equals("accent")){
                    if (hDown <= hUp)
                    {
                        if (h < hDown || h > hUp){

                            red = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            image.setRGB(j, i, new Color(red, green, blue).getRGB());
                        }                         
                    } else 
                    {
                        if (h > hDown || h < hUp){

                            red = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                            image.setRGB(j, i, new Color(red, green, blue).getRGB());
                        }                         
                    }
                    } else if (operation.equals("light"))
                    {
                        v = v + value;
                        if (v < 0) v = 0;
                        if (v > 510) v = 510;
                        red = (int) this.converter.hsv2rgb(h, s, v)[0];
                        green = (int) this.converter.hsv2rgb(h, s, v)[1];
                        blue = (int) this.converter.hsv2rgb(h, s, v)[2];
                        if (red < 0) red = 0;
                        if (red > 255) red = 255;
                        if (green < 0) green = 0;
                        if (green > 255) green = 255;
                        if (blue < 0) blue = 0;
                        if (blue > 255) blue = 255;
                        image.setRGB(j, i, new Color(red, green, blue).getRGB());
                    } else if (operation.equals("saturation")) 
                    {
                        s = s + ((double) value / 200.0);
                        if (s < 0) s = 0;
                        if (s > 1) s = 1;
                        red = (int) this.converter.hsv2rgb(h, s, v)[0];
                        green = (int) this.converter.hsv2rgb(h, s, v)[1];
                        blue = (int) this.converter.hsv2rgb(h, s, v)[2];
                        if (red < 0) red = 0;
                        if (red > 255) red = 255;
                        if (green < 0) green = 0;
                        if (green > 255) green = 255;
                        if (blue < 0) blue = 0;
                        if (blue > 255) blue = 255;
                        image.setRGB(j, i, new Color(red, green, blue).getRGB());
                    } else if (operation.equals("color")) 
                    {
                        h = h + value;
                        if (h < 0) h = h + 360;
                        if (h > 360) h = h - 360;
                        red = (int) this.converter.hsv2rgb(h, s, v)[0];
                        green = (int) this.converter.hsv2rgb(h, s, v)[1];
                        blue = (int) this.converter.hsv2rgb(h, s, v)[2];
                        if (red < 0) red = 0;
                        if (red > 255) red = 255;
                        if (green < 0) green = 0;
                        if (green > 255) green = 255;
                        if (blue < 0) blue = 0;
                        if (blue > 255) blue = 255;
                        image.setRGB(j, i, new Color(red, green, blue).getRGB());
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
