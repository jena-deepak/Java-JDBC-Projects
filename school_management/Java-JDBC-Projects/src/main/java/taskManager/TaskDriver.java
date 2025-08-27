package taskManager;

import java.util.Scanner;

public class TaskDriver {

	public static void main(String[] args) {
		try(Scanner scanner=new Scanner(System.in)){
			boolean flag = true;
			System.out.println("||---------  !!!Welcome to Task-Manager!!!  -----------||");
			while(flag) {
				System.out.println("1. Add Task"+"\n2. Get All Tasks"+
						"\n3.Delete Task By Id"+"\n4.Get Tasks by Priority"+"\n5.Update your tasks"+"\n6.Exit"+
								"\nEnter Your Choice : ");
						int inp=scanner.nextInt();
						switch(inp) {
						case 1: TaskDAO.addTask(scanner);
						break;
						case 2: TaskDAO.getAllTasks();
						break;
						case 3:TaskDAO.deleteTaskById(scanner);
						break;
						case 4: TaskDAO.getTasksByPriority(scanner);
						break;
						case 5: TaskDAO.updateTask(scanner);
						break;
						case 6: TaskDAO.exit();
						flag=false;
						break;
						default:
							System.out.println("invalid input");
						}
			}
			
			
		}finally {
			System.out.println("Thanks for using our Application😊😊😊"+"\nHave a good Day❤️");
			}

	}

}
