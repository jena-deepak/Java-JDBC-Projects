package school_management.driver;

import java.util.List;
import java.util.Scanner;

import school_management.entity.Parent;
import school_management.service.ParentService;


public class ParentDriver {

	public static void main(String[] args) {
		ParentService ptService =new ParentService();
		System.out.println("Welcome to  School Management System ⚆_⚆ ");
		boolean flag = true;
		while (flag) {
			System.out
					.println("1. Insert Parent details" + "\n2. Update Parents details" + "\n3.View parents" + " details"

							+ "\n4.Delete details" + "\n5.Exit" + "\nEnter Your Choice : ");

			Scanner sc = new Scanner(System.in);
			int inp = sc.nextInt();
			switch (inp) {
			case 1:
				System.out.println("Enter parent id: ");
				int id = sc.nextInt();
				System.out.println("Enter parent name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter child name: ");
				String childName = sc.nextLine();
				Parent parent = new Parent();
				parent.setParent_id(id);
				parent.setParent_name(name);
				parent.setChild_name(childName);
			     int res = ptService.save(parent);
				
				//int res = stService.save(student);
				if (res != 0)
					System.out.println("student data saved");

				else
					System.out.println("student not saved");

				break;
			case 2:
				System.out.println("enter id want to update:");
				int stId1 = sc.nextInt();
				System.out.println("change name :");
				sc.nextLine();
				String ptName = sc.nextLine();
				int res3 =ptService.updateName(ptName, stId1);
				if (res3 != 0)
					System.out.println("parent data updated");

				else
					System.out.println("not updated");

				break;
			case 3:
				List<Parent> list = ptService.fetchAll();
				if (list != null) {
					for (Parent e : list) {
						System.out.println(e);
					}
				} else {
					System.out.println("no data found");
				}

				break;

			case 4:
				System.out.println("enter id want to be deleted:");
				int scid1 = sc.nextInt();
				int res2 = ptService.delete(scid1);
				if (res2 != 0)
					System.out.println("parent deleted");
				else
					System.out.println("not deleted");
				break;

			case 5:
				ptService.exit();
				flag = false;
				break;

			default:
				System.out.println("invalid input");
				break;
			}

		}

	}

}
