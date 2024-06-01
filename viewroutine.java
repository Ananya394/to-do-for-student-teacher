package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class viewroutine extends JFrame implements ActionListener {
    JTable table;
    JButton delete,BB,a,b,c,d,e,f;
    String pin;
    viewroutine(String pin)
    {
        this.pin=pin;
        setSize(700,500);
        setLocationRelativeTo(null);
        setLayout(null);

        BB = new JButton("back");
        BB.setForeground(Color.BLACK);
        BB.setFont(new Font("Arial", Font.BOLD, 15));
        BB.setBounds(320,70,50,20);
        BB.setBorder(BorderFactory.createEmptyBorder());
        add(BB);
        BB.addActionListener(this);

        a = new JButton("add");
        a.setForeground(Color.BLACK);
        a.setFont(new Font("Arial", Font.BOLD, 15));
        a.setBounds(50,70,50,20);
        a.setBorder(BorderFactory.createEmptyBorder());
        add(a);
        a.addActionListener(this);

        b = new JButton("delete");
        b.setForeground(Color.BLACK);
        b.setFont(new Font("Arial", Font.BOLD, 15));
        b.setBounds(110,70,50,20);
        b.setBorder(BorderFactory.createEmptyBorder());
        add(b);
        b.addActionListener(this);

        c = new JButton("print");
        c.setForeground(Color.BLACK);
        c.setFont(new Font("Arial", Font.BOLD, 15));
        c.setBounds(170,70,50,20);
        c.setBorder(BorderFactory.createEmptyBorder());
        add(c);
        c.addActionListener(this);

        d = new JButton("refresh");
        d.setForeground(Color.BLACK);
        d.setFont(new Font("Arial", Font.BOLD, 15));
        d.setBounds(230,70,80,20);
        d.setBorder(BorderFactory.createEmptyBorder());
        add(d);
        d.addActionListener(this);

        table =new JTable();
        try{
            conn C=new conn();
            ResultSet rs=C.s.executeQuery("select * from routine");
            String query="select * from routine where pin='"+pin+"'";
            rs=C.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }



        JScrollPane js=new JScrollPane(table);
        js.setBounds(10,100,650,400);
        add(js);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {

        if(ac.getSource()==BB)
        {
            this.setVisible(false);
        }
        if(ac.getSource()==a)
        {
           new Addrotine(pin);
        }
        if(ac.getSource()==c){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ac.getSource()==d){
            setVisible(false);
            new viewroutine(pin);
        }
        if(ac.getSource()==b){
            new deleteexam(pin);
        }

    }

    public static void main(String[] args) {
        new viewroutine("127").setVisible(true);
    }
}
