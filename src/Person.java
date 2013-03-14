package familytree;

import java.util.ArrayList;

/**
 * Holds the details of an individual.
 * @author Matt McCouaig 11005773
 */
public class Person implements Comparable<Person> {

	// Instance variables. Only name, dob and birthplace are required by default.
	private String name, dob, birthplace, dateMarried = null, dateDivorced = null;
	private Person partner = null, mother = null, father = null, origMother = null, origFather = null;
	private ArrayList<Person> children = new ArrayList<Person>(5);
	private ArrayList<Person> divorcees = new ArrayList<Person>(5);
	private boolean adopted = false;
	// private boolean alive = true;

	/**
	 * Creates a new instance of Person
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
	 * Methods for adding/removing children and divorces below.
	 */
	
	public void addChild(Person child) {
		if(child != null) {
			if(!children.contains(child)) {
				children.add(child);
			} else {
				System.out.println("Error 418a - This child is already linked to the mother.");
			}
		} else {
			System.out.println("Error 418b - Please do not enter children without any details.");
		}
	}
	
	public void removeChild(Person child) {
		if(child != null) {
			if(children.contains(child)) {
				children.remove(child);
			} else {
				System.out.println("Error 419a - The child entered isn't linked to this parent.");
			}
		} else {
			System.out.println("Error 419b - Please do not enter children without any details.");
		}
	}
	
	public boolean addDivorce(Person exPartner, String dateofDivorce) {
		if(this.partner == exPartner) {
			divorcees.add(exPartner);
			this.partner = null;
			this.dateMarried = null;
			this.dateDivorced = dateofDivorce;
			return true;
		} else {
			return false;
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
	
	public void setBloodlineMother(Person mother) {
		this.origMother = mother;
	}

	public void setBloodlineFather(Person father) {
		this.origFather = father;
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

	public ArrayList<Person> getDivorcees() {
		return divorcees;
	}

	public boolean isAdopted() {
		return adopted;
	}
	
	public Person getBloodlineMother() {
		return origMother;
	}

	public Person getBloodlineFather() {
		return origFather;
	}
	
	/**
	 * Outputs simple details about a person, which then can be used to find their full details if needed.
	 * @return Name, Date of Birth and Birthplace in a formatted String.
	 */
	public String getBasicDetails() {
		return "\nName: " + this.name + ". DoB: " + this.dob + ". Birthplace: " + this.birthplace;
	}
	
	/*
	 * Overridden methods are below.
	 */
	
	@Override
	public int compareTo(Person o) {
		if(o == null) {
			return 0;
		} else if(this.name.equalsIgnoreCase(o.getName()) && this.dob.equalsIgnoreCase(o.getDob())) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * This will display the data available to it, and not the things it doesn't have.
	 */
	@Override
	public String toString() {
		String strNDB = "\nName: " + this.name + ". DoB: " + this.dob + ". Birthplace: " + this.birthplace;
		String strMFA = "", strPMD = "", strChild = "";
		
		// Mother, Father and Adoption states.
		if(this.mother != null) {
			strMFA += "\nMother: " + this.mother.getName();
		}
		if(this.father != null) {
			strMFA += "\nFather: " + this.father.getName();
		}
		strMFA += "\nAdopted: " + this.adopted;
		if(this.adopted) {
			if(this.origMother != null) {
				strMFA += "\nBiological Mother: " + this.origMother.getName();
			}
			if(this.origFather != null) {
				strMFA += "\nBiological Father: " + this.origFather.getName();
			}
		}
		// Partner, Marriage Date and Divorce Date, along with Last Partner if divorced.
		if(this.partner != null) {
			strPMD += "\nPartner: " + this.partner.getName() + ". Date Married: " + this.dateMarried;
		}
		if(!this.divorcees.isEmpty()) {
			strPMD += "\nPrevious Partner: " + divorcees.get(divorcees.size() - 1) + ". Date Divorced: " + this.dateDivorced;
		}
		// Children.
		if(!children.isEmpty()) {
			strChild = "\nChildren: ";
			for(Person p : this.children) {
				strChild += p.getName() + " ";
			}
		}
		return strNDB + strMFA + strPMD + strChild;
	}
	
}
