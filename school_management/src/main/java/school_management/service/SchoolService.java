package school_management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import school_management.entity.School;

public class SchoolService {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:postgresql://localhost:5432/" + "schoolmanagement?user=postgres&password=123";
	private static Connection connection;

	public SchoolService() {
		System.out.println(" object created...");
	}

	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url);
			System.out.println("connection estabilshed...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int save(School school) {
		int res = 0;
		String sql = "insert into school values(?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, school.getId());
			pstm.setString(2, school.getName());
			pstm.setString(3, school.getAddress());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	public int update(String name, int id) {
		int res = 0;
		String sql = "update school set name=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public int delete(int id) {
		int res = 0;
		String sql = "delete from school  where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public List<School> fetchAll() {
		List<School> list=new ArrayList<School>();
		String sql = "select * from school";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
//				int id=resultSet.getInt(1);
//				String name=resultSet.getString(2);
//				String address=resultSet.getString(3);
//				School school = new School(id,name,address);
				list.add(new School(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// exit application
	public void exit() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
