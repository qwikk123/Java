package CountingDuplicatesCW;

import java.util.HashMap;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        HashMap<Character, Integer> occurrences = new HashMap<>();
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            Character c = Character.toLowerCase(text.charAt(i));
            Integer n = occurrences.get(c);
            if (n == null) occurrences.put(c, 1);
            else if (n == 1) {count++;occurrences.put(c, n+1);}
            else occurrences.put(c, n+1);
        }
        return count;
    }
}
