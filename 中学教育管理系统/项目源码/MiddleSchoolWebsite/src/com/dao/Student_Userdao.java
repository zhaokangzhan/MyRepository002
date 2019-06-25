package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.domain.student_User;
import com.util.Mysql;

public class Student_Userdao {
	private static Student_Userdao instance = null;

	public static Student_Userdao getInstance() {

		if (instance == null) {
			instance = new Student_Userdao();
		}

		return instance;
	}

	public List<student_User> listallstudent_users() {
		// TODO Auto-generated method stub
		ArrayList<student_User> sql_list = new ArrayList<student_User>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		student_User su=null;
		int ordernum=1;
		try {
			
				String sql = "SELECT * FROM student_user ";
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					su=new student_User();
					su.setId(rs.getInt(1));			
					su.setUnique_id(rs.getString(2));
					su.setName(rs.getString(3));
					su.setPassword(rs.getString(4));
					su.setSex(rs.getString(5));
					su.setIdcard_number(rs.getString(6));
					su.setPhonenumber(rs.getString(7));
					su.setOrdernum(ordernum);
					sql_list.add(su);
					ordernum++;
				}	
				System.out.println("-----执行-----------Student_Userdao--listallstudent()------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return sql_list;
	}

	public List<student_User> update_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		ArrayList<student_User> onestudent = new ArrayList<student_User>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		student_User su=null;
		int ordernum=1;
		try {
			
				String sql = "SELECT * FROM student_user where id="+idid;
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					su=new student_User();
					su.setId(rs.getInt(1));
					su.setOrdernum(ordernum);
					su.setUnique_id(rs.getString(2));
					su.setName(rs.getString(3));
					su.setPassword(rs.getString(4));
					su.setSex(rs.getString(5));
					su.setIdcard_number(rs.getString(6));
					su.setPhonenumber(rs.getString(7));
					onestudent.add(su);
					ordernum++;
				}	
				System.out.println("-----执行-----------Student_Userdao---update()-----");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return onestudent;
	}

	public student_User copyonestudent_user(int idid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		student_User su=null;
		int ordernum=1;
	
	try {
		
		String sql = "SELECT * FROM student_user where id="+idid;
		conn = Mysql.getConnection();
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			su=new student_User();
			su.setId(rs.getInt(1));
			su.setOrdernum(ordernum);
			su.setUnique_id(rs.getString(2));
			su.setName(rs.getString(3));
			su.setPassword(rs.getString(4));
			su.setSex(rs.getString(5));
			su.setIdcard_number(rs.getString(6));
			su.setPhonenumber(rs.getString(7));
			ordernum++;
		}	
		System.out.println("-----执行----Student_Userdao--"
				+ "---copyonestudent_user()---getPhonenumber()="+su.getPhonenumber());
		System.out.println("-----执行-----------Student_Userdao---copyonestudent_user()-----");
} catch (Exception e) {
	e.printStackTrace();
} finally {
	Mysql.release(conn, pst, rs);
}
return su;
}

	public student_User realupdate_onestudent_user(student_User su) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {		
			String sql = "update student_user set unique_id=?,name=?,"
					+ "password=?,sex=?,idcard_number=?,phonenumber=?"
					+ " where id=?";		
			conn = Mysql.getConnection();
			pst = conn.prepareStatement(sql);
		    pst.setString(1, su.getUnique_id());
			pst.setString(2, su.getName());
			pst.setString(3, su.getPassword());
			pst.setString(4, su.getSex());
			pst.setString(5, su.getIdcard_number());
			pst.setString(6, su.getPhonenumber());
			pst.setInt(7, su.getId());
			pst.executeUpdate();
			System.out.println("-----执行-----------realupdate_onestudent_user(student_User su)-----");
			System.out.println("-----执行-----------su.getUnique_id()-----"+su.getUnique_id());
			
			return su;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Mysql.release(conn, pst, rs);
	}
		return su;
	}

	

	public student_User afterupdate_realupdate_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		student_User su=null;		
		try {
			
				String sql = "SELECT * FROM student_user where id="+idid;
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					su=new student_User();
					su.setId(rs.getInt(1));				
					su.setUnique_id(rs.getString(2));
					su.setName(rs.getString(3));
					su.setPassword(rs.getString(4));
					su.setSex(rs.getString(5));
					su.setIdcard_number(rs.getString(6));
					su.setPhonenumber(rs.getString(7));
				
				}	
				System.out.println("-----执行-----------Student_Userdao---aftet_update()-----");
				System.out.println("-----执行-----------Student_Userdao---aftet_update()-"
						+ "-----su.getPhonenumber()="+su.getPhonenumber());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return su;
	}

	public Boolean add_onestudent_user(student_User su) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {		
			String sql = "insert into student_user set unique_id=?,name=?,"
					+ "password=?,sex=?,idcard_number=?,phonenumber=?";		
			conn = Mysql.getConnection();
			pst = conn.prepareStatement(sql);
		    pst.setString(1, su.getUnique_id());
			pst.setString(2, su.getName());
			pst.setString(3, su.getPassword());
			pst.setString(4, su.getSex());
			pst.setString(5, su.getIdcard_number());	
			pst.setString(6, su.getPhonenumber());
			pst.executeUpdate();
			System.out.println("-----执行---student_userdao----add_onestudent_user(student_User su)-----");
			
			
			return true;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Mysql.release(conn, pst, rs);
	}
		return true;
	}

	public int delete_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		int recout=0;
		System.out.println("-----执行-----------Student_Userdao--"
				+ "-delete_onestudent_user()-----idid="+idid);
		try {
			
				String sql = "DELETE FROM student_user where id="+idid;
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				int recout2=pst.executeUpdate();
				
				System.out.println("-----执行-----------Student_Userdao--"
						+ "-delete_onestudent_user()-----recout="+recout);
				return recout2;
					
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return recout;
	
	}

	public List<student_User> seach_onestudent_user(String unique) {
		// TODO Auto-generated method stub
		ArrayList<student_User> sql_list = new ArrayList<student_User>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		student_User su=null;
		int ordernum=1;
	
	try {	
		String sql = "SELECT * FROM student_user where unique_id="+unique;
		conn = Mysql.getConnection();
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			su=new student_User();
			su.setId(rs.getInt(1));
			su.setOrdernum(ordernum);
			su.setUnique_id(rs.getString(2));
			su.setName(rs.getString(3));
			su.setPassword(rs.getString(4));
			su.setSex(rs.getString(5));
			su.setIdcard_number(rs.getString(6));
			su.setPhonenumber(rs.getString(7));
			sql_list.add(su);
			ordernum++;
		}	
		System.out.println("-----执行----Student_Userdao--"
				+ "---copyonestudent_user()---getPhonenumber()="+su.getPhonenumber());
		System.out.println("-----执行-----------Student_Userdao---copyonestudent_user()-----");
} catch (Exception e) {
	e.printStackTrace();
} finally {
	Mysql.release(conn, pst, rs);
}
return sql_list;
	}

	public String logincheck_onestudent_user(student_User su) {
		String id=null;
		Connection conn=null;
		ResultSet rs=null;
		String sql = "select id from student_user where name=? and password=?";
		try {
			conn = Mysql.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, su.getName());
			pstmt.setString(2, su.getPassword());
			rs = pstmt.executeQuery();
				System.out.println("----student-userdao表单输入的用户名:"+su.getName());
				System.out.println("----student-userdao表单输入的密码:"+su.getPassword());
				while (rs.next()) {
					String newid = rs.getString("id"); // 通过列名获取指定字段的值
					
					id=newid;
					System.out.println("数据库的id为:"+newid);
				}
				
				rs.close();
				pstmt.close();
				conn.close();
				
		}catch (Exception e) {
			e.printStackTrace() ;
		      System.out.println("查询结果失败");
		}
		
		
		
		return id;
		
	}
}
