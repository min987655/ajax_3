package com.cos.ajax3.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

	public static void outJson(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void outText(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
