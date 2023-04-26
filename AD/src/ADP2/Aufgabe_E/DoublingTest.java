package ADP2.Aufgabe_E;

import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            // Zeit für Problemgröße N
            Double[] a = generateRandomArray(N);
            Stopwatch timer = new Stopwatch();
            QuickSort.sort(a);
            double time = timer.elapsedTime();
            System.out.printf("%6d %7.1f\n", N, time);
        }
    }

    private static Double[] generateRandomArray(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }
        return a;
    }
}


