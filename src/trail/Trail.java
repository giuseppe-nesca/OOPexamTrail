package trail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Trail {

	Collection<Runner> runners = new ArrayList<Runner>();
	Collection<Location>path = new TreeSet<Location>(new Comparator<Location>(){
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
			if (r.surname == surname) {
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

	}

	public List<String> getDelegates() {
		return null;
	}

	public void assignDelegate(String location, String delegate)
			throws TrailException {

	}

	public List<String> getDelegates(String location) {
		return null;
	}

	public long recordPassage(String delegate, String location, int bibNumber)
			throws TrailException {
		return -1;
	}

	public long getPassTime(String position, int bibNumber)
			throws TrailException {
		return -1;
	}

	public List<Runner> getRanking(String location) {
		return null;
	}

	public List<Runner> getRanking() {
		return null;
	}
}
