package model;
public class Coach extends Employee {

	private int experienceYears;
	
	
	public Coach(String name, int ID,int salary,boolean status,int experienceYears){
		super(name, ID, salary, status);
		this.experienceYears = experienceYears;
	}
	
	/**
	*Gets the years of experience<br>
	*<b>pre: </b> The coach must already be created(subclass) <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public int getExpYears() {
		return experienceYears;
	}
	
	/**
	*Changes the years of experience of the coach<br>
	*<b>pre: </b> The coach must already be created*(subclass) <br>
	*<b>post: </b>  <br>
	*@param the new experience years
	*/
	public void setExpYears(int experienceYears){
		this.experienceYears = experienceYears;
	}
	
	
	/**
	*Shows all the info of the coach<br>
	*<b>pre: </b> The coach(one of its subclasses) must already be created <br>
	*<b>post: </b> Gives all the information <br>
	*@return the information of the coach
	*/
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