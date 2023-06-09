package org.example.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Team {

	private Long teamId;
	private String teamName;
	private List<User> member;

}
