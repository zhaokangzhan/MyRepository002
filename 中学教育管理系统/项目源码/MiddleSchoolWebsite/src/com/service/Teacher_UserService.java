package com.service;

import java.util.List;

import com.dao.Student_Userdao;
import com.dao.Teacher_Userdao;
import com.domain.student_User;
import com.domain.teacher_User;


public class Teacher_UserService {
	
	private Teacher_Userdao dao = new Teacher_Userdao();

	public List<teacher_User> listallteacher_users() {
		// TODO Auto-generated method stub
		
		System.out.println("--       ---执行-----------Student_userservice--------");
			return dao.listallteacher_users();
		
	}

	
	

	
	}
