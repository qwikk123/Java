package PyramidSlideDownCW;

public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {

        int[][] maxValues = new int[pyramid.length][];
        for (int i = 0; i < maxValues.length; i++) {
            maxValues[i] = pyramid[i].clone();
        }
        for (int i = pyramid.length-1; i > 0; i--) {
            for (int j = 0; j < pyramid[i].length-1; j++) {
                maxValues[i-1][j] += Math.max(maxValues[i][j], maxValues[i][j+1]);

            }
        }
        return maxValues[0][0];
    }
}