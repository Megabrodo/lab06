package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final int READ = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> numbers_over1000 = new ArrayList<>();
        for (int i=1000; i<2000; i++){
            numbers_over1000.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linked_numbers_over1000 = new LinkedList<>();
        linked_numbers_over1000.addAll(numbers_over1000);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int var=numbers_over1000.getFirst();
        numbers_over1000.set(0, numbers_over1000.getLast());
        numbers_over1000.set(numbers_over1000.size()-1, var);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : numbers_over1000){
            System.out.println("Number: "+i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i=1; i<=ELEMS; i++){
            numbers_over1000.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + numbers_over1000.size()
                + " ints inserting them first in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i=1; i<=ELEMS; i++){
            linked_numbers_over1000.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + linked_numbers_over1000.size()
                + " ints inserting them in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i=0; i<=READ; i++){
            numbers_over1000.get(numbers_over1000.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + numbers_over1000.size()/2
                + " int 1000 times took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i=0; i<=READ; i++){
            linked_numbers_over1000.get(linked_numbers_over1000.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + linked_numbers_over1000.size()/2
                + " int 1000 times took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        HashMap<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        Long population=0L;
        for (String a : map.keySet()){
            System.out.println("Nation: "+a+" Population: "+map.get(a));
            population = population + map.get(a);
        }
        System.out.println("Popolazione totale: "+population);
    }
}
