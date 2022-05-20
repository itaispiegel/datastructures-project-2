package il.ac.tau.cs.ds.table;

public class LPHashTable extends OAHashTable {
    private final ModHash hashFunction;

    public LPHashTable(int m, long p) {
        super(m);
        hashFunction = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int result = (hashFunction.Hash(x) + i) % m;
        return result >= 0 ? result : result + m;
    }
}
