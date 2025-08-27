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

import school_management.entity.Parent;

public class ParentService {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:postgresql://localhost:5432/" + "schoolmanagement?user=postgres&password=123";
	private static Connection connection;
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
	
	public int save(Parent parent) {
		int res = 0;
		String sql = "insert into parents values(?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, parent.getParent_id());
			pstm.setString(2, parent.getParent_name());
			pstm.setString(3, parent.getChild_name());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}
	public int delete(int id) {
		int res = 0;
		String sql = "delete from parents  where parentId=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public List<Parent> fetchAll() {
		List<Parent> list=new ArrayList<Parent>();
		String sql = "select * from parents";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new Parent(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int updateName(String name, int id) {
		int res = 0;
		String sql = "update parents set parent_name=? where parent_id=?";
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

	
	
	public void exit() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
