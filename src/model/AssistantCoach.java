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

	/**
	*Returns if the assistant was a player<br>
	*<b>pre: </b> The player must be already created <br>
	*<b>post: </b> Returns if the assistant was a player <br>
	*@return if the assistant was a player
	*/
	public boolean getWasPlayer() {
		return wasPlayer;
	}
	
	/**
	*Updates the info of the assistant, change to was a player o wasnt<br>
	*<b>pre: </b> The assistant must be already created <br>
	*<b>post: </b> Changes the info of the assistant <br>
	*@param The new info for the assistant1
	*/
	public void setWasPlayer(boolean wasPlayer){
		this.wasPlayer = wasPlayer;
	}

	/**
	*Gets the expertise of the assistant <br>
	*<b>pre: </b> The assistant must be already created <br>
	*<b>post: </b> Gives the expertise of the assistant <br>
	*@return The expertise of the assistant
	*/
	public Expertise getExpertise() {
		return assistantExpertise;
	}
	
	/**
	*Changes the expertise of the assistant<br>
	*<b>pre: </b> The assistant must be already created <br>
	*<b>post: </b> Changes the assistant expertise <br>
	*@param The new expertise
	*/
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
	
	/**
	*Returns the expertise of the assistant as a String<br>
	*<b>pre: </b> The assistant must already have an expertise <br>
	*<b>post: </b> Gives the ecpertise as a String <br>
	*@return the expertise of the assistant as text
	*/
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
	
	/**
	*Shows the info of the assistant<br>
	*<b>pre: </b> The assistant must already have all of its information <br>
	*<b>post: </b> Gives all the info of the assistant <br>
	*@return the info of the assistant
	*/
	@Override
	public String showInfo(){
		String msg = "Asistente tecnico.\n"+super.showInfo();
		msg += (getWasPlayer()?"Fue un jugador" : "No fue un jugador") + "\n" +
		"Experticia: " + getStringExpertise() + "\n";
		return msg;
	}
}