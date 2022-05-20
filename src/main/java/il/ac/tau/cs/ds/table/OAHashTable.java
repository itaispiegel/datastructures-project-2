package il.ac.tau.cs.ds.table;

public abstract class OAHashTable implements IHashTable {

    public static class DeletedHashTableElement extends HashTableElement {
        public DeletedHashTableElement(long key, long value) {
            super(key, value);
        }
    }

    private HashTableElement[] table;
    private int size;
    protected int m;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
        this.size = 0;
        this.m = m;
    }

    public int getSize() {
        return size;
    }

    public float calculateLoadFactor() {
        return (float) size / m;
    }

    @Override
    public HashTableElement Find(long key) {
        for (int i = 0; i < table.length; i++) {
            int index = Hash(key, i);
            if (table[index] == null) {
                return null;
            } else if (table[index].GetKey() == key) {
                return table[index];
            }
        }
        return null;
    }

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        int firstAvailableIndex = -1;

        for (int i = 0; i < table.length; i++) {
            int index = Hash(hte.GetKey(), i);
            if (table[index] == null) {
                firstAvailableIndex = index;
                break;
            } else if (table[index] instanceof DeletedHashTableElement && firstAvailableIndex == -1) {
                firstAvailableIndex = index;
            } else if (table[index].GetKey() == hte.GetKey()) {
                throw new KeyAlreadyExistsException(hte);
            }
        }

        if (firstAvailableIndex > -1) {
            table[firstAvailableIndex] = hte;
            size++;
        } else {
            throw new TableIsFullException(hte);
        }
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        for (int i = 0; i < table.length; i++) {
            int index = Hash(key, i);
            if (table[index] == null) {
                throw new KeyDoesntExistException(key);
            } else if (table[index].GetKey() == key) {
                table[index] = new DeletedHashTableElement(key, 0);
                size--;
                return;
            }
        }
        throw new KeyDoesntExistException(key);
    }

    /**
     * @param x - the key to hash
     * @param i - the index in the probing sequence
     * @return the index into the hash table to place the key x
     */
    public abstract int Hash(long x, int i);
}
