package net.tncy.hackatrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;



public class API_outpost_travel {
	
	private Place p;
	private Activite a;


	public API_outpost_travel() throws JSONException, UnsupportedEncodingException, IOException{
				
	}
	
	public void getInfoLieux(String ville) throws JsonSyntaxException, IOException, JSONException{
		Gson gson = new GsonBuilder().create();
		setP(gson.fromJson(get("http://api.outpost.travel/placeRentals", ville),Place.class));
	}
	
	public void getInfoExperiences(String ville) throws JsonSyntaxException, IOException, JSONException{
		Gson gson = new GsonBuilder().create();
		setA(gson.fromJson(get("http://api.outpost.travel/experiences", ville),Activite.class));
	}

	public static String get(String url_web, String city) throws IOException, JSONException{

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
}