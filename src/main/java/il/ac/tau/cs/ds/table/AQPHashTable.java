package il.ac.tau.cs.ds.table;

public class AQPHashTable extends OAHashTable {
    private final ModHash hashFunction;

    public AQPHashTable(int m, long p) {
        super(m);
        hashFunction = ModHash.GetFunc(m, p);
    }

    @Override
    public int Hash(long x, int i) {
        int rhs = i % 2 == 0 ? i * i : -(i * i);
        int result = (hashFunction.Hash(x) + rhs + m) % m;
        return result >= 0 ? result : result + m;
    }
}
