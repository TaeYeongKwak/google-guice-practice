package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface SimpleRepository<K, V> {

	V save(V value);
	List<V> findAll();
	Optional<V> findById(K key);
	void deleteById(K key);

}
