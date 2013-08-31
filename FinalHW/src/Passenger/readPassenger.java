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
			String[] b = a.split(" "); //텍스트 파일에서 띄워쓰기로 구분
			int id = Integer.parseInt(b[0]); // 첫번째 구절은 id
			String name = b[1]; // 두번째 구절은 이름
			int arrivalTime = Integer.parseInt(b[2]); //이건 도착시간
			int costTime = Integer.parseInt(b[3]); // 이건 티켓팅 소요시간
			Station departure = Station.searchStation(b[4]); //출발역
			Station arrival = Station.searchStation(b[5]); //도착역
			list.add(new Passenger(id, name, arrivalTime, costTime, departure, arrival)); // 이 정보를 array에 추가.
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
