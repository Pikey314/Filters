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
import java.awt.EventQueue;
/**
 *
 * @author Maciek P
 */
public class Filters {

     public static void main(String[] args) {
         
        EventQueue.invokeLater(() -> {
            MainFrame a = new MainFrame("Zestaw filtrów do artystycznego przetwarzania obrazu");
            UndoRedoOperations ur = new UndoRedoOperations();
            OptionPanel b = new OptionPanel(a,ur);
            a.setMainFrame("Zestaw filtrów do artystycznego przetwarzania obrazu");
            b.setBackground(Color.darkGray);
            a.add(b, BorderLayout.NORTH);
        });
    }
}
    
    