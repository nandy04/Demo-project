package JDBC;

public class JDBC_model {

	Integer id;
	String name;
	Integer parent_id;
	boolean is_folder;
	Integer owner_id;
	
	public JDBC_model(Integer id, String name, Integer parent_id, boolean is_folder, Integer owner_id )
	{
		this.id=id;
		this.name=name;
		this.parent_id=parent_id;
		this.is_folder=is_folder;
		this.owner_id=owner_id;
	}

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

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public boolean isIs_folder() {
		return is_folder;
	}

	public void setIs_folder(boolean is_folder) {
		this.is_folder = is_folder;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	
	
	
	
}
