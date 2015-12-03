package group87;
import student.TestCase;
/**
 * Tests the people list class.
 * @author Larissa Schneider (larissa6), Simone Stewart (simone5), Tara Amruthur (taraa2)
 * @version 2015.11.13
 *
 */
public class PeopleListTest extends TestCase
{
    private DoublyLinkedList<Song> answerKey;
    private PeopleList list;
    private DoublyLinkedList<Person> people;
    private DoublyLinkedList<String> answers1;
    private DoublyLinkedList<String> answers2;
    private DoublyLinkedList<String> answers3;
    
    /**
     * Sets up.
     */
    public void setUp()
    {
        people = new DoublyLinkedList<Person>();
        answerKey = new DoublyLinkedList<Song>();
        answerKey.add(new Song("Fall Out Boy",
                "Uma Thurman", "rock", "2015"));
        answerKey.add(new Song("Diana Ross",
                "Upside Down", "disco", "1980"));
        answerKey.add(new Song("Elvis Costello",
                "Watching the Detectives", "punk",
                "1977"));
        list = new PeopleList();
        list.setAnswerKey(answerKey);
        answers1 = new DoublyLinkedList<String>();
        for (int count = 0; count < 3; count++)
        {
            answers1.add("Yes");
        }
        for (int count = 0; count < 3; count++)
        {
            answers1.add("No");
        }
        answers2 = new DoublyLinkedList<String>();
        for (int count = 0; count < 6; count++)
        {
            answers2.add("Yes");
        }
        answers3 = new DoublyLinkedList<String>();
        for (int count = 0; count < 6; count++)
        {
            answers3.add("No");
        }
        Person tempPerson1 = new Person("sports", "Other Engineering",
                "Northeast US", answers2);
        list.addPerson(tempPerson1);
        list.addPerson(new Person("sports", "Math or CMDA",
                "Northeast US", answers1));
        list.addPerson(new Person("sports", "Math or CMDA",
                "the rest of US", answers3));
        list.addPerson(new Person("music", "Other",
                "outside the US", answers3));
        list.addPerson(new Person("music", "Other",
                "outside the US", answers2));
        list.addPerson(new Person("art", "Computer Science",
                "Southeast US", answers2));
        list.addPerson(new Person("read", "Computer Science",
                "Southeast US", answers1));
        for (int count = 0; count < list.getPopulation(); count++)
        {
            people.add(list.getPeople().get(count));
        }
    } 
    
    /**
     * Tests the setAnswerKey method.
     */
    public void testSetAnswerKey()
    {
        DoublyLinkedList<Song> tempKey = new DoublyLinkedList<Song>();
        tempKey.add(new Song("Artist", "Title", "Genre", "Year"));
        list.setAnswerKey(tempKey);
        assertTrue(tempKey.equals(list.getAnswerKey()));
    }
    
    /**
     * Tests the getAnswerKey method.
     */
    public void testGetAnswerKey()
    {
        assertTrue(answerKey.equals(list.getAnswerKey()));
    }
    
    /**
     * Tests the getPeople method.
     */
    public void testGetPeople()
    {
        assertTrue(people.get(0).equals(list.getPeople().get(0)));
        assertTrue(people.get(1).equals(list.getPeople().get(1)));
        assertTrue(people.get(2).equals(list.getPeople().get(2)));
    }
    
    /**
     * Tests the getPopulation method.
     */
    public void testGetPopulation()
    {
        assertEquals(7, list.getPopulation(), 0.01);
    }
    
    /**
     * Tests the addPerson method.
     */
    public void testAddPerson()
    {
        Person person = new Person("sports", "Computer Science", "Southeast", answers1);
        list.addPerson(person);
        assertTrue(person.equals(list.getPeople().get(7)));
    }
    
    /**
     * Tests the getPercentage method
     */
    public void testGetPercentage()
    {
        double[] results = list.getPercentage();
        assertEquals(71, results[0], 1);
    }
    
    /**
     * Tests the getPercentageByHobby method.
     */
    public void testGetPercentageByHobby()
    {
        double[] results = list.getPercentageByHobby();
        assertEquals(100, results[0], 0.01);
        assertEquals(-1, results[6], 0.01);
        assertEquals(100, results[7], 1);
    }
    
    /**
     * Tests the getPercentageByMajor method.
     */
    public void testGetPercentageByMajor()
    {
        double[] results = list.getPercentageByMajor();
    }

    /**
     * Tests the getPercentageByRegion method.
     */
    public void testGetPercentageByRegion()
    {
        double[] results = list.getPercentageByRegion();
    }
}
