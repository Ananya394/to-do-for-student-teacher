package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deleteclass extends JFrame implements ActionListener {
    JButton delete,d_all;
    JLabel cla,tim;
    JComboBox cc;
    String P;
    Choice choi,tt;
    deleteclass(String pin)
    {
this.P=pin;
        cla = new JLabel("CLASS:");
        cla.setFont(new Font("Raleway", Font.PLAIN, 18));
        cla.setBounds(50, 60, 100, 20);
        add(cla);

        tim = new JLabel("Time:");
        tim.setFont(new Font("Raleway", Font.PLAIN, 18));
        tim.setBounds(50, 100, 100, 20);
        add(tim);

        tt=new Choice();
        tt.setBounds(155,100,150,25);
        add(tt);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from class WHERE pin = '"+P+"'");
            while(rs.next()) {
                tt.add(rs.getString("tim"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choi=new Choice();
        choi.setBounds(155,60,150,25);
        add(choi);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from class WHERE pin = '"+P+"'");
            while(rs.next()) {
                choi.add(rs.getString("day"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 250);
        setLocationRelativeTo(null);
        setBackground(Color.lightGray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        delete=new JButton("delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Arial", Font.BOLD, 14));
        delete.setBounds(80,150,100,30);
        add(delete);
        delete.addActionListener(this);

        d_all=new JButton("delete all");
        d_all.setBackground(Color.BLACK);
        d_all.setForeground(Color.WHITE);
        d_all.setFont(new Font("Arial", Font.BOLD, 14));
        d_all.setBounds(210,150,150,30);
        add(d_all);
        d_all.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == delete) {
            String d=(String) choi.getSelectedItem();
            String Time1=(String) tt.getSelectedItem();
           try{
               conn c=new conn();
               c.s.executeUpdate("delete from class where day='"+d+"'AND pin='"+P+"'AND tim='"+Time1+"'");
           }catch(Exception e){
               e.printStackTrace();
           }
           setVisible(false);
        }
        else{
            try{
                conn c=new conn();
                c.s.executeUpdate("delete from class where pin='"+P+"'");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new deleteclass("127");
    }
}
