package il.ac.tau.cs.ds;

public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	private ModHash hashFunction;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.hashFunction = ModHash.GetFunc(m, 1000000007);
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		// TODO implement find
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		// TODO implement insertion	
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// TODO implement deletion
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
