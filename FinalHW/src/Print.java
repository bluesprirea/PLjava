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
		for (int i = 0; i < list.size(); i++) { //�°� �����Ϳ��� for���� ���� �̸�, �����ð�, Ƽ���ýð�, ��ٸ��� �ð�, Ƽ���� + �����ð�, �����ϰ� ������ ��ٸ� �ð�, ������ ź �ð����� ����ִ´�. 
			String name = list.get(i).getName();

			int arriveTime = list.get(i).getArriveTime();

			int TickettingTime = list.get(i).getcostTime();

			int waitTime = list.get(i).getWaitTimeTicketing();

			int waitTickettingTime = waitTime - TickettingTime;

			int endTime = arriveTime + waitTime;
			int waitStationTime = list.get(i).getWaitTimeStation();
			int startTime = endTime + waitStationTime;
			int arriveTrainTime = startTime + list.get(i).getGoTimeStation();
			writer.write(name + "   ���� �ð� : " + arriveTime + "   Ƽ���� ��� �ð� : "
					+ waitTickettingTime + "   ���� �Ϸ� �ð� : " + endTime
					+ "  ���� ��� �ð� :  " + waitStationTime + " ���� ��� �ð� : "
					+ startTime + " ���� ���� �ð� : " + arriveTrainTime + "\n");

			sum += list.get(i).getWaitTimeTicketing()
					+ list.get(i).getWaitTimeStation();

		}
		writer.write("��ٸ��� �ð��� ���� : " + sum + "\n");
		System.out.println("Total waiting Time : " + sum + "\n");
		writer.close();

	}
}
