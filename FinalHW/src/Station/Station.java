package Station;

public enum Station {
	SO("Seoul"), CC("Chuncheon"), KJ("Kyungju"), GJ("Gwangju"), DJ("Daejeon"), AS("Asan"), WJ("Wonju");

	private String name = "";

	Station(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static Station searchStation(String station) {
		Station[] s= Station.values();
		for(int i = 0;i<s.length;i++){
			if (s[i].getName().equals(station))
				return s[i];
		}
		return null;
	}

}