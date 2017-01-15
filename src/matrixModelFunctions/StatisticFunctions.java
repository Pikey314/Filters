/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixModelFunctions;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Comparator;
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
                
                /*
                if (newRed[i][j] < 0) newRed[i][j] = 0;
                if (newGreen[i][j] < 0) newGreen[i][j] = 0;
                if (newBlue[i][j] < 0) newBlue[i][j] = 0;
                if (newRed[i][j] > 255) newRed[i][j] = 255;
                if (newGreen[i][j] > 255) newGreen[i][j] = 255;
                if (newBlue[i][j] > 255) newBlue[i][j] = 255; */
                  
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
     /*
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
                
                
                if (newRed[i][j] < 0) newRed[i][j] = 0;
                if (newGreen[i][j] < 0) newGreen[i][j] = 0;
                if (newBlue[i][j] < 0) newBlue[i][j] = 0;
                if (newRed[i][j] > 255) newRed[i][j] = 255;
                if (newGreen[i][j] > 255) newGreen[i][j] = 255;
                if (newBlue[i][j] > 255) newBlue[i][j] = 255; 
                  
                image.setRGB(i, j, new Color(newRed[i][j], newGreen[i][j], newBlue[i][j]).getRGB());
                
            }   
        }
        Image dimg = image.getScaledInstance(picturePanel.getWidth(), picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        picturePanel.removeAll();
        picturePanel.add(imageLabel);
        */
    }
    
    public void statisticFunction7x7(BufferedImage image, JPanel picturePanel, String function) {
        
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
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i; 

        for (j = 1; j < args.length; j++)    // Start with 1 (not 0)
        {
            key = args[ j ];
            for(i = j - 1; (i >= 0) && (args[ i ] > key); i--)   // Smaller values are moving up
            {
                 args[ i+1 ] = args[i];
            }
         args[ i+1 ] = key;    // Put the key in its proper location
        }
     return args[index];
    }
}
