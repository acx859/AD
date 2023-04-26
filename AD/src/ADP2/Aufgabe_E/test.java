package ADP2.Aufgabe_E;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static ADP2.Aufgabe_D.MergeSortspiel.isSorted;
import static ADP2.Aufgabe_D.MergeSortspiel.less;

public class test {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        StdRandom.shuffle(a);
        sort( a,0, a.length - 1);
        assert isSorted(a);
    }
    private static <T extends Comparable<? super T>> void sort( T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int pivotPos = partition( a, lo, hi);
        sort(a, lo, pivotPos - 1);
        sort(a,pivotPos + 1, hi);
    }

    static <T extends Comparable<? super T>> int partition(T[] a, int lo,int hi){
        int i=lo, j=hi+1;
        T pivot = a[lo];
        while( true ) {
            while(less(a[++i],pivot)) if (i==hi) break;
            while(less(pivot,a[--j])) if (j==lo) break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    public static <T extends Comparable<? super T>> void exch(T[]a ,int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args) {
        // Test mit Integer-Array
        Integer[] arr1 = {5, 3, 8, 6, 2, 7, 1, 4};
        System.out.println("Unsorted array: " + Arrays.toString(arr1));
        sort(arr1);
        System.out.println("Sorted array: " + Arrays.toString(arr1));

        // Test mit String-Array
        String[] arr2 = {"apple", "banana", "cherry", "date", "fig", "grape"};
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
