package com.example.simplerestapis.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.models.SampleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WebController {

	@RequestMapping(value = "/input")
	public String name(@RequestParam(name = "name") String name) throws MalformedURLException {
		List<String> l = null;
		System.out.println("name1" + name);
		String cities = "";
		try {
			
			URL obj = new URL(
					"https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b8dfa918d701e0fdf762cde4dc0b7df6");

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			StringBuffer response = null;
			
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code ---> :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				name = name.toUpperCase();
				// print result
				JSONObject jo = new JSONObject(response.toString());
				JSONArray ja = (JSONArray) jo.get("list");
				l = new ArrayList();
				for (int i = 0; i < ja.length(); i++) {
					JSONObject object = ja.getJSONObject(i);
					l.add(object.getString("name"));
					System.out.println(object.getString("name"));
				}

				for (String city : l) {
					if (city.startsWith(name)) {
						cities = cities + " " + city;
						System.out.println("output is : " + city);
					}
				}

				//System.out.println("output is : " + cities);
				return cities;
			} else {
				System.out.println("GET request not worked");
			}
			// return l.;
		} catch (Exception e) {
			return null;
		}
		return null;

	}

}