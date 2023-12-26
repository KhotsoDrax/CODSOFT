package org.StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine();

        String[] subjects = new String[numberOfSubjects];
        int[] exams = new int[numberOfSubjects];

        // Input loop to get subject names and scores
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("Enter the subject name for Subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            System.out.println("Enter the score for " + subjects[i] + ": ");
            exams[i] = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
        }

        // Calculate average and grade
        double sum = 0;
        for (int exam : exams) {
            sum += exam;
        }

        double average = sum / numberOfSubjects;
        double percentage = average * 10;
        double roundedPercentage = Math.round(percentage / 100) * 10;

        System.out.println("The average percentage is: " + roundedPercentage + "%");

        char grade;
        if (roundedPercentage >= 90) {
            grade = 'A';
        } else if (roundedPercentage >= 80) {
            grade = 'B';
        } else if (roundedPercentage >= 70) {
            grade = 'C';
        } else if (roundedPercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("The student's grade is: " + grade);

        scanner.close();
    }
}
