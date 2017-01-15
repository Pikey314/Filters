/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import colorModelFunctions.RGBModelFunctions;
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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import matrixModelFunctions.MatrixFunctions;

public class OptionPanelButtons {
    
    private RGBModelFunctions rgbFilters = new RGBModelFunctions();
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
    JButton undo = new JButton("Cofnij");
    JButton myFilter1 = new JButton("Mój filtr 3x3");
    JButton myFilter2 = new JButton("Mój filtr 5x5");
    

    public OptionPanelButtons() {
       
        
        
      
       
        JButton openFile = new JButton("Otwórz Plik");
        JButton saveFile = new JButton("Zapisz Jako");
        JButton redo = new JButton("Ponów");
        
        myFilter1.setEnabled(false);
        myFilter2.setEnabled(false);
        
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
    
        
        myFilter1.addActionListener((ActionEvent event) -> {
        });
        
        myFilter2.addActionListener((ActionEvent event) -> {
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
        this.buttons.add(openFile);
        this.buttons.add(saveFile);
        this.buttons.add(myFilter1);
        this.buttons.add(myFilter2);
        
        
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
    
    public JButton getMyFilter1() {
        return this.myFilter1;
    }
    
    public JButton getMyFilter2() {
        return this.myFilter2;
    }
    
    public void setFunctionalityForMyFilter3x3(JRadioButton jtb, BufferedImage image, JPanel picturePanel, int[][] matrix, int redValue, int greenValue, int blueValue){
        this.myFilter1.setEnabled(true);
        this.myFilter1.removeActionListener(this.myFilter1.getActionListeners()[0]);
        this.myFilter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), getUndoButton());
                if (jtb.isSelected()){
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), picturePanel, matrix, 3);
                    rgbFilters.ownRGBFilter(mainFrame.getImageToSave(), picturePanel, "ownColor", redValue, greenValue, blueValue);
                } else {
                    rgbFilters.ownRGBFilter(mainFrame.getImageToSave(), picturePanel, "ownColor", redValue, greenValue, blueValue);
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), picturePanel, matrix, 3);
                }
                
                mainFrame.revalidate();
            }
        });
    }
    
    public void setFunctionalityForMyFilter5x5(JRadioButton jtb, BufferedImage image, JPanel picturePanel, int[][] matrix, int redValue, int greenValue, int blueValue){
        
        this.myFilter2.setEnabled(true);
        this.myFilter2.removeActionListener(this.myFilter2.getActionListeners()[0]);
        this.myFilter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), getUndoButton());
                if (jtb.isSelected()){
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), picturePanel, matrix, 5);
                    rgbFilters.ownRGBFilter(mainFrame.getImageToSave(), picturePanel, "ownColor", redValue, greenValue, blueValue);
                } else {
                    rgbFilters.ownRGBFilter(mainFrame.getImageToSave(), picturePanel, "ownColor", redValue, greenValue, blueValue);
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), picturePanel, matrix, 5);
                }
                
                mainFrame.revalidate();
            }
        });
    }
}

//asadas