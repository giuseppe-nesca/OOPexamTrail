package trail;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class Location {
	
	private String name; 
	private int orderNum;
	private Map<String, Delegate> delegates =  new HashMap<>();
	//private Map<Integer, Long > records = new HashMap<>();
	private Map<Integer, Record> records = new HashMap<>();
	
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
    
    public void insertRecord(int num, Record r){
    	records.put(num, r);
    }
    
    public Record getRecord(int num){
    	Record time = records.get(num);
    	if (time == null  ) return null;
    	return records.get(num);
    }
    
    public List<Runner> getRank(){
    	return records.values().stream()
    			.sorted(Comparator.comparing(Record::getTime))
    			.map(Record::getRunner)
    			.collect(Collectors.toList());
    }
}
