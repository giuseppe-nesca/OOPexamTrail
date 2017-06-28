package trail;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Delegate{

	private String nome, cognome, CF;
	private Map<String  , Location> posizioniAssegnate = new HashMap<>();
	
	public Delegate(String nome, String cognome, String CF){
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCF() {
		return CF;
	}
	
	public String toString(){
		return new String (cognome + ", " +  nome + ", " + CF);
	}
	
	public void assegnaPosizione(Location l){
		posizioniAssegnate.put(l.getName(), l);
	}
	
	public Location getLocation(String l)throws TrailException{
		Location location = posizioniAssegnate.get(l);
		return location;
	}
	public Map<String, Location> getLocations(){return posizioniAssegnate;}
}
