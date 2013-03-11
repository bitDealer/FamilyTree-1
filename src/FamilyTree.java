package familytree;

import java.util.ArrayList;

/**
 * Once complete this class manages a family tree. You need to complete the
 * methods whose headers are given here.
 * 
 * @author cjberry
 */
public class FamilyTree {

	private ArrayList<Person> family;
	
	public FamilyTree() {
		family = new ArrayList<Person>();
	}

	/**
	 * Adds a person to the family tree
	 * 
	 * @param aPerson
	 *            Person to be added
	 */
	public void addPerson(Person aPerson) {
		// Go through each and use compareTo() if this fails.
		if(!family.contains(aPerson)) {
			family.add(aPerson);
		} else {
			System.out.println("Error 314 - Person already in the family tree. <DEV NOTE - Duplicates, means addPerson() works...");
		}
	}

	/**
	 * Links an individual to their mother. Both the individual and the mother
	 * need already to appear as a Person in the family tree.
	 * 
	 * @param aPerson
	 *            String holding individual's name
	 * @param aDOB
	 *            String holding individual's date of birth
	 * @param mName
	 *            String holding mother's name
	 * @param mDOB
	 *            String holding mother's date of birth
	 */
	public void makeLinkToMother(String aPerson, String aDOB, String mName,
			String mDOB) {
		// Possible break here.
		Person child = null, mum = null;
		for(int i = 0; i < family.size(); i++) {
			System.out.println(aPerson + aDOB + mName + mDOB);
			System.out.println(family.get(i).getName() + family.get(i).getDob());
			if(family.get(i).getName() == aPerson && family.get(i).getDob() == aDOB) {
				child = family.get(i);
				System.out.println("CHILD IS GOT - " + child.getName());
			} else if(family.get(i).getName() == mName && family.get(i).getDob() == mDOB) {
				mum = family.get(i);
				System.out.println("MOTHER IS GOT - " + mum.getName());
			}
		}
		if(child != null && mum != null) {
			child.setMother(mum);
			mum.addChild(child);
		} else {
			System.out.println("Error 369 - Child and/or Mother doesn't exist in the tree. <DEV NOTE - " +
					"One of them is null. Test here.");
		}
		// Check for each person in the tree.
		// If in tree, add mother to aPerson's Person object.
		// If not, send out error.
	}

	/**
	 * Links an individual to their father. Both the individual and the mother
	 * need already to appear as a Person in the family tree.
	 * 
	 * @param aPerson
	 *            String holding individual's name
	 * @param aDOB
	 *            String holding individual's date of birth
	 * @param fName
	 *            String holding father's name
	 * @param fDOB
	 *            String holding father's date of birth
	 */
	public void makeLinkToFather(String aPerson, String aDOB, String fName,
			String fDOB) {
		// Same as above for commenting.
	}

	/**
	 * Links a newly married couple. Each member of the couple needs already to
	 * appear as a Person in the family tree.
	 * 
	 * @param partner1Name
	 *            String holding bride's name
	 * @param aDOB1
	 *            String holding bride's date of birth
	 * @param partner2Name
	 *            String holding groom's name
	 * @param aDOB2
	 *            String holding groom's date of birth
	 */
	public void recordWedding(String partner1Name, String aDOB1,
			String partner2Name, String aDOB2) {
		
	}

	/**
	 * Records a divorce. Each member of the couple needs already to appear as a
	 * Person in the family tree.
	 * 
	 * @param partner1Name
	 *            String holding wife's name
	 * @param aDOB1
	 *            String holding wife's date of birth
	 * @param partner2Name
	 *            String holding husband's name
	 * @param aDOB2
	 *            String holding husband's date of birth
	 */
	public void recordDivorce(String partner1Name, String aDOB1,
			String partner2Name, String aDOB2) {

	}

	/**
	 * List the details of the person whose name is given. Note you need to do
	 * something about the possibility of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listPersonDetails(String personName) {

	}

	/**
	 * List the details of the parent of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listParentDetails(String personName) {

	}

	/**
	 * List the details of the children of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listChildren(String personName) {
		// Find the person, get their children, and list them.
	}

	/**
	 * List the details of the siblings of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listSiblings(String personName) {

	}

	/**
	 * List the details of the ancestors along the paternal line of the person
	 * whose name is given. Note you need to do something about the possibility
	 * of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listPaternalLineage(String personName) {

	}

	/**
	 * List the details of the ancestors along the maternal line of the person
	 * whose name is given. Note you need to do something about the possibility
	 * of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listMaternalLineage(String personName) {

	}

	/**
	 * List the details of the grandparents of the person whose name is given.
	 * Note you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listGrandParents(String personName) {

	}

	/**
	 * List the details of the grandchildren of the person whose name is given.
	 * Note you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listGrandChildren(String personName) {

	}

	/**
	 * List the details of the cousins of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listCousins(String personName) {

	}

	/**
	 * List the details of the N generations of ancestors of the person whose
	 * name is given. Note you need to do something about the possibility of
	 * duplicate names appearing.
	 * 
	 * @param personName
	 * @param numberOfGenerations
	 *            1=parents,2=grandparents, 3=great-grandparents etc.
	 */
	public void listGreatNGrandParents(String personName,
			int numberOfGenerations) {

	}

	/**
	 * List the details of the N generations of children of the person whose
	 * name is given. Note you need to do something about the possibility of
	 * duplicate names appearing.
	 * 
	 * @param personName
	 * @param numberOfGenerations
	 *            1=children,2=grandchildren, 3=great-grandchildren etc.
	 */
	public void listGreatNGrandChildren(String personName,
			int numberOfGenerations) {

	}

	/**
	 * Records an adoption.
	 * 
	 * @param personName
	 * @param aDOB
	 */
	public void recordAdoption(String personName, String aDOB) {

	}
	
	/**
	 * Lists all the current people in the family tree.
	 */
	public void listAll() {
		if(family.isEmpty()) {
			System.out.println("Error 404 - No data found in the family tree.");
		} else {
			System.out.println(family.toString());
		}
	}
}