package model;
public class Player extends Employee implements FutballStar {

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
	
	public void setShirtNumber(int shirtNumber){
		this.shirtNumber = shirtNumber;
	}

	public int getGoals() {
		return this.goals;
	}
	
	public void setGoals(int goals){
		this.goals = goals;
	}

	public double getAverageGrade() {
		return averageGrade;
	}
	
	public void setAverageGrade(double averageGrade){
		this.averageGrade = averageGrade;
	}

	public Position getPosition() {
		return playerPosition;
	}
	
	public void setPlayerPosition(int playerPosition){
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
	
	private String getStringPosition(){
		String msg = "";
		switch(playerPosition){
			case keeper:
				msg = "Portero";
			break;
			
			case defense:
				msg = "Defensor";
			break;
			
			case midfielder:
				msg = "Volante";
			break;
			
			case striker:
				msg = "Delantero";
			break;
			
			default:
				msg = "Who knows men";
		}
		return msg;
	}
	
	@Override
	public String showInfo(){
		String msg = "Jugador.\n"+super.showInfo();
		msg += "Numero de camiseta :" + shirtNumber + "\n" + 
		"Numero de goles: " + goals + "\n" +
		"Calificacion promedio: " + averageGrade + "\n" +
		"Posicion: " + getStringPosition() + "\n";
		return msg;
	}
	
	@Override
	public int calculatePrice(){
		int price = 0;
		switch(playerPosition){
			case keeper:
				price = (int)((getSalary()*12) + (averageGrade*150));
			break;
			
			case defense:
				price = (int)((getSalary()*13) + (averageGrade*125) + (goals*100));
			break;
			
			case midfielder:
				price = (int)((getSalary()*14) + (averageGrade*135) + (goals*125));
			break;
			
			case striker:
				price = (int)((getSalary()*15) + (averageGrade*145) + (goals*150));
			break;
			
			default:
				price = 0;
			
		}
		return price;
	}
	
	@Override
	public double calculateLevel(){
		double level = 0;
		switch(playerPosition){
			case keeper:
				level = (averageGrade*0.9);
			break;
			
			case defense:
				level = (averageGrade*0.9)+(goals/100);
			break;
			
			case midfielder:
				level = (averageGrade*0.9)+(goals/90);
			break;
			
			case striker:
				level = (averageGrade*0.9)+(goals/80);
			break;
			
			default:
				level = 0;
		}
		return level;
	}
}