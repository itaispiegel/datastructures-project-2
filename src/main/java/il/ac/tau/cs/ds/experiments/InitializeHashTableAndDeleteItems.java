package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.DoubleHashTable;
import il.ac.tau.cs.ds.table.HashTableElement;
import il.ac.tau.cs.ds.table.IHashTable;

import java.util.List;
import java.util.Random;

public class InitializeHashTableAndDeleteItems {
    private static final int m = 10000019;
    private static final long p = 1000000007L;

    public static void main(String[] args) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {

        Random random = new Random(10);
        DoubleHashTable table = new DoubleHashTable(m, p);

        List<HashTableElement> sequence = ExperimentUtils.generateRandomSequence(m / 2, random);
        int sequenceSize = sequence.size();

        for (int i = 0; i < sequenceSize; i++) {
            HashTableElement hte = sequence.get(i);
            long startTime = System.nanoTime();
            table.Insert(hte);
            long endTime = System.nanoTime();

            if (i < 3) {
                System.out.println("Running time for inserting at iteration #" + (i + 1) + ": " +
                        (endTime - startTime) + "ns");
            }
        }

        System.out.println("Inserted all items, now starting to delete\n");

        for (int i = 0; i < sequenceSize; i++) {
            HashTableElement hte = sequence.get(i);
            long startTime = System.nanoTime();
            table.Delete(hte.GetKey());
            long endTime = System.nanoTime();

            if (i < 3) {
                System.out.println("Running time for deletion at iteration #" + (i + 1) + ": " +
                        (endTime - startTime) + "ns");
            }
        }
    }
}
