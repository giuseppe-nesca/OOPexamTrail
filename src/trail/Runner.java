package trail;

public class Runner {
	
	private String name,surname;
	private int bibNumber;
	private Record lastRecord = null;
	
	public Record getLastRecord() {
		return lastRecord;
	}


	public void setLastRecord(Record lastRecord) {
		this.lastRecord = lastRecord;
	}


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
