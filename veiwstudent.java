package javaproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class veiwstudent extends JFrame {
    String P,M;
    JTable tab;
    veiwstudent(String pin,String ms)
    {
        this.P=pin;
        this.M=ms;
        //String YE="First year";
        tab =new JTable();
        try{
            conn C=new conn();
            ResultSet rs=C.s.executeQuery("select * from student");
            String query="select * from student where pin='"+P+"'AND Year='"+M+"'";
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

    public static void main(String[] args) {
        new veiwstudent("","second year").setVisible(true);
    }
}
