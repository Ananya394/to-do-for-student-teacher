/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class firstveiw extends JFrame implements ActionListener{

    JLabel l1,lid;
    JButton b1;
    ImageIcon im;

    public firstveiw() {



        //setSize(1000,530);          // setContentPane(300,300,1366,390);   frame size
       // setLayout(null);
       // setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.PINK);
        b1.setForeground(Color.BLACK);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("pic/first.png"));
        Image i3 = i1.getImage().getScaledInstance(1366, 490,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

         lid=new JLabel("ACTIVITY TRACKER");
        lid.setBounds(30,400,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,60));
        lid.setForeground(Color.red);
        l1.add(lid);

        JLabel lid1=new JLabel("You can only manage time if you track it right.");
        lid1.setBounds(30,330,1500,100);
        lid1.setFont(new Font("serif",Font.ITALIC,30));
        lid1.setForeground(Color.red);
        l1.add(lid1);

        b1.setFont(new Font("Arial", Font.BOLD, 19));
        b1.setBounds(850,425,100,50);
        l1.setBounds(0, 0, 1366, 390);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

      /*
        }*/


    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==b1)
        {
            setVisible(false);
           new login().setVisible(true);
        }

    }

    public static void main(String[] args) {
        firstveiw window = new firstveiw();
        //window.setVisible(true);//
        for(int i=1;i<530;i=i+1)
        {
            window.setSize(i*2,i);
            window.setLocationRelativeTo(null);
        }
        while(true) {
            window.lid.setVisible(false); // lid =  j label
            try {
                Thread.sleep(500); //1000 = 1 second
            } catch (Exception e) {
            }
            window.lid.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}