package net.tncy.hackatrip;

public class Items {
	int price;
	String origin;
	Photos[] photos;
	
	public Items(){
		
	}
	
	public String toString(){
		String p = Integer.toString(price);
		return "Ville : "+origin+"\n"+
				"Prix : "+p+"\n"+
				"Photos : "+photos[0].toString();		
	}
}
