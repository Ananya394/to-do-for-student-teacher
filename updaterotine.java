package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updaterotine extends JFrame implements ActionListener {
    JLabel l1,l2,tag,pri,dd,type,l3;
    JTextField tl2,ttag,tpri,tdd;
    JButton add,done;
    String pin;
    JComboBox da,texttype;
    String P;
    Choice tt,choi;
    updaterotine(String pin)
    {
        this.P=pin;

        choi=new Choice();
        choi.setBounds(120,50,150,25);
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
        /*String dy=(String) choi.getSelectedItem();
        tt=new Choice();
        tt.setBounds(120,100,150,25);
        add(tt);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from class WHERE pin = '"+P+"'AND day='"+dy+"'");
            while(rs.next()) {
                tt.add(rs.getString("tim"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        tl2 = new JTextField(15);
        tl2.setBounds(120, 100, 200, 20);
        tl2.setFont(new Font("Arial", Font.PLAIN, 20));
        tl2.setBorder(BorderFactory.createEmptyBorder());
        tl2.setBackground(Color.pink);
        add(tl2);

        l2 = new JLabel("day:");
        l2.setFont(new Font("Raleway", Font.PLAIN, 18));
        l2.setBounds(50, 50, 200, 20);
        add(l2);

        l1 = new JLabel("new time:");
        l1.setFont(new Font("Raleway", Font.PLAIN, 15));
        l1.setBounds(50, 150, 200, 20);
        add(l1);

        dd = new JLabel("TIME:");
        dd.setFont(new Font("Raleway", Font.PLAIN, 18));
        dd.setBounds(50, 100, 200, 20);
        add(dd);

        pri = new JLabel("CLASS:");
        pri.setFont(new Font("Raleway", Font.PLAIN, 18));
        pri.setBounds(50, 200, 200, 20);
        add(pri);

        pri = new JLabel("type:");
        pri.setFont(new Font("Raleway", Font.PLAIN, 18));
        pri.setBounds(50, 250, 200, 20);
        add(pri);


        tdd = new JTextField(15);
        tdd.setBounds(120, 150, 200, 20);
        tdd.setFont(new Font("Arial", Font.PLAIN, 20));
        tdd.setBorder(BorderFactory.createEmptyBorder());
        tdd.setBackground(Color.pink);
        add(tdd);

        tpri = new JTextField(15);
        tpri.setBounds(120, 200, 200, 20);
        tpri.setFont(new Font("Arial", Font.PLAIN, 20));
        tpri.setBorder(BorderFactory.createEmptyBorder());
        tpri.setBackground(Color.pink);
        add(tpri);

        String lab[] = {"Theory","Lab"};
        texttype = new JComboBox(lab);
        texttype.setBackground(Color.WHITE);
        texttype.setBounds(120,250,200,20);
        add(texttype);

        add = new JButton("update");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.setBounds(80,300,100,30);
        add(add);

        done = new JButton("back");
        done.setBackground(Color.BLUE);
        done.setForeground(Color.WHITE);
        done.setFont(new Font("Arial", Font.BOLD, 14));
        done.setBounds(200,300,100,30);
        add(done);
        done.addActionListener(this);
        add.addActionListener(this);


        setSize(400, 400);
        setLocationRelativeTo(null);
        setBackground(Color.lightGray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == add) {
            String sub=(String) choi.getSelectedItem();
            String cri=tdd.getText();
            String dat=tpri.getText();
            String ty=(String) texttype.getSelectedItem();
            String time=tl2.getText();
            try {
                String query = "update class set tim='"+cri+"', sub='"+dat+"', type='"+ty+"' where day='"+sub+"'AND pin='"+P+"'AND tim='"+time+"'";
                conn con = new conn();
                con.s.executeUpdate(query);
               // setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ac.getSource()==done)
        {
            setVisible(false);
            new classroutine(P);
        }
    }
    public static void main(String[] args) {
       new updaterotine("127").setVisible(true);
    }
}
