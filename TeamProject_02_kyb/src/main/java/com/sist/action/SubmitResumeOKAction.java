package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.RecruitDAO;
import com.sist.vo.AFileVO;
import com.sist.vo.ALinkVO;
import com.sist.vo.ApplicantVO;


public class SubmitResumeOKAction implements CompanyAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("/recruit/upload");
		//System.out.print(path);
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*100,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
		
		File uploadFile =  multi.getFile("afile");
		
		String fname = "";
		
		if(uploadFile != null){
			fname = uploadFile.getName();
		}
		
		System.out.println("파일명"+fname);
		String name = multi.getParameter("aname");
		String phone = multi.getParameter("aphone");
		String email = multi.getParameter("aemail");
		int work = Integer.parseInt(multi.getParameter("awork"));
		String title = multi.getParameter("atitle");
		
		RecruitDAO dao = RecruitDAO.getInstance();
		
		ApplicantVO a = new ApplicantVO();
		
		a.setAName(name);
		a.setAPhone(phone);
		a.setAEmail(email);
		a.setAWork(work);
		a.setAStatus(0);
		a.setATitle(title);
		
		int re1 = dao.submitResume(a);
		
		ApplicantVO afn = dao.findMyResume(name, 1, phone);
		
		int ano = afn.getANo();
		
		
		AFileVO f = new AFileVO();
		f.setANo(ano);
		f.setAFilepath(fname);
		
		int re2 = dao.uploadResumeFile(f);
		
		int re3 = 0;
		
		
		if(multi.getParameterValues("links")!=null) {
			String[] arr = multi.getParameterValues("links");
			
			for (int i = 0; i < arr.length; i++) {
				ALinkVO l = new ALinkVO();
				l.setANO(ano);
				l.setLinks(arr[i]);
				re3 += dao.uploadLink(l);
	        }
		}
		System.out.println(re1+"명의 지원자 추가");
		System.out.println(re2+"개의 파일추가");
		System.out.println(re3+"개의 링크추가");
		
		
	
		return "newRecruitBoard.jsp";
	}

}