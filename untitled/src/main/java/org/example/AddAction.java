package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.*;

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

            Future<IOException> exceptionFuture = new FutureTask<>(() -> {
                IOException ioException = null;
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    int lineCounter = 0;
                    while ((line = reader.readLine()) != null) {
                        lineCounter++;
                        stringBuilder.append(line).append("\n");
                        if (lineCounter == 5) {
                            throw new IOException("Пятая строка");
                        }
                        Thread.sleep(3000);
                    }
                    SwingUtilities.invokeLater(() -> textArea.setText(stringBuilder.toString()));
                } catch (IOException ex) {
                    ioException = ex;
                }
                return ioException;
            });

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit((Runnable) exceptionFuture);
            executor.shutdown();

            try {
                IOException exception = exceptionFuture.get();
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.println("Файл успешно прочитан.");
                }
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }
    }
}
