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
public class RGBModelFunctions {
    
      
    public void rgbFilter(BufferedImage image, JPanel picturePanel, String color, int value) {
       
        Color colorOfPixel;
        Color colorOfPixelHistogram;
        
            int alpha; 
            int red;
            int green;
            int blue;
            int argb;
            int histogramExtendRedMax = -1;
            int histogramExtendRedMin = -1;
            int histogramExtendGreenMax = -1;
            int histogramExtendGreenMin = -1;
            int histogramExtendBlueMax = -1;
            int histogramExtendBlueMin = -1;
            int histogramRedTemp;
            int histogramGreenTemp;
            int histogramBlueTemp;
        
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
                    red = ((colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3) + 2*value;
                    green = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3 + value;
                    blue = (colorOfPixel.getRed() + colorOfPixel.getGreen() + colorOfPixel.getBlue())/3;
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                } else if ("solarisation".equals(color)) 
                {
                    red = colorOfPixel.getRed();
                    green = colorOfPixel.getGreen();
                    blue = colorOfPixel.getBlue();
                    int lightLevel = (red + green + blue)/3;
                    if (lightLevel < value){
                    red = 255 - colorOfPixel.getRed();
                    green = 255 - colorOfPixel.getGreen();
                    blue = 255 - colorOfPixel.getBlue();
                    }
                } else if ("gamma".equals(color)) 
                {
                    double aRed = ((double)colorOfPixel.getRed())/255.0;
                    double aGreen = ((double) colorOfPixel.getGreen())/255.0;
                    double aBlue = ((double) colorOfPixel.getBlue())/255.0;
                    double c;
                    c = ((double) value)/10.0; //wartości stałe dla urządzenia - dobre miary które znalazłem to 0.7 - przyciemnianie, 2.2 - rozjaśnianie
                    //if (value == 0) c = 0.52;
                    double b = 1.0/c;
                    red = (int) (255 * Math.pow(aRed, b));
                    green = (int) (255 * Math.pow(aGreen, b));
                    blue = (int) (255 * Math.pow(aBlue, b));
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                } else if ("exposition".equals(color)) 
                {
                    
                    double AIRed = (double) colorOfPixel.getRed();
                    double AIGreen = (double) colorOfPixel.getGreen();
                    double AIBlue = (double) colorOfPixel.getBlue();
                    double a = Math.pow(2, value);
                    
                    red = (int) (AIRed*a);
                    green = (int) (AIGreen*a);
                    blue = (int) (AIBlue*a);
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                    
                } else if ("histogramExtend".equals(color)) 
                {
                    if (histogramExtendRedMax == -1 && histogramExtendRedMin == -1 && histogramExtendGreenMax == -1 && histogramExtendGreenMin == -1 && histogramExtendBlueMax == -1 && histogramExtendBlueMin == -1){
                        for (int zz = 0; zz < image.getHeight(); zz++) {
                            for (int xx = 0; xx < image.getWidth(); xx++) {
                                colorOfPixelHistogram = new Color(image.getRGB(xx,zz));
                                if (zz == 0 && xx == 0){
                                    histogramExtendRedMax = colorOfPixelHistogram.getRed();
                                    histogramExtendRedMin = colorOfPixelHistogram.getRed();
                                    histogramExtendGreenMax = colorOfPixelHistogram.getGreen();
                                    histogramExtendGreenMin = colorOfPixelHistogram.getGreen();
                                    histogramExtendBlueMax = colorOfPixelHistogram.getBlue();
                                    histogramExtendBlueMin = colorOfPixelHistogram.getBlue();
                                } else {
                                 histogramRedTemp = colorOfPixelHistogram.getRed();
                                 histogramGreenTemp = colorOfPixelHistogram.getGreen();
                                 histogramBlueTemp = colorOfPixelHistogram.getBlue();
                                 
                                 if (histogramExtendRedMax < histogramRedTemp) histogramExtendRedMax = histogramRedTemp;
                                 if (histogramExtendRedMin > histogramRedTemp) histogramExtendRedMin = histogramRedTemp;
                                 if (histogramExtendGreenMax < histogramGreenTemp) histogramExtendGreenMax = histogramGreenTemp;
                                 if (histogramExtendGreenMin > histogramGreenTemp) histogramExtendGreenMin = histogramGreenTemp;
                                 if (histogramExtendBlueMax < histogramBlueTemp) histogramExtendBlueMax = histogramBlueTemp;
                                 if (histogramExtendBlueMin > histogramBlueTemp) histogramExtendBlueMin = histogramBlueTemp;
                                 
                                 
                                 
                                }
                                
                            }   
                        }
                    }
                    red = (255*(colorOfPixel.getRed()-histogramExtendRedMin))/(histogramExtendRedMax - histogramExtendRedMin);
                    green = (255*(colorOfPixel.getGreen()-histogramExtendGreenMin))/(histogramExtendGreenMax - histogramExtendGreenMin);
                    blue = (255*(colorOfPixel.getBlue()-histogramExtendBlueMin))/(histogramExtendBlueMax - histogramExtendBlueMin);
                    //if (red < 0) red = 0;
                    //if (green < 0) green = 0;
                    //if (blue < 0) blue = 0;
                }  else {
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
    
    public void solarFilter(BufferedImage image, JPanel picturePanel, String color, int value, int lightLevel){
        Color colorOfPixel;
        
            int alpha; 
            int red;
            int green;
            int blue;
            int argb;
        
        
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                colorOfPixel = new Color(image.getRGB(j,i));
                
                int newColorValue;
                red = colorOfPixel.getRed();
                green = colorOfPixel.getGreen();
                blue = colorOfPixel.getBlue();
                
                if (red > lightLevel)
                    red = 255 - red + value;
                if (green > lightLevel)
                    green = 255 - green + value;
                if (blue > lightLevel)
                    blue = 255 - blue + value;
                  
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (red < 0) red = 0;
                if (green < 0) green = 0;
                if (blue < 0) blue = 0;
                
                image.setRGB(j, i, new Color(red, green, blue).getRGB());
            }
        }
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
                
                
    }


public void ownRGBFilter(BufferedImage image, JPanel picturePanel, String color, int valueRed, int valueGreen, int valueBlue) {
       
        Color colorOfPixel;
        
            int red;
            int green;
            int blue;
            int argb;

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                colorOfPixel = new Color(image.getRGB(j,i));
                
                if ("ownColor".equals(color))
                {
                    
                    red = colorOfPixel.getRed() + valueRed;
                    green = colorOfPixel.getGreen() + valueGreen;
                    blue = colorOfPixel.getBlue() + valueBlue;
                    if (blue < 0) blue = 0;
                    if (green < 0) green = 0;
                    if (red < 0) red = 0;
                    if (red > 255) red = 255;
                    if (green > 255) green = 255;
                    if (blue > 255) blue = 255;
                
                }
                else {
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