package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAction implements ActionListener {
    private TextBut textBut;
    private String title;
    public ExitAction(TextBut textBut){
        this.textBut= textBut;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int formCount = textBut.getFormCount();
        if (formCount <= 3) {
            textBut.setVisible(false);
            textBut.showWithTitle(String.valueOf(formCount));
        } else {
            textBut.dispose();
        }
    }
}
