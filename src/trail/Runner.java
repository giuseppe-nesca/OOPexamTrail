package trail;

public class Runner {
	
	String name,surname;
	int bibNumber;
	
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
