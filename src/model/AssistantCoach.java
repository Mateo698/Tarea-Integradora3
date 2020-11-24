package model;
public class AssistantCoach extends Coach {

	private boolean wasPlayer;
	private Expertise assistantExpertise;
	
	public AssistantCoach(String name, int ID,int salary,boolean status,int experienceYears, boolean wasPlayer, int assistantExpertise){
		super(name, ID, salary, status, experienceYears);
		this.wasPlayer = wasPlayer;
		switch(assistantExpertise){
			case 1:
				this.assistantExpertise = Expertise.ofensive;
			break;
			
			case 2:
				Expertise.defensive;
			break;
			
			case 3:
				Expertise.possesion;
			break;
			
			case 4:
				Expertise.labPlays;
			break;
		}
	}

	public boolean getWasPlayer() {
		return wasPlayer
	}

	public Expertise getExpertise() {
		return assistantExpertise;
	}
	
	private String getStringExpertise(){
		switch(assistantExpertise){
			case ofensive:
				return "Ofensivo";
			break;
			
			case defensive:
				return "Defensivo";
			break;
			
			case possesion:
				return "Posesion";
			break;
			
			case labPlays:
				return "Jugadas de laboratorio";
			break;
			
			default:
			"U screwed something xd";
		}
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo();
		msg += (getWasPlayer()?"Fue un jugador" : "No fue un jugador") + "\n" +
		"Experticia: " + getStringExpertise() + "\n";
		return msg;
	}
}