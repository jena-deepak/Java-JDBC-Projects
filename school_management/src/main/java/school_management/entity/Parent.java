package school_management.entity;

public class Parent {
	private int parent_id;
	private String parent_name;
	private String child_name;
	

	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public Parent() {
		super();
	}
	
	public Parent(int parent_id, String parent_name, String child_name) {
		super();
		this.parent_id = parent_id;
		this.parent_name = parent_name;
		this.child_name = child_name;
	}
	@Override
	public String toString() {
		return " [parentId : " + parent_id + " |  parentName : " + parent_name + " |  childName : " + child_name + "]";
	}
	

}
