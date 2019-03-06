

/*
 * creates terms objects
 */

public class Terms 
{
	String CUI;
	String CUIName;
	
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
	 * getters and setters for the variables
	 */
	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public String getCUIName() {
		return CUIName;
	}

	public void setCUIName(String cUIName) {
		CUIName = cUIName;
	}
	
	public String toString()
	{
		return String.format("\n%-6d%-13s%",this.CUI,  this.CUIName);
	}

}
