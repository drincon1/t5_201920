package model.data_structures;

public interface ITablaHashLinearProbing <K, V extends Comparable<V>>{
	
	void put (K key, V value);
	
	void get (K key);

}
