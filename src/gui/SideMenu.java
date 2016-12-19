/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author Maciek P
 */
public class SideMenu {
    private ChangeListener listener;
    JButton aply = new JButton("Aply");
    JSlider slider;
    JPanel sidePanel = new JPanel();
    JTextField text = new JTextField(4);
    
    
        
    public JPanel setSideMenu() {
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
       // this.sidePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 177);
        slider.setMajorTickSpacing(51);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        text.setMaximumSize(new Dimension(1000,30));
        
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setText("177");
        
        
        listener = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text.setText("" + source.getValue());
            }
         };
        
        
     
        
        this.slider.addChangeListener(listener);
        this.sidePanel.add(this.slider);
        this.sidePanel.add(text);
        this.sidePanel.add(aply);
        //this.sidePanel.setAlignmentY(SwingConstants.CENTER);
        
       
//        slider.addChangeListener((javax.swing.event.ChangeListener) this);
        return this.sidePanel;
    }
    
    public int getTextFieldValue() {
        return Integer.parseInt(this.text.getText());
    }
    
    public JButton getAcceptButton() {
        return this.aply;
    }
}

