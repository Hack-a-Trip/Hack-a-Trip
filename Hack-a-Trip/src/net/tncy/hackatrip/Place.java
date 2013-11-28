package net.tncy.hackatrip;

public class Place {
	Items[] items;
	
	public Place (){
	}
	
	public String toString(){
		String s="";
		for(int i=0;i<items.length;i++){
			s += " "+items[i].toString();
		}
		return s;
	}
	
}
