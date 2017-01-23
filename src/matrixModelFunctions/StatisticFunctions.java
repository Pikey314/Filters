/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixModelFunctions;

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
public class StatisticFunctions {
    
    public void statisticFunction3x3(BufferedImage image, JPanel picturePanel, String function) {
     
        Color colorOfPixel;
        
           // int alpha; 
            int red[][] = new int[image.getWidth()][image.getHeight()];
            int green[][] = new int[image.getWidth()][image.getHeight()];
            int blue[][] = new int[image.getWidth()][image.getHeight()];
            
            int newRed[][] = new int[image.getWidth()][image.getHeight()];
            int newGreen[][] = new int[image.getWidth()][image.getHeight()];
            int newBlue[][] = new int[image.getWidth()][image.getHeight()];
            
            
        
            for (int i = 0; i < image.getWidth(); i++) {
                 for (int j = 0; j < image.getHeight(); j++) {
                      colorOfPixel = new Color(image.getRGB(i,j));
                
                
                        red[i][j] = colorOfPixel.getRed();
                        green[i][j] = colorOfPixel.getGreen();
                        blue[i][j] = colorOfPixel.getBlue();
                   
                 }
            }
            int argsRed[];
            int argsGreen[];
            int argsBlue[];
            
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
               //lewy górny róg start
                if (i == 0 && j == 0) {
                    argsRed = new int[4];
                    argsGreen = new int[4];
                    argsBlue = new int[4];
                    
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i+1][j];
                    argsRed[3] = red[i+1][j+1];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i+1][j];
                    argsGreen[3] = green[i+1][j+1];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i+1][j];
                    argsBlue[3] = blue[i+1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //lewy dolny róg start
                if(i == 0 && j == image.getHeight()-1) {
                    
                    argsRed = new int[4];
                    argsGreen = new int[4];
                    argsBlue = new int[4];
                    
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i+1][j];
                    argsRed[3] = red[i+1][j-1];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i+1][j];
                    argsGreen[3] = green[i+1][j-1];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i+1][j];
                    argsBlue[3] = blue[i+1][j-1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                } 
                
                //prawy górny róg start
                if(i == image.getWidth()-1 && j == 0){
                    argsRed = new int[4];
                    argsGreen = new int[4];
                    argsBlue = new int[4];
                    
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i-1][j];
                    argsRed[3] = red[i-1][j+1];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i-1][j];
                    argsGreen[3] = green[i-1][j+1];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i-1][j];
                    argsBlue[3] = blue[i-1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //prawy dolny róg start
                if(i == image.getWidth()-1 && j == image.getHeight()-1){
                    argsRed = new int[4];
                    argsGreen = new int[4];
                    argsBlue = new int[4];
                    
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i-1][j];
                    argsRed[3] = red[i-1][j-1];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i-1][j];
                    argsGreen[3] = green[i-1][j-1];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i-1][j];
                    argsBlue[3] = blue[i-1][j-1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                   
                    
                }
                
                //lewa krawędź
                if (i == 0 && j > 0 && j < image.getHeight()-1){
                    
                    argsRed = new int[6];
                    argsGreen = new int[6];
                    argsBlue = new int[6];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i+1][j-1];
                    argsRed[4] = red[i+1][j];
                    argsRed[5] = red[i+1][j+1];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i+1][j-1];
                    argsGreen[4] = green[i+1][j];
                    argsGreen[5] = green[i+1][j+1];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i+1][j-1];
                    argsBlue[4] = blue[i+1][j];
                    argsBlue[5] = blue[i+1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                   newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //prawa krawędź
                if (i == image.getWidth()-1 && j > 0 && j < image.getHeight()-1){
                    
                    argsRed = new int[6];
                    argsGreen = new int[6];
                    argsBlue = new int[6];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i-1][j-1];
                    argsRed[4] = red[i-1][j];
                    argsRed[5] = red[i-1][j+1];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i-1][j-1];
                    argsGreen[4] = green[i-1][j];
                    argsGreen[5] = green[i-1][j+1];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i-1][j-1];
                    argsBlue[4] = blue[i-1][j];
                    argsBlue[5] = blue[i-1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //górna krawędź
                if (i > 0 && i < image.getWidth()-1 && j == 0){
                    
                    argsRed = new int[6];
                    argsGreen = new int[6];
                    argsBlue = new int[6];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j+1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j+1];
                    argsRed[4] = red[i+1][j];
                    argsRed[5] = red[i+1][j+1];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j+1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j+1];
                    argsGreen[4] = green[i+1][j];
                    argsGreen[5] = green[i+1][j+1];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j+1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j+1];
                    argsBlue[4] = blue[i+1][j];
                    argsBlue[5] = blue[i+1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }                    

                                 
                }
                
                //dolna krawędź
                if (i > 0 && i < image.getWidth()-1 && j == image.getHeight()-1){
                
                    argsRed = new int[6];
                    argsGreen = new int[6];
                    argsBlue = new int[6];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j-1];
                    argsRed[4] = red[i+1][j];
                    argsRed[5] = red[i+1][j-1];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j-1];
                    argsGreen[4] = green[i+1][j];
                    argsGreen[5] = green[i+1][j-1];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j-1];
                    argsBlue[4] = blue[i+1][j];
                    argsBlue[5] = blue[i+1][j-1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                    
                }
                
                
                //Srodek Start
                if (i >= 1 && i < image.getWidth()-1 && j >= 1 && j < image.getHeight()-1) {
                    
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j-1];
                    argsRed[4] = red[i+1][j];
                    argsRed[5] = red[i+1][j-1];
                    argsRed[6] = red[i-1][j+1];
                    argsRed[7] = red[i][j+1];
                    argsRed[8] = red[i+1][j+1];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j-1];
                    argsGreen[4] = green[i+1][j];
                    argsGreen[5] = green[i+1][j-1];
                    argsGreen[6] = green[i-1][j+1];
                    argsGreen[7] = green[i][j+1];
                    argsGreen[8] = green[i+1][j+1];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j-1];
                    argsBlue[4] = blue[i+1][j];
                    argsBlue[5] = blue[i+1][j-1];
                    argsBlue[6] = blue[i-1][j+1];
                    argsBlue[7] = blue[i][j+1];
                    argsBlue[8] = blue[i+1][j+1];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                    
                
                   
                }
                  
                image.setRGB(i, j, new Color(newRed[i][j], newGreen[i][j], newBlue[i][j]).getRGB());
                
            }   
        }
        
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
    }
    

    
    
    
    
    
    
    
    
    
    
    
    public void statisticFunction5x5(BufferedImage image, JPanel picturePanel, String function) {
     Color colorOfPixel;
        
           // int alpha; 
            int red[][] = new int[image.getWidth()][image.getHeight()];
            int green[][] = new int[image.getWidth()][image.getHeight()];
            int blue[][] = new int[image.getWidth()][image.getHeight()];
            
            int newRed[][] = new int[image.getWidth()][image.getHeight()];
            int newGreen[][] = new int[image.getWidth()][image.getHeight()];
            int newBlue[][] = new int[image.getWidth()][image.getHeight()];
            
            
        
            for (int i = 0; i < image.getWidth(); i++) {
                 for (int j = 0; j < image.getHeight(); j++) {
                      colorOfPixel = new Color(image.getRGB(i,j));
                
                
                        red[i][j] = colorOfPixel.getRed();
                        green[i][j] = colorOfPixel.getGreen();
                        blue[i][j] = colorOfPixel.getBlue();
                   
                 }
            }
            int argsRed[];
            int argsGreen[];
            int argsBlue[];
            
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
               //lewy górny róg start
                if (i == 0 && j == 0) {
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i][j+2];
                    argsRed[3] = red[i+1][j];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j+2];
                    argsRed[6] = red[i+2][j];
                    argsRed[7] = red[i+2][j+1];
                    argsRed[8] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i][j+2];
                    argsGreen[3] = green[i+1][j];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j+2];
                    argsGreen[6] = green[i+2][j];
                    argsGreen[7] = green[i+2][j+1];
                    argsGreen[8] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i][j+2];
                    argsBlue[3] = blue[i+1][j];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j+2];
                    argsBlue[6] = blue[i+2][j];
                    argsBlue[7] = blue[i+2][j+1];
                    argsBlue[8] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //lewy dolny róg start
                if(i == 0 && j == image.getHeight()-1) {
                    
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j-2];
                    argsRed[3] = red[i+1][j];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j-2];
                    argsRed[6] = red[i+2][j];
                    argsRed[7] = red[i+2][j-1];
                    argsRed[8] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j-2];
                    argsGreen[3] = green[i+1][j];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j-2];
                    argsGreen[6] = green[i+2][j];
                    argsGreen[7] = green[i+2][j-1];
                    argsGreen[8] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j-2];
                    argsBlue[3] = blue[i+1][j];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j-2];
                    argsBlue[6] = blue[i+2][j];
                    argsBlue[7] = blue[i+2][j-1];
                    argsBlue[8] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                } 
                
                //prawy górny róg start
                if(i == image.getWidth()-1 && j == 0){
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i][j+2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j+2];
                    argsRed[6] = red[i-2][j];
                    argsRed[7] = red[i-2][j+1];
                    argsRed[8] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i][j+2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j+2];
                    argsGreen[6] = green[i-2][j];
                    argsGreen[7] = green[i-2][j+1];
                    argsGreen[8] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i][j+2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j+2];
                    argsBlue[6] = blue[i-2][j];
                    argsBlue[7] = blue[i-2][j+1];
                    argsBlue[8] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //prawy dolny róg start
                if(i == image.getWidth()-1 && j == image.getHeight()-1){
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j-2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-2][j];
                    argsRed[7] = red[i-2][j-1];
                    argsRed[8] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j-2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-2][j];
                    argsGreen[7] = green[i-2][j-1];
                    argsGreen[8] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j-2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-2][j];
                    argsBlue[7] = blue[i-2][j-1];
                    argsBlue[8] = blue[i-2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                   
                    
                }
                
                //lewa krawędź
                if (i == 0 && j > 1 && j < image.getHeight()-2){
                    
                    argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i][j-2];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j+1];
                    argsRed[4] = red[i][j+2];
                    argsRed[5] = red[i+1][j-2];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j+2];
                    argsRed[10] = red[i+2][j-2];
                    argsRed[11] = red[i+2][j-1];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j+1];
                    argsRed[14] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j-2];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j+1];
                    argsGreen[4] = green[i][j+2];
                    argsGreen[5] = green[i+1][j-2];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j+2];
                    argsGreen[10] = green[i+2][j-2];
                    argsGreen[11] = green[i+2][j-1];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j+1];
                    argsGreen[14] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j-2];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j+1];
                    argsBlue[4] = blue[i][j+2];
                    argsBlue[5] = blue[i+1][j-2];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j+2];
                    argsBlue[10] = blue[i+2][j-2];
                    argsBlue[11] = blue[i+2][j-1];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j+1];
                    argsBlue[14] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                   newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //prawa krawędź
                if (i == image.getWidth()-1 && j > 1 && j < image.getHeight()-2){
                    
                    argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i][j-2];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j+1];
                    argsRed[4] = red[i][j+2];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j];
                    argsRed[8] = red[i-1][j+1];
                    argsRed[9] = red[i-1][j+2];
                    argsRed[10] = red[i-2][j-2];
                    argsRed[11] = red[i-2][j-1];
                    argsRed[12] = red[i-2][j];
                    argsRed[13] = red[i-2][j+1];
                    argsRed[14] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j-2];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j+1];
                    argsGreen[4] = green[i][j+2];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j];
                    argsGreen[8] = green[i-1][j+1];
                    argsGreen[9] = green[i-1][j+2];
                    argsGreen[10] = green[i-2][j-2];
                    argsGreen[11] = green[i-2][j-1];
                    argsGreen[12] = green[i-2][j];
                    argsGreen[13] = green[i-2][j+1];
                    argsGreen[14] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j-2];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j+1];
                    argsBlue[4] = blue[i][j+2];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j];
                    argsBlue[8] = blue[i-1][j+1];
                    argsBlue[9] = blue[i-1][j+2];
                    argsBlue[10] = blue[i-2][j-2];
                    argsBlue[11] = blue[i-2][j-1];
                    argsBlue[12] = blue[i-2][j];
                    argsBlue[13] = blue[i-2][j+1];
                    argsBlue[14] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //górna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == 0){
                    
                     argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i-2][j];
                    argsRed[1] = red[i-2][j+1];
                    argsRed[2] = red[i-2][j+2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j+2];
                    argsRed[6] = red[i][j];
                    argsRed[7] = red[i][j+1];
                    argsRed[8] = red[i][j+2];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j+1];
                    argsRed[14] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-2][j];
                    argsGreen[1] = green[i-2][j+1];
                    argsGreen[2] = green[i-2][j+2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j+2];
                    argsGreen[6] = green[i][j];
                    argsGreen[7] = green[i][j+1];
                    argsGreen[8] = green[i][j+2];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j+1];
                    argsGreen[14] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-2][j];
                    argsBlue[1] = blue[i-2][j+1];
                    argsBlue[2] = blue[i-2][j+2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j+2];
                    argsBlue[6] = blue[i][j];
                    argsBlue[7] = blue[i][j+1];
                    argsBlue[8] = blue[i][j+2];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j+1];
                    argsBlue[14] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }                    

                                 
                }
                
                //dolna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == image.getHeight()-1){
                
                     argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i-2][j];
                    argsRed[1] = red[i-2][j-1];
                    argsRed[2] = red[i-2][j-2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i][j];
                    argsRed[7] = red[i][j-1];
                    argsRed[8] = red[i][j-2];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j-1];
                    argsRed[14] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-2][j];
                    argsGreen[1] = green[i-2][j-1];
                    argsGreen[2] = green[i-2][j-2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i][j];
                    argsGreen[7] = green[i][j-1];
                    argsGreen[8] = green[i][j-2];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j-1];
                    argsGreen[14] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-2][j];
                    argsBlue[1] = blue[i-2][j-1];
                    argsBlue[2] = blue[i-2][j-2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i][j];
                    argsBlue[7] = blue[i][j-1];
                    argsBlue[8] = blue[i][j-2];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j-1];
                    argsBlue[14] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                    
                }
                
                //lewy górny róg - 1 wysokość
                if (i == 0 && j == 1){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i][j+2];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j+1];
                    argsRed[7] = red[i+1][j+2];
                    argsRed[8] = red[i+2][j-1];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j+1];
                    argsRed[11] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i][j+2];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j+1];
                    argsGreen[7] = green[i+1][j+2];
                    argsGreen[8] = green[i+2][j-1];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j+1];
                    argsGreen[11] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i][j+2];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j+1];
                    argsBlue[7] = blue[i+1][j+2];
                    argsBlue[8] = blue[i+2][j-1];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j+1];
                    argsBlue[11] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy górny róg - 1 wysokość
                if (i == image.getWidth()-1 && j == 1){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i][j+2];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j];
                    argsRed[6] = red[i-1][j+1];
                    argsRed[7] = red[i-1][j+2];
                    argsRed[8] = red[i-2][j-1];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j+1];
                    argsRed[11] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i][j+2];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j];
                    argsGreen[6] = green[i-1][j+1];
                    argsGreen[7] = green[i-1][j+2];
                    argsGreen[8] = green[i-2][j-1];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j+1];
                    argsGreen[11] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i][j+2];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j];
                    argsBlue[6] = blue[i-1][j+1];
                    argsBlue[7] = blue[i-1][j+2];
                    argsBlue[8] = blue[i-2][j-1];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j+1];
                    argsBlue[11] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //lewy dolny róg + 1 wysokość
                if (i == 0 && j == image.getHeight()-2){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j+1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j-1];
                    argsRed[3] = red[i][j-2];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j-2];
                    argsRed[8] = red[i+2][j+1];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j-1];
                    argsRed[11] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i][j+1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j-1];
                    argsGreen[3] = green[i][j-2];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j-2];
                    argsGreen[8] = green[i+2][j+1];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j-1];
                    argsGreen[11] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i][j+1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j-1];
                    argsBlue[3] = blue[i][j-2];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j-2];
                    argsBlue[8] = blue[i+2][j+1];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j-1];
                    argsBlue[11] = blue[i+2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy dolny róg + 1 wysokość
                if (i == image.getWidth()-1 && j == image.getHeight()-2){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j+1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j-1];
                    argsRed[3] = red[i][j-2];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j-2];
                    argsRed[8] = red[i-2][j+1];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j-1];
                    argsRed[11] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i][j+1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j-1];
                    argsGreen[3] = green[i][j-2];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j-2];
                    argsGreen[8] = green[i-2][j+1];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j-1];
                    argsGreen[11] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i][j+1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j-1];
                    argsBlue[3] = blue[i][j-2];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j-2];
                    argsBlue[8] = blue[i-2][j+1];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j-1];
                    argsBlue[11] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //lewy górny róg + 1 szerokość
                    if (i == 1 && j == 0){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j+1];
                    argsRed[2] = red[i-1][j+2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j+2];
                    argsRed[6] = red[i+1][j];
                    argsRed[7] = red[i+1][j+1];
                    argsRed[8] = red[i+2][j+2];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j+1];
                    argsRed[11] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j+1];
                    argsGreen[2] = green[i-1][j+2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j+2];
                    argsGreen[6] = green[i+1][j];
                    argsGreen[7] = green[i+1][j+1];
                    argsGreen[8] = green[i+2][j+2];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j+1];
                    argsGreen[11] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j+1];
                    argsBlue[2] = blue[i-1][j+2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j+2];
                    argsBlue[6] = blue[i+1][j];
                    argsBlue[7] = blue[i+1][j+1];
                    argsBlue[8] = blue[i+2][j+2];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j+1];
                    argsBlue[11] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                 //lewy dolny róg + 1 szerokość
                 if (i == 1 && j == image.getHeight() - 1){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i-1][j-2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i+1][j];
                    argsRed[7] = red[i+1][j-1];
                    argsRed[8] = red[i+2][j-2];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j-1];
                    argsRed[11] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i-1][j-2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i+1][j];
                    argsGreen[7] = green[i+1][j-1];
                    argsGreen[8] = green[i+2][j-2];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j-1];
                    argsGreen[11] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i-1][j-2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i+1][j];
                    argsBlue[7] = blue[i+1][j-1];
                    argsBlue[8] = blue[i+2][j-2];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j-1];
                    argsBlue[11] = blue[i+2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                //prawy górny róg - 1 szerokość
                 if (i == image.getWidth()-2 && j == 0){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i+1][j];
                    argsRed[1] = red[i+1][j+1];
                    argsRed[2] = red[i+1][j+2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j+2];
                    argsRed[6] = red[i-1][j];
                    argsRed[7] = red[i-1][j+1];
                    argsRed[8] = red[i-2][j+2];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j+1];
                    argsRed[11] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+1][j];
                    argsGreen[1] = green[i+1][j+1];
                    argsGreen[2] = green[i+1][j+2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j+2];
                    argsGreen[6] = green[i-1][j];
                    argsGreen[7] = green[i-1][j+1];
                    argsGreen[8] = green[i-2][j+2];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j+1];
                    argsGreen[11] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+1][j];
                    argsBlue[1] = blue[i+1][j+1];
                    argsBlue[2] = blue[i+1][j+2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j+2];
                    argsBlue[6] = blue[i-1][j];
                    argsBlue[7] = blue[i-1][j+1];
                    argsBlue[8] = blue[i-2][j+2];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j+1];
                    argsBlue[11] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy dolny róg - 1 szerokość
                if (i == image.getWidth()-2 && j == image.getHeight()-1){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i+1][j];
                    argsRed[1] = red[i+1][j-1];
                    argsRed[2] = red[i+1][j-2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i-1][j];
                    argsRed[7] = red[i-1][j-1];
                    argsRed[8] = red[i-2][j-2];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j-1];
                    argsRed[11] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i+1][j];
                    argsGreen[1] = green[i+1][j-1];
                    argsGreen[2] = green[i+1][j-2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i-1][j];
                    argsGreen[7] = green[i-1][j-1];
                    argsGreen[8] = green[i-2][j-2];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j-1];
                    argsGreen[11] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i+1][j];
                    argsBlue[1] = blue[i+1][j-1];
                    argsBlue[2] = blue[i+1][j-2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i-1][j];
                    argsBlue[7] = blue[i-1][j-1];
                    argsBlue[8] = blue[i-2][j-2];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j-1];
                    argsBlue[11] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //lewa krawędź + 1 szerokość
                if (i == 1 && j >= 2 && j < image.getHeight()-2) {
                    argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i-1][j-2];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i-1][j];
                    argsRed[3] = red[i-1][j+1];
                    argsRed[4] = red[i-1][j+2];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j+2];
                    argsRed[10] = red[i+1][j-2];
                    argsRed[11] = red[i+1][j-1];
                    argsRed[12] = red[i+1][j];
                    argsRed[13] = red[i+1][j+1];
                    argsRed[14] = red[i+1][j+2];
                    argsRed[15] = red[i+2][j-2];
                    argsRed[16] = red[i+2][j-1];
                    argsRed[17] = red[i+2][j];
                    argsRed[18] = red[i+2][j+1];
                    argsRed[19] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j-2];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i-1][j];
                    argsGreen[3] = green[i-1][j+1];
                    argsGreen[4] = green[i-1][j+2];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j+2];
                    argsGreen[10] = green[i+1][j-2];
                    argsGreen[11] = green[i+1][j-1];
                    argsGreen[12] = green[i+1][j];
                    argsGreen[13] = green[i+1][j+1];
                    argsGreen[14] = green[i+1][j+2];
                    argsGreen[15] = green[i+2][j-2];
                    argsGreen[16] = green[i+2][j-1];
                    argsGreen[17] = green[i+2][j];
                    argsGreen[18] = green[i+2][j+1];
                    argsGreen[19] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-2];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i-1][j];
                    argsBlue[3] = blue[i-1][j+1];
                    argsBlue[4] = blue[i-1][j+2];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j+2];
                    argsBlue[10] = blue[i+1][j-2];
                    argsBlue[11] = blue[i+1][j-1];
                    argsBlue[12] = blue[i+1][j];
                    argsBlue[13] = blue[i+1][j+1];
                    argsBlue[14] = blue[i+1][j+2];
                    argsBlue[15] = blue[i+2][j-2];
                    argsBlue[16] = blue[i+2][j-1];
                    argsBlue[17] = blue[i+2][j];
                    argsBlue[18] = blue[i+2][j+1];
                    argsBlue[19] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //prawa krawędź - 1 szerokośc
                if (i == image.getWidth()-2 && j >= 2 && j < image.getHeight()-2) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+1][j-2];
                    argsRed[1] = red[i+1][j-1];
                    argsRed[2] = red[i+1][j];
                    argsRed[3] = red[i+1][j+1];
                    argsRed[4] = red[i+1][j+2];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j+2];
                    argsRed[10] = red[i-1][j-2];
                    argsRed[11] = red[i-1][j-1];
                    argsRed[12] = red[i-1][j];
                    argsRed[13] = red[i-1][j+1];
                    argsRed[14] = red[i-1][j+2];
                    argsRed[15] = red[i-2][j-2];
                    argsRed[16] = red[i-2][j-1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j+1];
                    argsRed[19] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+1][j-2];
                    argsGreen[1] = green[i+1][j-1];
                    argsGreen[2] = green[i+1][j];
                    argsGreen[3] = green[i+1][j+1];
                    argsGreen[4] = green[i+1][j+2];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j+2];
                    argsGreen[10] = green[i-1][j-2];
                    argsGreen[11] = green[i-1][j-1];
                    argsGreen[12] = green[i-1][j];
                    argsGreen[13] = green[i-1][j+1];
                    argsGreen[14] = green[i-1][j+2];
                    argsGreen[15] = green[i-2][j-2];
                    argsGreen[16] = green[i-2][j-1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j+1];
                    argsGreen[19] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+1][j-2];
                    argsBlue[1] = blue[i+1][j-1];
                    argsBlue[2] = blue[i+1][j];
                    argsBlue[3] = blue[i+1][j+1];
                    argsBlue[4] = blue[i+1][j+2];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j+2];
                    argsBlue[10] = blue[i-1][j-2];
                    argsBlue[11] = blue[i-1][j-1];
                    argsBlue[12] = blue[i-1][j];
                    argsBlue[13] = blue[i-1][j+1];
                    argsBlue[14] = blue[i-1][j+2];
                    argsBlue[15] = blue[i-2][j-2];
                    argsBlue[16] = blue[i-2][j-1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j+1];
                    argsBlue[19] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //górna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == 1) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+2][j-1];
                    argsRed[1] = red[i+2][j];
                    argsRed[2] = red[i+2][j+1];
                    argsRed[3] = red[i+2][j+2];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j+1];
                    argsRed[7] = red[i+1][j+2];
                    argsRed[8] = red[i][j-1];
                    argsRed[9] = red[i][j];
                    argsRed[10] = red[i][j+1];
                    argsRed[11] = red[i][j+2];
                    argsRed[12] = red[i-1][j-1];
                    argsRed[13] = red[i-1][j];
                    argsRed[14] = red[i-1][j+1];
                    argsRed[15] = red[i-1][j+2];
                    argsRed[16] = red[i-2][j-1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j+1];
                    argsRed[19] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+2][j-1];
                    argsGreen[1] = green[i+2][j];
                    argsGreen[2] = green[i+2][j+1];
                    argsGreen[3] = green[i+2][j+2];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j+1];
                    argsGreen[7] = green[i+1][j+2];
                    argsGreen[8] = green[i][j-1];
                    argsGreen[9] = green[i][j];
                    argsGreen[10] = green[i][j+1];
                    argsGreen[11] = green[i][j+2];
                    argsGreen[12] = green[i-1][j-1];
                    argsGreen[13] = green[i-1][j];
                    argsGreen[14] = green[i-1][j+1];
                    argsGreen[15] = green[i-1][j+2];
                    argsGreen[16] = green[i-2][j-1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j+1];
                    argsGreen[19] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+2][j-1];
                    argsBlue[1] = blue[i+2][j];
                    argsBlue[2] = blue[i+2][j+1];
                    argsBlue[3] = blue[i+2][j+2];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j+1];
                    argsBlue[7] = blue[i+1][j+2];
                    argsBlue[8] = blue[i][j-1];
                    argsBlue[9] = blue[i][j];
                    argsBlue[10] = blue[i][j+1];
                    argsBlue[11] = blue[i][j+2];
                    argsBlue[12] = blue[i-1][j-1];
                    argsBlue[13] = blue[i-1][j];
                    argsBlue[14] = blue[i-1][j+1];
                    argsBlue[15] = blue[i-1][j+2];
                    argsBlue[16] = blue[i-2][j-1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j+1];
                    argsBlue[19] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //dolna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == image.getHeight()-2) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+2][j+1];
                    argsRed[1] = red[i+2][j];
                    argsRed[2] = red[i+2][j-1];
                    argsRed[3] = red[i+2][j-2];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j-2];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j];
                    argsRed[10] = red[i][j-1];
                    argsRed[11] = red[i][j-2];
                    argsRed[12] = red[i-1][j+1];
                    argsRed[13] = red[i-1][j];
                    argsRed[14] = red[i-1][j-1];
                    argsRed[15] = red[i-1][j-2];
                    argsRed[16] = red[i-2][j+1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j-1];
                    argsRed[19] = red[i-2][j-2];
                    
                   argsGreen[0] = green[i+2][j+1];
                    argsGreen[1] = green[i+2][j];
                    argsGreen[2] = green[i+2][j-1];
                    argsGreen[3] = green[i+2][j-2];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j-2];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j];
                    argsGreen[10] = green[i][j-1];
                    argsGreen[11] = green[i][j-2];
                    argsGreen[12] = green[i-1][j+1];
                    argsGreen[13] = green[i-1][j];
                    argsGreen[14] = green[i-1][j-1];
                    argsGreen[15] = green[i-1][j-2];
                    argsGreen[16] = green[i-2][j+1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j-1];
                    argsGreen[19] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i+2][j+1];
                    argsBlue[1] = blue[i+2][j];
                    argsBlue[2] = blue[i+2][j-1];
                    argsBlue[3] = blue[i+2][j-2];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j-2];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j];
                    argsBlue[10] = blue[i][j-1];
                    argsBlue[11] = blue[i][j-2];
                    argsBlue[12] = blue[i-1][j+1];
                    argsBlue[13] = blue[i-1][j];
                    argsBlue[14] = blue[i-1][j-1];
                    argsBlue[15] = blue[i-1][j-2];
                    argsBlue[16] = blue[i-2][j+1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j-1];
                    argsBlue[19] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                
                //lewy górny róg -1 -1
                if (i == 1 && j == 1) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j-1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j+1];
                    argsRed[3] = red[i-1][j+2];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j+1];
                    argsRed[7] = red[i][j+2];
                    argsRed[8] = red[i+1][j-1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i+2][j-1];
                    argsRed[13] = red[i+2][j];
                    argsRed[14] = red[i+2][j+1];
                    argsRed[15] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j-1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j+1];
                    argsGreen[3] = green[i-1][j+2];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j+1];
                    argsGreen[7] = green[i][j+2];
                    argsGreen[8] = green[i+1][j-1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i+2][j-1];
                    argsGreen[13] = green[i+2][j];
                    argsGreen[14] = green[i+2][j+1];
                    argsGreen[15] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j+1];
                    argsBlue[3] = blue[i-1][j+2];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j+1];
                    argsBlue[7] = blue[i][j+2];
                    argsBlue[8] = blue[i+1][j-1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i+2][j-1];
                    argsBlue[13] = blue[i+2][j];
                    argsBlue[14] = blue[i+2][j+1];
                    argsBlue[15] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //prawy górny róg -1 -1
                if (i == image.getWidth() - 2 && j == 1) {
                    
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j-1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j+1];
                    argsRed[3] = red[i-1][j+2];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j+1];
                    argsRed[7] = red[i][j+2];
                    argsRed[8] = red[i+1][j-1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i-2][j-1];
                    argsRed[13] = red[i-2][j];
                    argsRed[14] = red[i-2][j+1];
                    argsRed[15] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i-1][j-1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j+1];
                    argsGreen[3] = green[i-1][j+2];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j+1];
                    argsGreen[7] = green[i][j+2];
                    argsGreen[8] = green[i+1][j-1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i-2][j-1];
                    argsGreen[13] = green[i-2][j];
                    argsGreen[14] = green[i-2][j+1];
                    argsGreen[15] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j+1];
                    argsBlue[3] = blue[i-1][j+2];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j+1];
                    argsBlue[7] = blue[i][j+2];
                    argsBlue[8] = blue[i+1][j-1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i-2][j-1];
                    argsBlue[13] = blue[i-2][j];
                    argsBlue[14] = blue[i-2][j+1];
                    argsBlue[15] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                } 
                
                //prawy dolny róg -1 -1
                if (i == image.getWidth()-2 && j == image.getHeight()-2) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j+1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j-1];
                    argsRed[3] = red[i-1][j-2];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j-2];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i-2][j+1];
                    argsRed[13] = red[i-2][j];
                    argsRed[14] = red[i-2][j-1];
                    argsRed[15] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i-1][j+1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j-1];
                    argsGreen[3] = green[i-1][j-2];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j-2];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i-2][j+1];
                    argsGreen[13] = green[i-2][j];
                    argsGreen[14] = green[i-2][j-1];
                    argsGreen[15] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i-1][j+1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j-1];
                    argsBlue[3] = blue[i-1][j-2];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j-2];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i-2][j+1];
                    argsBlue[13] = blue[i-2][j];
                    argsBlue[14] = blue[i-2][j-1];
                    argsBlue[15] = blue[i-2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //lewy dolny róg -1 -1
                if (i == 1 && j == image.getHeight()-2) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j+1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j-1];
                    argsRed[3] = red[i-1][j-2];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j-2];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i+2][j+1];
                    argsRed[13] = red[i+2][j];
                    argsRed[14] = red[i+2][j-1];
                    argsRed[15] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-1][j+1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j-1];
                    argsGreen[3] = green[i-1][j-2];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j-2];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i+2][j+1];
                    argsGreen[13] = green[i+2][j];
                    argsGreen[14] = green[i+2][j-1];
                    argsGreen[15] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-1][j+1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j-1];
                    argsBlue[3] = blue[i-1][j-2];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j-2];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i+2][j+1];
                    argsBlue[13] = blue[i+2][j];
                    argsBlue[14] = blue[i+2][j-1];
                    argsBlue[15] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                   
                    
                }
                
                
                
                //Srodek Start
                if (i >= 2 && i < image.getWidth()-2 && j >= 2 && j < image.getHeight()-2) {
                    
                    argsRed = new int[25];
                    argsGreen = new int[25];
                    argsBlue = new int[25];
                    
                    argsRed[0] = red[i-2][j-2];
                    argsRed[1] = red[i-2][j-1];
                    argsRed[2] = red[i-2][j];
                    argsRed[3] = red[i-2][j+1];
                    argsRed[4] = red[i-2][j+2];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j];
                    argsRed[8] = red[i-1][j+1];
                    argsRed[9] = red[i-1][j+2];
                    argsRed[10] = red[i][j-2];
                    argsRed[11] = red[i][j-2];
                    argsRed[12] = red[i][j];
                    argsRed[13] = red[i][j+1];
                    argsRed[14] = red[i][j+2];
                    argsRed[15] = red[i+1][j-2];
                    argsRed[16] = red[i+1][j-1];
                    argsRed[17] = red[i+1][j];
                    argsRed[18] = red[i+1][j+1];
                    argsRed[19] = red[i+1][j+2];
                    argsRed[20] = red[i+2][j-2];
                    argsRed[21] = red[i+2][j-1];
                    argsRed[22] = red[i+2][j];
                    argsRed[23] = red[i+2][j+1];
                    argsRed[24] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-2][j-2];
                    argsGreen[1] = green[i-2][j-1];
                    argsGreen[2] = green[i-2][j];
                    argsGreen[3] = green[i-2][j+1];
                    argsGreen[4] = green[i-2][j+2];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j];
                    argsGreen[8] = green[i-1][j+1];
                    argsGreen[9] = green[i-1][j+2];
                    argsGreen[10] = green[i][j-2];
                    argsGreen[11] = green[i][j-2];
                    argsGreen[12] = green[i][j];
                    argsGreen[13] = green[i][j+1];
                    argsGreen[14] = green[i][j+2];
                    argsGreen[15] = green[i+1][j-2];
                    argsGreen[16] = green[i+1][j-1];
                    argsGreen[17] = green[i+1][j];
                    argsGreen[18] = green[i+1][j+1];
                    argsGreen[19] = green[i+1][j+2];
                    argsGreen[20] = green[i+2][j-2];
                    argsGreen[21] = green[i+2][j-1];
                    argsGreen[22] = green[i+2][j];
                    argsGreen[23] = green[i+2][j+1];
                    argsGreen[24] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-2][j-2];
                    argsBlue[1] = blue[i-2][j-1];
                    argsBlue[2] = blue[i-2][j];
                    argsBlue[3] = blue[i-2][j+1];
                    argsBlue[4] = blue[i-2][j+2];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j];
                    argsBlue[8] = blue[i-1][j+1];
                    argsBlue[9] = blue[i-1][j+2];
                    argsBlue[10] = blue[i][j-2];
                    argsBlue[11] = blue[i][j-2];
                    argsBlue[12] = blue[i][j];
                    argsBlue[13] = blue[i][j+1];
                    argsBlue[14] = blue[i][j+2];
                    argsBlue[15] = blue[i+1][j-2];
                    argsBlue[16] = blue[i+1][j-1];
                    argsBlue[17] = blue[i+1][j];
                    argsBlue[18] = blue[i+1][j+1];
                    argsBlue[19] = blue[i+1][j+2];
                    argsBlue[20] = blue[i+2][j-2];
                    argsBlue[21] = blue[i+2][j-1];
                    argsBlue[22] = blue[i+2][j];
                    argsBlue[23] = blue[i+2][j+1];
                    argsBlue[24] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                    
                
                   
                }
                  
                image.setRGB(i, j, new Color(newRed[i][j], newGreen[i][j], newBlue[i][j]).getRGB());
                
            }   
        }
        
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void statisticFunction7x7(BufferedImage image, JPanel picturePanel, String function) {
       Color colorOfPixel;
        
           // int alpha; 
            int red[][] = new int[image.getWidth()][image.getHeight()];
            int green[][] = new int[image.getWidth()][image.getHeight()];
            int blue[][] = new int[image.getWidth()][image.getHeight()];
            
            int newRed[][] = new int[image.getWidth()][image.getHeight()];
            int newGreen[][] = new int[image.getWidth()][image.getHeight()];
            int newBlue[][] = new int[image.getWidth()][image.getHeight()];
            
            
        
            for (int i = 0; i < image.getWidth(); i++) {
                 for (int j = 0; j < image.getHeight(); j++) {
                      colorOfPixel = new Color(image.getRGB(i,j));
                
                
                        red[i][j] = colorOfPixel.getRed();
                        green[i][j] = colorOfPixel.getGreen();
                        blue[i][j] = colorOfPixel.getBlue();
                   
                 }
            }
            int argsRed[];
            int argsGreen[];
            int argsBlue[];
            
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
               //lewy górny róg start
                if (i == 0 && j == 0) {
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i][j+2];
                    argsRed[3] = red[i+1][j];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j+2];
                    argsRed[6] = red[i+2][j];
                    argsRed[7] = red[i+2][j+1];
                    argsRed[8] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i][j+2];
                    argsGreen[3] = green[i+1][j];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j+2];
                    argsGreen[6] = green[i+2][j];
                    argsGreen[7] = green[i+2][j+1];
                    argsGreen[8] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i][j+2];
                    argsBlue[3] = blue[i+1][j];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j+2];
                    argsBlue[6] = blue[i+2][j];
                    argsBlue[7] = blue[i+2][j+1];
                    argsBlue[8] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //lewy dolny róg start
                if(i == 0 && j == image.getHeight()-1) {
                    
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j-2];
                    argsRed[3] = red[i+1][j];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j-2];
                    argsRed[6] = red[i+2][j];
                    argsRed[7] = red[i+2][j-1];
                    argsRed[8] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j-2];
                    argsGreen[3] = green[i+1][j];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j-2];
                    argsGreen[6] = green[i+2][j];
                    argsGreen[7] = green[i+2][j-1];
                    argsGreen[8] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j-2];
                    argsBlue[3] = blue[i+1][j];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j-2];
                    argsBlue[6] = blue[i+2][j];
                    argsBlue[7] = blue[i+2][j-1];
                    argsBlue[8] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                } 
                
                //prawy górny róg start
                if(i == image.getWidth()-1 && j == 0){
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j+1];
                    argsRed[2] = red[i][j+2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j+2];
                    argsRed[6] = red[i-2][j];
                    argsRed[7] = red[i-2][j+1];
                    argsRed[8] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j+1];
                    argsGreen[2] = green[i][j+2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j+2];
                    argsGreen[6] = green[i-2][j];
                    argsGreen[7] = green[i-2][j+1];
                    argsGreen[8] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j+1];
                    argsBlue[2] = blue[i][j+2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j+2];
                    argsBlue[6] = blue[i-2][j];
                    argsBlue[7] = blue[i-2][j+1];
                    argsBlue[8] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //prawy dolny róg start
                if(i == image.getWidth()-1 && j == image.getHeight()-1){
                    argsRed = new int[9];
                    argsGreen = new int[9];
                    argsBlue = new int[9];
                   
                    argsRed[0] = red[i][j];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j-2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-2][j];
                    argsRed[7] = red[i-2][j-1];
                    argsRed[8] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i][j];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j-2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-2][j];
                    argsGreen[7] = green[i-2][j-1];
                    argsGreen[8] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i][j];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j-2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-2][j];
                    argsBlue[7] = blue[i-2][j-1];
                    argsBlue[8] = blue[i-2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                   
                    
                }
                
                //lewa krawędź
                if (i == 0 && j > 1 && j < image.getHeight()-2){
                    
                    argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i][j-2];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j+1];
                    argsRed[4] = red[i][j+2];
                    argsRed[5] = red[i+1][j-2];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j+2];
                    argsRed[10] = red[i+2][j-2];
                    argsRed[11] = red[i+2][j-1];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j+1];
                    argsRed[14] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j-2];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j+1];
                    argsGreen[4] = green[i][j+2];
                    argsGreen[5] = green[i+1][j-2];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j+2];
                    argsGreen[10] = green[i+2][j-2];
                    argsGreen[11] = green[i+2][j-1];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j+1];
                    argsGreen[14] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j-2];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j+1];
                    argsBlue[4] = blue[i][j+2];
                    argsBlue[5] = blue[i+1][j-2];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j+2];
                    argsBlue[10] = blue[i+2][j-2];
                    argsBlue[11] = blue[i+2][j-1];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j+1];
                    argsBlue[14] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                   newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //prawa krawędź
                if (i == image.getWidth()-1 && j > 1 && j < image.getHeight()-2){
                    
                    argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i][j-2];
                    argsRed[1] = red[i][j-1];
                    argsRed[2] = red[i][j];
                    argsRed[3] = red[i][j+1];
                    argsRed[4] = red[i][j+2];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j];
                    argsRed[8] = red[i-1][j+1];
                    argsRed[9] = red[i-1][j+2];
                    argsRed[10] = red[i-2][j-2];
                    argsRed[11] = red[i-2][j-1];
                    argsRed[12] = red[i-2][j];
                    argsRed[13] = red[i-2][j+1];
                    argsRed[14] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j-2];
                    argsGreen[1] = green[i][j-1];
                    argsGreen[2] = green[i][j];
                    argsGreen[3] = green[i][j+1];
                    argsGreen[4] = green[i][j+2];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j];
                    argsGreen[8] = green[i-1][j+1];
                    argsGreen[9] = green[i-1][j+2];
                    argsGreen[10] = green[i-2][j-2];
                    argsGreen[11] = green[i-2][j-1];
                    argsGreen[12] = green[i-2][j];
                    argsGreen[13] = green[i-2][j+1];
                    argsGreen[14] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j-2];
                    argsBlue[1] = blue[i][j-1];
                    argsBlue[2] = blue[i][j];
                    argsBlue[3] = blue[i][j+1];
                    argsBlue[4] = blue[i][j+2];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j];
                    argsBlue[8] = blue[i-1][j+1];
                    argsBlue[9] = blue[i-1][j+2];
                    argsBlue[10] = blue[i-2][j-2];
                    argsBlue[11] = blue[i-2][j-1];
                    argsBlue[12] = blue[i-2][j];
                    argsBlue[13] = blue[i-2][j+1];
                    argsBlue[14] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //górna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == 0){
                    
                     argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i-2][j];
                    argsRed[1] = red[i-2][j+1];
                    argsRed[2] = red[i-2][j+2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j+2];
                    argsRed[6] = red[i][j];
                    argsRed[7] = red[i][j+1];
                    argsRed[8] = red[i][j+2];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j+1];
                    argsRed[14] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-2][j];
                    argsGreen[1] = green[i-2][j+1];
                    argsGreen[2] = green[i-2][j+2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j+2];
                    argsGreen[6] = green[i][j];
                    argsGreen[7] = green[i][j+1];
                    argsGreen[8] = green[i][j+2];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j+1];
                    argsGreen[14] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-2][j];
                    argsBlue[1] = blue[i-2][j+1];
                    argsBlue[2] = blue[i-2][j+2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j+2];
                    argsBlue[6] = blue[i][j];
                    argsBlue[7] = blue[i][j+1];
                    argsBlue[8] = blue[i][j+2];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j+1];
                    argsBlue[14] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }                    

                                 
                }
                
                //dolna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == image.getHeight()-1){
                
                     argsRed = new int[15];
                    argsGreen = new int[15];
                    argsBlue = new int[15];
                    
                    argsRed[0] = red[i-2][j];
                    argsRed[1] = red[i-2][j-1];
                    argsRed[2] = red[i-2][j-2];
                    argsRed[3] = red[i-1][j];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i][j];
                    argsRed[7] = red[i][j-1];
                    argsRed[8] = red[i][j-2];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i+2][j];
                    argsRed[13] = red[i+2][j-1];
                    argsRed[14] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-2][j];
                    argsGreen[1] = green[i-2][j-1];
                    argsGreen[2] = green[i-2][j-2];
                    argsGreen[3] = green[i-1][j];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i][j];
                    argsGreen[7] = green[i][j-1];
                    argsGreen[8] = green[i][j-2];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i+2][j];
                    argsGreen[13] = green[i+2][j-1];
                    argsGreen[14] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-2][j];
                    argsBlue[1] = blue[i-2][j-1];
                    argsBlue[2] = blue[i-2][j-2];
                    argsBlue[3] = blue[i-1][j];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i][j];
                    argsBlue[7] = blue[i][j-1];
                    argsBlue[8] = blue[i][j-2];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i+2][j];
                    argsBlue[13] = blue[i+2][j-1];
                    argsBlue[14] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                    
                }
                
                //lewy górny róg - 1 wysokość
                if (i == 0 && j == 1){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i][j+2];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j+1];
                    argsRed[7] = red[i+1][j+2];
                    argsRed[8] = red[i+2][j-1];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j+1];
                    argsRed[11] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i][j+2];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j+1];
                    argsGreen[7] = green[i+1][j+2];
                    argsGreen[8] = green[i+2][j-1];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j+1];
                    argsGreen[11] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i][j+2];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j+1];
                    argsBlue[7] = blue[i+1][j+2];
                    argsBlue[8] = blue[i+2][j-1];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j+1];
                    argsBlue[11] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy górny róg - 1 wysokość
                if (i == image.getWidth()-1 && j == 1){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j-1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j+1];
                    argsRed[3] = red[i][j+2];
                    argsRed[4] = red[i-1][j-1];
                    argsRed[5] = red[i-1][j];
                    argsRed[6] = red[i-1][j+1];
                    argsRed[7] = red[i-1][j+2];
                    argsRed[8] = red[i-2][j-1];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j+1];
                    argsRed[11] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i][j-1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j+1];
                    argsGreen[3] = green[i][j+2];
                    argsGreen[4] = green[i-1][j-1];
                    argsGreen[5] = green[i-1][j];
                    argsGreen[6] = green[i-1][j+1];
                    argsGreen[7] = green[i-1][j+2];
                    argsGreen[8] = green[i-2][j-1];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j+1];
                    argsGreen[11] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i][j-1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j+1];
                    argsBlue[3] = blue[i][j+2];
                    argsBlue[4] = blue[i-1][j-1];
                    argsBlue[5] = blue[i-1][j];
                    argsBlue[6] = blue[i-1][j+1];
                    argsBlue[7] = blue[i-1][j+2];
                    argsBlue[8] = blue[i-2][j-1];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j+1];
                    argsBlue[11] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //lewy dolny róg + 1 wysokość
                if (i == 0 && j == image.getHeight()-2){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j+1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j-1];
                    argsRed[3] = red[i][j-2];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j-2];
                    argsRed[8] = red[i+2][j+1];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j-1];
                    argsRed[11] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i][j+1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j-1];
                    argsGreen[3] = green[i][j-2];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j-2];
                    argsGreen[8] = green[i+2][j+1];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j-1];
                    argsGreen[11] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i][j+1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j-1];
                    argsBlue[3] = blue[i][j-2];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j-2];
                    argsBlue[8] = blue[i+2][j+1];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j-1];
                    argsBlue[11] = blue[i+2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy dolny róg + 1 wysokość
                if (i == image.getWidth()-1 && j == image.getHeight()-2){
                 
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i][j+1];
                    argsRed[1] = red[i][j];
                    argsRed[2] = red[i][j-1];
                    argsRed[3] = red[i][j-2];
                    argsRed[4] = red[i-1][j+1];
                    argsRed[5] = red[i-1][j];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j-2];
                    argsRed[8] = red[i-2][j+1];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j-1];
                    argsRed[11] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i][j+1];
                    argsGreen[1] = green[i][j];
                    argsGreen[2] = green[i][j-1];
                    argsGreen[3] = green[i][j-2];
                    argsGreen[4] = green[i-1][j+1];
                    argsGreen[5] = green[i-1][j];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j-2];
                    argsGreen[8] = green[i-2][j+1];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j-1];
                    argsGreen[11] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i][j+1];
                    argsBlue[1] = blue[i][j];
                    argsBlue[2] = blue[i][j-1];
                    argsBlue[3] = blue[i][j-2];
                    argsBlue[4] = blue[i-1][j+1];
                    argsBlue[5] = blue[i-1][j];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j-2];
                    argsBlue[8] = blue[i-2][j+1];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j-1];
                    argsBlue[11] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //lewy górny róg + 1 szerokość
                    if (i == 1 && j == 0){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j+1];
                    argsRed[2] = red[i-1][j+2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j+2];
                    argsRed[6] = red[i+1][j];
                    argsRed[7] = red[i+1][j+1];
                    argsRed[8] = red[i+2][j+2];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j+1];
                    argsRed[11] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j+1];
                    argsGreen[2] = green[i-1][j+2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j+2];
                    argsGreen[6] = green[i+1][j];
                    argsGreen[7] = green[i+1][j+1];
                    argsGreen[8] = green[i+2][j+2];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j+1];
                    argsGreen[11] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j+1];
                    argsBlue[2] = blue[i-1][j+2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j+2];
                    argsBlue[6] = blue[i+1][j];
                    argsBlue[7] = blue[i+1][j+1];
                    argsBlue[8] = blue[i+2][j+2];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j+1];
                    argsBlue[11] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                 //lewy dolny róg + 1 szerokość
                 if (i == 1 && j == image.getHeight() - 1){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i-1][j];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i-1][j-2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i+1][j];
                    argsRed[7] = red[i+1][j-1];
                    argsRed[8] = red[i+2][j-2];
                    argsRed[9] = red[i+2][j];
                    argsRed[10] = red[i+2][j-1];
                    argsRed[11] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-1][j];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i-1][j-2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i+1][j];
                    argsGreen[7] = green[i+1][j-1];
                    argsGreen[8] = green[i+2][j-2];
                    argsGreen[9] = green[i+2][j];
                    argsGreen[10] = green[i+2][j-1];
                    argsGreen[11] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-1][j];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i-1][j-2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i+1][j];
                    argsBlue[7] = blue[i+1][j-1];
                    argsBlue[8] = blue[i+2][j-2];
                    argsBlue[9] = blue[i+2][j];
                    argsBlue[10] = blue[i+2][j-1];
                    argsBlue[11] = blue[i+2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                //prawy górny róg - 1 szerokość
                 if (i == image.getWidth()-2 && j == 0){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i+1][j];
                    argsRed[1] = red[i+1][j+1];
                    argsRed[2] = red[i+1][j+2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j+2];
                    argsRed[6] = red[i-1][j];
                    argsRed[7] = red[i-1][j+1];
                    argsRed[8] = red[i-2][j+2];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j+1];
                    argsRed[11] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+1][j];
                    argsGreen[1] = green[i+1][j+1];
                    argsGreen[2] = green[i+1][j+2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j+2];
                    argsGreen[6] = green[i-1][j];
                    argsGreen[7] = green[i-1][j+1];
                    argsGreen[8] = green[i-2][j+2];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j+1];
                    argsGreen[11] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+1][j];
                    argsBlue[1] = blue[i+1][j+1];
                    argsBlue[2] = blue[i+1][j+2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j+2];
                    argsBlue[6] = blue[i-1][j];
                    argsBlue[7] = blue[i-1][j+1];
                    argsBlue[8] = blue[i-2][j+2];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j+1];
                    argsBlue[11] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                //prawy dolny róg - 1 szerokość
                if (i == image.getWidth()-2 && j == image.getHeight()-1){
                    argsRed = new int[12];
                    argsGreen = new int[12];
                    argsBlue = new int[12];
                    
                    argsRed[0] = red[i+1][j];
                    argsRed[1] = red[i+1][j-1];
                    argsRed[2] = red[i+1][j-2];
                    argsRed[3] = red[i][j];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i-1][j];
                    argsRed[7] = red[i-1][j-1];
                    argsRed[8] = red[i-2][j-2];
                    argsRed[9] = red[i-2][j];
                    argsRed[10] = red[i-2][j-1];
                    argsRed[11] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i+1][j];
                    argsGreen[1] = green[i+1][j-1];
                    argsGreen[2] = green[i+1][j-2];
                    argsGreen[3] = green[i][j];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i-1][j];
                    argsGreen[7] = green[i-1][j-1];
                    argsGreen[8] = green[i-2][j-2];
                    argsGreen[9] = green[i-2][j];
                    argsGreen[10] = green[i-2][j-1];
                    argsGreen[11] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i+1][j];
                    argsBlue[1] = blue[i+1][j-1];
                    argsBlue[2] = blue[i+1][j-2];
                    argsBlue[3] = blue[i][j];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i-1][j];
                    argsBlue[7] = blue[i-1][j-1];
                    argsBlue[8] = blue[i-2][j-2];
                    argsBlue[9] = blue[i-2][j];
                    argsBlue[10] = blue[i-2][j-1];
                    argsBlue[11] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //lewa krawędź + 1 szerokość
                if (i == 1 && j >= 2 && j < image.getHeight()-2) {
                    argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i-1][j-2];
                    argsRed[1] = red[i-1][j-1];
                    argsRed[2] = red[i-1][j];
                    argsRed[3] = red[i-1][j+1];
                    argsRed[4] = red[i-1][j+2];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j+2];
                    argsRed[10] = red[i+1][j-2];
                    argsRed[11] = red[i+1][j-1];
                    argsRed[12] = red[i+1][j];
                    argsRed[13] = red[i+1][j+1];
                    argsRed[14] = red[i+1][j+2];
                    argsRed[15] = red[i+2][j-2];
                    argsRed[16] = red[i+2][j-1];
                    argsRed[17] = red[i+2][j];
                    argsRed[18] = red[i+2][j+1];
                    argsRed[19] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j-2];
                    argsGreen[1] = green[i-1][j-1];
                    argsGreen[2] = green[i-1][j];
                    argsGreen[3] = green[i-1][j+1];
                    argsGreen[4] = green[i-1][j+2];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j+2];
                    argsGreen[10] = green[i+1][j-2];
                    argsGreen[11] = green[i+1][j-1];
                    argsGreen[12] = green[i+1][j];
                    argsGreen[13] = green[i+1][j+1];
                    argsGreen[14] = green[i+1][j+2];
                    argsGreen[15] = green[i+2][j-2];
                    argsGreen[16] = green[i+2][j-1];
                    argsGreen[17] = green[i+2][j];
                    argsGreen[18] = green[i+2][j+1];
                    argsGreen[19] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-2];
                    argsBlue[1] = blue[i-1][j-1];
                    argsBlue[2] = blue[i-1][j];
                    argsBlue[3] = blue[i-1][j+1];
                    argsBlue[4] = blue[i-1][j+2];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j+2];
                    argsBlue[10] = blue[i+1][j-2];
                    argsBlue[11] = blue[i+1][j-1];
                    argsBlue[12] = blue[i+1][j];
                    argsBlue[13] = blue[i+1][j+1];
                    argsBlue[14] = blue[i+1][j+2];
                    argsBlue[15] = blue[i+2][j-2];
                    argsBlue[16] = blue[i+2][j-1];
                    argsBlue[17] = blue[i+2][j];
                    argsBlue[18] = blue[i+2][j+1];
                    argsBlue[19] = blue[i+2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //prawa krawędź - 1 szerokośc
                if (i == image.getWidth()-2 && j >= 2 && j < image.getHeight()-2) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+1][j-2];
                    argsRed[1] = red[i+1][j-1];
                    argsRed[2] = red[i+1][j];
                    argsRed[3] = red[i+1][j+1];
                    argsRed[4] = red[i+1][j+2];
                    argsRed[5] = red[i][j-2];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j+2];
                    argsRed[10] = red[i-1][j-2];
                    argsRed[11] = red[i-1][j-1];
                    argsRed[12] = red[i-1][j];
                    argsRed[13] = red[i-1][j+1];
                    argsRed[14] = red[i-1][j+2];
                    argsRed[15] = red[i-2][j-2];
                    argsRed[16] = red[i-2][j-1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j+1];
                    argsRed[19] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+1][j-2];
                    argsGreen[1] = green[i+1][j-1];
                    argsGreen[2] = green[i+1][j];
                    argsGreen[3] = green[i+1][j+1];
                    argsGreen[4] = green[i+1][j+2];
                    argsGreen[5] = green[i][j-2];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j+2];
                    argsGreen[10] = green[i-1][j-2];
                    argsGreen[11] = green[i-1][j-1];
                    argsGreen[12] = green[i-1][j];
                    argsGreen[13] = green[i-1][j+1];
                    argsGreen[14] = green[i-1][j+2];
                    argsGreen[15] = green[i-2][j-2];
                    argsGreen[16] = green[i-2][j-1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j+1];
                    argsGreen[19] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+1][j-2];
                    argsBlue[1] = blue[i+1][j-1];
                    argsBlue[2] = blue[i+1][j];
                    argsBlue[3] = blue[i+1][j+1];
                    argsBlue[4] = blue[i+1][j+2];
                    argsBlue[5] = blue[i][j-2];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j+2];
                    argsBlue[10] = blue[i-1][j-2];
                    argsBlue[11] = blue[i-1][j-1];
                    argsBlue[12] = blue[i-1][j];
                    argsBlue[13] = blue[i-1][j+1];
                    argsBlue[14] = blue[i-1][j+2];
                    argsBlue[15] = blue[i-2][j-2];
                    argsBlue[16] = blue[i-2][j-1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j+1];
                    argsBlue[19] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //górna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == 1) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+2][j-1];
                    argsRed[1] = red[i+2][j];
                    argsRed[2] = red[i+2][j+1];
                    argsRed[3] = red[i+2][j+2];
                    argsRed[4] = red[i+1][j-1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j+1];
                    argsRed[7] = red[i+1][j+2];
                    argsRed[8] = red[i][j-1];
                    argsRed[9] = red[i][j];
                    argsRed[10] = red[i][j+1];
                    argsRed[11] = red[i][j+2];
                    argsRed[12] = red[i-1][j-1];
                    argsRed[13] = red[i-1][j];
                    argsRed[14] = red[i-1][j+1];
                    argsRed[15] = red[i-1][j+2];
                    argsRed[16] = red[i-2][j-1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j+1];
                    argsRed[19] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i+2][j-1];
                    argsGreen[1] = green[i+2][j];
                    argsGreen[2] = green[i+2][j+1];
                    argsGreen[3] = green[i+2][j+2];
                    argsGreen[4] = green[i+1][j-1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j+1];
                    argsGreen[7] = green[i+1][j+2];
                    argsGreen[8] = green[i][j-1];
                    argsGreen[9] = green[i][j];
                    argsGreen[10] = green[i][j+1];
                    argsGreen[11] = green[i][j+2];
                    argsGreen[12] = green[i-1][j-1];
                    argsGreen[13] = green[i-1][j];
                    argsGreen[14] = green[i-1][j+1];
                    argsGreen[15] = green[i-1][j+2];
                    argsGreen[16] = green[i-2][j-1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j+1];
                    argsGreen[19] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i+2][j-1];
                    argsBlue[1] = blue[i+2][j];
                    argsBlue[2] = blue[i+2][j+1];
                    argsBlue[3] = blue[i+2][j+2];
                    argsBlue[4] = blue[i+1][j-1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j+1];
                    argsBlue[7] = blue[i+1][j+2];
                    argsBlue[8] = blue[i][j-1];
                    argsBlue[9] = blue[i][j];
                    argsBlue[10] = blue[i][j+1];
                    argsBlue[11] = blue[i][j+2];
                    argsBlue[12] = blue[i-1][j-1];
                    argsBlue[13] = blue[i-1][j];
                    argsBlue[14] = blue[i-1][j+1];
                    argsBlue[15] = blue[i-1][j+2];
                    argsBlue[16] = blue[i-2][j-1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j+1];
                    argsBlue[19] = blue[i-2][j+2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                //dolna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == image.getHeight()-2) {
                
                argsRed = new int[20];
                    argsGreen = new int[20];
                    argsBlue = new int[20];
                    
                    argsRed[0] = red[i+2][j+1];
                    argsRed[1] = red[i+2][j];
                    argsRed[2] = red[i+2][j-1];
                    argsRed[3] = red[i+2][j-2];
                    argsRed[4] = red[i+1][j+1];
                    argsRed[5] = red[i+1][j];
                    argsRed[6] = red[i+1][j-1];
                    argsRed[7] = red[i+1][j-2];
                    argsRed[8] = red[i][j+1];
                    argsRed[9] = red[i][j];
                    argsRed[10] = red[i][j-1];
                    argsRed[11] = red[i][j-2];
                    argsRed[12] = red[i-1][j+1];
                    argsRed[13] = red[i-1][j];
                    argsRed[14] = red[i-1][j-1];
                    argsRed[15] = red[i-1][j-2];
                    argsRed[16] = red[i-2][j+1];
                    argsRed[17] = red[i-2][j];
                    argsRed[18] = red[i-2][j-1];
                    argsRed[19] = red[i-2][j-2];
                    
                   argsGreen[0] = green[i+2][j+1];
                    argsGreen[1] = green[i+2][j];
                    argsGreen[2] = green[i+2][j-1];
                    argsGreen[3] = green[i+2][j-2];
                    argsGreen[4] = green[i+1][j+1];
                    argsGreen[5] = green[i+1][j];
                    argsGreen[6] = green[i+1][j-1];
                    argsGreen[7] = green[i+1][j-2];
                    argsGreen[8] = green[i][j+1];
                    argsGreen[9] = green[i][j];
                    argsGreen[10] = green[i][j-1];
                    argsGreen[11] = green[i][j-2];
                    argsGreen[12] = green[i-1][j+1];
                    argsGreen[13] = green[i-1][j];
                    argsGreen[14] = green[i-1][j-1];
                    argsGreen[15] = green[i-1][j-2];
                    argsGreen[16] = green[i-2][j+1];
                    argsGreen[17] = green[i-2][j];
                    argsGreen[18] = green[i-2][j-1];
                    argsGreen[19] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i+2][j+1];
                    argsBlue[1] = blue[i+2][j];
                    argsBlue[2] = blue[i+2][j-1];
                    argsBlue[3] = blue[i+2][j-2];
                    argsBlue[4] = blue[i+1][j+1];
                    argsBlue[5] = blue[i+1][j];
                    argsBlue[6] = blue[i+1][j-1];
                    argsBlue[7] = blue[i+1][j-2];
                    argsBlue[8] = blue[i][j+1];
                    argsBlue[9] = blue[i][j];
                    argsBlue[10] = blue[i][j-1];
                    argsBlue[11] = blue[i][j-2];
                    argsBlue[12] = blue[i-1][j+1];
                    argsBlue[13] = blue[i-1][j];
                    argsBlue[14] = blue[i-1][j-1];
                    argsBlue[15] = blue[i-1][j-2];
                    argsBlue[16] = blue[i-2][j+1];
                    argsBlue[17] = blue[i-2][j];
                    argsBlue[18] = blue[i-2][j-1];
                    argsBlue[19] = blue[i-2][j-2];
                    
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                
                
                }
                
                
                
                //lewy górny róg -1 -1
                if (i == 1 && j == 1) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j-1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j+1];
                    argsRed[3] = red[i-1][j+2];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j+1];
                    argsRed[7] = red[i][j+2];
                    argsRed[8] = red[i+1][j-1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i+2][j-1];
                    argsRed[13] = red[i+2][j];
                    argsRed[14] = red[i+2][j+1];
                    argsRed[15] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-1][j-1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j+1];
                    argsGreen[3] = green[i-1][j+2];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j+1];
                    argsGreen[7] = green[i][j+2];
                    argsGreen[8] = green[i+1][j-1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i+2][j-1];
                    argsGreen[13] = green[i+2][j];
                    argsGreen[14] = green[i+2][j+1];
                    argsGreen[15] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j+1];
                    argsBlue[3] = blue[i-1][j+2];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j+1];
                    argsBlue[7] = blue[i][j+2];
                    argsBlue[8] = blue[i+1][j-1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i+2][j-1];
                    argsBlue[13] = blue[i+2][j];
                    argsBlue[14] = blue[i+2][j+1];
                    argsBlue[15] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                }
                
                //prawy górny róg -1 -1
                if (i == image.getWidth() - 2 && j == 1) {
                    
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j-1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j+1];
                    argsRed[3] = red[i-1][j+2];
                    argsRed[4] = red[i][j-1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j+1];
                    argsRed[7] = red[i][j+2];
                    argsRed[8] = red[i+1][j-1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j+1];
                    argsRed[11] = red[i+1][j+2];
                    argsRed[12] = red[i-2][j-1];
                    argsRed[13] = red[i-2][j];
                    argsRed[14] = red[i-2][j+1];
                    argsRed[15] = red[i-2][j+2];
                    
                    argsGreen[0] = green[i-1][j-1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j+1];
                    argsGreen[3] = green[i-1][j+2];
                    argsGreen[4] = green[i][j-1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j+1];
                    argsGreen[7] = green[i][j+2];
                    argsGreen[8] = green[i+1][j-1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j+1];
                    argsGreen[11] = green[i+1][j+2];
                    argsGreen[12] = green[i-2][j-1];
                    argsGreen[13] = green[i-2][j];
                    argsGreen[14] = green[i-2][j+1];
                    argsGreen[15] = green[i-2][j+2];
                    
                    argsBlue[0] = blue[i-1][j-1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j+1];
                    argsBlue[3] = blue[i-1][j+2];
                    argsBlue[4] = blue[i][j-1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j+1];
                    argsBlue[7] = blue[i][j+2];
                    argsBlue[8] = blue[i+1][j-1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j+1];
                    argsBlue[11] = blue[i+1][j+2];
                    argsBlue[12] = blue[i-2][j-1];
                    argsBlue[13] = blue[i-2][j];
                    argsBlue[14] = blue[i-2][j+1];
                    argsBlue[15] = blue[i-2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                    
                } 
                
                //prawy dolny róg -1 -1
                if (i == image.getWidth()-2 && j == image.getHeight()-2) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j+1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j-1];
                    argsRed[3] = red[i-1][j-2];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j-2];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i-2][j+1];
                    argsRed[13] = red[i-2][j];
                    argsRed[14] = red[i-2][j-1];
                    argsRed[15] = red[i-2][j-2];
                    
                    argsGreen[0] = green[i-1][j+1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j-1];
                    argsGreen[3] = green[i-1][j-2];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j-2];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i-2][j+1];
                    argsGreen[13] = green[i-2][j];
                    argsGreen[14] = green[i-2][j-1];
                    argsGreen[15] = green[i-2][j-2];
                    
                    argsBlue[0] = blue[i-1][j+1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j-1];
                    argsBlue[3] = blue[i-1][j-2];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j-2];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i-2][j+1];
                    argsBlue[13] = blue[i-2][j];
                    argsBlue[14] = blue[i-2][j-1];
                    argsBlue[15] = blue[i-2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                    
                }
                
                //lewy dolny róg -1 -1
                if (i == 1 && j == image.getHeight()-2) {
                    argsRed = new int[16];
                    argsGreen = new int[16];
                    argsBlue = new int[16];
                   
                    argsRed[0] = red[i-1][j+1];
                    argsRed[1] = red[i-1][j];
                    argsRed[2] = red[i-1][j-1];
                    argsRed[3] = red[i-1][j-2];
                    argsRed[4] = red[i][j+1];
                    argsRed[5] = red[i][j];
                    argsRed[6] = red[i][j-1];
                    argsRed[7] = red[i][j-2];
                    argsRed[8] = red[i+1][j+1];
                    argsRed[9] = red[i+1][j];
                    argsRed[10] = red[i+1][j-1];
                    argsRed[11] = red[i+1][j-2];
                    argsRed[12] = red[i+2][j+1];
                    argsRed[13] = red[i+2][j];
                    argsRed[14] = red[i+2][j-1];
                    argsRed[15] = red[i+2][j-2];
                    
                    argsGreen[0] = green[i-1][j+1];
                    argsGreen[1] = green[i-1][j];
                    argsGreen[2] = green[i-1][j-1];
                    argsGreen[3] = green[i-1][j-2];
                    argsGreen[4] = green[i][j+1];
                    argsGreen[5] = green[i][j];
                    argsGreen[6] = green[i][j-1];
                    argsGreen[7] = green[i][j-2];
                    argsGreen[8] = green[i+1][j+1];
                    argsGreen[9] = green[i+1][j];
                    argsGreen[10] = green[i+1][j-1];
                    argsGreen[11] = green[i+1][j-2];
                    argsGreen[12] = green[i+2][j+1];
                    argsGreen[13] = green[i+2][j];
                    argsGreen[14] = green[i+2][j-1];
                    argsGreen[15] = green[i+2][j-2];
                    
                    argsBlue[0] = blue[i-1][j+1];
                    argsBlue[1] = blue[i-1][j];
                    argsBlue[2] = blue[i-1][j-1];
                    argsBlue[3] = blue[i-1][j-2];
                    argsBlue[4] = blue[i][j+1];
                    argsBlue[5] = blue[i][j];
                    argsBlue[6] = blue[i][j-1];
                    argsBlue[7] = blue[i][j-2];
                    argsBlue[8] = blue[i+1][j+1];
                    argsBlue[9] = blue[i+1][j];
                    argsBlue[10] = blue[i+1][j-1];
                    argsBlue[11] = blue[i+1][j-2];
                    argsBlue[12] = blue[i+2][j+1];
                    argsBlue[13] = blue[i+2][j];
                    argsBlue[14] = blue[i+2][j-1];
                    argsBlue[15] = blue[i+2][j-2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }
                   
                    
                }
                
                
                
                //Srodek Start
                if ((i == 2 && j >= 2 && j < image.getHeight()-2) || (i == image.getWidth()-3 && j >= 2 && j < image.getHeight()-2) || (j == 2 && i >= 2 && i < image.getWidth()-2) || (j == image.getHeight()-3 && i >= 2 && i < image.getWidth()-2 )) {
                    
                    argsRed = new int[25];
                    argsGreen = new int[25];
                    argsBlue = new int[25];
                    
                    argsRed[0] = red[i-2][j-2];
                    argsRed[1] = red[i-2][j-1];
                    argsRed[2] = red[i-2][j];
                    argsRed[3] = red[i-2][j+1];
                    argsRed[4] = red[i-2][j+2];
                    argsRed[5] = red[i-1][j-2];
                    argsRed[6] = red[i-1][j-1];
                    argsRed[7] = red[i-1][j];
                    argsRed[8] = red[i-1][j+1];
                    argsRed[9] = red[i-1][j+2];
                    argsRed[10] = red[i][j-2];
                    argsRed[11] = red[i][j-2];
                    argsRed[12] = red[i][j];
                    argsRed[13] = red[i][j+1];
                    argsRed[14] = red[i][j+2];
                    argsRed[15] = red[i+1][j-2];
                    argsRed[16] = red[i+1][j-1];
                    argsRed[17] = red[i+1][j];
                    argsRed[18] = red[i+1][j+1];
                    argsRed[19] = red[i+1][j+2];
                    argsRed[20] = red[i+2][j-2];
                    argsRed[21] = red[i+2][j-1];
                    argsRed[22] = red[i+2][j];
                    argsRed[23] = red[i+2][j+1];
                    argsRed[24] = red[i+2][j+2];
                    
                    argsGreen[0] = green[i-2][j-2];
                    argsGreen[1] = green[i-2][j-1];
                    argsGreen[2] = green[i-2][j];
                    argsGreen[3] = green[i-2][j+1];
                    argsGreen[4] = green[i-2][j+2];
                    argsGreen[5] = green[i-1][j-2];
                    argsGreen[6] = green[i-1][j-1];
                    argsGreen[7] = green[i-1][j];
                    argsGreen[8] = green[i-1][j+1];
                    argsGreen[9] = green[i-1][j+2];
                    argsGreen[10] = green[i][j-2];
                    argsGreen[11] = green[i][j-2];
                    argsGreen[12] = green[i][j];
                    argsGreen[13] = green[i][j+1];
                    argsGreen[14] = green[i][j+2];
                    argsGreen[15] = green[i+1][j-2];
                    argsGreen[16] = green[i+1][j-1];
                    argsGreen[17] = green[i+1][j];
                    argsGreen[18] = green[i+1][j+1];
                    argsGreen[19] = green[i+1][j+2];
                    argsGreen[20] = green[i+2][j-2];
                    argsGreen[21] = green[i+2][j-1];
                    argsGreen[22] = green[i+2][j];
                    argsGreen[23] = green[i+2][j+1];
                    argsGreen[24] = green[i+2][j+2];
                    
                    argsBlue[0] = blue[i-2][j-2];
                    argsBlue[1] = blue[i-2][j-1];
                    argsBlue[2] = blue[i-2][j];
                    argsBlue[3] = blue[i-2][j+1];
                    argsBlue[4] = blue[i-2][j+2];
                    argsBlue[5] = blue[i-1][j-2];
                    argsBlue[6] = blue[i-1][j-1];
                    argsBlue[7] = blue[i-1][j];
                    argsBlue[8] = blue[i-1][j+1];
                    argsBlue[9] = blue[i-1][j+2];
                    argsBlue[10] = blue[i][j-2];
                    argsBlue[11] = blue[i][j-2];
                    argsBlue[12] = blue[i][j];
                    argsBlue[13] = blue[i][j+1];
                    argsBlue[14] = blue[i][j+2];
                    argsBlue[15] = blue[i+1][j-2];
                    argsBlue[16] = blue[i+1][j-1];
                    argsBlue[17] = blue[i+1][j];
                    argsBlue[18] = blue[i+1][j+1];
                    argsBlue[19] = blue[i+1][j+2];
                    argsBlue[20] = blue[i+2][j-2];
                    argsBlue[21] = blue[i+2][j-1];
                    argsBlue[22] = blue[i+2][j];
                    argsBlue[23] = blue[i+2][j+1];
                    argsBlue[24] = blue[i+2][j+2];
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                }
                  
                //srodek 7x7
                if (i > 2 && i < image.getWidth()-3 && j > 2 && j < image.getHeight()-3 ) {
                   argsRed = new int[49];
                    argsGreen = new int[49];
                    argsBlue = new int[49];
                    
                    argsRed[0] = red[i-3][j-3];         argsRed[25] = red[i][j+1];
                    argsRed[1] = red[i-3][j-2];         argsRed[26] = red[i][j+2];
                    argsRed[2] = red[i-3][j-1];           argsRed[27] = red[i][j+3];
                    argsRed[3] = red[i-3][j];         argsRed[28] = red[i+1][j-3];
                    argsRed[4] = red[i-3][j+1];         argsRed[29] = red[i+1][j-2];
                    argsRed[5] = red[i-3][j+2];         argsRed[30] = red[i+1][j-1];
                    argsRed[6] = red[i-3][j+3];         argsRed[31] = red[i+1][j];
                    argsRed[7] = red[i-2][j-3];           argsRed[32] = red[i+1][j+1];
                    argsRed[8] = red[i-2][j-2];         argsRed[33] = red[i+1][j+2];
                    argsRed[9] = red[i-2][j-1];         argsRed[34] = red[i+1][j+3];
                    argsRed[10] = red[i-2][j];          argsRed[35] = red[i+2][j-3];
                    argsRed[11] = red[i-2][j+1];          argsRed[36] = red[i+2][j-2];
                    argsRed[12] = red[i-2][j+2];            argsRed[37] = red[i+2][j-1];
                    argsRed[13] = red[i-2][j+3];          argsRed[38] = red[i+2][j];
                    argsRed[14] = red[i-1][j-3];          argsRed[39] = red[i+2][j+1];
                    argsRed[15] = red[i-1][j-2];        argsRed[40] = red[i+2][j+2];
                    argsRed[16] = red[i-1][j-1];        argsRed[41] = red[i+2][j+3];
                    argsRed[17] = red[i-1][j];          argsRed[42] = red[i+3][j-3];
                    argsRed[18] = red[i-1][j+1];        argsRed[43] = red[i+3][j-2];
                    argsRed[19] = red[i-1][j+2];        argsRed[44] = red[i+3][j-1];
                    argsRed[20] = red[i-1][j+3];        argsRed[45] = red[i+3][j];
                    argsRed[21] = red[i][j-3];        argsRed[46] = red[i+3][j+1];
                    argsRed[22] = red[i][j-2];          argsRed[47] = red[i+3][j+2];
                    argsRed[23] = red[i][j-1];        argsRed[48] = red[i+3][j+3];
                    argsRed[24] = red[i][j];         
                    
                    argsGreen[0] = green[i-3][j-3];         argsGreen[25] = green[i][j+1];
                    argsGreen[1] = green[i-3][j-2];         argsGreen[26] = green[i][j+2];
                    argsGreen[2] = green[i-3][j-1];           argsGreen[27] = green[i][j+3];
                    argsGreen[3] = green[i-3][j];         argsGreen[28] = green[i+1][j-3];
                    argsGreen[4] = green[i-3][j+1];         argsGreen[29] = green[i+1][j-2];
                    argsGreen[5] = green[i-3][j+2];         argsGreen[30] = green[i+1][j-1];
                    argsGreen[6] = green[i-3][j+3];         argsGreen[31] = green[i+1][j];
                    argsGreen[7] = green[i-2][j-3];           argsGreen[32] = green[i+1][j+1];
                    argsGreen[8] = green[i-2][j-2];         argsGreen[33] = green[i+1][j+2];
                    argsGreen[9] = green[i-2][j-1];         argsGreen[34] = green[i+1][j+3];
                    argsGreen[10] = green[i-2][j];          argsGreen[35] = green[i+2][j-3];
                    argsGreen[11] = green[i-2][j+1];          argsGreen[36] = green[i+2][j-2];
                    argsGreen[12] = green[i-2][j+2];            argsGreen[37] = green[i+2][j-1];
                    argsGreen[13] = green[i-2][j+3];          argsGreen[38] = green[i+2][j];
                    argsGreen[14] = green[i-1][j-3];          argsGreen[39] = green[i+2][j+1];
                    argsGreen[15] = green[i-1][j-2];        argsGreen[40] = green[i+2][j+2];
                    argsGreen[16] = green[i-1][j-1];        argsGreen[41] = green[i+2][j+3];
                    argsGreen[17] = green[i-1][j];          argsGreen[42] = green[i+3][j-3];
                    argsGreen[18] = green[i-1][j+1];        argsGreen[43] = green[i+3][j-2];
                    argsGreen[19] = green[i-1][j+2];        argsGreen[44] = green[i+3][j-1];
                    argsGreen[20] = green[i-1][j+3];        argsGreen[45] = green[i+3][j];
                    argsGreen[21] = green[i][j-3];        argsGreen[46] = green[i+3][j+1];
                    argsGreen[22] = green[i][j-2];          argsGreen[47] = green[i+3][j+2];
                    argsGreen[23] = green[i][j-1];        argsGreen[48] = green[i+3][j+3];
                    argsGreen[24] = green[i][j];         
                    
                    argsBlue[0] = blue[i-3][j-3];         argsBlue[25] = blue[i][j+1];
                    argsBlue[1] = blue[i-3][j-2];         argsBlue[26] = blue[i][j+2];
                    argsBlue[2] = blue[i-3][j-1];           argsBlue[27] = blue[i][j+3];
                    argsBlue[3] = blue[i-3][j];         argsBlue[28] = blue[i+1][j-3];
                    argsBlue[4] = blue[i-3][j+1];         argsBlue[29] = blue[i+1][j-2];
                    argsBlue[5] = blue[i-3][j+2];         argsBlue[30] = blue[i+1][j-1];
                    argsBlue[6] = blue[i-3][j+3];         argsBlue[31] = blue[i+1][j];
                    argsBlue[7] = blue[i-2][j-3];           argsBlue[32] = blue[i+1][j+1];
                    argsBlue[8] = blue[i-2][j-2];         argsBlue[33] = blue[i+1][j+2];
                    argsBlue[9] = blue[i-2][j-1];         argsBlue[34] = blue[i+1][j+3];
                    argsBlue[10] = blue[i-2][j];          argsBlue[35] = blue[i+2][j-3];
                    argsBlue[11] = blue[i-2][j+1];          argsBlue[36] = blue[i+2][j-2];
                    argsBlue[12] = blue[i-2][j+2];            argsBlue[37] = blue[i+2][j-1];
                    argsBlue[13] = blue[i-2][j+3];          argsBlue[38] = blue[i+2][j];
                    argsBlue[14] = blue[i-1][j-3];          argsBlue[39] = blue[i+2][j+1];
                    argsBlue[15] = blue[i-1][j-2];        argsBlue[40] = blue[i+2][j+2];
                    argsBlue[16] = blue[i-1][j-1];        argsBlue[41] = blue[i+2][j+3];
                    argsBlue[17] = blue[i-1][j];          argsBlue[42] = blue[i+3][j-3];
                    argsBlue[18] = blue[i-1][j+1];        argsBlue[43] = blue[i+3][j-2];
                    argsBlue[19] = blue[i-1][j+2];        argsBlue[44] = blue[i+3][j-1];
                    argsBlue[20] = blue[i-1][j+3];        argsBlue[45] = blue[i+3][j];
                    argsBlue[21] = blue[i][j-3];        argsBlue[46] = blue[i+3][j+1];
                    argsBlue[22] = blue[i][j-2];          argsBlue[47] = blue[i+3][j+2];
                    argsBlue[23] = blue[i][j-1];        argsBlue[48] = blue[i+3][j+3];
                    argsBlue[24] = blue[i][j];         
                    
                    
                    if ("Maximal".equals(function)) {
                    newRed[i][j] = getMaxPixel(argsRed);
                    newGreen[i][j] = getMaxPixel(argsGreen);
                    newBlue[i][j] = getMaxPixel(argsBlue);
                    } else if ("Minimal".equals(function)){
                    newRed[i][j] = getMinPixel(argsRed);
                    newGreen[i][j] = getMinPixel(argsGreen);
                    newBlue[i][j] = getMinPixel(argsBlue);
                    } else {
                    newRed[i][j] = getMedianPixel(argsRed);
                    newGreen[i][j] = getMedianPixel(argsGreen);
                    newBlue[i][j] = getMedianPixel(argsBlue);
                    }     
                } 
                
                
                
                
                
                image.setRGB(i, j, new Color(newRed[i][j], newGreen[i][j], newBlue[i][j]).getRGB());
                
            }   
        }
        
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
    
    } 
    
    
    
    public int getMaxPixel(int args[]){
        int currentMax = args[0];
        for (int i = 1; i < args.length; i++){
            if(currentMax < args[i])
                currentMax = args[i];
        }        
        return currentMax;
    }
    
    public int getMinPixel(int args[]){
        int currentMin = args[0];
        for (int i = 1; i < args.length; i++){
            if(currentMin > args[i])
                currentMin = args[i];
        }
        return currentMin;
    }
    
    public int getMedianPixel(int args[]){
        int index = args.length/2;                   
        int temp, i;               
        for (int j = 1; j < args.length; j++){
            temp = args[j];
            for(i = j-1; (i>=0) && (args[i] > temp); i--){
                 args[i+1] = args[i];
            }
         args[i+1] = temp;    
        }
     return args[index];
    }
}
