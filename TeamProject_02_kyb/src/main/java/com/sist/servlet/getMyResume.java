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
import com.google.gson.JsonObject;
import com.sist.dao.RecruitDAO;
import com.sist.vo.AFileVO;
import com.sist.vo.ALinkVO;
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
		response.setContentType("application/json;charset=utf-8");
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type"));
		String info = request.getParameter("info");
		
		RecruitDAO dao = RecruitDAO.getInstance();
		ApplicantVO app = dao.findMyResume(name, type, info);
		int cno = app.getANo();
		ArrayList<ALinkVO> links = dao.findMyLinks(cno);
		AFileVO file = dao.findMyfile(cno);
		
		
		
		Gson gson = new Gson();
		String appJson = gson.toJson(app);
		String linksJson = gson.toJson(links);
		String fileJson = gson.toJson(file);
		//str = str.substring(0, str.length() - 1);
		
		System.out.println(fileJson);
		
		JsonObject jsonObject = new JsonObject();
		
        jsonObject.addProperty("info", appJson);
        jsonObject.addProperty("links", linksJson);
        jsonObject.addProperty("file", fileJson);
        String str = gson.toJson(jsonObject);
        
		System.out.println(str);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}