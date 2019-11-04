package com.alm.application.ALM.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	/*@Autowired
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("admin") && password.equalsIgnoreCase("dummy");
	}*/
	
	OutputStream os =null;
	String jsonInput = "{\"name\":\"Ja12va2novice\",\"salary\":\"123\","+
            "\"age\":\"23\",\"id\":\"789\"}";
	 BufferedReader reader = null;
	
	@Autowired
	public void UrlOpenConnect() throws IOException  {
		URL url = new URL("http://mocktarget.apigee.net/echo");
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		System.out.println(conn);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		if(conn.getResponseCode()!=200) {
			throw new RuntimeException("Failed : HTTP error Code"+conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		//conn.disconnect();
		
	  

	
		//return (ResponseBody) conn;
		
	}
	@Autowired
	public void showPostmethod() throws IOException {
		
		URL url = new URL("http://dummy.restapiexample.com/api/v1/create");
		
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		System.out.println(conn);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		
		os = conn.getOutputStream();
		os.write(jsonInput.getBytes());
		os.flush();
		if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK) {
			System.err.println("URL cannot be connected");
			return;
		}
		 System.out.println("Connected to the server...");
         InputStream is = conn.getInputStream();
         System.out.println(conn.getResponseCode());
         reader = new BufferedReader(new InputStreamReader((is)));
         String tmpStr = null;
         while((tmpStr = reader.readLine()) != null){
             System.out.println(tmpStr);
		
		
		
		
	}
	
}
	}
