package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.domain.student_User;
import com.domain.teacher_User;
import com.util.Mysql;

public class Teacher_Userdao {
	private static Teacher_Userdao instance = null;

	public static Teacher_Userdao getInstance() {

		if (instance == null) {
			instance = new Teacher_Userdao();
		}

		return instance;
	}


	public List<teacher_User> listallteacher_users() {
		// TODO Auto-generated method stub
		ArrayList<teacher_User> sql_list = new ArrayList<teacher_User>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		teacher_User su=null;
		int ordernum=1;
		try {
			
				String sql = "SELECT * FROM teacher_user ";
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					su=new teacher_User();
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
				return sql_list;
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return sql_list;
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

}
