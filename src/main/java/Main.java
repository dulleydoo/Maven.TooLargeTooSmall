import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    static int start = 0;
    static int stop = 20;

    public static void main(String[] args) {
        Main call = new Main();
        call.game();
    }

    public static int randomNumb() {
        Random a = new Random();
        int any = a.nextInt(stop);
        return any;
    }

    public void pick() {
        System.out.println("Enter a number " + start + "-" + stop);
    }

    private static int input() {
        Scanner user = new Scanner(System.in);
        Main m = new Main();
        m.pick();
        int choose = user.nextInt();
        return choose;

    }

    public void game() {
        check();
    }


    public int check() {
        boolean c = true;
        int d = randomNumb();
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        int counter = 0;
        while (c) {
            System.out.println("guess #" + counter);
            int guess = input();
            if (guess == d) {
                System.out.println("correct guess");
                guesses.add(guess);
                counter++;
                break;
            } else if (guess < d) {
                System.out.println("too small");
                if (!guesses.contains(guess)) {
                    guesses.add(guess);
                } else if (guesses.contains(guess)) {
                    System.out.println("Number already guessed");

                }
                counter++;
            } else if (guess > d) {
                System.out.println("too large");
                if (!guesses.contains(guess)) {
                    guesses.add(guess);
                } else if (guesses.contains(guess)) {
                    System.out.println("Number already guessed");

                }
                counter++;


            } else {
                System.out.println("Error");
                exit(5);
            }

        }
        System.out.println("It took you " + guesses.size() + " guesses");
        return guesses.size();
    }
}
