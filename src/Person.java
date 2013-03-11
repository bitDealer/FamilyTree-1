package familytree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds the details of an individual. You need to complete this class
 * <Only first name is held. Useful.>
 * @author David / MATTLOL
 */
public class Person implements Comparable<Person> {

	// Instance variables. Only name, dob and birthplace are required by default.
	private String name, dob, birthplace, dateMarried = null, dateDivorced = null;
	private Person partner = null, mother = null, father = null;
	private ArrayList<Person> children = new ArrayList<Person>();
	private HashMap<Person, String[]> divorcees = new HashMap<Person, String[]>();
	private boolean adopted = false;
	// private boolean alive = true;

	/** 
	 * Constructor(s) for the Person class.
	 * Creates a new instance of Person 
	 */
	public Person() {
		// Why does this exist? I never want an empty person... Seems odd.
		// Maybe it's 'cause some people have no souls?
		// Maybe that's right.
		// Maybe it's to create a blank one, add attributes and compare to existing ones. <--
	}

	/**
	 * @param aName - Name of the person.
	 * @param aDOB - Date of birth of the person.
	 * @param aBirthPlace - Where the person was born.
	 */
	public Person(String aName, String aDOB, String aBirthPlace) {
		this.name = aName;
		this.dob = aDOB;
		this.birthplace = aBirthPlace;
	}
	
	/*
	 * Methods for adding children and divorces below.
	 */
	
	public void addChild(Person child) {
		if(child != null) {
			if(!children.contains(child)) {
				children.add(child);
			}
		} else {
			System.out.println("Error 417 - Please do not enter children without any details. <DEV NOTE - Failed at addChild()>");
		}
	}
	
	public void addDivorce(Person exPartner, String dateofDivorce) {
		if(this.partner == exPartner) {
			String[] divorce = new String[] {dateMarried, dateofDivorce};
			divorcees.put(partner, divorce);
			this.partner = null;
			this.dateMarried = null;
			this.dateDivorced = dateofDivorce;
		}
	}
	
	/*
	 * Setters are below.
	 */
	
	public void setDateMarried(String dateMarried) {
		this.dateMarried = dateMarried;
	}

	public void setDateDivorced(String dateDivorced) {
		this.dateDivorced = dateDivorced;
	}

	public void setPartner(Person partner) {
		this.partner = partner;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	/*
	 * Getters are below.
	 */

	public ArrayList<Person> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public String getDateMarried() {
		return dateMarried;
	}

	public String getDateDivorced() {
		return dateDivorced;
	}

	public Person getPartner() {
		return partner;
	}

	public Person getMother() {
		return mother;
	}

	public Person getFather() {
		return father;
	}

	public HashMap<Person, String[]> getDivorcees() {
		return divorcees;
	}

	public boolean isAdopted() {
		return adopted;
	}

	@Override
	public int compareTo(Person o) {
		if(this.name == o.name && this.dob == o.dob && this.mother == o.mother) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		// TODO
		String str = "Name: " + this.name + ". DoB: " + this.dob + ". Birthplace: " + this.birthplace + ".";
		return str;
	}
	
}
