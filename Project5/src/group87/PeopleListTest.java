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
        Person tempPerson1 = new Person("sports", "Math/CMDA",
                "Northeast", answers1);
        list.addPerson(tempPerson1);
        answers2 = new DoublyLinkedList<String>();
        for (int count = 0; count < 6; count++)
        {
            answers2.add("Yes");
        }
        Person tempPerson2 = new Person("music", "Other",
                "non-US", answers2);
        list.addPerson(tempPerson2);
        answers3 = new DoublyLinkedList<String>();
        for (int count = 0; count < 6; count++)
        {
            answers3.add("No");
        }
        Person tempPerson3 = new Person("art", "Computer Science",
                "Southeast", answers3);
        list.addPerson(tempPerson3);
        people.add(tempPerson1);
        people.add(tempPerson2);
        people.add(tempPerson3);
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
        assertEquals(3, list.getPopulation(), 0.01);
    }
    
    /**
     * Tests the addPerson method.
     */
    public void testAddPerson()
    {
        Person person = new Person("sports", "Computer Science", "Southeast", answers1);
        list.addPerson(person);
        assertTrue(person.equals(list.getPeople().get(3)));
    }
    
    /**
     * Tests the getPercentage method
     */
    public void testGetPercentage()
    {
        double[] results = list.getPercentage();
        assertEquals(66, results[0], 1);
    }
    
    /**
     * Tests the getPercentageByHobby method.
     */
    public void testGetPercentageByHobby()
    {
        //TODO
        double[] results = list.getPercentageByHobby();
        for (int count = 0; count < results.length; count++)
        {
            System.out.println(results[count]);
        }
    }
    
    /**
     * Tests the sortBySongTitle method.
     */
    public void testSortBySongTitle()
    {
        //TODO
    }
    
    /**
     * Tests the sortByGenre method.
     */
    public void testSortByGenre()
    {
        //TODO
    }
    
    /**
     * Tests the sortByYear method.
     */
    public void testSortByYear()
    {
        //TODO
    }
    
    /**
     * Tests the sortByArtistName method.
     */
    public void testSortByArtistName()
    {
        //TODO
    }
    
    
}
