package net.tncy.hackatrip;

public class Items {
	int price;
	String origin;
	String description;
	Photos[] photos;
	
	public Items(){
		
	}
	
	public String toString(String s){
		if(s.compareTo("place")==0){
		String p = Integer.toString(price);
		return "Ville : "+origin+"\n"+
				"Prix : "+p+"\n"+
				"Photos : "+photos[0].toString(s);	
		}else{
			return "Ville : "+origin+"\n"+
					"Description : "+description+"\n"+
					"Photos : "+photos[0].toString(s);
		}
	}
}
