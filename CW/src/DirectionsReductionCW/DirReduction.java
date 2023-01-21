package DirectionsReductionCW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        HashMap<String, Integer> valueMap = new HashMap<>(){{
            put("NORTH", 1);
            put("SOUTH", -1);
            put("EAST", 2);
            put("WEST", -2);
        }};
        boolean done = false;
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(arr));

        while (!done) {
            boolean removed = false;
            for (int i = tempList.size()-2, j = tempList.size()-1; i>=0; j--, i--) {
                Integer dir1 = valueMap.get(tempList.get(i));
                Integer dir2 = valueMap.get(tempList.get(j));
                if (isBad(dir1,dir2)) {
                    tempList.remove(j);
                    tempList.remove(i);
                    removed = true;
                    j -= 2;
                    i -= 2;
                }
            }
            done = !removed;
        }
        return tempList.toArray(new String[0]);
    }
    public static boolean isBad(Integer dir1, Integer dir2) {
        return dir1+dir2==0;
    }
}
