package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * class handles input for the files and makes sure they are
 * read in correctly, else exception thrown
 */

public class InputOutput 
{	
	/*
	 * modified readRelationships to create a repository
	 * of type arrayList for the terms and pass boolean to addData() 
	 * to keep track of count of the times the
	 * file has been read in
	 */
	
	String CUI;
	String relationship;
	String CUI2;
	ArrayList<Relationships> relationships = new ArrayList<Relationships>();
	//ArrayList<Terms> terms = new ArrayList<Terms>();
	
	FileReader fileReader = null;
	String line = null;
	Scanner scanner = null;
	int count = 0;
	
	public boolean readRelations(String fileName, String comma)
	{
		try 
		{
			System.out.println("Number of lines terms in repository: " + relationships.size());
			scanner = new Scanner(new File(fileName));
			
			int count = 0;
			int numRelationships = 0;
			
			while(scanner.hasNextLine())
			{
				scanner.nextLine();
				numRelationships++;
			}
			
			numRelationships = numRelationships - 1;
			scanner.close();
			scanner = new Scanner(new File(fileName));
			int relationNum = 0;
			
			String header = scanner.nextLine();
			String[] headerBreak = header.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			
			String relationBreak = scanner.nextLine();
			String data[] = relationBreak.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			
			while(true){
				
				if(headerBreak[count].contains("CUI"))
				{
					CUI = (data[count]);
				}
				else
				{
					CUI = "";
				}
				if(headerBreak[count].contains("RELA"))
				{
					relationship = (data[count]);
				}
				else
				{
					relationship = "";
				}
				if(headerBreak[count].contains("CUI2"))
				{
					CUI2 = (data[count]);
				}
				else
				{
					CUI2 = "";
				}
				
				Relationships relation = new Relationships(CUI,relationship,CUI2);
				relationships.add(relation);
				count = -1;
				relationNum++;
				
				if( numRelationships == relationNum)
				{
					break;
				}
				
				relationBreak = scanner.nextLine();
				data = relationBreak.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				
				count++;
			}
			System.out.println("Added file to repository");
			System.out.println("Number of lines read: "+numRelationships);
			
			scanner.close();
			return true;
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open "+fileName);
		}
		return false;
	}
}
