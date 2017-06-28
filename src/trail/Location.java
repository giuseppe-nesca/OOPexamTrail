package trail;

public class Location {
	
	String name; int orderNum;
	
	public Location(String name, int orderNum){
		this.name = name;
		this.orderNum = orderNum;
	}

    public String getName(){
        return name;
    }

    public int getOrderNum(){
        return orderNum;
    }
}
