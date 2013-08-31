import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import Passenger.Passenger;
import Passenger.readPassenger;;


public class Print {
	public static void printCustomerInfo(String filename,
			ArrayList<Passenger> list) throws IOException {
		Writer writer = new BufferedWriter(new FileWriter(filename));
		int sum = 0;
		for (int i = 0; i < list.size(); i++) { //승객 데이터에서 for문을 통해 이름, 도착시간, 티켓팅시간, 기다리는 시간, 티켓팅 + 열차시간, 순수하게 역에서 기다린 시간, 기차를 탄 시각등을 지어넣는다. 
			String name = list.get(i).getName();

			int arriveTime = list.get(i).getArriveTime();

			int TickettingTime = list.get(i).getcostTime();

			int waitTime = list.get(i).getWaitTimeTicketing();

			int waitTickettingTime = waitTime - TickettingTime;

			int endTime = arriveTime + waitTime;
			int waitStationTime = list.get(i).getWaitTimeStation();
			int startTime = endTime + waitStationTime;
			int arriveTrainTime = startTime + list.get(i).getGoTimeStation();
			writer.write(name + "   도착 시간 : " + arriveTime + "   티켓팅 대기 시간 : "
					+ waitTickettingTime + "   예매 완료 시간 : " + endTime
					+ "  열차 대기 시간 :  " + waitStationTime + " 열차 출발 시간 : "
					+ startTime + " 열차 도착 시간 : " + arriveTrainTime + "\n");

			sum += list.get(i).getWaitTimeTicketing()
					+ list.get(i).getWaitTimeStation();

		}
		writer.write("기다리는 시간의 총합 : " + sum + "\n");
		System.out.println("Total waiting Time : " + sum + "\n");
		writer.close();

	}
}
