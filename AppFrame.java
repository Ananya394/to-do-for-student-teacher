package javaproject;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

class Footer extends JPanel {

    JButton addTask;
    JButton clear,done;

    Color orange = new Color(233, 133, 128);
    Color lightColor = new Color(252, 221, 176);
    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer() {
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(lightColor);

        addTask = new JButton("Add Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.ITALIC, 20));
        addTask.setVerticalAlignment(JButton.BOTTOM);
        addTask.setBackground(orange);
        this.add(addTask);

        this.add(Box.createHorizontalStrut(20));

        clear = new JButton("Clear finished tasks");
        clear.setFont(new Font("Sans-serif", Font.ITALIC, 20));
        clear.setBorder(emptyBorder);
        clear.setBackground(orange);
        this.add(clear);


        done = new JButton("back");
        done.setFont(new Font("Sans-serif", Font.ITALIC, 20));
        done.setBorder(emptyBorder);
        done.setBackground(orange);
        this.add(done);

    }

    public JButton getNewTask() {
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }
    public JButton getDo() {
        return done;
    }

}

class TitleBar extends JPanel {

    Color lightColor = new Color(252, 221, 176);

    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(lightColor);
        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 60));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);
    }
}

class List extends JPanel {

    Color lightColor = new Color(252, 221, 176);

    List() {

        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);

        this.setLayout(layout);
        this.setPreferredSize(new Dimension(400, 560));
        this.setBackground(lightColor);
    }

    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }

    }

    public void removeCompletedTasks() {

        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    remove(c);
                    updateNumbers();
                }
            }
        }

    }

    public void removetask(Task t) {

        remove(t);
        updateNumbers();


    }
}

class Task extends JPanel {

    JLabel index,fin;
    JTextField taskName,Tfin;
    JButton edit,remove ;
    JButton done;

    Color pink = new Color(249, 161, 161);
    Color green = new Color(188, 226, 158);
    Color doneColor = new Color(233, 119, 119);

    private boolean checked;

    Task() {
        this.setPreferredSize(new Dimension(400, 20));
        this.setBackground(pink);

        setLayout(null);

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        index.setBounds(10,5,20,20);
        this.add(index);

        taskName = new JTextField("Write something..");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBounds(30,5,300,20);
        taskName.setBackground(pink);

        Tfin = new JTextField("submit time");
        Tfin.setBorder(BorderFactory.createEmptyBorder());
        Tfin.setBounds(500,5,70,20);
        Tfin.setBackground(pink);

        edit = new JButton("Insert");
        edit.setPreferredSize(new Dimension(80, 15));
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setBounds(580,5,45,20);
        edit.setBackground(doneColor);
        edit.setFocusPainted(false);
        this.add(edit);

        remove = new JButton("remove");
        remove.setPreferredSize(new Dimension(80, 15));
        remove.setBorder(BorderFactory.createEmptyBorder());
        remove.setBackground(doneColor);
        remove.setBounds(630,5,50,20);
        remove.setFocusPainted(false);
        this.add(remove);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(80, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setBackground(doneColor);
        done.setBounds(690,5,50,20);
        done.setFocusPainted(false);
        this.add(done, BorderLayout.EAST);
        this.add(taskName);
        this.add(Tfin);
    }

    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }

    public JButton getDone() {
        return done;
    }

    public JButton getremove(){
        return remove;
    }

    public JButton getEdit(){
        return edit;
    }
    public boolean getState() {
        return checked;
    }

    public void changeState() {
        this.setBackground(green);
        taskName.setBackground(green);
        checked = true;
        revalidate();
    }



    public static void main(String[] args) {
        new Task().setVisible(true);
    }
}
class AppFrame extends JFrame {

    private TitleBar title;
    private Footer footer;
    private List list;

    private JButton newTask;
    private JButton clear,back;
    private taskpanel jp;
    JLabel tit;
    String P;
    JButton done;

    AppFrame(String pin) {
        this.P=pin;
        setSize(780, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        title = new TitleBar();
        footer = new Footer();
        list = new List();
        jp=new taskpanel();

        this.add(title, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        newTask = footer.getNewTask();
        clear = footer.getClear();
        back=footer.getDo();


        try{
            String Query="select * from taske where pin = '"+P+"'AND status='"+0+"'";
            conn co=new conn();
            ResultSet rs=co.s.executeQuery(Query);
            while (rs.next()){
                Task TT=new Task();
                TT.taskName.setText(rs.getString("task"));
                TT.Tfin.setText(rs.getString("finishtime"));
               // TT.index.setText(rs.getString("num"));
                list.add(TT);
                list.updateNumbers();
                String ST=rs.getString("task");
                String DT=rs.getString("time");
                String uu=rs.getString("finishtime");

                TT.getDone().addMouseListener(new MouseAdapter() {

                                                    public void mousePressed(MouseEvent e) {

                                                        TT.changeState();
                                                        list.updateNumbers();
                                                        revalidate();
                                                        Date A=new Date();
                                                        String AA=A+"";

                                                        try{
                                                            String queue="update taske set num='"+TT.index.getText()+"',task='"+TT.taskName.getText()+"',status='"+1+"',time='"+DT+"',pin='"+P+"',target='"+AA+"',finishtime='"+uu+"' where task='"+ST+"'AND pin='"+P+"'";
                                                            conn co = new conn();
                                                            co.s.executeUpdate(queue);
                                                        }catch(Exception Ep){Ep.printStackTrace();}

                                                    }
                                                }
                );

                TT.getremove().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        list.removetask(TT);
                        repaint();
                    }
                });
            }

        }catch (Exception ep){
            ep.printStackTrace();
        }

        addListeners();
    }

    public void addListeners() {
        newTask.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getDone().addMouseListener(new MouseAdapter() {

                                                    public void mousePressed(MouseEvent e) {

                                                        task.changeState();
                                                        list.updateNumbers();
                                                        revalidate();

                                                    }
                                                }
                );

                task.getEdit().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        String Ta=task.taskName.getText();
                        Date currentDate = new Date();
                        String DDT=currentDate+"";
                        String Num=task.index.getText();
                        String ff=task.Tfin.getText();

                        try{
                            conn C1 = new conn();
                            String Q1 = "insert into taske values('"+Num+"','"+Ta+"','"+0+"','"+DDT+"','"+P+"','"+00+"','"+ff+"')";
                            C1.s.executeUpdate(Q1);

                        }catch(Exception em){
                            em.printStackTrace();
                        }
                    }
                });

                task.getremove().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        list.removetask(task);
                        repaint();
                    }
                });
            }

        });

        clear.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                list.removeCompletedTasks(); // Removes all tasks that are done
                repaint(); // Repaints the list
            }
        });

        back.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
               setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new AppFrame("127").setVisible(true);
    }

}

