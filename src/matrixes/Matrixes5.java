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
           System.out.println(this.ownMatrix[0][0] + " " + this.ownMatrix[0][1] + " " + this.ownMatrix[0][2] + " " + this.ownMatrix[0][3] + " " + this.ownMatrix[0][4]  );
           System.out.println(this.ownMatrix[1][0] + " " + this.ownMatrix[1][1] + " " + this.ownMatrix[1][2] + " " + this.ownMatrix[1][3] + " " + this.ownMatrix[1][4]  );
           System.out.println(this.ownMatrix[2][0] + " " + this.ownMatrix[2][1] + " " + this.ownMatrix[2][2] + " " + this.ownMatrix[2][3] + " " + this.ownMatrix[2][4]  );
           System.out.println(this.ownMatrix[3][0] + " " + this.ownMatrix[3][1] + " " + this.ownMatrix[3][2] + " " + this.ownMatrix[3][3] + " " + this.ownMatrix[3][4]  );
           System.out.println(this.ownMatrix[4][0] + " " + this.ownMatrix[4][1] + " " + this.ownMatrix[4][2] + " " + this.ownMatrix[4][3] + " " + this.ownMatrix[4][4]  );
        }
        
        public int[][] getOwnMatrix(){
            return ownMatrix;
        }
}
