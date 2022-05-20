package il.ac.tau.cs.ds;

public class DoubleHashTable extends OAHashTable {
    private final ModHash h1;
    private final ModHash h2;

    public DoubleHashTable(int m, long p) {
        super(m);
        h1 = ModHash.GetFunc(m, p);
        h2 = ModHash.GetFunc(m - 1, p);
    }

    @Override
    public int Hash(long x, int i) {
        int result = (h1.Hash(x) + i * (h2.Hash(x) + 1)) % m;
        return result >= 0 ? result : result + m;
    }
}
