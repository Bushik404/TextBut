package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonAction implements ActionListener {
    private ClearButtonListener listener;

    public ClearButtonAction(ClearButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.actionPerformed(e);
        }
    }
}
