//package org.StudentGradeCalculator;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class StudentGradeCalculatorGUI {
//    private JFrame frame;
//    private JTextField[] subjectFields;
//    private JTextField[] scoreFields;
//    private JButton calculateButton;
//    private JTextArea resultTextArea;
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            StudentGradeCalculatorGUI calculatorGUI = new StudentGradeCalculatorGUI();
//            calculatorGUI.createAndShowGUI();
//        });
//    }
//
//    private void createAndShowGUI() {
//        frame = new JFrame("Student Grade Calculator");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(5, 5, 5, 5);
//
//        // Subject and Score input fields
//        subjectFields = new JTextField[5];
//        scoreFields = new JTextField[5];
//
//        for (int i = 0; i < 5; i++) {
//            panel.add(new JLabel("Subject for Exam " + (i + 1) + ":"), constraints);
//            subjectFields[i] = new JTextField(10);
//            panel.add(subjectFields[i], constraints);
//
//            panel.add(new JLabel("Score for Exam " + (i + 1) + ":"), constraints);
//            scoreFields[i] = new JTextField(3);
//            panel.add(scoreFields[i], constraints);
//        }
//
//        // Calculate button
//        calculateButton = new JButton("Calculate");
//        calculateButton.addActionListener(e -> calculateGrade());
//        constraints.gridy = 1;
//        constraints.gridwidth = 2;
//        panel.add(calculateButton, constraints);
//
//        // Result display area
//        resultTextArea = new JTextArea(5, 30);
//        resultTextArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(resultTextArea);
//        constraints.gridy = 2;
//        panel.add(scrollPane, constraints);
//
//        frame.add(panel);
//        frame.pack();
//        frame.setLocationRelativeTo(null); // Center the frame
//        frame.setVisible(true);
//    }
//
//    private void calculateGrade() {
//        int[] examScores = new int[5];
//
//        for (int i = 0; i < 5; i++) {
//            try {
//                examScores[i] = Integer.parseInt(scoreFields[i].getText());
//            } catch (NumberFormatException e) {
//                resultTextArea.setText("Invalid input. Please enter valid scores.");
//                return;
//            }
//        }
//
//        double average = (examScores[0] + examScores[1] + examScores[2] + examScores[3] + examScores[4]) / 5.0;
//        double percentage = average * 10;
//        double roundedPercentage = Math.round(percentage / 100) * 10;
//
//        resultTextArea.setText("The average percentage is: " + roundedPercentage + "%");
//
//        char grade;
//        if (roundedPercentage >= 90) {
//            grade = 'A';
//        } else if (roundedPercentage >= 80) {
//            grade = 'B';
//        } else if (roundedPercentage >= 70) {
//            grade = 'C';
//        } else if (roundedPercentage >= 60) {
//            grade = 'D';
//        } else {
//            grade = 'F';
//        }
//
//        resultTextArea.append("\nThe student's grade is: " + grade);
//    }
//}
