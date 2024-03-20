package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAction implements ActionListener {
    private TextBut textBut;
    public ExitAction(TextBut textBut){
        this.textBut= textBut;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int formCount = textBut.getFormCount();
        if (formCount < 2) {
            textBut.setVisible(false);
            textBut.setTitle(String.valueOf(formCount));
            textBut.openNewWindow();
            textBut.setVisible(true);
        } else {
            textBut.dispose();
        }
    }
}
