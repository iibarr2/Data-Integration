

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * class handles input for the files and makes sure they are
 * read in correctly, else exception thrown
 */

public class InputOutput 
{
	private Scanner keyboard = new Scanner(System.in);
	
	/*
	 * Reads the lines from the Terms.csv file
	 * parses them and creates objects
	 * @param terms
	 * @return size
	 */
	
	public int readTerms(Terms[] terms)
	{
		final String FILENAME = "Terms.csv";
		int size = 0;
		
		Scanner input = null;
		try
		{
			input = new Scanner(new File(FILENAME));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file " +FILENAME);
		}
		
		String line = input.nextLine();
		
		/*
		 * variable names to be used for certain files
		 */
		String CUI;
		String CUIName;
		
		while(input.hasNext() && size < terms.length)
		{
			line = input.nextLine();
			String[] record = line.split(",");
			
			CUI = record[0];
			CUIName = record[1];
		}//end while
		input.close();
		return size;
	}
	
	/*
	 * Reads the lines from all three relationships.csv files
	 * parses them and creates objects, combining all three together
	 * and taking empty spaces into consideration
	 * @param terms
	 * @return size
	 */
	
//	public int readRelationships(Relationsships[] relations)
//	{
//		
//	}

}
