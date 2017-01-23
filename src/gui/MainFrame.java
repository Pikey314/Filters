/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import guiOperations.ImageOperations;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private JPanel picturePanel;
    private BufferedImage imageToSave;
    private final ImageOperations Image = new ImageOperations();
    private int applicationWidth = 800;
    private int applicationHeight = 800;

    public MainFrame(String name) {
        super(name);
    }

    public void setMainFrame(String name) {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.picturePanel = new JPanel();
        this.picturePanel.setBackground(Color.darkGray);
        this.add(this.picturePanel, BorderLayout.CENTER);
        
    }

    public void setFrameSize(int width, int height) {
        this.applicationHeight = height;
        this.applicationWidth = width;
    }

    public int getFrameWidth() {
        return this.applicationWidth;
    }

    public int getFrameHeight() {
        return this.applicationHeight;
    }

    public void insertPicture(String file) {
        this.imageToSave = Image.insertPicture(file, picturePanel);
        pack();
    }

    public void savePicture(String path) throws IOException {
        Image.savePicture(path, this.imageToSave);
    }

    public JPanel getPicturePanel(){
        return this.picturePanel;
    }
    
    public BufferedImage getImageToSave(){
        return this.imageToSave;
    }
    
    public void packFrame(){
        pack();
    }
    
    public void setImageToSave(BufferedImage img){
        this.imageToSave = img;
    }

  
}

