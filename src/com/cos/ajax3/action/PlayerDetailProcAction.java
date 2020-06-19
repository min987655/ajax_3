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

public class PlayerDetailProcAction implements Action {
	private static final String TAG = "PlayerDetailProcAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int playerId = Integer.parseInt(request.getParameter("playerId"));
		System.out.println(TAG + "playerId :" + playerId);

		PlayersRepository playersRepository = PlayersRepository.getInstance();

		List<Players> playerDetail = playersRepository.findPlayer(playerId);
		
		Gson gson = new Gson();
		String playerDetailJson = gson.toJson(playerDetail);
		System.out.println(TAG + "playerDetail : " + playerDetail);
		
		Script.outJson(playerDetailJson, response);

	}
}
