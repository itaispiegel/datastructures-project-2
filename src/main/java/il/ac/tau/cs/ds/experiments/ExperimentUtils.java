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

        List<HashTableElement> sequence = generateRandomSequence(size, random);
        for (HashTableElement element : sequence) {
            table.Insert(element);
        }
    }

    public static long generateRandomSequenceElement(int index, Random random) {
        int b = random.nextInt(100);
        return 100L * index + b;
    }

    public static List<HashTableElement> generateRandomSequence(int size, Random random) {
        return LongStream.range(0, size)
                .map(l -> generateRandomSequenceElement((int) l, random))
                .mapToObj(l -> new HashTableElement(l, 0))
                .collect(Collectors.toList());
    }
}
