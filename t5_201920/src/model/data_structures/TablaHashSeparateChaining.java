package model.data_structures;

import java.util.*;

public class TablaHashSeparateChaining<K, V extends Comparable<V>> implements ITablaHashSeparateChaining<K, V> 
{
	//----------------------------------------
	// Atributos
	//----------------------------------------

	private int M;
	private int N;
	
	private Node[] st;
	
	private static class Node
	{
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object value, Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		/**
		 * @return the key
		 */
		public Object getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(Object key) {
			this.key = key;
		}

		/**
		 * @return the value
		 */
		public Object getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(Object value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}	
	}


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
		N = 0;
		st = new Node[m];

	}

	//----------------------------------------
	// Métodos de funcionamiento 
	//----------------------------------------
	@Override
	public void put(K key, V value) 
	{
		int i = hash(key);
		for(Node x = st[i]; x != null; x = x.getNext())
		{
			if(key.equals(x.getKey()))
			{
				x.setValue(value);
				return;
			}
				
		}
		N++;
		st[i] = new Node(key, value, st[i]);
	}

	@Override
	public V get(K key) 
	{
		int i = hash(key);
		for(Node x = st[i]; x != null; x = x.getNext())
			if(x.getKey().equals(key))
				return (V) x.getValue();
		return null;
	}

	@Override
	//Código sacado de http://www.algolist.net/Data_structures/Hash_table/Chaining
	public V delete(K key) 
	{	
		int i = hash(key);
		V valor = null;
		if(st[i] != null)
		{
			Node prev = null;
			Node actual = st[i];
			while(actual.getNext() != null && !(actual.getKey().equals(key)))
			{
				prev = actual;
				actual = actual.getNext();
			}
			if(actual.getKey().equals(key))
			{
				valor = (V) actual.getValue();
				if(prev == null)
					st[i] = actual.getNext();
				else
					prev.setNext(actual.getNext());
				N--;
			}
		}
		return valor;
	}

	@Override
	public Iterator<K> keys()
	{
		ArrayList<K> lista = new ArrayList<K>();
		for(int i = 0; i < N; i++)
		{
			if(st[i] != null)
			{
				Node temp = st[i];
				while(temp != null)
				{
					lista.add((K) temp.getKey());
					temp = temp.getNext();
				}
			}
		}
		Iterator<K> keys = lista.iterator();
		return keys;
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
