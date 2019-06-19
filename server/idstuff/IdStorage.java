package idstuff;

import java.io.*;
import java.util.ArrayList;

public class IdStorage extends ArrayList<Player>{
	private static IdStorage storage = new IdStorage();
	private IdStorage() {
		
	}
	
    public static IdStorage getInstance() {
        if (storage == null)
        	storage = new IdStorage();

        return storage;
    }

    
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4707099528716826136L;

	private String storageFilePath = "Players.txt";  //default filename
	private int idCount = 0;
	
	public void setFileName(String name){
		storageFilePath = name;
	}
	
	
	
	@Override
	public boolean contains(Object o) {
		if (!(o instanceof Player)) {
			return false;
		}
		Player pl = (Player) o;
		for(Player observable:storage) {
			if(observable.getName()==pl.getName()) {
				return true;
			}
		}
		
		return false;
	}



	//save to file
	public boolean saveToFile(){
		try {
			FileOutputStream fos = new FileOutputStream(storageFilePath); 
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(storage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//default constructor
	
	//load from file constructor
	public void create(String path){
		if(path == "default_path") path = storageFilePath;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			storage.addAll((IdStorage)ois.readObject());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// add method is here as the member of superclass
	
	//get by id
	public Player get(int id){
		Player result = null;
		for(Player l:storage){
			if(l.getId()==id){
				result = l;
				break;
			}
		}
		return result;
	}
	
	//get by name-password
	public Player get(String name,String password) {
		Player result = null;
		for(Player observablePl:storage){
			if(observablePl.match(name, password)){
				result = observablePl;
				break;
			}
		}
		return result;
	}
	
	//get same
	public Player get(Player pl) {
		Player result = null;
		for(Player observablePl:storage){
			if(observablePl.equals(pl)){
				result = observablePl;
				break;
			}
		}
		return result;
	}

}
