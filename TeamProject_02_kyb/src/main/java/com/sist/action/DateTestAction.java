package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTestAction implements CompanyAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String finalDate = request.getParameter("finalDate");
		int aNo = Integer.parseInt(request.getParameter("aNo"));
		
		return "DateTest?finalDate="+finalDate+"&aNo="+aNo; 
	} 

}
