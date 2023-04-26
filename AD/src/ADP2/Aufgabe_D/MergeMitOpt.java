package ADP2.Aufgabe_D;

import java.util.Arrays;


public class MergeMitOpt {
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
        if (isSorted(a)) {
            //System.out.println("if");
            return a;

        }
        if (a.length <= insertionGrenze) {
            // Wechsel zu InsertionSort für Arrays der Größe <= 10
            insertionsort(a, 0, a.length - 1);
        } else {
            int oneThird = a.length / 3;
            int twoThirds = a.length * 2 / 3;


            T[] leftSorted = sort(Arrays.copyOfRange(a, 0, oneThird));
            T[] centerSorted = sort(Arrays.copyOfRange(a, oneThird, twoThirds));

            T[] merged = merge(leftSorted, centerSorted);
            T[] rightSorted = sort(Arrays.copyOfRange(a, twoThirds, a.length));
            return merge(merged, rightSorted);

        }
        return a;
    }

    static <T extends Comparable<? super T>> void insertionsort(T[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static <T extends Comparable<? super T>> T[] merge(T[] left, T[] right) {
        T[] merged = (T[]) new Comparable[left.length + right.length];
        int leftC = 0;
        int rightC = 0;
        for (int i = 0; i < merged.length; i++) {
            if (leftC >= left.length) merged[i] = right[rightC++];
            else if (rightC >= right.length) merged[i] = left[leftC++];
            else if (less(right[rightC], left[leftC])) merged[i] = right[rightC++];
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

        String s = "M E R G E S O R T E X A M P L E";
        String[] in = s.split(" ");
        Comparable[] sorted = sort(in);
        String[] sortedString = Arrays.copyOf(sorted, sorted.length, String[].class);
        show(sortedString);
        Integer[] n = new Integer[100];
        for (int i = 0; i < n.length; i++) {
            if (i < 50) {
                n[i] =n.length - i;

            }else {
                n[i] = i-50;
            }
        }
        Comparable[] sortedNix = n;
        Integer[] sortedNummernix = Arrays.copyOf(sortedNix, sortedNix.length, Integer[].class);
        show(sortedNummernix);
        Comparable[] sortedN = sort(n);
        Integer[] sortedNummer = Arrays.copyOf(sortedN, sortedN.length, Integer[].class);
        show(sortedNummer);
    }
}


