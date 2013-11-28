package net.tncy.hackatrip;

public class Activite {
	Items[] items;
	
	public Activite(){
		
	}
	
	public String toString(String a){
		String s="";
		for(int i=0;i<items.length;i++){
			s += items[i].toString(a)+"\n\n";
		}
		return s;
	}

}
