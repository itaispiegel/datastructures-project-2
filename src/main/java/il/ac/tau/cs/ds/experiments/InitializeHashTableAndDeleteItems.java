package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.DoubleHashTable;
import il.ac.tau.cs.ds.table.HashTableElement;
import il.ac.tau.cs.ds.table.IHashTable;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class InitializeHashTableAndDeleteItems {
    private static final int m = 10000019;
    private static final long p = 1000000007L;

    private static long insertAndDeleteItemsAndMeasureTime(DoubleHashTable table,
                                                           Collection<HashTableElement> sequence) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {

        long startTimeMs = System.currentTimeMillis();
        for (HashTableElement element : sequence) {
            table.Insert(element);
        }

        for (HashTableElement element : sequence) {
            table.Delete(element.GetKey());
        }
        long endTimeMs = System.currentTimeMillis();
        return endTimeMs - startTimeMs;
    }

    public static void main(String[] args) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {

        Random random = new Random(10);
        DoubleHashTable table = new DoubleHashTable(m, p);

        long totalTime = 0;
        for (int i = 1; i < 4; i++) {
            List<HashTableElement> sequence = ExperimentUtils.generateRandomSequence(m / 2, random);

            long elapsedTimeMs = insertAndDeleteItemsAndMeasureTime(table, sequence);
            System.out.println(i + " took " + elapsedTimeMs + "ms");
            totalTime += elapsedTimeMs;
        }
        System.out.println("First 3 iterations: " + totalTime + "ms");

        totalTime = 0;
        for (int i = 4; i < 7; i++) {
            List<HashTableElement> sequence = ExperimentUtils.generateRandomSequence(m / 2, random);

            long elapsedTimeMs = insertAndDeleteItemsAndMeasureTime(table, sequence);
            System.out.println(i + " took " + elapsedTimeMs + "ms");
            totalTime += elapsedTimeMs;
        }
        System.out.println("Last 3 iterations: " + totalTime + "ms");
    }
}
