package model;
import java.util.*;
public class Team {

	private String name;
	private int[][] lineup;
	private Player[] teamPlayers;
	private MainCoach teamCoach;
	private AssistantCoach[] teamAssistant;
	
	private final int MAX_ASSISTANTS = 3;
	private final int LINEUP_ROWS = 10;
	private final int LINEUP_COL = 7;
	private final int MAX_PLAYERS = 25;
	
	public Team(String name, int[][] lineup, Player[] teamPlayers, MainCoach teamCoach, AssistantCoach[] teamAssistant){
		this.name = name;
		this.lineup = lineup;
		this.teamPlayers = teamPlayers;
		this.teamCoach = teamCoach;
		this.teamAssistant = teamAssistant;
	}
	
	public Team(String name){
		this.name = name;
		teamPlayers = new Player[MAX_PLAYERS];
		lineup = new int[LINEUP_ROWS][LINEUP_COL];
		teamAssistant = new AssistantCoach[MAX_ASSISTANTS];
		for(int i=0;i<LINEUP_ROWS;i++){
			for(int j=0;j<LINEUP_COL;i++){
				lineup[i][j] = 0;
			}
		}
	}
	
	public String addCoach(MainCoach newCoach){
		if(teamCoach == null){
			teamCoach = newCoach;
			return "El entrenador se agrego correctamente";
		}
		else{
			teamCoach = newCoach;
			return "Se reemplazo el coach exitosamente";
		}
	}
	
	public String addAssistant(AssistantCoach newAssistant){
		boolean added = false;
		boolean found = false;
		for(int i=0; i<MAX_ASSISTANTS && !added;i++){
			if(teamAssistant[i] != null){
				if(teamAssistant[i].getName().equalsIgnoreCase(newAssistant.getName()){
					found = true;
				}
			}
		}
		if(found){
			return "El asistente ya esta en el equipo"
		}
		else{
			for(int i=0;i<MAX_ASSISTANTS && !added;i++){
				if(teamAssistant[i] == null){
					teamAssistant[i] = newAssistant;
					added = true;
				}
			}
			if(added){
				return "El asistente fue agregado correctamente";
			}
			else{
				return "No se pudo agregar el asistente porque se ha llegado a su limite";
			}
		}
		
	}
	
	public String addPlayer(Player newPlayer){
		boolean found = false;
		boolean added = false;
		for(int i=0;i<teamPlayers.length && !found;i++){
			if(teamPlayers[i] != null){
				if(teamPlayers[i].getName().equalsIgnoreCase(newPlayer.getName()){
					found = true;
				}
			}
		}
		if(found){
			return "No se ha podido agregar al equipo porque ya esta en el";
		}
		else{
			for(int i=0;i<MAX_PLAYERS && !added;i++){
				if(teamPlayers[i] == null){
					teamPlayers[i] = newPlayer;
					added = true;
				}
			}
			if(added){
				return "El jugador fue agregado correctamente";
			}
			else{
				return "No se pudo agregar el jugador porque el equipo esta lleno";
			}
		}
	}
	
	public String updateLineup(String newLineup){
		int num1, num2, num3;
		lineupArray = newLineup.split("-");
		lineupNum = 0;
		for(int i = 8; i>1; i-=3){
			switch(Integer.parseInt(lineupArray[lineupNum])){
				case 1:
					lineup[i][3] = 1;
				break;
				
				case 2:
					lineup[i][4] = 1;
					lineup[i][2] = 1;
				break;
				
				case 3:
					lineup[i][1] = 1;
					lineup[i][3] = 1;
					lineup[i][5] = 1;
				break;
				
				case 4:
					lineup[i][1] = 1;
					lineup[i][2] = 1;
					lineup[i][4] = 1;
					lineup[i][5] = 1;
				break;
				
				case 5:
					lineup[i][1] = 1;
					lineup[i][2] = 1;
					lineup[i][3] = 1;
					lineup[i][4] = 1;
					lineup[i][4] = 1;
				break;
				default:
			}
			lineupNum++;
		}
		String msg = "";
		for(int i=0; i<LINEUP_ROWS;i++){
			msg += "\n";
			for(int j=0; i<LINEUP_COL; i++){
				msg += lineup[i][j];
			}
		}
		return msg;
	}
	
	
	
	public String showInfo(){
		
	}
	
	public MainCoach getCoach() {
		return teamCoach;
	}

	public AssistantCoach[] getAssistants() {
		return teamAssistant;
	}

	public Player[] getTeamPlayers() {
		return teamPlayers;
	}

}