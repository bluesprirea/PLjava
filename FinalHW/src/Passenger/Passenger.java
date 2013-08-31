package Passenger;

import Station.Station;

public class Passenger implements Comparable{
	/*
	 * 이 클래스는 txt파일에서 아이디, 이름, 각종 시간정보를 제공합니다. 
	 * 
	 * 
	 */
	
	private int id;
	private String name;
	private int arriveTime;
	private int costTime;
	private Station startStation;
	private Station arrivalStation;
	private int waitTimeTicketing;
	private int waitTimeStation;
	private int goTimeStation;
	
	public Passenger(int id, String name, int arriveTime, int costTime, Station startStation, Station arrivalStation){
		this.id = id;
		this.name = name;
		this.arriveTime = arriveTime;
		this.costTime = costTime;
		this.startStation = startStation;
		this.arrivalStation = arrivalStation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public int getcostTime() {
		return costTime;
	}

	public Station getStartStation() {
		return startStation;
	}

	public Station getArrivalStation() {
		return arrivalStation;
	}

	public int getWaitTimeTicketing() {
		return waitTimeTicketing;
	}

	public void setWaitTimeTicketing(int waitTimeTicketing) {
		this.waitTimeTicketing = waitTimeTicketing;
	}

	public int getWaitTimeStation() {
		return waitTimeStation;
	}

	public void setWaitTimeStation(int waitTimeStation) {
		this.waitTimeStation = waitTimeStation;
	}

	public int getGoTimeStation() {
		return goTimeStation;
	}

	public void setGoTimeStation(int goTimeStation) {
		this.goTimeStation = goTimeStation;
	}
	
	@Override
	public int compareTo(Object arg0) {
		if (arg0.getClass() != Passenger.class)
			return 0;
		Passenger c = (Passenger) arg0;
		
		return this.getcostTime() - c.getcostTime();
	}
	
}
