package ADP2.Aufgabe_E;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static ADP2.Aufgabe_E.SortClassCommons.isSorted;
import static ADP2.Aufgabe_E.SortClassCommons.less;


public class QuickSort {
    private static final int insertionGrenze = 10; // Schwellenwert für Wechsel zu InsertionSort

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        StdRandom.shuffle(a);// Mischen des Arrays, um die Wahrscheinlichkeit von Worst-Case-Szenarien zu reduzieren
        sort(a, 0, a.length - 1); // Aufruf der rekursiven QuickSort-Methode mit dem gesamten Array
        assert isSorted(a);

    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi - lo + 1 <= insertionGrenze) {
            // Wechsel zu InsertionSort für Arrays der Größe <= 10
            insertionsort(a, lo, hi);
        } else {
            T pivot = medianOf3FOR(a, lo, hi); // Auswahl des Pivotelements mittels Median-of-Three-Partitionierung
            int pivotPos = partition(a, lo, hi, pivot); // Partitionierung des Arrays um das Pivotelement
            sort(a, lo, pivotPos ); // Rekursiver Aufruf von QuickSort für das linke Teilarray vor dem Pivotelement
            sort(a, pivotPos , hi); // Rekursiver Aufruf von QuickSort für das rechte Teilarray nach dem Pivotelement
        }
    }

    static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi, T pivot) {
        int i = lo, j = hi + 1;
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

    static <T extends Comparable<? super T>> T medianOf3FOR(T[] a, int left, int right) {
        Random gen = new Random();
        ArrayList<T> threeNr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int index = gen.nextInt(right - left + 1) + left; // Zufälliger Index innerhalb des Bereichs
            threeNr.add(a[index]); // Wert an zufälligem Index dem ArrayList hinzufügen
        }
        Collections.sort(threeNr);

        return threeNr.get(1);
    }

    static <T extends Comparable<? super T>> T medianOf5(T[] a, int left, int right) {
        Random gen = new Random();
        ArrayList<T> fiveNr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int index = gen.nextInt(right - left + 1) + left; // Zufälliger Index innerhalb des Bereichs
            fiveNr.add(a[index]); // Wert an zufälligem Index dem ArrayList hinzufügen
        }
        Collections.sort(fiveNr);

        return fiveNr.get(2);
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
        System.out.println("Sorted array: " + Arrays.toString(arr1));
        // Test mit Integer-Array
        Integer[] arr2 = {5, 3, 8, 6,4, 2, 7, 1};
        System.out.println("Unsorted array: " + Arrays.toString(arr2));
        sort(arr2);
        System.out.println("Sorted array: " + Arrays.toString(arr2));
        // Test mit Double-Array
        Double[] arr3 = {3.5, 1.2, 4.8, 2.3, 5.7, 0.9};
        System.out.println("Unsorted array: " + Arrays.toString(arr3));
        sort(arr3);
        System.out.println("Sorted array: " + Arrays.toString(arr3));
    }
}

