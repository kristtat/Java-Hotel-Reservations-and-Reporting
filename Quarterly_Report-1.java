//import Scanner
import java.util.Scanner;
import java.math.*;
//Class Quarterly_Report
public class Quarterly_Report {
	
	//variables as counters for all departments
	private int quarterSalesElectrical = 0;
	private int quarterSalesKitchen = 0;
	private int quarterSalesBathroom = 0;
	private int quarterSalesSoftFurnishing = 0;
	private int quarterSalesAccessories = 0;


	//method for setting report data titled getQuarterlyDataPerDepartment()
	public void getQuarterlyDataPerDepartment() {
		
				//ask user for department, give options
		System.out.println("Welcome to your quarterly sales calculator.");
		System.out.println("In order to use the calculator, you will be required to enter the monthly sales figures for each individual department.\n");
		
		String[] departments = {"electrical", "kitchen", "bathroom", "soft furnishings", "accessories"};
		for (String department : departments) {
			System.out.println("Sales data for the " + department + " department.");
			Scanner keyboard = new Scanner(System.in);
					
			for (int month = 1; month <= 3; month++) {
				
				System.out.println("Please enter the sales for month number " + month + " of the quarter in thousands.\n");
				
				
				while (true) {
					
					if (keyboard.hasNextInt()) {
						int userInput = keyboard.nextInt();
					
						switch(department) {
						case "electrical":
							switch(month) {						
						case 1:
							quarterSalesElectrical += userInput;
							break;
						case 2: quarterSalesElectrical += userInput;
							break;
						case 3: quarterSalesElectrical += userInput;
							break;
						}
						break;
						
						
						case "kitchen":
							switch(month) {						
						case 1:
							quarterSalesKitchen += userInput;
							break;
						case 2: 
							quarterSalesKitchen += userInput;
							break;
						case 3: 
							quarterSalesKitchen += userInput;
							break;
						}
						break;
						
						
						case "bathroom":
							switch(month) {						
						case 1:
							quarterSalesBathroom += userInput;
							break;
						case 2: 
							quarterSalesBathroom += userInput;
							break;
						case 3: 
							quarterSalesBathroom += userInput;
							break;
						}
						break;
						
						
						case "soft furnishings":
							switch(month) {						
						case 1:
							quarterSalesSoftFurnishing += userInput;
							break;
						case 2: 
							quarterSalesSoftFurnishing += userInput;
							break;
						case 3: 
							quarterSalesSoftFurnishing += userInput;
							break;
						}
						break;
						
						
						case "accessories":
							switch(month) {						
						case 1:
							quarterSalesAccessories += userInput;
							break;
						case 2: 
							quarterSalesAccessories += userInput;
							break;
						case 3: 
							quarterSalesAccessories += userInput;
							break;
						}
						break;
						}
						break;
						
						} else {
						System.out.println("Invalid input, please enter a number without decimal points.");
						keyboard.next();
					}}}}}

			
			public void getTotalSalesPerDepartment() {
				
				System.out.println("Total sales for the quarter were as follows: \n");
				System.out.println("Electrical: " + quarterSalesElectrical + " thousand.");
				System.out.println("Kitchen: " + quarterSalesKitchen + " thousand.");
				System.out.println("Bathroom: " + quarterSalesBathroom + " thousand.");
				System.out.println("Soft Furnishing: " + quarterSalesSoftFurnishing + " thousand.");
				System.out.println("Accessories: " + quarterSalesAccessories + " thousand.");
				System.out.println("\n");
			}
			
			public int getTotalQuarterlySales() {
				int totalSales = quarterSalesElectrical + quarterSalesKitchen + quarterSalesBathroom + quarterSalesSoftFurnishing + quarterSalesAccessories;
				return totalSales;
			}
			
			public double calculateQuarterlyTax() {
			//Given the total sales for each quarter, calculate the tax that needs to be paid at 17%.
				double quarterlyTax = getTotalQuarterlySales() * 0.17;
				return quarterlyTax;
			}
			
			public void getQuarterlyTax() {
				
				System.out.println("The sales tax for the quarter is " + calculateQuarterlyTax() + " thousand.\n");
			}
		
				
			public void getSalesTargetNextQuarter() {
				double electricSalesNextQ = Math.round(quarterSalesElectrical * 1.12);
				System.out.println("Total sales targets for the next quarter are as follows: \n");
				System.out.println("Electrical: " + electricSalesNextQ + " thousand.");
				
				double kitchenSalesNextQ = Math.round(quarterSalesKitchen * 1.12);
				System.out.println("Kitchen: " + kitchenSalesNextQ + " thousand.");
				
				double bathroomSalesNextQ = Math.round(quarterSalesBathroom * 1.12);
				System.out.println("Bathroom: " + bathroomSalesNextQ + " thousand.");
				
				double softFurnishingSalesNextQ = Math.round(quarterSalesSoftFurnishing * 1.12);
				System.out.println("Soft Furnishing: " + softFurnishingSalesNextQ + " thousand.");
				
				double accessoriesSalesNextQ = Math.round(quarterSalesAccessories * 1.12);
				System.out.println("Accessories: " + accessoriesSalesNextQ + " thousand.");
			}

			
	public static void main(String[] args) {
		Quarterly_Report report = new Quarterly_Report();
			report.getQuarterlyDataPerDepartment();
			report.getTotalSalesPerDepartment();
			report.getQuarterlyTax();
			report.getSalesTargetNextQuarter();
			
		}}

