package taskManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskDAO {
	private static String url="jdbc:postgresql://localhost:5432/"
			+ "school?user=postgres&password=123";
	private static Connection connection;
	
	
	static {
		try {
			connection=DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void addTask(Scanner sc) {
		LocalDate date=LocalDate.now();
		// Convert it to a java.sql.Date object
		Date sqlDate = Date.valueOf(date);
		try {
			String sql="insert into tasks values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			System.out.println("Set Id: ");
			preparedStatement.setInt(1, sc.nextInt());
			sc.nextLine();
			System.out.println("Set Title: ");
			preparedStatement.setString(2,sc.nextLine() );
			System.out.println("Set Description : ");
			preparedStatement.setString(3, sc.nextLine());
			//System.out.println("Set Date: ");
			preparedStatement.setDate(4, sqlDate);
			System.out.println("Set Priority: ");
			preparedStatement.setString(5, sc.nextLine());
			System.out.println("Set Status: ");
			preparedStatement.setString(6, sc.nextLine());
			int res =preparedStatement.executeUpdate();
			if(res!=0)
				System.out.println("Task added");
			else
			System.out.println("Task not added");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	public static void getAllTasks() {
		try{
			String sql="select * from tasks";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				System.out.println("||---------------------------------------"
						+ "-------------------------------------------------------------------------------||");
				  System.out.println("\t" + rs.getInt(1)         // id
                  + "  |  " + rs.getString(2)       // title
                  + "  |  " + rs.getString(3)       // description
                  + "  |  " + rs.getDate(4)         // due_date
                  + "  |  " + rs.getString(5)       // priority
                  + "  |  " + rs.getString(6));      // status
      }
		

			System.out.println("||-------------------------------------------------------------------------------------"
					+ "---------------------------------||");
			}
			
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public static void updateTask(Scanner sc) {
		try {
		PreparedStatement preparedStatement=null;
		String sql="";
		int res=0;
		System.out.println("1. Update Title"+"\n2. Update status"
		+"\n3. Update priority"+"\n4. Update description"+"\nEnter your choice");
		int key=sc.nextInt();
		switch (key) {
		case 1:
			 sql ="update tasks set title=? where id=?";
			
				preparedStatement=connection.prepareStatement(sql);
				sc.nextLine();
				System.out.println("Set new title: ");
			preparedStatement.setString(1, sc.nextLine());
			System.out.println("Enter id: ");
			preparedStatement.setInt(2, sc.nextInt());
			res=preparedStatement.executeUpdate();
			break;
		case 2:
			 sql ="update tasks set status=? where id=?";
			
			preparedStatement=connection.prepareStatement(sql);
			sc.nextLine();
			System.out.println("Change staus(pending/completed): ");
			preparedStatement.setString(1, sc.nextLine());
			System.out.println("Enter id: ");
			preparedStatement.setInt(2, sc.nextInt());
			res=preparedStatement.executeUpdate();
			break;
		case 3:
			sql ="update tasks set priority=? where id=?";
			
			preparedStatement=connection.prepareStatement(sql);
			sc.nextLine();
			System.out.println("change priority(high/mid/low): ");
			preparedStatement.setString(1, sc.nextLine());
			System.out.println("Enter id: ");
			preparedStatement.setInt(2, sc.nextInt());
			res=preparedStatement.executeUpdate();
			break;
		case 4:
			sql ="update tasks set descp=? where id=?";
			
			preparedStatement=connection.prepareStatement(sql);
			System.out.println("Change Description : ");
			sc.nextLine();
			preparedStatement.setString(1, sc.nextLine());
			System.out.println("Enter id: ");
			preparedStatement.setInt(2, sc.nextInt());
			res=preparedStatement.executeUpdate();
			break;

		default:
			System.out.println("Invalid input");
			break;
		}
		if(res!=0)
			System.out.println("task is updated");
		else
			System.out.println("task not Updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public static void deleteTaskById(Scanner sc) {
		try{
				String sql ="DELETE FROM tasks where id=?";
				PreparedStatement pstm=connection.prepareStatement(sql);
				System.out.println("Enter product Id to delete : ");
				pstm.setInt(1, sc.nextInt());
				
				int res=pstm.executeUpdate();
				if(res!=0)
					System.out.println("Product is deleted :)");
				else
					System.out.println("Product  not deleted ");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	public static void getTasksByPriority(Scanner sc) {
		
			try{
				String sql="select * from tasks where priority=?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				System.out.println("Enter Priority: high or mid or low");
				sc.nextLine();
				String p =sc.nextLine().toLowerCase();
				preparedStatement.setString(1,p);
				ResultSet rs=preparedStatement.executeQuery();
				
				while(rs.next()) {
					System.out.println("||---------------------------------------"
							+ "-------------------------------------------------------------------------------||");
					  System.out.println("\t" + rs.getInt(1)         // id
	                  + "  |  " + rs.getString(2)       // title
	                  + "  |  " + rs.getString(3)       // description
	                  + "  |  " + rs.getDate(4)         // due_date
	                  + "  |  " + rs.getString(5)       // priority
	                  + "  |  " + rs.getString(6));      // status
	      }
			

				System.out.println("||-------------------------------------------------------------------------------------"
						+ "---------------------------------||");
				}
				
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void exit() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
