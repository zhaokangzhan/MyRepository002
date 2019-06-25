package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.domain.Book;
import com.util.ConnectDB;


public class BooksDao {
	private static BooksDao instance=null;
	public static BooksDao getInstance(){
		
		if(instance==null) {
			instance=new BooksDao();
		}
		
		return instance;
		
	}
	
	public ArrayList<Book> selectallbooks() {
		// TODO Auto-generated method stub		
		 Connection conn=null;			
			String sql = "select * from books";
			ResultSet rs=null;
			Book book=null;
			ArrayList<Book> bookstore=null;
			
       try {
    	   conn =ConnectDB.getconnect();
				PreparedStatement pstmt=conn.prepareStatement(sql);	
			rs= pstmt.executeQuery();
			bookstore=new ArrayList<Book>();
			while(rs.next()) {
				book=new Book();
				book.setId(rs.getInt("id"));
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPrint(rs.getString("print"));
				book.setPrice(rs.getString("price"));
				book.setTip(rs.getString("tip"));
				
				bookstore.add(book);
				
			}	
			pstmt.close();
			conn.close();
			return bookstore;
	
			}catch (Exception e) {
				e.printStackTrace() ;
			      System.out.println("查询结果失败");
			}	

		return null;
	}

	public Book selectonebooks(int id) {
		// TODO Auto-generated method stub
		Book book=null;
		 book=new Book();
		 System.out.println("bookdao的id="+id);
		 Connection conn=null;			
			String sql = "select * from books where id="+id;
			ResultSet rs=null;	
    try {	
 	   conn =ConnectDB.getconnect();
				PreparedStatement pstmt=conn.prepareStatement(sql);	
			rs= pstmt.executeQuery();	
			while(rs.next()) {
			    book.setId(rs.getInt("id"));
				book.setBookid(rs.getString("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPrint(rs.getString("print"));
				book.setPrice(rs.getString("price"));
				book.setTip(rs.getString("tip"));	
			}
			pstmt.close();
			conn.close();
			return book;
			
			}catch (Exception e) {
				e.printStackTrace() ;
			      System.out.println("bookdao查询当前id结果失败");
			}	
	return book;
	}

	public Book updateone_books(Book book) {	
		// TODO Auto-generated method stub
		
		Connection conn=null;			
		String sql = "update books set bookid=?,bookname=?,author=?,print=?,price=?,tip=? where id=?";
		
		 System.out.println("fbookdao修改的book.getBookname()="+book.getBookname());
		 System.out.println("fbookdao修改的book.getAuthor()="+book.getAuthor());
		try {
	    	   conn =ConnectDB.getconnect();
					PreparedStatement pstmt=conn.prepareStatement(sql);	
				pstmt.setString(1, book.getBookid());
				pstmt.setString(2, book.getBookname());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getPrint());
				pstmt.setString(5, book.getPrice());
				pstmt.setString(6, book.getTip());
				pstmt.setInt(7, book.getId());
				
				 System.out.println("bookdao修改的book.getBookname()="+book.getBookname());
				 System.out.println("bookdao修改的book.getAuthor()="+book.getAuthor());
			pstmt.executeUpdate();
				pstmt.close();
				conn.close();
				return book;
				}catch (Exception e) {
					e.printStackTrace() ;
				      System.out.println("修改一行数据失败");
				}	
		return book;
	}

	public int deleteone_books(int id) {
		// TODO Auto-generated method stub
		     Connection conn=null;			
			String sql = "delete from books where id="+id;
				
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

	public int insertbooks(Book book) {
		// TODO Auto-generated method stub
		
		int	rcount=0;
	      Connection conn=null;
			
			conn =ConnectDB.getconnect();
		
			String sql = "insert into books(bookid,bookname,author,print,price,tip)values(?,?,?,?,?,?)";
			
			try {
				
				PreparedStatement pstmt=conn.prepareStatement(sql);
				
				 pstmt.setString(1, book.getBookid());
				pstmt.setString(2, book.getBookname());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getPrint());
				pstmt.setString(5, book.getPrice());
				pstmt.setString(6, book.getTip());
			int	f= pstmt.executeUpdate();
			rcount=f;
			pstmt.close();
			conn.close();
			
				return rcount;
				
					
			}catch (Exception e) {
				e.printStackTrace() ;
			      System.out.println("插入数据失败");
			}
			
			return rcount;
	}

	public ArrayList<Book> searchbooks(Book book) {
		// TODO Auto-generated method stub
		Connection conn=null;			
		String sql = "select * from books where bookname="+book.getBookname();
		 System.out.println("bookdao的book.getBookname()="+book.getBookname());
		ResultSet rs=null;
		ArrayList<Book> bookstore=null;
		
   try {
	    conn =ConnectDB.getconnect();
			PreparedStatement pstmt=conn.prepareStatement(sql);	
		rs= pstmt.executeQuery();
		bookstore=new ArrayList<Book>();
		while(rs.next()) {
			
		
			book.setId(rs.getInt("id"));
			book.setBookid(rs.getString("bookid"));
			book.setBookname(rs.getString("bookname"));
			book.setAuthor(rs.getString("author"));
			book.setPrint(rs.getString("print"));
			book.setPrice(rs.getString("price"));
			book.setTip(rs.getString("tip"));
			
			bookstore.add(book);
			
		}	
		pstmt.close();
		conn.close();
		return bookstore;

		}catch (Exception e) {
			e.printStackTrace() ;
		      System.out.println("查询结果失败");
		}	

	return null;
}
		
	
}
