package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.OrderDAO;
import com.sist.vo.OrderVO;

public class OldOrderAddRequsestOKAction implements CompanyAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String path = request.getRealPath("/order/cFile");
		//System.out.print(path);
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
		);
		
		OrderVO o = new OrderVO();
		o.setCNo(Integer.parseInt(multi.getParameter("cNo")));
		o.setContent(multi.getParameter("content"));
		OrderDAO dao = OrderDAO.getInstance();
		int re = dao.insertAddInfo(o);
		request.setAttribute("re", re);

		OrderVO f = new OrderVO();
		f.setCNo(Integer.parseInt(multi.getParameter("cNo")));
		f.setFilePath(multi.getFile("uploadFile").getName());
		int re2=dao.insertFile(f);
		if(re2>0) {
			System.out.println("파일 추가 완료");
		}else {
			File uploadFile = multi.getFile("uploadFile"); 
			uploadFile.delete();
			System.out.println("파일 추가 실패");
		}
		request.setAttribute("re2", re2);
		
		return "oldOrderAddRequestOK.jsp";
	}

}
