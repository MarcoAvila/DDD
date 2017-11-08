package org.marcoavila.ddd.quantity;

public class TimeDurationVO {

	private final int hours;
	private final int minutes;
	
	
	
	
	public TimeDurationVO(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}


	public TimeDurationVO(int hours) {
		this.hours = hours;
		this.minutes = 0;
	}



	
	
	
	

	public TimeDurationVO minus(TimeDurationVO other) {
		
		int h = getHours()   - other.getHours();
		int m = getMinutes() - other.getMinutes();
		
		h += m / 60;
		m = m % 60;
		
		return new TimeDurationVO(m, h);
	}

	
	
	
	
	
	
	
	
	
	
	
	public int getHours() {
		return hours;
	}




	public int getMinutes() {
		return minutes;
	}
	
	

	public String display() {
		return hours + ":" + minutes;
	}
	
	
	
	
	
	
}
