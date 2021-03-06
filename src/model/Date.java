package model;
public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	*Gives the date<br>
	*<b>pre: </b> The date must already be created <br>
	*<b>post: </b> Shows the date <br>
	*@return the date
	*/
	public String stringDate(){
		String msg = day + "/" + month + "/" + year;
		return msg;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

}