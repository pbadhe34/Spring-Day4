package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

//import org.json.JSONObject;

public class REST_JSON_Client {

	public static void main(String[] args) throws IOException {
		/*System.out.println("*** GET Person Resonse as JSON **");

		URL getUrl = new URL("http://localhost:8080/Spring4-REST-Service/rest/person/get/1");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

		// Get json structure of customer object from the service

		connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		System.out.println("The response code is  " + connection.getResponseCode());

		System.out.println("The response content type is " + connection.getContentType());

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		System.out.println("\nThe JSON format of response sent by server...\n");

		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		connection.disconnect();*/
		
		System.out.println("*** GET All Persons Resonse as JSON **");
		
		URL getUrl = new URL("http://localhost:8080/Spring4-REST-Service/rest/person/list");
		 
		// Get json structure of customer object from the service

		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		System.out.println("The response code is  " + connection.getResponseCode());

		System.out.println("The response content type is " + connection.getContentType());

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		System.out.println("\nThe JSON format of response sent by server...\n");

		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		connection.disconnect();
		
		      /*// post new Person as json object
				System.out.println("*** POST New Person as JSON **");
				 
				URL postUrl = new URL("http://localhost:8080/Spring4-REST-Service/rest/person/insert");

				HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

			 	 
				//String newPerson="{\"id\":\"234\",\"name\":\"More\",\"country\":\"Magadh\"}";
				
				//System.out.println("The new Person string structure to be sent is " + newPerson);

				// we can also use json object as map translator
				JSONObject obj = new JSONObject();
				obj.put("id", "345");
				obj.put("name", "mallya");				 	 
				obj.put("country", "Brow");

				String dataJson = obj.toString();
				System.out.println("The oputput json object sent is  " + dataJson);

				OutputStream os = conn.getOutputStream();
			    //os.write(newPerson.getBytes());
				os.write(dataJson.getBytes());
				os.flush();
				System.out.println("The http status respopnse in post code is  " + conn.getResponseCode());

		 
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output = null;
				System.out.println("Output from the Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();*/
		
		      /*// Update Person as  json object
				System.out.println("*** Update Person as JSON **");
			    URL updateUrl = new URL("http://localhost:8080/Spring4-REST-Service/rest/person/update");

				HttpURLConnection conn2 = (HttpURLConnection) updateUrl.openConnection();
				conn2.setDoOutput(true);
				conn2.setRequestMethod("PUT");
				conn2.setRequestProperty("Content-Type", "application/json");
				// conn.setInstanceFollowRedirects(false);

				 
				// we can  use json translator
				JSONObject obj1 = new JSONObject();
				obj1.put("id", "6");
				obj1.put("name", "Madhav");				 
				obj1.put("country", "Bara");

				String dataJson1 = obj1.toString();
				System.out.println("The oputput sent is  " + dataJson1);

				OutputStream os1 = conn2.getOutputStream();
				os1.write(dataJson1.getBytes());
				os1.flush();
				System.out.println("The http status respopnse in post code is  " + conn2.getResponseCode());

			 
				BufferedReader br2 = new BufferedReader(new InputStreamReader((conn2.getInputStream())));

				String output = null;
				System.out.println("Output from the Server .... \n");
				while ((output = br2.readLine()) != null) {
					System.out.println(output);
				}

				conn2.disconnect();*/
		
		      // Delete person request
				System.out.println("*** Delete Person as id **");

				URL deleteUrl = new URL("http://localhost:8080/Spring4-REST-Service/rest/person/remove/4");

				HttpURLConnection con = (HttpURLConnection) deleteUrl.openConnection();
				con.setDoOutput(true);
				con.setRequestMethod("DELETE");
				// con.setRequestProperty("Content-Type", "application/json");
				// con.setInstanceFollowRedirects(false);

				System.out.println("The response code in delete opeartion is  " + con.getResponseCode());

			 
				BufferedReader reader2 = new BufferedReader(new InputStreamReader(con.getInputStream()));

				line = null;
				line = reader2.readLine();
				while (line != null) {
					System.out.println(line);
					line = reader2.readLine();
				}
				con.disconnect();				
				
	}

		 

}
