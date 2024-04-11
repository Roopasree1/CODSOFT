package task3;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 3;
        int score = 0;

        System.out.println("Welcome To Guess!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Can you guess what it is?");
            int attempts = 0;
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess)
                {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                }
                else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } 
                else
                {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsLimit)
                {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
                }
            }

            System.out.print("Wanna play Again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("Glad you played! Your score: " + score);
    }
}
