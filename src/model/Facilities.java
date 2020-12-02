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
	
	public String setCoach(MainCoach newCoach){
		Coach c = (Coach) newCoach;
		boolean found = false;
		boolean added = false;
		for(int i=0;i<OFFICE_ROWS && !found;i++){
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == newCoach){
						found = true;
					}
				}
			}
		}
		if(found){
			return "El entrenador ya esta en la oficina";
		}
		else{
			for(int i=0;i<OFFICE_ROWS && !found;i++){
				for(int j=0;j<OFFICE_COL;i++){
					if(office[i][j] == null){
						if(i==0){
							if(j==0){
								office[i][j] = c;
								added = true;
							}
							if(j==5){	
							}
							else{
								if(office[i+1][j] == null){
									if(office[i][j+1] == null){
										if(office[i][j-1] == null){
											if(office[i+1][j+1] == null){
												if(office[i+1][j-1] == null){					
													office[i][j] = c;
													added = true;			
												}
											}
										}
									}
								}
							}
						}
						else if(i==5){
							
						}							
						else{
							if(j==0){
								if(office[i-1][j] == null){
									if(office[i+1][j] == null){
										if(office[i][j+1] == null){
											if(office[i+1][j+1] == null){
												if(office[i-1][j+1] == null){
													office[i][j] = c;
													added = true;
												}
											}
										}
									}
								}
							}
							else if(j==5){		
							}
							else{
								if(office[i-1][j] == null){
									if(office[i+1][j] == null){
										if(office[i][j+1] == null){
											if(office[i][j-1] == null){
												if(office[i+1][j+1] == null){
													if(office[i+1][j-1] == null){
														if(office[i-1][j+1] == null){
															if(office[i-1][j-1] == null){
																office[i][j] = c;
																added = true;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if(added){
				return "Agregado correctamente";
			}
			else{
				return "No se pudo agregar";
			}
		}
	}	
	
	public String setAssistant(AssistantCoach newAssistant){
		Coach c = (Coach) newAssistant;
		boolean found = false;
		boolean added = false;
		for(int i=0;i<OFFICE_ROWS && !found;i++){
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == newAssistant){
						found = true;
					}
				}
			}
		}
		if(found){
			return "El asistente ya esta en la oficina";
		}
		else{
			for(int i=0;i<OFFICE_ROWS && !found;i++){
				for(int j=0;j<OFFICE_COL;i++){
					if(office[i][j] == null){
						if(i==0){
							if(j==0){
								office[i][j] = c;
								added = true;
							}
							if(j==5){	
							}
							else{
								if(office[i+1][j] == null){
									if(office[i][j+1] == null){
										if(office[i][j-1] == null){
											if(office[i+1][j+1] == null){
												if(office[i+1][j-1] == null){					
													office[i][j] = c;
													added = true;			
												}
											}
										}
									}
								}
							}
						}
						else if(i==5){
							
						}							
						else{
							if(j==0){
								if(office[i-1][j] == null){
									if(office[i+1][j] == null){
										if(office[i][j+1] == null){
											if(office[i+1][j+1] == null){
												if(office[i-1][j+1] == null){
													office[i][j] = c;
													added = true;
												}
											}
										}
									}
								}
							}
							else if(j==5){		
							}
							else{
								if(office[i-1][j] == null){
									if(office[i+1][j] == null){
										if(office[i][j+1] == null){
											if(office[i][j-1] == null){
												if(office[i+1][j+1] == null){
													if(office[i+1][j-1] == null){
														if(office[i-1][j+1] == null){
															if(office[i-1][j-1] == null){
																office[i][j] = c;
																added = true;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if(added){
				return "Agregado correctamente";
			}
			else{
				return "No se pudo agregar correctamente";
			}
		}
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
						for(int j=0;j<DRESSER_COL1 && !added;i++){
							if(dresserRoom1[i][j] == null){
								if(i==0){
									if(j==0){
										dresserRoom1[i][j] = newPlayer;
										added = true;
									}
									if(j==5){
										
									}
									else{
										if(dresserRoom1[i+1][j] == null){
											if(dresserRoom1[i][j+1] == null){
												if(dresserRoom1[i][j-1] == null){
													if(dresserRoom1[i+1][j+1] == null){
														if(dresserRoom1[i+1][j-1] == null){					
															dresserRoom1[i][j] = newPlayer;
															added = true;			
														}
													}
												}
											}
										}
									}
								}
								else if(i==6){
									if(j==0){
										dresserRoom1[i][j] = newPlayer;
										added = true;
									}
									else if(j==5){
										
									}
									else{
										if(dresserRoom1[i-1][j] == null){
											if(dresserRoom1[i][j+1] == null){
												if(dresserRoom1[i][j-1] == null){	
													if(dresserRoom1[i-1][j+1] == null){
														if(dresserRoom1[i-1][j-1] == null){
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
									if(j==0){
										if(dresserRoom1[i-1][j] == null){
											if(dresserRoom1[i+1][j] == null){
												if(dresserRoom1[i][j+1] == null){
													if(dresserRoom1[i+1][j+1] == null){
														if(dresserRoom1[i-1][j+1] == null){
															dresserRoom1[i][j] = newPlayer;
															added = true;
														}
													}
												}
											}
										}
									}
									else if(j==5){
										
									}
									else{
										if(dresserRoom1[i-1][j] == null){
											if(dresserRoom1[i+1][j] == null){
												if(dresserRoom1[i][j+1] == null){
													if(dresserRoom1[i][j-1] == null){
														if(dresserRoom1[i+1][j+1] == null){
															if(dresserRoom1[i+1][j-1] == null){
																if(dresserRoom1[i-1][j+1] == null){
																	if(dresserRoom1[i-1][j-1] == null){
																		dresserRoom1[i][j] = newPlayer;
																		added = true;
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else{
					for(int i=0;i<DRESSER_ROWS && !added;i++){
						for(int j=0;j<DRESSER_COL2 && !added;i++){
							if(dresserRoom2[i][j] == null){
								if(i==0){
									if(j==0){
										dresserRoom2[i][j] = newPlayer;
										added = true;
									}
									if(j==6){
										dresserRoom2[i][j] = newPlayer;
										added = true;
									}
									else{
										if(dresserRoom2[i+1][j] == null){
											if(dresserRoom2[i][j+1] == null){
												if(dresserRoom2[i][j-1] == null){
													if(dresserRoom2[i+1][j+1] == null){
														if(dresserRoom2[i+1][j-1] == null){					
															dresserRoom2[i][j] = newPlayer;
															added = true;			
														}
													}
												}
											}
										}
									}
								}
								else if(i==6){
									if(j==0){
										dresserRoom2[i][j] = newPlayer;
										added = true;
									}
									else if(j==6){
										dresserRoom2[i][j] = newPlayer;
										added = true;
									}
									else{
										if(dresserRoom2[i-1][j] == null){
											if(dresserRoom2[i][j+1] == null){
												if(dresserRoom2[i][j-1] == null){	
													if(dresserRoom2[i-1][j+1] == null){
														if(dresserRoom2[i-1][j-1] == null){
															dresserRoom2[i][j] = newPlayer;
															added = true;
														}
													}
												}
											}	
										}
									}
									
								}
								else{
									if(j==0){
										if(dresserRoom2[i-1][j] == null){
											if(dresserRoom2[i+1][j] == null){
												if(dresserRoom2[i][j+1] == null){
													if(dresserRoom2[i+1][j+1] == null){
														if(dresserRoom2[i-1][j+1] == null){
															dresserRoom2[i][j] = newPlayer;
															added = true;
														}
													}
												}
											}
										}
									}
									else if(j==6){
										if(dresserRoom2[i-1][j] == null){
											if(dresserRoom2[i+1][j] == null){
												if(dresserRoom2[i][j-1] == null){
													if(dresserRoom2[i+1][j-1] == null){
														if(dresserRoom2[i-1][j-1] == null){
															dresserRoom2[i][j] = newPlayer;
															added = true;
														}
													}										
												}
											}
										}
									}
									else{
										if(dresserRoom2[i-1][j] == null){
											if(dresserRoom2[i+1][j] == null){
												if(dresserRoom2[i][j+1] == null){
													if(dresserRoom2[i][j-1] == null){
														if(dresserRoom2[i+1][j+1] == null){
															if(dresserRoom2[i+1][j-1] == null){
																if(dresserRoom2[i-1][j+1] == null){
																	if(dresserRoom2[i-1][j-1] == null){
																		dresserRoom2[i][j] = newPlayer;
																		added = true;
																	}
																}
															}
														}
													}
												}
											}
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
		Coach c = (Coach) coach;
		String msg = "Ubicacion del asistente: \n";
		boolean found = false;
		for(int i = 0; i<OFFICE_ROWS;i++){
			msg += "\n";
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == c){
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
	public String findAsistant(AssistantCoach pAssistant){
		Coach c = (Coach) pAssistant;
		String msg = "Ubicacion del jugador: \n";
		boolean found = false;
		for(int i = 0; i<OFFICE_ROWS;i++){
			msg += "\n";
			for(int j=0;j<OFFICE_COL;i++){
				if(office[i][j] != null){
					if(office[i][j] == c){
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
			for(int i = 0; i<DRESSER_ROWS;i++){
				msg += "\n";
				for(int j=0;j<DRESSER_COL1;i++){
					if(dresserRoom1[i][j] != null){
						if(dresserRoom1[i][j] == player){
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
			for(int i = 0; i<DRESSER_ROWS;i++){
				msg += "\n";
				for(int j=0;j<DRESSER_COL2;i++){
					if(dresserRoom2[i][j] != null){
						if(dresserRoom2[i][j] == player){
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