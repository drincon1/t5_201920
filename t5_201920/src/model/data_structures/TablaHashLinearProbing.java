package model.data_structures;

import java.util.Iterator;

public class TablaHashLinearProbing <K extends Comparable<K>, V extends Comparable<V>> implements ITablaHashLinearProbing<K, V>{

	private static final int INIT_CAPACITY = 4;

	private int n;           
	private int m;           
	private K[] keys;      
	private V[] values;    


	/**
	 * Initializes an empty symbol table.
	 * @return 
	 */
	public TablaHashLinearProbing() {
		this(INIT_CAPACITY);
	}

	/**
	 * Initializes an empty symbol table with the specified initial capacity.
	 *
	 * @param capacity the initial capacity
	 */
	public TablaHashLinearProbing(int capacity) {
		m = capacity;
		n = 0;
		keys = (K[])   new Object[m];
		values = (V[]) new Object[m];
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 *
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns true if this symbol table is empty.
	 *
	 * @return {@code true} if this symbol table is empty;
	 *         {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns true if this symbol table contains the specified key.
	 *
	 * @param  key the key
	 * @return {@code true} if this symbol table contains {@code key};
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(K key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	// hash function for keys - returns value between 0 and M-1
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	// resizes the hash table to the given capacity by re-hashing all of the keys
	private void resize(int capacity) {
		TablaHashLinearProbing<K, V> temp = new TablaHashLinearProbing<K, V>(capacity);
		for (int i = 0; i < m; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		m    = temp.m;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old 
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is {@code null}.
	 *
	 * @param  key the key
	 * @param  val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(K key, V val) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		// double table size if 50% full
		if (n >= m/2) resize(2*m);

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
			if (keys[i].equals(key)) {
				values[i] = val;
				return;
			}
		}
		keys[i] = key;
		values[i] = val;
		n++;
	}

	/**
	 * Returns the value associated with the specified key.
	 * @param key the key
	 * @return the value associated with {@code key};
	 *         {@code null} if no such value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public V get(K key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
			if (keys[i].equals(key))
				return values[i];
		return null;
	}

	/**
	 * Removes the specified key and its associated value from this symbol table     
	 * (if the key is in this symbol table).    
	 *
	 * @param  key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void delete(K key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		if (!contains(key)) return;

		// find position i of key
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i + 1) % m;
		}

		// delete key and associated value
		keys[i] = null;
		values[i] = null;

		// rehash all keys in same cluster
		i = (i + 1) % m;
		while (keys[i] != null) {
			// delete keys[i] an vals[i] and reinsert
			K   keyToRehash = keys[i];
			V valToRehash = values[i];
			keys[i] = null;
			values[i] = null;
			n--;
			put(keyToRehash, valToRehash);
			i = (i + 1) % m;
		}

		n--;

		// halves size of array if it's 12.5% full or less
		if (n > 0 && n <= m/8) resize(m/2);

		assert check();
	}

	/**
	 * Returns all keys in this symbol table as an {@code Iterable}.
	 * To iterate over all of the keys in the symbol table named {@code st},
	 * use the foreach notation: {@code for (Key key : st.keys())}.
	 *
	 * @return all keys in this symbol table
	 */
	public Iterable<K> keys() {
		ListaDoblementeEncadenada<K> listaDoble = new ListaDoblementeEncadenada<K>();
		for (int i = 0; i < m; i++)
			if (keys[i] != null) listaDoble.agregar(keys[i]);
		return listaDoble;
	}

	// integrity check - don't check after each put() because
	// integrity not maintained during a delete()
	private boolean check() {

		// check that hash table is at most 50% full
		if (m < 2*n) {
			System.err.println("Hash table size m = " + m + "; array size n = " + n);
			return false;
		}

		// check that each key in table can be found by get()
		for (int i = 0; i < m; i++) {
			if (keys[i] == null) continue;
			else if (get(keys[i]) != values[i]) {
				System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + values[i]);
				return false;
			}
		}
		return true;
	}
}
