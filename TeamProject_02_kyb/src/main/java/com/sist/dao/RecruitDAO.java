package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.AFileVO;
import com.sist.vo.ALinkVO;
import com.sist.vo.ApplicantVO;
import com.sist.vo.ScheduleVO;

public class RecruitDAO {
	
	public static RecruitDAO dao;
	
	public static RecruitDAO getInstance() {
		if(dao == null) {
			dao = new RecruitDAO();
		}
		return dao;
	}
	
	private RecruitDAO() {
		
	}
	public int updateFile(AFileVO f) {
		int re = -1;
		String sql = "delete from afile where ano = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, f.getANo());				
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("submitResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}
		re = uploadResumeFile(f);
		return re;
		
	}
	public int deleteLink(int ano) {
		int re = -1;
		String sql = "delete from alink where ano = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, ano);				
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("submitResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}
		return re;
		
	}
	
	public int updateResume(int ano,ApplicantVO a) {
		int re = -1;
		String sql = "update applicantnew set aname = ?, aphone = ?, aemail = ? where ano = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAName());
			pstmt.setString(2, a.getAPhone());
			pstmt.setString(3, a.getAEmail());			
			pstmt.setInt(4, ano);				
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("submitResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return re;
	}
	
	
	public int submitResume(ApplicantVO a) {
		int re = -1;
		String sql = "insert into applicantnew"
				+"(ano, aname, aphone, aemail, aresumepath, awork, astatus) "
				+"values(seq_applicant.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAName());
			pstmt.setString(2, a.getAPhone());
			pstmt.setString(3, a.getAEmail());			
			pstmt.setString(4, a.getATitle());			
			pstmt.setInt(5, a.getAWork());			
			pstmt.setInt(6, a.getAStatus());			
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("submitResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return re;
	}
	public int uploadResumeFile(AFileVO f) {
		int re = -1;
		String sql = "insert into aFile"
				+"(afileno, ano, afilepath) "
				+"values(seq_file.nextval,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, f.getANo());
			pstmt.setString(2, f.getAFilepath());
	
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("uploadResumeFile exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return re;
	}
	public int uploadLink(ALinkVO l) {
		int re = -1;
		String sql = "insert into alink"
				+"(alinkno, ano, links) "
				+"values(seq_link.nextval,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, l.getANO());
			pstmt.setString(2, l.getLinks());
			
			re = pstmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println("uploadResumeFile exception occurred!!:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return re;
	}
	
	
	
	public ApplicantVO findMyResume(String name, int num, String info) {
		ApplicantVO a = null;
		
		String sql = "select * from applicantnew where aname = ? and ";
		
		if(num == 1) {
			sql += "aphone = ?";
		}else {
			sql += "aemail = ?";
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,info);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				a = new ApplicantVO();
				a.setANo(rs.getInt("ano"));
				a.setAName(rs.getString("aname"));
				a.setAPhone(rs.getString("aphone"));
				a.setAEmail(rs.getString("aemail"));
				a.setAWork(rs.getInt("awork"));
				a.setAStatus(rs.getInt("astatus"));
				a.setATitle(rs.getString("aresumepath"));
			}
		}catch(Exception e) {
			System.out.println("findMyResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(rs != null) { try{rs.close();}catch(Exception e) {} }
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return a;
	}
	
	public ArrayList<ALinkVO> findMyLinks(int ano) {
		ArrayList<ALinkVO> list = new ArrayList<ALinkVO>();
		ALinkVO l = null;
		
		String sql = "select * from alink where ano = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ano);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				l = new ALinkVO();
				l.setAlinkNO(rs.getInt("alinkno"));
				l.setANO(rs.getInt("ano"));
				l.setLinks(rs.getString("links"));
				list.add(l);
			}
		}catch(Exception e) {
			System.out.println("findMyResume exception occurred!!:"+e.getMessage());
		}finally {			
			if(rs != null) { try{rs.close();}catch(Exception e) {} }
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}		
		
		return list;
	}
	public AFileVO findMyfile(int ano) {
		AFileVO f = null;
		
		String sql = "select * from afile where ano = ? ";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ano);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				f = new AFileVO();
				f.setAFileNo(rs.getInt("afileno"));
				f.setANo(rs.getInt("ano"));
				f.setAFilepath(rs.getString("afilepath"));
			}
		}catch(Exception e) {
			System.out.println("findMyfile exception occurred!!:"+e.getMessage());
		}finally {			
			if(rs != null) { try{rs.close();}catch(Exception e) {} }
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}			
		return f;
	}
	
	
	public int insertMeeting(ScheduleVO b) {
		int re = -1;
		String sql = "insert into ApplicantOrigin(aMeeting,ano,alevel) values((to_date(?,'yyyy-mm-dd HH24:MI')),?,1 )";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getAMeeting());
			pstmt.setInt(2, b.getANo());
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}	
		return re;
	}
	
}