    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import javax.swing.JPanel;

public class OptionPanel extends JPanel {
    private final OptionPanelButtons buttons = new OptionPanelButtons();
    private int optionPanelWidth;
    private int optionPanelHeight;

    public OptionPanel(MainFrame mF) {
        this.buttons.setProperMainFrame(mF);
        int numberOfButtons = this.buttons.getButtons().size();
        for (int i = 0; i < numberOfButtons; ++i) {
            this.add(this.buttons.getButtons().get(i));
        }
    }
}