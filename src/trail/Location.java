package trail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Location {
	
	private String name; 
	private int orderNum;
	private Map<String, Delegate> delegates =  new HashMap<>();
	
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
    
    public void addDelegate(Delegate d){
    	delegates.put(d.getNome(), d);
    }
    
    public Collection<Delegate> getDelegates(){ return delegates.values();}
}
