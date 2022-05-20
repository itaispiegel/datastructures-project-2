package il.ac.tau.cs.ds;

public class QPHashTable extends OAHashTable {
    private final ModHash hashFunction;

    public QPHashTable(int m, long p) {
        super(m);
        hashFunction = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int result = (hashFunction.Hash(x) + i * i) % m;
        return result >= 0 ? result : result + m;
    }
}
