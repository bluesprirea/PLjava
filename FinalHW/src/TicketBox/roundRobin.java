package TicketBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

import Passenger.Passenger;

import TicketBox.Agent;
import TicketBox.roundRobin;
import TicketBox.ticketting;

public class roundRobin {
	public interface TickettingMethod {
		public void process(Agent[] Agents, ArrayList<Passenger> timeList);
	}
	
	public static Field getStategy() throws IOException {
		
		Class<roundRobin> c = roundRobin.class;

		Field[] fs = c.getFields();
		
		String fname = "roundRobin";

		try {
			int index = Integer.parseInt(fname);
			fname = fs[index].getName();
		} catch (NumberFormatException e) {

		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		try {
			Field f = c.getField(fname);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static TickettingMethod roundRobin = new TickettingMethod() {
		@Override
		public void process(Agent[] Agents, ArrayList<Passenger> timeList) {
			int num = 0;
			for (Passenger c : timeList) {
				num = num % Agents.length;
				Agents[num].addPassenger(c);
				num++;
			}
		}
	};

}
	
