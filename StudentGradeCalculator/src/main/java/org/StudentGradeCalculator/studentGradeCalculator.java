import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the subject for the first exam: ");
        String subject1 = scanner.nextLine();
        System.out.println("Enter the score for " + subject1 + ": ");
        int exam1 = scanner.nextInt();

        scanner.nextLine();  // Consume the newline character

        System.out.println("Enter the subject for the second exam: ");
        String subject2 = scanner.nextLine();
        System.out.println("Enter the score for " + subject2 + ": ");
        int exam2 = scanner.nextInt();

        scanner.nextLine();  // Consume the newline character

        System.out.println("Enter the subject for the third exam: ");
        String subject3 = scanner.nextLine();
        System.out.println("Enter the score for " + subject3 + ": ");
        int exam3 = scanner.nextInt();

        scanner.nextLine();  // Consume the newline character

        System.out.println("Enter the subject for the fourth exam: ");
        String subject4 = scanner.nextLine();
        System.out.println("Enter the score for " + subject4 + ": ");
        int exam4 = scanner.nextInt();

        scanner.nextLine();  // Consume the newline character

        System.out.println("Enter the subject for the fifth exam: ");
        String subject5 = scanner.nextLine();
        System.out.println("Enter the score for " + subject5 + ": ");
        int exam5 = scanner.nextInt();

        double average = (exam1 + exam2 + exam3 + exam4 + exam5) / 5.0;
        double percentage = average * 10; // Calculate percentage
        double roundedPercentage = Math.round(percentage / 100) * 10; // Round off to nearest 10

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
