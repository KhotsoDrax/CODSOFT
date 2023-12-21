package org.NumberGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGameGUI {
    private JFrame frame;
    private JTextField guessTextField;
    private JTextArea resultTextArea;

    private int numberToGuess;
    private int attempts;
    private int maxAttempts;
    private boolean guessedCorrectly;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGameGUI gameGUI = new NumberGameGUI();
            gameGUI.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Difficulty level choice
        String[] difficultyOptions = {"Easy", "Medium", "Hard", "Very Hard"};
        JComboBox<String> difficultyComboBox = new JComboBox<>(difficultyOptions);
        panel.add(new JLabel("Choose a difficulty level:"), constraints);
        panel.add(difficultyComboBox, constraints);

        // Start button
        JButton startButton = new JButton("Start Game");
        constraints.gridy = 1;
        panel.add(startButton, constraints);

        // Guess input field
        guessTextField = new JTextField(10);
        constraints.gridy = 2;
        panel.add(new JLabel("Enter your guess:"), constraints);
        panel.add(guessTextField, constraints);

        // Guess button
        JButton guessButton = new JButton("Guess");
        constraints.gridy = 3;
        panel.add(guessButton, constraints);

        // Result display area
        resultTextArea = new JTextArea(5, 20);
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridy = 4;
        panel.add(scrollPane, constraints);

        // Initialize the game
        startButton.addActionListener(e -> startGame(difficultyComboBox.getSelectedIndex()));
        guessButton.addActionListener(e -> makeGuess());

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    private void startGame(int difficultyIndex) {
        Random random = new Random();
        guessedCorrectly = false;
        attempts = 0;

        switch (difficultyIndex) {
            case 0:
                maxAttempts = 20;
                break;
            case 1:
                maxAttempts = 15;
                break;
            case 2:
                maxAttempts = 10;
                break;
            case 3:
                maxAttempts = 5;
                break;
            default:
                maxAttempts = 15; // Default to medium difficulty
        }

        numberToGuess = random.nextInt(100) + 1;
        resultTextArea.setText("Welcome to the Number Guessing Game!\n" +
                "Try to guess the randomly selected number between 1 and 100.\n" +
                "You have " + maxAttempts + " attempts.");
    }

    private void makeGuess() {
        if (!guessedCorrectly && attempts < maxAttempts) {
            int guess = Integer.parseInt(guessTextField.getText());
            attempts++;

            if (guess < numberToGuess) {
                resultTextArea.append("\nToo low! Try again.");
            } else if (guess > numberToGuess) {
                resultTextArea.append("\nToo high! Try again.");
            } else {
                guessedCorrectly = true;
                resultTextArea.append("\nCongratulations! You've guessed the number " +
                        numberToGuess + " in " + attempts + " attempts.");
            }

            if (attempts < maxAttempts) {
                resultTextArea.append("\nYou have " + (maxAttempts - attempts) + " attempts remaining.");
            } else if (!guessedCorrectly) {
                resultTextArea.append("\nSorry, you've run out of attempts. The correct number was: " + numberToGuess);
            }

            guessTextField.setText("");
        }
    }
}
