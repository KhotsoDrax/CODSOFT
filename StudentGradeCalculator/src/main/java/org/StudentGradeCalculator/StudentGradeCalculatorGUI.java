//package org.StudentGradeCalculator;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class StudentGradeCalculatorGUI extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Student Grade Calculator");
//
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25, 25, 25, 25));
//
//        TextField[] subjectFields = new TextField[5];
//        TextField[] scoreFields = new TextField[5];
//
//        for (int i = 0; i < 5; i++) {
//            Label subjectLabel = new Label("Subject for Exam " + (i + 1) + ":");
//            grid.add(subjectLabel, 0, i);
//
//            subjectFields[i] = new TextField();
//            grid.add(subjectFields[i], 1, i);
//
//            Label scoreLabel = new Label("Score for Exam " + (i + 1) + ":");
//            grid.add(scoreLabel, 2, i);
//
//            scoreFields[i] = new TextField();
//            grid.add(scoreFields[i], 3, i);
//        }
//
//        Button calculateButton = new Button("Calculate");
//        grid.add(calculateButton, 1, 5);
//
//        Label resultLabel = new Label("");
//        grid.add(resultLabel, 1, 6);
//
//        calculateButton.setOnAction(e -> {
//            int[] examScores = new int[5];
//
//            for (int i = 0; i < 5; i++) {
//                examScores[i] = Integer.parseInt(scoreFields[i].getText());
//            }
//
//            double average = (examScores[0] + examScores[1] + examScores[2] + examScores[3] + examScores[4]) / 5.0;
//            double percentage = average * 10;
//            double roundedPercentage = Math.round(percentage / 100) * 10;
//
//            resultLabel.setText("The average percentage is: " + roundedPercentage + "%");
//
//            char grade;
//            if (roundedPercentage >= 90) {
//                grade = 'A';
//            } else if (roundedPercentage >= 80) {
//                grade = 'B';
//            } else if (roundedPercentage >= 70) {
//                grade = 'C';
//            } else if (roundedPercentage >= 60) {
//                grade = 'D';
//            } else {
//                grade = 'F';
//            }
//
//            resultLabel.setText(resultLabel.getText() + "\n" + "The student's grade is: " + grade);
//        });
//
//        Scene scene = new Scene(grid, 500, 300);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//    }
//}
