package Test;

import java.util.ArrayList;

public class Functions {

	//定义一个方法，将一个对象数组进行转换,字符串的数组，类似于序列化
		public static ArrayList<ArrayList> getArray_student_data_list(ArrayList<Student> data_students){
			
			ArrayList<ArrayList> data_stu_list = new ArrayList<ArrayList>(); 
			Student student = new Student();
			int i,j;
			int stu_num = data_students.size();
			
			//初始化集合
			for(i=0; i<stu_num ; i++) 
				data_stu_list.add(new ArrayList());
			//向集合里添加元素	
			for(i=0; i<stu_num ; i++) {
				student = data_students.get(i);
				data_stu_list.get(i).add(student.getStu_name());
				data_stu_list.get(i).add(student.getE_mail());
//用来测试用				
//				System.out.println("====>"+student.getChinese_score());
//				System.out.println("====>"+student.getMath_score());
				
				data_stu_list.get(i).add(String.valueOf(student.getChinese_score()));
				data_stu_list.get(i).add(String.valueOf(student.getMath_score()));
			}
				
			return data_stu_list;
		}
     
}
