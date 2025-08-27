package school_management.entity;

public class School {
	private int id;
	private String name;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public School(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public School() {
	}

	@Override
	public String toString() {
		return "[" + id + "  ||  name : " + name + "  ||  address :" + address + "]" + "\n";
	}

}
