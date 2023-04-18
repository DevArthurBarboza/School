package br.com.ExemploJDBC.controller;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import br.com.ExemploJDBC.model.Course;

public class CRUDCourse<T> extends AbstractCRUD<T>{

	@Override
	public boolean create(T o) throws SQLException {
		Course course = (Course) o;
		String query = "INSERT INTO course (title,dept_name,credit) VALUES (?,?,?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, course.getTitle());
		stmt.setString(2, course.getDeptName());
		stmt.setDouble(3, course.getCredit());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		
		String query = "DELETE FROM course WHERE course_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
		
	}

	@Override
	public boolean update(T o) throws SQLException {
		Course course = (Course) o;
		String query = "UPDATE course "
				+ "SET title = ?, dept_name= ?, credit = ? "
				+ "WHERE course_id = ?";
		
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, course.getTitle());
		stmt.setString(2, course.getDeptName());
		stmt.setDouble(3, course.getCredit());
		stmt.setInt(4, course.getIdCourse());
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public T getById(int id) throws SQLException {
		String query = "SELECT * FROM course WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Course course = new Course();
		course.setIdCourse(result.getInt(1));
		course.setTitle(result.getString(2));
		course.setDeptName(result.getString(3));
		course.setCredit(result.getDouble(4));
		return (T) course;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM course";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Course> courses = new ArrayList<Course>();
		while(result.next()) {
			Course course = new Course();
			course.setIdCourse(result.getInt(1));
			course.setTitle(result.getString(2));
			course.setDeptName(result.getString(3));
			course.setCredit(result.getDouble(4));
			courses.add(course);
		}
		return (ArrayList<T>) courses;
	}

}
