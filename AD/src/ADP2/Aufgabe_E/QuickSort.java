package ADP2.Aufgabe_E;

import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

import static ADP2.Aufgabe_E.SortClassCommons.*;


public class QuickSort {
    private static final int insertionGrenze = 10; // Schwellenwert für Wechsel zu InsertionSort

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        StdRandom.shuffle(a);// Mischen des Arrays, um die Wahrscheinlichkeit von Worst-Case-Szenarien zu reduzieren
        sort(a, 0, a.length - 1); // Aufruf der rekursiven QuickSort-Methode mit dem gesamten Array
        assert isSorted(a);

    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        if (hi - lo + 1 <= insertionGrenze) {
            // Wechsel zu InsertionSort für Arrays der Größe <= 10
            InsertionSort.sort(a, lo, hi);
        } else {
            int pivot = partition(a, lo, hi);
            sort(a, lo, pivot );
            sort(a, pivot, hi);
        }
    }

    static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        T pivot = a[medianOf5(a, lo, hi)];
        while (true) {
            while (less(a[++i], pivot))
                if (i == hi) break; // Suche nach einem Element größer als das Pivotelement von links
            while (less(pivot, a[--j]))
                if (j == lo) break; // Suche nach einem Element kleiner als das Pivotelement von rechts
            if (i >= j)
                break; // Wenn sich die beiden Suchindizes i und j gekreuzt haben, ist die Partitionierung abgeschlossen
            exch(a, i, j); // Tausch der beiden Elemente, die an der falschen Position sind
        }
        exch(a, lo, j); // Tausch des Pivotelements an die richtige Position
        return j; // Rückgabe der Position des Pivotelements nach der Partitionierung
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

    static <T extends Comparable<? super T>> T medianOf3(T[] array, int left, int right) {
        int center = (left + right) / 2;

        if (array[left].compareTo(array[center]) > 0)
            exch(array, left, center);

        if (array[left].compareTo(array[right]) > 0)
            exch(array, left, right);

        if (array[center].compareTo(array[right]) > 0)
            exch(array, center, right);

        exch(array, center, right - 1);
        return array[right - 1];
    }


    static <T extends Comparable<? super T>> int medianOf5(T[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int sixth = (hi - lo) / 4;
        int[] indices = {lo, lo + sixth, mid, mid - sixth, hi};
        for (int i = 0; i < indices.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < indices.length; j++) {
// Wenn das Element an Index j kleiner als das aktuelle Minimum ist, aktualisiere den Index des Minimums
                if (a[indices[j]].compareTo(a[indices[minIndex]]) < 0) {
                    minIndex = j;
                }
            }
// Wenn das Minimum nicht an der aktuellen Position ist, tausche es mit dem Element an der aktuellen Position aus.
            if (minIndex != i) {
                exch(a, indices[i], indices[minIndex]);
            }
        }
        return mid;
    }

    static <T extends Comparable<? super T>> T medianOf11(T[] a, int left, int right) {
        Random gen = new Random();

        ArrayList<T> elevenNr = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
        int index = gen.nextInt(right - left + 1) + left; // Zufälliger Index innerhalb des Bereichs
        elevenNr.add(a[index]); // Wert an zufälligem Index dem ArrayList hinzufügen
        }
        Collections.sort(elevenNr);

        return elevenNr.get(5);
    }


    public static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        // Test mit Integer-Array
        Integer[] arr1 = {5, 3, 8, 6, 2, 7, 1, 43, 2, 4, 5, 6, 7, 8, 9, 0, 8, 23, 34, 4, 56, 67, 87, 98};
        System.out.println("Unsorted array: " + Arrays.toString(arr1));
        sort(arr1);
        System.out.println(isSorted(arr1));
        System.out.println("Sorted array: " + Arrays.toString(arr1));
        // Test mit Integer-Array
        Integer[] arr2 = {5, 3, 8, 6,4, 2, 7, 1};
        System.out.println("Unsorted array: " + Arrays.toString(arr2));
        sort(arr2);
        System.out.println(isSorted(arr2));

        System.out.println("Sorted array: " + Arrays.toString(arr2));
        // Test mit Double-Array
        Double[] arr3 = {3.5, 1.2, 4.8, 2.3, 5.7, 0.9};
        System.out.println("Unsorted array: " + Arrays.toString(arr3));
        sort(arr3);
        System.out.println(isSorted(arr3));

        System.out.println("Sorted array: " + Arrays.toString(arr3));
        //String[] a = new In(args[0]).readAllStrings();
        Integer[] a = {1,3,56,78,34,12,3,6,78,897,234,1};
        sort(a);
        assert isSorted(a);
        show(a);


    }
}

