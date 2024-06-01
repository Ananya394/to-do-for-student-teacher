package javaproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,ll1;
    JTextField tf1,tf4,pit;
    JPasswordField pf2;
    JButton b1,b2,b3;


    login(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/second.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);
        add(l11);


        setTitle("ativity tracker");

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("pic/snow.png"));
        Image ii2 = ii1.getImage().getScaledInstance(700, 580, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel ll1 = new JLabel(ii3);
        ll1.setBounds(0, 0, 700, 500);
        add(ll1);

        l1 = new JLabel("WELCOME TO ACTIVITY TRACKER");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(180,40,550,40);
        ll1.add(l1);

        l2 = new JLabel("Name:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(125,150,375,30);
        ll1.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(tf1);

        l3 = new JLabel("Password:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(125,220,375,30);
        ll1.add(l3);

        l4 = new JLabel("pin:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(125,290,375,30);
        ll1.add(l4);

        pit = new JTextField(15);
        pit.setBounds(300,290,230,30);
        pit.setFont(new Font("Arial", Font.BOLD, 14));
        pit.setBorder(BorderFactory.createEmptyBorder());
        add(pit);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        pf2.setBorder(BorderFactory.createEmptyBorder());
        add(pf2);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        ll1.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        ll1.add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
       ll1.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(Color.pink);

        setSize(800,580);
        setLocation(250,50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==b2)
        {
            tf1.setText("");
            pf2.setText("");
        }
        if(ac.getSource()==b3)
        {
           new singup().setVisible(true);
        }
        else if(ac.getSource()==b1)
        {
            try{
                String usname=tf1.getText();
                String pass=pf2.getText();
                String pin=pit.getText();

                String qu="select * from singup where name = '"+usname+"' and pincode = '"+pin+"' and password = '"+pass+"'";
                conn c=new conn();
                ResultSet res=c.s.executeQuery(qu);
                if(res.next())
                {
                   String s1= res.getString("status");

                    if(s1.equals("teacher"))
                    {setVisible(false);
                   new teacher(pin);}
                    else
                    {
                        setVisible(false);
                        new Final1(pin).setVisible(true);
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null,"incorrect info");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        new login();
    }


}

