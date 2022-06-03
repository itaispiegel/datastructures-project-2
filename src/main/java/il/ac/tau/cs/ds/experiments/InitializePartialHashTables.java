package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.*;

import java.util.List;
import java.util.Random;

public class InitializePartialHashTables {
    private static final int m = 10000019;
    private static final long p = 1000000007L;

    public static long initializeTableAndGetElapsedTime(OAHashTable table, Random random, int size) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {

        List<HashTableElement> sequence = ExperimentUtils.generateRandomSequence(size, random);

        long startTime = System.currentTimeMillis();
        for (HashTableElement element : sequence) {
            table.Insert(element);
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static void main(String[] args) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {

        Random random = new Random(10);

        // m / 2
        OAHashTable table = new LPHashTable(m, p);
        System.out.println("Elapsed time for LP table (m / 2): " +
                initializeTableAndGetElapsedTime(table, random, m / 2) + "ms");

        table = new QPHashTable(m, p);
        System.out.println("Elapsed time for QP table (m / 2): " +
                initializeTableAndGetElapsedTime(table, random, m / 2) + "ms");

        table = new AQPHashTable(m, p);
        System.out.println("Elapsed time for AQP table (m / 2): " +
                initializeTableAndGetElapsedTime(table, random, m / 2) + "ms");

        table = new DoubleHashTable(m, p);
        System.out.println("Elapsed time for DoubleHashTable table (m / 2): " +
                initializeTableAndGetElapsedTime(table, random, m / 2) + "ms\n");

        // m * 0.95
        table = new LPHashTable(m, p);
        System.out.println("Elapsed time for LP table (m * 0.95): " +
                initializeTableAndGetElapsedTime(table, random, (int) (m * 0.95)) + "ms");

        table = new QPHashTable(m, p);
        System.out.println("Elapsed time for QP table (m * 0.95): " +
                initializeTableAndGetElapsedTime(table, random, (int) (m * 0.95)) + "ms");

        table = new AQPHashTable(m, p);
        System.out.println("Elapsed time for AQP table (m * 0.95): " +
                initializeTableAndGetElapsedTime(table, random, (int) (m * 0.95)) + "ms");

        table = new DoubleHashTable(m, p);
        System.out.println("Elapsed time for DoubleHashTable table (m * 0.95): " +
                initializeTableAndGetElapsedTime(table, random, (int) (m * 0.95)) + "ms");
    }
}
