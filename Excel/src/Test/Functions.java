package Test;

import java.util.ArrayList;

public class Functions {

	//����һ����������һ�������������ת��,�ַ��������飬���������л�
		public static ArrayList<ArrayList> getArray_student_data_list(ArrayList<Student> data_students){
			
			ArrayList<ArrayList> data_stu_list = new ArrayList<ArrayList>(); 
			Student student = new Student();
			int i,j;
			int stu_num = data_students.size();
			
			//��ʼ������
			for(i=0; i<stu_num ; i++) 
				data_stu_list.add(new ArrayList());
			//�򼯺������Ԫ��	
			for(i=0; i<stu_num ; i++) {
				student = data_students.get(i);
				data_stu_list.get(i).add(student.getStu_name());
				data_stu_list.get(i).add(student.getE_mail());
//����������				
//				System.out.println("====>"+student.getChinese_score());
//				System.out.println("====>"+student.getMath_score());
				
				data_stu_list.get(i).add(String.valueOf(student.getChinese_score()));
				data_stu_list.get(i).add(String.valueOf(student.getMath_score()));
			}
				
			return data_stu_list;
		}
     
}
