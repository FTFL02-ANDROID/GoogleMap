package sam.limo.oopandroidproject;

public class Salary {
		public double basic;
		public double percentHouse;
		public double percentMedical;
		public double totalSalary;
		
		public void setBasic(double basic) {
			this.basic = basic; 
		}
		public void setPercentHouse(double percentHouse) {
			this.percentHouse = percentHouse; 
		}
		public void setPercentMedical(double percentMedical) {
			this.percentMedical = percentMedical; 
		}
		
		public double getMedicalAmount() {
			percentMedical /=100;
			return basic*percentMedical;
		}
		public double getHouseRent() {
			percentHouse /=100;
			return basic*percentHouse;
		}
		public double getTotalSalary() {
			return basic + (percentHouse*basic) + (percentMedical*basic);
		}
}
