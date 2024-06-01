package javaproject;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class taskpanel extends JPanel {
    JLabel index;
    JTextField taskName;
    JButton edit,remove ;// "Edit" button
    JButton done; // "Done" button

    Color pink = new Color(249, 161, 161);
    Color green = new Color(188, 226, 158);
    Color doneColor = new Color(233, 119, 119);

    private boolean checked;

    public taskpanel() {
        this.setPreferredSize(new Dimension(400, 20)); // set size of task
        this.setBackground(pink); // set background color of task

        //this.setLayout(new GridLayout(0,5,4,10)); // set layout of task
        setLayout(null);

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        index.setBounds(10,5,20,20);
        this.add(index);

        taskName = new JTextField("Write something..");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBounds(30,5,300,20);
        taskName.setBackground(pink);

        edit = new JButton("Edit"); // "Edit" button
        edit.setPreferredSize(new Dimension(80, 15));
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setBounds(500,5,30,20);
        edit.setBackground(doneColor);
        edit.setFocusPainted(false);
        this.add(edit);

        remove = new JButton("remove"); // "Edit" button
        remove.setPreferredSize(new Dimension(80, 15));
        remove.setBorder(BorderFactory.createEmptyBorder());
        remove.setBackground(doneColor);
        remove.setBounds(535,5,50,20);
        remove.setFocusPainted(false);
        this.add(remove);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(80, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setBackground(doneColor);
        done.setBounds(590,5,50,20);
        done.setFocusPainted(false);
        this.add(done, BorderLayout.EAST);
        this.add(taskName);
    }
    public void changeIndex(int num) {
        this.index.setText(num + ""); // num to String
        this.revalidate(); // refresh
    }

    public JButton getDone() {
        return done;
    }

    public JButton getremove(){
        return remove;
    }

    public JButton getEdit(){
        return edit;
    }
    public boolean getState() {
        return checked;
    }

    public void changeState() {
        this.setBackground(green);
        taskName.setBackground(green);
        checked = true;
        revalidate();
    }
}
