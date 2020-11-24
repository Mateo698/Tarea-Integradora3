package model;
import java.util.*;
public class FutballClub {

	private String name;
	private int NIT;
	private Facilities clubFacilities;
	private ArrayList<Employee> clubEmployees;
	private Date foundationDate;
	
	public FutballClub(String name, int NIT, Date foundationDate){
		this.name = name;
		this.NIT = NIT;
		this.foundationDate = foundationDate;
	}
	
	/**
	*Adds a new Main Coach to the club's employees<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(String name, int ID, int salary, int status, int experience, int managedTeams, int champions){
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
	public void addEmployee(){
		
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(){
		
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(){
		
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public void addEmployee(){
		
	}

	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public string getName() {
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
		// TODO - implement FutballClub.getNIT
		throw new UnsupportedOperationException();
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public Date getDate() {
		// TODO - implement FutballClub.getDate
		throw new UnsupportedOperationException();
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public Facilities getFacilities() {
		// TODO - implement FutballClub.getFacilities
		throw new UnsupportedOperationException();
	}
	
	/**
	*Description<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param 
	*@return 
	*/
	public Employee getEmployees() {
		// TODO - implement FutballClub.getEmployees
		throw new UnsupportedOperationException();
	}

}