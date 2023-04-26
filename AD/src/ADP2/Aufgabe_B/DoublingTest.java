package ADP2.Aufgabe_B;

import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {


    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            // Zeit für Problemgröße N
            int[] a = schlechtesteGenerateArray(N);
            Stopwatch timer = new Stopwatch();
            BubbleSort.bubbleSort(a);
            double time = timer.elapsedTime();
            System.out.printf("%6d %7.1f\n", N, time);
        }
    }

    private static int[] besteGenerateArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        return a;
    }

    private static int[] mittlereGenerateArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = (int) Math.random();
        }
        return a;
    }

    private static int[] schlechtesteGenerateArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = N - i;
        }
        return a;
    }
}
