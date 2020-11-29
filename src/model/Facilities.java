package model;
public class Facilities {
	
	private Player[][] dresserRoom1;
	private Player[][] dresserRoom2;
	private Coach[][] office;

	private final int DRESSER_ROWS = 7;
	private final int DRESSER_COL1 = 6;
	private final int DRESSER_COL2 = 7;
	
	private final int OFFICE_ROWS = 6;
	private final int OFFICE_COL = 6;

	public Facilities(){
		dresserRoom1 = new Player[DRESSER_ROWS][DRESSER_COL1];
		dresserRoom2 = new Player[DRESSER_ROWS][DRESSER_COL2];
		office = new Coach[OFFICE_ROWS][OFFICE_COL];
	}
	
	public String setPlayer(int selected, Player newPlayer, Team[] clubTeams){
		boolean found = false;
		int numPlayers = 0;
		boolean added = false;
		if(selected == 1){
			for(int i=0;i<DRESSER_ROWS && !found;i++){
				for(int j=0;j<DRESSER_COL1;i++){
					if(dresserRoom1[i][j] != null){
						numPlayers++;
						if(dresserRoom1[i][j] == newPlayer){
							found = true;
						}
					}
				}
			}
		}
		else{
			for(int i=0;i<DRESSER_ROWS && !found;i++){
				for(int j=0;j<DRESSER_COL2;i++){
					if(dresserRoom1[i][j] != null){
						numPlayers++;
						if(dresserRoom2[i][j] == newPlayer){
							found = true;
						}
					}
				}
			}
		}
		if(found){
			return "No se pudo agregar porque el jugador ya se encuentra en los vestidores";
		}
		else{
			selected--;
			if(clubTeams[selected].playerIsInTeam(newPlayer)){
				selected++;
				if(selected == 1){
					for(int i=0;i<DRESSER_ROWS && !added;i++){
						for(int j=0;j<DRESSER_COL1;i++){
							if(dresserRoom1[i][j] == null){
								if(dresserRoom1[i][j+1] == null){
									if(dresserRoom1[i+1][j] == null){
										if(dresserRoom1[i+1][j+1] == null){
											dresserRoom1[i][j] = newPlayer;
											added = true;
										}
									}
								}
							}
						}
					}
				}
				else{
					for(int i=0;i<DRESSER_ROWS && !added;i++){
						for(int j=0;j<DRESSER_COL2;i++){
							if(dresserRoom2[i][j] == null){
								if(dresserRoom2[i][j+1] == null){
									if(dresserRoom2[i+1][j] == null){
										if(dresserRoom2[i+1][j+1] == null){
											dresserRoom2[i][j] = newPlayer;
											added = true;
										}
									}
								}
							}
						}
					}
				}
				if(added){
					return "El jugador se agrego al camerino exitosamente";
				}
				else{
					return "El jugador no se pudo agregar al camerino";
				}
			}
			else{
				return "El jugador no pertenece al equipo, por lo que no se puede agregar a este camerino";
			}
		}
	}
	
	//Coach
	public String findCoach(MainCoach coach){
		String msg = "Ubicacion del asistente: \n";
		boolean found = false;
		for(int = 0; i<OFFICE_ROWS;i++){
			msg += "\n";
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == coach){
						msg += 1;
						found = true;
					}
				}
				else{
					msg += 0;
				}
			}
		}
		if(!found){
			return "El entrenador no se encuentra en las oficinas";
		}
		else{
			return msg;
		}
	}
	
	//Assistant
	public String findAsistant(AssistantCoach assistant){
		String msg = "Ubicacion del jugador: \n";
		boolean found = false;
		for(int = 0; i<OFFICE_ROWS;i++){
			msg += "\n";
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == assistant){
						msg += 1;
						found = true;
					}
				}
				else{
					msg += 0;
				}
			}
		}
		if(!found){
			return "El asistente no se encuentra en las oficinas";
		}
		else{
			return msg;
		}
	}
	
	//Player
	public String findPlayer(Player player, int selectedDresser){
		String msg = "";
		boolean found = false;
		if(selectedDresser == 1){
			for(int = 0; i<DRESSER_ROWS;i++){
				msg += "\n";
				for(int j=0;j<DRESSER_COL1;i++){
					if(office[i][j] != null){
						if(office[i][j] == assistant){
							msg += 1;
							found = true;
						}
					}
					else{
						msg += 0;
					}
				}
			}
		}
		else{
			for(int = 0; i<DRESSER_ROWS;i++){
				msg += "\n";
				for(int j=0;j<DRESSER_COL2;i++){
					if(office[i][j] != null){
						if(office[i][j] == assistant){
							msg += 1;
							found = true;
						}
					}
					else{
						msg += 0;
					}
				}
			}
		}
		if(!found){
			return "No se encontro al jugador en el vestidor";
		}
		else{
			return msg;
		}
	}
	
	public Player[][] getDresser1() {
		return dresserRoom1;
	}

	public Player[][] getDresser2() {
		return dresserRoom2;
	}

	public Coach[][] getOffice() {
		return office;
	}

}