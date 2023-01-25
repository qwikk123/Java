import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\Users\\qwikk\\IdeaProjects\\Java\\AOC\\src\\StrategyGuide.txt");
        Scanner s = new Scanner(f);
        int total = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            char opponent = line.charAt(0);
            char player = line.charAt(2);
            if (win(opponent,player)) total += 6;
            else if (draw(opponent,player)) total += 3;
            total += points(player);

        }
        s.close();
        System.out.println(total);
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
}