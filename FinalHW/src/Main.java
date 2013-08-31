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
		readPassenger.loadFile(args[0]); //�մ� ����� �ҷ��´�.
		StationFunc.loadFile(args[1]); //������ ������ �����´�. 
		ticketting t = new ticketting(); //Ƽ���ð����� ���� new ����
		Field f = roundRobin.getStategy(); //����� �޼ҵ� �ҷ����� - ����κ�
		TickettingMethod r = (TickettingMethod) f.get(roundRobin.class); //���� �κ� �����ִ� �Լ� ��������
		t.process(r, readPassenger.getList()); 
		Print.printCustomerInfo("Result.txt",readPassenger.getList()); //result.txt �� ������ ����, ����.
			
		
	
	}
}
