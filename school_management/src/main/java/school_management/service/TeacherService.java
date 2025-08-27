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

import school_management.entity.Teacher;

public class TeacherService {
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
	
	public int save(Teacher teacher) {
		int res = 0;
		String sql = "insert into teachers values(?,?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, teacher.getTeacher_id());
			pstm.setString(2, teacher.getTeacher_name());
			pstm.setString(3, teacher.getDept_name());
			pstm.setDouble(4, teacher.getTeacher_salary());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}
	public int delete(int id) {
		int res = 0;
		String sql = "delete from teachers  where teacher_id=?";
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
	public List<Teacher> fetchAll() {
		List<Teacher> list=new ArrayList<Teacher>();
		String sql = "select * from teachers";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new Teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4)));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int updateName(String name, int id) {
		int res = 0;
		String sql = "update teachers set teacher_name=? where teacher_id=?";
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
