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
     * 
     * @param answers
     */
    public void setAnswers(List<String> answers)
    {
        this.answers = answers;
    }
    
    public String getHobby()
    {
        return hobby;
    }
    
    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }
    
    public void setmajor(String major)
    {
        this.major = major;
    }
    
    public void setstate(String state)
    {
        this.state = state;
    }
    
    public void setdate(String date)
    {
        this.date = date;
    }
    
    
}
