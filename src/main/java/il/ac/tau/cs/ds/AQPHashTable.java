package il.ac.tau.cs.ds;

public class AQPHashTable extends OAHashTable {
    private final ModHash hashFunction;

    public AQPHashTable(int m, long p) {
        super(m);
        hashFunction = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        // TODO implement hash function
        return 0;
    }
}
