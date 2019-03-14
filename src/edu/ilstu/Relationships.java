/**
 * 
 */
package edu.ilstu;

/**
 * @author israe
 *
 */

/*
 * represents a relationship of terms and related methods
 * keeps track of what CUI is called
 */
public class Relationships 
{
	
	/*
	 * variables
	 */
	String CUI;
	String CUI2;
	//String CUI;
	String relation;
	//String CUI2;
	
	/*
	 * creates relationships array
	 */
	public Relationships(String CUI, String relation, String CUI2)
	{
		super();
		this.CUI = CUI;
		this.relation = relation;
		this.CUI2 = CUI2;
	}
	
	/*
	 * getters and setters for the variables
	 */
//	public String getCUI() {
//		return CUI;
//	}
//
//	public void setCUI(String CUI) {
//		this.CUI = CUI;
//	}
	
	

	public String getRelation() {
		return relation;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String CUI) {
		this.CUI = CUI;
	}

	public String getCUI2() {
		return CUI2;
	}

	public void setCUI2(String CUI2) {
		this.CUI2 = CUI2;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

//	public String getCUI2() {
//		return CUI2;
//	}
//
//	public void setCUI2(String CUI2) {
//		this.CUI2 = CUI2;
//	}
	
	public String toStringRel()
	{
		return String.format("\n%-6d%-13s%-18s",this.CUI,  this.relation,  this.CUI2);
	}
	
	
	

}
