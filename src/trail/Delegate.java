package trail;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Delegate implements Comparator<Delegate>{

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
	
	@Override
	public int compare(Delegate d1, Delegate d2){
		int checkName = d1.getNome().compareTo(d2.getNome());
		int checkSurname = d1.getCognome().compareTo(d2.getCognome());
		if (checkSurname == 0){
			return checkName;
		}else
			return checkSurname;
	}
	
	public void assegnaPosizione(Location l){
		posizioniAssegnate.put(l.getName(), l);
	}
	
	public Location getLocation(String l){
		return posizioniAssegnate.get(l);
	}
}
