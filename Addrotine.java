package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addrotine extends JFrame implements ActionListener {
    JLabel l1,sub,dat,time,credit,jcomplete,jtype;
    JTextField st,dt,tt,ct;
    JComboBox complete,type;
    JButton add,back;
    String pin,kkk="okay okay";
    Addrotine(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/image4.png"));
        Image i3 = i1.getImage().getScaledInstance(270, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(400,20,270,450);
        add(image);

        sub=new JLabel("SUBJECT");
        sub.setBounds(40,100,120,25);
        sub.setFont(new Font("serif",Font.PLAIN,20));
        add(sub);

        st = new JTextField(15);
        st.setBounds(180,100,200,25);
        st.setFont(new Font("Arial", Font.PLAIN, 20));
        st.setBorder(BorderFactory.createEmptyBorder());
        st.setBackground(Color.pink);
        add(st);

        dat=new JLabel("DATE");
        dat.setBounds(40,190,120,25);
        dat.setFont(new Font("serif",Font.PLAIN,20));
        add(dat);

        dt = new JTextField(15);
        dt.setBounds(180,190,200,25);
        dt.setFont(new Font("Arial", Font.PLAIN, 20));
        dt.setBorder(BorderFactory.createEmptyBorder());
        dt.setBackground(Color.pink);
        add(dt);

        time=new JLabel("TIME");
        time.setBounds(40,220,120,25);
        time.setFont(new Font("serif",Font.PLAIN,20));
        add(time);

        tt = new JTextField(15);
        tt.setBounds(180,220,200,25);
        tt.setFont(new Font("Arial", Font.PLAIN, 20));
        tt.setBorder(BorderFactory.createEmptyBorder());
        tt.setBackground(Color.pink);
        add(tt);

        credit=new JLabel("CREDIT");
        credit.setBounds(40,160,120,25);
        credit.setFont(new Font("serif",Font.PLAIN,20));
        add(credit);

        ct = new JTextField(15);
        ct.setBounds(180,160,200,25);
        ct.setFont(new Font("Arial", Font.PLAIN, 20));
        ct.setBorder(BorderFactory.createEmptyBorder());
        ct.setBackground(Color.pink);
        add(ct);

        jcomplete=new JLabel("COMPLETE");
        jcomplete.setBounds(40,250,120,25);
        jcomplete.setFont(new Font("serif",Font.PLAIN,20));
        add(jcomplete);

        String course[] = {"100%","0%","10%","20%","30%","40%","60%","70%","80","90%","50%"};
        complete = new JComboBox(course);
        complete.setBackground(Color.WHITE);
        complete.setBounds(180,250,120,25);
        add(complete);

        jtype=new JLabel("TYPE");
        jtype.setBounds(40,130,120,25);
        jtype.setFont(new Font("serif",Font.PLAIN,20));
        add(jtype);

        String cou[] = {"THEORY","LAB"};
        type = new JComboBox(cou);
        type.setBackground(Color.WHITE);
        type.setBounds(180,130,120,25);
        add(type);

        add = new JButton("add more");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.setBounds(50,350,100,30);
        add(add);

        back = new JButton("DONE");
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(270,350,100,30);
        add(back);
        back.addActionListener(this);
        add.addActionListener(this);

        setSize(750,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == back) {
           setVisible(false);
        }
        if (ac.getSource() == add) {
            String sub=st.getText();
            String cri=ct.getText();
            String dat=dt.getText();
            String tim=tt.getText();
            String ty=(String) type.getSelectedItem();
            String com=(String) complete.getSelectedItem();
            String P=pin;

            try{
                if(ty.equals("")||com.equals("")|| st.getText().equals("")||ct.getText().equals("")||dt.getText().equals("")||tt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }
                else{
                    conn C=new conn();
                    String que="insert into routine values('"+sub+"','"+ty+"','"+cri+"','"+dat+"','"+tim+"','"+ com+"','"+P+"')";
                    C.s.executeUpdate(que);
                    JOptionPane.showMessageDialog(null,"routine added "+kkk);
                    setVisible(false);
                    new Addrotine(pin).setVisible(true);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Addrotine("").setVisible(true);
    }
}
