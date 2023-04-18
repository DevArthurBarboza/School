package br.com.ExemploJDBC.model;

public class Course {

	/**
	 * id int primary key
	 * title varchar(30)
	 * dept_name varchar(30) foreign key
	 * credit numeric
	 * 
	 */
	
	private int idCourse;
	private String title;
	private String dept_name;
	private double credit;
	
	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeptName() {
		return dept_name;
	}
	public void setDeptName(String dept_name) {
		this.dept_name = dept_name;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
	
}
