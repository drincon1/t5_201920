package model.data_structures;

import java.util.*;

public class TablaHashSeparateChaining<K, V extends Comparable<V>> implements ITablaHashSeparateChaining<K, V> 
{
	//----------------------------------------
	// Atributos
	//----------------------------------------

	private int M;
	
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
	public V delete(K key) 
	{	
		int i = hash(key);
		Node anterior = null;
		V valor = null;
		for(Node x = st[i]; x != null; x = x.getNext())
		{
			if(x.getKey().equals(key))
			{
				if(anterior != null)
					anterior.setNext(x.getNext());
				valor = (V) x.getValue();
				
				break;
			}
			anterior = x;
		}
		
		
		return valor;
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
