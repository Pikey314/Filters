/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixes;

import javax.swing.JTextField;

/**
 *
 * @author Maciek P
 */
public class Matrixes5 {
    public static int averagingMatrix[][]   =    {{1,1,1,1,1},
                                                  {1,1,1,1,1},
                                                  {1,1,1,1,1},
                                                  {1,1,1,1,1},
                                                  {1,1,1,1,1}};
    
    public static int lP1Matrix[][]   =            {{1,1,1,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,2,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,1,1,1}};
    
    public static int lP2Matrix[][]   =            {{1,1,1,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,4,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,1,1,1}};
    
    public static int lP3Matrix[][]   =            {{1,1,1,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,12,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,1,1,1}};
    
    public static int circleMatrix[][]   =          {{0,1,1,1,0},
                                                    {1,1,1,1,1},
                                                    {1,1,1,1,1},
                                                    {1,1,1,1,1},
                                                    {0,1,1,1,0}};
    
    public static int piramideMatrix[][]   =         {{1,2,3,2,1},
                                                      {2,4,6,4,2},
                                                      {3,6,9,6,3},
                                                      {2,4,6,4,2},
                                                      {1,2,3,2,1}};
    
    public static int coneMatrix[][]   =             {{0,0,1,0,0},
                                                      {0,2,2,2,0},
                                                      {1,2,5,2,1},
                                                      {0,2,2,2,0},
                                                      {0,0,1,0,0}};
    
    
    public static int gauss2Matrix[][]   =             {{1,1,2,1,1},
                                                      {1,2,4,2,1},
                                                      {2,4,8,4,2},
                                                      {1,2,4,2,1},
                                                      {1,1,2,1,1}};
    
     public static int gauss3Matrix[][]   =             {{0,1,2,1,0},
                                                      {1,4,8,4,1},
                                                      {2,8,16,8,2},
                                                      {1,4,8,4,1},
                                                      {0,1,2,1,0}};
     
     public static int gauss4Matrix[][]   =           {{1,4,7,4,1},
                                                      {4,16,26,16,4},
                                                      {7,26,41,26,7},
                                                      {4,16,26,16,4},
                                                      {1,4,7,4,1}};
    
    public static int removeAverageMatrix[][] =     {{-1,-1,-1,-1,-1},
                                                     {-1,-1,-1,-1,-1},
                                                     {-1,-1,25,-1,-1},
                                                     {-1,-1,-1,-1,-1},
                                                     {-1,-1,-1,-1,-1}};
    
   
    
    public static int embossingNorthMatrix[][] =       {{2,2,2,2,2},
                                                        {1,1,1,1,1},
                                                        {0,0,1,0,0},
                                                        {-1,-1,-1,-1,-1},
                                                        {-2,-2,-2,-2,-2}};
    
    
    
    
    
    
    
    
    public int ownMatrix[][] =                  {{0,0,0,0,0},
                                                  {0,0,0,0,0},
                                                  {0,0,0,0,0},
                                                  {0,0,0,0,0},
                                                  {0,0,0,0,0}};
        
        
        public void setOwnMatrix(JTextField[] textFields) {
            for (int i = 0; i<25; i++) {
                if (i<5)
                    this.ownMatrix[0][i] = Integer.parseInt(textFields[i].getText());
                else if (i>=5 && i<10)
                    this.ownMatrix[1][i-5] = Integer.parseInt(textFields[i].getText());
                else if (i>=10 && i<15)
                    this.ownMatrix[2][i-10] = Integer.parseInt(textFields[i].getText());
                else if (i>=15 && i<20)
                    this.ownMatrix[3][i-15] = Integer.parseInt(textFields[i].getText());
                else
                    this.ownMatrix[4][i-20] = Integer.parseInt(textFields[i].getText());
            }
       }
        
        public int[][] getOwnMatrix(){
            return ownMatrix;
        }
}
