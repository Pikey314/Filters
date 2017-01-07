/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author Maciek P
 */
public class SideMenu {
    private ChangeListener listener1;
    private ChangeListener listener2;
    private ChangeListener listener3;
    JLabel slider1Name = new JLabel();
    JLabel slider2Name = new JLabel();
    JLabel slider3Name = new JLabel();
    JSlider slider1;
    JSlider slider2;
    JSlider slider3;
    JTextField text1 = new JTextField(4);
    JTextField text2 = new JTextField(4);
    JTextField text3 = new JTextField(4);
    JPanel sidePanel = new JPanel();
    JTextArea description = new JTextArea();
    JPanel buttonPanel = new JPanel();
    JButton aply = new JButton("Zastosuj");
    
    //slider for rgb begining = 0, end = 255, middlevalue = 177, majortTickSpacing = 51, minorTickSpacing = 1
        
    public JPanel setSideMenu1Slider(String slidername1, int begining, int end, int beginingValue, int majorTickSpacing, int minorTickSpacing, String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText(slidername1);
        slider1Name.setBackground(Color.darkGray);
        slider1Name.setForeground(Color.white);
        slider1Name.setOpaque(true);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, begining, end, beginingValue);
        slider1.setMajorTickSpacing(majorTickSpacing);
        slider1.setMinorTickSpacing(minorTickSpacing);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);

        text1.setMaximumSize(new Dimension(1000,25));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(beginingValue));
        
        listener1 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text1.setText("" + source.getValue());
            }
         };
        
        
        
        buttonPanel.add(aply);
        buttonPanel.setBackground(Color.darkGray);
        aply.setPreferredSize(new Dimension(200,30));
        aply.setBackground(Color.green);
        aply.setForeground(Color.white);
        aply.setFont(new Font("Arial", Font.BOLD, 25));
       
       
        description.setText(desc);
        description.setFont(new Font("Arial", Font.BOLD, 17));
        description.setBackground(Color.darkGray);
        description.setForeground(Color.WHITE);
        description.setMargin(new Insets(10,10,10,10));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        
        this.slider1.addChangeListener(listener1);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        this.sidePanel.setBackground(Color.darkGray);
        return this.sidePanel;
    }
    
    
    public JPanel setSideMenu2Sliders(String slidername1, int begining1, int end1, int beginingValue1, int majorTickSpacing1, int minorTickSpacing1, String slidername2, int begining2, int end2, int beginingValue2, int majorTickSpacing2, int minorTickSpacing2, String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText(slidername1);
        slider2Name.setText(slidername2);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, begining1, end1, beginingValue1);
        slider1.setMajorTickSpacing(majorTickSpacing1);
        slider1.setMinorTickSpacing(minorTickSpacing1);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        
        slider2 = new JSlider(JSlider.HORIZONTAL, begining2, end2, beginingValue2);
        slider2.setMajorTickSpacing(majorTickSpacing2);
        slider2.setMinorTickSpacing(minorTickSpacing2);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);

        text1.setMaximumSize(new Dimension(1000,30));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(beginingValue1));
        
        text2.setMaximumSize(new Dimension(1000,30));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setText(Integer.toString(beginingValue2));
        
        listener1 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text1.setText("" + source.getValue());
            }
         };
        
        buttonPanel.add(aply);
        buttonPanel.setBackground(Color.black);
        aply.setPreferredSize(new Dimension(200,30));
        aply.setBackground(Color.green);
        aply.setForeground(Color.white);
        aply.setFont(new Font("Arial", Font.BOLD, 25));
        
        listener2 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text2.setText("" + source.getValue());
            }
         };
        description.setText(desc);
        description.setFont(new Font("Arial", Font.BOLD, 17));
        description.setBackground(Color.BLACK);
        description.setForeground(Color.WHITE);
        description.setMargin(new Insets(10,10,10,10));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        
        this.slider1.addChangeListener(listener1);
        this.slider2.addChangeListener(listener2);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(slider2Name);
        this.sidePanel.add(this.slider2);
        this.sidePanel.add(text2);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        return this.sidePanel;
    }
    
    public int getTextField1Value() {
        return Integer.parseInt(this.text1.getText());
    }
    
    public int getTextField2Value() {
        return Integer.parseInt(this.text2.getText());
    }
    
    public int getTextField3Value() {
        return Integer.parseInt(this.text3.getText());
    }
    
    public JButton getAcceptButton() {
        return this.aply;
    }
}

