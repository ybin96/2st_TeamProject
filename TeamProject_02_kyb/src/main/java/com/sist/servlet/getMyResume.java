package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.vo.ApplicantVO;

/**
 * Servlet implementation class getMyResume
 */
@WebServlet("/getMyResume")
public class getMyResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMyResume() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type"));
		String info = request.getParameter("info");
		
		System.out.println(name);
		System.out.println(type);
		System.out.println(info);
		
		/*	Gson gson = new Gson();
		String str = gson.toJson(a);
		PrintWriter out = response.getWriter();
		System.out.println("gson값"+str);
		out.print(str);
		out.close();
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}