/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import gui.MainFrame;
import gui.OptionPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;
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

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                
                MainFrame a = new MainFrame("testFrame");
                OptionPanel b = new OptionPanel(a);
                a.setMainFrame("testFrame");
                b.setBackground(Color.yellow);
                a.add(b, BorderLayout.NORTH);
                
            }
        });
    }
}
    
    