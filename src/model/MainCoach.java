package model;
public class MainCoach extends Coach implements FutballStar {

	private int managedTeams;
	private int championships;

	public MainCoach(String name, int ID,int salary,boolean status,int experienceYears,int managedTeams, int championships){
		super(name, ID, salary, status, experienceYears);
		this.managedTeams = managedTeams;
		this.championships = championships;
	}
	
	public int getManagedTeams() {
		return this.managedTeams;
	}
	
	public void setManagedTeams(int managedTeams){
		this.managedTeams = managedTeams;
	}

	public int getChampions() {
		return championships;
	}
	
	public void setChampions(int championships){
		this.championships = championships;
	}
	
	@Override
	public String showInfo(){
		String msg = "Entrenador principal.\n " + super.showInfo();
		msg += "Equipos que ha manejado: " + managedTeams + "\n" +
		"Campeonatos ganados: " + championships + "\n";
		return msg;
	}
	
	/**
	*Calcultaes the price of the main coach<br>
	*<b>pre: </b> The main coach must already be created <br>
	*<b>post: </b> Gives the price of the coach <br>
	*@return the price of the coach
	*/
	@Override
	public int calculatePrice(){
		int price = 0;
		price = (getSalary() * 10) + (getExpYears()*100) + (championships*50);
		return price;
	}
	
	/**
	*Calculates the level of the main coach<br>
	*<b>pre: </b> The coach must already be created <br>
	*<b>post: </b> Gives the level of the coach <br> 
	*@return The level of the coach
	*/
	@Override
	public double calculateLevel(){
		double level = 0;
		level = 5+(championships/10);
		return level;
	}
}