import java.util.HashMap;

import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {
	
	private HashMap<String,Person> database = new HashMap();
	
	public String createPerson(String firstname, String lastname)
	{
		Person temp = new Person(firstname, lastname);
		
		database.put(temp.getFirstname() + temp.getLastname(), temp);
		
		return "Person create!";
	}
	
	public String displayHealtProfile(String personId)
	{
		Person temp = database.get(personId);
		
		if(temp != null)
			return personId + "'s health profile is: " + temp.gethProfile().toString();
				
		return "Not found!";
	}
	
	public String updateHealtProfile(String personId, double height, double weight)
	{
		Person temp = database.get(personId);
		
		if(temp != null)
			temp.sethProfile(new HealthProfile(weight, height));
		else
			return "Person not found";
		
		return "Person create!";
	}
	
	public Double getPersonBMI(String personId)
	{
		return database.get(personId).gethProfile().getBMI();
	}
	
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
}