package ADP2.Aufgabe_D;

import java.util.Arrays;


public class MergeSort {
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
        int mid = a.length / 2;
        T[] leftSorted = sort(Arrays.copyOf(a, mid));

        T[] rightSorted = sort(Arrays.copyOfRange(a, mid, a.length));

        return merge(leftSorted, rightSorted);
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
        Integer []n = new Integer[]{7,6,5,4,3,2,1,0} ;
        Comparable[] sortedN = sort(n);
        Integer[] sortedNu = Arrays.copyOf(sortedN, sortedN.length, Integer[].class);
        show(sortedNu);
    }
}

