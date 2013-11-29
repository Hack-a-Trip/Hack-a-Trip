package net.tncy.hackatrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.tncy.servlet.DisplayDetailsTravel;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;



public class API_outpost_travel {

	private Place p;
	private Activite a;
	private ArrayList<String> origin = new ArrayList<String>();
	private ArrayList<String> photo = new ArrayList<String>();
	private ArrayList<String> prix = new ArrayList<String>();
	private ArrayList<Items> liste_item = new ArrayList<Items>();


	public API_outpost_travel() throws JSONException, UnsupportedEncodingException, IOException{

	}

	public void getInfoLieux(String ville,int budget) throws JsonSyntaxException, IOException, JSONException{
		Gson gson = new GsonBuilder().create();
		setP(gson.fromJson(get("http://api.outpost.travel/placeRentals", ville),Place.class));
		for(int i =0;i<p.items.length;i++){
			if(p.items[i].price <= budget){
				Items temp = new Items(p.items[i].origin,p.items[i].price,p.items[i].photos[0].url,p.items[i].nid,p.items[i].link);
				liste_item.add(temp);
			}
		}

	}

	public void getInfoExperiences(String ville) throws JsonSyntaxException, IOException, JSONException{
		Gson gson = new GsonBuilder().create();
		setA(gson.fromJson(get("http://api.outpost.travel/experiences", ville),Activite.class));
	}
	
	public void updateLocationsVoted(List<String> locationsVoted)
	{
		for(Items e : liste_item)
			e.updateLocationsVoted(locationsVoted);
	}

	public static String get(String url_web, String city) throws IOException, JSONException{

		//FAUT METTRE LA PREMIERE LETTRE EN MAJUSCULE
		char[] char_table = city.toCharArray();
		char_table[0]=Character.toUpperCase(char_table[0]);
		city = new String(char_table);
		//FIN

		if(city.contains(" ")){

			city = city.replaceAll(" ", "%20");
			for(int i=0;i<city.length();i++){
				if(city.charAt(i)=='0'){
					char_table = city.toCharArray();
					char_table[i+1] = Character.toUpperCase(char_table[i+1]);
					city = new String(char_table);
				}
			}
		}
		String source ="";
		URL url = new URL(url_web+"?city="+city);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						url.openStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			source +=inputLine;
		in.close();
		return source;
	}

	public Place getP() {
		return p;
	}

	public void setP(Place p) {
		this.p = p;
	}


	public Activite getA() {
		return a;
	}

	public void setA(Activite a) {
		this.a = a;
	}

	public ArrayList<String> getOrigin() {
		return origin;
	}

	public void setOrigin(ArrayList<String> origin) {
		this.origin = origin;
	}

	public ArrayList<String> getPrix() {
		return prix;
	}

	public void setPrix(ArrayList<String> prix) {
		this.prix = prix;
	}

	public ArrayList<String> getPhoto() {
		return photo;
	}

	public void setPhoto(ArrayList<String> photo) {
		this.photo = photo;
	}

	public ArrayList<Items> getListe_item() {
		return liste_item;
	}

	public void setListe_item(ArrayList<Items> liste_item) {
		this.liste_item = liste_item;
	}
}
