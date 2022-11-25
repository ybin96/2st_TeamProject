package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.OrderDAO;
import com.sist.vo.OrderVO;

/**
 * Servlet implementation class OldOrderLoginCheck
 */
@WebServlet("/OldOrderLoginCheck")
public class OldOrderLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldOrderLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO dao = OrderDAO.getInstance();
		String cName = request.getParameter("cName");
		//System.out.println("cname: "+cName);
		String cPhone = request.getParameter("cPhone");
		//System.out.println("cPhone: "+cPhone);
		response.setContentType("text/plain;charset=utf-8");
		int cNo = dao.login(cName, cPhone);
		PrintWriter out = response.getWriter();
		out.print(cNo);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
