package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.OrderDAO;
import com.sist.dao.RecruitDAO;
import com.sist.vo.ApplicantVO;
import com.sist.vo.OrderVO;
import com.sist.vo.ScheduleVO;

/**
 * Servlet implementation class DateTest
 */
@WebServlet("/DateTest")
public class DateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String referer = (String)request.getHeader("REFERER");
		RecruitDAO dao = RecruitDAO.getInstance();
		String date = request.getParameter("finalDate");
		int aNo = Integer.parseInt(request.getParameter("aNo"));
		response.setContentType("text/plain");
		ScheduleVO o = new ScheduleVO();
		o.setAMeeting(date);
		System.out.println("date: "+date);
		o.setANo(aNo);
		System.out.println("cNo: "+aNo);
		int re = dao.insertMeeting(o);
		if(re > 0) {
			response.sendRedirect("/TeamProject02/recruit/myRecruitLogin.jsp?re=true");
		}else {
			System.out.println(re);
			response.sendRedirect("/TeamProject02/recruit/myRecruitLogin.jsp?re=false");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}