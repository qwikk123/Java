package EnoughIsEnoughCW;

import java.util.HashMap;
import java.util.LinkedList;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> intList = new LinkedList<>();
        for (int i : elements) {
            map.computeIfPresent(i, (k,v) -> v+1);
            map.putIfAbsent(i,1);
            if (map.get(i) <= maxOccurrences) {
                intList.add(i);
            }
        }
        return intList.stream().mapToInt(x -> x).toArray();
    }

}
