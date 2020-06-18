package com.cos.ajax3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Players {
	private int id;
	private int teamId;
	private String playerName;
	private String position;
}
