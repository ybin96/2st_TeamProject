package com.sist.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.RecruitBoardDAO;
import com.sist.dao.RecruitDAO;
import com.sist.vo.ApplicantVO;

public class ApplicantLoginCheckAction implements CompanyAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("aname");
		int type = Integer.parseInt(request.getParameter("radio"));
		String info = request.getParameter("info");
		
		RecruitDAO dao = RecruitDAO.getInstance();
		ApplicantVO a = dao.findMyResume(name, type, info);
		

		if(a == null) {
		
			 try { String var = "지원서를 넣은 사용자가 아닙니다.";
			 	response.setContentType("text/html; charset=utf-8"); 
			 	PrintWriter w = response.getWriter(); 
			 	w.write("<script>alert('"+var+"');location.href='myRecruitLogin.jsp';</script>");
			 	w.flush(); 
			 	w.close(); 
			 }catch(Exception e) { 
				 e.printStackTrace(); 
			 }
		

		}
		if(a.getAStatus() == 0) {
			request.setAttribute("name", name);
			request.setAttribute("type", type);
			request.setAttribute("info", info);
			return "myReruitUpdate.jsp";
		}
		 
		if(a.getAStatus() == 1) {
			request.setAttribute("name", name);
			request.setAttribute("title", a.getATitle());	
			request.setAttribute("no", a.getANo());
			return "myRecruitResult_document.jsp";
		}
		if(a.getAStatus() == 2) {
			request.setAttribute("name", name);
			request.setAttribute("title", a.getATitle());
			request.setAttribute("no", a.getANo());
			return "myRecruitResult_coding.jsp";
		}
		if(a.getAStatus() == 3) {
			request.setAttribute("name", name);
			request.setAttribute("title", a.getATitle());	
			return "myRecruitResult_pass.jsp";
		}
		if(a.getAStatus() == 4) {
			request.setAttribute("name", name);
			request.setAttribute("title", a.getATitle());	
			return "myRecruitResult_fail.jsp";
		}

		return "newRecruitBoard.jsp";
	}

}