import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        playGuessingGame();
    }

    public static void playGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsPlayed = 0;

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            System.out.println("Round " + (roundsPlayed + 1));

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + lowerRange + " and " + upperRange + ": ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    break;
                }
            }

            roundsPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds and took " + totalAttempts + " total attempts.");
    }
}
