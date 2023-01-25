package Day2AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day2AOC/StrategyGuide.txt");
        Scanner s = new Scanner(f);
        int total1;
        int total2;
        total1 = part1(s);
        s = new Scanner(f);
        total2 = part2(s);
        s.close();
        System.out.println(total1 + " " + total2);
    }
    public static int part1(Scanner s) {
        int total = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            char opponent = line.charAt(0);
            char player = line.charAt(2);
            if (win(opponent,player)) total += 6;
            else if (draw(opponent,player)) total += 3;
            total += points(player);
        }
        return total;
    }

    public static boolean win(char opponent, char player) {
        if (opponent == 'A' && player == 'Y') return true;
        if (opponent == 'B' && player == 'Z') return true;
        if (opponent == 'C' && player == 'X') return true;
        return false;
    }
    public static boolean draw(char opponent, char player) {
        if (opponent == 'A' && player == 'X') return true;
        if (opponent == 'B' && player == 'Y') return true;
        if (opponent == 'C' && player == 'Z') return true;
        return false;
    }
    public static int points(char player) {
        if (player == 'X') return 1;
        if (player == 'Y') return 2;
        if (player == 'Z') return 3;
        return -1;
    }
    public static int part2(Scanner s) {
        int total = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            char opponent = line.charAt(0);
            char outcome = line.charAt(2);
            total += req(opponent, outcome);
        }
        return total;
    }
    public static int req (char opponent, char outcome) {
        if (outcome == 'X') return lose2(opponent);
        if (outcome == 'Y') return draw2(opponent);
        if (outcome == 'Z') return win2(opponent);
        return -1;
    }
    public static int lose2(char opponent) {
        if (opponent == 'A') return 3;
        if (opponent == 'B') return 1;
        return 2;
    }
    public static int draw2(char opponent) {
        if (opponent == 'A') return 1+3;
        if (opponent == 'B') return 2+3;
        return 3+3;
    }
    public static int win2(char opponent) {
        if (opponent == 'A') return 2+6;
        if (opponent == 'B') return 3+6;
        return 1+6;
    }
}