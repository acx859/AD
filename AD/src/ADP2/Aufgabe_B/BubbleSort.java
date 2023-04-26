package ADP2.Aufgabe_B;

import java.util.Arrays;
import java.util.Arrays;

import static ADP2.Aufgabe_E.SortClassCommons.exch;
import static ADP2.Aufgabe_E.SortClassCommons.less;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        long  vergleiche = 0; // Zähler für Vergleiche
        long  tauschoperationen = 0; // Zähler für Tauschoperationen
        for (int i = 0; i < n-1; i++) { // Äußere Schleife für Durchläufe
            for (int j = 0; j < n-i-1; j++) { // Innere Schleife für Vergleiche und Tauschoperationen
                vergleiche++; // Vergleichszähler erhöhen
                if( less(arr[j+1],arr[j])) { // Vergleiche benachbarte Elemente
                    tauschoperationen++; // Tauschzähler erhöhen
                    // Tausche arr[j] und arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Anzahl der Vergleiche: " + vergleiche); // Ausgabe der Anzahl der Vergleiche
        System.out.println("Anzahl der Tauschoperationen: " + tauschoperationen); // Ausgabe der Anzahl der Tauschoperationen
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr)); // Ausgabe des sortierten Arrays
    }
}
