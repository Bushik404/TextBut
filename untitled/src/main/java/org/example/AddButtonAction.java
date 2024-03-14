package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonAction implements ActionListener {
    private AddButtonListener listener;

    public AddButtonAction(AddButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.actionPerformed(e);
        }
    }
}
