/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Maciek P
 */
public class MenuBar {
    
    public JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        return menuBar;
    }
}
