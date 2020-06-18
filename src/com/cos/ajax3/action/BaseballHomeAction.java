package com.cos.ajax3.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ajax3.model.KBOTeam;
import com.cos.ajax3.repository.KBOTeamRepository;

public class BaseballHomeAction implements Action {
	private static final String TAG = "BaseballHomeAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KBOTeamRepository baseballRepository = 
				KBOTeamRepository.getInstance();
		
		List<KBOTeam> kboTeams = baseballRepository.findAll();
		System.out.println(TAG + kboTeams);
		
		request.setAttribute("kboTeams", kboTeams);
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
	}
}
