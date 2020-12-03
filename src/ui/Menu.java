package ui;
import model.*;
import java.util.*;

public class Menu{
	
	private FutballClub club;
	private static Scanner in = new Scanner(System.in);
	
	
	public Menu(){

	}
	
	/**
	*Read the option selected by the user<br>
	*<b>pre: </b> None <br>
	*<b>post: </b> Gives the option selected <br>
	*@return the option, lmao
	*/
	public int readOption(){
		int option = in.nextInt();
		in.nextLine();
		return option;
	}
	
	/**
	*Show the first menu to create the club<br>
	*<b>pre: </b> None <br>
	*<b>post: </b> Creates the club <br> 
	*/
	public void showInitialMenu(){
		System.out.println("Ingrese el nombre del club de futbol\n");
		String name = in.nextLine();
		System.out.println("Ingrese el NIT del club\n");
		int NIT = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese la fecha en la cual se creo el club con el formato DIA/MES/ANIO");
		String date = in.nextLine();
		club = new FutballClub(name,NIT,date);
	}
	
	/**
	*Shows the main menu<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> None <br> 
	*/
	public void showMainMenu(){
		System.out.println("Ingrese el numero de una de las siguientes opciones\n" +
		"1. Contratar un empleado\n" + 
		"2. Despedir un empleado\n" +
		"3. Crear un equipo\n" +
		"4. Agregar un empleado a un equipo\n" +
		"5. Actualizar la informacion de un empleado\n" +
		"6. Ver la informacion de los empleados\n" +
		"7. Ver la informacion de un empleado\n" +
		"8. Actualizar o ver alineacion de un equipo\n" +
		"9. Ubicar un empleado en las instalaciones\n" +
		"10. Encontrar un empleado en las instalaciones\n" +
		"11. Ver informacion de los equipos\n");
	}
	
	/**
	*Do the selected operation<br>
	*<b>pre: </b> The club must be created and the readOption() called <br>
	*<b>post: </b> Do the respective operation <br>
	*@param The selected option
	*/
	public void operations(int option){
		switch(option){
			case 1:
				readEmployee();
			break;
			
			case 2:
				fireEmployee();
			break;
			
			case 3:
				System.out.println("Ingrese el nombre del equipo");
				String tName = in.nextLine();
				System.out.println(club.newTeam(tName));
			break;
			
			case 4:
				addToTeam();
			break;
			
			case 5:
				updateEmployee();
			break;
			
			case 6:
				System.out.println(club.showAllEmployees());
			break;
			
			case 7:
				seeEmployee();
			break;
			
			case 8:
				showTeamMenu();
			break;
			
			case 9:
				placeEmployee();
			break;
			
			case 10:
				locateEmployee();
			break;
			
			case 11:
				if(club.getTeams()[0]  == null && club.getTeams()[1] == null ){
					System.out.println("Aun no hay equipos");
				}
				else{
					System.out.println(club.showTeams());
				}
			break;
			
			default:
				System.out.println("Seleccione una opcion valida");
		}
	}
	
	/**
	*Reads the new employee<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> None <br>
	*/
	public void readEmployee(){
		System.out.println("Ingrese el nombre del nuevo empleado");
		String name = in.nextLine();
		System.out.println("Ingrese el numero de identificacion");
		int ID = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese el salario del empleado");
		int salary = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese 1 si esta activo, 2 si no esta activo");
		int selection = in.nextInt();
		in.nextLine();
		boolean status = false;
		if(selection == 1){
			status = true;
		}
		System.out.println("Ingrese 1 si es un entrenador, 2 si es un asistente y 3 si es un jugador");
		int selectionType = in.nextInt();
		in.nextLine();
		int expYears = 0;
		switch(selectionType){
			case 1:
				System.out.println("Ingrese los anios de experiencia");
				expYears = in.nextInt();
				System.out.println("Ingrese los equipos que ha manejado");
				int managed = in.nextInt();
				System.out.println("Ingrese el numero de campeonatos ganados");
				int champions = in.nextInt();
				in.nextLine();
				club.addEmployee(name,ID,salary,status,expYears,managed,champions);
			break;
			
			case 2:
				System.out.println("Ingrese los anios de experiencia");
				expYears = in.nextInt();
				System.out.println("Ingrese 1 si fue un jugador, 2 si no");
				int intWasPlayer = in.nextInt();
				boolean wasPlayer = false;
				if(intWasPlayer == 1){
					wasPlayer = true;
				}
				System.out.println("Ingrese 1 si su expertisia es ofensiva\n2 si es defensiva\n3 si es posesion\n4 si es de jugadas de laboratorio");
				int intExpertise = in.nextInt();
				in.nextLine();
				club.addEmployee(name,ID,salary,status,expYears,wasPlayer,intExpertise);
			break;
			
			case 3:
				System.out.println("Ingrese el numero de camiseta");
				int shirtNumber = in.nextInt();
				System.out.println("Ingrese el numero de goles");
				int goals = in.nextInt();
				System.out.println("Ingrese la calificacion promedio con coma");
				double grade = in.nextDouble();
				System.out.println("Ingrese 1 si es portero\n2 si es defensor\n3 si es volante\n4 si es delantero");
				int position = in.nextInt();
				in.nextLine();
				club.addEmployee(name,ID,salary,status,shirtNumber,goals,grade,position);
			break;
			
			default:
		}
		System.out.println("Agregado correctamente \n\n");
	}
	
	/**
	*Show the menu to fire an employee<br>
	*<b>pre: </b> The club must be created and there must be at least one employee <br>
	*<b>post: </b> None <br>
	*/
	public void fireEmployee(){
		if(club.getEmployees().size() == 0){
			System.out.println("Aun no hay empleados");
		}
		else{
			System.out.println("Digite el numero del empleado que desea despedir");
			System.out.println(club.showAllEmployees());
			int selected = in.nextInt();
			in.nextLine();
			System.out.println(club.removeEmployee(selected));
		}
	}
	
	/**
	*<br>
	*<b>pre: </b> The club must be created  <br>
	*<b>post: </b> None <br>
	*/
	public void addToTeam(){
		if(club.getTeams()[0]  == null && club.getTeams()[1] == null ){
			System.out.println("Aun no hay equipos");
		}
		else{
			if(club.getEmployees().size() == 0){
				System.out.println("Aun no hay empleados");
			}
			else{
				System.out.println("Ingrese 1 si desea agregar un entrenado\n2 un asistente\n3 un jugador");
				int selectionType = in.nextInt();
				System.out.println(club.showAllEmployees());
				System.out.println("Seleccione el numero del empleado DE ACUERDO A LO QUE SELECCIONO ANTERIORMENTE");
				int selected = in.nextInt();
				System.out.println(club.showTeams());
				System.out.println("Ingrese el numero del equipo al que desea agregar el empleado");
				int selectedTeam = in.nextInt();
				in.nextLine();
				System.out.println(club.addEmployeeToTeam(selectionType,selected,selectedTeam));
			}
		}
	}
	
	/**
	*Reads the new info of the employee<br>
	*<b>pre: </b> TThe club must be created and the employee as well <br>
	*<b>post: </b> Updates the employee info <br>
	*/
	public void updateEmployee(){
		if(club.getEmployees().size() != 0){
			System.out.println(club.showAllEmployees());
			System.out.println("Seleccione el numero del que desea actualizar");
			int selectedToChange = in.nextInt();
			in.nextLine();
			System.out.println("Ingrese el nuevo nombre del nuevo empleado");
			String name = in.nextLine();
			System.out.println("Ingrese el nuevo numero de identificacion");
			int ID = in.nextInt();
			in.nextLine();
			System.out.println("Ingrese el nuevo salario del empleado");
			int salary = in.nextInt();
			in.nextLine();
			System.out.println("Ingrese 1 si esta activo, 2 si no esta activo");
			int selection = in.nextInt();
			in.nextLine();
			boolean status = false;
			if(selection == 1){
				status = true;
			}
			selectedToChange--;
			Employee e = club.getEmployees().get(selectedToChange);
			selectedToChange++;
			int expYears = 0;
			if(e instanceof MainCoach){
				System.out.println("Ingrese los anios de experiencia");
				expYears = in.nextInt();
				System.out.println("Ingrese los equipos que ha manejado");
				int managed = in.nextInt();
				System.out.println("Ingrese el numero de campeonatos ganados");
				int champions = in.nextInt();
				in.nextLine();
				System.out.println(club.updateEmployeeInfo(selectedToChange,name,ID,salary,status,expYears,managed,champions));
			}
			else if(e instanceof AssistantCoach){
				System.out.println("Ingrese los anios de experiencia");
				expYears = in.nextInt();
				System.out.println("Ingrese 1 si fue un jugador, 2 si no");
				int intWasPlayer = in.nextInt();
				boolean wasPlayer = false;
				if(intWasPlayer == 1){
					wasPlayer = true;
				}
				System.out.println("Ingrese 1 si su expertisia es ofensiva\n2 si es defensiva\n3 si es posesion\n4 si es de jugadas de laboratorio");
				int intExpertise = in.nextInt();
				in.nextLine();
				System.out.println(club.updateEmployeeInfo(selectedToChange,name,ID,salary,status,expYears,wasPlayer,intExpertise));
			}
			else if(e instanceof Player){
				System.out.println("Ingrese el numero de camiseta");
				int shirtNumber = in.nextInt();
				System.out.println("Ingrese el numero de goles");
				int goals = in.nextInt();
				System.out.println("Ingrese la calificacion promedio con coma o punto");
				double grade = in.nextDouble();
				System.out.println("Ingrese 1 si es portero\n2 si es defensor\n3 si es volante\n4 si es delantero");
				int position = in.nextInt();
				in.nextLine();
				System.out.println(club.updateEmployeeInfo(selectedToChange,name,ID,salary,status,shirtNumber,goals,grade,position));
			}
		}
		else{
			System.out.println("Aun no hay empleados");
		}
	}
	
	/**
	*Shows the info of the selected employee<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Shows the info of the employee <br> 
	*/
	public void seeEmployee(){
		System.out.println("Ingrese el numero de identificacion del empleado");
		int ID = in.nextInt();
		in.nextLine();
		System.out.println(club.showEmployeeInfo(ID));
	}
	
	/**
	*Shows the menu for the teams<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> None <br>
	*/
	public void showTeamMenu(){
		System.out.println(club.showTeams());
		System.out.println("Ingrese el numero del equipo que desea editar");
		int selectedTeam = in.nextInt();
		in.nextLine();
		if(selectedTeam>2 || selectedTeam<0){
			System.out.println("Ingrese un valor valido");
		}
		else{
			selectedTeam--;
			System.out.println("Ingrese 1 si desea ver la alineacion\n2 si desea cambiarla\n");
			int option = in.nextInt();
			in.nextLine();
			if(option == 1){
				System.out.println(club.showTeamLineUp(option));
			}
			else{
				System.out.println("Ingrese la nueva alineacion");
				String newLineUp = in.nextLine();
				System.out.println(club.getTeams()[selectedTeam].updateLineup(newLineUp));
			}
		}
	}
	
	/**
	*Read the info to place an employee<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Calls the method to place an employee <br> 
	*/
	public void placeEmployee(){
		System.out.println(club.showAllEmployees());
		System.out.println("Ingrese 1 si desea ubicar un entrenador, 2 un asistente y 3 un jugador");
		int selectedType = in.nextInt();
		System.out.println("Ingrese el numero del empleado que desea ubicar CONCORDE A LO QUE RESPONDIO");
		int selectedEmployee = in.nextInt();
		int selectedDresser = 0;
		if(selectedType == 3){
			System.out.println("Ingrese el numero del vestidor (1 o 2)");
			selectedDresser = in.nextInt();
		}
		System.out.println(club.placeEmployee(selectedEmployee,selectedDresser));
	}
	
	/**
	*Read the info to find an employee<br>
	*<b>pre: </b> The club must be created <br>
	*<b>post: </b> Calls the method to find the employee <br> 
	*/
	public void locateEmployee(){
		System.out.println("Ingrese 1 si desea ubicar un entrenador, 2 un asistente y 3 un jugador");
		int selectedType = in.nextInt();
		System.out.println(club.showAllEmployees());
		System.out.println("Ingrese el numero del empleado que desea encontrar CONCORDE A LO QUE ACABA DE INGRESAR");
		int selectedEmployee = in.nextInt();
		int selectedDresser = 0;
		if(selectedType == 3){
			System.out.println("Ingrese 1 si desea buscarlo en el vestidor 1 o 2 si desea buscarlo en el segundo");
			selectedDresser = in.nextInt();
			in.nextLine();
		}
		System.out.println(club.employeeFacilities(selectedType,selectedEmployee,selectedDresser));
	}
	
	/**
	*Start the program<br>
	*<b>pre: </b> None <br>
	*<b>post: </b> None <br>
	*/
	public void startProgram(){
		int option = 0;
		showInitialMenu();
		do{
			showMainMenu();
			option = readOption();
			operations(option);
			
			
		}while(option != 0);
	}
	
	
	
}