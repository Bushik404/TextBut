package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextBut extends JFrame {

    private static TextBut instance;
    private static int formCount = 0;

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
        setTitle(String.valueOf(formIndex));

        JPanel jPanel = createPanel();
        add(jPanel);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        JTextArea textArea = createTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        jPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel(textArea);
        jPanel.add(buttonPanel, BorderLayout.SOUTH);

        return jPanel;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    private JPanel createButtonPanel(JTextArea textArea) {
        JPanel buttonPanel = new JPanel();
        JButton add = createButton("Добавить");
        JButton clear = createButton("Очистить");
        JButton exit = createButton("Выход");

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
                    if (formIndex == 3) {
                        System.exit(0);
                    }
                }
            }
        });

        buttonPanel.add(add);
        buttonPanel.add(clear);
        buttonPanel.add(exit);

        return buttonPanel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        Dimension buttonSize = new Dimension(100, 30);
        button.setPreferredSize(buttonSize);
        return button;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                TextBut inst1 = getInstance();
                inst1.setVisible(true);
                inst1.init();
                TextBut inst2 = getInstance();
                inst2.setVisible(true);
                inst2.init();
                TextBut inst3 = getInstance();
                inst3.setVisible(true);
                inst3.init();
            }
        });
    }
}
