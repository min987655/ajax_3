package com.cos.ajax3.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ajax3.model.Players;
import com.cos.ajax3.repository.PlayersRepository;
import com.cos.ajax3.util.Script;
import com.google.gson.Gson;

public class PlayerListProcAction implements Action {
	private static final String TAG = "PlayerListProcAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int playersTeamId = Integer.parseInt(request.getParameter("teamId"));		
		System.out.println(TAG +"playersTeamId :"+ playersTeamId);

		PlayersRepository playersRepository =
				PlayersRepository.getInstance();
		
		List<Players> playerList = playersRepository.findTeamPlayer(playersTeamId);

		Gson gson = new Gson();
		String playerListJson = gson.toJson(playerList);
		
		System.out.println(TAG + "playerList : " +playerListJson);
		Script.outJson(playerListJson, response);
	}
}
