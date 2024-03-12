package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextBut extends JFrame{

    private static int formCount = 0;
    private int formIndex;

    public TextBut() {
        formCount++;
        formIndex = formCount;
        init();
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
        setTitle(String.valueOf(formIndex));

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formIndex <= 3) {
                    dispose();
                    formCount--;
                    if (formCount == 0) {
                        System.exit(0);
                    }
                }
            }
        });

        buttonPanel.add(add);
        buttonPanel.add(clear);
        buttonPanel.add(exit);
        jPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(jPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextBut();
                new TextBut();
                new TextBut();
            }
        });
    }
}