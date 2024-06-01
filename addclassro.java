package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class addclassro extends JFrame implements ActionListener {
    JLabel l1,l2,tag,pri,dd,type;
    JTextField tl2,ttag,tpri,tdd;
    JButton add,done;
    String pin;
    JComboBox da,texttype;
    addclassro(String pin) {
        this.pin=pin;
        l2 = new JLabel("day:");
        l2.setFont(new Font("Raleway", Font.PLAIN, 18));
        l2.setBounds(50, 50, 200, 20);
        add(l2);

        dd = new JLabel("TIME:");
        dd.setFont(new Font("Raleway", Font.PLAIN, 18));
        dd.setBounds(50, 100, 200, 20);
        add(dd);

        pri = new JLabel("CLASS:");
        pri.setFont(new Font("Raleway", Font.PLAIN, 18));
        pri.setBounds(50, 150, 200, 20);
        add(pri);

        pri = new JLabel("type:");
        pri.setFont(new Font("Raleway", Font.PLAIN, 18));
        pri.setBounds(50, 200, 200, 20);
        add(pri);

        String day[] = {"SATURDAY","SUNDAY","MONDAY","THURSDAY","WEDNESDAY","THURSDAY","FRIDAY"};
        da = new JComboBox(day);
        da.setBackground(Color.WHITE);
        da.setBounds(120,50,200,20);
        add(da);


        tdd = new JTextField(15);
        tdd.setBounds(120, 100, 200, 20);
        tdd.setFont(new Font("Arial", Font.PLAIN, 20));
        tdd.setBorder(BorderFactory.createEmptyBorder());
        tdd.setBackground(Color.pink);
        add(tdd);

        tpri = new JTextField(15);
        tpri.setBounds(120, 150, 200, 20);
        tpri.setFont(new Font("Arial", Font.PLAIN, 20));
        tpri.setBorder(BorderFactory.createEmptyBorder());
        tpri.setBackground(Color.pink);
        add(tpri);

        String lab[] = {"Theory","Lab"};
        texttype = new JComboBox(lab);
        texttype.setBackground(Color.WHITE);
        texttype.setBounds(120,200,200,20);
        add(texttype);

        add = new JButton("add more");
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.setBounds(80,250,100,30);
        add(add);

        done = new JButton("back");
        done.setBackground(Color.BLUE);
        done.setForeground(Color.WHITE);
        done.setFont(new Font("Arial", Font.BOLD, 14));
        done.setBounds(200,250,100,30);
        add(done);
        done.addActionListener(this);
        add.addActionListener(this);


        setSize(400, 350);
        setLocationRelativeTo(null);
        setBackground(Color.lightGray);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == done) {
            setVisible(false);
            new classroutine(pin).setVisible(true);
        }
        if (ac.getSource() == add) {
            String sub=(String) da.getSelectedItem();
            String cri=tdd.getText();
            String dat=tpri.getText();
            String ty=(String) texttype.getSelectedItem();

            try{
                if(sub.equals("")||cri.equals("")|| tpri.getText().equals("")||ty.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }
                else{
                    conn C=new conn();
                    String que="insert into class values('"+sub+"','"+cri+"','"+dat+"','"+ty+"','"+pin+"')";
                    C.s.executeUpdate(que);
                    JOptionPane.showMessageDialog(null,"class added");
                    setVisible(false);
                    new addclassro(pin).setVisible(true);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
  new addclassro("127").setVisible(true);
    }
}
