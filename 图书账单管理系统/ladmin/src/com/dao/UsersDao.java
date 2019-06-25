package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.domain.Book;
import com.domain.User;
import com.util.ConnectDB;

public class UsersDao {

	private static UsersDao instance = null;

	public static UsersDao getInstance() {

		if (instance == null) {
			instance = new UsersDao();
		}

		return instance;
	}

	public String checkuser(User user) {
		String id = null;
		Connection conn = null;

		conn = ConnectDB.getconnect();
		ResultSet rs = null;
		String sql = "select id from users where username=? and password=?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			System.out.println("表单输入的用户名:" + user.getUsername());
			System.out.println("表单输入的密码:" + user.getPassword());
			while (rs.next()) {
				String newid = rs.getString("id"); // 通过列名获取指定字段的值
				id = newid;
				System.out.println("数据库的id为:" + newid);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询结果失败");
		}
		return id;
	}

	public boolean insertuser(User user) {

		Connection conn = null;

		conn = ConnectDB.getconnect();

		String sql = "insert into users(username,password,phonenumber,email)values(?,?,?,?)";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhonenumber());
			pstmt.setString(4, user.getEmail());
			Boolean flag = pstmt.execute();
			System.out.println("表单输入的用户名:" + user.getUsername());
			System.out.println("表单输入的密码:" + user.getPassword());
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询结果失败");
		}

		return false;
		// TODO Auto-generated method stub

	}

	public ArrayList<User> selectallusers() {
		Connection conn = null;
		String sql = "select * from users";
		ResultSet rs = null;
		User user = null;
		ArrayList<User> allusers = null;

		try {
			conn = ConnectDB.getconnect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			allusers = new ArrayList<User>();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setEmail(rs.getString("email"));
				allusers.add(user);
			}

			pstmt.close();
			conn.close();
			return allusers;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询结果失败");
		}

		return null;
	}

	public User selectoneuser(int id) {
		// TODO Auto-generated method stub
		User user = null;
		user = new User();
		System.out.println("Userdao的id=" + id);
		Connection conn = null;
		String sql = "select * from users where id=" + id;
		ResultSet rs = null;
		try {
			conn = ConnectDB.getconnect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
                 user.setUsername(rs.getString("username"));
                 user.setPassword(rs.getString("password"));
                 user.setPhonenumber(rs.getString("phonenumber"));
                user.setEmail(rs.getString("email"));
			}
			pstmt.close();
			conn.close();
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("bookdao查询当前id结果失败");
		}
		return user;
	}

	public User updateone_user(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;			
		String sql = "update users set username=?,password=?,phonenumber=?,email=? where id=?";
		
		try {
	    	   conn =ConnectDB.getconnect();
					PreparedStatement pstmt=conn.prepareStatement(sql);	
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2,user.getPassword());
				pstmt.setString(3,user.getPhonenumber());
				pstmt.setString(4, user.getEmail());
				pstmt.setInt(5, user.getId());
				 System.out.println("userDAO修改的user.getUsername()="+user.getUsername());
				
			pstmt.executeUpdate();
				pstmt.close();
				conn.close();
				return user;
				}catch (Exception e) {
					e.printStackTrace() ;
				      System.out.println("修改一行数据失败");
				}	
		return user;
	}

	public int deleteone_user(int id) {
		// TODO Auto-generated method stub
		 Connection conn=null;			
			String sql = "delete from users where id="+id;
				
        try {	
	       conn =ConnectDB.getconnect();
				PreparedStatement pstmt=conn.prepareStatement(sql);	
		int	rcount= pstmt.executeUpdate();	
			
			pstmt.close();
			conn.close();
		    return rcount;
       }catch (Exception e) {
		      e.printStackTrace() ;
	           System.out.println("修改一行数据失败");
	                           }	
        return 0;
	}

}
