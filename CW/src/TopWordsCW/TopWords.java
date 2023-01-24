package TopWordsCW;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopWords {
    public static List<String> top3(String s) {
        HashMap<String, Integer> stringMap = new HashMap<>();
        String stripped = s.replaceAll("[^a-zA-Z' ]", " ").trim();
        stripped = stripped.replaceAll("(?<!\\w)'(?!\\w)", "");
        stripped = stripped.replaceAll("'{2,}", "");
        stripped = stripped.replaceAll("\n", "");
        if (stripped.equals("")) {return new LinkedList<>();}

        for (String w : stripped.split(" +")) {
            stringMap.merge(w.toLowerCase(), 1, Integer::sum);
        }
        return stringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}