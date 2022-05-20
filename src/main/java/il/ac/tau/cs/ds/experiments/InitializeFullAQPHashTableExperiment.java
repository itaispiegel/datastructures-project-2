package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.AQPHashTable;
import il.ac.tau.cs.ds.table.IHashTable;

import java.util.Random;

public class InitializeFullAQPHashTableExperiment {
    private static final int m = 6571;
    private static final long p = 1000000007L;

    public static void main(String[] args) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {

        Random random = new Random(10);
        for (int i = 0; i < 100; i++) {
            AQPHashTable table = new AQPHashTable(m, p);
            ExperimentUtils.addRandomItemsToTable(table, random, m);
        }
    }
}
