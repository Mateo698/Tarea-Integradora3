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
		thos.NIT = NIT;
		String[] dates = date.split("/");
		Date foundationDateR = new Date(Integer.parseInt(dates[0],Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
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
	public void addEmployee(String name, int ID, int salary, int status, int experience, boolean wasPlayer, int expertise){
		AssistantCoach newACoach = new AssistantCoach(name,ID,salary,status.experience,wasPlayer,expertise);
		clubEmployees.add(newACoach);
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, int status, int shirtNumber, int goals, double grade, int position){
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
		msg = "Nombre del club: " + name + "\n" +
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
			msg += enumeration + ". \n" clubEmployees.get(i).showInfo() + "\n";
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
					msg = clubTeams[teamSelected].addCoach(employees);
				}
				else{
					msg = "Seleccione un empleado apropiado";
				}
			break;
			
			case 2:
				if(clubEmployees.get(employeeSelected) instanceof AssistantCoach){
					msg = clubTeams[teamSelected].addAssistant(employees);
				}
				else{
					msg = "Seleccione un empleado apropiado";
				}
			break;
			
			case 3:
				if(clubEmployees.get(employeeSelected) instanceof Player){
					msg = clubTeams[teamSelected].addPlayer(employees);
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
		String msg = ""
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
		clubEmployees.get(selected).setName(name);
		clubEmployees.get(selected).setID(ID);
		clubEmployees.get(selected).setSalary(salary);
		clubEmployees.get(selected).setStatus(status);
		clubEmployees.get(selected).setExpYears(experience);
		clubEmployees.get(selected).setManagedTeams(managedTeams);
		clubEmployees.get(selected).setChampions(champions);
		return "Informacion del entrenador actualizada";
	}
	
	//Updates assistant info
	public String updateEmployeeInfo(int selected,String name, int ID, int salary, int status, int experience, boolean wasPlayer, int expertise){
		selected--;
		clubEmployees.get(selected).setName(name);
		clubEmployees.get(selected).setID(ID);
		clubEmployees.get(selected).setSalary(salary);
		clubEmployees.get(selected).setStatus(status);
		clubEmployees.get(selected).setExpYears(experience);
		clubEmployees.get(selected).setWasPlayer(wasPlayer);
		clubEmployees.get(selected).setExpertise(expertise);
		return "Informacion del asistente actualizada";
	}
	
	//Updates player info
	public String updateEmployeeInfo(int selected,String name, int ID, int salary, int status, int shirtNumber, int goals, double grade, int position){
		selected--;
		clubEmployees.get(selected).setName(name);
		clubEmployees.get(selected).setID(ID);
		clubEmployees.get(selected).setSalary(salary);
		clubEmployees.get(selected).setStatus(status);
		clubEmployees.get(selected).setShirtNumber(shirtNumber);
		clubEmployees.get(selected).setGoals(goals);
		clubEmployees.get(selected).setAverageGrade(grade);
		clubEmployees.get(selected).setPosition(position);
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
					msg = clubFacilities.findCoach(clubEmployees.get(selectedEmployee));
				}
			break;
			
			case 2:
				if(clubEmployees.get(selectedEmployee) instanceof MainCoach || clubEmployees.get(selectedEmployee) instanceof Player){
					msg = "Seleccione un empleado valido";
				}
				else{
					msg = clubFacilities.findAsistant(clubEmployees.get(selectedEmployee));
				}
			break;
			
			case 3:
				if(clubEmployees.get(selectedEmployee) instanceof MainCoach || clubEmployees.get(selectedEmployee) instanceof AssistantCoach){
					msg = clubFacilities.findCoach(clubEmployees.get(selectedEmployee));
				}
				else{
					msg = clubFacilities.findPlayer(clubEmployees.get(selectedEmployee),selectedDresser);
				}
			break;
			
			default:
				msg = "error";
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