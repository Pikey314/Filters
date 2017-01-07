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
                    newBlue[i][j] = (blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD);         
                    
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
     public void matrix5x5Funtion (BufferedImage image, JPanel picturePanel, int[][] matrix, int matrixSize) {
      
        if (matrix.length == matrixSize && matrix[0].length == matrixSize && matrix[1].length == matrixSize && matrix[2].length == matrixSize && matrix[3].length == matrixSize && matrix[4].length == matrixSize) {    
         
            int LLUL = matrix[0][0];
            int LLU = matrix[1][0];
            int LLC = matrix[2][0];
            int LLD = matrix[3][0];
            int LLDL = matrix[4][0];
            int LUU = matrix[0][1];
            int LU = matrix[1][1];
            int LC = matrix[2][1];
            int LD = matrix[3][1];
            int LDD = matrix[4][1];
            int CUU = matrix[0][2];
            int CU = matrix[1][2];
            int CC = matrix[2][2];
            int CD = matrix[3][2];
            int CDD = matrix[4][2];
            int RUU = matrix[0][3];
            int RU = matrix[1][3];
            int RC = matrix[2][3];
            int RD = matrix[3][3];
            int RDD = matrix[4][3];
            int RRUR = matrix[0][4];
            int RRU = matrix[1][4];
            int RRC = matrix[2][4];
            int RRD = matrix[3][4];
            int RRDR = matrix[4][4];
            
            System.out.println(LLUL + " " + LUU + " " + CUU + " " + RUU + " " + RRUR);
            System.out.println(LLU + " " + LU + " " + CU + " " + RU + " " + RRU);
            System.out.println(LLC + " " + LC + " " + CC + " " + RC + " " + RRC);
            System.out.println(LLD + " " + LD + " " + CD + " " + RD + " " + RRD);
            System.out.println(LLDL + " " + LDD + " " + CDD + " " + RDD + " " + RRDR); 
            
            
            int matrixSum = LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + LLU + LLC + LLD + LLUL + LLDL + RRUR + RRU + RRC + RRD + RRDR;
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
                    newRed[i][j] = (red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD  +  red[i][j+2]*CDD + red[i][j+1]*RDD + red[i+2][j]*RRC + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD  +  green[i][j+2]*CDD + green[i][j+1]*RDD + green[i+2][j]*RRC + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);    
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD  +  blue[i][j+2]*CDD + blue[i][j+1]*RDD + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);   
               
                    if ((CC + CD + RC + RD + CDD + RDD + RRC + RRD + RRDR) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CD + RC + RD + CDD + RDD + RRC + RRD + RRDR);
                         newGreen[i][j] = newGreen[i][j]/(CC + CD + RC + RD + CDD + RDD + RRC + RRD + RRDR);
                         newBlue[i][j] = newBlue[i][j]/(CC + CD + RC + RD + CDD + RDD + RRC + RRD + RRDR);       
                    }
                }
                
                //lewy dolny róg start
                if(i == 0 && j == image.getHeight()-1) {
                    newRed[i][j] = (red[i][j]*CC + red[i][j-1]*CU + red[i+1][j]*RC + red[i+1][j-1]*RU  +  red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i+2][j]*RRC + red[i+2][j-1]*RRU + red[i+2][j-2]*RRUR);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j-1]*CU + green[i+1][j]*RC + green[i+1][j-1]*RU); 
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j-1]*CU + blue[i+1][j]*RC + blue[i+1][j-1]*RU); 
                    
                    if ((CC + CU + RC + RU + CUU + RUU + RRC + RRU + RRUR) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CU + RC + RU + CUU + RUU + RRC + RRU + RRUR);
                         newGreen[i][j] = newGreen[i][j]/(CC + CU + RC + RU + CUU + RUU + RRC + RRU + RRUR);
                         newBlue[i][j] = newBlue[i][j]/(CC + CU + RC + RU + CUU + RUU + RRC + RRU + RRUR);
                    }
                } 
                
                //prawy górny róg start
                if(i == image.getWidth()-1 && j == 0){
                    newRed[i][j] = (red[i][j]*CC + red[i][j+1]*CD + red[i-1][j]*LC + red[i-1][j+1]*LD  +  red[i][j+2]*CDD + red[i-1][j+2]*LDD + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j+1]*CD + green[i-1][j]*LC + green[i-1][j+1]*LD);    
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j+1]*CD + blue[i-1][j]*LC + blue[i-1][j+1]*LD);    
                    
                    if ((CC + CD + LC + LD + CDD + LDD + LLC + LLD + LLDL) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CD + LC + LD + CDD + LDD + LLC + LLD + LLDL);
                         newGreen[i][j] = newGreen[i][j]/(CC + CD + LC + LD + CDD + LDD + LLC + LLD + LLDL);
                         newBlue[i][j] = newBlue[i][j]/(CC + CD + LC + LD + CDD + LDD + LLC + LLD + LLDL);
                    }
                }
                
                //prawy dolny róg start
                if(i == image.getWidth()-1 && j == image.getHeight()-1){
                    newRed[i][j] = (red[i][j]*CC + red[i][j-1]*CU + red[i-1][j]*LC + red[i-1][j-1]*LU  +  red[i][j-2]*CUU + red[i-1][j-2]*LUU + red[i-2][j]*LLC + red[i-2][j-1]*LLU + red[i-2][j-2]*LLUL);    
                    newGreen[i][j] = (green[i][j]*CC + green[i][j-1]*CU + green[i-1][j]*LC + green[i-1][j-1]*LU);     
                    newBlue[i][j] = (blue[i][j]*CC + blue[i][j-1]*CU + blue[i-1][j]*LC + blue[i-1][j-1]*LU);   
                    
                    if ((CC + CU + LC + LU  +  CUU + LUU + LLC + LLU + LLUL) != 0){
                         newRed[i][j] = newRed[i][j]/(CC + CU + LC + LU +  CUU + LUU + LLC + LLU + LLUL);
                         newGreen[i][j] = newGreen[i][j]/(CC + CU + LC + LU +  CUU + LUU + LLC + LLU + LLUL);
                         newBlue[i][j] = newBlue[i][j]/(CC + CU + LC + LU +  CUU + LUU + LLC + LLU + LLUL);
                    }
                }
                
                //lewa krawędź
                if (i == 0 && j > 1 && j < image.getHeight()-2){
                    newRed[i][j] = (red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i][j+2]*CDD + red[i][j-2]*CUU + red[i+1][j+2]*RDD + red[i+1][j-2]*RUU + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i][j+2]*CDD + green[i][j-2]*CUU + green[i+1][j+2]*RDD + green[i+1][j-2]*RUU + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + red[i+2][j]*RRC + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i][j+2]*CDD + blue[i][j-2]*CUU + blue[i+1][j+2]*RDD + blue[i+1][j-2]*RUU + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                    
                    if ((CU + CC + CD + RU + RC + RD  +  CDD + CUU + RDD + RUU + RRUR + RRU + RRC + RRD + RRDR) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + CUU + RDD + RUU + RRUR + RRU + RRC + RRD + RRDR);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + CUU + RDD + RUU + RRUR + RRU + RRC + RRD + RRDR);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + CUU + RDD + RUU + RRUR + RRU + RRC + RRD + RRDR);
                    }
                }
                
                //prawa krawędź
                if (i == image.getWidth()-1 && j > 1 && j < image.getHeight()-2){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD
                            + red[i][j-2]*CUU + red[i][j+2]*CDD + red[i-1][j-2]*LUU + red[i][j+2]*LDD + red[i-2][j-2]*LLUL + red[i-2][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD
                            + green[i][j-2]*CUU + green[i][j+2]*CDD + green[i-1][j-2]*LUU + green[i][j+2]*LDD + green[i-2][j-2]*LLUL + green[i-2][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD
                            + blue[i][j-2]*CUU + blue[i][j+2]*CDD + blue[i-1][j-2]*LUU + blue[i][j+2]*LDD + blue[i-2][j-2]*LLUL + blue[i-2][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                    
                    if ((CU + CC + CD + LU + LC + LD  +  CUU + CDD + LUU + LDD + LLUL + LLU + LLC + LLD + LLDL) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + CDD + LUU + LDD + LLUL + LLU + LLC + LLD + LLDL);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + CDD + LUU + LDD + LLUL + LLU + LLC + LLD + LLDL);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + CDD + LUU + LDD + LLUL + LLU + LLC + LLD + LLDL);
                    }
                }
                
                //górna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == 0){
                    newRed[i][j] = (red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL + red[i+2][j]*RRC + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL + green[i+2][j]*RRC + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                    
                    if ((LC + LD + CC + CD + RC + RD  +  LDD + CDD + RDD + LLC + LLD + LLDL + RRC + RRD + RRDR) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + LLC + LLD + LLDL + RRC + RRD + RRDR);
                         newGreen[i][j] = newGreen[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + LLC + LLD + LLDL + RRC + RRD + RRDR);
                         newBlue[i][j] = newBlue[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + LLC + LLD + LLDL + RRC + RRD + RRDR);
                    }                    
                }
                
                //dolna krawędź
                if (i > 1 && i < image.getWidth()-2 && j == image.getHeight()-1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i][j-1]*CU + red[i][j]*CC + red[i+1][j-1]*RU + red[i+1][j]*RC
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i-2][j]*LLC + red[i-2][j-1]*LLU + red[i-2][j-2]*LLUL + red[i+2][j]*RRC + red[i+2][j-1]*RRU + red[i+2][j-2]*RRUR);                            
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i][j-1]*CU + green[i][j]*CC + green[i+1][j-1]*RU + green[i+1][j]*RC
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i-2][j]*LLC + green[i-2][j-1]*LLU + green[i-2][j-2]*LLUL + green[i+2][j]*RRC + green[i+2][j-1]*RRU + green[i+2][j-2]*RRUR);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i][j-1]*CU + blue[i][j]*CC + blue[i+1][j-1]*RU + blue[i+1][j]*RC
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i-2][j]*LLC + blue[i-2][j-1]*LLU + blue[i-2][j-2]*LLUL + blue[i+2][j]*RRC + blue[i+2][j-1]*RRU + blue[i+2][j-2]*RRUR);
                
                    if ((LC + LU + CC + CU + RC + RU  +  LUU + CUU + RUU + LLC + LLU + LLUL + RRC + RRU + RRUR) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL + RRC + RRU + RRUR);
                         newGreen[i][j] = newGreen[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL + RRC + RRU + RRUR);
                         newBlue[i][j] = newBlue[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL + RRC + RRU + RRUR);
                    }   
                }
                
                
                
                
                //lewy górny róg - 1 wysokość
                if (i == 0 && j == 1){
                    newRed[i][j] = (red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i+2][j-1]*RRU + red[i+2][j]*RRC + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i+2][j-1]*RRU + green[i+2][j]*RRC + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                    
                    if ((CU + CC + CD + RU + RC + RD  +  CDD + RDD + RRU + RRC + RRD + RRDR) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + RDD + RRU + RRC + RRD + RRDR);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + RDD + RRU + RRC + RRD + RRDR);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + RU + RC + RD +  CDD + RDD + RRU + RRC + RRD + RRDR);
                    }
                }
                
                //prawy górny róg - 1 wysokość
                if (i == image.getWidth()-1 && j == 1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD
                            + red[i][j+2]*CDD + red[i][j+2]*LDD + red[i-2][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD
                            + green[i][j+2]*CDD + green[i][j+2]*LDD + green[i-2][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD
                            + blue[i][j+2]*CDD + blue[i][j+2]*LDD + blue[i-2][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                    
                    if ((CU + CC + CD + LU + LC + LD  + CDD + LDD + LLU + LLC + LLD + LLDL) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + LU + LC + LD +  + CDD + LDD + LLU + LLC + LLD + LLDL);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + LU + LC + LD + CDD + LDD + LLU + LLC + LLD + LLDL);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + LU + LC + LD + CDD + LDD + LLU + LLC + LLD + LLDL);
                    }
                }
                
                 //lewy dolny róg + 1 wysokość
                if (i == 0 && j == image.getHeight()-2){
                    newRed[i][j] = (red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC + red[i+2][j+1]*RRD);
                    newGreen[i][j] = (green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + green[i+2][j]*RRC + green[i+2][j+1]*RRD);
                    newBlue[i][j] = (blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD);
                    
                    if ((CU + CC + CD + RU + RC + RD  +  CUU + RUU + RRUR + RRU + RRC + RRD) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + RU + RC + RD +  CUU + RUU + RRUR + RRU + RRC + RRD);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + RU + RC + RD +  CUU + RUU + RRUR + RRU + RRC + RRD);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + RU + RC + RD +  CUU + RUU + RRUR + RRU + RRC + RRD);
                    }
                }
                
                //prawy dolny róg + 1 wysokość
                if (i == image.getWidth()-1 && j == image.getHeight()-2){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD
                            + red[i][j-2]*CUU + red[i-1][j-2]*LUU + red[i-2][j-2]*LLUL + red[i-2][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD
                            + green[i][j-2]*CUU + green[i-1][j-2]*LUU + green[i-2][j-2]*LLUL + green[i-2][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD
                            + blue[i][j-2]*CUU + blue[i-1][j-2]*LUU + blue[i-2][j-2]*LLUL + blue[i-2][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD);
                    
                    if ((CU + CC + CD + LU + LC + LD  +  CUU + LUU + LLUL + LLU + LLC + LLD) != 0){
                         newRed[i][j] = newRed[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + LUU + LLUL + LLU + LLC + LLD);
                         newGreen[i][j] = newGreen[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + LUU + LLUL + LLU + LLC + LLD);
                         newBlue[i][j] = newBlue[i][j]/(CU + CC + CD + LU + LC + LD +  CUU + LUU + LLUL + LLU + LLC + LLD);
                    }
                }
                
                
                
                //lewy górny róg + 1 szerokość
                if (i == 1 && j == 0){
                    newRed[i][j] = (red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i+2][j]*RRC + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i+2][j]*RRC + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i+2][j]*RRC + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                    
                    if ((LC + LD + CC + CD + RC + RD  +  LDD + CDD + RDD + RRC + RRD + RRDR) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + RRC + RRD + RRDR);
                         newGreen[i][j] = newGreen[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + RRC + RRD + RRDR);
                         newBlue[i][j] = newBlue[i][j]/(LC + LD + CC + CD + RC + RD +  LDD + CDD + RDD + RRC + RRD + RRDR);
                    }                    
                }
                
                //lewy dolny róg + 1 szerokość
                if (i == 1 && j == image.getHeight() - 1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i][j-1]*CU + red[i][j]*CC + red[i+1][j-1]*RU + red[i+1][j]*RC
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i+2][j]*RRC + red[i+2][j-1]*RRU + red[i+2][j-2]*RRUR);                            
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i][j-1]*CU + green[i][j]*CC + green[i+1][j-1]*RU + green[i+1][j]*RC
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i+2][j]*RRC + green[i+2][j-1]*RRU + green[i+2][j-2]*RRUR); 
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i][j-1]*CU + blue[i][j]*CC + blue[i+1][j-1]*RU + blue[i+1][j]*RC
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i+2][j]*RRC + blue[i+2][j-1]*RRU + blue[i+2][j-2]*RRUR); 
                
                    if ((LC + LU + CC + CU + RC + RU  +  LUU + CUU + RUU + RRC + RRU + RRUR) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + RRC + RRU + RRUR);
                         newGreen[i][j] = newGreen[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + RRC + RRU + RRUR);
                         newBlue[i][j] = newBlue[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + RRC + RRU + RRUR);
                    }   
                }
                
                //prawy górny róg - 1 szerokość
                if (i == image.getWidth()-2 && j == 0){
                    newRed[i][j] = (red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                    
                    if ((LC + LD + CC + CD + RC + RD  +  LLD + CDD + RDD + LLC + LLD + LLDL) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LD + CC + CD + RC + RD +  LLD + CDD + RDD + LLC + LLD + LLDL);
                         newGreen[i][j] = newGreen[i][j]/(LC + LD + CC + CD + RC + RD +  LLD + CDD + RDD + LLC + LLD + LLDL);
                         newBlue[i][j] = newBlue[i][j]/(LC + LD + CC + CD + RC + RD +  LLD + CDD + RDD + LLC + LLD + LLDL);
                    }                    
                }
                
                //prawy dolny róg - 1 szerokość
                if (i == image.getWidth()-2 && j == image.getHeight()-1){
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i][j-1]*CU + red[i][j]*CC + red[i+1][j-1]*RU + red[i+1][j]*RC
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i-2][j]*LLC + red[i-2][j-1]*LLU + red[i-2][j-2]*LLUL);                            
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i][j-1]*CU + green[i][j]*CC + green[i+1][j-1]*RU + green[i+1][j]*RC
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i-2][j]*LLC + green[i-2][j-1]*LLU + green[i-2][j-2]*LLUL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i][j-1]*CU + blue[i][j]*CC + blue[i+1][j-1]*RU + blue[i+1][j]*RC
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i-2][j]*LLC + blue[i-2][j-1]*LLU + blue[i-2][j-2]*LLUL);
                
                    if ((LC + LU + CC + CU + RC + RU  +  LUU + CUU + RUU + LLC + LLU + LLUL) != 0){
                         newRed[i][j] = newRed[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL);
                         newGreen[i][j] = newGreen[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL);
                         newBlue[i][j] = newBlue[i][j]/(LC + LU + CC + CU + RC + RU +  LUU + CUU + RUU + LLC + LLU + LLUL);
                    }   
                }
                
                //lewa krawędź + 1 szerokość
                if (i == 1 && j >= 2 && j < image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i-1][j+2]*LDD + red[i][j-2]*CUU + red[i][j+2]*CDD + red[i+1][j-2]*RUU + red[i+1][j+2]*RDD + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i-1][j+2]*LDD + green[i][j-2]*CUU + green[i][j+2]*CDD + green[i+1][j-2]*RUU + green[i+1][j+2]*RDD + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i-1][j+2]*LDD + blue[i][j-2]*CUU + blue[i][j+2]*CDD + blue[i+1][j-2]*RUU + blue[i+1][j+2]*RDD + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                
                    if ((LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + RRUR + RRU + RRC + RRD + RRDR) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + RRUR + RRU + RRC + RRD + RRDR);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + RRUR + RRU + RRC + RRD + RRDR);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + RRUR + RRU + RRC + RRD + RRDR);
                    }
                }
                
                //prawa krawędź - 1 szerokośc
                if (i == image.getWidth()-2 && j >= 2 && j < image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i-1][j+2]*LDD + red[i][j-2]*CUU + red[i][j+2]*CDD + red[i+1][j-2]*RUU + red[i+1][j+2]*RDD
                            + red[i-2][j-2]*LLUL + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i-1][j+2]*LDD + green[i][j-2]*CUU + green[i][j+2]*CDD + green[i+1][j-2]*RUU + green[i+1][j+2]*RDD
                            + green[i-2][j-2]*LLUL + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i-1][j+2]*LDD + blue[i][j-2]*CUU + blue[i][j+2]*CDD + blue[i+1][j-2]*RUU + blue[i+1][j+2]*RDD 
                            + blue[i-2][j-2]*LLUL + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                
                    if ((LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + LLU + LLC + LLD + LLUL + LLDL) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + LLU + LLC + LLD + LLUL + LLDL);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + LLU + LLC + LLD + LLUL + LLDL);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LUU + LDD + CU + CC + CD + CUU + CDD + RU + RC + RD + RUU + RDD + LLU + LLC + LLD + LLUL + LLDL);
                    }
                }
                
                //górna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == 1) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                             + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                
                    if ((LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL + RRU + RRC + RRD + RRDR) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL + RRU + RRC + RRD + RRDR);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL + RRU + RRC + RRD + RRDR);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL + RRU + RRC + RRD + RRDR);
                    }
                }
                
                //dolna krawędź wysokość + 1
                if (i >= 2 && i < image.getWidth()-2 && j == image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD + red[i-2][j-2]*LLUL + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD + green[i-2][j-2]*LLUL + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD + blue[i-2][j-2]*LLUL + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD);
                
                    if ((LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL + RRUR + RRU + RRC + RRD) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL + RRUR + RRU + RRC + RRD);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL + RRUR + RRU + RRC + RRD);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL + RRUR + RRU + RRC + RRD);
                    }
                }
                
                //lewy górny róg -1 -1
                if (i == 1 && j == 1) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                             + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR);
                
                    if ((LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + RRU + RRC + RRD + RRDR) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + RRU + RRC + RRD + RRDR);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + RRU + RRC + RRD + RRDR);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + RRU + RRC + RRD + RRDR);
                    }
                }
                
                //prawy górny róg -1 -1
                if (i == image.getWidth() - 2 && j == 1) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j+2]*LDD + red[i][j+2]*CDD + red[i+1][j+2]*RDD
                            + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                             + green[i-1][j+2]*LDD + green[i][j+2]*CDD + green[i+1][j+2]*RDD
                            + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j+2]*LDD + blue[i][j+2]*CDD + blue[i+1][j+2]*RDD
                            + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                
                    if ((LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LDD + CU + CC + CD + CDD + RU + RC + RD + RDD + LLU + LLC + LLD + LLDL);
                    }
                }
                
                //lewy dolny róg -1 -1
                if (i == 1 && j == image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD);
                
                    if ((LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + RRUR + RRU + RRC + RRD) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + RRUR + RRU + RRC + RRD);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + RRUR + RRU + RRC + RRD);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + RRUR + RRU + RRC + RRD);
                    }
                }
                
                //prawy dolny róg -1 -1
                if (i == image.getWidth()-2 && j == image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i][j-2]*CUU + red[i+1][j-2]*RUU
                            + red[i-2][j-2]*LLUL + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i][j-2]*CUU + green[i+1][j-2]*RUU
                            + green[i-2][j-2]*LLUL + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i][j-2]*CUU + blue[i+1][j-2]*RUU
                            + blue[i-2][j-2]*LLUL + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD);
                
                    if ((LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL) != 0){
                        newRed[i][j] = newRed[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL);
                        newGreen[i][j] = newGreen[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL);
                        newBlue[i][j] =  newBlue[i][j]/(LU + LC + LD + LUU + CU + CC + CD + CUU + RU + RC + RD + RUU + LLU + LLC + LLD + LLUL);
                    }
                }
                
                
                //Srodek Start
                if (i >= 2 && i < image.getWidth()-2 && j >= 2 && j < image.getHeight()-2) {
                    newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD
                            + red[i-1][j-2]*LUU + red[i-1][j+2]*LDD + red[i][j-2]*CUU + red[i][j+2]*CDD + red[i+1][j-2]*RUU + red[i+1][j+2]*RDD + red[i+2][j-2]*RRUR + red[i+2][j-1]*RRU + red[i+2][j]*RRC
                            + red[i+2][j+1]*RRD + red[i+2][j+2]*RRDR + red[i-2][j-2]*LLUL + red[i][j-1]*LLU + red[i-2][j]*LLC + red[i-2][j+1]*LLD + red[i-2][j+2]*LLDL);
                    newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD
                            + green[i-1][j-2]*LUU + green[i-1][j+2]*LDD + green[i][j-2]*CUU + green[i][j+2]*CDD + green[i+1][j-2]*RUU + green[i+1][j+2]*RDD + green[i+2][j-2]*RRUR + green[i+2][j-1]*RRU + green[i+2][j]*RRC
                            + green[i+2][j+1]*RRD + green[i+2][j+2]*RRDR + green[i-2][j-2]*LLUL + green[i][j-1]*LLU + green[i-2][j]*LLC + green[i-2][j+1]*LLD + green[i-2][j+2]*LLDL);
                    newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD
                            + blue[i-1][j-2]*LUU + blue[i-1][j+2]*LDD + blue[i][j-2]*CUU + blue[i][j+2]*CDD + blue[i+1][j-2]*RUU + blue[i+1][j+2]*RDD + blue[i+2][j-2]*RRUR + blue[i+2][j-1]*RRU + blue[i+2][j]*RRC
                            + blue[i+2][j+1]*RRD + blue[i+2][j+2]*RRDR + blue[i-2][j-2]*LLUL + blue[i][j-1]*LLU + blue[i-2][j]*LLC + blue[i-2][j+1]*LLD + blue[i-2][j+2]*LLDL);
                
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
