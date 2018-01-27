package Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import GenerateExcel.GenExcelObject;

public class TestExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<ArrayList> data_list = null;
		ArrayList<String> fields = new ArrayList<String>();
		String excel_file_path = "D:/"+sf.format(new Date())+".xlsx";
	    ArrayList<Student> data_students = new ArrayList<Student>();
	   
	    Student stu1 = new Student("孙宏伟","1103009779@qq.com",89,99);
	    Student stu2 = new Student("Mike","1103009779@qq.com",89,99);
	    Student stu3 = new Student("Mike","1103009779@qq.com",89,99);
	    Student stu4 = new Student("Mike","1103009779@qq.com",89,99);
	    
		
	    fields.add("姓名");
		fields.add("电子邮件");
		fields.add("语文");
		fields.add("数学");
		
		data_students.add(stu1);
		data_students.add(stu2);
		data_students.add(stu3);
		data_students.add(stu4);
		
		System.out.println("============"+excel_file_path);
		
		data_list=Functions.getArray_student_data_list(data_students);		
		
//		new GenExcelObject(excel_file_path,fields,data_list).generate_excel_file();
		
		new GenExcelObject().generate_excel_file(excel_file_path, fields, data_list);
		
	}

}
