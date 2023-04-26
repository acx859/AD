package ADP1.Aufgabe2;

import edu.princeton.cs.algs4.StdIn;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {

            try {
                int i = StdIn.readInt();
                if ((i > 0) && (i % 2 == 0)) {
                    System.out.println(i);
                }
            } catch (Exception e) {

            }

        }
    }
}
