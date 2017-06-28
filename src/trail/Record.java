package trail;

public class Record {
	
	private long time;
	private Runner runner;
	private Location location;
	
	public Record(Runner r , Location l, Long  t){
		this.runner = r;
		this.location = l;
		this.time = t;
	}

	public long getTime() {
		return time;
	}

	public Runner getRunner() {
		return runner;
	}

	public Location getLocation() {
		return location;
	}

}
