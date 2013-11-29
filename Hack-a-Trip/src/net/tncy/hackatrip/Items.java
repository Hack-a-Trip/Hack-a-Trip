package net.tncy.hackatrip;

public class Items {
	int price;
	String origin;
	String description;
	Photos[] photos;
	String url;
	String nid;
	
	public Items(){
		
	}
	
	public Items(String origin, int price, String url,String nid){
		this.origin=origin;
		this.price=price;
		this.url = url;
		this.nid = nid;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Photos[] getPhotos() {
		return photos;
	}

	public void setPhotos(Photos[] photos) {
		this.photos = photos;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
