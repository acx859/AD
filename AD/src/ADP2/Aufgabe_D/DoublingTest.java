package ADP2.Aufgabe_D;

import ADP2.Aufgabe_E.QuickSort;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {


    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            // Zeit für Problemgröße N
            Integer[] a = generateRandomArray(N);
            Stopwatch timer = new Stopwatch();
            MergeSortDreiTeile.sort(a);
            double time = timer.elapsedTime();
            System.out.printf("%6d %7.1f\n", N, time);
        }
    }
//
    private static Integer[] generateRandomArray(int N) {
        Integer[] n = new Integer[N];
        for (int i = 0; i < n.length; i++) {
            if (i < N/2) {
                n[i] =n.length - i;

            }else {
                n[i] = i-(N/2);
            }
        }
        return n;
    }
}
