package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.dao.Testdao;

public class TestScore {
		public static int GetTestScore(Map<String, String[]> map,ArrayList<String> list,ArrayList<Integer> ra_list){
			
			int result = 0;
			ArrayList<String> sql_list = Testdao.getInstance().getAnswerList(ra_list);
			for (String string : sql_list) {
				System.out.println("----testscore----------数据库拿到的答案如下:"+string);
			}
//			System.out.println("--------------------数据库的总共有答案个数:"+sql_list.size());
			Set<String> key = map.keySet();
			Iterator<String> iterator = key.iterator();
			ArrayList<String> valueStringList = new ArrayList<String>();
			while (iterator.hasNext()) {
				String keyString = (String) iterator.next();
				String[] value = map.get(keyString);
				for(int i = 0; i < value.length ; i++) {
					String valueString = value[i];
					valueStringList.add(valueString);
					System.out.println("------------------学生答题的答案"+keyString+"==="+valueString);	
				}	
			}
			for (int i = 0; i < valueStringList.size(); i++) {
				String student_answer = valueStringList.get(i);
				System.out.println("学生第"+(i)+"条答案："+student_answer);
				String sql_answer = sql_list.get(i);
				System.out.println("数据库第"+(i)+"条答案："+sql_answer);
				System.out.println("变量i的变化"+(i));
				if (student_answer.equals(sql_answer)) {
						result = result + 20;//设置分值
				}	
			}
//			System.out.println("今次总分是:"+result);
			return result;
			
		}
	}
