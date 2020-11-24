package model;
public class Player extends Employee implements CalculatePrice {

	private int shirtNumber;
	private int goals;
	private double averageGrade;
	private Position playerPosition;
	
	public Player(String name, int ID,int salary,boolean status, int shirtNumber, int goals, double averageGrade, int playerPosition){
		super(name, ID, salary, status);
		this.shirtNumber = shirtNumber;
		this.goals = goals;
		this.averageGrade = averageGrade;
		switch(playerPosition){
			case 1:
				this.playerPosition = Position.keeper;
			break;
			
			case 2:
				this.playerPosition = Position.defense;
			break;
			
			case 3:
				this.playerPosition = Position.midfielder;
			break;
			
			case 4:
				this.playerPosition = Position.striker;
			break;
			
			default:
		}
	}

	public int getShirtNumber() {
		return this.shirtNumber;
	}

	public int getGoals() {
		return this.goals;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public Position getPosition() {
		return playerPosition;
	}
	
	private String getStringPosition(){
		switch(playerPosition){
			case keeper:
				return "Portero";
			break;
			
			case defense:
				return "Defensor";
			break;
			
			case midfielder:
				return "Volante";
			break;
			
			case striker:
				return "Delantero";
			break;
			
			default:
				return "Who knows men";
		}
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo();
		msg += "Numero de camiseta :" + shirtNumber + "\n" + 
		"Numero de goles: " + goals + "\n" +
		"Calificacion promedio: " + averageGrade + "\n" +
		"Posicion: " + getStringPosition() + "\n";
		return msg;
	}

}