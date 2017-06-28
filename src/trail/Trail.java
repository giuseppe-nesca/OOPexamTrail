package trail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Trail {

	private Collection<Runner> runners = new ArrayList<Runner>();
	private Collection<Location>path = new TreeSet<Location>(new Comparator<Location>(){
		@Override
		public int compare(Location l1, Location l2){
			if(l1.getName().equals(l2.getName())){
				return 0;
			}
			else{
				return l1.getOrderNum() - l2.getOrderNum();
			}
		}
	});
	private Map<String, Delegate> delegates = new HashMap<>();

	public int newRunner(String name, String surname) {
		int bibNumber = runners.size()+1;
		runners.add(new Runner(name, surname, bibNumber));
		return bibNumber;
	}

	public Runner getRunner(int bibNumber) {
		return ((ArrayList<Runner>) runners).get(bibNumber - 1);
	}

	public Collection<Runner> getRunner(String surname) {
		Collection<Runner> resultCollection = new ArrayList<>();
		runners.forEach(r -> {
			if (r.getSurname() == surname) {
				resultCollection.add(r);
			}
		});
		return resultCollection;
	}

	public List<Runner> getRunners() {
		return (List<Runner>) runners;
	}

	public List<Runner> getRunnersByName() {
		return runners.stream().sorted(new Comparator<Runner>() {

			public int compare(Runner r1, Runner r2) {
				int checkSurname = r1.getSurname().compareTo(r2.getSurname());
				int checkName = r1.getName().compareTo(r2.getName());
				if (checkSurname == 0) {
					if (checkName == 0) {
						return r1.getBibNumber();
					}else {
						return checkName;
					}
				}else {
					return checkSurname;
				}
			}
		}).collect(Collectors.toList());
	}

	public void addLocation(String location) {
		
		Location l = new Location(location, path.size());
		path.add(l);
	}

	// public void addLocation(String name, double lat, double lon, double
	// elevation){
	//
	// }

	public Location getLocation(String location) {
		for (Location l : path) {
			if (l.getName().equals(location)){
				return l;
			}
		}
		return null;
	}

	public List<Location> getPath() {
		return path.stream().collect(Collectors.toList());
	}

	public void newDelegate(String name, String surname, String id) {
		delegates.put(id, new Delegate(name, surname, id));
	}

	public List<String> getDelegates() {
		return 
				delegates.values().stream()
				.sorted(new Comparator<Delegate>() {

					@Override
					public int compare(Delegate d1, Delegate d2) {
						int checkName = d1.getNome().compareTo(d2.getNome());
						int checkSurname = d1.getCognome().compareTo(d2.getCognome());
						if (checkSurname == 0){
							return checkName;
						}else
							return checkSurname;
					}
				})
				.map(d -> d.toString())
				.collect(Collectors.toList())
				;
	}

	public void assignDelegate(String location, String delegate)
			throws TrailException {
		
		Delegate d = delegates.get(delegate);
		Location l = getLocation(location);
		if (d == null || l == null){
			throw new TrailException("location or delegate to found");
		}
		d.assegnaPosizione(l);
		l.addDelegate(d);
	}

	public List<String> getDelegates(String location) {
		return 
				getLocation(location).getDelegates().stream()
				.sorted(Comparator.comparing(Delegate::getCognome).thenComparing(Delegate::getNome))
				.map(d->d.toString())
				.collect(Collectors.toList())
				;
	}

	public long recordPassage(String delegate, String location, int bibNumber)
			throws TrailException {
		Delegate d = delegates.get(delegate);
		if (d == null) {
			throw new TrailException("delegate or location or runner not found");
		}
		//Location l = d.getLocation(location);
		Location l = d.getLocations().get(location);
		if (l == null || bibNumber > runners.size()) {
			throw new TrailException("delegate or location or runner not found");
		}
		long oraPassaggio = System.currentTimeMillis();
		Runner runner = getRunner(bibNumber);
		Record record = new Record(runner, l, oraPassaggio);
		l.insertRecord(bibNumber, record);
		runner.setLastRecord(record);
		return oraPassaggio;
	}

	public long getPassTime(String position, int bibNumber)
			throws TrailException {
		Location l = getLocation(position);
		if ( l == null || bibNumber > runners.size() ){
			throw new TrailException("number or position not found");
		}
		Record record = l.getRecord(bibNumber);
		if (record == null) {
			return -1;
		}else{
			return record.getTime();
		}
	}

	public List<Runner> getRanking(String location) {
		return getLocation(location).getRank();
	}

	public List<Runner> getRanking() {
		return 
//				runners.stream()
//				.map(Runner::getLastRecord)
//				.sorted(Comparator.comparing(Record::getTime))
//				.sorted((x,y) -> y.getLocation().getOrderNum() - x.getLocation().getOrderNum())
//				.map(Record::getRunner)
//				.distinct()
//				.collect(Collectors.toList());
				runners.stream()
				.sorted(Comparator.comparing(Runner::getLastLocNum, Comparator.reverseOrder())
						.thenComparing(Runner::getLastTime))
				.collect(Collectors.toList());
	}
}
