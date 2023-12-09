package org.StudentGradeCalculator;

import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the score for Exam 1: ");
        int exam1 = scanner.nextInt();
        System.out.println("Enter the score for Exam 2: ");
        int exam2 = scanner.nextInt();
        System.out.println("Enter the score for Exam 3: ");
        int exam3 = scanner.nextInt();

        double average = (exam1 + exam2 + exam3) / 3.0;
        System.out.println("The average score is: " + average);

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("The student's grade is: " + grade);

        scanner.close();
    }
}
