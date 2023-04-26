package ADP1.Aufgabe2;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AccumulatorClient {
    public static void main(String[] args) {
        Accumulator accumulator;
        int accumulatorType = Integer.parseInt(args[0]);
        if (accumulatorType == 0) {                       // Wenn der Akkumulator-Typ 0 ist, wird ein SimpleAccumulator erzeugt
            accumulator = new SimpleAccumulator();
        } else {                                          // Andernfalls wird ein VisualAccumulator erzeugt
            int n = Integer.parseInt(args[1]);            // Anzahl der Daten
            double max = Double.parseDouble(args[2]);     // Maximale Wert
            accumulator = new VisualAccumulator(n, max);
        }

        // Eingabe-Loop und Ãœbergabe der Daten an den Akkumulator
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            accumulator.addDataValue(value);
        }

        if (accumulatorType == 0) {
            System.out.println(accumulator);
        }
        else {
            StdOut.println(accumulator);
        }
    }
}
