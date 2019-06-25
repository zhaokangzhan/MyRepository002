package com.service;

import java.util.List;

import com.dao.Student_Userdao;
import com.domain.student_User;


public class Student_UserService {
	
	private Student_Userdao dao = new Student_Userdao();

	public List<student_User> listallstudent_users() {
		// TODO Auto-generated method stub
		
		System.out.println("--       ---执行-----------Student_userservice--------");
			return dao.listallstudent_users();
		
	}

	public List<student_User> update_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		return dao.update_onestudent_user(idid);
		
		
	}

	public student_User copyonestudent_user(int idid) {
		// TODO Auto-generated method stub
		return dao.copyonestudent_user(idid);
	}

	
		
	public student_User realupdate_onestudent_user(student_User su) {
		// TODO Auto-generated method stub
		return dao.realupdate_onestudent_user(su);

	}

	public student_User afterupdate_realupdate_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		return dao.afterupdate_realupdate_onestudent_user(idid);
	}

	public Boolean add_onestudent_user(student_User su) {
		// TODO Auto-generated method stub
		return dao.add_onestudent_user(su);
	}

	public int delete_onestudent_user(int idid) {
		// TODO Auto-generated method stub
		return dao.delete_onestudent_user(idid);
	}

	public List<student_User> seach_onestudent_user(String unique) {
		// TODO Auto-generated method stub
		return dao.seach_onestudent_user(unique);
	}

	public String logincheck_onestudent_user(student_User su) {
		// TODO Auto-generated method stub
		return dao.logincheck_onestudent_user(su);
	}
	}
