package school_management.driver;

import java.util.List;
import java.util.Scanner;
import school_management.entity.Teacher;
import school_management.service.TeacherService;

public class TeacherDriver {
	public static void main(String[] args) {
		TeacherService tService = new TeacherService();
		System.out.println("Welcome to  School Management System ⚆_⚆ ");
		boolean flag = true;
		while (flag) {
			System.out
					.println("1. Insert Teacher details" + "\n2. Update teachers details" + "\n3.View teachers" + " details"

							+ "\n4.Delete details" + "\n5.Exit" + "\nEnter Your Choice : ");

			Scanner sc = new Scanner(System.in);
			int inp = sc.nextInt();
			switch (inp) {
			case 1:
				System.out.println("Enter Teacher id: ");
				int id = sc.nextInt();
				System.out.println("Enter Teacher name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Department name: ");
				String deptName = sc.nextLine();
				System.out.println("Enter Teacher Salary : ");
				double sal=sc.nextLong();
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(id);
				teacher.setTeacher_name(name);
				teacher.setDept_name(deptName);
				teacher.setTeacher_salary(sal);
				
				
			     int res = tService.save(teacher);
				
				if (res != 0)
					System.out.println("teacher data saved");

				else
					System.out.println("teacher not saved");

				break;
			case 2:
				System.out.println("enter id want to update:");
				int stId1 = sc.nextInt();
				System.out.println("change name :");
				sc.nextLine();
				String ptName = sc.nextLine();
				int res3 =tService.updateName(ptName, stId1);
				if (res3 != 0)
					System.out.println("teacher data updated");

				else
					System.out.println("not updated");

				break;
			case 3:
				List<Teacher> list = tService.fetchAll();
				if (list != null) {
					for (Teacher e : list) {
						System.out.println(e);
					}
				} else {
					System.out.println("no data found");
				}

				break;

			case 4:
				System.out.println("enter id want to be deleted:");
				int scid1 = sc.nextInt();
				int res2 = tService.delete(scid1);
				if (res2 != 0)
					System.out.println("Teacher deleted");
				else
					System.out.println("not deleted");
				break;

			case 5:
				tService.exit();
				flag = false;
				break;

			default:
				System.out.println("invalid input");
				break;
			}

		}

	}

}
