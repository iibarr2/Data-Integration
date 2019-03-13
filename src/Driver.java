/**
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author israe
 *
 */

/*
 * class to handle user input and to manipulate the data
 */
public class Driver {

	static String[][] firstDataIn = new String[150][3];
	public static int firstDataInSize = 0;
	public boolean isThereAFile = false;
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
			char choice = userInput.nextLine().charAt(0);

			switch(choice) {
				
			case 'A':
			case 'a':
				System.out.println("Please enter file name: ");
				getFileInfo(userInput.nextLine());
				break;
			
			case 'R':
			case 'r':
				
				break;
				
			case 'T':
			case 't':
				
				break;
				
			case 'E':
			case 'e':
				
				break;
			
			}
			/*
			 * start switch case statements
			 */
							
		}
		

	}
	
	public static void getFileInfo(String fileName1) {
		
		File file = new File(fileName1);
		String line32 = null;
		try {
		    Scanner scanner = new Scanner(file);

		    //now read the file line by line...
		    int lineNum = 0;
		    int rowNum = 0;
		    int colNum = 0;
		    scanner.nextLine() ;
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        
		        if(line.isEmpty()) {
		        	continue;
		        }
		        String[] arrOfStr = line.split(","); 
		        for (String element : arrOfStr) {
		        	
		        	firstDataIn[rowNum][colNum] = element;
		        	colNum++;
		            System.out.println(element);
		        }
		        if(colNum == 3) {
		        	colNum = 0;
		        }
		        
		        rowNum++;
		        firstDataInSize++;
		        lineNum++;
		     
		    }
		} catch(FileNotFoundException e) { 
		    System.out.println("No file found");
		}
		System.out.println(firstDataInSize);
	}
	
	

}
