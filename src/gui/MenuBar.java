/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import colorFilters.RGBFilters;
import guiOperations.FileOperations;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author Maciek P
 */
public class MenuBar {
    
    private RGBFilters rgbFilters = new RGBFilters();
    private ArrayList buttons = new ArrayList();
    private MainFrame mainFrame;
    private JTextField filename = new JTextField();
    private JTextField dir = new JTextField();
    FileOperations fileOperations = new FileOperations();
    private SideMenu sideMenu = new SideMenu();
    JPopupMenu popupMenu = new JPopupMenu("Title");
    
    public JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
            JMenuItem openFile = new JMenuItem("Open File");
            JMenuItem saveFile = new JMenuItem("Save File");
        file.add(openFile);
        file.addSeparator();
        file.add(saveFile);
            
        JMenu filters = new JMenu("Filters");
            JMenu colorFilters = new JMenu("Color Filtes");
                JMenuItem redFilter = new JMenuItem("Red Filter");
                JMenuItem greenFilter = new JMenuItem("Green Filter");
                JMenuItem blueFilter = new JMenuItem("Blue Filter");
            colorFilters.add(redFilter);
            colorFilters.add(greenFilter);
            colorFilters.add(blueFilter);
        filters.add(colorFilters);
            
        menuBar.add(file);
        menuBar.add(filters);
        
        //SET INITIAL ACCTION LISTENER START
        sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                    }
                });
        
        //SET INITIAL ACCTION LISTENER END
        
        
        
        //funkcje
        
        //for FILES START
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                fileOperations.openFile(mainFrame);
            }
        });
        
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    fileOperations.saveFile(mainFrame);
                } catch (IOException ex) {
                    Logger.getLogger(OptionPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //for FILES END
        
        
        //for FILTERS START
        blueFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "blue", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        greenFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "green", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        redFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "red", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
         //for FILTERS END
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return menuBar;
    }
    
     public void setProperMainFrame(MainFrame mF) {
        this.mainFrame = mF;
    }
}
