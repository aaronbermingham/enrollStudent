
public class Student {
	private String name, address;
	private boolean database,java,acct;
	
	public Student(String name, String address, boolean database, boolean java, boolean acct) {
		this.name = name;
		this.address = address;
		this.database = database;
		this.java = java;
		this.acct = acct;
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

	public boolean isDatabase() {
		return database;
	}

	public void setDatabase(boolean database) {
		this.database = database;
	}

	public boolean isJava() {
		return java;
	}

	public void setJava(boolean java) {
		this.java = java;
	}

	public boolean isAcct() {
		return acct;
	}

	public void setAcct(boolean acct) {
		this.acct = acct;
	}


	@Override
	public String toString() {
		return  this.name + ", " + this.address +"\n";
	}

	
	

	
	

}
