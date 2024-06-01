package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnotherClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Choose an Option");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Select an option:");
        JButton taskCompletionButton = new JButton("Task Completion Efficiency");
        JButton messageButton = new JButton("Scheduled Dialog App");
        JButton bothButton = new JButton("Both");

        panel.add(label);
        panel.add(taskCompletionButton);
        panel.add(messageButton);
        panel.add(bothButton);

        frame.add(panel);

        taskCompletionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task gui = new Task();
                frame.dispose(); // Close the menu frame
            }
        });

        messageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message message = new Message();
                frame.dispose(); // Close the menu frame
            }
        });

        bothButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task gui = new Task();
                Message message = new Message();
                frame.dispose(); // Close the menu frame
            }
        });

        frame.setVisible(true);
    }
}