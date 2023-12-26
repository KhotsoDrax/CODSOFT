package org.StudentGradeCalculator;//package org.StudentGradeCalculator;
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculatorGUI extends Component {
    private final JFrame mainFrame;
    private int totalSubjects;
    private final JTextField totalSubjectsField;

    private JFrame inputFrame;
    private JTextField[] subjectMarkFields;

    private JFrame resultFrame;
    private static double totalMarks = 0;

    public StudentGradeCalculatorGUI() {
        // First frame to get total number of subjects
        mainFrame = new JFrame("Welcome to the Student Grade Calculator!");
        totalSubjectsField = new JTextField(10);
        totalSubjectsField.setFont(new Font("Arial",Font.BOLD,18));
        JButton submitTotalSubjectsButton = new JButton("Submit");
        submitTotalSubjectsButton.setFont(new Font("Arial",Font.BOLD,18));
        submitTotalSubjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalSubjects = Integer.parseInt(totalSubjectsField.getText());
                showInputFrame();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("Enter total number of subjects: ");
        label2.setFont(new Font("Arial",Font.BOLD,18));
        mainPanel.add(label2);
        mainPanel.add(totalSubjectsField);
        mainPanel.add(submitTotalSubjectsButton);

        mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        mainFrame.setSize(800, 130);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void showInputFrame() {
        // Input frame after selecting the number of subjects, names and marks
        inputFrame = new JFrame("Subject Details");
        inputFrame.setSize(new Dimension(500,500));
        inputFrame.setLayout(new GridLayout(totalSubjects + 1, 3));

        JTextField[] subjectNameFields = new JTextField[totalSubjects];
        subjectMarkFields = new JTextField[totalSubjects];

        for (int i = 0; i < totalSubjects; i++) {
            inputFrame.add(new JLabel("Subject " + (i + 1) + " Name: "));
            subjectNameFields[i] = new JTextField(20);
            subjectNameFields[i].setFont(new Font("Arial",Font.BOLD,15));
            inputFrame.add(subjectNameFields[i]);

            inputFrame.add(new JLabel("Subject " + (i + 1) + " Mark: "));
            subjectMarkFields[i] = new JTextField(20);
            subjectMarkFields[i].setFont(new Font("Arial",Font.BOLD,15));
            inputFrame.add(subjectMarkFields[i]);
        }

        JButton submitMarksButton = new JButton("Submit");
        submitMarksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndShowResult();
            }
        });

        inputFrame.add(new JLabel(""));
        inputFrame.add(new JLabel(""));
        inputFrame.add(submitMarksButton);

        inputFrame.setSize(800, totalSubjects * 80);
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setVisible(true);
    }

    private void calculateAndShowResult() {
        inputFrame.dispose();
        mainFrame.dispose();
        resultFrame = new JFrame("Goodbye");
        Box resultBox = Box.createVerticalBox();


        for (int i = 0; i < totalSubjects; i++) {
            String markText = subjectMarkFields[i].getText();
            double mark = Double.parseDouble(markText);
            totalMarks += mark;
        }

        double average = totalMarks / totalSubjects;
        String grade = checkGrade(average);

        JPanel customPanel = new JPanel();
        customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));
        JLabel custom = new JLabel("Total Marks: " + totalMarks);
        JLabel customLabel = new JLabel("Average Percentage: " + average + "%");
        JLabel me = new JLabel( "\nGrade Obtained: " + grade);

        customLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        customLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        custom.setFont(new Font("Calibri", Font.BOLD, 20));
        custom.setAlignmentX(Component.CENTER_ALIGNMENT);

        me.setFont(new Font("Calibri", Font.BOLD, 20));
        me.setAlignmentX(Component.CENTER_ALIGNMENT);

        customPanel.add(customLabel);

        JOptionPane.showMessageDialog(this, custom, "Final results", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, customPanel, "Final results", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, me, "Final results", JOptionPane.INFORMATION_MESSAGE);


        JLabel label = new JLabel("\uD83D\uDCDA");
        JLabel label1 = new JLabel("Thank you for using this Student Grade Calculator!");
        label1.setFont(new Font("Calibri",Font.BOLD ,20));
        JLabel label2 = new JLabel( "\uD83D\uDCDA");


        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultBox.add(label);
        resultBox.add(label1);
        resultBox.add(label2);
        resultBox.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultFrame.dispose();
                System.exit(0);
            }
        });

        resultBox.add(okButton);
        resultFrame.add(resultBox);

        resultFrame.setSize(500, 180);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setVisible(true);
    }




    private static String checkGrade(double average)
    {

        if(average >= 90 && average <= 100)
        {
            return "A+";
        } else if(average >= 85 && average <= 89)
        {
            return "A";
        }else if(average >= 80 && average <= 84)
        {
            return "A-";
        }else if(average >= 75 && average <= 79)
        {
            return "B+";
        }else if(average >= 70 && average <= 74)
        {
            return "B";
        }else if(average >= 65 && average <= 69)
        {
            return "C+";
        }else if(average >= 60 && average <= 64)
        {
            return "C";
        }else if(average >= 55 && average <= 59)
        {
            return "D+";
        }else if(average >= 50 && average <= 54)
        {
            return "D";
        }else if(average >= 40 && average <= 49)
        {
            return "E";
        }else if(average <= 39)
        {
            return "F";
        }
        return "Error getting grade.";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentGradeCalculatorGUI();

            }
        });
    }
}

