package StringJustifyCW;

import java.util.Arrays;

public class StringJustify {

    public static void main(String[] args) {
        String testString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusce at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. Vivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, non dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at fermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum velit ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellentesque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla et dolor.";
        if (args.length != 2) {
            System.out.println("only 2 arg \"string\" \"length\"");
            System.exit(0);
        }
        int length = 0;
        String text = testString;
        try {
            length = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Length not a number");
            System.exit(0);
        }

        String printout = "";

        String[] tokens = text.split(" ");
        int rest = 0;
        int lineLength = 0;
        for (int i = 0; i < tokens.length; i++) {

            lineLength += tokens[i].length();

            if (lineLength + i - rest > length) {
                lineLength += i - rest - 1;
                lineLength -= tokens[i].length();

                int spaces = length - lineLength;
                String line = "";
                String[] space = new String[Math.max(1, i - rest - 1)];

                if (i - rest - 1 < 1) {
                    spaces--;
                }
                Arrays.fill(space, " ");

                int adder = 0;
                while (spaces > 0) {
                    if (adder > space.length - 1) {
                        adder = 0;
                    }
                    space[adder] += " ";
                    adder++;
                    spaces--;
                }
                int addspace = 0;
                for (int x = rest; x < i; x++) {
                    line += tokens[x];
                    if (addspace < space.length) {
                        line += space[addspace];
                    }
                    addspace++;
                }
                printout += line + "\n";

                rest = i;
                lineLength = 0;
                i--;
            }
        }
        for (int i = rest; i < tokens.length; i++) {
            printout += tokens[i] + " ";
        }

        System.out.println(printout);
    }
}
