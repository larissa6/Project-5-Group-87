package group87;
import java.util.List;

/**
 * An average person with survey results
 * @author Larissa Schneider (larissa6)
 * @version 2015.11.13
 */
public class Person 
{
    private List<String> answers;
    private String hobby;
    private String major;
    private String state;
    private String date;
    
    /**
     * Creates a person with survey results.
     * @param answers The survey results.
     */
    public Person(List<String> answers)
    {
        this.answers = answers;
    }
    
    /**
     * Gets a person's survey results.
     * @return The results.
     */
    public List<String> getAnswers()
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
    
    /**
     * Sets a person's date.
     * @param date The date to be set.
     */
    public void setDate(String date)
    {
        this.date = date;
    }

}
