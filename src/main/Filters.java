/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
                
                MainFrame a = new MainFrame("Zestaw filtrów do artystycznego przetwarzania obrazu");
                UndoRedoOperations ur = new UndoRedoOperations();
                OptionPanel b = new OptionPanel(a,ur);
                a.setMainFrame("testFrame");
                b.setBackground(Color.darkGray);
                a.add(b, BorderLayout.NORTH);
            }
        });
    }
}
    
    