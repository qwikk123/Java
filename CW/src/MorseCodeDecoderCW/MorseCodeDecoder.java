package MorseCodeDecoderCW;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        String[] words = morseCode.trim().split(" {3}");
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            String[] chars = s.split(" ");
            for (String c : chars) {
                sb.append(MorseCode.get(c));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
