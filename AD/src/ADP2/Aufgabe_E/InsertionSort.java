package ADP2.Aufgabe_E;
public class InsertionSort extends SortClassCommons {
    public static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= lo && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
