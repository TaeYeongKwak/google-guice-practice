package org.example.service;

import java.util.concurrent.CopyOnWriteArrayList;

import org.example.entity.Team;
import org.example.entity.User;
import org.example.repository.TeamRepository;
import org.example.repository.UserRepository;

import com.google.inject.Inject;

public class MyServiceImpl implements MyService{

	private final UserRepository userRepository;
	private final TeamRepository teamRepository;

	@Inject
	public MyServiceImpl(UserRepository userRepository, TeamRepository teamRepository) {
		this.userRepository = userRepository;
		this.teamRepository = teamRepository;
	}

	@Override
	public User findUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> {
			throw new RuntimeException("user not found");
		});
	}

	@Override
	public void createUser(String name) {
		Long userId = this.getRandomId();
		userRepository.save(new User(userId, name));
	}

	@Override
	public void joinTeam(Long teamId, Long userId) {
		Team team = this.findTeam(teamId);
		User user = this.findUser(userId);
		team.getMember().add(user);
	}

	@Override
	public Team findTeam(Long teamId) {
		return teamRepository.findById(teamId).orElseThrow(() -> {
			throw new RuntimeException("team not found");
		});
	}

	@Override
	public void createTeam(String name) {
		Long teamId = this.getRandomId();
		teamRepository.save(new Team(teamId, name, new CopyOnWriteArrayList<>()));
	}

	private Long getRandomId() {
		return (long) (Math.random() * Long.MAX_VALUE);
	}

}
