package javaproject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TUTU {
    private JFrame frame;
    private int totalTasks;
    private int[] taskCompletionStatuses;
    private int currentTaskIndex;

    public TUTU() {
        frame = new JFrame("Task Completion Efficiency");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel totalTasksLabel = new JLabel("Enter the number of tasks: ");
        JTextField totalTasksField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        frame.add(totalTasksLabel);
        frame.add(totalTasksField);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalTasks = Integer.parseInt(totalTasksField.getText());
                taskCompletionStatuses = new int[totalTasks];
                currentTaskIndex = 0;
                frame.remove(totalTasksLabel);
                frame.remove(totalTasksField);
                frame.remove(submitButton);
                askForTaskStatus();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void askForTaskStatus() {
        if (currentTaskIndex < totalTasks) {
            JLabel taskStatusLabel = new JLabel("Task " + (currentTaskIndex + 1) + ": Have you completed it? (0 for not completed, 1 for completed): ");
            JTextField taskStatusField = new JTextField(10);
            JButton nextTaskButton = new JButton("Next Task");
            frame.add(taskStatusLabel);
            frame.add(taskStatusField);
            frame.add(nextTaskButton);

            nextTaskButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    taskCompletionStatuses[currentTaskIndex] = Integer.parseInt(taskStatusField.getText());
                    currentTaskIndex++;
                    taskStatusField.setText("");
                    frame.remove(taskStatusLabel);
                    frame.remove(taskStatusField);
                    frame.remove(nextTaskButton);
                    askForTaskStatus();
                }
            });
            frame.revalidate();
            frame.repaint();
        } else {
            double efficiency = calculateEfficiency();
            displayEfficiency(efficiency);
        }
    }

    private double calculateEfficiency() {
        int completedTasks = 0;
        for (int status : taskCompletionStatuses) {
            if (status == 1) {
                completedTasks++;
            }
        }
        return (double) completedTasks / totalTasks * 100;
    }

    private void displayEfficiency(double efficiency) {
        frame.dispose();
        JFrame efficiencyFrame = new JFrame("Task Completion Efficiency");
        efficiencyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        efficiencyFrame.setSize(800, 400);


        PieDataset dataset = createDataset(efficiency);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 400));


        JLabel efficiencyLabel = new JLabel("Efficiency: " + efficiency + "%");
        efficiencyLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.add(efficiencyLabel, BorderLayout.SOUTH);

        efficiencyFrame.getContentPane().add(panel);
        efficiencyFrame.setVisible(true);
    }

    private PieDataset createDataset(double efficiency) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Completed", efficiency);
        dataset.setValue("Remaining", 100 - efficiency);
        return dataset;
    }

    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Task Completion Efficiency", dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Completed", Color.PINK);
        plot.setSectionPaint("Remaining", Color.YELLOW);
        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TUTU();
            }
        });
    }
}