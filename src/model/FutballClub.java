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
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int experience, int managedTeams, int champions){
		MainCoach newCoach = new MainCoach(name, ID, salary, status, experience, managedTeams, champions);
		clubEmployees.add(newCoach);
	}
	
	/**
	*Adds a new assistant to the club's employees<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int experience, boolean wasPlayer, int expertise){
		AssistantCoach newACoach = new AssistantCoach(name,ID,salary,status,experience,wasPlayer,expertise);
		clubEmployees.add(newACoach);
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, boolean status, int shirtNumber, int goals, double grade, int position){
		Player newPlayer = new Player(name,ID,salary,status,shirtNumber,goals,grade,position);
		clubEmployees.add(newPlayer);
	}
	
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
	
	public String showAllInfo(){
		String msg = "Nombre del club: " + name + "\n" +
		"NIT: " + NIT + "\n" +
		"Fecha: " + foundationDate.stringDate() + "\n" +
		"Empleados: " + showAllEmployees() + "\n" +
		"Equipos: " + showTeams() + "\n";
		return msg;
	}
	
	public String showAllEmployees(){
		int enumeration = 1;
		String msg = "";
		for(int i=0;i<clubEmployees.size();i++){
			msg += enumeration + ". \n" + clubEmployees.get(i).showInfo() + "\n";
			enumeration++;
		}
		return msg;
	}
	
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
	
	public String showTeamLineUp(int selectedTeam){
		selectedTeam--;
		String msg = clubTeams[selectedTeam].showLineUp();
		return msg;
	}
	
	
	
	//Update main coach info
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
	
	//Updates assistant info
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
	
	//Updates player info
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

	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public int getNIT() {
		return NIT;
	}
	
	public Team[] getTeams(){
		return clubTeams;
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public Date getDate() {
		return foundationDate;
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public Facilities getFacilities() {
		return clubFacilities;
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public ArrayList<Employee> getEmployees() {
		return clubEmployees;
	}
	

}