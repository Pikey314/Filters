/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import gui.MainFrame;
import gui.OptionPanel;
import guiOperations.UndoRedoOperations;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maciek P
 */

//DODAĆ własne sekwencje szablonow  - 1 przycusk wlasny filtr
//wgrywac obraz w rozdzielczosci oryginalnej
public class Filters {

     public static void main(String[] args) {
         //testowe operacje
         

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                
                MainFrame a = new MainFrame("testFrame");
                UndoRedoOperations ur = new UndoRedoOperations();
                OptionPanel b = new OptionPanel(a,ur);
                a.setMainFrame("testFrame");
                b.setBackground(Color.yellow);
                a.add(b, BorderLayout.NORTH);
                
             int args[] = new int[9];
             args[0] = 1;
             args[1] = 4;
             args[2] = 3;
             args[4] = 2;
             args[3] = 5;
             args[5] = 7;
             args[6] = 6;
             args[7] = 8;
             args[8] = 9;
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
                 for (j = 0; j < args.length; j++)
                     
               System.out.println((255.0 * Math.pow((200/255.0), (1.0/0.9))));
                
            }
        });
    }
}
    
    