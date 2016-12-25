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
            
            int newRed[][] = new int[image.getWidth()-2][image.getHeight()-2];
            int newGreen[][] = new int[image.getWidth()-2][image.getHeight()-2];
            int newBlue[][] = new int[image.getWidth()-2][image.getHeight()-2];
            
        
        
        for (int i = 0; i < image.getWidth()-1; i++) {
            for (int j = 0; j < image.getHeight()-1; j++) {
                colorOfPixel = new Color(image.getRGB(i,j));
                
                
                   red[i][j] = colorOfPixel.getRed();
                   green[i][j] = colorOfPixel.getGreen();
                   blue[i][j] = colorOfPixel.getBlue();
                   
                
               // image.setRGB(j, i, new Color(red, green, blue).getRGB());
            }
        }
        
        for (int i = 1; i < image.getWidth()-2; i++) {
            for (int j = 1; j < image.getHeight()-2; j++) {
                newRed[i][j] = (red[i-1][j-1]*LU + red[i-1][j]*LC + red[i-1][j+1]*LD + red[i][j-1]*CU + red[i][j]*CC + red[i][j+1]*CD + red[i+1][j-1]*RU + red[i+1][j]*RC + red[i+1][j+1]*RD);
                newGreen[i][j] = (green[i-1][j-1]*LU + green[i-1][j]*LC + green[i-1][j+1]*LD + green[i][j-1]*CU + green[i][j]*CC + green[i][j+1]*CD + green[i+1][j-1]*RU + green[i+1][j]*RC + green[i+1][j+1]*RD);
                newBlue[i][j] = (blue[i-1][j-1]*LU + blue[i-1][j]*LC + blue[i-1][j+1]*LD + blue[i][j-1]*CU + blue[i][j]*CC + blue[i][j+1]*CD + blue[i+1][j-1]*RU + blue[i+1][j]*RC + blue[i+1][j+1]*RD);
                
                if (matrixSum != 0){
                    newRed[i][j] = newRed[i][j]/matrixSum;
                    newGreen[i][j] = newGreen[i][j]/matrixSum;
                    newBlue[i][j] =  newBlue[i][j]/matrixSum; 
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
