/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiOperations;

import gui.MainFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Maciek P
 */
public class UndoRedoOperations {
    private final BufferedImage[] undoImages;
    //private final BufferedImage[] redoImages; old redo
    private BufferedImage redoImage;
    private MainFrame mainFrame;
    
    
    public UndoRedoOperations(){
        this.undoImages = new BufferedImage[3];
        this.redoImage = null;
        //this.redoImages = new BufferedImage[3]; old redo
        for(int i = 0; i<3; i++){
            this.undoImages[i] = null;
           // this.redoImages[i] = null; old redo
        }
    }
    
    public void addToUndoList(BufferedImage currentImage, JButton undo){
        ColorModel cm = currentImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = currentImage.copyData(null);
        BufferedImage currentImage1 = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        if(this.undoImages[1] != null && this.undoImages[0] != null) {
            System.out.println("U1");
            this.undoImages[2] = this.undoImages[1];
            this.undoImages[1] = this.undoImages[0];
            this.undoImages[0] = currentImage1;
        }
        if (this.undoImages[0] != null && this.undoImages[1] == null && this.undoImages[2] == null){
            System.out.println("U2");
            this.undoImages[1] = this.undoImages[0];
            this.undoImages[0] = currentImage1;
        }
        if (this.undoImages[0] == null && this.undoImages[1] == null && this.undoImages[2] == null) {
            System.out.println("U3");
            this.undoImages[0] = currentImage1;
        }
        undo.setEnabled(true);
    }
    
    public void addToRedoList(BufferedImage currentImage){
        ColorModel cm = currentImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = currentImage.copyData(null);
        BufferedImage currentImage1 = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        this.redoImage = currentImage1;
        /*if(this.redoImages[1] != null && this.redoImages[0] != null) {
            this.redoImages[2] = this.redoImages[1];
            this.redoImages[1] = this.redoImages[0];
            this.redoImages[0] = currentImage1;
        }
        if (this.redoImages[0] != null && this.redoImages[1] == null && this.redoImages[2] == null){
            this.redoImages[1] = this.redoImages[0];
            this.redoImages[0] = currentImage1;
        }
        if (this.redoImages[0] == null && this.redoImages[1] == null && this.redoImages[2] == null) {
            this.redoImages[0] = currentImage1;
        }  old redo*/
    }
        
        
    public void undo(BufferedImage currentImage, JButton redo, JButton undo){
        if (this.undoImages[0] != null){
            
            
             Image dimg = this.undoImages[0].getScaledInstance(mainFrame.getPicturePanel().getWidth(), mainFrame.getPicturePanel().getHeight(), 4);
             ImageIcon pic = new ImageIcon(dimg);
             JLabel imageLabel = new JLabel(pic);
             mainFrame.getPicturePanel().removeAll();
             mainFrame.getPicturePanel().add(imageLabel);
             mainFrame.revalidate();
             
             mainFrame.setImageToSave(this.undoImages[0]);
            
            
            
            addToRedoList(currentImage);
            this.undoImages[0] = null;
            if (this.undoImages[1] != null && this.undoImages[2] == null) {
                this.undoImages[0] = this.undoImages[1];
                this.undoImages[1] = null;
            }
            if (this.undoImages[1] != null && this.undoImages[2] != null) {
                this.undoImages[0] = this.undoImages[1];
                this.undoImages[1] = this.undoImages[2];
                this.undoImages[2] = null;
            }
            
         redo.setEnabled(true);
         if(this.undoImages[0] == null && this.undoImages[1] == null && this.undoImages[2] == null)
             undo.setEnabled(false);
        }
        else {
            System.out.println("Can't do Undo");
        }
        
        
        }
        
        
        
        public void redo(BufferedImage currentImage, JButton undo){
        if (this.redoImage != null){
            
            Image dimg = this.redoImage.getScaledInstance(mainFrame.getPicturePanel().getWidth(), mainFrame.getPicturePanel().getHeight(), 4);
             ImageIcon pic = new ImageIcon(dimg);
             JLabel imageLabel = new JLabel(pic);
             mainFrame.getPicturePanel().removeAll();
             mainFrame.getPicturePanel().add(imageLabel);
             mainFrame.revalidate();
             
             mainFrame.setImageToSave(this.redoImage);
             
            addToUndoList(currentImage, undo);
            mainFrame.setImageToSave(this.redoImage);
            
            this.redoImage = null;
            undo.setEnabled(true);
            /*
            if (this.redoImages[1] != null && this.redoImages[2] == null) {
                this.redoImages[0] = this.redoImages[1];
                this.redoImages[1] = null;
            }
            if (this.redoImages[1] != null && this.redoImages[2] != null) {
                this.redoImages[0] = this.redoImages[1];
                this.redoImages[1] = this.redoImages[2];
                this.redoImages[2] = null;
            }old redo */
            
            
        }
        else {
            System.out.println("Can't do Redo");
        }
        
        
        }
        
        public void setProperMainFrame(MainFrame mF) {
        this.mainFrame = mF;
    }
}
