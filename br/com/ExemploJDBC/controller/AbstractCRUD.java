package br.com.ExemploJDBC.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractCRUD<T> {
	
	private final String URL = "jdbc:mysql://localhost/CLASSES";
	//jdbc:oracle:thin:@hostname:port Number:databaseName
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	protected Connection connection;

	public boolean open() throws SQLException {
		this.connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
		if(this.connection != null) {
			return true;			
		} 
		return false;
	}
	
	public boolean close() throws SQLException {
		this.connection.close();
		if(this.connection.isClosed()) {
			return true;
		}
		return false;
	}
	
	public abstract boolean create(T o) throws SQLException;
	public abstract boolean delete(int id) throws SQLException;
	public abstract boolean update(T o) throws SQLException;
	public abstract T getById(int id) throws SQLException;
	public abstract ArrayList<T> listAll() throws SQLException;
	
	
}
