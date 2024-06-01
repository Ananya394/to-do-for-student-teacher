package javaproject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Message {
    private JFrame frame;
    private JTextField timeField;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private Date[] targetTimes = new Date[10];

    public Message() {
        frame = new JFrame("Scheduled Dialog App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter target times (HH:MM, separated by spaces): ");
        timeField = new JTextField(30);

        JButton scheduleButton = new JButton("Schedule");
        JButton okButton = new JButton("OK");

        panel.add(label);
        panel.add(timeField);
        panel.add(scheduleButton);
        panel.add(okButton);

        frame.add(panel);

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleDialog();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "OK button clicked");
            }
        });

        frame.setVisible(true);
    }

    private void scheduleDialog() {
        String inputTimes = timeField.getText();
        String[] timeStrings = inputTimes.split(" ");
        int numTimes = Math.min(timeStrings.length, targetTimes.length);

        for (int i = 0; i < numTimes; i++) {
            try {
                Date currentTime = new Date();
                Date targetTime = sdf.parse(timeStrings[i]);

                Calendar currentCalendar = Calendar.getInstance();
                currentCalendar.setTime(currentTime);

                Calendar targetCalendar = Calendar.getInstance();
                targetCalendar.setTime(targetTime);

                targetCalendar.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR));
                targetCalendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH));
                targetCalendar.set(Calendar.DAY_OF_MONTH, currentCalendar.get(Calendar.DAY_OF_MONTH));

                if (targetCalendar.before(currentCalendar)) {
                    targetCalendar.add(Calendar.DAY_OF_MONTH, 1);
                }


                long delay = targetCalendar.getTimeInMillis() - currentCalendar.getTimeInMillis();

                Timer timer = new Timer();
                final int index = i;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        playSound("D:/tune.wav");
                        JOptionPane.showMessageDialog(frame, "You have new assignment to do. Hurry up!!!!");
                        if (index == numTimes - 1) {
                            timer.cancel();
                        }
                    }
                }, delay);

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(frame, "Invalid time format. Please use HH:MM");
            }
        }
    }

    private void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Message();
            }
        });
    }
}