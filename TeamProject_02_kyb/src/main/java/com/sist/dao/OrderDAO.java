package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.OrderVO;

public class OrderDAO {
	
	private static OrderDAO dao;
	public static OrderDAO getInstance() {
		if(dao == null) {
			dao = new OrderDAO();
		}
		return dao;
	}
	
	private OrderDAO() {		
	}	
	
	//신규문의
	public int insertNewOrder(OrderVO o) {
		int re = -1;
		
		String sql = "insert into "
				+ "CustomerNew "
				+ "(cNo,cName,cPhone,cAddr,cManager,cEmail,cService,cPrice,"
				+ "cInfo,cPortfolio) "
				+ "values(seq_customer.nextval,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o.getCName());
			pstmt.setString(2, o.getCPhone());
			pstmt.setString(3, o.getCAddr());
			pstmt.setString(4, o.getCManager());
			pstmt.setString(5, o.getCEmail());
			pstmt.setInt(6, o.getCService());
			pstmt.setInt(7, o.getCPrice());
			pstmt.setString(8, o.getCInfo());
			pstmt.setString(9, o.getCPortfolio());			
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}				
		
		return re;
	}
	
	public int insertMeeting(OrderVO o) {
		int re = -1;
		String sql = "update CustomerNew set cMeeting=(to_date(?,'yyyy-mm-dd HH24:MI')) where cNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o.getCMeeting());
			pstmt.setInt(2, o.getCNo());		
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}	
		return re;
	}
	
	//기존문의
	
	public int insertFile(OrderVO o) {
		int re = -1;
		String sql = "insert into cFile(fileNo, cNo, filePath) values(seq_cfile.nextval, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getCNo());
			pstmt.setString(2, o.getFilePath());		
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}	
		return re;
	}
	public int insertAddInfo(OrderVO o) {
		int re = -1;
		String sql = "insert into cAddInfo(addInfoNo, cNo, content) values(seq_addInfo.nextval, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getCNo());
			pstmt.setString(2, o.getContent());		
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}	
		return re;
	}
	
	public int login(String cname, String cphone) {
		int cno = -1;
		String sql = "select cno from customerNew where cname='"+cname+"' and cphone='"+cphone+"'";
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
				cno = rs.getInt("cno");
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(rs != null) { try{rs.close();}catch(Exception e) {} }
			if(stmt != null) { try{stmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}		
		return cno;
	}
	
	public OrderVO findRequest(int cNo) {
		OrderVO o = new OrderVO();
		String sql = "select n.cno,n.cname,o.cprogress from CustomerNew n, "
				+ "CustomerOrigin o where n.cNo = o.cNo and o.cno="+cNo;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds  =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				o.setCNo(rs.getInt("cNo"));
				o.setCName(rs.getString("cName"));
				o.setCProgress(rs.getInt("cProgress"));
			}
		} catch (Exception e) {
			System.out.println("Exception: "+e);
		}finally {
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(stmt!=null) {try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return o;
	}
	
	public int progress() {
		int re = -1;
		
		return re;
	}
	
	public int addRequest() {
		int re = -1;
		
		return re;
	}
}