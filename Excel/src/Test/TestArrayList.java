package Test;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> datas = new ArrayList<Student>();
		Student stu1 = new Student("ËïºêÎ°","1103009779@qq.com",89,99);
		Student stu2 = new Student("Mike","1103009779@qq.com",89,99);
		
		ArrayList<ArrayList> data_list = null;
		
		datas.add(stu1);
		datas.add(stu2);
		
		data_list = Functions.getArray_student_data_list(datas);
		
		for(int j=0;j<data_list.size();j++) {
			for(int k=0;k<data_list.get(j).size();k++) {
				System.out.println("------------->"+data_list.get(j).get(k));
			}
		}
			
		
	}

}
