package hu.dpc.edu.mvc.impl;

import hu.dpc.edu.mvc.Default;
import hu.dpc.edu.mvc.InMemory;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vrg on 17/10/16.
 */
@org.springframework.stereotype.Component
public class SwingView implements MyView, MessageChangedListener {

    private MyModel model;
    private MyController controller;

    @Autowired
    public SwingView(@InMemory MyModel model, @Default MyController controller) {
        this.model = model;
        this.controller = controller;
    }

    private JFrame frame = new JFrame("My View");
    private JTextField messageField = new JTextField();
    private JPanel panel = new JPanel();
    private JButton saveButton = new JButton("Save");

    public void setVisible() {
        messageField.setPreferredSize(new Dimension(300,20));
        final ActionListener saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onSave(messageField.getText());
            }
        };
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.add(messageField);
        panel.add(saveButton);

        final String message = model.getMessage();
        messageField.setText(message);

        messageField.addActionListener(saveListener);
        saveButton.addActionListener(saveListener);

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

    @PostConstruct
    public void initView() {
        model.addMessageChangeListener(this);
    }
}
