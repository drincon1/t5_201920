package model.data_structures;

import java.util.*;

public class TablaHashSeparateChaining<K, V extends Comparable<V>> implements ITablaHashSeparateChaining<K, V> 
{
	//----------------------------------------
	// Atributos
	//----------------------------------------

	private int M;

	private NodoHashTable<K, V>[] st;


	//----------------------------------------
	// Método constructor
	//----------------------------------------

	/**
	 * Crea una tabla de hash con capacidad inicial de m posiciones
	 * @param m Tamano de la tabla a crear. m > 0
	 */
	public TablaHashSeparateChaining (int m)
	{
		M = m;
		st = (NodoHashTable<K, V>[]) new Object[m];
	}

	//----------------------------------------
	// Métodos de funcionamiento 
	//----------------------------------------
	@Override
	public void put(K key, V value) 
	{
		int i = hash(key);
		for (NodoHashTable<K, V>  x = st[i]; x != null; x = x.getNext())
		{
			if (key.equals(x.getKey())) 
			{ 
				x.setValue(value);
				return;
			}
		}

		st[i] = new NodoHashTable<K, V> (key, value);
	}

	@Override
	public V get(K key) 
	{
		int i = hash(key);
		for (NodoHashTable<K, V> x = st[i]; x != null; x = x.getNext())
			if (key.equals(x.getKey())) 
				return x.getValue();
		return null;
	}

	@Override
	public V delete(K key) 
	{	
		return null;
	}

	@Override
	public Iterator<K> keys()
	{
		return null;
	}

	private int hash (K key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}


	//----------------------------------------
	// Getters
	//----------------------------------------

	/**
	 * @return El tamano de la tabla
	 */
	public int getM() 
	{
		return M;
	}

}
