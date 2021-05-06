
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

 
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.Person;

 

public class Rest_Client {

	public static final String SERVER_URI = "http://localhost:8080/Spring_REST_JSON/rest/person/";
	
	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
		
		 
		System.out.println("*****");
		testGetAllPersons();
		System.out.println("*****");
		testAddPerson();
		System.out.println("*****");
		testGetPerson();
		System.out.println("*****");
		testUpdatePerson();
		System.out.println("*****");
		testDeletePerson();
		System.out.println("*****");
		
		
	}

	private static void testGetAllPersons() {
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		List<LinkedHashMap> persons = restTemplate.getForObject(SERVER_URI+"list", List.class);
		 
		System.out.println(persons.size());
		for(LinkedHashMap map : persons){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",Country="+map.get("country"));;
		}
	}

	private static void testAddPerson() throws JsonGenerationException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();		 
		 
		HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.APPLICATION_JSON);    
		//  headers.setContentType(MediaType.APPLICATION_XML);    
		
		Person person = new Person();
		person.setId(105);
		person.setCountry("Austriya");
		person.setName("Vij");
		
		ObjectMapper mapper = new ObjectMapper();
		String output = mapper.writeValueAsString(person);
		System.out.println("The output json is  "+output);		
		
		HttpEntity request= new HttpEntity(output, headers);
		 
		//String response = restTemplate.postForObject(SERVER_URI+"insert", request, String.class);
		String response = restTemplate.postForObject(SERVER_URI+"insert", person, String.class); 
		
	    System.out.println(response);
	}
  
	private static void testGetPerson() {
		RestTemplate restTemplate = new RestTemplate();
		Person emp = restTemplate.getForObject(SERVER_URI+"get/105", Person.class);
		System.out.println("The person returned is  "+emp);
	}
  
	private static void testUpdatePerson() {
		RestTemplate restTemplate = new RestTemplate();
		
		Person person = new Person();
		person.setId(105);
		person.setCountry("UK");
		person.setName("Vij");
		 
		restTemplate.put(SERVER_URI+"update",person);
		System.out.println("The person updated  "+person);
	}
	
	private static void testDeletePerson() {
		RestTemplate restTemplate = new RestTemplate();
		int id = 105;
		restTemplate.delete(SERVER_URI+"remove/105");
		System.out.println("The person removed with id  "+id);
	}
  
}