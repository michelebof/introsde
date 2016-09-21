import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {
	
	public static Map<Long,Person> database = new HashMap<Long,Person>();
	
	static
    {
		Person pallino = new Person();
		Person pallo = new Person(new Long(1), "Pinco", "Pallo", "1984-06-21");
		HealthProfile hp = new HealthProfile(68.0, 1.72);
		Person john = new Person(new Long(2), "John", "Doe", "1985-03-20", hp);

		database.put(pallino.getPersonId(), pallino);
		database.put(pallo.getPersonId(), pallo);
		database.put(john.getPersonId(), john);
    }
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//initializeDatabase();
		int argCount = args.length;
		if (argCount == 0) {
			System.out.println("I cannot create people out of thing air. Give me at least a name and lastname.");
		} else if (argCount == 1) {
			String id = args[0];
			displayHealtProfile(Long.valueOf(id));	
		} else if (argCount == 3) {
			Long id = Long.valueOf(args[0]);
			Double height = Double.valueOf(args[1]);
			Double weight = Double.valueOf(args[2]);
			updateHealtProfile(id, height, weight);
		}
		
	}
	
	//public static void initializeDatabase() {
	//	Person pallino = new Person();
	//	Person pallo = new Person("Pinco","Pallo");
	//	HealthProfile hp = new HealthProfile(68.0,1.72);
	//	Person john = new Person("John","Doe",hp);
	//	
	//	database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
	//	database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
	//	database.put(john.getFirstname()+" "+john.getLastname(), john);
	//}
	
	public static void createPerson(String firstname, String lastname, String birthdate){
		Long id = Math.round(Math.floor(Math.random()*9998)+1);
		Person p = new Person(id,firstname, lastname, birthdate);
		
		database.put(p.getPersonId(), p);
		
	}
	
	public static void displayHealtProfile(Long personId){
		Person p = database.get(personId);
		if (p!=null) { 
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString());
		} else {
			System.out.println(personId+" is not in the database");
		}
	}
	
	public static void updateHealtProfile(Long personId, Double height, Double weight){
		Person p = database.get(personId);
		if (p!=null) {
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile was: "+p.gethProfile().toString());
			HealthProfile hp = new HealthProfile(weight, height);
			p.sethProfile(hp);
			System.out.println("Now his/her health profile is: "+p.gethProfile().toString());
		} else {
			System.out.println(personId+" is not in the database");
		}
	}
}