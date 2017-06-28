package trail;

public class Runner {
	
	private String name,surname;
	private int bibNumber;
	
	public Runner(String name, String surname, int bibNumber){
		this.name = name;
		this.surname = surname;
		this.bibNumber = bibNumber;
	}

    
    public int getBibNumber(){
        return bibNumber;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

}
