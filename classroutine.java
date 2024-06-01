package javaproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class classroutine extends JFrame implements ActionListener {
    JButton add, up,print,back,DD,re;
    JTable table;
    String pin;
    classroutine(String pin){

        this.pin=pin;
        add = new JButton("add");
       // add.setBackground(Color.w);
        add.setForeground(Color.BLACK);
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setBounds(50,10,50,20);
        add.setBorder(BorderFactory.createEmptyBorder());
        add(add);
        add.addActionListener(this);

        up = new JButton("update");
        // up.setBackground(Color.w);
        up.setForeground(Color.BLACK);
        up.setFont(new Font("Arial", Font.BOLD, 15));
        up.setBounds(120,10,80,20);
        up.setBorder(BorderFactory.createEmptyBorder());
        add(up);
        up.addActionListener(this);

        back = new JButton("BACK");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setBounds(300,10,80,20);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        back.addActionListener(this);

        DD = new JButton("delete");
        DD.setForeground(Color.BLACK);
        DD.setFont(new Font("Arial", Font.BOLD, 15));
        DD.setBounds(390,10,80,20);
        DD.setBorder(BorderFactory.createEmptyBorder());
        add(DD);
        DD.addActionListener(this);

        re = new JButton("refresh");
        re.setForeground(Color.BLACK);
        re.setFont(new Font("Arial", Font.BOLD, 15));
        re.setBounds(486,10,80,20);
        re.setBorder(BorderFactory.createEmptyBorder());
        add(re);
        re.addActionListener(this);

        print = new JButton("print");
        // print.setBackground(Color.w);
        print.setForeground(Color.BLACK);
        print.setFont(new Font("Arial", Font.BOLD, 15));
        print.setBounds(210,10,80,20);
        print.setBorder(BorderFactory.createEmptyBorder());
        add(print);
        print.addActionListener(this);

        table =new JTable();
        try{
            conn C=new conn();
            ResultSet rs=C.s.executeQuery("select * from class");
            String query="select * from class where pin='"+pin+"'";
            rs=C.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane js=new JScrollPane(table);
        js.setBounds(10,50,650,400);
        add(js);

        setSize(700,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == add) {
           new addclassro(pin).setVisible(true);
           setVisible(false);
        }

        if (ac.getSource() == back) {
           setVisible(false);
        }
        if(ac.getSource()==up){
            setVisible(false);
            new updaterotine(pin);
        }
        if(ac.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ac.getSource()==re){
            setVisible(false);
            new classroutine(pin).setVisible(true);
        }
        else if(ac.getSource()==DD) {
            new deleteclass(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new classroutine("127").setVisible(true);
    }
}
