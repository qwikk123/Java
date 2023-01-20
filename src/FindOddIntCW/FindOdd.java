package FindOddIntCW;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {
        HashMap<Integer,Boolean> oddMap = new HashMap<>();

        for (int i: a) {
            if (oddMap.containsKey(i)) {
                oddMap.put(i,!oddMap.get(i));
            }
            else {
                oddMap.put(i,true);
            }
        }

        for (Map.Entry<Integer, Boolean> oddSet: oddMap.entrySet())
            if (oddSet.getValue()) return oddSet.getKey();

        return -1;
    }
}
