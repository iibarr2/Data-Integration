/**
 * 
 */


import java.util.Scanner;

/**
 * @author israe
 *
 */

/*
 * class to handle user input and to manipulate the data
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userInput = new Scanner(System.in);
		
		InputOutput io = new InputOutput();
		
		
		
		
		/*
		 * prompt user for input and displays menu
		 * upon selecting an option
		 */
		boolean num = false;
		while(!num)
		{
			System.out.print("\nBiomedical Concepts Data\n"
							+ "\n('A' or 'a') Add Data\n"
							+ "('R' or 'r') Save data for a relationship\n"
							+ "('T' or 't') Save data for medical terms\n"
							+ "('E' or 'e') Exit Program\n"
							+ "\nEnter choice from above: ");
			
			/*
			 * grab the userinput and call methods for what they chose
			 * from the above
			 */
			String choice = userInput.nextLine();
			
			/*
			 * start switch case statements
			 */
							
		}
		

	}

}
