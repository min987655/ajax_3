package com.cos.ajax3.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ajax3.action.Action;
import com.cos.ajax3.action.BaseballHomeAction;
import com.cos.ajax3.action.PlayerListProcAction;

@WebServlet("/baseball")
public class BaseballController extends HttpServlet {
	private static final String TAG = "BaseballController : ";
	private static final long serialVersionUID = 1L;
       
    public BaseballController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		Action action = router(cmd); 
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if (cmd.equals("home")) {
			return new BaseballHomeAction();
		} else if (cmd.equals("playerListProc")) {
			return new PlayerListProcAction();
		}
		return null;
	} 

}
