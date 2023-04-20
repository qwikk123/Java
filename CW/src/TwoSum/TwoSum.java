package TwoSum;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])) return new int[]{i, map.get(target-numbers[i])};
            else map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
