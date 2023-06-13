package ADP2.Aufgabe_D;

import java.util.Arrays;

import static ADP2.Aufgabe_E.SortClassCommons.*;


public class MergeBottomUp {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] aux = a.clone();
        int N = a.length;
        for (int sz = 1; sz < N; sz = 3 * sz){
            for (int lo = 0; lo < N - sz; lo += 3 * sz){
                int mid1 = lo + sz -1;
                int mid2 = lo + 2 * sz - 1;
                merge(a,aux,lo,mid1, Math.min(mid2,N-1));
                merge(a,aux,lo,mid2, Math.min(lo+3*sz-1,N-1));
            }
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++]; // links erschöpft
            else if (j > hi ) a[k] = aux[i++]; // rechts erschöpft
            else if (less(aux[j], aux[i])) a[k]= aux[j++]; // rechts kleiner links
            else a[k] = aux[i++];
        }
    }

    public static <T extends Comparable<? super T>> boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {5, 3, 8, 6, 2, 7, 1, 43, 2, 4, 5, 6, 7, 8, 9, 0, 8, 23, 34, 4, 56, 67, 87, 98};
        System.out.println("Unsorted array: " + Arrays.toString(arr1));
        sort(arr1);
        System.out.println(isSorted(arr1));
        System.out.println("Sorted array: " + Arrays.toString(arr1));
        // Test mit Integer-Array
        Integer[] arr2 = {5, 3, 8, 6, 4, 2, 7, 1};
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
        Integer[] a = {1, 3, 56, 78, 34, 12, 3, 6, 78, 897, 234, 1};
        sort(a);
        assert isSorted(a);
        show(a);
    }
    }

