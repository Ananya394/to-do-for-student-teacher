package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addmeeting extends JFrame implements ActionListener {
    String P;
    JLabel aa1,aa2,aa3,aa4,aa5,aa6;
    JTextField tt1,tt2,tt3,tt4;
    JButton jb1,jb2;
    addmeeting(String pin){
        this.P=pin;

        aa1=new JLabel("TOPIC");
        aa1.setBounds(40,100,120,25);
        aa1.setFont(new Font("serif",Font.PLAIN,18));
        add(aa1);

        tt3 = new JTextField(15);
        tt3.setBounds(140,100,160,25);
        tt3.setFont(new Font("Arial", Font.PLAIN, 18));
        tt3.setBorder(BorderFactory.createEmptyBorder());
        tt3.setBackground(Color.pink);
        add(tt3);

        aa2=new JLabel("PLACE");
        aa2.setBounds(40,136,120,25);
        aa2.setFont(new Font("serif",Font.PLAIN,18));
        add(aa2);

        tt2 = new JTextField(15);
        tt2.setBounds(140,136,160,25);
        tt2.setFont(new Font("Arial", Font.PLAIN, 18));
        tt2.setBorder(BorderFactory.createEmptyBorder());
        tt2.setBackground(Color.pink);
        add(tt2);

        aa3=new JLabel("TIME");
        aa3.setBounds(40,170,120,25);
        aa3.setFont(new Font("serif",Font.PLAIN,18));
        add(aa3);

        tt1 = new JTextField(15);
        tt1.setBounds(140,170,160,25);
        tt1.setFont(new Font("Arial", Font.PLAIN, 18));
        tt1.setBorder(BorderFactory.createEmptyBorder());
        tt1.setBackground(Color.pink);
        add(tt1);

        aa4=new JLabel("REMINDER");
        aa4.setBounds(40,205,120,25);
        aa4.setFont(new Font("serif",Font.PLAIN,18));
        add(aa4);

        tt4 = new JTextField(15);
        tt4.setBounds(140,205,160,25);
        tt4.setFont(new Font("Arial", Font.PLAIN, 18));
        tt4.setBorder(BorderFactory.createEmptyBorder());
        tt4.setBackground(Color.pink);
        add(tt4);

        jb1 = new JButton("ADD");
        jb1.setBackground(Color.BLUE);
        jb1.setForeground(Color.WHITE);
        jb1.setFont(new Font("Arial", Font.BOLD, 14));
        jb1.setBounds(50,250,100,30);
        add(jb1);

        jb2 = new JButton("BACK");
        jb2.setBackground(Color.BLUE);
        jb2.setForeground(Color.WHITE);
        jb2.setFont(new Font("Arial", Font.BOLD, 14));
        jb2.setBounds(150,250,100,30);
        add(jb2);
        jb2.addActionListener(this);
        jb1.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/meet.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(290, 330,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(310,10,260,330);
        add(image);

        setLayout(null);
        setSize(600,370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == jb1) {
            try {
                conn cn = new conn();
                String q1 = "insert into meeting values('"+tt3.getText()+"','"+tt2.getText()+"','"+tt1.getText()+"','"+tt4.getText()+"','"+P+"')";
                cn.s.executeUpdate(q1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"added successfully");
            setVisible(false);
            new addmeeting(P).setVisible(true);
        }

        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addmeeting("").setVisible(true);
    }
}
