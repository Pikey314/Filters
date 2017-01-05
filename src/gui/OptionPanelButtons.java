/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import colorFilters.RGBFilters;
import gui.MainFrame;
import gui.OptionPanelButtons;
import guiOperations.FileOperations;
import guiOperations.UndoRedoOperations;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import matrixManiFunctions.MatrixFunctions;

public class OptionPanelButtons {
    
    private RGBFilters rgbFilters = new RGBFilters();
    private ArrayList buttons = new ArrayList();
    private MatrixFunctions matrixFunction = new MatrixFunctions();
    private MainFrame mainFrame;
    UndoRedoOperations undoRedo;
    private JTextField filename = new JTextField();
    private JTextField dir = new JTextField();
    FileOperations fileOperations = new FileOperations();
    private SideMenu sideMenu = new SideMenu();
    JPopupMenu popupMenu = new JPopupMenu("Title");
    int[] rgbArray;
    JButton undo = new JButton("undo");

    public OptionPanelButtons() {
       
        

      
        JButton RGB = new JButton("RGB");
        JButton red = new JButton("red");
        JButton openFile = new JButton("Open File");
        JButton saveFile = new JButton("Save File");
        JButton green = new JButton("green");
        JButton test = new JButton("test");
        //JButton undo = new JButton("undo");
        JButton redo = new JButton("redo");
        
        redo.setEnabled(false);
        undo.setEnabled(false);
         int a[][] = {{1,0,-1},
                     {1,0,-1},
                     {1,0,-1}};
        
        
    //   RGB.setComponentPopupMenu(popupMenu);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
             undoRedo.setProperMainFrame(mainFrame);
              undoRedo.undo(mainFrame.getImageToSave(), redo, undo);
            }
        });
        
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                undoRedo.setProperMainFrame(mainFrame);
              undoRedo.redo(mainFrame.getImageToSave(), undo);
              redo.setEnabled(false);
            }
        });
    
        
        /*test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), a, 3);
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });*/
        
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               //rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "green");
               mainFrame.revalidate();
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               //rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "red");
               mainFrame.revalidate();
            }
        });
        
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
        
        
        
        
        this.buttons.add(undo);
        this.buttons.add(redo);
        this.buttons.add(RGB);
        this.buttons.add(openFile);
        this.buttons.add(saveFile);
        this.buttons.add(red);
        this.buttons.add(green);
        this.buttons.add(test);
        
    }
    
    public JButton getUndoButton() {
        return this.undo;
    }

    public ArrayList<JButton> getButtons() {
        return this.buttons;
    }

    public void setProperMainFrame(MainFrame mF) {
        this.mainFrame = mF;
    }
    public void setProperUndoRedo(UndoRedoOperations ur) {
        this.undoRedo = ur;
    }

}

//asadas