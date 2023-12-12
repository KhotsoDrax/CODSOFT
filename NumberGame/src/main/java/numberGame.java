import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Set difficulty levels
        int easyMaxAttempts = 20;
        int mediumMaxAttempts = 15;
        int hardMaxAttempts = 10;
        int veryHardMaxAttempts = 5;

        // Ask the user to choose a difficulty level
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Very Hard");
        System.out.print("Enter the corresponding number for your choice: ");

        int difficultyChoice = scanner.nextInt();
        int maxAttempts;

        // Set maxAttempts based on the difficulty level chosen
        switch (difficultyChoice) {
            case 1:
                maxAttempts = easyMaxAttempts;
                break;
            case 2:
                maxAttempts = mediumMaxAttempts;
                break;
            case 3:
                maxAttempts = hardMaxAttempts;
                break;
            case 4:
                maxAttempts = veryHardMaxAttempts;
                break;
            default:
                System.out.println("Invalid choice. Setting difficulty to Medium.");
                maxAttempts = mediumMaxAttempts;
                break;
        }

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the randomly selected number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                guessedCorrectly = true;
                break;
            }

            if (attempts < maxAttempts) {
                // Only ask the user to try again if there are more attempts available
                System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining.");
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
        }

        scanner.close();
    }
}
