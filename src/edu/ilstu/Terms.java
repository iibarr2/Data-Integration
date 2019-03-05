package edu.ilstu;

/*
 * creates terms objects
 */

public class Terms 
{
	private String CUI;
	private String CUIName;
	
	/*
	 * two constructors one that accepts only terms
	 * the other accepts terms and their relation
	 */
	public Terms(String CUI, String CUIName)
	{
		super();
		this.CUI = CUI;
		this.CUIName = CUIName;
	}
	
	/*
	 * constructor for the relationship terms
	 */
	public Terms(String CUI)
	{
		super();
		this.CUI =CUI;
	}
	
	/*
	 * getters and setters for the variables
	 */
	public String getCUI() {
		return CUI;
	}

	public void setCUI(String CUI) {
		this.CUI = CUI;
	}

	public String getCUIName() {
		return CUIName;
	}

	public void setCUIName(String CUIName) {
		this.CUIName = CUIName;
	}
	
	public String toString()
	{
		return String.format("\n%-6d%-13s%",this.CUI,  this.CUIName);
	}

}
