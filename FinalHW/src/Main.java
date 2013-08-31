import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

import Station.StationFunc;
import TicketBox.roundRobin;
import TicketBox.roundRobin.TickettingMethod;
import TicketBox.ticketting;
import Passenger.Passenger;
import Passenger.readPassenger;


public class Main {
	public static void main(String[] args) throws IOException,
			IllegalArgumentException, IllegalAccessException{
		readPassenger.loadFile(args[0]); //손님 목록을 불러온다.
		StationFunc.loadFile(args[1]); //기차역 정보를 가져온다. 
		ticketting t = new ticketting(); //티켓팅과정에 대한 new 선언
		Field f = roundRobin.getStategy(); //라우팅 메소드 불러오기 - 라운드로빈
		TickettingMethod r = (TickettingMethod) f.get(roundRobin.class); //라운드 로빈에 나와있는 함수 가져오기
		t.process(r, readPassenger.getList()); 
		Print.printCustomerInfo("Result.txt",readPassenger.getList()); //result.txt 에 정보를 쓰고, 저장.
			
		
	
	}
}
