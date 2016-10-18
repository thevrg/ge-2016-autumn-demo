package hu.dpc.edu;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vrg on 17/10/16.
 */
public class SwingView implements MyView, MessageChangedListener {

    private MyModel model;
    private MyController controller;

    public SwingView(MyModel model, MyController controller) {
        this.model = model;
        this.controller = controller;
    }

    private JFrame frame = new JFrame("My View");
    private JTextField messageField = new JTextField();
    private JPanel panel = new JPanel();
    private JButton saveButton = new JButton("Save");

    public void setVisible() {
        messageField.setPreferredSize(new Dimension(300,20));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.add(messageField);
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onSave(messageField.getText());
            }
        });

        final String message = model.getMessage();
        messageField.setText(message);

        frame.pack();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public void handleMessageChangedEvent(final MessageChangedEvent event) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                messageField.setText(event.getNewMessage());
            }
        });

    }
}
