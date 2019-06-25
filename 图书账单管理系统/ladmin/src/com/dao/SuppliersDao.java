package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.domain.Book;
import com.domain.Supplier;
import com.util.ConnectDB;


public class SuppliersDao {
	private static SuppliersDao instance=null;
	public static SuppliersDao getInstance(){
		
		if(instance==null) {
			instance=new SuppliersDao();
		}
		
		return instance;
		
	}
	
	
	public ArrayList<Supplier> selectallSuppliers() {
		// TODO Auto-generated method stub
		 Connection conn=null;			
			String sql = "select * from suppliers";
			ResultSet rs=null;
			Supplier supplier=null;
			ArrayList<Supplier> suppliers=null;
			
    try {
 	   conn =ConnectDB.getconnect();
				PreparedStatement pstmt=conn.prepareStatement(sql);	
			rs= pstmt.executeQuery();
			suppliers=new ArrayList<Supplier>();
			while(rs.next()) {
				supplier=new Supplier();
				supplier.setId(rs.getInt("id"));	
				supplier.setSuppliername(rs.getString("suppliername"));
				supplier.setSuppliercertificate(rs.getString("suppliercertificate"));
				supplier.setSupplierpnumber(rs.getString("supplierpnumber"));
				supplier.setSupplieremail(rs.getString("supplieremail"));
				supplier.setSupplieraddress(rs.getString("supplieraddress"));
				suppliers.add(supplier);
				
			}	
			pstmt.close();
			conn.close();
			return suppliers;
	
			}catch (Exception e) {
				e.printStackTrace() ;
			      System.out.println("查询结果失败");
			}	

		return suppliers;
	}
		
	
}
