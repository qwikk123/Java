package AddingBigNumbersCW;

public class Kata {
    public static String add(String a, String b) {
        System.out.println(a+" + " +b);
        StringBuilder sb = new StringBuilder();
        Integer rest = 0;
        int currentA = a.length()-1, currentB = b.length()-1;

        while (currentA >= 0 || currentB >= 0) {
            Integer intA = (currentA >= 0) ? Integer.parseInt(Character.toString(a.charAt(currentA))) : 0;
            Integer intB = (currentB >= 0) ? Integer.parseInt(Character.toString(b.charAt(currentB))) : 0;
            Integer newNumber = intA+intB+rest;
            rest = 0;
            if (newNumber >= 10) {
                newNumber -= 10;
                sb.append(newNumber);
                rest = 1;
            } else {
                sb.append(newNumber);
            }

            currentA--; currentB--;
        }
        if(rest == 1 && a.length() == b.length()) sb.append(rest);

        return sb.reverse().toString().replaceFirst("^0+(?!$)", "");
    }
}