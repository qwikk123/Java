package SpiralizorCW;

import java.util.Arrays;

public class Spiralizor {

    public static int[][] spiralize(int size) {
        int check = (size % 2 == 0) ? 3 : 2;
        int[][] spiral = new int[size][size];
        direction d = direction.RIGHT;
        Arrays.fill(spiral[0],1);
        Arrays.fill(spiral[size-1],1);

        for (int i = 0; i < size-1; i++) {
            spiral[i][size-1] = 1;
            if (i > 1) spiral[i][0] = 1;
        }

        int x = 1;
        int y = 2;
        while (true) {
            spiral[y][x] = 1;
            if (d == direction.RIGHT) {
                if (spiral[y][x+2] == 1){
                    d = direction.DOWN;
                    if (spiral[y+check][x] == 1) {
                        if (check == 3) spiral[y+1][x] = 1;
                        break;
                    }
                } else {
                    x++;
                }
            }
            else if (d == direction.DOWN) {
                if (spiral[y+2][x] == 1){
                    d = direction.LEFT;
                    if (spiral[y][x-check] == 1) {
                        if (check == 3) spiral[y][x-1] = 1;
                        break;
                    }
                } else {
                    y++;
                }
            }
            else if (d == direction.LEFT) {
                if (spiral[y][x-2] == 1){
                    d = direction.UP;
                    if (spiral[y-check][x] == 1) {
                        if (check == 3) spiral[y-1][x] = 1;
                        break;
                    }
                } else {
                    x--;
                }
            }
            else if (d == direction.UP) {
                if (spiral[y-2][x] == 1){
                    d = direction.RIGHT;
                    if (spiral[y][x+check] == 1) {
                        if (check == 3) spiral[y][x+1] = 1;
                        break;
                    }
                } else {
                    y--;
                }
            }
        }
        return spiral;
    }
    enum direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }
}