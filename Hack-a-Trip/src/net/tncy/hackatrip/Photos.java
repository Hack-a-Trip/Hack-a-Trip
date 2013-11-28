package net.tncy.hackatrip;

public class Photos {
	String url;
	String photo;
	
	public Photos(){
		
	}
	
	public String toString(String s){
		if(s.compareTo("activite")==0){
			return photo;
		}else{
			return url;
		}	
	}

}
