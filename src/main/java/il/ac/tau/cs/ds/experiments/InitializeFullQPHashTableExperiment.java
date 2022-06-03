package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.IHashTable;
import il.ac.tau.cs.ds.table.QPHashTable;

import java.util.Random;

public class InitializeFullQPHashTableExperiment {
    private static final int m = 6571;
    private static final long p = 1000000007L;

    public static void main(String[] args) throws IHashTable.KeyAlreadyExistsException {

        Random random = new Random(10);
        for (int i = 0; i < 100; i++) {
            QPHashTable table = new QPHashTable(m, p);
            try {
                ExperimentUtils.addRandomItemsToTable(table, random, m);
            } catch (IHashTable.TableIsFullException e) {
                System.out.println("Got TableIsFullException");
                System.out.println("Table size: " + table.getSize());
                System.out.println("Table load factor: " + table.calculateLoadFactor() + "\n");
            }
        }
    }
}
