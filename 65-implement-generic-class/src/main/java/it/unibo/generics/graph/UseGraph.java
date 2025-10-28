package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.GraphImpl;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.Scanner;

/**
 *
 */
public final class UseGraph {

    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String D = "d";
    private static final String E = "e";

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        Graph<String>graph = new GraphImpl<>();
        /*
         * Test your graph implementation(s) by calling testGraph
         */
        testGraph(graph);
    }

    private static void testGraph(final Graph<String> graph) {
        Scanner scanner = new Scanner(System.in);

        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);
        graph.addEdge(A, B);
        graph.addEdge(B, C);
        graph.addEdge(C, D);
        graph.addEdge(D, E);
        graph.addEdge(C, A);
        graph.addEdge(E, A);
        /*
         * Should be ["a","b","c","d","e"], in any order
         */
        assertIsAnyOf(graph.nodeSet(), Set.of(A, B, C, D, E));
        /*
         * ["d","a"], in any order
         */
        assertIsAnyOf(graph.linkedNodes(C), Set.of(A, D));
        /*
         * Either the path b,c,a or b,c,d,e,a
         */

        System.out.println("Insert what kind of algorithm you want to use\n");
        System.out.println("0 for dfs, 1 for bfs: \t");
        int decision = scanner.nextInt();

        assertIsAnyOf(
            graph.getPath(B, A, decision),
            Arrays.asList(B, C, A),
            Arrays.asList(B, C, D, E, A)
        );

        scanner.close();
    }

    private static void assertIsAnyOf(final Object actual, final Object... valid) {
        for (final var target: Objects.requireNonNull(valid)) {
            if (Objects.equals(target, actual)) {
                System.out.println("OK: " + actual + " matches " + target); // NOPMD
                return;
            }
        }
        throw new AssertionError("None of " + Arrays.asList(valid) + " matches " + actual);
    }
}
