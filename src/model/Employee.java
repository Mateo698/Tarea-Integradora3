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

	public string getName() {
		return this.name;
	}

	public int getID() {
		return ID;
	}

	public int getSalary() {
		return this.salary;
	}

	public boolean getStatus() {
		return this.status;
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