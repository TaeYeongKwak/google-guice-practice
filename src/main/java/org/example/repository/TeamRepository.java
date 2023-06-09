package org.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.example.entity.Team;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeamRepository implements SimpleRepository<Long, Team> {

	private static Map<Long, Team> map = new ConcurrentHashMap<>();

	@Override
	public Team save(Team value) {
		log.info("Team Save - {}", value);
		return map.put(value.getTeamId(), value);
	}

	@Override
	public List<Team> findAll() {
		log.info("Team findAll");
		return map.values().stream().toList();
	}

	@Override
	public Optional<Team> findById(Long key) {
		log.info("Team findById - {}", key);
		return Optional.ofNullable(map.get(key));
	}

	@Override
	public void deleteById(Long key) {
		log.info("Team deleteById - {}", key);
		if (!map.containsKey(key))
			throw new RuntimeException("team not found");
		map.remove(key);
	}

}
