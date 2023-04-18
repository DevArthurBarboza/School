package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Student;

public class CRUDStudent<T> extends AbstractCRUD<T> {


	@Override
	public boolean create(T o) throws SQLException {
		Student student = (Student) o;
		String query = 
				"INSERT INTO student (name, dept_name, total_credit) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getDeptName());
		stmt.setDouble(3, student.getTotalCredit());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		String query = "DELETE FROM student WHERE id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public boolean update(T o) throws SQLException {

		Student student = (Student) o;
		String query = "UPDATE student "
				+ "SET name = ?, dept_name = ?, total_credit = ? "
				+ "WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getDeptName());
		stmt.setDouble(3, student.getTotalCredit());
		stmt.setInt(4, student.getIdStudent());
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public T getById(int id) throws SQLException {
		String query = "SELECT * FROM student WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Student student = new Student();
		student.setIdStudent(result.getInt(1));
		student.setName(result.getString(2));
		student.setDeptName(result.getString(3));
		student.setTotalCredit(result.getDouble(4));
		return (T) student;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM student";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Student> students = new ArrayList<Student>();
		while(result.next()) {
			Student student = new Student();
			student.setIdStudent(result.getInt(1));
			student.setName(result.getString(2));
			student.setDeptName(result.getString(3));
			student.setTotalCredit(result.getDouble(4));
			students.add(student);
		}
		return (ArrayList<T>) students;
	}

}
