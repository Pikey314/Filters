/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame
extends JFrame {
    private JPanel picturePanel;
    private BufferedImage imageToSave;
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
        this.picturePanel.setBackground(Color.orange);
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
        this.picturePanel.removeAll();
        System.out.println(file);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file));
        }
        catch (IOException e) {
        }
        
        Image dimg = img.getScaledInstance(this.picturePanel.getWidth(), this.picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        System.out.println("" + img.getWidth() + " " + img.getHeight());
        this.picturePanel.add(imageLabel);
        this.pack();
        this.imageToSave = img;
    }

    public void savePicture(String path) throws IOException {
        String extensionValidator;
        if (path.length() > 3) 
            extensionValidator = path.substring(path.length() - 4, path.length());
        else 
            extensionValidator = null;
       
        if (!extensionValidator.equals(".jpg") && !extensionValidator.equals(".png")) {
            path = path + ".jpg";
        }
        System.out.println(extensionValidator);
        System.out.println(path);
        File outputfile = new File(path);
        ImageIO.write((RenderedImage)this.imageToSave, "jpg", outputfile);
    }

    public void colorPicture() {
       
        Color colorOfPixel;
        
int alpha; 
int red;
int green;
int blue;

int argb;
        
        
        for (int i = 0; i < this.imageToSave.getHeight()-1; i++) {
            for (int j = 0; j < this.imageToSave.getWidth()-1; j++) {
                colorOfPixel = new Color(this.imageToSave.getRGB(j,i));
                
                alpha = colorOfPixel.getAlpha();
                red = colorOfPixel.getRed();
                green = colorOfPixel.getGreen()-50;
                blue = colorOfPixel.getBlue()-50;
                
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                //System.out.println("ARGB " + alpha + " " + red + " " + green + " " + blue);
                //argb = alpha << 24 + red << 16 + green << 8 + blue;
                this.imageToSave.setRGB(j, i, new Color(red, green, blue).getRGB());
            }
        }
        Image dimg = this.imageToSave.getScaledInstance(this.picturePanel.getWidth(), this.picturePanel.getHeight(), 4);
        ImageIcon pic = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(pic);
        this.picturePanel.removeAll();
        this.picturePanel.add(imageLabel);
    }
}
