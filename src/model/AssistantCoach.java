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
				this.assistantExpertise = Expertise.defensive;
			break;
			
			case 3:
				this.assistantExpertise = Expertise.possession;
			break;
			
			case 4:
				this.assistantExpertise = Expertise.labPlays;
			break;
			
			default:
			
		}
	}

	public boolean getWasPlayer() {
		return wasPlayer;
	}
	
	public void setWasPlayer(boolean wasPlayer){
		this.wasPlayer = wasPlayer;
	}

	public Expertise getExpertise() {
		return assistantExpertise;
	}
	
	public void setExpertise(int assistantExpertise){
		switch(assistantExpertise){
			case 1:
				this.assistantExpertise = Expertise.ofensive;
			break;
			
			case 2:
				this.assistantExpertise = Expertise.defensive;
			break;
			
			case 3:
				this.assistantExpertise = Expertise.possession;
			break;
			
			case 4:
				this.assistantExpertise = Expertise.labPlays;
			break;
			
			default:
		}
	}
	
	private String getStringExpertise(){
		String msg = "";
		switch(assistantExpertise){
			case ofensive:
				msg = "Ofensivo";
			break;
			
			case defensive:
				msg = "Defensivo";
			break;
			
			case possession:
				msg = "Posesion";
			break;
			
			case labPlays:
				msg = "Jugadas de laboratorio";
			break;
			
			default:
			 msg = "U screwed something xd";
		}
		return msg;
	}
	
	@Override
	public String showInfo(){
		String msg = "Asistente tecnico.\n"+super.showInfo();
		msg += (getWasPlayer()?"Fue un jugador" : "No fue un jugador") + "\n" +
		"Experticia: " + getStringExpertise() + "\n";
		return msg;
	}
}