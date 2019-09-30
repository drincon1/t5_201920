package model.data_structures;

public class NodoHashTable<K, V extends Comparable<V>>
{
	//----------------------------------------
	// Atributos
	//----------------------------------------

	//Llave del nodo
	private K key;

	//Elemento del nodo
	private V value;

	//Siguiente del nodo actual
	private NodoHashTable<K, V> next;

	//----------------------------------------
	// Método constructor
	//----------------------------------------
	public NodoHashTable (K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	//----------------------------------------
	// Getters
	//----------------------------------------
	/**
	 * @return Llave del nodo
	 */
	public K getKey() 
	{
		return key;
	}

	/**
	 * @return Elemento del nodo
	 */
	public V getValue() 
	{
		return value;
	}

	/**
	 * @return El siguiente del nodo actual
	 */
	public NodoHashTable<K, V> getNext() 
	{
		return next;
	}

	//----------------------------------------
	// Setters
	//----------------------------------------

	/**
	 * @param Nuevo valor para el nodo
	 */
	public void setValue(V value) {
		this.value = value;
	}



}
