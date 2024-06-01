package javaproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class teacher extends JFrame implements ActionListener {

    JLabel ll1,ll2;
    JTable tab;
    JButton ad,re,view,upd,ex,ta,me;
    JMenuBar menu;
    JMenu m1,m2,m3;
    JMenuItem it1,it2,it3,it4,tu1,tu2,tu3,at;
    String P;
    teacher(String pin)
    {
        this.P=pin;
        ll1=new JLabel("");

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("pic/classroom.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(1250, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        ll1 = new JLabel(i2);
        ll1.setBounds(0, 0, 1366, 390);
        add(ll1);

        ad = new JButton("ADD student");
        ad.setBackground(Color.PINK);
        ad.setForeground(Color.BLACK);
        ad.setFont(new Font("Arial", Font.BOLD, 19));
        ad.setBounds(250,100,200,50);
        ad.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(ad);
        ad.addActionListener(this);

        /*view = new JButton("efficency");
        view.setBackground(Color.PINK);
        view.setForeground(Color.BLACK);
        view.setFont(new Font("Arial", Font.BOLD, 19));
        view.setBounds(790,170,200,50);
        view.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(view);
        view.addActionListener(this);*/


        upd = new JButton("update student info ");
        upd.setBackground(Color.PINK);
        upd.setForeground(Color.BLACK);
        upd.setFont(new Font("Arial", Font.BOLD, 17));
        upd.setBounds(250,170,200,50);
        upd.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(upd);
        upd.addActionListener(this);

        re = new JButton("remove student");
        re.setBackground(Color.PINK);
        re.setForeground(Color.BLACK);
        re.setFont(new Font("Arial", Font.BOLD, 19));
        re.setBounds(250,240,200,50);
        re.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(re);
        re.addActionListener(this);


        ta = new JButton("ADD TASK");
        ta.setBackground(Color.PINK);
        ta.setForeground(Color.BLACK);
        ta.setFont(new Font("Arial", Font.BOLD, 19));
        ta.setBounds(550,100,200,50);
        ta.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(ta);
        ta.addActionListener(this);


        me = new JButton("MEETING");
        me.setBackground(Color.PINK);
        me.setForeground(Color.BLACK);
        me.setFont(new Font("Arial", Font.BOLD, 19));
        me.setBounds(550,170,200,50);
        me.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(me);
        me.addActionListener(this);

        ex = new JButton("exit");
        ex.setBackground(Color.PINK);
        ex.setForeground(Color.BLACK);
        ex.setFont(new Font("Arial", Font.BOLD, 19));
        ex.setBounds(550,240,200,50);
        ex.setBorder(BorderFactory.createEmptyBorder());
        ll1.add(ex);
        ex.addActionListener(this);

        menu=new JMenuBar();

        m1=new JMenu("view student");
        menu.add(m1);

        it1=new JMenuItem("First year");
        m1.add(it1);
        it1.addActionListener(this);

        it2=new JMenuItem("second year");
        m1.add(it2);
        it2.addActionListener(this);

        it3=new JMenuItem("third year");
        m1.add(it3);
        it3.addActionListener(this);

        it4=new JMenuItem("fourth year");
        m1.add(it4);
        it4.addActionListener(this);

         m2=new JMenu("ADD Mark");
        menu.add(m2);

       tu1=new JMenuItem("Marks");
        m2.add(tu1);
        tu1.addActionListener(this);

       /* tu2=new JMenuItem("tutorial 2");
        m2.add(tu2);
        tu2.addActionListener(this);

        tu3=new JMenuItem("tutorial 3");
        m2.add(tu3);
        tu3.addActionListener(this);*/

        setJMenuBar(menu);

        setSize(1300,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        String msg = ac.getActionCommand();
        if (ac.getSource() == ad) {
            new addstudent(P).setVisible(true);
        } else if (msg.equals("First year") || msg.equals("second year") || msg.equals("third year") || msg.equals("fourth year")) {
            new veiwstudent(P, msg).setVisible(true);
            //setVisible(false);
        } else if (msg.equals("Marks")) {
            new addmark(P).setVisible(true);
        } else if (ac.getSource() == ad) {
            new addstudent(P).setVisible(true);
        } else if (ac.getSource() == upd) {
            new updatestu(P).setVisible(true);
        } else if (ac.getSource() == re) {
            new removestu(P).setVisible(true);
        } else if (ac.getSource() == ex) {
            setVisible(false);
        } else if (ac.getSource() == ta) {
            new AppFrame(P).setVisible(true);
        } else if (ac.getSource() == me) {
            new meeting(P).setVisible(true);
        }
        else if(ac.getSource()==view)
        {
          //  new AnotherClass();
        }

    }

    public static void main(String[] args) {
        new teacher("").setVisible(true);
    }
}
