package il.ac.tau.cs.ds.table;

public abstract class OAHashTable implements IHashTable {

    public static class DeletedHashTableElement extends HashTableElement {
        public DeletedHashTableElement(long key) {
            super(key, 0);
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
        try {
            int index = getIndexInTable(key);
            return table[index];
        } catch (KeyDoesntExistException e) {
            return null;
        }
    }

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        long key = hte.GetKey();
        int firstAvailableIndex = -1;

        for (int i = 0; i < table.length; i++) {
            int index = Hash(key, i);
            if (table[index] == null) {
                firstAvailableIndex = firstAvailableIndex == -1 ? index : firstAvailableIndex;
                break;
            }

            if (table[index] instanceof DeletedHashTableElement) {
                if (firstAvailableIndex == -1) {
                    firstAvailableIndex = index;
                }
            } else if (table[index].GetKey() == key) {
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
        int index = getIndexInTable(key);
        table[index] = new DeletedHashTableElement(key);
        size--;
    }

    private int getIndexInTable(long key) throws KeyDoesntExistException {
        for (int i = 0; i < table.length; i++) {
            int index = Hash(key, i);
            HashTableElement hte = table[index];
            if (hte == null) {
                break;
            } else if (hte.GetKey() == key) {
                return index;
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
