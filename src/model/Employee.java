package model;
public class Employee {

	private String name;
	private int ID;
	private int salary;
	private boolean status;
	
	public Employee(String name, int ID, int salary, boolean status){
		this.name = name;
		this.ID = ID;
		this.salary = salary;
		this.status = status;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}

	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}

	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public String showInfo(){
		String msg = "";
		msg = "Nombre : " + getName() + "\n" +
		"ID: " + getID() + "\n" +
		"Salario: " + getSalary() + "\n" +
		"Estado: " + getStatus() + "\n";
		return msg;
	}
}