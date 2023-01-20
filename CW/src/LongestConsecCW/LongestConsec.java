package LongestConsecCW;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (k > strarr.length || k <= 0) return "";

        int longest = 0;
        int start = 0;

        for (int i = 0; i <= strarr.length-k; i++) {
            int newLength = 0;
            for (int j = i; j < i+k; j++) {
                newLength += strarr[j].length();
            }
            if (newLength > longest) {
                longest = newLength;
                start = i;
            }
        }
        StringBuilder newString = new StringBuilder();
        for (int i = start; i < start + k; i++) {
            newString.append(strarr[i]);
        }

        return newString.toString();
    }
}
