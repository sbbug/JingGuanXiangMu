package Test;

import java.util.ArrayList;

public class Student {

	private String stu_name;
	private String e_mail;
	private float chinese_score;
	private float math_score;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String _name,String _mail,int chinese_score,int math_score) {
		 
		this.stu_name = _name;
		this.e_mail = _mail;
		this.chinese_score = chinese_score;
		this.math_score = math_score;
		
	}
	
    public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public float getChinese_score() {
		return chinese_score;
	}
	public void setChinese_score(float chinese_score) {
		this.chinese_score = chinese_score;
	}
	public float getMath_score() {
		return math_score;
	}
	public void setMath_score(float math_score) {
		this.math_score = math_score;
	}
	
	
		
}
