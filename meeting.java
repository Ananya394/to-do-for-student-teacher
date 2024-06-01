package javaproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class meeting extends JFrame implements ActionListener {
    String P,M;
    JTable tab;
    JButton add,remove,back,RR;
    meeting(String pin){
        this.P=pin;

        add=new JButton("ADD");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.setBounds(100,40,100,30);
        add(add);
        add.addActionListener(this);

        remove=new JButton("Remove");
        remove.setBackground(Color.BLUE);
        remove.setForeground(Color.WHITE);
        remove.setFont(new Font("Arial", Font.BOLD, 14));
        remove.setBounds(220,40,100,30);
        add(remove);
         remove.addActionListener(this);

        RR=new JButton("REFRESH");
        RR.setBackground(Color.BLUE);
        RR.setForeground(Color.WHITE);
        RR.setFont(new Font("Arial", Font.BOLD, 14));
        RR.setBounds(460,40,100,30);
        add(RR);
        RR.addActionListener(this);

        back=new JButton("BACK");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(340,40,100,30);
        add(back);
         back.addActionListener(this);


        tab =new JTable();
        try{
            conn C=new conn();
            ResultSet rs=C.s.executeQuery("select * from meeting");
            String query="select * from meeting where pin='"+P+"'";
            rs=C.s.executeQuery(query);
            tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane js=new JScrollPane(tab);
        js.setBounds(10,100,650,400);
        add(js);

        setSize(700,500);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == back) {
            setVisible(false);
        }
        else if(ac.getSource()==add){
            new addmeeting(P).setVisible(true);
        }
        else if(ac.getSource()==RR){
            setVisible(false);
            new meeting(P).setVisible(true);
        }
        else {
            new delmeet(P).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new meeting("").setVisible(true);
    }
}
