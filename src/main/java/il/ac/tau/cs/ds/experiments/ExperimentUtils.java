package il.ac.tau.cs.ds.experiments;

import il.ac.tau.cs.ds.table.HashTableElement;
import il.ac.tau.cs.ds.table.IHashTable;
import il.ac.tau.cs.ds.table.OAHashTable;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ExperimentUtils {
    public static void addRandomItemsToTable(OAHashTable table, Random random, int size) throws
            IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {

        for (int i = 0; i < size; i++) {
            long a = generateRandomSequenceElement(i, random);
            HashTableElement element = new HashTableElement(a, a);
            table.Insert(element);
        }
    }

    public static long generateRandomSequenceElement(int index, Random random) {
        int b = random.nextInt(100);
        return 100L * index + b;
    }

    public static List<Long> generateRandomSequence(int size, Random random) {
        return LongStream.range(0, size)
                .map(i -> generateRandomSequenceElement((int) i, random))
                .boxed()
                .collect(Collectors.toList());
    }
}
