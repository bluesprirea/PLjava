package TicketBox;

import java.util.ArrayList;

import Station.StationFunc;
import Passenger.Passenger;

public class Agent {
	ArrayList<Passenger> PassengerList = new ArrayList<Passenger>();
	private int startTime = 0;

	public void addPassenger(Passenger c) {
		PassengerList.add(c);
	}

	public void process(int nowTime) {
		if (PassengerList.isEmpty())
			return;

		int taskTime = nowTime - startTime;

		if (taskTime <= 0)
			return;
		Passenger c = PassengerList.get(0);

		int leadTime = c.getcostTime();

		if (c.getArriveTime() > startTime) {//startTime�� ���� ���� Adviser�� ��� �־��� ����. Ƽ������ �� �� ���� ���.
			startTime = c.getArriveTime();
			return;
		}
		// System.out.println(leadTime + "asas"+c.getArriveTime());

		if (leadTime <= taskTime) {// �귯�� �ð�
			// System.out.println(c.getName() +"  "+ c.getcostTime() + " - " +
			// nowTime);

			c.setWaitTimeStation(nowTime % 5 == 0 ? 0 : 5 - nowTime % 5);
			c.setWaitTimeTicketing(nowTime - c.getArriveTime());
			c.setGoTimeStation(StationFunc.getTimeGoStation(
					c.getStartStation(), c.getArrivalStation()));

			PassengerList.remove(0);

			startTime = nowTime;
		}
	}

	public int getAllTime() {
		int time = 0;
		for (Passenger c : PassengerList) {
			time += c.getcostTime();
		}
		return time;
	}

	public int getCount() {
		return PassengerList.size();
	}

	public boolean isEmpty() {
		return PassengerList.isEmpty();
	}

}
