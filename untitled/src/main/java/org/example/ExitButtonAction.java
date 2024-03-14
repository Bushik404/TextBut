package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonAction implements ActionListener {
    private ExitButtonListener listener;

    public ExitButtonAction(ExitButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.actionPerformed(e);
        }
    }
}
