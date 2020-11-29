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
	
	@Override
	public int calculatePrice(){
		int price = 0;
		price = (getSalary() * 10) + (getExpYears()*100) + (championships*50);
		return price;
	}
	
	@Override
	public double calculateLevel(){
		double level = 0;
		level = 5+(championships/10);
		return level;
	}
}