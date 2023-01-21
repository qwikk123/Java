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
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(arr));

        for (int i = tempList.size()-2, j = tempList.size()-1; i>=0; j--, i--) {
            if (valueMap.get(tempList.get(i)) + valueMap.get(tempList.get(j)) == 0) {
                tempList.remove(j);
                tempList.remove(i);
                j = Math.min(tempList.size(), j+2);
                i = j-1;
            }
        }

        return tempList.toArray(new String[0]);
    }
}
