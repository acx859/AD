package ADP2.Aufgabe_D;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 4, 3, 2, 5, 7, 9, 0};
        int oneThird = a.length / 3;
        int twoThirds = a.length * 2 / 3;

        int[] leftSorted = Arrays.copyOfRange(a, 0, oneThird);
        int[] centerSorted = Arrays.copyOfRange(a, oneThird, twoThirds);


        int[] rightSorted = Arrays.copyOfRange(a, twoThirds, a.length);
        System.out.println("leftSorted:");
        for (int i = 0; i < leftSorted.length; i++) {
            System.out.println(leftSorted[i]);
        }

        System.out.println("centerSorted:");
        for (int i = 0; i < centerSorted.length; i++) {
            System.out.println(centerSorted[i]);
        }

        System.out.println("rightSorted:");
        for (int i = 0; i < rightSorted.length; i++) {
            System.out.println(rightSorted[i]);
        }
    }
}
