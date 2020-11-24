package model;
public class Coach extends Employee {

	private int experienceYears;
	
	public Coach(String name, int ID,int salary,boolean status,int experienceYears){
		super(name, ID, salary, status);
		this.experienceYears = experienceYears;
	}

	public void getExpYears() {
		return experienceYears;
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo();
		msg += "Nombre : " + getName() + "\n" +
		"ID: " + getID() + "\n" +
		"Salario: " + getSalary() + "\n" +
		"Estado: " + getStatus() + "\n" +
		"Anios de experiencia: " + experienceYears + "\n";
		return msg;
	}
}	