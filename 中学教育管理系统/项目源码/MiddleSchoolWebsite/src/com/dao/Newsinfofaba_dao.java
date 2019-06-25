package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.domain.NewsInfofabu;
import com.util.Mysql;

public class Newsinfofaba_dao {
	private static NewsInfofabu instance = null;

	public static NewsInfofabu getInstance() {

		if (instance == null) {
			instance = new NewsInfofabu();
		}

		return instance;
	}

	public int inser_news_images(NewsInfofabu newsinfofabu) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {		
			String sql = "insert into newsinfoimage (title,content,imagepath) value(?,?,?)";		
			conn = Mysql.getConnection();
			pst = conn.prepareStatement(sql);			
		    pst.setString(1,newsinfofabu.getTitle());
			pst.setString(2, newsinfofabu.getContent());
			pst.setString(3, newsinfofabu.getImagepath());	
			pst.executeUpdate();
			System.out.println("-----执行---student_userdao----add_onestudent_user(student_User su)-----");
			
			return 1;
			
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Mysql.release(conn, pst, rs);
	}
		
		return 0;
	}

	public NewsInfofabu getnewsfrom_table() {
		NewsInfofabu newinfo=new NewsInfofabu();
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				try {		
					String sql = "select * from newsinfoimage order by id desc";		
					conn = Mysql.getConnection();
					pst = conn.prepareStatement(sql);
					rs=pst.executeQuery();
					if(rs.next()) {
						newinfo.setTitle(rs.getString("title"));
						newinfo.setContent(rs.getString("content"));
						newinfo.setImagepath(rs.getString("imagepath"));
					}
					return newinfo;
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Mysql.release(conn, pst, rs);
			}
				return newinfo;
	}
}
