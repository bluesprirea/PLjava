package TicketBox;

import java.util.ArrayList;

import TicketBox.Agent;
import TicketBox.roundRobin;
import TicketBox.roundRobin.TickettingMethod;
import Passenger.Passenger;

public class ticketting {


		Agent Agents[] = new Agent[3];

		public ticketting() {
			for (int i = 0; i < 3; i++) {
				Agents[i] = new Agent();
			}
		}

		public ArrayList<Passenger> filter(ArrayList<Passenger> list, int time) {
			ArrayList<Passenger> flist = new ArrayList<Passenger>();
			for (Passenger c : list) {
				if (c.getArriveTime() == time)
					flist.add(c);
			}
			return flist;
		}

		public boolean isRemainPassenger(ArrayList<Passenger> list, int time) {
			for (Passenger c : list) {
				if (c.getArriveTime() >= time)
					return true;
			}
			return false;
		}

		public void process(TickettingMethod r, ArrayList<Passenger> list) {
			int time = -1;
			while (true) {
				time++;
				for (int i = 0; i < Agents.length; i++) {
					Agents[i].process(time);
				}
				ArrayList<Passenger> timeList = filter(list, time);
				
				r.process(Agents, timeList);
				
				
				
				boolean isRemain = isRemainPassenger(list, time);
				boolean isPassengers = false;

				for (Agent Agent : Agents) {
					if (!Agent.isEmpty()) {
						isPassengers = true;
					}
				}
				if (!isPassengers && !isRemain)
					break;
			}
		}
}
