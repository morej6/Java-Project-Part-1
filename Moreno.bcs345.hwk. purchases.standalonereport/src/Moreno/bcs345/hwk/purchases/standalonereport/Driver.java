package Moreno.bcs345.hwk.purchases.standalonereport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;
	/**
	 * Contains main program code. This class generates a report
	 * for a single customer’s purchases.
	 * 
	 * @author Juan Moreno
	 * @version 1.0
	 * @since 9/20/16
	 */
public class Driver {
	
	/**
	 * Main is where the code is run.
	 * @param args contains the command-line arguments
	 */
	
	public static void main(String[] args){
		
		//Variable list
		//*********************************************************************
		String firstName; //firstName holds the first name of the customer.
		String lastName; //lastName holds the last name of the customer.
		String houseNumber; //houseNumber holds the number address of the customer.
		String street; // street holds the name of the street of the customer.
		String city; //city holds the name of the city where customer lives.
		String state; //state holds the name for the state where customer lives.
		String zip; //zip holds the Zip code of the customer. 
		String ProductDescription = null; //ProductDescription holds the information of each product.
		double productPrice = 0; //productPrice holds the price of each item.
		int productQuantity = 0; //productQuantity holds the number of item bought. 
		double cost = 0; //cost holds the amount each item cost.
		double totalQ = 0; //totalQ is the sum of productQuanity.
		double totalC = 0; //totalC is the sum of the price of all the items. 
		//*************************************************************************************
		
		// Using Scanner to read user input and storing it into variable UserInput
		Scanner UserInput = new Scanner(System.in);
		System.out.print("Enter file name:");
		String infile = UserInput.nextLine();
		//Initializing Scanner sc to null.
		Scanner sc = null;
		
		//Try and catch block are used for exception handling. 
		try
		{
			FileReader fr = new FileReader(new File(infile)); //fileReader is used to read the file  
			 sc = new Scanner(fr);
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not found");
		}

		System.out.print("Enter outfile name:");
		String outfile = UserInput.nextLine();
		
		
		PrintStream ps = null; //PrinStream is used to print a text file.
		try {
			ps = new PrintStream(outfile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		String D = "Description", P= "Price",Q= "Quantity", C= "Cost";
		String filler = "-----------";
		firstName= sc.nextLine(); //Reading in the first name from the inputfile
		lastName = sc.nextLine(); //Reading in the last name from the inputfile
		houseNumber = sc.nextLine(); //Reading in the house number from the inputfile
		street = sc.nextLine(); //Reading in the street from the inputfile
		state = sc.nextLine(); //Reading in the state  from the inputfile
		city = sc.nextLine(); //Reading in the city  from the inputfile
		zip = sc.nextLine(); //Reading in the zip code from the inputfile
		
		//Using ps to print to the outfile
		ps.printf("Purchase Report\n");
		ps.printf("---------------\n");
		ps.println(firstName +" " +lastName);
		ps.println(houseNumber+" "+street);
		ps.println(state+", "+city+" "+zip);
		ps.println();
		ps.printf("%-30s %12s %10s %12s\n", D, P, Q, C);
		ps.printf("%-30s %12s %10s %12s\n", filler, filler, filler, filler);
		while(sc.hasNext())
		{
			ProductDescription = sc.nextLine(); //Reading in product description from inputfile
			productPrice = Double.parseDouble(sc.nextLine()); // Reading in product price and being converted to a double.
			productQuantity = Integer.parseInt(sc.nextLine()); // Reading in product quntity and being converted to a double.
			cost = productPrice / productQuantity; //Multiplying productPrice and productQuanity to get item cost.
			totalQ = productQuantity + totalQ; //Adding productQuantity and toalQ to get the total sum of all items.
			totalC = cost + totalC; //Adding cost and totalC to get total cost.
			//Printing results to text file.
			ps.printf("%-30s %12s %10d %12s\n",ProductDescription, productPrice ,productQuantity, cost);
			
		}
		//Printing results to text file.
		ps.printf("%-30s %12s %10s %12s\n", filler, filler, filler, filler);
		ps.printf("Total %48.0f %12.2f\n", totalQ, totalC);
		//Closing Scanners.
		sc.close();
		UserInput.close();
		
	}

}
