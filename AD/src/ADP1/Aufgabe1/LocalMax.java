package ADP1.Aufgabe1;

import java.util.Arrays;

public class LocalMax {

    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] res1 = localMax(ary1, 2);
        System.out.println(Arrays.toString(res1)); // expected output: [1, 61, 89, 75, 16]

        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] res2 = localMax(ary2, 3);
        System.out.println(Arrays.toString(res2)); // expected output: [16, 75, 89, 133, 89, 59, 28]
        int[] ary3 = {99, 1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] res3 = localMax(ary3, 1);
        System.out.println(Arrays.toString(res3)); // expected output: null

        int[] ary4 = {1, 2, 5, 4, 2, 3, 1};
        int[] res4 = localMax(ary4, 1);
        System.out.println(Arrays.toString(res4)); // expected output: [2, 3, 1]
    }


    public static int[] localMax(int[] a, int radius) {
        return localMax(a, 0, a.length, radius);
    }

    private static int[] localMax(int[] a, int lo, int hi, int radius) {
        if (lo >= hi) {
            //Array ist leer
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        if (mid < radius || (mid + radius) > (hi)) return null;


        // Überprüfung auf lokales Maximum
        boolean linkeSeite = true;
        for (int i = mid - radius; i < mid; i++) {
            if (a[i] >= a[i + 1]) {
                linkeSeite = false;
                break;
            }
        }

        boolean rechteSeite = true;
        for (int i = mid; i < mid + radius; i++) {
            if (a[i] <= a[i + 1]) {
                rechteSeite = false;
                break;
            }
        }

        if (linkeSeite && rechteSeite) {
            // lokales Maximum gefunden
            // return {mid - radius, mid + radius +1};
            return Arrays.copyOfRange(a, mid - radius, mid + radius + 1);
        } else if (mid == lo) {
           // Array kann nicht weiter aufgeteilt werden
            return null;
        } else {
            // rekursiver Aufruf für die Hälfte mit dem kleineren Nachbarn
            if (a[mid - 1] > a[mid + 1]) {
                return localMax(a, mid, hi, radius);
            } else {
                return localMax(a, lo, mid, radius);
            }
        }
    }

}
