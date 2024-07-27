import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        // Number Game using Java Programming project 1
        Scanner sc = new Scanner(System.in);
        int chances = 5;
        int finals = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + chances + " chances to win the game.");

        while (playAgain) {
            int rand = getrandN(1, 100);
            boolean guess = false;

            for (int i = 0; i < chances; i++) {
                System.out.println("Chance " + (i + 1) + ": Enter your guess:");
                int user = sc.nextInt();
                sc.nextLine(); // Consume newline left-over

                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("Congratulations! You guessed it right.");
                    break;
                } else if (user > rand) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
            }

            if (!guess) {
                System.out.println("Sorry, you lost all chances. The number was: " + rand);
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String play = sc.nextLine();
            playAgain = play.equalsIgnoreCase("Y");
        }

        System.out.println("Hope you enjoyed playing!");
        System.out.println("Here is your score: " + finals);

        sc.close();
    }

    public static int getrandN(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
