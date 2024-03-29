package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TextBut extends JFrame {

    public static int formCount = 1;
    private static TextBut instance;

    private TextBut() {
        init();
    }

    public static TextBut getInstance() {
        if (instance == null) {
            instance = new TextBut();

        }
        return instance;
    }
    public int getFormCount() {
        formCount++;
        return formCount;
    }
    public void init() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        jPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton add = new JButton("Добавить");
        JButton clear = new JButton("Очистить");
        JButton exit = new JButton("Выход");
        Dimension buttonSize = new Dimension(100, 30);
        add.setPreferredSize(buttonSize);
        clear.setPreferredSize(buttonSize);
        exit.setPreferredSize(buttonSize);

        add.addActionListener(new AddAction(textArea));
        clear.addActionListener(new ClearAction(textArea));

        exit.addActionListener(new ExitAction(this));
        buttonPanel.add(add);
        buttonPanel.add(clear);
        buttonPanel.add(exit);
        jPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(jPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        showWithTitle(String.valueOf(formCount));
    }

    public void showWithTitle(String title) {
        setTitle("Окно номер "+title);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getInstance();
            }
        });
    }
}
