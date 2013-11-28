package net.tncy.hackatrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;



public class API_outpost_travel {
	
	Place p;
	
	public API_outpost_travel() throws JSONException, UnsupportedEncodingException, IOException{
			Gson gson = new GsonBuilder().create();
			p = gson.fromJson(get("http://api.outpost.travel/placeRentals", "Paris"),Place.class);	
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
}