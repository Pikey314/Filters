/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiOperations;

import gui.MainFrame;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOperations {
    private JTextField filename = new JTextField();
    private JTextField dir = new JTextField();

    public void openFile(MainFrame mainFrame) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        int flag = fileChooser.showOpenDialog(mainFrame);
        if (flag == JFileChooser.APPROVE_OPTION) {
            this.filename.setText(fileChooser.getSelectedFile().getName());
            this.dir.setText(fileChooser.getCurrentDirectory().toString());
            String filePath = this.dir.getText() + "\\" + this.filename.getText();
            for (int i = 0; i < filePath.length(); ++i) {
                if (filePath.charAt(i) == '\\') {
                    filePath = filePath.substring(0, i) + "\\" + filePath.substring(i, filePath.length());
                    ++i;
                }
            }
            mainFrame.insertPicture(filePath);
        }
        if (flag == JFileChooser.CANCEL_OPTION) {
            this.filename.setText("You pressed cancel");
            this.dir.setText("");
        }
    }

    public void saveFile(MainFrame mainFrame) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(mainFrame);
        if (userSelection == 0) {
            String fileToSave = fileChooser.getSelectedFile().toString();
            for (int i = 0; i < fileToSave.length(); ++i) {
                if (fileToSave.charAt(i) == '\\') {
                fileToSave = fileToSave.substring(0, i) + "\\" + fileToSave.substring(i, fileToSave.length());
                ++i;
                }
            }
            System.out.println(fileToSave);
            mainFrame.savePicture(fileToSave);
        }
    }
}