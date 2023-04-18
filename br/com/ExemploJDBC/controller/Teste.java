package br.com.ExemploJDBC.controller;

import java.sql.SQLException;
import br.com.ExemploJDBC.model.*;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Department;

public class Teste {

	public static void main(String[] args) {

		try {

			AbstractCRUD<Department> crudDepartment;
			// ...
			crudDepartment = new CRUDDepartment<Department>();

			System.out.println(crudDepartment.open());
			// INSERT
			Department departmentInsert = new Department();
			departmentInsert.setNameDepartment("DPT. Comp");
			departmentInsert.setBuildingDepartment("Campus Sede");
			departmentInsert.setBudgetDepartment(18000.0);

			crudDepartment.create(departmentInsert);

			// DELETE
			crudDepartment.delete(1);

			// UPDATE
			Department departmentUpdate = new Department();
			departmentUpdate.setIdDepartment(2);
			departmentUpdate.setNameDepartment("Departamento Comp");
			departmentUpdate.setBuildingDepartment("Campus Sede");
			departmentUpdate.setBudgetDepartment(180000.0);

			crudDepartment.update(departmentUpdate);

			// Select by id
			Department dep = crudDepartment.getById(2);
			System.out.println(dep.getNameDepartment());

			ArrayList<Department> departments = crudDepartment.listAll();
			for (Department d : departments) {
				System.out.println(d.getNameDepartment());
			}
			System.out.println(crudDepartment.close());

			// STUDENT

			AbstractCRUD<Student> crudStudent;
			// ...
			crudStudent = new CRUDStudent<Student>();

			System.out.println(crudStudent.open());
			// INSERT
			Student studentInsert = new Student();
			studentInsert.setName("Rogério");
			studentInsert.setDeptName("Departamento Comp");
			studentInsert.setTotalCredit(18000.0);

			crudStudent.create(studentInsert);

			// DELETE
			crudStudent.delete(1);

			// UPDATE
			Student studentUpdate = new Student();
			studentUpdate.setIdStudent(2);
			studentUpdate.setName("Joao");
			studentUpdate.setDeptName("Departamento Psico");
			studentUpdate.setTotalCredit(300.0);

			crudStudent.update(studentInsert);

			// Select by id
			Student student = crudStudent.getById(1);
			System.out.println(student.getName());

			ArrayList<Student> students = crudStudent.listAll();
			for (Student s : students) {
				System.out.println(s.getName());
			}
			System.out.println(crudStudent.close());

			// COURSE

			AbstractCRUD<Course> crudCourse;
			// ...
			crudCourse = new CRUDStudent<Course>();

			System.out.println(crudCourse.open());
			// INSERT
			Course courseInsert = new Course();
			courseInsert.setTitle("Rogério");
			courseInsert.setDeptName("Departamento Comp");
			courseInsert.setCredit(180.0);

			crudCourse.create(courseInsert);

			// DELETE
			crudCourse.delete(1);

			// UPDATE
			Course courseUpdate = new Course();
			courseUpdate.setIdCourse(2);
			courseUpdate.setTitle("CC");
			courseUpdate.setDeptName("Departamento Psico");
			courseUpdate.setCredit(280.0);

			crudCourse.update(courseUpdate);

			// Select by id
			Course course= crudCourse.getById(1);
			System.out.println(course.getTitle());

			ArrayList<Course> courses = crudCourse.listAll();
			for (Course c : courses) {
				System.out.println(c.getTitle());
			}
			System.out.println(crudStudent.close());

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
