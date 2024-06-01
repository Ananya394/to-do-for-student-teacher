package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addtask extends JFrame implements ActionListener {
    JLabel l1,l2,tag,pri,dd;
    JTextField tl2,ttag,tpri,tdd;
    JButton add,back;
    Addtask()
    {
        l2 = new JLabel("task:");
        l2.setFont(new Font("Raleway", Font.PLAIN, 18));
        l2.setBounds(50,50,200,20);
        add(l2);

        dd = new JLabel("date:");
        dd.setFont(new Font("Raleway", Font.PLAIN, 18));
        dd.setBounds(50,80,200,20);
        add(dd);

        pri = new JLabel("pririty:");
        pri.setFont(new Font("Raleway", Font.PLAIN, 18));
        pri.setBounds(50,110,200,20);
        add(pri);

        tag = new JLabel("tag:");
        tag.setFont(new Font("Raleway", Font.PLAIN, 18));
        tag.setBounds(50,140,200,20);
        add(tag);

        tl2 = new JTextField(15);
        tl2.setBounds(100,50,200,20);
        tl2.setFont(new Font("Arial", Font.PLAIN, 20));
        tl2.setBorder(BorderFactory.createEmptyBorder());
        tl2.setBackground(Color.pink);
        add(tl2);

        tdd = new JTextField(15);
        tdd.setBounds(100,80,200,20);
        tdd.setFont(new Font("Arial", Font.PLAIN, 20));
        tdd.setBorder(BorderFactory.createEmptyBorder());
        tdd.setBackground(Color.pink);
        add(tdd);

        tpri = new JTextField(15);
        tpri.setBounds(100,110,200,20);
        tpri.setFont(new Font("Arial", Font.PLAIN, 20));
        tpri.setBorder(BorderFactory.createEmptyBorder());
        tpri.setBackground(Color.pink);
        add(tpri);

        ttag = new JTextField(15);
        ttag.setBounds(100,140,200,20);
        ttag.setFont(new Font("Arial", Font.PLAIN, 20));
        ttag.setBorder(BorderFactory.createEmptyBorder());
        ttag.setBackground(Color.pink);
        add(ttag);

        add=new JButton("add");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.setBounds(90,200,100,30);
        add(add);
        add.addActionListener(this);

        back=new JButton("back");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(210,200,100,30);
        add(back);
        back.addActionListener(this);

        setSize(400,280);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==add)
        {
            setVisible(false);
            new Addtask().setVisible(true);
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addtask().setVisible(true);
    }
}
