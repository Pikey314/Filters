/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixManiFunctions;

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
public class MatrixFunctions {
    
    public void matrix3x3Funtion (BufferedImage image, JPanel picturePanel, int[][] matrix, int matrixSize) {
        
        
        if (matrix.length == matrixSize && matrix[0].length == matrixSize && matrix[1].length == matrixSize && matrix[2].length == matrixSize) {
            
            int LU = matrix[0][0];
            int LC = matrix[1][0];
            int LD = matrix[2][0];
            int CU = matrix[0][1];
            int CC = matrix[1][1];
            int CD = matrix[2][1];
            int RU = matrix[0][2];
            int RC = matrix[1][2];
            int RD = matrix[2][2];
            
            System.out.println(LU + " " + CU + " " + RU);
            System.out.println(LC + " " + CC + " " + RC);
            System.out.println(LD + " " + CD + " " + RD);
            
            
            int matrixSum = LU + LC + LD + CU + CC + CD + RU + RC + RD;
           System.out.println("suma " + matrixSum);
       
       
        
        
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
                   
                
               // image.setRGB(j, i, new Color(red, green, blue).getRGB());
            }
        }
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
               //lewy górny róg start
                if (i == 0 && j == 0) {
                    newRed[i][j] = (red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD);    
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD);   
               
                    if ((CC + CD + RC + RD) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CD + RC + RD);
                         newGreen[i][j] = newGreen[i][j]/(CC + CD + RC + RD);
                         newBlue[i][j] = newBlue[i][j]/(CC + CD + RC + RD);       
                    }
                }
                
                //lewy dolny róg start
                if(i == 0 && j == image.getHeight()-1) {
                    newRed[i][j] = (red[i][j]*CC + red[i][j-1]*CU + red[i+1][j]*RC + red[i+1][j-1]*RU);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j-1]*CU + green[i+1][j]*RC + green[i+1][j-1]*RU); 
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j-1]*CU + blue[i+1][j]*RC + blue[i+1][j-1]*RU); 
                    
                    if ((CC + CU + RC + RU) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CU + RC + RU);
                         newGreen[i][j] = newGreen[i][j]/(CC + CU + RC + RU);
                         newBlue[i][j] = newBlue[i][j]/(CC + CU + RC + RU);
                    }
                } 
                
                //prawy górny róg start
                if(i == image.getWidth()-1 && j == 0){
                    newRed[i][j] = (red[i][j]*CC + red[i][j+1]*CD + red[i-1][j]*LC + red[i-1][j+1]*LD);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j+1]*CD + green[i-1][j]*LC + green[i-1][j+1]*LD);    
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j+1]*CD + blue[i-1][j]*LC + blue[i-1][j+1]*LD);    
                    
                    if ((CC + CD + LC + LD) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CD + LC + LD);
                         newGreen[i][j] = newGreen[i][j]/(CC + CD + LC + LD);
                         newBlue[i][j] = newBlue[i][j]/(CC + CD + LC + LD);
                    }
                }
                
                //prawy dolny róg start
                if(i == image.getWidth()-1 && j == image.getHeight()-1){
                    newRed[i][j] = (red[i][j]*CC + red[i][j-1]*CU + red[i-1][j]*LC + red[i-1][j-1]*LU);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j-1]*CU + green[i-1][j]*LC + green[i-1][j-1]*LU);     
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j-1]*CU + blue[i-1][j]*LC + blue[i-1][j-1]*LU);   
                    
                    if ((CC + CU + LC + LU) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CU + LC + LU);
                         newGreen[i][j] = newGreen[i][j]/(CC + CU + LC + LU);
                         newBlue[i][j] = newBlue[i][j]/(CC + CU + LC + LU);
                    }
                }
                
                //lewa krawędź
                if (i == 0 && j > 0 && j < image.getHeight()-1){
                    newRed[i][j] = (red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD);
                    newGreen[i][j] = (green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD);
                    newBlue[i][j] = (green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD);         
                    
                    if ((CU + CC + CD + RU + RC + RD) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + RU + RC + RD);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + RU + RC + RD);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + RU + RC + RD);
                    }
                }
                
                //prawa krawędź
                if (i == image.getWidth()-1 && j > 0 && j < image.getHeight()-1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD);     
                    
                    if ((CU + CC + CD + LU + LC + LD) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + LU + LC + LD);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + LU + LC + LD);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + LU + LC + LD);
                    }
                }
                
                //górna krawędź
                if (i > 0 && i < image.getWidth()-1 && j == 0){
                    newRed[i][j] = (red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD);
                    newGreen[i][j] = (green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD);
                    newBlue[i][j] = (blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD);
                    
                    if ((LC + LD + CC + CD + RC + RD) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LD + CC + CD + RC + RD);
                         newGreen[i][j] = newGreen[i][j]/(LC + LD + CC + CD + RC + RD);
                         newBlue[i][j] = newBlue[i][j]/(LC + LD + CC + CD + RC + RD);
                    }                    
                }
                
                //dolna krawędź
                if (i > 0 && i < image.getWidth()-1 && j == image.getHeight()-1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i][j-1]*CU + red[i][j]*CC + red[i+1][j-1]*RU + red[i+1][j]*RC);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i][j-1]*CU + green[i][j]*CC + green[i+1][j-1]*RU + green[i+1][j]*RC);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i][j-1]*CU + blue[i][j]*CC + blue[i+1][j-1]*RU + blue[i+1][j]*RC);
                
                    if ((LC + LU + CC + CU + RC + RU) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LU + CC + CU + RC + RU);
                         newGreen[i][j] = newGreen[i][j]/(LC + LU + CC + CU + RC + RU);
                         newBlue[i][j] = newBlue[i][j]/(LC + LU + CC + CU + RC + RU);
                    }   
                }
                
                
                //Srodek Start
                if (i >= 1 && i < image.getWidth()-1 && j >= 1 && j < image.getHeight()-1) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD);
                
                    if (matrixSum != 0){
                        newRed[i][j] = newRed[i][j]/matrixSum;
                        newGreen[i][j] = newGreen[i][j]/matrixSum;
                        newBlue[i][j] =  newBlue[i][j]/matrixSum; 
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
    

        }
    }
}
