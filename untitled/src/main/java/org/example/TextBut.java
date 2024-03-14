package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextBut extends JFrame {

    public static int formCount = 1;
    private static TextBut instance;

    private int formIndex;

    private TextBut() {
        formIndex = ++formCount;
        init();
    }

    public static synchronized TextBut getInstance() {
        if (instance == null) {
            instance = new TextBut();
        }
        return instance;
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

        clear.addActionListener(new ClearButtonAction(new ClearButtonListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        }));

        exit.addActionListener(new ExitButtonAction(new ExitButtonListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formCount <= 3) {
                    setVisible(false);
                    setTitle(String.valueOf(formCount));
                    openNewWindow();
                    setVisible(true);
                } else {
                    dispose();
                }
            }
        }));

        buttonPanel.add(add);
        buttonPanel.add(clear);
        buttonPanel.add(exit);
        jPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(jPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        setVisible(true);
    }

    public void openNewWindow() {
        getInstance();
        formCount++;
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
