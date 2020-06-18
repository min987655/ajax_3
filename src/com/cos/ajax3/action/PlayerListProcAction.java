package com.cos.ajax3.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ajax3.model.Players;
import com.cos.ajax3.repository.KBOTeamRepository;
import com.cos.ajax3.repository.PlayersRepository;
import com.cos.ajax3.util.Script;
import com.google.gson.Gson;

public class PlayerListProcAction implements Action {
	private static final String TAG = "PlayerListProcAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		System.out.println(TAG + sb.toString());
		Gson gson = new Gson();
		Players players = gson.fromJson(sb.toString(), Players.class);
		int playersTeamId = players.getTeamId();
		System.out.println(TAG +"playersTeamId :"+ playersTeamId);
		
		PlayersRepository playersRepository =
				PlayersRepository.getInstance();
		
		List<Players> playerList = playersRepository.findTeamPlayer(playersTeamId);
		System.out.println(TAG + "playerList : " +playerList);
//		List<Players> playerList = playersRepository.findAll();
		String playerListJson = gson.toJson(playerList);
		Script.outJson(playerListJson, response);
	}
}
