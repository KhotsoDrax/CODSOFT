//package org.NumberGame;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.util.Random;
//
//public class NumberGameGUI extends Application {
//    private int numberToGuess;
//    private int maxAttempts;
//    private int attempts;
//    private boolean guessedCorrectly;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Number Guessing Game");
//
//        VBox vbox = new VBox(10);
//        vbox.setAlignment(Pos.CENTER);
//
//        Label label = new Label("Welcome to the Number Guessing Game!");
//        Label instructionLabel = new Label("Try to guess the randomly selected number between 1 and 100.");
//
//        Button startButton = new Button("Start Game");
//
//        startButton.setOnAction(e -> {
//            startGame();
//            displayGuessingGame(primaryStage);
//        });
//
//        vbox.getChildren().addAll(label, instructionLabel, startButton);
//
//        Scene scene = new Scene(vbox, 400, 200);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//    }
//
//    private void startGame() {
//        Random random = new Random();
//
//        // Set difficulty levels
//        int easyMaxAttempts = 20;
//        int mediumMaxAttempts = 15;
//        int hardMaxAttempts = 10;
//        int veryHardMaxAttempts = 5;
//
//        // Set maxAttempts based on the difficulty level chosen
//        int difficultyChoice = 2;  // Default to Medium
//        switch (difficultyChoice) {
//            case 1:
//                maxAttempts = easyMaxAttempts;
//                break;
//            case 2:
//                maxAttempts = mediumMaxAttempts;
//                break;
//            case 3:
//                maxAttempts = hardMaxAttempts;
//                break;
//            case 4:
//                maxAttempts = veryHardMaxAttempts;
//                break;
//            default:
//                maxAttempts = mediumMaxAttempts;
//                break;
//        }
//
//        numberToGuess = random.nextInt(100) + 1;
//        attempts = 0;
//        guessedCorrectly = false;
//    }
//
//    private void displayGuessingGame(Stage primaryStage) {
//        VBox vbox = new VBox(10);
//        vbox.setAlignment(Pos.CENTER);
//
//        Label guessLabel = new Label("Enter your guess:");
//        TextField guessTextField = new TextField();
//        Button guessButton = new Button("Submit Guess");
//
//        guessButton.setOnAction(e -> {
//            handleGuess(Integer.parseInt(guessTextField.getText()));
//            if (!guessedCorrectly && attempts < maxAttempts) {
//                guessTextField.clear();
//                guessTextField.requestFocus();
//            } else {
//                displayResult(primaryStage);
//            }
//        });
//
//        vbox.getChildren().addAll(guessLabel, guessTextField, guessButton);
//
//        Scene scene = new Scene(vbox, 400, 200);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//    }
//
//    private void handleGuess(int guess) {
//        attempts++;
//
//        if (guess < numberToGuess) {
//            System.out.println("Too low! Try again.");
//        } else if (guess > numberToGuess) {
//            System.out.println("Too high! Try again.");
//        } else {
//            guessedCorrectly = true;
//        }
//
//        if (attempts < maxAttempts) {
//            // Only ask the user to try again if there are more attempts available
//            System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining.");
//        }
//    }
//
//    private void displayResult(Stage primaryStage) {
//        VBox vbox = new VBox(10);
//        vbox.setAlignment(Pos.CENTER);
//
//        if (guessedCorrectly) {
//            Label resultLabel = new Label("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
//            vbox.getChildren().add(resultLabel);
//        } else {
//            Label resultLabel = new Label("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
//            vbox.getChildren().add(resultLabel);
//        }
//
//        Button restartButton = new Button("Play Again");
//        restartButton.setOnAction(e -> start(primaryStage));
//
//        vbox.getChildren().add(restartButton);
//
//        Scene scene = new Scene(vbox, 400, 200);
//        primaryStage.setScene(scene);
//    }
//}
