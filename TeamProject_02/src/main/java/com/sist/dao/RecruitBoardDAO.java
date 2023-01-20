package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.RecruitBoardVO;

public class RecruitBoardDAO {
	
		//싱글턴 방식의 객체 제공하기
		private static RecruitBoardDAO dao;
		public static RecruitBoardDAO getInstance() {
			if(dao == null) {
				dao = new RecruitBoardDAO();
			}
			return dao;
		}
		
		private RecruitBoardDAO() {		
		}	
		
		// 게시판번호를 받아 정보 가져오기
		public RecruitBoardVO findByNo(int rbNo) {
			RecruitBoardVO r = null;
			String sql = "select rbNo,rTitle,to_char(rStartDate,'yyyy/mm/dd') rStartDate,to_char(rEndDate,'yyyy/mm/dd') rEndDate,"
					+ "rContent,rWork from RecruitBoard where rbNo=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Context context = new InitialContext();
				DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rbNo);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					r = new RecruitBoardVO();
					r.setRbNo(rs.getInt("rbNo"));
					r.setRTitle(rs.getString("rTitle"));
					r.setRStartDate(rs.getString("rStartDate"));
					r.setREndDate(rs.getString("rEndDate"));
					r.setRContent(rs.getString("rContent"));
					r.setRWork(rs.getInt("rWork"));	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(rs != null){try{rs.close();}catch(Exception e){}}
				if(pstmt != null){try{pstmt.close();}catch(Exception e){}}
				if(conn != null){try{conn.close();}catch(Exception e){}}
			}
			
			return r;
		}
		
		// 게시판 모든정보 가져오기
		public ArrayList<RecruitBoardVO> findAll(){
			ArrayList<RecruitBoardVO> list = new ArrayList<RecruitBoardVO>();
			String sql = "select rbNo,rTitle,to_char(rStartDate,'yyyy/mm/dd') rStartDate,to_char(rEndDate,'yyyy/mm/dd') rEndDate,"
					+ "rContent,rWork from RecruitBoard order by rbNo desc";
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Context context = new InitialContext();
				DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
				conn = ds.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					RecruitBoardVO r = new RecruitBoardVO();
					r.setRbNo(rs.getInt("rbNo"));
					r.setRTitle(rs.getString("rTitle"));
					r.setRStartDate(rs.getString("rStartDate"));
					r.setREndDate(rs.getString("rEndDate"));
					r.setRContent(rs.getString("rContent"));
					r.setRWork(rs.getInt("rWork"));
					list.add(r);	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(rs != null){try{rs.close();}catch(Exception e){}}
				if(stmt != null){try{stmt.close();}catch(Exception e){}}
				if(conn != null){try{conn.close();}catch(Exception e){}}
			}
			return list;
		}
}
