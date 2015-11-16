package group87;
import student.TestCase;
/**
 * Tests the person class.
 * @author Larissa Schneider (larissa6), Simone Stewart (simone5), Tara Amruthur (taraa2)
 * @version 2015.11.13
 *
 */
public class PersonTest extends TestCase
{
    private DoublyLinkedList<String> answers;
    private String hobby;
    private String major;
    private String state;
    private String date;
    private Person person;
    
    /**
     * Sets up.
     */
    public void setUp()
    {
        answers = new DoublyLinkedList<String>();
        answers.add("Yes");
        answers.add("No");
        answers.add("Yes");
        hobby = "music";
        major = "Computer Science";
        state = "Southeast";
        date = "10/19/15";
        person = new Person(hobby, major, state, date, answers);
    }
    
    /**
     * Tests the getAnswers method.
     */
    public void testGetAnswers()
    {
        assertTrue(answers.equals(person.getAnswers()));
    }
    
    /**
     * Tests the getHobby method.
     */
    public void testGetHobby()
    {
        assertTrue(hobby.equals(person.getHobby()));
    }
    
    /**
     * Tests the getMajor method.
     */
    public void testGetMajor()
    {
        assertTrue(major.equals(person.getMajor()));
    }
    
    /**
     * Tests the getState method.
     */
    public void testGetState()
    {
        assertTrue(state.equals(person.getState()));
    }
    
    /**
     * Tests the getDate method.
     */
    public void testGetDate()
    {
        assertTrue(date.equals(person.getDate()));
    }
}
