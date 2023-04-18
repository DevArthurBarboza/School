package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Department;

public class CRUDDepartment<T> extends AbstractCRUD<T> {
	
	@Override
	public boolean create(T o) throws SQLException {
		Department dep = (Department) o;
		String query = 
				"INSERT INTO department (dept_name, building, budget) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, dep.getNameDepartment());
		stmt.setString(2, dep.getBuildingDepartment());
		stmt.setDouble(3, dep.getBudgetDepartment());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM department WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public boolean update(T o) throws SQLException {
		Department dep = (Department) o;
		String query = "UPDATE department "
				+ "SET dept_name = ?, building = ?, budget = ? "
				+ "WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, dep.getNameDepartment());
		stmt.setString(2, dep.getBuildingDepartment());
		stmt.setDouble(3, dep.getBudgetDepartment());
		stmt.setInt(4, dep.getIdDepartment());
		int rows = stmt.executeUpdate();
		return rows > 0;
		
	}

	@Override
	public T getById(int id) throws SQLException {
		
		String query = "SELECT * FROM department WHERE dept_id = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Department dep = new Department();
		dep.setIdDepartment(result.getInt(1));
		dep.setNameDepartment(result.getString(2));
		dep.setBuildingDepartment(result.getString(3));
		dep.setBudgetDepartment(result.getDouble(4));
		return (T) dep;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM department";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Department> departments = new ArrayList<Department>();
		while(result.next()) {
			Department dep = new Department();
			dep.setIdDepartment(result.getInt(1));
			dep.setNameDepartment(result.getString(2));
			dep.setBuildingDepartment(result.getString(3));
			dep.setBudgetDepartment(result.getDouble(4));
			departments.add(dep);
		}
		return (ArrayList<T>) departments;
	}

}
