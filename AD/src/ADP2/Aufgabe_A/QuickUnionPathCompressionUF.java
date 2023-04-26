package ADP2.Aufgabe_A;

import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Random;

public class QuickUnionPathCompressionUF {
    private int[] parent;  // parent[i] is the parent of i
    private int[] size;    // size[i] is the size of the tree rooted at i

    public QuickUnionPathCompressionUF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        // Path compression: make all nodes on the path from p to the root
        // point directly to the root.
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // Weighted union: always attach the smaller tree to the larger one.
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }


    public static void main(String[] args) {
        int n = 10;
        int m = 100;
        int l = 1000;
       /* testQuickUnion(new QuickUnionUF(n), "QuickUnion (n = " + n + ")");
        testQuickUnion(new QuickUnionPathCompressionUF(n), "QuickUnion (Path compression, n = " + n + ")");
        testQuickUnion(new WeightedQuickUnionUF(n), "WeightedQuickUnion (n = " + n + ")");
        testQuickUnion(new QuickUnionUF(m), "QuickUnion (n = " + m + ")");
        testQuickUnion(new QuickUnionPathCompressionUF(m), "QuickUnion (Path compression, n = " + m + ")");
        testQuickUnion(new WeightedQuickUnionUF(m), "WeightedQuickUnion (n = " + m + ")");
        testQuickUnion(new QuickUnionUF(l), "QuickUnion (n = " + l + ")");
        testQuickUnion(new QuickUnionPathCompressionUF(l), "QuickUnion (Path compression, n = " + l + ")");
        testQuickUnion(new WeightedQuickUnionUF(l), "WeightedQuickUnion (n = " + l + ")");
   */ }

    private static void testQuickUnion(UF uf, String name) {
        Stopwatch stopwatch = new Stopwatch();
        // Perform some random unions and finds.
        Random random = new Random();
        for (int i = 0; i < uf.count() * 2; i++) {
            int p = random.nextInt(uf.count());
            int q = random.nextInt(uf.count());
            uf.union(p, q);
            uf.connected(p, q);
        }
        double time = stopwatch.elapsedTime();
        System.out.printf("%s: %.3f seconds\n", name, time);
    }
}