    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import guiOperations.UndoRedoOperations;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
    private final OptionPanelButtons buttons = new OptionPanelButtons();
    private final MenuBar menu = new MenuBar();
    private final JPanel buttonPanel = new JPanel();

    public OptionPanel(MainFrame mF, UndoRedoOperations ur) {
        buttonPanel.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.buttons.setProperMainFrame(mF);
        this.menu.setProperMainFrame(mF);
        this.buttons.setProperUndoRedo(ur);
        this.menu.setProperUndoRedo(ur);
        this.menu.setProperOptionPanelButtons(buttons);
        int numberOfButtons = this.buttons.getButtons().size();
        this.add(menu.setMenuBar(), BorderLayout.NORTH);
        for (int i = 0; i < numberOfButtons; ++i) {
            this.buttonPanel.add(this.buttons.getButtons().get(i));
        this.add(this.buttonPanel, BorderLayout.CENTER);
        }
    }
}