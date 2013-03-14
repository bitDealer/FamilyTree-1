package familytree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Once complete this class manages a family tree. You need to complete the
 * methods whose headers are given here.
 * 
 * @author Matt McCouaig 11005773
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
		boolean found = false;
		for (Person p : family) {
			if (p.compareTo(aPerson) == 1) {
				found = true;
			}
		}
		if (!found) {
			family.add(aPerson);
			System.out.println(aPerson.getName() + " has been added!");
		} else {
			System.out.println("Error 301 - Person already in the family tree.");
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
		Person[] personArr = getPair(aPerson, aDOB, mName, mDOB);
		if (personArr[0] != null && personArr[1] != null) {
			personArr[0].setMother(personArr[1]);
			personArr[1].addChild(personArr[0]);
			System.out.println(personArr[0].getName() + "'s mother is now " + personArr[1].getName() + "!");
		} else {
			System.out.println("Error 302 - Child and/or Mother doesn't exist in the tree.");
		}
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
		Person[] personArr = getPair(aPerson, aDOB, fName, fDOB);
		if (personArr[0] != null && personArr[1] != null) {
			personArr[0].setFather(personArr[1]);
			personArr[1].addChild(personArr[0]);
			System.out.println(personArr[0].getName() + "'s father is now " + personArr[1].getName() + "!");
		} else {
			System.out.println("Error 303 - Child and/or Father doesn't exist in the tree.");
		}
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
			String partner2Name, String aDOB2, String dateMarried) {
		Person[] personArr = getPair(partner1Name, aDOB1, partner2Name, aDOB2);
		if (personArr[0] != null && personArr[1] != null) {
			personArr[0].setPartner(personArr[1]);
			personArr[0].setDateMarried(dateMarried);
			personArr[1].setPartner(personArr[0]);
			personArr[1].setDateMarried(dateMarried);
			System.out.println(personArr[0].getName() + " and " + personArr[1].getName() + "'s marriage has been recorded.");
		} else {
			System.out.println("Error 304 - Marriage recording failed. One of you aren't already in the family tree.");
		}
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
			String partner2Name, String aDOB2, String dateDivorced) {
		Person[] personArr = getPair(partner1Name, aDOB1, partner2Name, aDOB2);
		boolean pOne, pTwo;
		if (personArr[0] != null && personArr[1] != null) {
			pOne = personArr[0].addDivorce(personArr[1], dateDivorced);
			pTwo = personArr[1].addDivorce(personArr[0], dateDivorced);
			if(pOne && pTwo) {
				System.out.println(personArr[0].getName() + " and " + personArr[1].getName() + "'s divorce has been recorded.");
			} else {
				System.out.println("Error 305a - The partner given doesn't match with the partner linked to the person.");
			}
		} else {
			System.out.println("Error 305b - Divorce recording failed. One of you aren't in the family tree already.");
		}
	}

	/**
	 * List the details of the person whose name is given. Note you need to do
	 * something about the possibility of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listPersonDetails(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			System.out.println(aPerson.toString());
		} else {
			System.out.println("Error 306 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the parent of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listParentDetails(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			if (aPerson.getMother() != null) {
				System.out.println(aPerson.getMother().toString());
			}
			if (aPerson.getFather() != null) {
				System.out.println(aPerson.getFather().toString());
			}
			if (aPerson.getMother() == null && aPerson.getFather() == null) {
				System.out
						.println("Error 307 - This person doesn't have a mother and father linked to them.");
			}
		} else {
			System.out
					.println("Error 308 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the children of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listChildren(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			if (!aPerson.getChildren().isEmpty()) {
				System.out.println("Children of " + aPerson.getName() + " are:");
				for(Person q : aPerson.getChildren()) {
					System.out.println(q.getBasicDetails());
					if (q.isAdopted()) {
						System.out.print(" - Adopted");
					}
				}
			} else {
				System.out.println("Error 309 - That person has no children!");
			}
		} else {
			System.out.println("Error 310 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the siblings of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listSiblings(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			System.out.println("Siblings: ");
			if(aPerson.getMother() != null && aPerson.getFather() != null) {
				ArrayList<Person> siblings = aPerson.getMother().getChildren();
				siblings.remove(aPerson);
				boolean unique = true;
				for(Person p : aPerson.getFather().getChildren()) {
					for(Person q : siblings) {
						if(p.compareTo(q) == 1) {
							unique = false;
						}
					}
					if(unique && p.compareTo(aPerson) == 0) {
						siblings.add(p);
					}
					unique = true;
				}
				for(Person r : siblings) {
					System.out.println(r.getBasicDetails());
					// As the siblings list is based from the mother's children
					// You only need to check against the father for half-siblings.
					if(aPerson.getFather().compareTo(r.getFather()) == 0) {
						System.out.print(" - Half-Sibling");
					}
					if (r.isAdopted()) {
						System.out.print(" - Adopted");
					}
				}
			} else if(aPerson.getMother() != null) {
				for(Person p : aPerson.getMother().getChildren()) {
					System.out.println(p.getBasicDetails());
					if(p.getFather() != null) {
						System.out.print(" - Half-Sibling");
					}
					if (p.isAdopted()) {
						System.out.print(" - Adopted");
					}
				}
			} else if(aPerson.getFather() != null) {
				for(Person p : aPerson.getMother().getChildren()) {
					System.out.println(p.getBasicDetails());
					if(p.getMother() != null) {
						System.out.print(" - Half-Sibling");
					}
					if (p.isAdopted()) {
						System.out.print(" - Adopted");
					}
				}
			} else {
				System.out.println("Error 311a - This person doesn't have any siblings.");
			}
		} else {
			System.out.println("Error 311b - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the ancestors along the paternal line of the person
	 * whose name is given. Note you need to do something about the possibility
	 * of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listPaternalLineage(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			Person father = aPerson.getFather();
			int i = 1;
			if(father != null) {
				while (father != null) {
					System.out.println(i + father.getBasicDetails());
					father = father.getFather();
					i++;
				}
			} else {
				System.out.println("Error 312 - This person is the oldest in his bloodline!");
			}
		} else {
			System.out.println("Error 313 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the ancestors along the maternal line of the person
	 * whose name is given. Note you need to do something about the possibility
	 * of duplicate names appearing.
	 * 
	 * @param personName
	 */
	public void listMaternalLineage(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if (aPerson != null) {
			Person mother = aPerson.getMother();
			int i = 1;
			if(mother != null) {
				while (mother != null) {
					System.out.println(i + ": " + mother.getBasicDetails());
					mother = mother.getFather();
					i++;
				}
			} else {
				System.out.println("Error 314 - This person is the oldest in her bloodline!");
			}
		} else {
			System.out.println("Error 315 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the grandparents of the person whose name is given.
	 * Note you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listGrandParents(String personName) {
		Person aPerson = gaugeUserInput(genSublist(personName));
		if(aPerson != null) {
			Person[] parents = {aPerson.getMother(), aPerson.getFather()};
			if(parents[0] != null && parents[1] != null) { // checks to see if the parents exist
				System.out.println("\nGrandparents:");
				if(parents[0].getMother() != null && parents[0].getFather() != null) { // checks to see if both grandparents exist
					System.out.println("1: " + parents[0].getMother().getBasicDetails() + " and " + parents[0].getFather().getBasicDetails());
				} else if(parents[0].getMother() != null) { // these check to see if either exist, rather than both
					System.out.println("1: " + parents[0].getMother().getBasicDetails());
				} else if(parents[0].getFather() != null) { 
					System.out.println("1: " + parents[0].getFather().getBasicDetails());
				}
				if(parents[1].getMother() != null && parents[1].getFather() != null) { // checks to see if both grandparents exist
					System.out.println("2: " + parents[1].getMother().getBasicDetails() + " and " + parents[1].getFather().getBasicDetails());
				} else if(parents[1].getMother() != null) { // these check to see if either exist, rather than both
					System.out.println("2: " + parents[1].getMother().getBasicDetails());
				} else if(parents[1].getFather() != null) {
					System.out.println("2: " + parents[1].getFather().getBasicDetails());
				}
				if((parents[0].getMother() == null && parents[0].getFather() == null) && 
						(parents[1].getMother() == null && parents[1].getFather() == null)) {
					System.out.println("Error 316 - This person doesn't have any grandparents." +
							"Their parents are the oldest ancestors.");
				}
			} else if(parents[0] != null) {
				System.out.println("\nGrandparents:");
				if(parents[0].getMother() != null && parents[0].getFather() != null) { // checks to see if both grandparents exist
					System.out.println("1: " + parents[0].getMother().getBasicDetails() + " and " + parents[0].getFather().getBasicDetails());
				} else if(parents[0].getMother() != null) { // these check to see if either exist, rather than both
					System.out.println("1: " + parents[0].getMother().getBasicDetails());
				} else if(parents[0].getFather() != null) { 
					System.out.println("1: " + parents[0].getFather().getBasicDetails());
				} else {
					System.out.println("Error 317 - This person doesn't have any grandparents." +
							"Their parents are the oldest ancestors.");
				}
			} else if(parents[1] != null) {
				System.out.println("\nGrandparents:");
				if(parents[1].getMother() != null && parents[1].getFather() != null) { // checks to see if both grandparents exist
					System.out.println("2: " + parents[1].getMother().getBasicDetails() + " and " + parents[1].getFather().getBasicDetails());
				} else if(parents[1].getMother() != null) { // these check to see if either exist, rather than both
					System.out.println("2: " + parents[1].getMother().getBasicDetails());
				} else if(parents[1].getFather() != null) {
					System.out.println("2: " + parents[1].getFather().getBasicDetails());
				} else {
					System.out.println("Error 318 - This person doesn't have any grandparents." +
							"Their parents are the oldest ancestors.");
				}
			} else {
				System.out.println("Error 319 - This person doesn't have any parents. They could be the oldest ancestor.");
			}
		} else {
			System.out.println("Error 320 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the grandchildren of the person whose name is given.
	 * Note you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listGrandChildren(String personName) {
		ArrayList<Person> gChildren = new ArrayList<Person>();
		Person aPerson = gaugeUserInput(genSublist(personName));
		if(aPerson != null) {
			if(!aPerson.getChildren().isEmpty()) {
				for(Person p : aPerson.getChildren()) {
					if(!p.getChildren().isEmpty()) {
						for(Person q : p.getChildren()) {
							gChildren.add(q);
						}
					}
				}
				if(!gChildren.isEmpty()) {
					for(Person r : gChildren) {
						System.out.println(r.getBasicDetails());
					}
				} else {
					System.out.println("Error 321 - This person doesn't have any grandchildren.");
				}
			} else {
				System.out.println("Error 322 - This person doesn't have any children.");
			}
		} else {
			System.out.println("Error 323 - This person doesn't exist in the family tree.");
		}
	}

	/**
	 * List the details of the cousins of the person whose name is given. Note
	 * you need to do something about the possibility of duplicate names
	 * appearing.
	 * 
	 * @param personName
	 */
	public void listCousins(String personName) {
		ArrayList<Person> cousins = new ArrayList<Person>();
		Person aPerson = gaugeUserInput(genSublist(personName));
		if(aPerson != null) {
			// Mother's side of the family.
			if(aPerson.getMother() != null) {
				if(aPerson.getMother().getMother() != null) {
					if(!aPerson.getMother().getMother().getChildren().isEmpty()) {
						for(Person p : aPerson.getMother().getMother().getChildren()) {
							if(p.compareTo(aPerson.getMother()) == 0) {
								if(!p.getChildren().isEmpty()) {
									for(Person q : p.getChildren()) {
										cousins.add(q);
									}
								}
							}
						}
					}
				}
				if(aPerson.getMother().getFather() != null) {
					boolean unique = true;
					if(!aPerson.getMother().getMother().getChildren().isEmpty()) { // Grandmother's children
						for(Person p : aPerson.getMother().getMother().getChildren()) {
							if(p.compareTo(aPerson.getMother()) == 0) {
								if(!p.getChildren().isEmpty()) { // Grandmother's grandchildren
									for(Person q : p.getChildren()) { // for each cousin
										for(Person r : cousins) {
											if(q.compareTo(r) == 1) {
												unique = false;
											}
										}
										if(unique) {
											cousins.add(q);
										}
										unique = true;
									}
								}
							}
						}
					}
				}
			}
			// Father's side of the family.
			if(aPerson.getFather() != null) {
				if(aPerson.getFather().getMother() != null) {
					boolean unique = true;
					if(!aPerson.getFather().getMother().getChildren().isEmpty()) {
						for(Person p : aPerson.getFather().getMother().getChildren()) {
							if(p.compareTo(aPerson.getFather()) == 0) {
								if(!p.getChildren().isEmpty()) { // Grandmother's grandchildren
									for(Person q : p.getChildren()) { // for each cousin
										for(Person r : cousins) {
											if(q.compareTo(r) == 1) {
												unique = false;
											}
										}
										if(unique) {
											cousins.add(q);
										}
										unique = true;
									}
								}
							}
						}
					}
				}
				if(aPerson.getFather().getFather() != null) {
					boolean unique = true;
					if(!aPerson.getFather().getFather().getChildren().isEmpty()) {
						for(Person p : aPerson.getFather().getFather().getChildren()) {
							if(p.compareTo(aPerson.getFather()) == 0) {
								if(!p.getChildren().isEmpty()) { // Grandmother's grandchildren
									for(Person q : p.getChildren()) { // for each cousin
										for(Person r : cousins) {
											if(q.compareTo(r) == 1) {
												unique = false;
											}
										}
										if(unique) {
											cousins.add(q);
										}
										unique = true;
									}
								}
							}
						}
					}
				}
			}
			// Display all cousins
			if(!cousins.isEmpty()) {
				for(Person p : cousins) {
					System.out.println(p.getBasicDetails());
				}
			} else {
				System.out.println("Error 324 - This person has no cousins.");
			}
		} else {
			System.out.println("Error 325 - This person doesn't exist in the family tree.");
		}
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
		Person aPerson = gaugeUserInput(genSublist(personName));
		// ArrayList<Person> genParents = new ArrayList<Person>();
		// Go through each generation, getting the parents and putting them into the arraylist.
		// Output for each generation.
		// If the function runs out of generations, set the var to be one off by the end, I think.
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
		Person aPerson = gaugeUserInput(genSublist(personName));
	}

	/**
	 * Records an adoption.
	 * 
	 * @param personName
	 * @param aDOB
	 */
	public void recordAdoption(String personName, String aDOB) {
		Person child = getPerson(personName, aDOB);
		if (child != null) {
			if(!child.isAdopted()) {
				if(child.getMother() != null) {
					child.setBloodlineMother(child.getMother());
					child.getMother().removeChild(child);
					child.setMother(null);
				}
				if(child.getFather() != null) {
					child.setBloodlineFather(child.getFather());
					child.getFather().removeChild(child);
					child.setFather(null);
				}
				child.setAdopted(true);
				System.out.println("Adoption of " + personName
					+ " recorded. Please create new Mother and Father links.");
			} else {
				System.out.println("Error 326 - This person is already set to being adopted!");
			}
		} else {
			System.out.println("Error 327 - There is no person within the tree with that name and date of birth.");
		}
	}

	/**
	 * Lists all the current people in the family tree.
	 */
	public void listAll() {
		if (family.isEmpty()) {
			System.out.println("Error 404 - No data found in the family tree.");
		} else {
			System.out.println(family.toString());
		}
	}

	/**
	 * Method for getting the correct Person object from a sublist of possible
	 * people. Can return a NULL.
	 * 
	 * @param people
	 *            - Sublist generated from genSublist()
	 * @return Person required from a sublist of possible people.
	 */
	private Person gaugeUserInput(ArrayList<Person> people) {
		if (!people.isEmpty()) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Possible Matches:");
			for (Person p : people) {
				System.out.println(" - " + p.getName() + ", " + p.getDob()
						+ ", " + p.getBirthplace());
			}
			System.out
					.println("\nPlease enter the Date of Birth of the person you are searching for: (yyyy)");
			String DoB = scan.next();
			Person person = getPerson(people.get(0).getName(), DoB);
			return person;
		} else {
			return null;
		}
	}

	private ArrayList<Person> genSublist(String name) {
		ArrayList<Person> subList = new ArrayList<Person>();
		for (int i = 0; i < family.size(); i++) {
			if (family.get(i).getName().equalsIgnoreCase(name)) {
				subList.add(family.get(i));
			}
		}
		return subList;
	}

	/**
	 * Method to find a pair of people required for another function. No error
	 * checking. Can return a NULL.
	 * 
	 * @param oneName
	 *            - Name of the first person.
	 * @param oneDOB
	 *            - Date of birth of the first person.
	 * @param twoName
	 *            - Name of the second person.
	 * @param twoDOB
	 *            - Date of birth of the second person.
	 * @return Array containing the two Person objects you're looking for if
	 *         they exist.
	 */
	private Person[] getPair(String oneName, String oneDOB, String twoName,
			String twoDOB) {
		Person one = null, two = null;

		for (int i = 0; i < family.size(); i++) {
			if (family.get(i).getName().equalsIgnoreCase(oneName)
					&& family.get(i).getDob().equalsIgnoreCase(oneDOB)) {
				one = family.get(i);
			} else if (family.get(i).getName().equalsIgnoreCase(twoName)
					&& family.get(i).getDob().equalsIgnoreCase(twoDOB)) {
				two = family.get(i);
			}
		}

		Person[] personArr = { one, two };
		return personArr;
	}

	/**
	 * Method for attaining a Person object from a name and date of birth. No
	 * error checking. Can return a NULL.
	 * 
	 * @param name
	 *            - Name of the person you're looking for.
	 * @param DoB
	 *            - Date of Birth of the person you're looking for.
	 * @return Person object as found.
	 */
	private Person getPerson(String name, String DoB) {
		Person foundPerson = null;
		for (int i = 0; i < family.size(); i++) {
			if (family.get(i).getName().equalsIgnoreCase(name)
					&& family.get(i).getDob().equalsIgnoreCase(DoB)) {
				foundPerson = family.get(i);
			}
		}
		return foundPerson;
	}
}