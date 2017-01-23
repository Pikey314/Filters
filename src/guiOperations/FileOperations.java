/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiOperations;

import gui.MainFrame;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOperations {
    private final JTextField filename = new JTextField();
    private final JTextField dir = new JTextField();

    public void openFile(MainFrame mainFrame) {
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa Pliku");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ Pliku");
        UIManager.put("FileChooser.openButtonText", "Otwórz");
        UIManager.put("FileChooser.cancelButtonText", "Anuluj");
        UIManager.put("FileChooser.lookInLabelText", "Szukaj w");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Wszystkie pliki");
        JFileChooser fileChooser = new JFileChooser();


        fileChooser.setDialogTitle("Wybierz plik graficzny");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki graficzne", "jpg", "png", "gif", "jpeg", "bmp");
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
            this.filename.setText("Wcisnąłeś 'Cancel'");
            this.dir.setText("");
        }
    }

    public void saveFile(MainFrame mainFrame) throws IOException {
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa Pliku");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ Pliku");
        UIManager.put("FileChooser.saveButtonText", "Zapisz");
        UIManager.put("FileChooser.cancelButtonText", "Anuluj");
        UIManager.put("FileChooser.saveInLabelText", "Szukaj w");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Wszystkie pliki");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wybierz miejsce do zapisu pliku");
        int userSelection = fileChooser.showSaveDialog(mainFrame);
        if (userSelection == 0) {
            String fileToSave = fileChooser.getSelectedFile().toString();
            for (int i = 0; i < fileToSave.length(); ++i) {
                if (fileToSave.charAt(i) == '\\') {
                fileToSave = fileToSave.substring(0, i) + "\\" + fileToSave.substring(i, fileToSave.length());
                ++i;
                }
            }
            mainFrame.savePicture(fileToSave);
        }
    }
}