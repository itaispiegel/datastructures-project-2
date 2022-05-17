package il.ac.tau.cs.ds;

import java.util.Random;

public class ModHash {
    private long p;
    private long a;
    private long b;
    private int m;

    public ModHash() {
    }

    public ModHash(long p, long a, long b, int m) {
        this.p = p;
        this.a = a;
        this.b = b;
        this.m = m;
    }

    public static ModHash GetFunc(int m, long p) {
        Random random = new Random();
        long a = Math.abs(random.nextLong()) % (p - 1) + 1;
        long b = Math.abs(random.nextLong()) % p;
        return new ModHash(p, a, b, m);
    }

    public int Hash(long key) {
        return (int) ((a * key + b) % p) % m;
    }
}
