package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.OrderDAO;
import com.sist.vo.OrderVO;

public class OldOrderDetialAction implements CompanyAction {
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		//System.out.println(cNo);
		OrderDAO dao = OrderDAO.getInstance();
		OrderVO o = dao.findRequest(cNo);
		String cName = o.getCName();
		int cProgress = o.getCProgress();
		request.setAttribute("cName", cName);
		request.setAttribute("cProgress", cProgress);
		request.setAttribute("cNo", cNo);
		return "oldOrderDetail.jsp";
	}
}
