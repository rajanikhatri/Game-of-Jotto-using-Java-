import java.util.Scanner;
public class Jotto {
    public static void main(String[] args) {
        String mysteryWord;
        String guess;
        int guessCount;
        System.out.println("=== JOTTO ===");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter mystery word: ");
        mysteryWord = input.nextLine().toLowerCase();
        guess = "";
        guessCount = 0;
        if (!validateWord(mysteryWord)) {
            System.out.println("The supplied mystery word is not valid.");
            System.exit(0);
        }
        else {
            while (!guess.equalsIgnoreCase("quit")) {
                System.out.print("Enter your guess: ");
                guess = input.nextLine().toLowerCase();
                int score = scoreWord(mysteryWord, guess);
                if (guess.equalsIgnoreCase("quit")) {
                    System.out.println("Thank you for playing goodbye!");
                    System.exit(0);
                }
                else if (!validateWord(guess)) {
                    System.out.println("The supplied guess is not valid.");
                }
                else {
                    if (score == 5) {
                        System.out.println("You Won!");
                        System.out.println("Game Score: " + scoreGame(guessCount));
                        System.exit(0);
                    }
                    else {
                        System.out.println("Score: " + score);
                        guessCount += 1;
                    }
                }
            }
            System.out.println("Thank you for playing goodbye!");
            System.exit(0);
        }
    }

    public static boolean validateWord(String mysteryWord) {
        int similarity = 0;
        for (int i = 1; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i) == (mysteryWord.charAt(i-1))) {
                similarity += 1;
            }
            else {
                similarity += 0;
            }
        }
        if (similarity == 0 && mysteryWord.length() == 5) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int scoreWord(String mysteryWord, String guess) {
        int wordScore = 0;
        for (int i = 0; i < mysteryWord.length(); i++) {
            for (int j = 0; j < guess.length(); j++){
                if (guess.charAt(j) == mysteryWord.charAt(i)) {
                    wordScore += 1;
                }
            }
        }
        return wordScore;
    }

    public static int scoreGame(int guessCount) {
        int gameScore;
        gameScore = 100 - (guessCount * 5);
        return gameScore;
    }
}


/*
Output1:
=== JOTTO ===
Enter mystery word: PEACH
Enter your guess: PEARS
Score: 3
Enter your guess: prune
Score: 2
Enter your guess: PeACh
You Won!
Game Score: 90

Output 2:
=== JOTTO ===
Enter mystery word: apple
The supplied mystery word is not valid.

Output 3:
=== JOTTO ===
Enter mystery word: gourds
The supplied mystery word is not valid.

Output 4:
=== JOTTO ===
Enter mystery word: GOURD
Enter your guess: banana
The supplied guess is not valid.
Enter your guess: GRAPE
Score: 2
Enter your guess: GREAT
Score: 2
Enter your guess: GRAND
Score: 3
Enter your guess: GOURD
You Won!
Game Score: 85

Output 5:
=== JOTTO ===
Enter mystery word: FRUIT
Enter your guess: GRAPE
Score: 1
Enter your guess: qUiT
Thank you for playing goodbye!
 */

