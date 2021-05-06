package com.server;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

 



import com.server.service.PersonService;

//This program  using Spring4.1 with Hibernate 4.1 and jackson ver2.1 libraries

/*Spring’s annotation based MVC framework simplifies the process of creating RESTful web 
services. 
The key difference between a traditional Spring MVC controller and the RESTful web service 
controller is the way the HTTP response body is created. 
While the traditional MVC controller relies on the View technology, 
the RESTful web service controller simply returns the object and the object 
data is written directly to the HTTP response as JSON/XML. 
  
*/
@RestController
@RequestMapping("/person")
public class PersonController {
	
	/*
	 * The asm.jar used here in web-inf/lib path ahs issues with higher versions of java than 1.6
	 * It throws the initial loading error illegal argumentexception in loading the class person
	 * To avoid this conflict with higher jvm versions keep the application properties  java compiler level to 1.6 .
	 */
	
	@Autowired
    private PersonService personService;

    @RequestMapping(value="getPersonPage",method = RequestMethod.GET)
	public ModelAndView getPersonView() {
    	System.out.println("PersonController.getPersonView()");

		/*ModelAndView modelView = new ModelAndView("personPage");		 
		modelView.addObject("person", new Person());	*/	
    	ModelAndView modelView = new ModelAndView("personPage");
		List list  = personService.listPersons();
		modelView.addObject("listPersons", list);	
		return modelView;
	}
     
    
        //The url is /rest/person/get{id}
        @RequestMapping(value = "/get/{id}", method=RequestMethod.GET)   //default http method is get		
		public @ResponseBody Person getById(@PathVariable int id) {
			System.out.println("PersonController.getById() "+id);
			Person person =  personService.getPersonById(id);
			System.out.println("The person returned by the controller  is  "+person);
			return person;
		}

		
        /* same as above method, but is mapped to
    	 * /rest/person/get?id= rather than /rest/person/get{id}
    	 */
    	@RequestMapping(value="/get", params="id")
    	@ResponseBody
    	public Person getByIdFromRequestParam(@RequestParam("id") int id) {
    		System.out.println("PersonController.getByIdFromRequestParam()");
    		Person person =  personService.getPersonById(id);
			System.out.println("The person returned by the controller  is  "+person);
			return person;
    	}
    	
    	@RequestMapping("/getDefaultPerson")
    	public Person getPersonDetail(@RequestParam(value = "id",required = false,
                defaultValue = "0") Integer id) {
    		Person p = new Person();
    		p.setId(id);
    		p.setCountry("India");
    		p.setName("rama");
			return p;
    	}
    	
    	///The url is /rest/person/list
		
		 
    	//@ResponseBody 
		@RequestMapping(method=RequestMethod.GET, value="/list")		
		public  List getAllPersons() {
			System.out.println("\n**** PersonController.getAllPersons()\n***\n");
			List personList  = personService.listPersons();	 
			System.out.println("The list returned is  "+personList);			 
			return personList;
		}
	@RequestMapping(value="/add",method = RequestMethod.POST)
	  public String addPerson(@RequestParam Map<String,String> requestParams) {
        System.out.println("PersonController.addPerson()");      
         
        String id = requestParams.get("id");
        Person  person = new Person();
        person.setCountry(requestParams.get("country"));
       // person.setId(Integer.parseInt(id));
        person.setName(requestParams.get("name"));
        System.out.println("The person details are  "+person);
        personService.addPerson(person);
		return null;
	}
	
	
	/*@RequestMapping(value="/insert", method=RequestMethod.POST,headers = {"content-type=application/json"})
	@ResponseBody
	public String addPerson(Person person) {
		System.out.println("Adding new person  "+person);
		personService.addPerson(person);
		return "Saved person: " + person.toString();
	}*/
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public String insertPerson(@RequestBody Person person) {			 
        
		System.out.println("Inserting new person  "+person);
		personService.addPerson(person);
		return "Inserted new person: " + person.toString();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody
	public String updatePerson(@RequestBody Person person) {
		System.out.println("PersonController.updatePerson() "+person.getId());
		personService.updatePerson(person);
		return "updated person: " + person.toString();
	}
	
	//The url is /rest/person/remove{id}
    @RequestMapping(value = "/remove/{id}", method=RequestMethod.DELETE)   
    @ResponseBody
	public String  deletePerson(@PathVariable int id) {
		System.out.println("PersonController.remove for  "+id); 
	 
		personService.removePerson(id);
		return "removed person with id =  "+id;
	}
    
	@RequestMapping(method=RequestMethod.GET, value="/getAllPersons")
	public ModelAndView getAll() {
		System.out.println("PersonController.getAll()");
		ModelAndView modelView = new ModelAndView("personPage");
		List list  = personService.listPersons();
		modelView.addObject("listPersons", list);		 
		return modelView;
	}
	
     
}