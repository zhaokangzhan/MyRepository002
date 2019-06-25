package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import com.domain.TestSelect;
import com.util.Mysql;



public class Testdao {
	private static Testdao instance = null;

	public static Testdao getInstance() {
		if (instance == null) {
			instance = new Testdao();
		}
		return instance;
	}

	// 拿到数据库对应题号的答案
	public ArrayList<String> getAnswerList(ArrayList<Integer> ra_list) {
		ArrayList<String> sql_list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			for (Integer ra_id : ra_list) {
				String sql = "SELECT * FROM test WHERE id="+ra_id;
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					String s = rs.getString("anser");
					sql_list.add(s);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return sql_list;
	}


//	// 随机抽取数据库里面的题库---抽4道题
//	public ArrayList<TestSelect> getAlltest() {
//		ArrayList<TestSelect> realTest = new ArrayList<TestSelect>();
//		Connection conn = null;
//		PreparedStatement pst = null;
//		ResultSet rs = null;
//		int totalCount = 0;
//		try {
//			String sql = "select count(*) from test";// 得到数据库题目的总条数
//			conn = Mysql.getConnection();
//			pst = conn.prepareStatement(sql);
//			rs = pst.executeQuery();
//			if (rs.next()) {
//				// 得到数据库题目的总条数
//				totalCount = Integer.parseInt(rs.getString(1));
//				System.out.println("得到数据库题目的总条数" + totalCount);
//
//			}
////			// 注意=====数据库里面的总题目数必须大于等于抽取考试题目的数量
////			// 在数据库题目的总条数范围内生成4个随机数
////			ArrayList<Integer> ra_list = new ArrayList<Integer>();
////			while (ra_list.size()<4) {
////				Random ra = new Random();
////				int ra_id = ra.nextInt(totalCount) + 1;
////				//用集合去存储不相同随机数------避免生成了相同的随机数
////				if (!ra_list.contains(ra_id)) {
////					ra_list.add(ra_id);
////				}
////			}
////			realTest = getRealTest(ra_list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			Mysql.release(conn, pst, rs);
//		}
//		return realTest;
//	}

	// 得到数据库里面的所有题目总数
		public int getTotal() {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			int totalCount = 0;
			try {
				String sql = "select count(*) from test";// 得到数据库题目的总条数
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				if (rs.next()) {
					// 得到数据库题目的总条数
					totalCount = Integer.parseInt(rs.getString(1));
					System.out.println("得到数据库题目的总条数" + totalCount);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Mysql.release(conn, pst, rs);
			}
			return totalCount;
		}

		
	public ArrayList<TestSelect> getRealTest(ArrayList<Integer> ra_list) {
		ArrayList<TestSelect> list = new ArrayList<TestSelect>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int tdnumber=1;
		try {
			for (Integer ra_id : ra_list) {
				
				String sql = "SELECT * FROM test WHERE id="+ra_id;
				conn = Mysql.getConnection();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					TestSelect test = new TestSelect();
					test.setNumber(tdnumber);
					test.setId(rs.getInt(1));
					test.setQuestion(rs.getString("question"));
					test.setSelect_a(rs.getString("select_a"));
					test.setSelect_b(rs.getString("select_b"));
					test.setSelect_c(rs.getString("select_c"));
					test.setSelect_d(rs.getString("select_d"));
					test.setAnser(rs.getString("anser"));
					test.setExplain(rs.getString("explain"));
					list.add(test);
					tdnumber++;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Mysql.release(conn, pst, rs);
		}
		return list;
	}

	

	

}