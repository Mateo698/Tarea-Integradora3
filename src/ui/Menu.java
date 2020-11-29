package ui;
import model.*;
import java.util.*;

public class Menu(){
	
	private FutballClub club;
	private static Scanner in = new Scanner(System.in);
	
	public Menu(){
	}
	
	public int readOption(){
		int option = in.nextInt();
		in.nextLine();
		return option;
	}
	
	public void showInitialMenu(){
		System.out.println("Ingrese el nombre del club de futbol\n");
		String name = in.nextLine();
		System.out.println("Ingrese el NIT del club\n");
		int NIT = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese la fecha en la cual se creo el club con el formato DIA/MES/ANIO")
		String date = in.nextLine();
		club = new FutballClub(name,NIT,date);
	}
	
	public void showMainMenu(){
		System.out.println("Ingrese el numero de una de las siguientes opciones\n" +
		"1. Contratar un empleado\n" + 
		"2. Despedir un empleado\n" +
		"3. Agregar un empleado a un equipo\n" +
		"4. Actualizar la informacion de un empleado\n" +
		"5. Ver la informacion de los empleados\n" +
		"6. Ver la informacion de un empleado\n" +
		"7. Editar un equipo\n" +
		"8. Ubicar un empleado en las instalaciones\n" +
		"9. Encontrar un empleado en las instalaciones");
	}
	
	public void operations(int option){
		switch(option){
			case 1:
				readEmployee();
			break;
			
			case 2:
				fireEmployee();
			break;
			
			case 3:
				addToTeam();
			break;
			
			case 4:
			
		}
	}
	
	public void readEmployee(){
		System.out.println("Ingrese el nombre del nuevo empleado");
		String name = in.nextLine();
		System.out.println("Ingrese el numero de identificacion");
		int ID = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese el salario del empleado");
		int salary = in.nextInt()
		in.nextLine();
		System.out.println("Ingrese 1 si esta activo, 2 si no esta activo");
		int selection = in.nextInt()
		in.nextLine()
		boolean status = false;
		if(selection == 1){
			status = true;
		}
		System.out.println("Ingrese 1 si es un entrenador, 2 si es un asistente y 3 si es un jugador");
		int selectionType = in.nextInt();
		in.nextLine();
		switch(selectionType){
			case 1:
				System.out.println("Ingrese los anios de experiencia");
				int expYears = in.nextInt();
				System.out.println("Ingrese los equipos que ha manejado");
				int managed = in.nextInt();
				System.out.println("Ingrese el numero de campeonatos ganados");
				int champions = in.nextInt();
				in.nextLine();
				club.addEmployee(name,ID,salary,status,expYears,managed,champions);
			break;
			
			case 2:
				System.out.println("Ingrese los anios de experiencia");
				int expYears = in.nextInt();
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
				System.out.println("Ingrese la calificacion promedio con coma o punto");
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
	
	public void fireEmployee(){
		if(club.getEmployees().size() == 0){
			System.out.println("Aun no hay empleados");
		}
		else{
			System.out.println("Digite el numero del empleado que desea despedir");
			System.out.println(club.showAllEmployees);
			int selected = in.nextInt();
			in.nextLine();
			System.out.println(club.removeEmployee(selected));
		}
	}
	
	public void addToTeam(){
		if(club.getTeams()[0]  == null && club.getTeams()[1] == null){
			System.out.println("Aun no hay equipos");
		}
		else{	
			System.out.println("Ingrese 1 si desea agregar un entrenado\n2 un asistente\n3 un jugador");
			int selectionType = in.nextInt();
			System.out.println(club.showAllEmployees);
			System.out.println("Seleccione el numero del empleado DE ACUERDO A LO QUE SELECCIONO ANTERIORMENTE");
			int selected = in.nextInt();
			System.out.println(club.showTeams())
			System.out.println("Ingrese el numero del equipo al que desea agregar el empleado");
			int selectedTeam = in.nextInt();
			in.nextLine();
			System.out.println(club.addEmployeeToTeam(selectionType,selected,selectedTeam));
		}
	}
	
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