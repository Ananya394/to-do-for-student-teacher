package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatestu extends JFrame implements ActionListener {
    JLabel aa1,aa2,aa3,aa4,h1,h2,h3,h4;
    JTextField tt1,tt2,tt3,tt4,w2,w3,w4,w1;
    JButton ser,set,B;
    JComboBox NO;
    String P;
    updatestu(String pin)
    {
        this.P=pin;

        aa1=new JLabel("NAME");
        aa1.setBounds(40,100,120,25);
        aa1.setFont(new Font("serif",Font.PLAIN,18));
        add(aa1);

        tt3 = new JTextField(15);
        tt3.setBounds(140,100,160,25);
        tt3.setFont(new Font("Arial", Font.PLAIN, 18));
        tt3.setBorder(BorderFactory.createEmptyBorder());
        tt3.setBackground(Color.pink);
        add(tt3);


        aa2=new JLabel("ROLL");
        aa2.setBounds(40,136,120,25);
        aa2.setFont(new Font("serif",Font.PLAIN,18));
        add(aa2);

        tt2 = new JTextField(15);
        tt2.setBounds(140,136,160,25);
        tt2.setFont(new Font("Arial", Font.PLAIN, 18));
        tt2.setBorder(BorderFactory.createEmptyBorder());
        tt2.setBackground(Color.pink);
        add(tt2);

        aa3=new JLabel("exam roll");
        aa3.setBounds(40,170,120,25);
        aa3.setFont(new Font("serif",Font.PLAIN,18));
        add(aa3);

        tt1 = new JTextField(15);
        tt1.setBounds(140,170,160,25);
        tt1.setFont(new Font("Arial", Font.PLAIN, 18));
        tt1.setBorder(BorderFactory.createEmptyBorder());
        tt1.setBackground(Color.pink);
        add(tt1);

        aa4=new JLabel("YEAR");
        aa4.setBounds(40,205,120,25);
        aa4.setFont(new Font("serif",Font.PLAIN,18));
        add(aa4);

        tt4 = new JTextField(15);
        tt4.setBounds(140,205,160,25);
        tt4.setFont(new Font("Arial", Font.PLAIN, 18));
        tt4.setBorder(BorderFactory.createEmptyBorder());
        tt4.setBackground(Color.pink);
        add(tt4);

        h1=new JLabel("tutorial 1:");
        h1.setBounds(40,246,120,25);
        h1.setFont(new Font("serif",Font.PLAIN,18));
        add(h1);

        w3 = new JTextField(15);
        w3.setBounds(140,246,160,25);
        w3.setFont(new Font("Arial", Font.PLAIN, 18));
        w3.setBorder(BorderFactory.createEmptyBorder());
        w3.setBackground(Color.pink);
        add(w3);

        h2=new JLabel("tutorial 2 :");
        h2.setBounds(40,286,120,25);
        h2.setFont(new Font("serif",Font.PLAIN,18));
        add(h2);

        w2 = new JTextField(15);
        w2.setBounds(140,286,160,25);
        w2.setFont(new Font("Arial", Font.PLAIN, 18));
        w2.setBorder(BorderFactory.createEmptyBorder());
        w2.setBackground(Color.pink);
        add(w2);

        h3=new JLabel("attendence :");
        h3.setBounds(40,320,120,25);
        h3.setFont(new Font("serif",Font.PLAIN,18));
        add(h3);

        w4 = new JTextField(15);
        w4.setBounds(140,320,160,25);
        w4.setFont(new Font("Arial", Font.PLAIN, 18));
        w4.setBorder(BorderFactory.createEmptyBorder());
        w4.setBackground(Color.pink);
        add(w4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/update.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(250, 220,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(310,100,250,250);
        add(image);

        ser=new JButton("scerch");
        ser.setBackground(Color.BLUE);
        ser.setForeground(Color.WHITE);
        ser.setFont(new Font("Arial", Font.BOLD, 14));
        ser.setBounds(150,50,100,30);
        add(ser);
        ser.addActionListener(this);

        set=new JButton("update");
        set.setBackground(Color.BLUE);
        set.setForeground(Color.WHITE);
        set.setFont(new Font("Arial", Font.BOLD, 14));
        set.setBounds(130,400,100,30);
        add(set);
        set.addActionListener(this);

        B=new JButton("BACK");
        B.setBackground(Color.BLUE);
        B.setForeground(Color.WHITE);
        B.setFont(new Font("Arial", Font.BOLD, 14));
        B.setBounds(300,400,100,30);
        add(B);
        B.addActionListener(this);



        setLayout(null);
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == ser) {
            try{
                String we="select * from student where name='"+tt3.getText()+"'AND pin='"+P+"'AND Roll='"+tt2.getText()+"'";
                conn cu=new conn();
                ResultSet RR=cu.s.executeQuery(we);
                while(RR.next()){
                    tt1.setText(RR.getString("Exam_Roll"));
                    tt4.setText(RR.getString("Year"));
                    w3.setText(RR.getString("tutorial1"));
                    w2.setText(RR.getString("tutorial2"));
                    w4.setText(RR.getString("attendence"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        else if(ac.getSource()==set){
            try{
                conn c1 = new conn();
                String q1,in;
                int ab=Integer.parseInt(w2.getText())+Integer.parseInt(w3.getText())+Integer.parseInt(w4.getText());
                in=String.valueOf(ab);
                q1="update student set name='"+tt3.getText()+"',Roll='"+tt2.getText()+"',Exam_Roll='"+tt1.getText()+"',Year='"+tt4.getText()+"',pin='"+P+"',tutorial1='"+ w3.getText()+"',tutorial2='"+w2.getText()+"',attendence='"+w4.getText()+"',total='"+in+"'where name='"+tt3.getText()+"'AND pin='"+P+"'AND Roll='"+tt2.getText()+"'";
                c1.s.executeUpdate(q1);
            }catch (Exception ep){
                ep.printStackTrace();
            }
        }

        else {
            setVisible(false);
        }
    }

            public static void main(String[] args) {
        new updatestu("").setVisible(true);
    }
}
