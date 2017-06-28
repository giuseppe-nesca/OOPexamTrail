package trail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class Location {
	
	private String name; 
	private int orderNum;
	private Map<String, Delegate> delegates =  new HashMap<>();
	private Map<Integer, Long > records = new HashMap<>();
	
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
    
    public void insertRecord(int num, long time){
    	records.put(num, time);
    }
    
    public long getRecord(int num){
    	Long time = records.get(num);
    	if (time == null  ) return -1;
    	return records.get(num);
    }
}
