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
import java.awt.GridLayout;
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
import javax.swing.JRadioButton;
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
    JPanel matrixPanel3x3 = new JPanel();
    JTextField textForMatrix3x3[] = new JTextField[9];
    JRadioButton matrixFirst3x3 = new JRadioButton("Matrix Filter first");
    JPanel matrixPanel5x5 = new JPanel();
    JTextField textForMatrix5x5[] = new JTextField[25];
    JRadioButton matrixFirst5x5 = new JRadioButton("Matrix Filter first");
    
    public SideMenu () {
        slider1Name.setBackground(Color.darkGray);
        slider1Name.setForeground(Color.white);
        slider1Name.setOpaque(true);
        
        slider2Name.setBackground(Color.darkGray);
        slider2Name.setForeground(Color.white);
        slider2Name.setOpaque(true);
        
        slider3Name.setBackground(Color.darkGray);
        slider3Name.setForeground(Color.white);
        slider3Name.setOpaque(true);
        
        
        
        text1.setMaximumSize(new Dimension(1000,25));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setEditable(false);
        
        text2.setMaximumSize(new Dimension(1000,25));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setEditable(false);
       
        text3.setMaximumSize(new Dimension(1000,25));
        text3.setHorizontalAlignment(SwingConstants.CENTER);
        text3.setEditable(false);
        
        buttonPanel.setBackground(Color.darkGray);
        
        aply.setPreferredSize(new Dimension(200,30));
        aply.setBackground(Color.green);
        aply.setForeground(Color.white);
        aply.setFont(new Font("Arial", Font.BOLD, 25));
        
        description.setFont(new Font("Arial", Font.BOLD, 17));
        description.setBackground(Color.darkGray);
        description.setForeground(Color.WHITE);
        description.setMargin(new Insets(10,10,10,10));
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        
        matrixFirst3x3.setBackground(Color.darkGray);
        matrixFirst3x3.setForeground(Color.white);
        
        matrixFirst5x5.setBackground(Color.darkGray);
        matrixFirst5x5.setForeground(Color.white);
        sidePanel.setBackground(Color.darkGray);
    }
    
    //USTAW POPRAWNIE KOLORYSTYKE!!!!!!!!!!!!
    //SLIDERY TAK SAMO KOLOROWAĆ w kazdej funckji
    //reszta w konstruktorze
    
    
    //slider for rgb begining = 0, end = 255, middlevalue = 177, majortTickSpacing = 51, minorTickSpacing = 1
        
    public JPanel setSideMenu1Slider(String slidername1, int begining, int end, int beginingValue, int majorTickSpacing, int minorTickSpacing, String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText(slidername1);
        //slider1Name.setBackground(Color.darkGray);
        //slider1Name.setForeground(Color.white);
        //slider1Name.setOpaque(true);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, begining, end, beginingValue);
        slider1.setMajorTickSpacing(majorTickSpacing);
        slider1.setMinorTickSpacing(minorTickSpacing);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);

        //text1.setMaximumSize(new Dimension(1000,25));
        //text1.setHorizontalAlignment(SwingConstants.CENTER);
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
        //buttonPanel.setBackground(Color.darkGray);
       // aply.setPreferredSize(new Dimension(200,30));
       // aply.setBackground(Color.green);
       // aply.setForeground(Color.white);
       // aply.setFont(new Font("Arial", Font.BOLD, 25));
       
        description.removeAll();
        description.setText(desc);

        
        this.slider1.addChangeListener(listener1);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        this.sidePanel.setBackground(Color.darkGray);
        description.revalidate();
        description.repaint();
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
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);
        
        slider2 = new JSlider(JSlider.HORIZONTAL, begining2, end2, beginingValue2);
        slider2.setMajorTickSpacing(majorTickSpacing2);
        slider2.setMinorTickSpacing(minorTickSpacing2);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setBackground(Color.darkGray);
        slider2.setForeground(Color.white);

        //text1.setMaximumSize(new Dimension(1000,30));
        //text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(beginingValue1));
        
        //text2.setMaximumSize(new Dimension(1000,30));
        //text2.setHorizontalAlignment(SwingConstants.CENTER);
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
       // buttonPanel.setBackground(Color.black);
       // aply.setPreferredSize(new Dimension(200,30));
       // aply.setBackground(Color.green);
       // aply.setForeground(Color.white);
       // aply.setFont(new Font("Arial", Font.BOLD, 25));
        
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
        description.removeAll();
        description.setText(desc);
       // description.setFont(new Font("Arial", Font.BOLD, 17));
       // description.setBackground(Color.BLACK);
       // description.setForeground(Color.WHITE);
       // description.setMargin(new Insets(10,10,10,10));
       // description.setWrapStyleWord(true);
       // description.setLineWrap(true);
        
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
        
        description.revalidate();
        description.repaint();
        return this.sidePanel;
    }
    
    public JPanel setSideMenu3Sliders(String slidername1, int begining1, int end1, int beginingValue1, int majorTickSpacing1, int minorTickSpacing1, String slidername2, int begining2, int end2, int beginingValue2, int majorTickSpacing2, int minorTickSpacing2, String slidername3, int begining3, int end3, int beginingValue3, int majorTickSpacing3, int minorTickSpacing3, String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText(slidername1);
        slider2Name.setText(slidername2);
        slider3Name.setText(slidername3);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, begining1, end1, beginingValue1);
        slider1.setMajorTickSpacing(majorTickSpacing1);
        slider1.setMinorTickSpacing(minorTickSpacing1);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);
        
        slider2 = new JSlider(JSlider.HORIZONTAL, begining2, end2, beginingValue2);
        slider2.setMajorTickSpacing(majorTickSpacing2);
        slider2.setMinorTickSpacing(minorTickSpacing2);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setBackground(Color.darkGray);
        slider2.setForeground(Color.white);
        
        slider3 = new JSlider(JSlider.HORIZONTAL, begining3, end3, beginingValue3);
        slider3.setMajorTickSpacing(majorTickSpacing3);
        slider3.setMinorTickSpacing(minorTickSpacing3);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setBackground(Color.darkGray);
        slider3.setForeground(Color.white);

        //text1.setMaximumSize(new Dimension(1000,30));
        //text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(beginingValue1));
        
        //text2.setMaximumSize(new Dimension(1000,30));
        //text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setText(Integer.toString(beginingValue2));
        
        //text3.setMaximumSize(new Dimension(1000,30));
        //text3.setHorizontalAlignment(SwingConstants.CENTER);
        text3.setText(Integer.toString(beginingValue3));
        
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
        //buttonPanel.setBackground(Color.black);
        //aply.setPreferredSize(new Dimension(200,30));
        //aply.setBackground(Color.green);
        //aply.setForeground(Color.white);
        //aply.setFont(new Font("Arial", Font.BOLD, 25));
        
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
        description.removeAll();
        description.setText(desc);
        //description.setFont(new Font("Arial", Font.BOLD, 17));
        //description.setBackground(Color.BLACK);
        //description.setForeground(Color.WHITE);
        //description.setMargin(new Insets(10,10,10,10));
        //description.setWrapStyleWord(true);
        //description.setLineWrap(true);
        
        listener3 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text3.setText("" + source.getValue());
            }
         };
        
        this.slider1.addChangeListener(listener1);
        this.slider2.addChangeListener(listener2);
        this.slider3.addChangeListener(listener3);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(slider2Name);
        this.sidePanel.add(this.slider2);
        this.sidePanel.add(text2);
        this.sidePanel.add(slider3Name);
        this.sidePanel.add(this.slider3);
        this.sidePanel.add(text3);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        description.revalidate();
        description.repaint();
        return this.sidePanel;
    }
    
    public JPanel ownFilter3x3SidePanel(String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText("Czerwony");
        slider2Name.setText("Zielony");
        slider3Name.setText("Niebieski");
        
        slider1 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider1.setMajorTickSpacing(100);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);
        
        slider2 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider2.setMajorTickSpacing(100);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setBackground(Color.darkGray);
        slider2.setForeground(Color.white);
        
        slider3 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider3.setMajorTickSpacing(100);
        slider3.setMinorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setBackground(Color.darkGray);
        slider3.setForeground(Color.white);

        //text1.setMaximumSize(new Dimension(1000,30));
        //text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(0));
        
        //text2.setMaximumSize(new Dimension(1000,30));
        //text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setText(Integer.toString(0));
        
        //text3.setMaximumSize(new Dimension(1000,30));
       // text3.setHorizontalAlignment(SwingConstants.CENTER);
        text3.setText(Integer.toString(0));
        
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
        //buttonPanel.setBackground(Color.black);
        //aply.setPreferredSize(new Dimension(200,30));
        //aply.setBackground(Color.green);
        //aply.setForeground(Color.white);
        //aply.setFont(new Font("Arial", Font.BOLD, 25));
        
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
        description.removeAll();
        description.setText(desc);
        //description.setFont(new Font("Arial", Font.BOLD, 17));
       // description.setBackground(Color.BLACK);
       // description.setForeground(Color.WHITE);
       // description.setMargin(new Insets(10,10,10,10));
       // description.setWrapStyleWord(true);
       // description.setLineWrap(true);
        
        listener3 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text3.setText("" + source.getValue());
            }
         };
        
        JTextField text00 = new JTextField(3);  this.textForMatrix3x3[0] = text00;
        JTextField text01 = new JTextField(3);  this.textForMatrix3x3[1] = text01;
        JTextField text02 = new JTextField(3);  this.textForMatrix3x3[2] = text02;
        JTextField text10 = new JTextField(3);  this.textForMatrix3x3[3] = text10;
        JTextField text11 = new JTextField(3);  this.textForMatrix3x3[4] = text11;
        JTextField text12 = new JTextField(3);  this.textForMatrix3x3[5] = text12;
        JTextField text20 = new JTextField(3);  this.textForMatrix3x3[6] = text20;
        JTextField text21 = new JTextField(3);  this.textForMatrix3x3[7] = text21;
        JTextField text22 = new JTextField(3);  this.textForMatrix3x3[8] = text22;
        
        this.matrixPanel3x3.setLayout(new GridLayout(3,3));
        
        JLabel matrixDesc = new JLabel();
        matrixDesc.setText("Macierz dla filtru");
        
        this.matrixPanel3x3.removeAll();
        for(int i = 0; i<9; i++){
            this.textForMatrix3x3[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.textForMatrix3x3[i].setText(Integer.toString(0));
            this.textForMatrix3x3[i].setPreferredSize(new Dimension(30,30));
            this.matrixPanel3x3.add(textForMatrix3x3[i]);
        }
        
        this.slider1.addChangeListener(listener1);
        this.slider2.addChangeListener(listener2);
        this.slider3.addChangeListener(listener3);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(slider2Name);
        this.sidePanel.add(this.slider2);
        this.sidePanel.add(text2);
        this.sidePanel.add(slider3Name);
        this.sidePanel.add(this.slider3);
        this.sidePanel.add(text3);
        this.sidePanel.add(matrixDesc);
        this.sidePanel.add(this.matrixPanel3x3);
        this.sidePanel.add(matrixFirst3x3);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        description.revalidate();
        description.repaint();
        return this.sidePanel;
    }
    
    public JPanel setEmptySideMenu(String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        
        
        buttonPanel.add(aply);
       // buttonPanel.setBackground(Color.darkGray);
       // aply.setPreferredSize(new Dimension(200,30));
       // aply.setBackground(Color.green);
      //  aply.setForeground(Color.white);
      //  aply.setFont(new Font("Arial", Font.BOLD, 25));
       
        //description.remove
        description.removeAll();
        description.setText(desc);
       // description.setFont(new Font("Arial", Font.BOLD, 17));
       // description.setBackground(Color.darkGray);
        //description.setForeground(Color.WHITE);
       // description.setMargin(new Insets(10,10,10,10));
       // description.setWrapStyleWord(true);
       // description.setLineWrap(true);
       // 
       
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
       // this.sidePanel.setBackground(Color.darkGray);
        description.revalidate();
        description.repaint();
        return this.sidePanel;
    }
    
    
    public JPanel ownFilter5x5SidePanel(String desc) {
        
        this.sidePanel.removeAll();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));
        
        slider1Name.setText("Czerwony");
        slider2Name.setText("Zielony");
        slider3Name.setText("Niebieski");
        
        slider1 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider1.setMajorTickSpacing(100);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setBackground(Color.darkGray);
        slider1.setForeground(Color.white);
        
        
        slider2 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider2.setMajorTickSpacing(100);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setBackground(Color.darkGray);
        slider2.setForeground(Color.white);
        
        slider3 = new JSlider(JSlider.HORIZONTAL, -255, 255, 0);
        slider3.setMajorTickSpacing(100);
        slider3.setMinorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setBackground(Color.darkGray);
        slider3.setForeground(Color.white);

        //text1.setMaximumSize(new Dimension(1000,30));
       // text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setText(Integer.toString(0));
        
       // text2.setMaximumSize(new Dimension(1000,30));
       // text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setText(Integer.toString(0));
        
       // text3.setMaximumSize(new Dimension(1000,30));
       // text3.setHorizontalAlignment(SwingConstants.CENTER);
        text3.setText(Integer.toString(0));
        
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
       // buttonPanel.setBackground(Color.black);
       // aply.setPreferredSize(new Dimension(200,30));
       // aply.setBackground(Color.green);
       // aply.setForeground(Color.white);
       // aply.setFont(new Font("Arial", Font.BOLD, 25));
        
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
        description.removeAll();
        description.setText(desc);
       // description.setFont(new Font("Arial", Font.BOLD, 17));
       // description.setBackground(Color.BLACK);
       // description.setForeground(Color.WHITE);
       // description.setMargin(new Insets(10,10,10,10));
       // description.setWrapStyleWord(true);
       // description.setLineWrap(true);
        
        listener3 = new ChangeListener()
         {
            @Override
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               text3.setText("" + source.getValue());
            }
         };
        
        JTextField text00 = new JTextField(3);  this.textForMatrix5x5[0] = text00;
        JTextField text01 = new JTextField(3);  this.textForMatrix5x5[1] = text01;
        JTextField text02 = new JTextField(3);  this.textForMatrix5x5[2] = text02;
        JTextField text03 = new JTextField(3);  this.textForMatrix5x5[3] = text03;
        JTextField text04 = new JTextField(3);  this.textForMatrix5x5[4] = text04;
        
        JTextField text10 = new JTextField(3);  this.textForMatrix5x5[5] = text10;
        JTextField text11 = new JTextField(3);  this.textForMatrix5x5[6] = text11;
        JTextField text12 = new JTextField(3);  this.textForMatrix5x5[7] = text12;
        JTextField text13 = new JTextField(3);  this.textForMatrix5x5[8] = text13;
        JTextField text14 = new JTextField(3);  this.textForMatrix5x5[9] = text14;
        
        JTextField text20 = new JTextField(3);  this.textForMatrix5x5[10] = text20;
        JTextField text21 = new JTextField(3);  this.textForMatrix5x5[11] = text21;
        JTextField text22 = new JTextField(3);  this.textForMatrix5x5[12] = text22;
        JTextField text23 = new JTextField(3);  this.textForMatrix5x5[13] = text23;
        JTextField text24 = new JTextField(3);  this.textForMatrix5x5[14] = text24;
        
        JTextField text30 = new JTextField(3);  this.textForMatrix5x5[15] = text30;
        JTextField text31 = new JTextField(3);  this.textForMatrix5x5[16] = text31;
        JTextField text32 = new JTextField(3);  this.textForMatrix5x5[17] = text32;
        JTextField text33 = new JTextField(3);  this.textForMatrix5x5[18] = text33;
        JTextField text34 = new JTextField(3);  this.textForMatrix5x5[19] = text34;
        
        JTextField text40 = new JTextField(3);  this.textForMatrix5x5[20] = text40;
        JTextField text41 = new JTextField(3);  this.textForMatrix5x5[21] = text41;
        JTextField text42 = new JTextField(3);  this.textForMatrix5x5[22] = text42;
        JTextField text43 = new JTextField(3);  this.textForMatrix5x5[23] = text43;
        JTextField text44 = new JTextField(3);  this.textForMatrix5x5[24] = text44;
        
        
        this.matrixPanel5x5.setLayout(new GridLayout(5,5));
        
        JLabel matrixDesc = new JLabel();
        matrixDesc.setText("Macierz dla filtru");
        
        this.matrixPanel5x5.removeAll();
        for(int i = 0; i<25; i++){
            this.textForMatrix5x5[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.textForMatrix5x5[i].setText(Integer.toString(0));
            this.textForMatrix5x5[i].setPreferredSize(new Dimension(30,30));
            this.matrixPanel5x5.add(textForMatrix5x5[i]);
        }
        
        this.slider1.addChangeListener(listener1);
        this.slider2.addChangeListener(listener2);
        this.slider3.addChangeListener(listener3);
        this.sidePanel.add(slider1Name);
        this.sidePanel.add(this.slider1);
        this.sidePanel.add(text1);
        this.sidePanel.add(slider2Name);
        this.sidePanel.add(this.slider2);
        this.sidePanel.add(text2);
        this.sidePanel.add(slider3Name);
        this.sidePanel.add(this.slider3);
        this.sidePanel.add(text3);
        this.sidePanel.add(matrixDesc);
        this.sidePanel.add(this.matrixPanel5x5);
        this.sidePanel.add(matrixFirst5x5);
        this.sidePanel.add(description);
        this.sidePanel.add(buttonPanel);
        
        description.revalidate();
        description.repaint();
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
    
    public JTextField[] getOwnMatrix3x3() {
        return this.textForMatrix3x3;
    }
    
    public JTextField[] getOwnMatrix5x5() {
        return this.textForMatrix5x5;
    }
    
    public JButton getAcceptButton() {
        return this.aply;
    }
    
    public JRadioButton getMatrixFirst3x3Button() {
        return this.matrixFirst3x3;
    }
    
    public JRadioButton getMatrixFirst5x5Button() {
        return this.matrixFirst5x5;
    }
}

