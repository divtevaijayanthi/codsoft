import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalScore = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int userGuess;
            System.out.println("\nRound " + (roundsPlayed + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange);
            do {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } while (attempts < maxAttempts);
            if (userGuess!= targetNumber) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }
            roundsPlayed++;
            System.out.println("Do you want to play again? (yes/no): ");
        } while (!scanner.next().toLowerCase().equals("no"));
        System.out.println("Thanks for playing! Your total score is: " + totalScore);
        scanner.close();
    }}