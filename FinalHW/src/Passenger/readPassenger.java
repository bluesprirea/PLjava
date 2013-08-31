package Passenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Station.Station;
import Passenger.readPassenger;

public class readPassenger {
	private static ArrayList<Passenger> list = new ArrayList<Passenger>();
	
	private readPassenger(String filename) throws IOException {
		list.clear();
		FileReader fr = new FileReader (filename);
		BufferedReader br = new BufferedReader(fr);
		String a = "";
		
		while((a = br.readLine()) != null)
		{
			String[] b = a.split(" "); //�ؽ�Ʈ ���Ͽ��� �������� ����
			int id = Integer.parseInt(b[0]); // ù��° ������ id
			String name = b[1]; // �ι�° ������ �̸�
			int arrivalTime = Integer.parseInt(b[2]); //�̰� �����ð�
			int costTime = Integer.parseInt(b[3]); // �̰� Ƽ���� �ҿ�ð�
			Station departure = Station.searchStation(b[4]); //��߿�
			Station arrival = Station.searchStation(b[5]); //������
			list.add(new Passenger(id, name, arrivalTime, costTime, departure, arrival)); // �� ������ array�� �߰�.
		}
		br.close();
	}
	
	public static readPassenger loadFile(String string) throws IOException{
		return new readPassenger(string);
	}
	
	public static ArrayList<Passenger> getList() {
		return list;
	}
}
