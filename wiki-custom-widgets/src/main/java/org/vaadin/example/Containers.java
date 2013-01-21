package org.vaadin.example;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.vaadin.wiki.cc.gwt.shared.Category;
import org.vaadin.wiki.cc.gwt.shared.ContactInfo;

import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

/**
 * A mix of com.vaadin.demo.sampler.ExampleUtil and org.vaadin.wiki.cc.gwt.client.ContactDatabase.
 */
public class Containers {

	public static final Object PERSON_PROPERTY_ID = "Person Id";
	public static final Object PERSON_PROPERTY_FIRSTNAME = "First Name";
	public static final Object PERSON_PROPERTY_LASTNAME = "Last Name";
	public static final Object PERSON_PROPERTY_NAME = "Name";
	public static final Object PERSON_PROPERTY_STREET = "Street";
	public static final Object PERSON_PROPERTY_BIRTHDAY = "Birthday";
	public static final Object PERSON_PROPERTY_CATEGORY = "Category";

	private static final String[] FEMALE_FIRST_NAMES = {
			"Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer", "Maria", "Susan",
			"Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Helen", "Sandra", "Donna",
			"Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah", "Jessica",
			"Shirley", "Cynthia", "Angela", "Melissa", "Brenda", "Amy", "Anna", "Rebecca", "Virginia",
			"Kathleen", "Pamela", "Martha", "Debra", "Amanda", "Stephanie", "Carolyn", "Christine",
			"Marie", "Janet", "Catherine", "Frances", "Ann", "Joyce", "Diane", "Alice", "Julie",
			"Heather", "Teresa", "Doris", "Gloria", "Evelyn", "Jean", "Cheryl", "Mildred", "Katherine",
			"Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly", "Nicole", "Judy", "Christina",
			"Kathy", "Theresa", "Beverly", "Denise", "Tammy", "Irene", "Jane", "Lori", "Rachel",
			"Marilyn", "Andrea", "Kathryn", "Louise", "Sara", "Anne", "Jacqueline", "Wanda", "Bonnie",
			"Julia", "Ruby", "Lois", "Tina", "Phyllis", "Norma", "Paula", "Diana", "Annie", "Lillian",
			"Emily", "Robin", "Peggy", "Crystal", "Gladys", "Rita", "Dawn", "Connie", "Florence",
			"Tracy", "Edna", "Tiffany", "Carmen", "Rosa", "Cindy", "Grace", "Wendy", "Victoria", "Edith",
			"Kim", "Sherry", "Sylvia", "Josephine", "Thelma", "Shannon", "Sheila", "Ethel", "Ellen",
			"Elaine", "Marjorie", "Carrie", "Charlotte", "Monica", "Esther", "Pauline", "Emma",
			"Juanita", "Anita", "Rhonda", "Hazel", "Amber", "Eva", "Debbie", "April", "Leslie", "Clara",
			"Lucille", "Jamie", "Joanne", "Eleanor", "Valerie", "Danielle", "Megan", "Alicia", "Suzanne",
			"Michele", "Gail", "Bertha", "Darlene", "Veronica", "Jill", "Erin", "Geraldine", "Lauren",
			"Cathy", "Joann", "Lorraine", "Lynn", "Sally", "Regina", "Erica", "Beatrice", "Dolores",
			"Bernice", "Audrey", "Yvonne", "Annette", "June", "Samantha", "Marion", "Dana", "Stacy",
			"Ana", "Renee", "Ida", "Vivian", "Roberta", "Holly", "Brittany", "Melanie", "Loretta",
			"Yolanda", "Jeanette", "Laurie", "Katie", "Kristen", "Vanessa", "Alma", "Sue", "Elsie",
			"Beth", "Jeanne" };

	private static final String[] MALE_FIRST_NAMES = {
			"James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph",
			"Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven",
			"Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy",
			"Jose", "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond",
			"Gregory", "Joshua", "Jerry", "Dennis", "Walter", "Patrick", "Peter", "Harold", "Douglas",
			"Henry", "Carl", "Arthur", "Ryan", "Roger", "Joe", "Juan", "Jack", "Albert", "Jonathan",
			"Justin", "Terry", "Gerald", "Keith", "Samuel", "Willie", "Ralph", "Lawrence", "Nicholas",
			"Roy", "Benjamin", "Bruce", "Brandon", "Adam", "Harry", "Fred", "Wayne", "Billy", "Steve",
			"Louis", "Jeremy", "Aaron", "Randy", "Howard", "Eugene", "Carlos", "Russell", "Bobby",
			"Victor", "Martin", "Ernest", "Phillip", "Todd", "Jesse", "Craig", "Alan", "Shawn",
			"Clarence", "Sean", "Philip", "Chris", "Johnny", "Earl", "Jimmy", "Antonio", "Danny",
			"Bryan", "Tony", "Luis", "Mike", "Stanley", "Leonard", "Nathan", "Dale", "Manuel", "Rodney",
			"Curtis", "Norman", "Allen", "Marvin", "Vincent", "Glenn", "Jeffery", "Travis", "Jeff",
			"Chad", "Jacob", "Lee", "Melvin", "Alfred", "Kyle", "Francis", "Bradley", "Jesus", "Herbert",
			"Frederick", "Ray", "Joel", "Edwin", "Don", "Eddie", "Ricky", "Troy", "Randall", "Barry",
			"Alexander", "Bernard", "Mario", "Leroy", "Francisco", "Marcus", "Micheal", "Theodore",
			"Clifford", "Miguel", "Oscar", "Jay", "Jim", "Tom", "Calvin", "Alex", "Jon", "Ronnie",
			"Bill", "Lloyd", "Tommy", "Leon", "Derek", "Warren", "Darrell", "Jerome", "Floyd", "Leo",
			"Alvin", "Tim", "Wesley", "Gordon", "Dean", "Greg", "Jorge", "Dustin", "Pedro", "Derrick",
			"Dan", "Lewis", "Zachary", "Corey", "Herman", "Maurice", "Vernon", "Roberto", "Clyde",
			"Glen", "Hector", "Shane", "Ricardo", "Sam", "Rick", "Lester", "Brent", "Ramon", "Charlie",
			"Tyler", "Gilbert", "Gene" };

	private static final String[] LAST_NAMES = {
			"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
			"Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
			"Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen",
			"Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker",
			"Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips",
			"Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris",
			"Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper",
			"Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
			"Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross",
			"Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes",
			"Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander",
			"Russell", "Griffin", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Sullivan",
			"Wallace", "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis",
			"Harrison", "Gibson", "Mcdonald", "Cruz", "Marshall", "Ortiz", "Gomez", "Murray", "Freeman",
			"Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter", "Hicks", "Crawford",
			"Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren", "Dixon", "Ramos", "Reyes", "Burns",
			"Gordon", "Shaw", "Holmes", "Rice", "Robertson", "Hunt", "Black", "Daniels", "Palmer",
			"Mills", "Nichols", "Grant", "Knight", "Ferguson", "Rose", "Stone", "Hawkins", "Dunn",
			"Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce", "Berry",
			"Matthews", "Arnold", "Wagner", "Willis", "Ray", "Watkins", "Olson", "Carroll", "Duncan",
			"Snyder", "Hart", "Cunningham", "Bradley", "Lane", "Andrews", "Ruiz", "Harper", "Fox",
			"Riley", "Armstrong", "Carpenter", "Weaver", "Greene", "Lawrence", "Elliott", "Chavez",
			"Sims", "Austin", "Peters", "Kelley", "Franklin", "Lawson" };

	private static final String[] STREET_NAMES =
	{
			"Peachtree", "First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Tenth",
			"Fourteenth", "Spring", "Techwood", "West Peachtree", "Juniper", "Cypress", "Fowler",
			"Piedmont", "Juniper", "Main", "Central", "Currier", "Courtland", "Williams",
			"Centennial", "Olympic", "Baker", "Highland", "Pryor", "Decatur", "Bell", "Edgewood",
			"Mitchell", "Forsyth", "Capital" };

	private static final String[] STREET_SUFFIX = {
			"St", "Rd", "Ln", "Blvd", "Way", "Pkwy", "Cir", "Ave" };

	private static Containers INSTANCE = new Containers();

	private static Random RANDOM = new Random(292892813L);

	//
	
	private Category[] categories;

	private Indexed contactInfoDb;

	private Containers() {
	}

	public static Containers getInstance() {
		return INSTANCE;
	}

	public static IndexedContainer getPersonContainer() {
		IndexedContainer contactContainer = new IndexedContainer();
		contactContainer.addContainerProperty(PERSON_PROPERTY_FIRSTNAME,
				String.class, "");
		contactContainer.addContainerProperty(PERSON_PROPERTY_LASTNAME,
				String.class, "");

		for (int i = 0; i < 50;) {
			String fn;
			if (RANDOM.nextBoolean()) {
				fn = FEMALE_FIRST_NAMES[(int) (RANDOM.nextDouble() * FEMALE_FIRST_NAMES.length)];
			}
			else {
				fn = MALE_FIRST_NAMES[(int) (RANDOM.nextDouble() * MALE_FIRST_NAMES.length)];
			}
			String ln = LAST_NAMES[(int) (RANDOM.nextDouble() * LAST_NAMES.length)];
			String id = fn + ln;
			Item item = contactContainer.addItem(id);
			if (item != null) {
				i++;
				item.getItemProperty(PERSON_PROPERTY_FIRSTNAME).setValue(fn);
				item.getItemProperty(PERSON_PROPERTY_LASTNAME).setValue(ln);
			}
		}
		return contactContainer;
	}

	public Category[] getCategories() {
		if (categories == null || categories.length == 0) {
			// Initialize the categories.
			// DatabaseConstants constants = GWT.create(DatabaseConstants.class);
			// String[] catNames = constants.contactDatabaseCategories();
			final String[] catNames = new String[] { "family", "friends", "peers" };
			categories = new Category[catNames.length];
			for (int i = 0; i < catNames.length; i++) {
				categories[i] = new Category(catNames[i]);
			}
		}
		return categories;
	}

	public Indexed getContactInfoContainer() {
		if (contactInfoDb == null || contactInfoDb.size() == 0) {
			// Initialize the categories.
			getCategories();
			
			// Initialize the indexed container.
			final IndexedContainer contactContainer = new IndexedContainer();
			contactContainer.addContainerProperty(PERSON_PROPERTY_ID,
					int.class, null);
			contactContainer.addContainerProperty(PERSON_PROPERTY_FIRSTNAME,
					String.class, "");
			contactContainer.addContainerProperty(PERSON_PROPERTY_LASTNAME,
					String.class, "");
			contactContainer.addContainerProperty(PERSON_PROPERTY_STREET,
					String.class, "");
			contactContainer.addContainerProperty(PERSON_PROPERTY_BIRTHDAY,
					Date.class, null);
			contactContainer.addContainerProperty(PERSON_PROPERTY_CATEGORY,
					Category.class, null);
			contactInfoDb = contactContainer;

			// Generate initial data.
			generateContacts(250);
		}
		return contactInfoDb;
	}

	/**
	 * Generate the specified number of contacts and add them to the data
	 * provider.
	 * 
	 * @param count the number of contacts to generate.
	 */
	public void generateContacts(int count) {
		/*
		List<ContactInfo> contacts = dataProvider.getList();
		for (int i = 0; i < count; i++) {
			contacts.add(createContactInfo());
		}
		 */
		for (int i = 0; i < count; ++i) {
			final ContactInfo contact = createContactInfo();
			final Item item = contactInfoDb.addItem(contact.getId());
			if (item != null) {
				item.getItemProperty(PERSON_PROPERTY_CATEGORY).setValue(contact.getCategory());
				item.getItemProperty(PERSON_PROPERTY_FIRSTNAME).setValue(contact.getFirstName());
				item.getItemProperty(PERSON_PROPERTY_LASTNAME).setValue(contact.getLastName());
				item.getItemProperty(PERSON_PROPERTY_STREET).setValue(contact.getFirstName());
				item.getItemProperty(PERSON_PROPERTY_BIRTHDAY).setValue(contact.getBirthday());
			}
		}
	}

	/**
	 * Create a new random {@link ContactInfo}.
	 * 
	 * @return the new {@link ContactInfo}.
	 */
	private ContactInfo createContactInfo() {
		ContactInfo contact = new ContactInfo(nextValue(categories));
		contact.setLastName(nextValue(LAST_NAMES));
		if (RANDOM.nextBoolean()) {
			// Male.
			contact.setFirstName(nextValue(MALE_FIRST_NAMES));
		}
		else {
			// Female.
			contact.setFirstName(nextValue(FEMALE_FIRST_NAMES));
		}

		// Create a birthday between 20-80 years ago.
		int year = (new Date()).getYear() - 21 - RANDOM.nextInt(61);
		contact.setBirthday(new Date(year, RANDOM.nextInt(12), 1 + RANDOM.nextInt(31)));

		// Create an address.
		int addrNum = 1 + RANDOM.nextInt(999);
		String addrStreet = nextValue(STREET_NAMES);
		String addrSuffix = nextValue(STREET_SUFFIX);
		contact.setAddress(addrNum + " " + addrStreet + " " + addrSuffix);
		return contact;
	}

	/**
	 * Get the next random value from an array.
	 * 
	 * @param array the array
	 * @return a random value in the array
	 */
	private <T> T nextValue(T[] array) {
		return array[RANDOM.nextInt(array.length)];
	}
	
	public static ContactInfo fromContactInfoFromItem(Object itemId, Item item) {
		final Category category = (Category) item.getItemProperty(PERSON_PROPERTY_CATEGORY).getValue();
		final ContactInfo result = new ContactInfo(category);
		result.setFirstName((String) item.getItemProperty(PERSON_PROPERTY_FIRSTNAME).getValue());
		result.setLastName((String) item.getItemProperty(PERSON_PROPERTY_LASTNAME).getValue());
		result.setAddress((String) item.getItemProperty(PERSON_PROPERTY_STREET).getValue());
		result.setBirthday((Date) item.getItemProperty(PERSON_PROPERTY_BIRTHDAY).getValue());
		return result;
	}

}
