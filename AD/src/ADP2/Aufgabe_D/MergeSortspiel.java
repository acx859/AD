package ADP2.Aufgabe_D;

import java.util.Arrays;


public class MergeSortspiel {
    private static final int insertionGrenze = 10; // Schwellenwert für Wechsel zu InsertionSort

    public static <T extends Comparable<? super T>> T[] sort(T[] a) {
        if (a.length <= 1) return a;
        if (a.length == 2) { // Spezialfall für Arrays mit Länge 2
            if (a[0].compareTo(a[1]) > 0) {
                T temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            return a;
        }
        int elements = a.length;
        int sizeLeft;
        int sizeCenter;
        int sizeRight;
        /*if (elements == 2) {
            T[] centerSorted = (T[]) new Comparable[]{};
            T[] leftSorted = sort(Arrays.copyOfRange(a, 0, 1));
            T[] rightSorted = sort(Arrays.copyOfRange(a, 1, a.length));
            return merge(a, leftSorted, centerSorted, rightSorted);
        }*/
        if (elements > 2) {
            int oneThird = a.length / 3;
            int twoThirds = a.length * 2 / 3;

            T[] leftSorted = sort(Arrays.copyOfRange(a, 0, oneThird));
            T[] centerSorted = sort(Arrays.copyOfRange(a, oneThird, twoThirds));
            T[] rightSorted = sort(Arrays.copyOfRange(a, twoThirds, a.length));


            return merge(a, leftSorted, centerSorted, rightSorted);
        } else {
            return a;
        }
    }

    private static <T extends Comparable<? super T>> T[] merge(T[] a, T[] left, T[] center, T[] right) {
        T[] merged = (T[]) new Comparable[left.length + center.length + right.length];
        int totalC = 0;
        int leftC = 0;
        int rightC = 0;
        int centerC = 0;
        for (int i = 0; i < merged.length; i++) {
            if ((leftC >= left.length)&&(centerC >= center.length)) merged[i] = right[rightC++];
            else if ((rightC >= right.length)&&(leftC >= left.length)) merged[i] = center[centerC++];
            else if ((rightC >= right.length)&&(centerC >= center.length)) merged[i] = left[leftC++];
            else if ((less(right[rightC], left[leftC]))&&(less(right[rightC], center[centerC]))) merged[i] = right[rightC++];
            else if ((less(center[centerC], left[leftC]))&&(less(center[centerC], right[rightC]))) merged[i] = center[centerC++];
            else merged[i] = left[leftC++];
        }

        return merged;
    }

    public static <T extends Comparable<? super T>> boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static <T> void show(T[] a) {
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {

        String s = "6 5 4 3 2 1";
        String[] in = s.split(" ");
        Comparable[] sorted = sort(in);
        String[] sortedString = Arrays.copyOf(sorted, sorted.length, String[].class);
        show(sortedString);
    }
}

