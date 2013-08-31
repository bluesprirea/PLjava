package Station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import Station.Station;

public class StationFunc {
	private HashMap<Station, HashMap<Station, Integer>> train = new HashMap<Station, HashMap<Station, Integer>>(); // 출발역, 도착역, 걸리는 시간
	private static HashMap<Station, HashMap<Station, Integer>> trainTime = new HashMap<Station, HashMap<Station, Integer>>();

	private final int MAX = 10000000;

	private StationFunc(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String a = "";

		train.clear();
		trainTime.clear();

		while ((a = br.readLine()) != null) {
			String[] b = a.split(" ");
			Station start = Station.searchStation(b[0]);
			Station arrive = Station.searchStation(b[1]);
			int time = Integer.parseInt(b[2]);
			if (start == null || arrive == null)
				continue;

			add(start, arrive, time);
		}
		br.close();
		Station[] stations = Station.values();
		for (int i = 0; i < stations.length; i++) {
			dijkstra(stations[i]);
		}
	}

	public void add(Station a, Station b, int time) {
		addStation(a, b, time);
		addStation(b, a, time);
	}

	public void addStation(Station a, Station b, int time) {
		if (!train.containsKey(a))
			train.put(a, new HashMap<Station, Integer>());

		train.get(a).put(b, time);
	}

	public static int getTimeGoStation(Station start, Station arrive) {
		return trainTime.get(start).get(arrive);
	}

	void dijkstra(Station start) {
		
		HashMap<Station, Integer> distance = new HashMap<Station, Integer>();
		HashMap<Station, Station> beforeVertex = new HashMap<Station, Station>();
		HashMap<Station, Boolean> found = new HashMap<Station, Boolean>();
		
		HashMap<Station, Integer> startList = train.get(start);

		Station[] s = Station.values();
		for (int i = 0; i < s.length; i++) {
			distance.put(s[i], MAX);
			found.put(s[i], false);
			if (s[i] == start)
				continue;

			beforeVertex.put(s[i], start);

			if (startList.containsKey(s[i]))
				distance.put(s[i], startList.get(s[i]));
		}

		for (int i = 0; i < s.length; i++) {
			Station u = choose(distance, found);
			found.put(u, true);

			if (u == null)
				break;

			if (!train.containsKey(u))
				continue;

			Iterator<Station> iter = train.get(u).keySet().iterator();

			for (int j = 0; j < s.length; j++) {
				if (!found.get(s[j])) {
					int high = train.get(u).containsKey(s[j]) ? train.get(u)
							.get(s[j]) : MAX;
					if (distance.get(u) + high < distance.get(s[j])) {
						distance.put(s[j], distance.get(u) + high);
						beforeVertex.put(s[j], u);
					}
				}
			}
		}

		for (int i = 0; i < s.length; i++) {
			addTrainTime(start, s[i], distance.get(s[i]));
		}
	}

	public Station choose(HashMap<Station, Integer> distance,
			HashMap<Station, Boolean> found) {
		int min;
		Station minpos = null;
		min = 10000000;
		Iterator<Station> i = distance.keySet().iterator();

		while (i.hasNext()) {
			Station s = i.next();
			if (distance.get(s) < min && !found.get(s)) {
				min = distance.get(s);
				minpos = s;
			}
		}
		return minpos;
	}

	public void addTrainTime(Station a, Station b, int time) {
		if (!trainTime.containsKey(a))
			trainTime.put(a, new HashMap<Station, Integer>());

		trainTime.get(a).put(b, time);
	}

	public static StationFunc loadFile(String string) throws IOException {
		return new StationFunc(string);
	}
}
