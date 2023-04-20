public class TrappingWater {
    //  Google interview question: Given a list of numbers representing the height of bars in a bar chart calculate how
    //  many units of water the entire bar chart can hold.
    public static void main(String[] args) {
        int[] bars1 = new int[]{4, 2, 3, 5};
        int[] bars2 = new int[]{4, 2, 2, 5};
        int[] bars3 = new int[]{8, 1, 4, 2, 2, 5};
        int[] bars4 = new int[]{2, 6, 3, 5, 2, 8, 1, 4, 2, 2, 5, 3, 5, 7, 4, 2, 1};
        int[] bars5 = new int[]{4, 2, 3, 5, 6};
        int[] bars6 = new int[]{4, 2, 5, 6};

        System.out.println(calculateWater(bars1));
        System.out.println(calculateWater(bars2));
        System.out.println(calculateWater(bars3));
        System.out.println(calculateWater(bars4));
        System.out.println(calculateWater(bars5));
        System.out.println(calculateWater(bars6));

    }

    public static int calculateWater(int[] bars) {
        int water = 0;
        int lefttop = 0; int righttop = 0;
        int left=0; int right=bars.length-1;

        while(left < right) {
            if (bars[left] < bars[right]) {
                if (bars[left] >= lefttop) lefttop = bars[left];
                else water += lefttop - bars[left];
                left++;
            }
            else {
                if (bars[right] >= righttop) righttop = bars[right];
                else water += righttop - bars[right];
                right--;
            }
        }
        return water;
    }
}
