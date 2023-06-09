package org.example.service;

import java.util.concurrent.CopyOnWriteArrayList;

import org.example.entity.Team;
import org.example.entity.User;

public interface MyService {

	User findUser(Long userId);
	void createUser(String name);
	void joinTeam(Long teamId, Long userId);
	Team findTeam(Long teamId);
	void createTeam(String name);

}
