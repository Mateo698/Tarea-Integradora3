package model;
import java.util.*;
public class FutballClub {

	private String name;
	private int NIT;
	private Facilities clubFacilities;
	private ArrayList<Employee> clubEmployees;
	private Date foundationDate;
	private Team[] clubTeams;
	
	private final int MAX_TEAMS = 2;
	
	
	public FutballClub(String name, int NIT,String date){
		this.name = name;
		this.NIT = NIT;
		String[] dates = date.split("/");
		Date foundationDateR = new Date(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
		clubTeams = new Team[MAX_TEAMS];
		clubFacilities = new Facilities();
		clubEmployees = new ArrayList<Employee>();
	}
	
	public FutballClub(String name, int NIT, Facilities clubFacilities, ArrayList<Employee> clubEmployees, Date foundationDate, Team[] clubTeams){
		this.name = name;
		this.NIT = NIT;
		this.foundationDate = foundationDate;
		this.clubEmployees = clubEmployees;
		this.clubTeams = clubTeams;
		this.clubFacilities = clubFacilities;
	}
	
	/**
	*Adds a new Main Coach to the club's employees<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Adds a new Main Coach to the club <br>
	*@param name The employee's name 
	*@param ID the employee's ID
	*@param salary the employee's salary
	*@param status The employee's status
	*@param experience The coach's years
	*@param managedTeams The main coach's number of managed teams
	*@param champions The main coach's number of championships that his teams have won
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int experience, int managedTeams, int champions){
		MainCoach newCoach = new MainCoach(name, ID, salary, status, experience, managedTeams, champions);
		clubEmployees.add(newCoach);
	}
	
	/**
	*Adds a new Assistant Coach to the club's employees<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Adds a new Assistant Coach to the club <br>
	*@param name The employee's name 
	*@param ID the employee's ID
	*@param salary the employee's salary
	*@param status The employee's status
	*@param experience It's the coach's years of experience
	*@param wasPlayer It's the value that says if the assistant was a player or nor
	*@param experience It's the number that indicates the expertise of the assistant
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int experience, boolean wasPlayer, int expertise){
		AssistantCoach newACoach = new AssistantCoach(name,ID,salary,status,experience,wasPlayer,expertise);
		clubEmployees.add(newACoach);
	}
	
	/**
	*Adds a new Player to the club's employees<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Adds a new Player to the club <br>
	*@param name The employee's name 
	*@param ID the employee's ID
	*@param salary the employee's salary
	*@param status The employee's status
	*@param shirtNumber The player's shirt number
	*@param goals The amount of goals made by the player
	*@param grade The average grade of the player
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int shirtNumber, int goals, double grade, int position){
		Player newPlayer = new Player(name,ID,salary,status,shirtNumber,goals,grade,position);
		clubEmployees.add(newPlayer);
	}
	
	/**
	*Addsa new team to the club<br>
	*<b>pre: </b> The club must be created and the name as well <br>
	*<b>post: </b> Adds a new team <br>
	*@param name The team's name
	*@return a message that says if the team was added or not
	*/
	public String newTeam(String name){
		boolean added = false;
		for(int i=0;i<MAX_TEAMS && !added;i++){
			if(clubTeams[i] == null){
				added = true;
				clubTeams[i] = new Team(name);
			}
		}
		if(added){
			return "Nuevo equipo agregado";
		}
		else{
			return "No se pudo agregar el equipo";
		}
	}
	
	/**
	*Fires an employee<br>
	*<b>pre: </b> There must be at least one employee <br>
	*<b>post: </b> The employee was fired <br>
	*@param selected The index of the selected employee to fire
	*@return A message that indicates if it was fired or not
	*/
	public String removeEmployee(int selected){
		selected--;
		if(selected > clubEmployees.size()){
			return "Valor invalido";
		}
		else{
			clubEmployees.remove(selected);
			return "El empleado fue despedido dolorosamente";
		}
	}
	
	/**
	*Calculates all the info of the club<br>
	*<b>pre: </b> The club must have declared all of its attributes <br>
	*<b>post: </b> Shows all the info of the club <br>
	*@return the info of the club
	*/
	public String showAllInfo(){
		String msg = "Nombre del club: " + name + "\n" +
		"NIT: " + NIT + "\n" +
		"Fecha: " + foundationDate.stringDate() + "\n" +
		"Empleados: " + showAllEmployees() + "\n" +
		"Equipos: " + showTeams() + "\n";
		return msg;
	}
	
	/**
	*Show the info of all the employees<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Show all the employee's info <br> 
	*@return the employee's info
	*/
	public String showAllEmployees(){
		int enumeration = 1;
		String msg = "";
		for(int i=0;i<clubEmployees.size();i++){
			msg += enumeration + ". \n" + clubEmployees.get(i).showInfo() + "\n";
			enumeration++;
		}
		return msg;
	}
	
	/**
	*Shows the info of ONE employee<br>
	*<b>pre: </b> There must be at least one employee <br>
	*<b>post: </b> Gives the info of the selected employee <br>
	*@param ID the ID of the employee 
	*@return the info of the employee
	*/
	public String showEmployeeInfo(int ID){
		String msg = "";
		boolean found = false;
		for(int i=0; i<clubEmployees.size() && !found;i++){
			if(clubEmployees.get(i).getID() == ID){
				found = true;
				msg = clubEmployees.get(i).showInfo();
			}
		}
		if(found){
			return msg;
		}
		else{
			return "Empleado no encontrado";
		}
	}
	
	/**
	*Adds an employee to a team<br>
	*<b>pre: </b> There must be at least one team <br>
	*<b>post: </b> Adds an employee to a team <br>
	*@param selectedType Its the kind of employee that will be added to the team 
	*@param employeeSelected Its the index of the selected employee to add
	*@param teamSelected The index of the team.
	*@return 
	*/
	public String addEmployeeToTeam(int selectedType,int employeeSelected,int teamSelected){
		String msg = "";
		employeeSelected--;
		teamSelected--;
		switch(selectedType){
			case 1:
				if(clubEmployees.get(employeeSelected) instanceof MainCoach){
					Employee e = clubEmployees.get(employeeSelected);
					MainCoach m = (MainCoach) e;
					msg = clubTeams[teamSelected].addCoach(m);
				}
				else{
					msg = "Seleccione un empleado apropiado";
				}
			break;
			
			case 2:
				if(clubEmployees.get(employeeSelected) instanceof AssistantCoach){
					Employee e = clubEmployees.get(employeeSelected);
					AssistantCoach a = (AssistantCoach) e;
					msg = clubTeams[teamSelected].addAssistant(a);
				}
				else{
					msg = "Seleccione un empleado apropiado";
				}
			break;
			
			case 3:
				if(clubEmployees.get(employeeSelected) instanceof Player){
					Employee e = clubEmployees.get(employeeSelected);
					Player p = (Player) e;
					msg = clubTeams[teamSelected].addPlayer(p);
				}
				else{
					msg = "Seleccione un empleado apropiado";
				}
			break;
			
			default:
			msg = "Ingrese un valor valido";
		}
		return msg;
	}
	
	/**
	*Shows the info of the teams<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Shows the info of the teams <br>
	*@return the info of the teams
	*/
	public String showTeams(){
		int enumeration = 1;
		String msg = "";
		for(int i=0;i<MAX_TEAMS;i++){
			if(clubTeams[i] != null){
				msg += enumeration + ". \n" + clubTeams[i].showInfo() + "\n";
			}
			enumeration++;
		}
		return msg;
	}
	
	/**
	*Shows the lineup of a selected Team<br>
	*<b>pre: </b> The team must be created <br>
	*<b>post: </b> Shows the lineup of a team <br>
	*@param selected Its the index of the team
	*@return the lineup of the team
	*/
	public String showTeamLineUp(int selectedTeam){
		selectedTeam--;
		String msg = clubTeams[selectedTeam].showLineUp();
		return msg;
	}
	
	
	
	/**
	*Updates the info of an employee<br>
	*<b>pre: </b> The employee must already be created <br>
	*<b>post: </b> Changes the info of the employee <br>
	*@param All are the same as the method addEmployee() to add a Main Coach
	*@return 
	*/
	public String updateEmployeeInfo(int selected,String name, int ID, int salary, boolean status, int experience, int managedTeams, int champions){
		selected--;
		Employee e = clubEmployees.get(selected);
		MainCoach c = (MainCoach) e;
		c.setName(name);
		c.setID(ID);
		c.setSalary(salary);
		c.setStatus(status);
		c.setExpYears(experience);
		c.setManagedTeams(managedTeams);
		c.setChampions(champions);
		clubEmployees.set(selected,c);
		return "Informacion del entrenador actualizada";
	}
	
	/**
	*Updates the info of an employee<br>
	*<b>pre: </b> The employee must already be created <br>
	*<b>post: </b> Changes the info of the employee <br>
	*@param All are the same as the method addEmployee() to add an Assistant
	*@return 
	*/
	public String updateEmployeeInfo(int selected,String name, int ID, int salary, boolean status, int experience, boolean wasPlayer, int expertise){
		selected--;
		Employee e = clubEmployees.get(selected);
		AssistantCoach a = (AssistantCoach) e;
		a.setName(name);
		a.setID(ID);
		a.setSalary(salary);
		a.setStatus(status);
		a.setExpYears(experience);
		a.setWasPlayer(wasPlayer);
		a.setExpertise(expertise);
		clubEmployees.set(selected,a);
		return "Informacion del asistente actualizada";
	}
	
	/**
	*Updates the info of an employee<br>
	*<b>pre: </b> The employee must already be created <br>
	*<b>post: </b> Changes the info of the employee <br>
	*@param All are the same as the method addEmployee() to add a Player
	*@return 
	*/
	public String updateEmployeeInfo(int selected,String name, int ID, int salary, boolean status, int shirtNumber, int goals, double grade, int position){
		selected--;
		Employee e = clubEmployees.get(selected);
		Player p = (Player) e;
		p.setName(name);
		p.setID(ID);
		p.setSalary(salary);
		p.setStatus(status);
		p.setShirtNumber(shirtNumber);
		p.setGoals(goals);
		p.setAverageGrade(grade);
		p.setPosition(position);
		clubEmployees.set(selected,p);
		return "Informacion del jugador actualizada";
	}
	
	/**
	*Finds the location of an employee in the facilities<br>
	*<b>pre: </b> The facilities must alredady be created and there must be at least one employee <br>
	*<b>post: </b> Shows the location of the employee <br>
	*@param selectedType The tyoe of employee
	*@param selectedEmployee The index of the employee
	*@param selectedDresser The selected dresser in case of a Player
	*@return A message that says if the employee was found
	*/
	public String employeeFacilities(int selectedType, int selectedEmployee, int selectedDresser){
		String msg = "";
		selectedEmployee--;
		switch(selectedType){
			case 1:
				if(clubEmployees.get(selectedEmployee) instanceof Player || clubEmployees.get(selectedEmployee) instanceof AssistantCoach){
					msg = "Seleccione un empleado valido";
				}
				else{
					Employee e = clubEmployees.get(selectedEmployee);
					MainCoach m = (MainCoach) e;
					msg = clubFacilities.findCoach(m);
				}
			break;
			
			case 2:
				if(clubEmployees.get(selectedEmployee) instanceof MainCoach || clubEmployees.get(selectedEmployee) instanceof Player){
					msg = "Seleccione un empleado valido";
				}
				else{
					Employee e = clubEmployees.get(selectedEmployee);
					AssistantCoach a = (AssistantCoach) e;
					msg = clubFacilities.findAsistant(a);
				}
			break;
			
			case 3:
				if(clubEmployees.get(selectedEmployee) instanceof MainCoach || clubEmployees.get(selectedEmployee) instanceof AssistantCoach){
					msg = "Seleccione un empleado valido";
				}
				else{
					Employee e = clubEmployees.get(selectedEmployee);
					Player p = (Player) e;
					msg = clubFacilities.findPlayer(p,selectedDresser);
				}
			break;
			
			default:
				msg = "error";
		}
		return msg;
		
	}
	
	/**
	*Place an employee in the facilities<br>
	*<b>pre: </b> There must be atleast one employee<br>
	*<b>post: </b> Place the employee in the respective place <br>
	*@param selectedEmployee The index of the employee
	*@param selectedDresser The selected dresser in case of a player
	*@return 
	*/
	public String placeEmployee(int selectedEmployee,int selectedDresser){
		selectedEmployee--;
		String msg = "";
		if(clubEmployees.get(selectedEmployee) instanceof MainCoach){
			MainCoach c = (MainCoach) clubEmployees.get(selectedEmployee);
			msg = clubFacilities.setCoach(c);
		}
		else if(clubEmployees.get(selectedEmployee) instanceof AssistantCoach){
			AssistantCoach a = (AssistantCoach) clubEmployees.get(selectedEmployee);
			msg = clubFacilities.setAssistant(a);
		}
		else{
			Player p = (Player) clubEmployees.get(selectedEmployee);
			msg = clubFacilities.setPlayer(selectedDresser,p,clubTeams);
		}
		return msg;
	}

	
	public String getName() {
		return this.name;
	}
	
	
	public int getNIT() {
		return NIT;
	}
	
	public Team[] getTeams(){
		return clubTeams;
	}
	
	
	public Date getDate() {
		return foundationDate;
	}
	
	
	public Facilities getFacilities() {
		return clubFacilities;
	}
	
	
	public ArrayList<Employee> getEmployees() {
		return clubEmployees;
	}
	

}