package ADP1.Aufgabe3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.LinkedList;


public class DoublingTest {
    public static void main(String[] args) {
        for (int N = 250; true; N += N) { // Schleife, um die Problemgröße N zu verdoppeln
            // Zeit für Problemgröße N messen
            double time = iteriereLinkedList(N);
            StdOut.printf("%6d %7.1f\n", N, time); // Ausgabe von N und der gemessenen Zeit
        }
    }

    private static double iteriereDoublyLinkedList(int N) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(); // Erstellen einer doppelt verketteten Liste
        for (int i = 0; i < N; i++) {
            list.add(0, i); // Hinzufügen von Elementen an den Anfang der Liste
        }
        Stopwatch timer = new Stopwatch(); // Erstellen eines Stopwatches zur Messung der Zeit
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // Zugriff auf Elemente der Liste
        }
        return timer.elapsedTime(); // Rückgabe der verstrichenen Zeit
    }

    private static double iteriereLinkedList(int N) {
        LinkedList<Integer> list = new LinkedList<>(); // Erstellen einer einfach verketteten Liste
        for (int i = 0; i < N; i++) {
            list.add(0, i); // Hinzufügen von Elementen an den Anfang der Liste
        }
        Stopwatch timer = new Stopwatch(); // Erstellen eines Stopwatches zur Messung der Zeit
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // Zugriff auf Elemente der Liste
        }
        return timer.elapsedTime(); // Rückgabe der verstrichenen Zeit
    }
}