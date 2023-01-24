package ValidParenthesesCW;

public class ValidParentheses {
    public static boolean validParentheses(String parens) {
        int counter = 0;
        for (int i = 0; i < parens.length(); i++) {
            char next = parens.charAt(i);
            if (next == '(') {counter++; continue;}
            if (next == ')') {
                if (counter == 0) return false;
                counter--;
            }
        }
        return counter == 0;
    }
}
