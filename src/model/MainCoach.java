package model;
public class MainCoach extends Coach {

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

	public int getChampions() {
		return championships;
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo();
		msg += "Equipos que ha manejado: " + managedTeams + "\n" +
		"Campeonatos ganados: " + championships + "\n";
		return msg;
	}
}