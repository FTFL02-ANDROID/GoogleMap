package sam.limo.oopandroidproject;

public class Person {
	
	//	HAS:
		public String firstName;
		public String middleName;
		public String lastName;
		
	//	DOES:	
		public String getFullName() {
			return firstName + " " + middleName + " " + lastName;
		}
		
		public String getReverseName() {
			String fullName = getFullName();
			
			String revName = new StringBuilder(fullName).reverse().toString();
			return revName;
		}
}
