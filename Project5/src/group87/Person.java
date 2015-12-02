package group87;

/**
 * An average person with survey results
 * @author Larissa Schneider (larissa6)
 * @version 2015.11.13
 */
public class Person
{
    private DoublyLinkedList<String> answers;
    private String hobby;
    private String major;
    private String state;
    private String date;

    /**
     * Creates a person with survey results.
     * WILL BE DELETED LATER
     * @param answers The survey results.
     */
    public Person(String hobby, String major, String state, String date,
        DoublyLinkedList<String> answers)
    {
        this.answers = answers;
        this.hobby = hobby;
        this.major = major;
        this.state = state;
        this.date = date;
    }
    
    /**
     * Creates a person with survey results.
     * @param hobby The person's hobby.
     * @param major The person's major.
     * @param state The person's state.
     * @param answers The person's results
     */
    public Person(String hobby, String major, String state, DoublyLinkedList<String> answers)
    {
        this.answers = answers;
        this.hobby = hobby;
        this.major = major;
    }

    /**
     * Gets a person's survey results.
     * @return The results.
     */
    public DoublyLinkedList<String> getAnswers()
    {
        return answers;
    }

    /**
     * Gets a person's hobby.
     * @return The hobby.
     */
    public String getHobby()
    {
        return hobby;
    }

    /**
     * Gets a person's major.
     * @return The major.
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * Gets a person's state.
     * @return The state.
     */
    public String getState()
    {
        return state;
    }

    /**
     * Gets a person's date.
     * @return The date.
     */
    public String getDate()
    {
        return date;
    }
}
