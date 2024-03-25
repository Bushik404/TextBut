package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class AddAction implements ActionListener {
    private JTextArea textArea;

    public AddAction(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                reader.close();
                textArea.setText(stringBuilder.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
