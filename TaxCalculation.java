import java.util.Scanner;

public class TaxCalculation{
	
	public static int calculateSalary(int hour, int experience){
		int Salary = 0;
		double bonus = 0;
		double tax = 0;
		if (hour < 30) {
			Salary += 20 * hour;
		}
		if ((hour >= 30) && (hour <= 40)) {
			Salary += 30 * hour;
		}
		if (hour > 40) {
			Salary += 40 * 1200;
			Salary += (hour - 40) * 50;
		}
		if (experience < 5) {
			bonus = Salary * 0.02;
			Salary += (int)bonus;
		}
		if (experience >= 5) {
			bonus = Salary * 0.05;
			Salary += (int)bonus;
		}
		
		if (Salary <= 600) {
			tax = Salary * 0.1;
			Salary -= (int) tax;
		}
		else {
			tax = Salary * 0.15;
			Salary -= (int) tax;
		}
		
		
		
		return Salary;
		}
		
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int hour;
		int experience;
		
		System.out.println("Input Hour.");
		hour = sc.nextInt();
		
		System.out.println("Input Experience.");
		experience = sc.nextInt();
		int salary = calculateSalary(hour, experience);
		
		System.out.println("Total Weekly Salary is = " + salary);
	}
}