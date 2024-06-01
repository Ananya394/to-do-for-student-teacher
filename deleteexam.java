package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deleteexam extends JFrame implements ActionListener {
    JLabel l1;
    Choice ww;
    JButton bb1,bb2;
    String P;
    deleteexam(String pin)
    {
        this.P=pin;

        l1 = new JLabel("Date:");
        l1.setFont(new Font("Raleway", Font.PLAIN, 18));
        l1.setBounds(50, 60, 100, 20);
        add(l1);

        ww=new Choice();
        ww.setBounds(155,60,150,25);
        add(ww);

        try {
            conn c8 = new conn();
            ResultSet rs = c8.s.executeQuery("select * from routine WHERE pin = '"+P+"'");
            while(rs.next()) {
                ww.add(rs.getString("dat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        bb1=new JButton("delete");
        bb1.setBackground(Color.BLACK);
        bb1.setForeground(Color.WHITE);
        bb1.setFont(new Font("Arial", Font.BOLD, 14));
        bb1.setBounds(80,110,100,30);
        add(bb1);
        bb1.addActionListener(this);

        bb2=new JButton("delete all");
        bb2.setBackground(Color.BLACK);
        bb2.setForeground(Color.WHITE);
        bb2.setFont(new Font("Arial", Font.BOLD, 14));
        bb2.setBounds(200,110,100,30);
        add(bb2);
        bb2.addActionListener(this);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setBackground(Color.lightGray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == bb1) {
            String d = (String) ww.getSelectedItem();

            try {
                conn c5 = new conn();
                c5.s.executeUpdate("delete from routine where dat='" + d + "'AND pin='" + P + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
        }
        else
        {
            try {
                conn c5 = new conn();
                c5.s.executeUpdate("delete from routine where pin='" + P + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new deleteexam("127").setVisible(true);

    }
}
