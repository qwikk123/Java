package PyramidSlideDownCW;

public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {

        int[][] maxValues = new int[pyramid.length][];
        for (int i = 0; i < maxValues.length; i++) {
            maxValues[i] = pyramid[i].clone();
        }
        for (int i = pyramid.length-1; i > 0; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                if (j == 0) {
                    maxValues[i-1][j] += maxValues[i][j];
                }
                else if (j == pyramid[i-1].length) {
                    maxValues[i-1][j-1] = Math.max(maxValues[i-1][j-1], maxValues[i][j]+pyramid[i-1][j-1]);
                }
                else {
                    maxValues[i-1][j-1] = Math.max(maxValues[i-1][j-1], maxValues[i][j]+pyramid[i-1][j-1]);
                    maxValues[i-1][j] = Math.max(maxValues[i-1][j], maxValues[i][j]+pyramid[i-1][j]);
                }
            }
        }
        return maxValues[0][0];
    }
}