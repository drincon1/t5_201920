package model.data_structures;

import java.util.*;

public interface ITablaHashLinearProbing <K extends Comparable<K>, V extends Comparable<V>>{


	/**
	 * Permite agregar una dupla (K, V) a la tabla
	 * V no puede ser null 
	 * @param key identificador en la tabla hash
	 * @param value valor que se le asigna a un key en la tabla
	 */
	void put (K key, V value);


	/**
	 * Permite obtener el valor asociado a un key en la tabla
	 * @param key
	 */
	V get (K key);

	/**
	 * Permite eliminar la dupla asociada a la llave K
	 * @return el valor de la llave que se elimino 
	 */
	void delete (K key);

	/**
	 * Conjunto de keys presentes en la tabla 
	 */
	Iterable<K> keys();

}
