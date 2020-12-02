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
				if(teamAssistant[i].getName().equalsIgnoreCase(newAssistant.getName())){
					found = true;
				}
			}
		}
		if(found){
			return "El asistente ya esta en el equipo";
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
				if(teamPlayers[i].getName().equalsIgnoreCase(newPlayer.getName())){
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
	
	public String removePlayer(int selected){
		selected--;
		if(teamPlayers[selected] == null){
			return "Ingrese un valor valido";
		}
		else{
			teamPlayers[selected] = null;
			return "Jugador eliminado del equipo";
		}
	}
	
	
	public String updateLineup(String newLineup){
		for(int i=0;i<LINEUP_ROWS;i++){
			for(int j=0;j<LINEUP_COL;i++){
				lineup[i][j] = 0;
			}
		}
		String[] lineupArray = newLineup.split("-");
		int numSpaces = LINEUP_ROWS-lineupArray.length;
		int spaces = (int) lineupArray.length/numSpaces;
		int[] location = new int[1];
		switch(lineupArray.length){
			case 1:
				int[] location1 = {5};
				location = location1;
			break;
			
			case 2:
				int[] location2 = {4,6};
				location = location2;
			break;
			
			case 3:
				int[] location3 = {8,5,2};
				location = location3;
			break;
			
			case 4:
				int[] location4 = {8,6,4,2};
				location = location4;
			break;
			
			case 5:
				int[] location5 = {9,7,5,3,1};
				location = location5;
			break;
			
			case 6:
				int[] location6 = {8,7,5,4,2,1};
				location = location6;
			break;
			
			case 7:
				int[] location7 = {8,7,6,4,3,2,1};
				location = location7;
			break;
			
			case 8:
				int[] location8 = {8,7,6,5,4,3,2,1};
				location = location8;
			break;
			
			case 9:
				int[] location9 = {9,8,7,6,5,4,3,2,1};
				location = location9;
			break;
			
			case 10:
				int[] location10 = {9,8,7,6,5,4,3,2,1,0};
				location = location10;
			break;
			
			default:
				int[] locationA = {1};
		}
		int lineupQuantity = lineupArray.length;
		int lineupNum = 0;
		for(int i = 0; i<lineupQuantity; i++){
			switch(Integer.parseInt(lineupArray[lineupNum])){
				case 1:
					lineup[location[i]][3] = 1;
				break;
				
				case 2:
					lineup[location[i]][4] = 1;
					lineup[location[i]][2] = 1;
				break;
				
				case 3:
					lineup[location[i]][1] = 1;
					lineup[location[i]][3] = 1;
					lineup[location[i]][5] = 1;
				break;
				
				case 4:
					lineup[location[i]][1] = 1;
					lineup[location[i]][2] = 1;
					lineup[location[i]][4] = 1;
					lineup[location[i]][5] = 1;
				break;
				
				case 5:
					lineup[location[i]][1] = 1;
					lineup[location[i]][2] = 1;
					lineup[location[i]][3] = 1;
					lineup[location[i]][4] = 1;
					lineup[location[i]][4] = 1;
				break;
				default:
			}
			lineupNum++;
		}
		String msg = "Nueva alineacion: \n";
		for(int i=0; i<LINEUP_ROWS;i++){
			msg += "\n";
			for(int j=0; i<LINEUP_COL; i++){
				msg += lineup[i][j];
			}
		}
		return msg;
	}
	
	
	
	
	
	public String showInfo(){
		String msg = "";
		msg += "Nombre del equipo: " + name + "\n" +
		"Entrenador del equipo: " + teamCoach.getName() + "\n" +
		"Asistentes del equipo: " + getAssistantString() + "\n" +
		"Jugadores del equipo: " + getPlayersString() + "\n" +
		"Alineacion: " + getLineUpString() + "\n";
		return msg;
	}
	
	public MainCoach getCoach() {
		return teamCoach;
	}

	public AssistantCoach[] getAssistants() {
		return teamAssistant;
	}
	
	private String getAssistantString(){
		String msg = "";
		if(teamAssistant[0] != null){
			msg += teamAssistant[0].getName() + " ";
		}
		if(teamAssistant[1] != null){
			msg += teamAssistant[1].getName() + " ";
		}
		if(teamAssistant[2] != null){
			msg += teamAssistant[2].getName() + " ";
		}
		return msg;
	}
	
	private String getPlayersString(){
		String msg = "";
		int num = 1;
		for(int i=0;i<MAX_PLAYERS;i++){
			if(teamPlayers[i] != null){
				msg += num + ". " + teamPlayers[i].getName() + " ";
				num++;
			}
		}
		if(msg.equals("")){
			msg = "No hay jugadores en el equipo";
		}
		return msg;
	}
	
	private String getLineUpString(){
		ArrayList<Integer> lineupString = new ArrayList<Integer>();
		int num =0;
		for(int i=0;i<LINEUP_ROWS;i++){
			num = 0;
			for(int j=0;j<LINEUP_COL;i++){
				if(lineup[i][j] == 1){
					num++;
				}
				if(j==6){
					lineupString.add(num);
				}
			}
		}
		String stringLineup = "";
		for(int i=0;i<lineupString.size();i++){
			if(i== lineupString.size()-1){
				stringLineup += lineupString.get(i);
			}
			else{
				stringLineup += lineupString.get(i) + "-";
			}
		}
		return stringLineup;
	}
	
	public String showLineUp(){
		String msg = "";
		for(int i = 0;i<LINEUP_ROWS;i++){
			msg += "\n";
			for(int j=0;j<LINEUP_COL;i++){
				if(lineup[i][j] == 1){
					msg += 1;
				}
				else{
					msg += 0;
				}
			}
		}
		return msg;
	}

	public Player[] getTeamPlayers() {
		return teamPlayers;
	}
	
	public boolean playerIsInTeam(Player checkPlayer){
		boolean found = false;
		for(int i=0; i<MAX_PLAYERS && !found; i++){
			if(teamPlayers[i] != null){
				if(teamPlayers[i] == checkPlayer){
					found = true;
				}
			}
		}
		return found;
	}

}