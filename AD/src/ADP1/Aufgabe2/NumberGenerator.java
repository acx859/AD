package ADP1.Aufgabe2;

import edu.princeton.cs.algs4.StdRandom;

public class NumberGenerator {
    public static void numberGen(int n, int min, int max) {
        for (int i = 0; i < n; i++) {
            double intORdouble = StdRandom.uniformDouble();
            if (intORdouble > 0.5) {
                int intNumber = StdRandom.uniformInt(min, max);
                System.out.println("Integer: " + intNumber);
            } else {
                double doubleNumber = StdRandom.uniformDouble(min, max);
                System.out.println("double: " + doubleNumber);
            }
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);
        numberGen(n, min, max);
    }
}

