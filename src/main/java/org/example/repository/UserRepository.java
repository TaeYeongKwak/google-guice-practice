package org.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.example.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRepository implements SimpleRepository<Long, User> {

	private static Map<Long, User> map = new ConcurrentHashMap<>();

	@Override
	public User save(User value) {
		log.info("User Save - {}", value);
		return map.put(value.getUserId(), value);
	}

	@Override
	public List<User> findAll() {
		log.info("User findAll");
		return map.values().stream().toList();
	}

	@Override
	public Optional<User> findById(Long key) {
		log.info("User findById - {}", key);
		return Optional.ofNullable(map.get(key));
	}

	@Override
	public void deleteById(Long key) {
		log.info("User deleteById - {}", key);
		if (!map.containsKey(key))
			throw new RuntimeException("not found");
		map.remove(key);
	}

}
