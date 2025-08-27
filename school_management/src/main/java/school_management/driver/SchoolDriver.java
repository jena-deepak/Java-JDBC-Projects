package school_management.driver;

import java.util.List;
import java.util.Scanner;

import school_management.entity.School;
import school_management.service.SchoolService;

public class SchoolDriver {

	public static void main(String[] args) {
		SchoolService scService = new SchoolService();
		System.out.println("Welcome to  School Management System ⚆_⚆ ");
		boolean flag = true;
		while (flag) {
			System.out
					.println("1. Insert School details" + "\n2. Update school details" + "\n3.View school" + " details"

							+ "\n4.Delete details" + "\n5.Exit" + "\nEnter Your Choice : ");

			Scanner sc = new Scanner(System.in);
			int inp = sc.nextInt();
			switch (inp) {
			case 1:
				System.out.println("Enter school id: ");
				int id = sc.nextInt();
				System.out.println("Enter school name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter school address: ");
				String address = sc.nextLine();
				School school = new School();
				school.setName(name);
				school.setId(id);
				school.setAddress(address);
				int res = scService.save(school);
				if (res != 0)
					System.out.println("School data saved");

				else
					System.out.println("School not saved");

				break;
			case 2:
				System.out.println("enter id want to update:");
				int scid = sc.nextInt();
				System.out.println("change name :");
				sc.nextLine();
				String scname = sc.nextLine();
				int res1 = scService.update(scname, scid);
				if (res1 != 0)
					System.out.println("School data updated");

				else
					System.out.println("not updated");

				break;
			case 3:
				List<School> list = scService.fetchAll();
				if (list != null) {
					for (School e : list) {
						System.out.println(e);
					}
				} else {
					System.out.println("no data found");
				}

				break;

			case 4:
				System.out.println("enter id want to be deleted:");
				int scid1 = sc.nextInt();
				int res2 = scService.delete(scid1);
				if (res2 != 0)
					System.out.println("School deleted");
				else
					System.out.println("not deleted");
				break;

			case 5:
				scService.exit();
				flag = false;
				break;

			default:
				System.out.println("invalid input");
				break;
			}

		}

	}

}
