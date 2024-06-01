package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Final1 extends JFrame implements ActionListener {
    JLabel l1,l3;
    String pin;
    JButton home,study,addro,seero,seeho,seesty,de,cal,note;
    Final1(String pin)
    {
      this.pin=pin;
      l1=new JLabel("");

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("pic/image3.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1250, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
        l1.setBounds(0, 0, 1366, 390);
        add(l1);

        home = new JButton("ADD TASK");
        home.setBackground(Color.PINK);
        home.setForeground(Color.BLACK);
        home.setFont(new Font("Arial", Font.BOLD, 19));
        home.setBounds(700,220,250,50);
        home.setBorder(BorderFactory.createEmptyBorder());
        l1.add(home);
        home.addActionListener(this);

       /* seeho = new JButton("SEE HOME TASK");
        seeho.setBackground(Color.PINK);
        seeho.setForeground(Color.BLACK);
        seeho.setFont(new Font("Arial", Font.BOLD, 19));
        seeho.setBounds(700,160,250,50);
        seeho.setBorder(BorderFactory.createEmptyBorder());
        l1.add(seeho);

        study = new JButton("Study time");
        study.setBackground(Color.PINK);
        study.setForeground(Color.BLACK);
        study.setFont(new Font("Arial", Font.BOLD, 19));
        study.setBounds(700,220,250,50);
        study.setBorder(BorderFactory.createEmptyBorder());
        l1.add(study);*/

        seesty = new JButton("class routine");
        seesty.setBackground(Color.PINK);
        seesty.setForeground(Color.BLACK);
        seesty.setFont(new Font("Arial", Font.BOLD, 19));
        seesty.setBounds(700,280,250,50);
        seesty.setBorder(BorderFactory.createEmptyBorder());
        l1.add(seesty);
      seesty.addActionListener(this);

        addro = new JButton("add exam routine");
        addro.setBackground(Color.PINK);
        addro.setForeground(Color.BLACK);
        addro.setFont(new Font("Arial", Font.BOLD, 19));
        addro.setBounds(700,340,250,50);
        addro.setBorder(BorderFactory.createEmptyBorder());
        l1.add(addro);
        addro.addActionListener(this);

      seero = new JButton("upcomming exams");
      seero.setBackground(Color.PINK);
      seero.setForeground(Color.BLACK);
      seero.setFont(new Font("Arial", Font.BOLD, 19));
      seero.setBounds(700,400,250,50);
      seero.setBorder(BorderFactory.createEmptyBorder());
      l1.add(seero);
      seero.addActionListener(this);

      de = new JButton("exit");
      de.setBackground(Color.yellow);
      de.setForeground(Color.BLACK);
      de.setFont(new Font("Arial", Font.BOLD, 19));
      de.setBounds(1066,660,200,50);
      de.setBorder(BorderFactory.createEmptyBorder());
      l1.add(de);
      de.addActionListener(this);

      cal = new JButton("Calculator");
      cal.setBackground(Color.PINK);
      cal.setForeground(Color.BLACK);
      cal.setFont(new Font("Arial", Font.BOLD, 19));
      cal.setBounds(700,460,250,50);
      cal.setBorder(BorderFactory.createEmptyBorder());
      l1.add(cal);
      cal.addActionListener(this);

      note = new JButton("NOtePAD");
      note.setBackground(Color.PINK);
      note.setForeground(Color.BLACK);
      note.setFont(new Font("Arial", Font.BOLD, 19));
      note.setBounds(700,520,250,50);
      note.setBorder(BorderFactory.createEmptyBorder());
      l1.add(note);
      note.addActionListener(this);


        setSize(1366,760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

  public void actionPerformed(ActionEvent ac) {
    if (ac.getSource() == addro) {
      //setVisible(false);
      new Addrotine(pin).setVisible(true);
    }
    else if (ac.getSource()==cal)
    {
      try{
        Runtime.getRuntime().exec("calc.exe");
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    else if (ac.getSource()==seesty)
    {
      new classroutine(pin).setVisible(true);
    }
    else if (ac.getSource()==seero)
    {
      new viewroutine(pin).setVisible(true);
    }
    else if (ac.getSource()==note)
    {
      try{
        Runtime.getRuntime().exec("notepad.exe");
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else if(ac.getSource()==home){
      new AppFrame(pin).setVisible(true);
    }

    else {
      setVisible(false);
    }

  }

    public static void main(String[] args) {
        new Final1("").setVisible(true);
    }
}
