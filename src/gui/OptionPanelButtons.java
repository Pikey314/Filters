/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.MainFrame;
import gui.OptionPanelButtons;
import guiOperations.FileOperations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OptionPanelButtons {
    private ArrayList buttons = new ArrayList();
    private MainFrame mainFrame;
    private JTextField filename = new JTextField();
    private JTextField dir = new JTextField();
    FileOperations fileOperations = new FileOperations();

    public OptionPanelButtons() {
        JButton undo = new JButton("undo");
        JButton openFile = new JButton("Open File");
        JButton saveFile = new JButton("Save File");
      
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mainFrame.colorPicture();
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
        this.buttons.add(openFile);
        this.buttons.add(saveFile);
    }

    public ArrayList<JButton> getButtons() {
        return this.buttons;
    }

    public void setProperMainFrame(MainFrame mF) {
        this.mainFrame = mF;
    }

}

//asadas