package ADP2.Aufgabe_D;

import java.util.Arrays;

import static ADP2.Aufgabe_D.SortClassCommons.show;
import static ADP2.Aufgabe_E.SortClassCommons.isSorted;


public class MergeSortDreiTeile {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        if (a == null) return;
        T[] aux = a.clone();
        sort(aux, 0, a.length, a);
    }

    private static <T extends Comparable<? super T>> void sort(T[] aux, int lo, int hi, T[] a) {
        if (hi - lo < 2) return;

        int mid1 = lo + (hi - lo) / 3;
        int mid2 = lo + 2 * ((hi - lo) / 3) + 1;
        sort(a, lo, mid1, aux);
        sort(a, mid1, mid2, aux);
        sort(a, mid2, hi, aux);


        merge(a, lo, hi, mid1, mid2, aux);
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, int lo, int hi, int mid1, int mid2, T[] aux){
        int i = lo;
        int j = mid1;
        int k = mid2;
        int l = lo;
        while ((i < mid1) && (j < mid2) && (k < hi)) {
            if (less(aux[i], aux[j])) {
                if (less(aux[i], aux[k])) {
                    a[l++] = aux[i++];
                } else {
                    a[l++] = aux[k++];
                }
            } else {
                if (less(aux[j], aux[k])){
                    a[l++] = aux[j++];
                } else {
                    a[l++] = aux[k++];
                }
            }
        }

        while((i < mid1) && (j < mid2)){
            if(less(aux[i], aux[j])){
                a[l++] = aux[i++];
            } else {
                a[l++] = aux[j++];
            }
        }

        while((i < mid1) && (k < hi)){
            if(less(aux[i], aux[k])){
                a[l++] = aux[i++];
            } else {
                a[l++] = aux[k++];
            }
        }

        while((j < mid2) && (k < hi)){
            if(less(aux[j], aux[k])){
                a[l++] = aux[j++];
            } else {
                a[l++] = aux[k++];
            }
        }

        while(i < mid1){
            a[l++] = aux[i++];
        }

        while(j < mid2){
            a[l++] = aux[j++];
        }

        while(k < hi){
            a[l++] = aux[k++];
        }
    }

    public static <T extends Comparable<? super T>> boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 4, 48, 7, 2, 6, 5,5, 8,7,2, 6,7 , 6, 0, 3, 9};
        sort(integers);
        System.out.println(Arrays.toString(integers));

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
        ADP2.Aufgabe_E.SortClassCommons.show(a);

    }
}
