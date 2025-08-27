package school_management.driver;

import java.util.List;
import java.util.Scanner;

import school_management.entity.Student;
import school_management.service.StudentService;

public class StudentDriver {

	public static void main(String[] args) {
		StudentService stService =new StudentService();
		System.out.println("Welcome to  School Management System ⚆_⚆ ");
		boolean flag = true;
		while (flag) {
			System.out
					.println("1. Insert Student details" + "\n2. Update school details" + "\n3.View school" + " details"

							+ "\n4.Delete details" + "\n5.Exit" + "\nEnter Your Choice : ");

			Scanner sc = new Scanner(System.in);
			int inp = sc.nextInt();
			switch (inp) {
			case 1:
				System.out.println("Enter Student id: ");
				int id = sc.nextInt();
				System.out.println("Enter Student name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Student Age: ");
				int age = sc.nextInt();
				Student student = new Student();
				student.setStudentId(id);
				student.setStudentName(name);
				student.setStudentAge(age);
				
				int res = stService.save(student);
				if (res != 0)
					System.out.println("student data saved");

				else
					System.out.println("student not saved");

				break;
			case 2:
				System.out.println("enter id want to update:");
				int stId = sc.nextInt();
				System.out.println("change name :");
				sc.nextLine();
				String stName = sc.nextLine();
				int res1=stService.update(stName, stId);
				if (res1 != 0)
					System.out.println("Student data updated");

				else
					System.out.println("not updated");

				break;
			case 3:
				List<Student> list = stService.fetchAll();
				if (list != null) {
					for (Student e : list) {
						System.out.println(e);
					}
				} else {
					System.out.println("no data found");
				}

				break;

			case 4:
//				System.out.println("enter id want to be deleted:");
//				int scid1 = sc.nextInt();
//				int res2 = stService.delete(scid1);
//				if (res2 != 0)
//					System.out.println("School deleted");
//				else
//					System.out.println("not deleted");
				break;

			case 5:
				stService.exit();
				flag = false;
				break;

			default:
				System.out.println("invalid input");
				break;
			}

		}


	}

}
