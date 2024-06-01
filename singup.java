package javaproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;

public class singup extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7,jp1;
    JRadioButton r1,r2,r3,r4,r5;

    JPasswordField jp2;
    JButton b,jb1;
    //JDateChooser dateChooser;


    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    singup(){

        setTitle("NEW ACCOUNT APPLICATION FORM");

        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);*/

        l1 = new JLabel("APPLICATION FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("Password:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));


        l5 = new JLabel("Email Address:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel("Status: ");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));


        l7 = new JLabel("Pin Code:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));



        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        jp1 = new JTextField(15);
        jp1.setFont(new Font("Raleway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));


        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        jb1 = new JButton("back");
        jb1.setFont(new Font("Raleway", Font.BOLD, 14));
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);

        r1 = new JRadioButton("student");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("teacher");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        setLayout(null);
        l1.setBounds(140,20,600,40);
        add(l1);

        l2.setBounds(290,80,600,30);
        add(l2);

        l3.setBounds(100,140,100,30);
        add(l3);

        t1.setBounds(300,140,400,30);
        add(t1);

        l4.setBounds(100,190,200,30);
        add(l4);

        jp1.setBounds(300,190,400,30);
        add(jp1);

        l5.setBounds(100,240,200,30);
        add(l5);

        l6.setBounds(100,290,100,30);
        add(l6);

        l7.setBounds(100,340,100,30);
        add(l7);

        r1.setBounds(300,290,100,30);
        add(r1);

        r2.setBounds(450,290,90,30);
        add(r2);

        t3.setBounds(300,240,400,30);
        add(t3);

        t4.setBounds(300,340,400,30);
        add(t4);




        b.setBounds(620,450,80,30);
        add(b);

        jb1.setBounds(520,450,80,30);
        add(jb1);

        b.addActionListener(this);
       jb1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,600);
        setLocation(200,10);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b) {
    String formno = " " + ran;
    String name = t1.getText();
    //String password=jp1.getText();
    // String fname = t2.getText();
    // String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    String status = null;
    if (r1.isSelected()) {
        status = "Student";
    } else if (r2.isSelected()) {
        status = "Teacher";
    }

    String email = t3.getText();
        /*String status = null;
        if(r1.isSelected()){
            marital = "student";
        }else if(r2.isSelected()) {
            marital = "teacher";
        }*/
    String pincode = t4.getText();
    String passw = jp1.getText();


    try {

        if (t1.getText().equals("") || t4.getText().equals("") || t3.getText().equals("") || jp1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
        } else {
            conn c1 = new conn();
            String q1 = "insert into singup values('" + formno + "','" + name + "','" + email + "','" + status + "','" + pincode + "','" + passw + "')";
            c1.s.executeUpdate(q1);

            // new singup2(first).setVisible(true);
            //setVisible(false);
            JOptionPane.showMessageDialog(null, "sign in successfully");
            setVisible(false);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
else
{
    setVisible(false);
    new login().setVisible(true);
}
    }


    public static void main(String[] args){
        new singup().setVisible(true);
    }
}